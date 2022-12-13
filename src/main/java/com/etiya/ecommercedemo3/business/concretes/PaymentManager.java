package com.etiya.ecommercedemo3.business.concretes;

import com.etiya.ecommercedemo3.business.abstracts.PaymentService;
import com.etiya.ecommercedemo3.business.dtos.response.payment.GetAllPaymentsResponse;
import com.etiya.ecommercedemo3.core.util.results.DataResult;
import com.etiya.ecommercedemo3.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemo3.repository.abstracts.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PaymentManager implements PaymentService {
    private PaymentRepository paymentRepository;

    @Override
    public DataResult<List<GetAllPaymentsResponse>> getAllDto() {
        List<GetAllPaymentsResponse> response = paymentRepository.getAllDto();
        return new SuccessDataResult<List<GetAllPaymentsResponse>>(response,"Ödeme tipi Listelendi");
    }
}
