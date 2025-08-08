package com.example.ProductCatalog_Service.controllers;

import com.example.ProductCatalog_Service.dtos.SearchRequestDto;
import com.example.ProductCatalog_Service.models.Product;
import com.example.ProductCatalog_Service.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private SearchService searchService;
    @PostMapping
    public List<Product> searchProducts(@RequestBody SearchRequestDto searchRequestDto)
    {
        return searchService.searchProducts(searchRequestDto.getQuery());
    }
}
