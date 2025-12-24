package com.example1;

public class SquareShape implements Shape{

    private double side = 3;

    @Override
    public double getArea() {
        return side * side;
    }
}
