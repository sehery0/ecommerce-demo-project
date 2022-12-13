package com.etiya.ecommercedemo3.api.controllers;

import com.etiya.ecommercedemo3.business.abstracts.PaymentService;
import com.etiya.ecommercedemo3.business.constants.Paths;
import com.etiya.ecommercedemo3.business.dtos.response.payment.GetAllPaymentsResponse;
import com.etiya.ecommercedemo3.core.util.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix + "payments")
@AllArgsConstructor
public class PaymentsController {
    private PaymentService paymentService;
    @GetMapping("/getAllPaymentsDto")
    public DataResult<List<GetAllPaymentsResponse>> getAllDto(){
        return this.paymentService.getAllDto();
    }
}
