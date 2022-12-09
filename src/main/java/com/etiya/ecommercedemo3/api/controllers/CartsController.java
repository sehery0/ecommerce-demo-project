package com.etiya.ecommercedemo3.api.controllers;

import com.etiya.ecommercedemo3.business.abstracts.CartService;
import com.etiya.ecommercedemo3.business.constants.Paths;
import com.etiya.ecommercedemo3.business.dtos.request.cart.AddCartRequest;
import com.etiya.ecommercedemo3.business.dtos.request.country.AddCountryRequest;
import com.etiya.ecommercedemo3.business.dtos.response.cart.AddCartResponse;
import com.etiya.ecommercedemo3.business.dtos.response.country.AddCountryResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Paths.apiPrefix + "carts")
@AllArgsConstructor
public class CartsController {
    private CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<AddCartResponse> addCart(@RequestBody AddCartRequest addCartRequest)
    {
        return new ResponseEntity<AddCartResponse>(cartService.addCart(addCartRequest), HttpStatus.CREATED);
    }
}
