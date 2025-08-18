package com.example.ProductCatalog_Service.services;

import com.example.ProductCatalog_Service.dtos.FakeStoreProductDtos;
import com.example.ProductCatalog_Service.models.Category;
import com.example.ProductCatalog_Service.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    private RestTemplate restTemplate;
//    private String url = "https://fakestoreapi.com/";

    public FakeStoreProductService()
    {
        restTemplateBuilder = new RestTemplateBuilder();
        restTemplate = restTemplateBuilder.build();
    }
    @Override
    public Product getproductbyId(Long id) {

        ResponseEntity<FakeStoreProductDtos> responseEntity= restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", FakeStoreProductDtos.class,id);
        FakeStoreProductDtos fakestoreresponse = responseEntity.getBody();
        if(fakestoreresponse!=null && responseEntity.getStatusCode()== HttpStatusCode.valueOf(200))
        {
            Product p = from(fakestoreresponse);
            return p;
        }
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        FakeStoreProductDtos fakeStoreProductDtos = toFakeStoreProductDto(product);
        ResponseEntity<FakeStoreProductDtos> responseEntity = restTemplate.postForEntity("https://fakestoreapi.com/products",fakeStoreProductDtos,FakeStoreProductDtos.class);
        FakeStoreProductDtos fakeStoreProductResponse = responseEntity.getBody();
        if(responseEntity.getStatusCode()==HttpStatusCode.valueOf(200) && fakeStoreProductResponse!=null)
        {
            return from(fakeStoreProductResponse);
        }
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        ResponseEntity<FakeStoreProductDtos[]> fakeStoreproducts = restTemplate.getForEntity("https://fakestoreapi.com/products",FakeStoreProductDtos[].class);
        FakeStoreProductDtos[] fakeStoreProduct = fakeStoreproducts.getBody();
        List<Product> products = new ArrayList<>();
        if (fakeStoreProduct != null) {
            for (FakeStoreProductDtos fakeStoreProductDtos : fakeStoreProduct) {
                products.add(from(fakeStoreProductDtos));
            }
        }
        return products;
    }

    @Override
    public Product replaceProduct(Long id,Product product) {
        FakeStoreProductDtos requestFakeStore = toFakeStoreProductDto(product);
        RequestCallback requestCallback = restTemplate.httpEntityCallback(requestFakeStore);
        ResponseExtractor<ResponseEntity<FakeStoreProductDtos>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDtos.class);
        ResponseEntity<FakeStoreProductDtos> fakeStoreProductDtosResponseEntity = restTemplate.execute("https://fakestoreapi.com/products/{id}", HttpMethod.PUT, requestCallback,responseExtractor,id,requestFakeStore );
        FakeStoreProductDtos fakeStoreProductDtos = fakeStoreProductDtosResponseEntity.getBody();
        if(fakeStoreProductDtosResponseEntity.getStatusCode()==HttpStatusCode.valueOf(200) && fakeStoreProductDtos!=null)
        {
            return from(fakeStoreProductDtos);
        }
        return null;
    }

    @Override
    public Product getProductBasedOnUserScope(Long productId, Long userId) {
        return null;
    }
//    @Nullable
//    public <T> T execute(String uriTemplate, HttpMethod method, @Nullable RequestCallback requestCallback, @Nullable ResponseExtractor<T> responseExtractor, Object... uriVariables) throws RestClientException {
//        URI url = this.getUriTemplateHandler().expand(uriTemplate, uriVariables);
//        return this.doExecute(url, uriTemplate, method, requestCallback, responseExtractor);
//    }

    private FakeStoreProductDtos toFakeStoreProductDto(Product product)
    {
        FakeStoreProductDtos fakeStoreProductDtos = new FakeStoreProductDtos();
        fakeStoreProductDtos.setId(product.getId());
        fakeStoreProductDtos.setPrice(product.getPrice());
        if(product.getCategory()!=null) {
            fakeStoreProductDtos.setCategory(product.getCategory().getCategoryname());
        }
        fakeStoreProductDtos.setTitle(product.getName());
        fakeStoreProductDtos.setDescription(product.getDescription());
        fakeStoreProductDtos.setImage_url(product.getImage_url());
        return fakeStoreProductDtos;
    }
    private Product from(FakeStoreProductDtos fakeStoreProductDtos)
    {
        Product p = new Product();
        p.setId(fakeStoreProductDtos.getId());
        p.setDescription(fakeStoreProductDtos.getDescription());
        p.setName(fakeStoreProductDtos.getTitle());
        String category = fakeStoreProductDtos.getCategory();
        Category c = new Category();
        c.setId(fakeStoreProductDtos.getId());
        c.setCategoryname(category);
        p.setCategory(c);
        p.setPrice(fakeStoreProductDtos.getPrice());
        p.setImage_url(fakeStoreProductDtos.getImage_url());
        return p;
    }
}
