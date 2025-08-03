package com.example.ProductCatalog_Service.steps;

import com.example.ProductCatalog_Service.controllers.ProductController;
import com.example.ProductCatalog_Service.dtos.CategoryDtos;
import com.example.ProductCatalog_Service.dtos.ProductDtos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ProductControllerSteps {
    @LocalServerPort
    private int port;
    private ProductDtos productDtos;
    private Response response;
    @Given("I want to get the productDto with productDetails")
    public void test()
    {
        productDtos = new ProductDtos();
        productDtos.setId(1L);
        productDtos.setName("Abc");
        productDtos.setDescription("Alpha Beta Gamma");
        productDtos.setPrice(400.0);
        CategoryDtos categoryDtos = new CategoryDtos();
        categoryDtos.setCategoryname("AVC");
        productDtos.setCategory(categoryDtos);
        productDtos.setImage_url("https://123.com");

    }



    @When("Details Valid")
    public void detailsValid() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String requestbody = objectMapper.writeValueAsString(productDtos);
        response = given().port(port).contentType(ContentType.JSON).body(requestbody).post("/products");
    }

    @Then("Return response with Success {int}")
    public void returnResponseWithSuccess(int arg0) {
        assertEquals(response.getStatusCode(),arg0);
    }
}
