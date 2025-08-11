package com.example.ProductCatalog_Service.services;

import com.example.ProductCatalog_Service.models.Product;
import com.example.ProductCatalog_Service.repository.ProductRepository;
import org.hibernate.boot.jaxb.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
    @Autowired
    private ProductRepository productRepository;
    public Page<Product> searchProducts(String query, int pageNo, int pageSize,List<String> parameters)
    {
//        Sort sortbyId = Sort.by("id").descending();
//        Sort sort = Sort.by("price").descending();
//        sort = sort.and(sortbyId);
        Sort sort = Sort.by("price").descending();
        if(parameters!=null) {
            for (String parameter : parameters) {
                Sort sortbytemp = Sort.by(parameter).descending();
                sort = sort.and(sortbytemp);
            }
        }
        return productRepository.findByNameEquals(query, PageRequest.of(pageNo,pageSize,sort));
    }
    public Slice<Product> searchProductsSlice(String query, int pageNo, int pageSize, List<String> parameters)
    {
//        Sort sortbyId = Sort.by("id").descending();
//        Sort sort = Sort.by("price").descending();
//        sort = sort.and(sortbyId);
        Sort sort = Sort.by("price").descending();
        if(parameters!=null) {
            for (String parameter : parameters) {
                Sort sortbytemp = Sort.by(parameter).descending();
                sort = sort.and(sortbytemp);
            }
        }
        return productRepository.findByNameEquals(query, PageRequest.of(pageNo,pageSize,sort));
    }
}
