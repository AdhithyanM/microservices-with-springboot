package com.adhithyan.orderservice.dto;

import java.util.List;

public record OrderRequest(
        List<OrderLineItemDto> orderLineItems
) {
}
