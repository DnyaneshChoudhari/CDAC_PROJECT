package com.app.service;

import java.util.List;

import com.app.entities.Delivery;
import com.app.entities.Order;

public interface DeliveryService {

	 List<Delivery> getAllDeliveries();
	 
	 Delivery getDeliveryById(Long id);
	 
	 Delivery getDeliveryByOrderId(Long oid);
	 
	 Delivery createDelivery(Order order);
	 
	 Delivery updateDelivery(Delivery delivery);
	 
	 String deleteDelivery(Long id);
	 
	 Delivery assignDeliveryPerson(Long deliveryPersonId, Long deliveryId);
	 
	 Boolean verifyOtp(Long orderId, String otpcode);
}
