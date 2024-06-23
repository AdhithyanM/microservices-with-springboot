package com.adhithyan.orderservice.service;

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

    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItem> orderLineItems = orderRequest.orderLineItems().stream()
                .map(orderLineItemMapper::toOrderLineItem)
                .collect(Collectors.toList());

        order.setOrderLineItems(orderLineItems);
        orderRepository.save(order);
    }
}
