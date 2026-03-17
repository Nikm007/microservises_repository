package com.example.infy.order_service.service;

import com.example.infy.order_service.Clients.InventoryOpenFeignClient;
import com.example.infy.order_service.Enums.OrderStatus;
import com.example.infy.order_service.dto.OrderRequestDto;
import com.example.infy.order_service.dto.OrderRequestItemDto;
import com.example.infy.order_service.entity.OrderItem;
import com.example.infy.order_service.entity.Orders;
import com.example.infy.order_service.repository.OrdersRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;


@Service
@RequiredArgsConstructor
public class OrdersService {
    private final OrdersRepository ordersRepository;
    private final ModelMapper modelMapper;
    private final InventoryOpenFeignClient inventoryOpenFeignClient;

    @Transactional
    public OrderRequestDto createNewOrder(OrderRequestDto orderRequestDto) {

        Double totalPrice = inventoryOpenFeignClient.reduceStocks(orderRequestDto);
        Orders incoming = modelMapper.map(orderRequestDto, Orders.class);

        for(OrderItem orderItem : incoming.getItems()){
            orderItem.setOrders(incoming);
        }
        incoming.setTotalPrice(totalPrice);
        incoming.setStatus(OrderStatus.CONFIRMED);
        Orders save = ordersRepository.save(incoming);

        return modelMapper.map(save, OrderRequestDto.class);

    }


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