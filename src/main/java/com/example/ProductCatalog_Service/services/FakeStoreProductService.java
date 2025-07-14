package com.example.ProductCatalog_Service.services;

import com.example.ProductCatalog_Service.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements ProductService{
    private RestTemplateBuilder restTemplateBuilder;
    private RestTemplate restTemplate;

    public FakeStoreProductService()
    {
        restTemplateBuilder = new RestTemplateBuilder();
        restTemplate = restTemplateBuilder.build();
    }
    @Override
    public Product getproductbyId(Long id) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }
}
