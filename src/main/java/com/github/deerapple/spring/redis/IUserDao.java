/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.deerapple.spring.redis;

/**
 *增删改查接口
 * @author SONY
 */
public interface IUserDao {
    User get(String id);
    boolean add(User user);
    void delete(String key);
    void update(User user);
}
