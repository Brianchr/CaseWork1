/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdu.mmmi.oop1.bms.business;

import sdu.mmmi.oop1.bms.acq.IBuildingManagementSystem;
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
public class BuildingManagementSystemImpl implements IBuildingManagementSystem {

    private Map<UUID, IBuilding> buildings = new HashMap<>();
    private List<IMeasurement> measurements = new ArrayList<>();

    @Override
    public void addBuilding(String name, String address) {
        IBuilding b = new Building(name, address);
        buildings.put(b.getId(), b);
    }

    @Override
    public void removeBuilding(UUID id) {
        buildings.remove(id);
    }

    @Override
    public List<IBuilding> getBuildings() {
        return new ArrayList<>(buildings.values());
    }

    @Override
    public UUID addTemperatureSensor(UUID building, String name) {
        ISensor temperatureSensor = new TemperatureSensor(name);
        buildings.get(building).addSensor(temperatureSensor);
        return temperatureSensor.getId();
    }

    @Override
    public UUID addCo2Sensor(UUID building, String name) {
        ISensor co2Sensor = new Co2Sensor(name);
        buildings.get(building).addSensor(co2Sensor);
        return co2Sensor.getId();
    }

    @Override
    public void makeMeasurement(UUID buildingId, UUID sensorId) {
        measurements.add(buildings.get(buildingId).getMeasurement(sensorId));
    }

    @Override
    public List<IMeasurement> getMeasurements(Date start, Date end, UUID sensorId) {
        List<IMeasurement> measurementPeriod = new ArrayList<>();

        for (IMeasurement m : measurements) {
            if (m.getSensorId().equals(sensorId) && m.getTime().after(start) && m.getTime().before(end)) {
                measurementPeriod.add(m);    
            }
        }
        
        return measurementPeriod;
    }

}
