package com.hss.export;

import com.hss.domain.User;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserExportEntity {

    public static ResponseEntity<byte []> exportUserExcel(List<User> userList){
        HttpHeaders headers = null;
        ByteArrayOutputStream baos = null;

        try {
            //1.创建Excel文档
            HSSFWorkbook workbook = new HSSFWorkbook();
            //2.创建文档摘要
            workbook.createInformationProperties();
            //3.获取文档信息，并配置
            DocumentSummaryInformation dsi = workbook.getDocumentSummaryInformation();
            //3.1文档类别
            dsi.setCategory("员工信息");
            //3.2设置文档管理员
            dsi.setManager("hss");
            //3.3设置组织机构
            dsi.setCompany("何氏集团");
            //4.获取摘要信息并配置
            SummaryInformation si = workbook.getSummaryInformation();
            //4.1设置文档主题
            si.setSubject("用户信息表");
            //4.2设置文档标题
            si.setTitle("用户信息");
            //4.3设置文档作者
            si.setAuthor("何氏集团");
            //4.4设置文档备注
            si.setComments("备注信息暂无");
            //创建excel表单
            HSSFSheet sheet = workbook.createSheet("何氏集团用户信息表");
            //创建日期显示格式
            HSSFCellStyle dataCellStyle = workbook.createCellStyle();
            dataCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
            //创建标题的显示样式
            HSSFCellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFillBackgroundColor(IndexedColors.YELLOW.index);
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            //定义列的宽度
            sheet.setColumnWidth(0,5 * 256);
            sheet.setColumnWidth(1,12 * 256);
            sheet.setColumnWidth(2,20 * 256);
            //5.设置表头
            HSSFRow headerRow = sheet.createRow(0);
            HSSFCell cell0 = headerRow.createCell(0);
            cell0.setCellValue("编号");
            HSSFCell cell1 = headerRow.createCell(1);
            cell1.setCellValue("姓名");
            HSSFCell cell2 = headerRow.createCell(2);
            cell2.setCellValue("出生日期");
            //6.装入数据
            for(int i = 0; i < userList.size(); i++){
                HSSFRow row = sheet.createRow(i + 1);
                User user = userList.get(i);
                row.createCell(0).setCellValue(user.getId());
                row.createCell(1).setCellValue(user.getName());
                //日期格式  赋值  格式
                HSSFCell birthdayCell = row.createCell(2);
                birthdayCell.setCellValue(user.getBirthday());
                birthdayCell.setCellStyle(dataCellStyle);
            }
            headers = new HttpHeaders();
            headers.setContentDispositionFormData("attachment",
                    new String("用户表.xls".getBytes("UTF-8"),"iso-8859-1"));
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            baos = new ByteArrayOutputStream();
            workbook.write(baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<byte []>(baos.toByteArray(),headers,HttpStatus.CREATED);
    }

    public static List<User> importUserList(MultipartFile file){
        List<User> userList = new ArrayList<>();
        try {
            HSSFWorkbook workbook = new HSSFWorkbook(new POIFSFileSystem(file.getInputStream()));
            int numberOfSheets = workbook.getNumberOfSheets();
            for(int i = 0; i < numberOfSheets; i++){
                HSSFSheet sheet = workbook.getSheetAt(i);
                int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
                User user;
                for(int j = 0; j < physicalNumberOfRows; j++){
                    if(j == 0){
                        continue;//标题行
                    }
                    HSSFRow row = sheet.getRow(j);
                    if(row == null){
                        continue;//没数据
                    }
                    int physicalNumberOfCells = row.getPhysicalNumberOfCells();
                    user = new User();
                    for(int k = 0; k < physicalNumberOfCells; k++){
                        HSSFCell cell = row.getCell(k);
                        //字符类型
                        if(cell.getCellType().equals(CellType.STRING)){
                            String cellValue = cell.getStringCellValue();
                            if(cellValue == null){
                                cellValue = "";
                            }
                            switch (k){
                                case 1:
                                    user.setName(cellValue);
                                    break;
                            }
                        }else{//其他类型
                            switch (k){
                                case 0:
                                    user.setId(new Double(cell.getNumericCellValue()).longValue());
                                    break;
                                case 2:
                                    user.setBirthday(cell.getDateCellValue());
                            }
                        }
                    }
                    userList.add(user);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userList;
    }
}
