package com.example.ProductCatalog_Service.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Category extends BaseModel{
    private String categoryname;
    @OneToMany(mappedBy = "category")
    @JsonBackReference
    private List<Product> products;
    private String description;
}

