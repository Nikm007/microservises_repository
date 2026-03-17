package com.example.infy.inventory_service.controller;

import com.example.infy.inventory_service.Clients.OrderFeignClient;
import com.example.infy.inventory_service.dto.OrderRequestDto;
import com.example.infy.inventory_service.dto.ProductDTO;
import com.example.infy.inventory_service.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    private final OrderFeignClient feignClient;

    @GetMapping("/getOrders")
    public String getOrderFromInventory(){

        return feignClient.getHelloOrders();


//        ServiceInstance ordersService = discoveryClient.getInstances("order-service").getFirst();
//
//        return restClient.get()
//                .uri(ordersService.getUri()+"/orders/core/fetchOrders")
//                .retrieve()
//                .body(String.class);
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
       List<ProductDTO> inventories = productService.getAllInventory();
       return  ResponseEntity.ok(inventories);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id){
        ProductDTO dto = productService.getProductById(id);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/reduce-stocks")
    public ResponseEntity<Double> reduceStock(@RequestBody OrderRequestDto orderRequestDto){
        Double totalPrice = productService.reduceStocks(orderRequestDto);
        return ResponseEntity.ok(totalPrice);
    }
}
