package com.example.ProductService.Repository;

import com.example.ProductService.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByOrderByCreateAtDesc();


    Optional<Product> findById(Long product_id);

//    ProductCountDTO findByCount(Long productId);
}

