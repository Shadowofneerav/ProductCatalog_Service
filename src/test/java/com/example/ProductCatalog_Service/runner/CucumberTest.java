package com.example.ProductCatalog_Service.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = {"com.example.ProductCatalog_Service.steps","com.example.ProductCatalog_Service.configuration"},
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true
)
public class CucumberTest {
}
