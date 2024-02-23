package com.example.ProductService.dto;

import com.example.ProductService.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDTO {
    private Long product_id;

    private String title;

    private String content;

    private Long price;

    public ProductResponseDTO(Product product) {
        this.product_id = product.getProduct_id();
        this.title = product.getTitle();
        this.content = product.getContent();
        this.price = product.getPrice();

    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
