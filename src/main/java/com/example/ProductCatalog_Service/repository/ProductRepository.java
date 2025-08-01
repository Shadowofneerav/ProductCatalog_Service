package com.example.ProductCatalog_Service.repository;

import com.example.ProductCatalog_Service.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Product save(Product product);
    Optional<Product> findById(Long id);
    List<Product> findAll();
}
