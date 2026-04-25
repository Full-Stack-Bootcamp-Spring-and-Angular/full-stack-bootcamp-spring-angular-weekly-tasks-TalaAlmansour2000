package com.myApp.entitiy;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "products")
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int id;
    @Column(name = "name", nullable = false)
    @NotNull(message = "Name cannot be null")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price", nullable = false)
    @Min(value = 0)
    private double price;
    @NotNull(message = "Stock quantity is required")
    @Column(name = "stock_quantity", nullable = false)
    private int stockQuantity;
    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "production_date")
    private LocalDate productionDate;
    @Transient
    private double totalValue;

    public double getTotalValue() {
        return this.price * this.stockQuantity;
    }


    public Product() {
    }


}