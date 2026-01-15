package com.vehiclesSystem.dao;
import com.vehiclesSystem.models.Vehicle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

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
    public void init() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(this.url, this.username, this.password);
            System.out.println("Connection Established.");
        } catch (Exception e) {
            System.err.println("Connection Failed: " + e.getMessage());
        }

    }

    @PreDestroy
    public void destroy() {
        try {
            if (this.connection != null && !this.connection.isClosed()) {
                this.connection.close();
                System.out.println("Connection Closed: Database disconnected.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void save(Vehicle vehicle) {
        String sql = "INSERT INTO vehicles (id, model, type) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setInt(1, vehicle.getId());
            stmt.setString(2, vehicle.getModel());
            stmt.setString(3, vehicle.getType().name().toUpperCase());
            stmt.executeUpdate();
            System.out.println(String.format(" Vehicle Saved: ID=%d | Model=%s | Type=%s", vehicle.getId(), vehicle.getModel(), vehicle.getType().name()));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void delete(int id) {
        String sql = "DELETE FROM vehicles WHERE id = ?";

        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println(String.format(" Vehicle Deleted: ID=%d", id));
            } else {
                System.out.println(String.format("Vehicle ID %d not found", id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void update(Vehicle vehicle) {
        String sql = "UPDATE vehicles SET model = ?, type = ? WHERE id = ?";

        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setString(1, vehicle.getModel());
            stmt.setString(2, vehicle.getType().name().toUpperCase());
            stmt.setInt(3, vehicle.getId());
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println(String.format(" Vehicle Updated: ID=%d | Model=%s | Type=%s", vehicle.getId(), vehicle.getModel(), vehicle.getType().name()));
            } else {
                System.out.println(String.format(" Vehicle ID %d not found", vehicle.getId()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void searchById(int id) {
        String sql = "SELECT * FROM vehicles WHERE id = ?";

        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println(String.format(" Found Vehicle -> ID: %d | Model: %s | Type: %s", rs.getInt("id"), rs.getString("model"), rs.getString("type")));
            } else {
                System.out.println(String.format("Vehicle ID %d not found", id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void getAllVehicles() {

            String sql = "SELECT * FROM vehicles";

            try (Statement stmt = this.connection.createStatement()) {
                ResultSet rs = stmt.executeQuery(sql);


                    while(rs.next()) {
                        System.out.println(String.format("ID: %d | Model: %s | Type: %s", rs.getInt("id"), rs.getString("model"), rs.getString("type")));}
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
