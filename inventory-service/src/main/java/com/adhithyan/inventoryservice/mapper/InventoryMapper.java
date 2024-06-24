package com.adhithyan.inventoryservice.mapper;

import com.adhithyan.inventoryservice.dto.InventoryResponse;
import com.adhithyan.inventoryservice.model.Inventory;
import org.springframework.stereotype.Component;

@Component
public class InventoryMapper {

    public InventoryResponse toInventoryResponse(Inventory inventory) {
        return new InventoryResponse(
          inventory.getSkuCode(),
          inventory.getQuantity() > 0
        );
    }
}
