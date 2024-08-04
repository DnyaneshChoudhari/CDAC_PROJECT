package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.entities.Delivery_Person;

public interface DeliveryPersonService {
	
	List<Delivery_Person> getAllDeliveryPerson();
	
	Optional<Delivery_Person> getDeliverpersonById(Long id);
	
	Delivery_Person addNewDeliverperson(Delivery_Person delivery_Person);
	 
	Delivery_Person updateDeliverperson(Delivery_Person delivery_Person);
	 
	 String deleteDeliverperson(Long id);
	

}
