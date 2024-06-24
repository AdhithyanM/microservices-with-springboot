package com.adhithyan.orderservice.service;

import com.adhithyan.orderservice.client.InventoryClient;
import com.adhithyan.orderservice.dto.InventoryResponse;
import com.adhithyan.orderservice.dto.OrderRequest;
import com.adhithyan.orderservice.mapper.OrderLineItemMapper;
import com.adhithyan.orderservice.model.Order;
import com.adhithyan.orderservice.model.OrderLineItem;
import com.adhithyan.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderLineItemMapper orderLineItemMapper;
    private final InventoryClient inventoryClient;

    public void placeOrder(OrderRequest orderRequest) {
        List<OrderLineItem> orderLineItems = orderRequest.orderLineItems().stream()
                .map(orderLineItemMapper::toOrderLineItem)
                .collect(Collectors.toList());

        // Call inventory service and place order if product is in stock
        List<String> skuCodes = orderLineItems.stream()
                .map(OrderLineItem::getSkuCode)
                .collect(Collectors.toList());

        List<InventoryResponse> inventoryResponseList = inventoryClient.isInStock(skuCodes);

        System.out.println("inventoryResponseList: "+inventoryResponseList);

        boolean allProductsInStock = inventoryResponseList.stream()
                .allMatch(inventoryResponse -> inventoryResponse.isInStock())
                && inventoryResponseList.size() == skuCodes.size();

        if(allProductsInStock) {
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setOrderLineItems(orderLineItems);
            orderRepository.save(order);
        } else {
            throw new RuntimeException("Some or All of the products are not in stock. Please check and try again later");
        }
    }
}
