package com.vehiclesSystem.models;

import com.vehiclesSystem.dao.DatabaseOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Car implements Vehicle {
    private int id;
    private String model;
    private Type type;
    private final DatabaseOperations db;

    @Autowired
    public Car(DatabaseOperations db) {
        this.type = Type.CAR;
        this.db = db;
    }

    public int getId() {
        return this.id;
    }

    public String getModel() {
        return this.model;
    }

    public Type getType() {
        return this.type;
    }

    public DatabaseOperations getDb() {
        return this.db;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String toString() {
        return "Car(id=" + this.getId() + ", model=" + this.getModel() + ", type=" + this.getType() + ", db=" + this.getDb() + ")";
    }
}
