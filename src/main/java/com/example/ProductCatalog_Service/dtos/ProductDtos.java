package com.example.ProductCatalog_Service.dtos;

import com.example.ProductCatalog_Service.models.Category;
import com.example.ProductCatalog_Service.models.Product;
import lombok.Data;

@Data
public class ProductDtos {
    private Long id;
    private String name;
    private CategoryDtos category;
    private String description;
    private String image_url;
    private Double price;
    public static Product toProduct(ProductDtos productDtos)
    {
        Product p = new Product();
        p.setId(productDtos.getId());
        p.setName(productDtos.getName());
        if(productDtos.getCategory()!=null) {
            p.setCategory(CategoryDtos.toCategory(productDtos.getCategory(), productDtos));
        }
        p.setPrice(productDtos.getPrice());
        p.setDescription(productDtos.getDescription());
        p.setImage_url(productDtos.getImage_url());
        return p;
    }
}
