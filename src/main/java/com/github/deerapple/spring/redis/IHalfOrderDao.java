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
public interface IHalfOrderDao {
    void GetIn(String id, String station);
    String GetOut(String id);
    void ClearAfterOut(String id);
}
