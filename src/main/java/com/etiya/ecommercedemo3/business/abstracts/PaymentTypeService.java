package com.etiya.ecommercedemo3.business.abstracts;

import com.etiya.ecommercedemo3.business.dtos.request.paymentType.AddPaymentTypeRequest;
import com.etiya.ecommercedemo3.business.dtos.response.paymentType.AddPaymentTypeResponse;
import com.etiya.ecommercedemo3.entities.concretes.PaymentType;

import java.util.List;

public interface PaymentTypeService {
    List<PaymentType> getAll();
    PaymentType getById(int id);
    PaymentType getByName(String name);
    PaymentType getByDescription(String description);
    AddPaymentTypeResponse addPaymentType(AddPaymentTypeRequest addPaymentTypeRequest);
}
