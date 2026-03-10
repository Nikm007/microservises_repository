package com.example.infy.order_service.controller;

import com.example.infy.order_service.dto.OrderRequestDto;
import com.example.infy.order_service.dto.OrderRequestItemDto;
import com.example.infy.order_service.entity.Orders;
import com.example.infy.order_service.repository.OrdersRepository;
import com.example.infy.order_service.service.OrdersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
@Slf4j
@RequiredArgsConstructor

public class OrdersController {

    private final ModelMapper modelMapper;
    private final OrdersService ordersService;

    @GetMapping("/fetchOrders")
    public String helloFetchOrder(){
        return "Hello from orders service";
    }

    @GetMapping("/")
    public ResponseEntity<Page<OrderRequestDto>> getAllOrders(){
        Page<OrderRequestDto> orderRequestDtos = ordersService.getAllOrders();
        return ResponseEntity.ok(orderRequestDtos);

    }
@GetMapping("/{id}")
    public ResponseEntity<OrderRequestDto> getOrderById(@PathVariable Long id){

        OrderRequestDto orderRequestDto = ordersService.getOrderById(id);
        return ResponseEntity.ok(orderRequestDto);
}



}
