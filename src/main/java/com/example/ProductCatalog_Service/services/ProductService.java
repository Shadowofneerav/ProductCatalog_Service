package com.example.ProductCatalog_Service.services;

import com.example.ProductCatalog_Service.models.Product;

public interface ProductService {
    public Product getproductbyId(Long id);
    public Product createProduct(Product product);
}
