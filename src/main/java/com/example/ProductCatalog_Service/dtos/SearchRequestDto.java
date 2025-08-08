package com.example.ProductCatalog_Service.dtos;

import lombok.Data;

@Data
public class SearchRequestDto {
    private String query;
    private Integer pageNo;
    private Integer pageSize;
}
