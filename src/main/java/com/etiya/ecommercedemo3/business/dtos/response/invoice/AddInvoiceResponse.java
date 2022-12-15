package com.etiya.ecommercedemo3.business.dtos.response.invoice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddInvoiceResponse {
    private int Id;
    private String invoiceNumber;
    private LocalDate invoiceDate;
    private int orderId;
}
