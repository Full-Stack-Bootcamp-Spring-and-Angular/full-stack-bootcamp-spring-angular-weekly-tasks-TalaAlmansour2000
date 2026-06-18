package com.myApp.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Email
    private String email;
    private String username;
    private String password;
    @OneToMany(mappedBy = "user", cascade=CascadeType.ALL)
    private List<Orders> orders;

    public User(String password, String email, String username, List<Orders> orders) {
        this.password = password;
        this.email = email;
        this.username = username;
        this.orders = orders;

    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +


                '}';
    }
}
