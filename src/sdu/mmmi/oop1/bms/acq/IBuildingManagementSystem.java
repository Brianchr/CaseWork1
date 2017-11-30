/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdu.mmmi.oop1.bms.acq;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import sdu.mmmi.oop1.bms.business.Building;
import sdu.mmmi.oop1.bms.business.Measurement;

/**
 *
 * @author dbj
 */
public interface IBuildingManagementSystem {
    void addBuilding(String name, String address);
    void removeBuilding(UUID b);
    
    UUID addTemperatureSensor(UUID building, String name);
    UUID addCo2Sensor(UUID building, String name);
     
    List<IBuilding> getBuildings();
    
    public void makeMeasurement(UUID buildingId, UUID sensorId);
    
    public List<IMeasurement> getMeasurements(Date start, Date end, UUID sensorId);
    
}
