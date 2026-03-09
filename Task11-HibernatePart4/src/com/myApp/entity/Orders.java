package com.myApp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "User_orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int id;
    private LocalDate orderDate;
    private Double totalPrice = 0.0;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy ="order",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<OrderIteams> orderIteams;
    @Override
    public String toString() {
        return "Order Details: [" +
                "ID: " + id +
                ", Date: " + orderDate +
                ", Total Price: " + totalPrice + " $ " +
                "]";
    }

}

