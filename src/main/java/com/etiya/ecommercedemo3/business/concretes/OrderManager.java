package com.etiya.ecommercedemo3.business.concretes;

import com.etiya.ecommercedemo3.business.abstracts.InvoiceService;
import com.etiya.ecommercedemo3.business.abstracts.OrderService;
import com.etiya.ecommercedemo3.business.constants.Messages;
import com.etiya.ecommercedemo3.business.dtos.request.invoice.AddInvoiceRequest;
import com.etiya.ecommercedemo3.business.dtos.request.order.AddOrderRequest;
import com.etiya.ecommercedemo3.business.dtos.response.cartDetail.GetCartDetailResponse;
import com.etiya.ecommercedemo3.business.dtos.response.order.AddOrderResponse;
import com.etiya.ecommercedemo3.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo3.core.util.results.DataResult;
import com.etiya.ecommercedemo3.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemo3.entities.concretes.*;
import com.etiya.ecommercedemo3.repository.abstracts.OrderRepository;
import com.etiya.ecommercedemo3.repository.abstracts.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderManager implements OrderService {
    private OrderRepository orderRepository;
    private ModelMapperService modelMapperService;
    private InvoiceService invoiceService;
    private ProductRepository productRepository;

    @Override
    @Transactional
    public DataResult<AddOrderResponse> addOrder(AddOrderRequest addOrderRequest) {
        Order order=modelMapperService.getMapperRequest().map(addOrderRequest, Order.class);
        Order savedOrder = orderRepository.save(order);

        AddOrderResponse response=modelMapperService.getMapperResponse().map(savedOrder,AddOrderResponse.class);
        order.setOrderDate(LocalDate.now());
        order.setOrderNumber(String.valueOf(randomNumberGenerate()));
        List<Product> products=orderRepository.getProductsAtOrderWithCartId(addOrderRequest.getCartId());
        List<GetCartDetailResponse> getCartDetailResponse=new ArrayList<>();
        for(Product product:products)
        {
            getCartDetailResponse.add(new GetCartDetailResponse(product.getId(),addOrderRequest.getCartId()));
        }


        List<CartDetail> productCarts=getCartDetailResponse.stream().map(getGetCartDetailResponse-> this.modelMapperService.getMapperResponse().map(getCartDetailResponse, CartDetail.class)).collect(Collectors.toList());

        addInvoice(savedOrder);

        return new SuccessDataResult<AddOrderResponse>(response, Messages.Order.orderAddSuccessMessage);
    }

    private void addInvoice(Order savedOrder) {
        Invoice invoice = new Invoice();
        invoice.setOrder(savedOrder);
        invoice.setInvoiceNumber(String.valueOf(randomNumberGenerate()));
        invoice.setInvoiceDate(LocalDate.now());
        AddInvoiceRequest addInvoiceRequest = modelMapperService.getMapperRequest().map(invoice, AddInvoiceRequest.class);
        this.invoiceService.addInvoice(addInvoiceRequest);
    }

    private static int randomNumberGenerate() {
        Random random = new Random();
        int invoiceNumber = random.nextInt(10000) + 1;
        return invoiceNumber;
    }

    @Override
    public List<Product> getProductsAtOrderWithCartId(int identity) {
        return orderRepository.getProductsAtOrderWithCartId(identity);
    }

}
