package com.adhithyan.inventoryservice.service;

import com.adhithyan.inventoryservice.dto.InventoryResponse;
import com.adhithyan.inventoryservice.mapper.InventoryMapper;
import com.adhithyan.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;
    private final InventoryMapper inventoryMapper;

    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCodes) {
        return inventoryRepository.findBySkuCodeIn(skuCodes).stream()
                .map(inventoryMapper::toInventoryResponse)
                .collect(Collectors.toList());
    }
}
