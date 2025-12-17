package com.example1;

public class CircleShape implements Shape {
    private double radius = 3;

    @Override
    public double getArea() {
        return 2 * Math.PI * radius;
    }
}
