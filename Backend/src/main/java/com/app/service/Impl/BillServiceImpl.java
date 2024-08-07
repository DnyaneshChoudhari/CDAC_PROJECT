
package com.app.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Bill;
import com.app.entities.Order;
import com.app.repository.BillRepository;
import com.app.repository.OrderRepository;
import com.app.service.BillService;

@Service
@Transactional
public class BillServiceImpl implements BillService {

	@Autowired
	private BillRepository billRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Bill generateBill(Bill bill) {

		return billRepository.save(bill);
	}

	@Override
	public Bill getBillByOrderId(Long id) {
		Order order = orderRepository.findById(id).orElseThrow();
		return billRepository.findByOrder(order);
	}

	@Override
	public Bill getBillById(Long id) {

		return billRepository.findById(id).orElseThrow();
	}

}
