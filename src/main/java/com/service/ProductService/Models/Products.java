package com.service.ProductService.Models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Products extends BaseModel{

    private String title;
    private Double price;
    private String description;
    private String image;
    private String category;





}
