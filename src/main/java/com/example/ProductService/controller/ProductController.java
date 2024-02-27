package com.example.ProductService.controller;

import com.example.ProductService.Service.ProductService;
import com.example.ProductService.dto.ProductDTO;
import com.example.ProductService.dto.ProductRequestDTO;
import com.example.ProductService.dto.ProductResponseDTO;
import com.example.ProductService.entity.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ProductService")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //상품 목록 조회

    //2. 일반 상품 조회
    @GetMapping("/product/id")
    public List<ProductDTO> getproducts(){
        System.out.println("일반 상품 조회");
        return productService.getProducts();
    }

    //상품 상세페이지 조회
    @GetMapping("/product/details/{product_id}")
    public Product getProduct(@PathVariable Long product_id) {
        return productService.getProduct(product_id);
    }


    //상품 등록
    @PostMapping("/product/new")
    public ProductResponseDTO createProduct(@RequestBody ProductRequestDTO requestDTO){
        return productService.createProduct(requestDTO);
    }

}
