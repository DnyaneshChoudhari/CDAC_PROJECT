package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Delivery;
import com.app.service.DeliveryService;
import com.app.service.OrderService;


@RestController
@RequestMapping("/api/deliveries")
public class DeliveryController {
	
	@Autowired
	private DeliveryService deliveryService;
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/")
	public String postMethodName(@RequestBody Long oid) {
		
		Delivery delivery = deliveryService.createDelivery(orderService.getOrderById(oid));
		return "Delivery created"+ delivery.getId();
	}
	

}
