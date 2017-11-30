/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdu.mmmi.oop1.bms.acq;

import java.util.UUID;

/**
 *
 * @author dbj
 */
public interface ISensor {
    String getName();
    String getUnit();
    UUID getId();
    double getCurrentValue();
}
