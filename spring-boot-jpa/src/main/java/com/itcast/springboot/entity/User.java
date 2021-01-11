package com.itcast.springboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.itcast.springboot.enums.SexEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

//使用JPA注解配置映射关系
@Entity  //告诉jpa这是一个实体类（和数据表映射的类）
@Table(name = "tbl_user") //来指定和那个数据表对应；如果省略，表名默认user
public class User {
    @Id //这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增主键   AUTO、INDENTITY、SEQUENCE 和 TABLE 4 种
    private Integer id;
    @Column(name = "last_name",length = 50,nullable = false,unique=true,columnDefinition="varchar(50) comment '用户名称'") //这是数据库一列 nullable(是否允许为空)  unique(是否唯一)
    private String lastName;
    @Column(name = "email",length = 30,columnDefinition="varchar(30) comment '电子邮件'") //省略，默认列名就是属性名
    private String email;
    @Transient //表示该属性并非一个到数据库表的字段映射
    private String phone;
    @Enumerated(EnumType.ORDINAL) //使用枚举的时候，我们希望数据库存储枚举对应的String值或枚举的索引值 ORDINAL  STRING
    @Column(name = "sex",columnDefinition="tinyint comment '性别'")
    private SexEnum sex;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "birthday",columnDefinition="date comment '出生日期'")
    private Date birthday;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                '}';
    }
}
