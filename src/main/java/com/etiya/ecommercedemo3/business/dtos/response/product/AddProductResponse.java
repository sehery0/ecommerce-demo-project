package com.etiya.ecommercedemo3.business.dtos.response.product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AddProductResponse {
    private  int id;
    private String name;
    private double unitPrice;
    private int stock;
    private int orderId;
}
