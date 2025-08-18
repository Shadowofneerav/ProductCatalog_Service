package com.example.ProductCatalog_Service.controllers;

import com.example.ProductCatalog_Service.dtos.FakeStoreProductDtos;
import com.example.ProductCatalog_Service.dtos.ProductDtos;
import com.example.ProductCatalog_Service.models.Product;
import com.example.ProductCatalog_Service.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ProductDtos getProductbyID(@PathVariable Long id)
    {
//        Product product = ProductDtos.toProduct(productDtos);
        if(id<0)
        {
            throw new IllegalArgumentException("Product Id is not valid");
        }
        Optional<Product> response = Optional.ofNullable(productService.getproductbyId(id));
        if(response.isEmpty())
        {
            return new ProductDtos();
        }

        return Product.toProductDtos(response.get());
    }
    @GetMapping
    public List<ProductDtos> getAllProducts()
    {
        List<Product> products = productService.getAllProducts();
        List<ProductDtos> productDtos = products.stream().map(Product::toProductDtos).toList();
        return productDtos;
    }

    @PostMapping
    public ProductDtos createProduct(@RequestBody ProductDtos productDtos)
    {
        Optional<Product> response = Optional.ofNullable(productService.createProduct(ProductDtos.toProduct(productDtos)));

        return Product.toProductDtos(response.get());
    }
    @PutMapping("/{id}")
    public ProductDtos putProduct(@PathVariable Long id, @RequestBody ProductDtos productDtos)
    {
        Optional<Product> response = Optional.ofNullable(productService.replaceProduct(id, ProductDtos.toProduct(productDtos)));

        return Product.toProductDtos(response.get());
    }

    @GetMapping("/{productId}/{userId}")
    public ProductDtos getProductBasedOnUserScope(@PathVariable Long productId, @PathVariable Long userId)
    {
        return Product.toProductDtos(productService.getProductBasedOnUserScope(productId, userId));
    }


}
