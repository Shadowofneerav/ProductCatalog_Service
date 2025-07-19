package com.example.ProductCatalog_Service.dtos;

import com.example.ProductCatalog_Service.models.Category;
import lombok.Data;

@Data
public class FakeStoreProductDtos {
    private Long id;
    private String title;
    private String category;
    private String description;
    private String image_url;
    private Double price;
}
