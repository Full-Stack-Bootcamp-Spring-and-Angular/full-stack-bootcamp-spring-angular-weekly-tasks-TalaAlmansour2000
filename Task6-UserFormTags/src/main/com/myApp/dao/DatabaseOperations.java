package main.com.myApp.dao;

import main.com.myApp.models.UserModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
    public void init() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(url, username, password);
    }

    @PreDestroy
    public void close() throws SQLException {
        if (connection != null && !connection.isClosed()) connection.close();
    }


    public void save(UserModel user) throws SQLException {
        String sql = "INSERT INTO users (user_name, password, country, program_lang) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, user.getUserName());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getCountry());
        ps.setString(4, user.getProgramLang());
        ps.executeUpdate();
        ps.close();
    }
}
