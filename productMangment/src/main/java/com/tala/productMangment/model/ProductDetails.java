package com.tala.productMangment.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tala.productMangment.enums.Manufacturer;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "Product_details")

public class ProductDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "expiration_Date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate expirationDate;

    @Enumerated(EnumType.STRING)

    private Manufacturer manufacturer;
    @DecimalMin(value = "0.0")
    @NotNull
    @Positive
    private Double price;
    private boolean availability;

    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @JsonIgnore
    private Product product;

    @Override
    public String toString() {
        return "ProductDetails{" +
                "id=" + id +
                ", expirationDate=" + expirationDate +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", availability=" + availability + '\'' +
                '}';
    }

    public boolean isExpired() {
        if (expirationDate == null) return false;
        return expirationDate.isBefore(LocalDate.now());
    }
}
