package com.adhithyan.productservice.service;

import com.adhithyan.productservice.dto.ProductRequest;
import com.adhithyan.productservice.dto.ProductResponse;
import com.adhithyan.productservice.mapper.ProductMapper;
import com.adhithyan.productservice.model.Product;
import com.adhithyan.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();

        productRepository.save(product);
        log.info("Product {} is saved", product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream()
                .map(productMapper::toProductResponse)
                .collect(Collectors.toList());
    }
}
