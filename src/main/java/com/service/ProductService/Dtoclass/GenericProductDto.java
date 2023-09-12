package com.service.ProductService.Dtoclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericProductDto {
    private String title;
    private Double price;
    private String description;
    private String image;
    private String category;
}
