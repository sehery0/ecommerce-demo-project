package com.etiya.ecommercedemo3.business.dtos.response.order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddOrderResponse {
    private int Id;
    private int paymentId;
    private int customerId;
    private int addressId;
    private LocalDate orderDate;
    private String orderNumber;
}
