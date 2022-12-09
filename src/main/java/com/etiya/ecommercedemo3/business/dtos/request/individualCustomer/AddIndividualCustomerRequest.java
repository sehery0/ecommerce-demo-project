package com.etiya.ecommercedemo3.business.dtos.request.individualCustomer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AddIndividualCustomerRequest {
    private String firstName;
    private String lastName;
    private String nationalIdentity;
    private int customerNumber;

}
