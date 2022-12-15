package com.etiya.ecommercedemo3.business.dtos.response.cartDetail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetCartDetailResponse {
    private int productId;
    private int cartId;

}
