package com.example.ProductCatalog_Service.controllers;

import com.example.ProductCatalog_Service.dtos.ProductDtos;
import com.example.ProductCatalog_Service.models.Product;
import com.example.ProductCatalog_Service.services.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
public class ProductControllerMvcTest {
    @MockBean
    private ProductService productService;
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void testGetAllProducts_RunSuccessfully() throws Exception{
        //Arrange
        Product product = new Product();
        product.setId(1L);
        product.setName("Mac");
        List<Product> productList = new ArrayList<>();
        productList.add(product);

        when(productService.getAllProducts()).thenReturn(productList);
        ProductDtos productDtos = new ProductDtos();
        productDtos.setId(1L);
        productDtos.setName("Mac");
        List<ProductDtos> productDtosList = new ArrayList<>();
        productDtosList.add(productDtos);
        ObjectMapper objectMapper = new ObjectMapper();
        String response = objectMapper.writeValueAsString(productDtosList);
        //Assert
        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(content().string(response));
    }
//    @Test
//    private void testCreateProductService_RunSuccessfully()
//    {
//        Product product = new Product();
//        product.setId(1L);
//        product.setName("Mac");
//        when(productService.createProduct(product)).thenReturn(product);
//        ProductDtos productDtos = new ProductDtos();
//        productDtos.setId(1L);
//        productDtos.setName("Mac");
//    }

}
