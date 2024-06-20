package com.example.mybatisdemohomework.repository;

import com.example.mybatisdemohomework.model.Products;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductRepository {
    @Select("""
       SELECT * FROM products;
       """)
    @Results(id = "productMapper" ,value = {
            @Result(property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "price",column = "price_per_unit"),
            @Result(property = "active",column = "active_for_sell")
    })
    List<Products> getAllProduct();

    @Select("""
       SELECT * FROM products WHERE id=#{id};
        """)
    @ResultMap({"productMapper"})
    Products getProductById(Integer id);

    @Select("INSERT INTO products (name, price_per_unit, active_for_sell) " +
            "VALUES (#{name}, #{price_per_unit}, #{active_for_sell}) " +
            "RETURNING *")
    Products addProduct(Products product);

    @Update("UPDATE products SET name = #{product.name}, " +
            "price_per_unit = #{product.price_per_unit}, " +
            "active_for_sell = #{product.active_for_sell} " +
            "WHERE id = #{id}")
    int updateProduct(@Param("id") Integer id, @Param("product") Products product);
}
