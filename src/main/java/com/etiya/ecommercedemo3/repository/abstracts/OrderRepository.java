package com.etiya.ecommercedemo3.repository.abstracts;

import com.etiya.ecommercedemo3.entities.concretes.Order;
import com.etiya.ecommercedemo3.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query("select distinct p from Product as p inner join CartDetail as cd on " +
            "p=cd.product inner join Cart as c on cd.cart=c " +
            "inner join Order as o on o.cart=cd.cart where c.id in(:identity) ")
    List<Product> getProductsAtOrderWithCartId(int identity);
}
