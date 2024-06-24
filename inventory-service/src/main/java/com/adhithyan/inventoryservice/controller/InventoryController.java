package com.adhithyan.inventoryservice.controller;

import com.adhithyan.inventoryservice.dto.InventoryResponse;
import com.adhithyan.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    // http://localhost:8092/api/inventory/iPhone-13,iPhone-15
    // http://localhost:8092/api/inventory?skuCodes=iPhone-13&skuCodes=iPhone-13-red    (use it this way)
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(
        @RequestParam List<String> skuCodes
    ) {
        System.out.println("skuCode: "+skuCodes);
        return inventoryService.isInStock(skuCodes);
    }
}
