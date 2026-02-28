package com.myApp.entitiy;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;


    public User() {}

    @Override
    public String toString() {
        return "User{" +
                ", password='****'" + '\'' +
                ", username='" + username + '\'' +
                ", id=" + id +
                '}';
    }
}