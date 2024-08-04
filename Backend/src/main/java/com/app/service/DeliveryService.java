package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.entities.Delivery;

public interface DeliveryService {

	 List<Delivery> getAllDeliveries();
	 
	 Optional<Delivery> getDeliveryById(Long id);
	 
	 Optional<Delivery> getDeliveryByOrderId(Long oid);
	 
	 Delivery createDelivery(Delivery Delivery);
	 
	 Delivery updateDelivery(Delivery Delivery);
	 
	 String deleteDelivery(Long id);
}
