package com.etiya.ecommercedemo3.business.abstracts;

import com.etiya.ecommercedemo3.business.dtos.request.invoice.AddInvoiceRequest;
import com.etiya.ecommercedemo3.business.dtos.response.address.AddAddressResponse;
import com.etiya.ecommercedemo3.business.dtos.response.invoice.AddInvoiceResponse;
import com.etiya.ecommercedemo3.core.util.results.DataResult;
import com.etiya.ecommercedemo3.entities.concretes.Invoice;

import java.util.List;

public interface InvoiceService {
    DataResult<AddInvoiceResponse> addInvoice(AddInvoiceRequest addInvoiceRequest);
}
