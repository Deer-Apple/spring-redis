/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.deerapple.spring.redis;

/**
 *
 * @author SONY
 */
public class HalfOrder {
    
    private String id;
    private String station;
    
    public HalfOrder(){
        
    }
    
    public HalfOrder(String id, String station){
        this.id = id;
        this.station = station;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    public void setStation(String station){
        this.station = station;
    }
    
    public String getId(){
        return this.id;
    }
    
    public String getStation(){
        return this.station;
    }
}
