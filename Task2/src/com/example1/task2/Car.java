package com.example1.task2;

public class Car implements Vehicle {

    private DatabaseOperations databaseOperations;
    private String brand;

    public void setDatabaseOperations(DatabaseOperations databaseOperations) {
        this.databaseOperations = databaseOperations;
    }
    @Override
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public void saveToDatabase(Vehicle vehicle) {
        databaseOperations.save(vehicle);
    }
}

