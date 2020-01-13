package com.itcast.springboot.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@CacheConfig(cacheNames = "object",cacheManager = "objectCacheManager")
public class ObjectService {

    @Cacheable
    public Map<Object,Object> getObject(Integer id){
        Map<Object,Object> map = new HashMap<>();
        map.put("1","一");
        map.put("2","二");
        map.put("3","三");
        return map;
    }
}
