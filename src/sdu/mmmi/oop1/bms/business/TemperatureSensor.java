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
public class TemperatureSensor extends Sensor {

    Random R = new Random();

    public TemperatureSensor(String name) {
        super(name, "°C");
    }
    
    @Override
    public double getCurrentValue() {
        return 10 + R.nextDouble() * 40;
    }
    
}
