package com.example.ProductService.Service;

import com.example.ProductService.Repository.ProductCountRepository;
import com.example.ProductService.Repository.ProductRepository;
import com.example.ProductService.dto.ProductDTO;
import com.example.ProductService.dto.ProductRequestDTO;
import com.example.ProductService.dto.ProductResponseDTO;
import com.example.ProductService.entity.Product;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductCountRepository productCountRepository;
    public ProductService(ProductRepository productRepository, ProductCountRepository productCountRepository) {
        this.productRepository = productRepository;
        this.productCountRepository = productCountRepository;
    }

    //전체 상품 목록 조회- 새로 등록된 상품 순으로 정렬
    @Transactional(readOnly = true)
    public List<ProductDTO> getProducts() {
        return productRepository.findAllByOrderByCreateAtDesc().stream().map(ProductDTO::new).toList();
    }

    //상품 상세목록 조회
    @Transactional
    public Product getProduct(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("상품을 찾을 수 없습니다: " + productId));
    }


    //실제 상품 수량 조회
//    @Transactional
//    public ProductCountDTO getProductCount(Long productId) {
//        ProductCountDTO productCountDTO = productCountRepository.findById(productId);
//        return ProductCountDTO.toDto(productCountDTO);
//
//    }

    @Transactional
    public ProductResponseDTO createProduct(ProductRequestDTO requestDTO) {
        Product product = new Product(requestDTO);
        productRepository.save(product);
        return new ProductResponseDTO(product);
    }
}
