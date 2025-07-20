package com.example.ProductCatalog_Service.services;

import com.example.ProductCatalog_Service.models.Category;
import com.example.ProductCatalog_Service.models.Product;
import com.example.ProductCatalog_Service.repository.CategoryRepository;
import com.example.ProductCatalog_Service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class StorageProductService implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Product getproductbyId(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty())
        {
            throw new NullPointerException("User is not present");
        }
        return product.get();
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return productRepository.save(product);
    }
}
