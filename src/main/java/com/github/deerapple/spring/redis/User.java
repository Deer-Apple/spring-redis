/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.deerapple.spring.redis;

import java.io.Serializable;

/**
 *
 * @author SONY
 */
public class User implements Serializable {
    
    private String id;
    private String key;
    
    public User(){
        
    }
    
    public User(String id, String key){
        this.id = id;
        this.key = key;
    }
    
    public String getId(){
        return id;
    }
    
    public String getKey(){
        return key;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    public void setKey(String key){
        this.key = key;
    }
}
