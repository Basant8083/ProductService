package com.service.ProductService.Service;

import com.service.ProductService.Dtoclass.GenericProductDto;

public interface ProductService {

    GenericProductDto getProductById(Long id);

    GenericProductDto[] getAllProducts();
}
