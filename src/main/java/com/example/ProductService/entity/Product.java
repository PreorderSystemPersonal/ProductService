package com.example.ProductService.entity;

import com.example.ProductService.dto.ProductRequestDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name="Product_table")
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto인가?
    private Long product_id;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private Long price;

    @Column
    @CreatedDate
    private LocalDateTime createAt;
    @Column
    private LocalDateTime deletedAt;

    public Product(ProductRequestDTO requestDTO){
        this.title = requestDTO.getTitle();
        this.content = requestDTO.getContent();
        this.price= requestDTO.getPrice();
    }

    public Long getProduct_id() {
        return product_id;
    }


    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
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
