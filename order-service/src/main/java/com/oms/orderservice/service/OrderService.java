package com.oms.orderservice.service;

import com.oms.orderservice.model.Cart;

public interface OrderService {

	Long save(Cart cart);
	void add(Long idCart, Long idProduct, Integer quantity);
	Long ordered(Long idCart);

}
