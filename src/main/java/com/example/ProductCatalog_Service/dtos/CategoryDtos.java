package com.example.ProductCatalog_Service.dtos;

import com.example.ProductCatalog_Service.models.Category;
import com.example.ProductCatalog_Service.models.Product;
import lombok.Data;

import java.util.List;

@Data
public class CategoryDtos {
//    private Long id;
    private String categoryname;
//    private List<Product> products;
    private String description;
    public static Category toCategory(CategoryDtos categoryDtos, ProductDtos p)
    {
        Category c = new Category();
        c.setId(p.getId());
//        c.setProducts(categoryDtos.getProducts());
        c.setDescription(categoryDtos.getDescription());
        c.setCategoryname(categoryDtos.getCategoryname());
        return c;
    }
}
