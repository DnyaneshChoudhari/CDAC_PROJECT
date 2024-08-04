package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.entities.Order;

public interface OrderService {

	 List<Order> getAllOrdersByCustomer(Long cid);
	 
	 List<Order> getAllOrdersByStatus(String status);
	 
	 List<Order> getAllOrders();
	 
	 Order getOrderById(Long id);
	 
	 Order createOrder(Order Order);
	 
	 Order updateOrder(Order Order);
	 
	 String deleteOrder(Long id);
}
