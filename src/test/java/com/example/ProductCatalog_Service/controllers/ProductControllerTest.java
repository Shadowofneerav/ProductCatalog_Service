package com.example.ProductCatalog_Service.controllers;

import com.example.ProductCatalog_Service.dtos.ProductDtos;
import com.example.ProductCatalog_Service.models.Product;
import com.example.ProductCatalog_Service.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ProductControllerTest {
    @Autowired
    private ProductController productController;
    @MockBean
    private ProductService productService;
    @Test
    public void testGetProductForID_WithValidID_RunSuccessfully()
    {
        //Arrange
        Long id = 1L;
        Product product = new Product();
        product.setId(id);
        product.setName("Mac 14");
        when(productService.getproductbyId(1L)).thenReturn(product);

        //Act
        ProductDtos productDtos = productController.getProductbyID(id);
        //Assert
        assertNotNull(productDtos.getId());
        assertEquals("Mac 14",productDtos.getName());
        verify(productService,times(1)).getproductbyId(id);
    }
    @Test
    public void testGetProductbyID_withInvalidID_throwingIllegalArgumentException()
    {

        //Assert
        assertThrows(IllegalArgumentException.class,()->productController.getProductbyID(-1L));
    }
    @Test
    public void testGetProductbyID_withInvalidID_throwingIllegalArgumentExceptionAndCheckExceptionMessage()
    {

        //Assert
       Exception ex = assertThrows(IllegalArgumentException.class,()->productController.getProductbyID(-1L));
       assertEquals("Product Id is not valid",ex.getMessage());
    }
}
