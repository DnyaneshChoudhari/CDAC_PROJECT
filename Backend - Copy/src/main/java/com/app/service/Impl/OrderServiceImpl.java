package com.app.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.CustomException;
import com.app.entities.Customer;
import com.app.entities.Order;
import com.app.entities.OrderStatus;
import com.app.repository.CustomerRepository;
import com.app.repository.OrderRepository;
import com.app.service.OrderService;
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<Order> getAllOrdersByCustomer(Long cid) {
		Customer customer = customerRepository.findById(cid).orElseThrow();		
		return orderRepository.findAllByCustomer(customer);
	}

	@Override
	public List<Order> getAllOrdersByStatus(String status) {
		OrderStatus orderStatus = OrderStatus.valueOf(status);
		return orderRepository.findAllByStatus(orderStatus);
	}

	@Override
	public List<Order> getAllOrders() {		
		return orderRepository.findAll();
	}

	@Override
	public Order getOrderById(Long id) {		
		return  orderRepository.findById(id).orElseThrow();
	}

	@Override
	public Order createOrder(Order order) {				
		return orderRepository.save(order);
	}

	@Override
	public Order updateOrder(Order updatedOrder) {
		return orderRepository.save(updatedOrder);
	}

	@Override
	public String deleteOrder(Long id) {
		if(orderRepository.existsById(id)) {
		orderRepository.deleteById(id);
		return "order deleted";
		}
		throw new CustomException("order not deleted");
		
	}

}
