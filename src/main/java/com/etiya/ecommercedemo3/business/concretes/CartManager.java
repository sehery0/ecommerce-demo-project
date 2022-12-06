package com.etiya.ecommercedemo3.business.concretes;

import com.etiya.ecommercedemo3.business.abstracts.CartService;
import com.etiya.ecommercedemo3.business.dtos.request.cart.AddCartRequest;
import com.etiya.ecommercedemo3.business.dtos.response.cart.AddCartResponse;
import com.etiya.ecommercedemo3.entities.concretes.Cart;
import com.etiya.ecommercedemo3.repository.abstracts.CartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CartManager implements CartService {
    private CartRepository cartRepository;

    @Override
    public AddCartResponse addCart(AddCartRequest addCartRequest) {
        Cart cart = new Cart();
        cart.setTotalPrice(addCartRequest.getTotalPrice());
        Cart savedCart = cartRepository.save(cart);
        AddCartResponse response = new AddCartResponse(savedCart.getId(), savedCart.getTotalPrice());
        return response;
    }
}
