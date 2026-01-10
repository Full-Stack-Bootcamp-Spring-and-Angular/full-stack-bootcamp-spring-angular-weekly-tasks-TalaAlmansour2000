package com.vehiclesSystem.models;

import com.vehiclesSystem.dao.DatabaseOperations;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Getter@Setter
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


}
