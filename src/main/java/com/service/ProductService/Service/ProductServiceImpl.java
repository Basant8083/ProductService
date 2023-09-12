package com.service.ProductService.Service;

import com.service.ProductService.Dtoclass.FakeProductServiceDto;
import com.service.ProductService.Dtoclass.GenericProductDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements  ProductService{

    private String getProductResourceUrl = "https://fakestoreapi.com/products/{id}";
    private String getAllProductsResourceUrl = "https://fakestoreapi.com/products";
    RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();

    private GenericProductDto fakeProductToGenericProductDto(FakeProductServiceDto fakeProductServiceDto){
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setCategory(fakeProductServiceDto.getCategory());
        genericProductDto.setImage(fakeProductServiceDto.getImage());
        genericProductDto.setDescription(fakeProductServiceDto.getDescription());
        genericProductDto.setTitle(fakeProductServiceDto.getTitle());
        genericProductDto.setPrice(fakeProductServiceDto.getPrice());

        return genericProductDto;
    }
    @Override
    public GenericProductDto getProductById(Long id) {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeProductServiceDto> responseEntity =  restTemplate.getForEntity(getProductResourceUrl, FakeProductServiceDto.class, id);

        GenericProductDto genericProductDto = fakeProductToGenericProductDto(responseEntity.getBody());



        return genericProductDto;
    }

    @Override
    public GenericProductDto[] getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeProductServiceDto[]> responseEntity =  restTemplate.getForEntity(getAllProductsResourceUrl, FakeProductServiceDto[].class);
        List<GenericProductDto> genericProducts = new ArrayList<>();
        for(FakeProductServiceDto fakeProductServiceDto : responseEntity.getBody()) {
            genericProducts.add(fakeProductToGenericProductDto(fakeProductServiceDto));
        }


        return (restTemplate.exchange(getAllProductsResourceUrl, HttpMethod.GET, null, GenericProductDto[].class).getBody());
    }


}
