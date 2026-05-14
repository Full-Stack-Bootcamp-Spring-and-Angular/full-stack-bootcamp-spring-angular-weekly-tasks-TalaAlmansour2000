package com.myApp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Order_Iteams")
public class OrderIteams {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iteam_id")
    private int id;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders order;
    @ManyToOne
    @JoinColumn(name="product_id")
    private  Product product ;
}
