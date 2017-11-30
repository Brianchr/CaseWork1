/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdu.mmmi.oop1.bms.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import sdu.mmmi.oop1.bms.acq.IBuilding;
import sdu.mmmi.oop1.bms.acq.IMeasurement;
import sdu.mmmi.oop1.bms.acq.ISensor;

/**
 *
 * @author dbj
 */
public class Building implements IBuilding {
    
    private Map<UUID, ISensor> sensors;
    private String name;
    private String address;
    private UUID id;
    
    public Building(String name, String address)
    {
        this.name = name;
        this.address = address;
        this.id = UUID.randomUUID();
        this.sensors = new HashMap<>();
    }

    @Override
    public String getName() {
	return name;
    }

    @Override
    public String getAddress() {
	return address;
    }
    
    @Override
    public void addSensor(ISensor s)
    {
        this.sensors.put(s.getId(),s);
    }
    
    @Override
    public List<Sensor> getSensors()
    {
        return new ArrayList(sensors.values());
    }
    
    @Override
    public UUID getId()
    {
        return id;
    }
    
    @Override
    public IMeasurement getMeasurement(UUID sensorId)
    {
        double value = sensors.get(sensorId).getCurrentValue();
        return new Measurement(new Date(), value, sensorId);
    }
}
