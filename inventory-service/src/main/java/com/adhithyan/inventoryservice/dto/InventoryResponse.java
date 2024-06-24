package com.adhithyan.inventoryservice.dto;

public record InventoryResponse(
        String skuCode,
        boolean isInStock
) {
}
