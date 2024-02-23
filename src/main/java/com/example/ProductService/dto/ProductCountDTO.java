package com.example.ProductService.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductCountDTO {
    private Long product_id;
    private Long count;



}
