package com.example.ProductCatalog_Service.controllers;

import com.example.ProductCatalog_Service.dtos.ProductDtos;
import com.example.ProductCatalog_Service.models.Product;
import com.example.ProductCatalog_Service.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ProductDtos getProductbyID(ProductDtos productDtos)
    {
        Product product = ProductDtos.toProduct(productDtos);
//        ProductDtos responseDto = productService.getproductbyId(product.getId());
        return null;

    }
}
