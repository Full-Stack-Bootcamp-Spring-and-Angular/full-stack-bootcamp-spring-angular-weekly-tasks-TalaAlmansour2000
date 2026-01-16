package com.task5.userprofile.dao;

import com.task5.userprofile.models.User;

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
    public void register(User user) throws SQLException {
        String INSERT_USERS_toSQL = "INSERT INTO users (first_name, last_name, email, dob, city) VALUES (?, ?, ?, ?, ?);";

        PreparedStatement preparedStatement = this.connection.prepareStatement(INSERT_USERS_toSQL);


            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setDate(4, java.sql.Date.valueOf(user.getDate()));
            preparedStatement.setString(5, user.getCity());
            preparedStatement.executeUpdate();
        preparedStatement.close();


    }}

