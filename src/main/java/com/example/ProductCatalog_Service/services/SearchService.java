package com.example.ProductCatalog_Service.services;

import com.example.ProductCatalog_Service.models.Product;
import com.example.ProductCatalog_Service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
    @Autowired
    private ProductRepository productRepository;
    public List<Product> searchProducts(String query)
    {
        return productRepository.findByNameEquals(query);
    }
}
