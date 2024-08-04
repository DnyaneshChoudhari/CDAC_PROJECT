package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Order_Item;

public interface OrderItemRepository extends JpaRepository<Order_Item, Long> {

}
