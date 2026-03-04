package com.example.infy.inventory_service.service;

import com.example.infy.inventory_service.dto.ProductDTO;
import com.example.infy.inventory_service.entity.Product;
import com.example.infy.inventory_service.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

   private final ModelMapper modelMapper;
   private final ProductRepository productRepository;

   public List<ProductDTO> getAllInventory(){
       List<Product> products = productRepository.findAll();
      return products.stream().map(product->modelMapper.map(product, ProductDTO.class)).toList();
   }

   public ProductDTO getProductById(Long id){
       Optional<Product> product = productRepository.findById(id);
       return product.map(item -> modelMapper.map(product, ProductDTO.class)).orElseThrow(
               ()-> new RuntimeException("product not found with id :" + id)
       );

   }
}
