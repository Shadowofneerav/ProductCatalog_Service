package com.example.ProductCatalog_Service.models;

import lombok.Data;

import java.util.List;

@Data
public class Category extends BaseModel{
    private String categoryname;
    private List<Product> products;
    private String description;
}

