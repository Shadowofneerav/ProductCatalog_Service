package com.example.ProductCatalog_Service.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Data
@Entity
public class Category extends BaseModel{
    private String categoryname;

    @OneToMany(mappedBy = "category",fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    @JsonBackReference
    private List<Product> products;
    private String description;
}

