package com.app.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Customer;
import com.app.entities.Order;
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
		
		return null;
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
