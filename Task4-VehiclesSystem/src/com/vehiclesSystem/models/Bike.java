package com.vehiclesSystem.models;

import com.vehiclesSystem.dao.DatabaseOperations;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Getter
@Setter

public class Bike implements Vehicle {
    private int id;
    private String model;
    private Type type;
    @Autowired
    private DatabaseOperations db;

    public Bike() {
        this.type = Type.BIKE;
    }


}
