package com.example.ProductService.Repository;

import com.example.ProductService.entity.ProductCount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCountRepository extends JpaRepository<ProductCount, Long> {
}
