package com.app.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.CustomException;
import com.app.entities.Customer;
import com.app.entities.Order;
import com.app.entities.OrderStatus;
import com.app.entities.Order_Item;
import com.app.entities.Product;
import com.app.repository.CustomerRepository;
import com.app.repository.OrderRepository;
import com.app.repository.ProductRepository;
import com.app.service.OrderService;
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
//	@Autowired
	//private OrderItemService itemService;
	
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
		
		if (order.getCustomer() != null && order.getCustomer().getId() != null) {
            Customer customer = customerRepository.findById(order.getCustomer().getId()).orElse(null);
            order.setCustomer(customer);
        }

        // Ensure products exist and set in order items
        for (Order_Item item : order.getItems()) {
            if (item.getProduct() != null && item.getProduct().getId() != null) {
                Product product = productRepository.findById(item.getProduct().getId()).orElse(null);
                item.setProduct(product);
            }
            item.setOrder(order);
            //itemService.createOrderItem(item);            
        }

        return orderRepository.save(order);
    }
		
	

	@Override
	public Order updateOrder(Long oid,Order updatedOrder) {
		if(orderRepository.existsById(oid)) {
			return orderRepository.save(updatedOrder);
		}
		throw new CustomException("order not found");
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
