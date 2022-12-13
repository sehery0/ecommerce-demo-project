package com.etiya.ecommercedemo3.business.dtos.response.product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetProductsResponse {
    private String name;
    private int stock;
    private double unitPrice;
}
