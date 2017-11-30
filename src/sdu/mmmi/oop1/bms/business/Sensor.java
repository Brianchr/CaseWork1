/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdu.mmmi.oop1.bms.business;

import java.util.UUID;
import sdu.mmmi.oop1.bms.acq.ISensor;

/**
 *
 * @author dbj
 */
public abstract class Sensor implements ISensor {
    private String name;
    private String unit;
    private UUID id;
    
    public Sensor(String name, String unit)
    {
        this.name = name;
        this.unit = unit;
        this.id = UUID.randomUUID();
    }
    
    @Override
    public String getName()
    {
        return name;
    }
    
    @Override
    public String getUnit()
    {
        return unit;
    }
    
    @Override
    public UUID getId() {
        return id;
    }
}
