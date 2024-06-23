package com.adhithyan.orderservice.mapper;

import com.adhithyan.orderservice.dto.OrderLineItemDto;
import com.adhithyan.orderservice.model.OrderLineItem;
import org.springframework.stereotype.Component;

@Component
public class OrderLineItemMapper {
    public OrderLineItem toOrderLineItem(OrderLineItemDto orderLineItemDto) {
        return OrderLineItem.builder()
                .skuCode(orderLineItemDto.skuCode())
                .quantity(orderLineItemDto.quantity())
                .price(orderLineItemDto.price())
                .build();
    }
}
