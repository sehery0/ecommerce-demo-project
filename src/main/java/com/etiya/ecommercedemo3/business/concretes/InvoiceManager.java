package com.etiya.ecommercedemo3.business.concretes;

import com.etiya.ecommercedemo3.business.abstracts.InvoiceService;
import com.etiya.ecommercedemo3.business.constants.Messages;
import com.etiya.ecommercedemo3.business.dtos.request.invoice.AddInvoiceRequest;
import com.etiya.ecommercedemo3.business.dtos.response.invoice.AddInvoiceResponse;
import com.etiya.ecommercedemo3.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo3.core.util.results.DataResult;
import com.etiya.ecommercedemo3.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemo3.entities.concretes.Invoice;
import com.etiya.ecommercedemo3.repository.abstracts.InvoiceRepository;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InvoiceManager implements InvoiceService {
    private InvoiceRepository invoiceRepository;
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<AddInvoiceResponse> addInvoice(AddInvoiceRequest addInvoiceRequest) {
        Invoice invoice = modelMapperService.getMapperRequest().map(addInvoiceRequest, Invoice.class);
        Invoice savedInvoice = invoiceRepository.save(invoice);
        AddInvoiceResponse response = modelMapperService.getMapperResponse().map(savedInvoice, AddInvoiceResponse.class);
        return new SuccessDataResult<AddInvoiceResponse>(response, Messages.Invoice.invoiceAddSuccessMessage);
    }
}
