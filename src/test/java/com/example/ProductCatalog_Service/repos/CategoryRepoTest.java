package com.example.ProductCatalog_Service.repos;

import com.example.ProductCatalog_Service.models.Category;
import com.example.ProductCatalog_Service.models.Product;
import com.example.ProductCatalog_Service.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class CategoryRepoTest {
    @Autowired
    private CategoryRepository categoryRepo;
    @Test
    @Transactional
    public void testfindByCategoryID(){
        Optional<Category> categoryOptional = categoryRepo.findById(1L);
//        for(Product p : categoryOptional.get().getProducts()) {
//            System.out.println(p.getName());
//        }
    }
}
