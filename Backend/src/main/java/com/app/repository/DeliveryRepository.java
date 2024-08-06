package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Delivery;
import com.app.entities.Order;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
	Optional<Delivery> findByOrder(Order order);
}
