package main.com.myApp.dao;
import main.com.myApp.model.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import java.sql.*;
@Lazy
@Component
@Scope("singleton")
public class DatabaseOperations {



    @Value("${db.url}")
    private String url;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;
    private Connection connection;


    @PostConstruct


    public void init() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        this.connection = DriverManager.getConnection(this.url, this.username, this.password);

    }
    @PreDestroy
    public void destroy() {
        try {
            if (this.connection != null && !this.connection.isClosed()) {
                this.connection.close();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void register(Employee employee) throws SQLException {

        String INSERT_EMPLOYEES_toSQL = "INSERT INTO employees (name, email, password) VALUES (?, ?, ?);";
        PreparedStatement preparedStatement = this.connection.prepareStatement(INSERT_EMPLOYEES_toSQL);

        preparedStatement.setString(1, employee.getName());
        preparedStatement.setString(2, employee.getEmail());
        preparedStatement.setString(3, employee.getPassword());


        preparedStatement.executeUpdate();
        preparedStatement.close();


    }}

