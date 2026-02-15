package com.vehiclesSystem;
import com.vehiclesSystem.config.Config;
import com.vehiclesSystem.controller.CarController;
import com.vehiclesSystem.dao.DatabaseOperations;
import com.vehiclesSystem.models.Car;
import com.vehiclesSystem.models.Plane;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(new Class[]{Config.class});
        CarController controller = (CarController)context.getBean(CarController.class);
        DatabaseOperations dbOps = (DatabaseOperations)context.getBean(DatabaseOperations.class);
        Car myCar = (Car)context.getBean(Car.class);
        myCar.setId(3);
        myCar.setModel("Toyota");
        Plane myPlane = (Plane)context.getBean(Plane.class);
        myPlane.setId(4);
        myPlane.setModel("Boeing 747");
        controller.saveVehicle(myCar);
        controller.saveVehicle(myPlane);
        dbOps.getAllVehicles();
        context.close();
    }
}
