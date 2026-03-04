package com.example.infy.order_service.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequestDto {
private Long id;
private List<OrderRequestItemDto> orderItemList;
private Double totalPrice;
}
