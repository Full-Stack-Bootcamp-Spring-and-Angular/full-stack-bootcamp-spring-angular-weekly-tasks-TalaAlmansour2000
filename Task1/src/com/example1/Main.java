package com.example1;

import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("application-context.xml");


        Shape circle = context.getBean("circle", Shape.class);
        Shape square = context.getBean("square", Shape.class);
        System.out.println(String.format("the area of the circle = %f", circle.getArea()));
        System.out.println(String.format("the area of the Square = %f", square.getArea()));

        context.close();
    }
}