package com.myApp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "products")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int product_id;
    private String name;
    private  String description;
    private  String manufacturer;
    private  double price;
    @Column(name = "stock_quantity", nullable = false)
    private Integer stockQuantity;

    @Column(name = "production_date")
    private LocalDate productionDate;
    @OneToMany(mappedBy = "product")
    private List<OrderIteams> orderItems;



    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", stockQuantity=" + stockQuantity +
                ", productionDate=" + productionDate +
                '}';
    }

    public Product(String description, String name, String manufacturer, double price, Integer stockQuantity, List<OrderIteams> orderItems, LocalDate productionDate) {
        this.description = description;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.orderItems = orderItems;
        this.productionDate = productionDate;
    }
}
