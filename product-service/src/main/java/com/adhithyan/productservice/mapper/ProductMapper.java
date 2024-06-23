package com.adhithyan.productservice.mapper;

import com.adhithyan.productservice.dto.ProductResponse;
import com.adhithyan.productservice.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductResponse toProductResponse(Product product) {
        return new ProductResponse(
            product.getId(),
            product.getName(),
            product.getDescription(),
            product.getPrice()
        );
    }
}
