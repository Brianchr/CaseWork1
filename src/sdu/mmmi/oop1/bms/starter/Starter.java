/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdu.mmmi.oop1.bms.starter;

import sdu.mmmi.oop1.bms.acq.IBuildingManagementSystem;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import sdu.mmmi.oop1.bms.acq.IBuilding;
import sdu.mmmi.oop1.bms.acq.IMeasurement;
import sdu.mmmi.oop1.bms.business.BuildingManagementSystemImpl;
import sdu.mmmi.oop1.bms.business.Sensor;

/**
 *
 * @author dbj
 */
public class Starter {

    public static void main(String[] args) {
        
        Date start = new Date();
        //Wait 1000 ms (1 sekund) in order to create gap
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Starter.class.getName()).log(Level.SEVERE, null, ex);
        }
        IBuildingManagementSystem bms = new BuildingManagementSystemImpl();
        bms.addBuilding("OU44", "Campusvej 55");
        bms.addBuilding("OU42/43", "Campusvej 55");

        List<IBuilding> buildings = bms.getBuildings();

        Random R = new Random();
        for (IBuilding b : buildings) {
            int numSensors = R.nextInt(10);
            for (int i = 0; i < numSensors; i++) {
                if (i % 2 == 0) {
                    bms.addTemperatureSensor(b.getId(), "Temperature sensor " + i);
                } else {
                    bms.addCo2Sensor(b.getId(), "CO2 sensor " + i);
                }
            }
        }

        for (IBuilding b : buildings) {
            for (Sensor s : b.getSensors()) {
                for (int i = 0; i < 100; i++) {
                    bms.makeMeasurement(b.getId(), s.getId());
                }
            }
        }
        
        //Wait 1000 ms (1 sekund) in order to create gap
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Starter.class.getName()).log(Level.SEVERE, null, ex);
        }
        Date end = new Date();
        for (IBuilding b : buildings) {
            for (Sensor s : b.getSensors()) {
                List<IMeasurement> measurements = bms.getMeasurements(start, end, s.getId());
                System.out.println(b.getName() + "\t" + measurements);
            }
        }
    }
}
