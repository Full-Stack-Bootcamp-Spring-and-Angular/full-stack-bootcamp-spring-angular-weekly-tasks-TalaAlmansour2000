package com.vehiclesSystem.controller;

import com.vehiclesSystem.dao.DatabaseOperations;
import com.vehiclesSystem.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarController implements VehicleController {
    @Autowired
    private DatabaseOperations databaseOperations;

    public void saveVehicle(Vehicle vehicle) {
        this.databaseOperations.save(vehicle);
    }
}
