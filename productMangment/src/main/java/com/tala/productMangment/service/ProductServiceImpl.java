package com.tala.productMangment.service;

import com.tala.productMangment.enums.Manufacturer;
import com.tala.productMangment.model.Product;
import com.tala.productMangment.repository.ProductRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repo;


    public ProductServiceImpl(ProductRepository repo) {
        this.repo = repo;
    }

    @Override
    public Product save(Product product) {
        if (product.getProductDetails() != null) {
            product.getProductDetails().setProduct(product);
        }
        return repo.save(product);
    }

    @Override
    public List<Product> getAll() {
        return repo.findAll();
    }

    @Override
    public Product getById(int id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }
    @Override
    public List<Product> findExpiredByManufacturer(Manufacturer manufacturer) {
        return repo.findExpiredByName(manufacturer);
    }
//    @Override
//    public Page<Product> getAllProducts(int page, int size) {
//        Pageable pageable = PageRequest.of(page, size);
//        return repo.findAll(pageable);
//    }
}