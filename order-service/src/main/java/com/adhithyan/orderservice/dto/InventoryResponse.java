package com.adhithyan.orderservice.dto;

public record InventoryResponse(
        String skuCode,
        boolean isInStock
) {
}
