package com.adhithyan.productservice.controller;

import com.adhithyan.productservice.dto.ProductRequest;
import com.adhithyan.productservice.dto.ProductResponse;
import com.adhithyan.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(
        @RequestBody ProductRequest productRequest
    ) {
        productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProduts() {
        return productService.getAllProducts();
    }

}
