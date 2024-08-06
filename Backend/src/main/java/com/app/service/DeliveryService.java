package com.app.service;

import java.util.List;

import com.app.entities.Delivery;

public interface DeliveryService {

	 List<Delivery> getAllDeliveries();
	 
	 Delivery getDeliveryById(Long id);
	 
	 Delivery getDeliveryByOrderId(Long oid);
	 
	 Delivery createDelivery(Delivery delivery);
	 
	 Delivery updateDelivery(Delivery delivery);
	 
	 String deleteDelivery(Long id);
}
