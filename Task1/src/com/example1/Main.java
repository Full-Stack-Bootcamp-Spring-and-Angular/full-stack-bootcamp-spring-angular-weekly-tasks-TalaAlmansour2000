package com.example1;

import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("application-context.xml");


        Shape circle = context.getBean("circle", Shape.class);
        Shape square = context.getBean("square", Shape.class);


        System.out.println("the area of the circle = " + circle.getArea());
        System.out.println("the area of the Square = " + square.getArea());


        context.close();
    }
}