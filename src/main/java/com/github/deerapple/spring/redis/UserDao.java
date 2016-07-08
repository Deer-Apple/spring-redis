/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.deerapple.spring.redis;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 *
 * @author SONY
 */
public class UserDao extends AbstractBaseRedisDao<String, User> implements IUserDao {

    @Override
    public User get(final String id) {
        User result = redisTemplate.execute(new RedisCallback<User>() {

            @Override
            public User doInRedis(RedisConnection rc) throws DataAccessException {
                RedisSerializer<String> serializer = getRedisSerializer();
                byte[] key = serializer.serialize(id);  
                byte[] value = rc.get(key);  
                if (value == null) {  
                    return null;  
                }  
                String name = serializer.deserialize(value); 
                return new User(id, name);
            }
        });
        return result;
    }

    @Override
    public boolean add(final User user) {
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {

            @Override
            public Boolean doInRedis(RedisConnection rc) throws DataAccessException {
                RedisSerializer<String> serializer = getRedisSerializer();
                byte[] key  = serializer.serialize(user.getId());  
                byte[] name = serializer.serialize(user.getKey());  
                return rc.setNX(key, name);
            }
        });
        return result;
    }

    @Override
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    @Override
    public void update(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
