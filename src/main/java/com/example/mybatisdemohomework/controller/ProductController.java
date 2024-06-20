package com.example.mybatisdemohomework.controller;

import com.example.mybatisdemohomework.model.Products;
import com.example.mybatisdemohomework.model.request.repository.APIResponse;
import com.example.mybatisdemohomework.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<APIResponse<List<Products>>> getAllProduct(){
        return ResponseEntity.status(HttpStatus.OK).body(
                new APIResponse<>(
                        "Find all successful",
                        productService.getAllProduct(),
                        HttpStatus.OK,
                        LocalDateTime.now()
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<Products>> getProductById(@PathVariable("id") Integer id) {
        Products product = productService.getProductById(id);
        if (product != null) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new APIResponse<>(
                            "Product found",
                            product,
                            HttpStatus.OK,
                            LocalDateTime.now()
                    )
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new APIResponse<>(
                            "Product not found",
                            null,
                            HttpStatus.NOT_FOUND,
                            LocalDateTime.now()
                    )
            );
        }
    }
    @PostMapping("")
    public ResponseEntity<APIResponse<Products>> addProduct(@RequestBody Products product) {
        Products newProduct = productService.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new APIResponse<>(
                        "Product added successfully",
                        newProduct,
                        HttpStatus.CREATED,
                        LocalDateTime.now()
                )
        );
    }


    // Endpoint to update a Product
    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<Products>> updateProduct(
            @PathVariable("id") Integer id,
            @RequestBody Products productToUpdate) {
        Products updatedProduct = productService.updateProduct(id, productToUpdate);
        if (updatedProduct != null) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new APIResponse<>(
                            "Product updated successfully",
                            updatedProduct,
                            HttpStatus.OK,
                            LocalDateTime.now()
                    )
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new APIResponse<>(
                            "Product not found",
                            null,
                            HttpStatus.NOT_FOUND,
                            LocalDateTime.now()
                    )
            );
        }
    }

}
