package com.tala.productMangment.repository;

import com.tala.productMangment.enums.Manufacturer;
import com.tala.productMangment.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p " +
            "WHERE p.productDetails.manufacturer = :manufacturer " +
            "AND p.productDetails.expirationDate < CURRENT_DATE")
    List<Product> findExpiredByName(@Param("manufacturer") Manufacturer manufacturer);
}
