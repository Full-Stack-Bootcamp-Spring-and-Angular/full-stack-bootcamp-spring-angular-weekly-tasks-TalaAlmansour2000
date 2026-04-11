package com.tala.productMangment.service;

import com.tala.productMangment.enums.Manufacturer;
import com.tala.productMangment.model.Product;

import java.util.List;

public interface ProductService {
    Product save(Product product);
    List<Product> getAll();
    Product getById(int id);
    void delete(int id);
    List<Product> findExpiredByManufacturer(Manufacturer manufacturer);
//    Page<Product> getAllProducts(int page, int size);
}