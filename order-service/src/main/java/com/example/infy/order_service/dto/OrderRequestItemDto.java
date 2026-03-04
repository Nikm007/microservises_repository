package com.example.infy.order_service.dto;

import lombok.Data;

@Data
public class OrderRequestItemDto {
    private Long id;

    private Integer quantity;

    private Long productId;
}
