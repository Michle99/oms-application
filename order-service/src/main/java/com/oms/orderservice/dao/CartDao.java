package com.oms.orderservice.dao;

import com.oms.orderservice.model.Cart;

public interface CartDao {

	Cart findBy(Long idCart);
	Long save(Cart cart);
	void update(Cart cart);
	
}
