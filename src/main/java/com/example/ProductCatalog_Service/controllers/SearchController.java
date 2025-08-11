package com.example.ProductCatalog_Service.controllers;

import com.example.ProductCatalog_Service.dtos.SearchRequestDto;
import com.example.ProductCatalog_Service.models.Product;
import com.example.ProductCatalog_Service.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private SearchService searchService;
    @PostMapping
    public Page<Product> searchProducts(@RequestBody SearchRequestDto searchRequestDto, @RequestParam(name="sortBy",required = false) List<String> parameter)
    {
        return searchService.searchProducts(searchRequestDto.getQuery(),searchRequestDto.getPageNo(),searchRequestDto.getPageSize(),parameter);
    }

    @PostMapping("/slice")
    public Slice<Product> searchProductsSlice(@RequestBody SearchRequestDto searchRequestDto, @RequestParam(name="sortBy",required = false) List<String> parameter)
    {
        return searchService.searchProductsSlice(searchRequestDto.getQuery(),searchRequestDto.getPageNo(),searchRequestDto.getPageSize(),parameter);
    }
}
