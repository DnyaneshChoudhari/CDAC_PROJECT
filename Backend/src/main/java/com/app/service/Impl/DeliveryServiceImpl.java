package com.app.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.CustomException;
import com.app.entities.Delivery;
import com.app.entities.Order;
import com.app.repository.DeliveryRepository;
import com.app.repository.OrderRepository;
import com.app.service.DeliveryService;

@Service
@Transactional
public class DeliveryServiceImpl implements DeliveryService {

	@Autowired
	private DeliveryRepository deliveryRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public List<Delivery> getAllDeliveries() {
		return deliveryRepository.findAll();
	}

	@Override
	public Delivery getDeliveryById(Long id) {
		Optional<Delivery> optional = deliveryRepository.findById(id);
		return optional.orElseThrow(()->new CustomException("Invalid Delivery Id"));
	}

	@Override
	public Delivery getDeliveryByOrderId(Long oid) {
		Order order = orderRepository.findById(oid).orElseThrow();
		return deliveryRepository.findByOrder(order).orElseThrow();
		
	}

	@Override
	public Delivery createDelivery(Delivery delivery) {
		return deliveryRepository.save(delivery);
	}

	@Override
	public Delivery updateDelivery(Delivery delivery) {
		return deliveryRepository.save(delivery);
	}

	@Override
	public String deleteDelivery(Long id) {
		if(deliveryRepository.existsById(id)) {
			deliveryRepository.deleteById(id);
			return "Delivey Deleted";
		}
		throw new CustomException("Deletion operation of delivery failed");
	}

}
