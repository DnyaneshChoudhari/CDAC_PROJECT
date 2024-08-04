package com.app.service.Impl;

import java.util.List;
import java.util.Optional;

import com.app.entities.Order;
import com.app.service.OrderService;

public class OrderServiceImpl implements OrderService {

	@Override
	public List<Order> getAllOrdersByCustomer(Long cid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getAllOrdersByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Order> getOrderById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Order createOrder(Order Order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order updateOrder(Order Order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteOrder(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
