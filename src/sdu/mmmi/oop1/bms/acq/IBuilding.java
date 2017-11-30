/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdu.mmmi.oop1.bms.acq;

import java.util.List;
import java.util.UUID;
import sdu.mmmi.oop1.bms.business.Sensor;

/**
 *
 * @author dbj
 */
public interface IBuilding {
    UUID getId();
    List<Sensor> getSensors();
    void addSensor(ISensor s);
    IMeasurement getMeasurement(UUID sensorId);
    String getName();
    String getAddress();
}
