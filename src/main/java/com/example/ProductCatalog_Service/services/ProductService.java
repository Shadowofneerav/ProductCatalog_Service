package com.example.ProductCatalog_Service.services;

import com.example.ProductCatalog_Service.ProductCatalogServiceApplication;
import com.example.ProductCatalog_Service.models.Product;

import java.util.List;

public interface ProductService {
    public Product getproductbyId(Long id);
    public Product createProduct(Product product);
    public List<Product> getAllProducts();
    public Product replaceProduct(Long id,Product product);
    public Product getProductBasedOnUserScope(Long productId,Long userId);
}
