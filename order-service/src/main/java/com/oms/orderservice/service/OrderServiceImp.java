package com.oms.orderservice.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oms.orderservice.dao.CartDao;
import com.oms.orderservice.dao.OrderDao;
import com.oms.orderservice.dao.ProductDao;
import com.oms.orderservice.model.Cart;
import com.oms.orderservice.model.LineItem;
import com.oms.orderservice.model.Product;
import com.oms.orderservice.util.OrderStatus;
import com.oms.orderservice.model.Order;
import com.oms.orderservice.model.Order.BuilderOrder;

@Service
@Transactional
public class OrderServiceImp implements OrderService {

	@Autowired
	CartDao cartDao;

	@Autowired
	ProductDao productDao;
	
	@Autowired
	OrderDao orderDao;

	@Override
	public Long save(Cart cart) {
		return cartDao.save(cart);
	}

	@Override
	public void add(Long idCart, Long idProduct, Integer quantity) {
		Cart cart = cartDao.findBy(idCart);
		Product product = productDao.findBy(idProduct);
		cart.getLinesItems().add(new LineItem(cart, product, quantity, product.getPrice()));
		cartDao.update(cart);
	}

	@Override
	public Long ordered(Long idCart) {
		Cart cart = cartDao.findBy(idCart);
		Order order = new BuilderOrder()
				.setCustomer(cart.getCustomer())
				.setOrdered(new Date())
				.setStatus(OrderStatus.NEW.toString())
				.setTotal(cart.calculateTotal())
				.setLinesItems(cart.getLinesItems())
				.build();
		return orderDao.save(order);
	}

}
