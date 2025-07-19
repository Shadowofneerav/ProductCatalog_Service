package com.example.ProductCatalog_Service.models;

import com.example.ProductCatalog_Service.dtos.CategoryDtos;
import com.example.ProductCatalog_Service.dtos.ProductDtos;
import lombok.Data;

@Data
public class Product extends BaseModel{
    private String name;
    private Category category;
    private String description;
    private String image_url;
    private Double price;
    public static ProductDtos toProductDtos(Product product)
    {
        ProductDtos productDtos = new ProductDtos();
        productDtos.setId(product.getId());
        productDtos.setName(product.getName());
        if(product.getCategory()!=null) {
            CategoryDtos c = new CategoryDtos();
            c.setProducts(product.getCategory().getProducts());
            c.setDescription(product.getCategory().getDescription());
            c.setCategoryname(product.getCategory().getCategoryname());
            productDtos.setCategory(c);
        }
        productDtos.setPrice(product.getPrice());
        productDtos.setImage_url(product.getImage_url());
        productDtos.setDescription(product.getDescription());
        return productDtos;
    }


}
