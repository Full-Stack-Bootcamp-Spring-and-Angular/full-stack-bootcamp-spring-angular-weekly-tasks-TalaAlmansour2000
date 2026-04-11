package com.tala.productMangment.controller;

import com.tala.productMangment.enums.Manufacturer;
import com.tala.productMangment.model.Product;
import com.tala.productMangment.service.ProductService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v2/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getById(id));
    }


    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(product));
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable int id, @RequestBody Product product) {
        product.setId(id);
        return service.save(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
    @GetMapping("/expired")
    public List<Product> getExpiredByManufacturer(@RequestParam Manufacturer manufacturer) {
        return service.findExpiredByManufacturer(manufacturer);
    }
}