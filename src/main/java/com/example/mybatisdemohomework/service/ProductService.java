package com.example.mybatisdemohomework.service;

import com.example.mybatisdemohomework.model.Products;

import java.util.List;

public interface ProductService {
    List<Products> getAllProduct();

    Products getProductById(Integer id);

    Products addProduct(Products product);

    Products updateProduct(Integer id, Products productToUpdate);
}
