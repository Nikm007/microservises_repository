package com.example.infy.order_service.service;

import com.example.infy.order_service.dto.OrderRequestDto;
import com.example.infy.order_service.dto.OrderRequestItemDto;
import com.example.infy.order_service.entity.Orders;
import com.example.infy.order_service.repository.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class OrdersService {
    private final OrdersRepository ordersRepository;
    private final ModelMapper modelMapper;


    public Page<OrderRequestDto> getAllOrders(){
        Pageable pageable = PageRequest.of(0, 20);
        Page<Orders> ordersPage = ordersRepository.findAll(pageable);

        return ordersPage.map(order ->
                modelMapper.map(order, OrderRequestDto.class));

}

    public OrderRequestDto getOrderById(Long id) {

        Orders order = ordersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("order not found for id " + id));

        OrderRequestDto dto = modelMapper.map(order, OrderRequestDto.class);
        return dto;
    }

}