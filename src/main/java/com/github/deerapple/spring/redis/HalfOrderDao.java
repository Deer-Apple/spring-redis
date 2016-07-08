/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.deerapple.spring.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author SONY
 */
@Component
public class HalfOrderDao implements IHalfOrderDao {
    
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public void GetIn(String id, String station) {
        redisTemplate.opsForValue().set(id, station, 3600*1000*3);
        
    }

    @Override
    public String GetOut(String id) {
        String stationTemp;
        stationTemp = redisTemplate.opsForValue().get(id);
        return stationTemp;
    }

    @Override
    public void ClearAfterOut(String id) {
        redisTemplate.delete(id);
    }
    
}
