package com.example1.task2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext springContainer =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Plane planeBean = springContainer.getBean("planeBean", Plane.class);
        planeBean.setBrand("Boeing");

        System.out.println(String.format("Registering brand: %s in the database", planeBean.getBrand()));
        planeBean.saveToDatabase(planeBean);
        Car carBean = springContainer.getBean("carBean", Car.class);
        carBean.setBrand("BMW");
        System.out.println(String.format("Registering brand: %s in the database", carBean.getBrand()));
        carBean.saveToDatabase(carBean);
    }
}
