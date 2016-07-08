/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.deerapple.spring.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author SONY
 */
@RestController
public class HalfOrderController {
    
    @Autowired
    private IHalfOrderDao hod;
    
    @RequestMapping(value = "/in", method = RequestMethod.GET)
    public String handleIn(@RequestParam("id") String id, @RequestParam("station") String station){
//        System.out.println(id + "........." + station);
        hod.GetIn(id, station);
        return id + "........." + station;
    }
    
    @RequestMapping(value = "/out", method = RequestMethod.GET)
    public String handleOut(@RequestParam("id") String id, @RequestParam("station") String station){
        String temp = hod.GetOut(id);
//        System.out.println(id + "...." + temp + "...to..." + station);
        hod.ClearAfterOut(id);
        return id + "...." + temp + "...to..." + station;
    }
}
