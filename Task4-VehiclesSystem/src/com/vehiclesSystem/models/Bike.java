package com.vehiclesSystem.models;

import com.vehiclesSystem.dao.DatabaseOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Bike implements Vehicle {
    private int id;
    private String model;
    private Type type;
    @Autowired
    private DatabaseOperations db;

    public Bike() {
        this.type = Type.BIKE;
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

    public void setDb(DatabaseOperations db) {
        this.db = db;
    }

    public String toString() {
        return "Bike(id=" + this.getId() + ", model=" + this.getModel() + ", type=" + this.getType() + ", db=" + this.getDb() + ")";
    }
}
