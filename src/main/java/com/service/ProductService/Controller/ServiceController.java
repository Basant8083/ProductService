package com.service.ProductService.Controller;

import com.service.ProductService.Dtoclass.GenericProductDto;
import com.service.ProductService.Service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ServiceController {

    private ProductService productService;
    ServiceController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("{id}")
    public ResponseEntity<GenericProductDto> getProductById(@PathVariable("id") Long id){
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.NOT_FOUND) ;
    }
    @GetMapping
    public GenericProductDto[] getAllProducts(){
        return productService.getAllProducts();
    }







}
