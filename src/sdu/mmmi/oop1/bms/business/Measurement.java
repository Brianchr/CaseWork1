/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdu.mmmi.oop1.bms.business;

import java.util.Date;
import java.util.UUID;
import sdu.mmmi.oop1.bms.acq.IMeasurement;

/**
 *
 * @author dbj
 */
public class Measurement implements IMeasurement, Comparable<IMeasurement> {
    private Date time;
    private double value;
    private UUID sensorId;
    
    public Measurement(Date time, double value, UUID sensorId)
    {
        this.time = time;
        this.value = value;
        this.sensorId = sensorId;
    }

    @Override
    public int compareTo(IMeasurement o) {
        return getTime().compareTo(o.getTime());
    }

    @Override
    public Date getTime() {
        return time;
    }

    @Override
    public double getValue() {
        return value;
    }
    
    @Override
    public UUID getSensorId() {
        return sensorId;
    }
    
    @Override
    public String toString()
    {
        return "Sensor " + sensorId + " Value: " + value + " at " + time.getTime();
    }
}