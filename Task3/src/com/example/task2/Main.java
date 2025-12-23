package com.example.task2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext springContainer =
                new ClassPathXmlApplicationContext("applicationContext-task2.xml");

        DatabaseOperations db = springContainer.getBean("init-destroy", DatabaseOperations.class);

        springContainer.close();



    }
}
