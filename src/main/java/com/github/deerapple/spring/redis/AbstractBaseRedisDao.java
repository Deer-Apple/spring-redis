/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.deerapple.spring.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 *
 * @author SONY
 * @param <K>
 * @param <V>
 */
public abstract class AbstractBaseRedisDao<K, V> {  
      
    @Autowired  
    protected RedisTemplate<K, V> redisTemplate;   
      
    /** 
     * 获取 RedisSerializer 
     * @return 
     */  
    protected RedisSerializer<String> getRedisSerializer() {  
        return redisTemplate.getStringSerializer();  
    }  
}  
