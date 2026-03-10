package com.example.infy.inventory_service.controller;

import com.example.infy.inventory_service.dto.ProductDTO;
import com.example.infy.inventory_service.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final RestClient restClient;
    private final DiscoveryClient discoveryClient;

    @GetMapping("/getOrders")
    public String getOrderFromInventory(){

        ServiceInstance ordersService = discoveryClient.getInstances("order-service").getFirst();

        return restClient.get()
                .uri(ordersService.getUri()+"/api/v1/orders/fetchOrders")
                .retrieve()
                .body(String.class);
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
}
