package com.service.ProductService.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController {
    @GetMapping("/hello")
    public String print(){
        return "Basant";
    }
}
