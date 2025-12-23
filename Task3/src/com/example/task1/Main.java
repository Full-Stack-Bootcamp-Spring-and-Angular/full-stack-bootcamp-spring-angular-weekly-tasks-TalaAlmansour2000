package com.example.task1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext container =
                new ClassPathXmlApplicationContext("applicationContext-task1.xml");
        Shape circle = container.getBean("circle", Shape.class);
        circle.drawShape2d();
        circle.drawShape3d();

        Shape square = container.getBean("square", Shape.class);
        square.drawShape2d();
        square.drawShape3d();


    }
}
