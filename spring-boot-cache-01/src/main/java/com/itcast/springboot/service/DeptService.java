package com.itcast.springboot.service;

import com.itcast.springboot.bean.Department;
import com.itcast.springboot.mapper.DepartmentMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;

@Service
//@CacheConfig(cacheNames = "dept",cacheManager = "deptCacheManager")
public class DeptService {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Qualifier("deptCacheManager")
    @Autowired
    RedisCacheManager deptCacheManager;
    //日志记录器
    Logger log = LoggerFactory.getLogger(getClass());
//注解
//    @Cacheable(value = "dept",cacheManager = "deptCacheManager")
//    public Department getDeptById(Integer id){
//        log.info("[执行由id查询部门]id={}",id);
//        Department dept = departmentMapper.getDeptById(id);
//        return dept;
//    }
//编码
        public Department getDeptById(Integer id){
            log.info("[执行由id查询部门]id={}",id);
            Department dept = departmentMapper.getDeptById(id);
            //获取某个缓存
            Cache cache = deptCacheManager.getCache("dept");
            cache.put("dept1",dept);
            return dept;
    }
}
