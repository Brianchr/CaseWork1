/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdu.mmmi.oop1.bms.business;

import java.util.Random;

/**
 *
 * @author dbj
 */
public class Co2Sensor extends Sensor {

    Random R = new Random();

    public Co2Sensor(String name) {
        super(name, "ppm^2");
    }
    
    @Override
    public double getCurrentValue() {
        return R.nextDouble() * 1200;
    }
    
}
