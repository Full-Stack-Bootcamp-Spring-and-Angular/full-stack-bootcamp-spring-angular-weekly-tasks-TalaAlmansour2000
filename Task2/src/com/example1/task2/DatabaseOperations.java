package com.example1.task2;

public class DatabaseOperations {

    private String url;
    private String username;
    private String password;

    public DatabaseOperations()
    {}

    public void setUrl(String url) {
        this.url = url;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public void save(Vehicle vehicle) {
        System.out.println("connecting to database with properties");
        System.out.println(String.format("%s %s %s", url, username, password));
        System.out.println(String.format("--------------%s saved to database------------------", vehicle.getBrand()));
    }

}
