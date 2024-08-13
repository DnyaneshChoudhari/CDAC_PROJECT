package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Delivery;
import com.app.service.DeliveryService;
import com.app.service.OrderService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/deliveries")
public class DeliveryController {

	@Autowired
	private DeliveryService deliveryService;
	@Autowired
	private OrderService orderService;

	@PostMapping("/{oid}")
	public String postMethodName(@PathVariable Long oid) {

		Delivery delivery = deliveryService.createDelivery(orderService.getOrderById(oid));
		return "Delivery created" + delivery.getId();
	}

}
