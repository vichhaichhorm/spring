package com.example.mybatisdemohomework.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Products {
    private Integer id;
    private String name;
    private float price;
    private Boolean active;
}
