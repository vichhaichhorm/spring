package com.example.mybatisdemohomework.service.serviceimp;

import com.example.mybatisdemohomework.model.Products;
import com.example.mybatisdemohomework.repository.ProductRepository;
import com.example.mybatisdemohomework.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Products> getAllProduct() {
        return productRepository.getAllProduct();
    }

    @Override
    public Products getProductById(Integer id) {
        return productRepository.getProductById(id);
    }

    @Override
    public Products addProduct(Products product) {
        return productRepository.addProduct(product);
    }

    @Override
    @Transactional
    public Products updateProduct(Integer id, Products productToUpdate) {
        int rowsAffected = productRepository.updateProduct(id, productToUpdate);
        if (rowsAffected > 0) {
            return productRepository.getProductById(id); // Fetch and return updated product
        } else {
            throw new RuntimeException("Failed to update product with id: " + id);
        }
    }
}
