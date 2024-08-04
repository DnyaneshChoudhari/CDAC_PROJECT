package com.app.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Order;
import com.app.entities.Otp;
import com.app.repository.OrderRepository;
import com.app.repository.OtpRepository;
import com.app.service.OtpService;
@Service
@Transactional
public class OtpServiceImpl implements OtpService {
	
	@Autowired
	private OtpRepository otpRepository;
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Otp getOtpById(Long id) {
		return otpRepository.findById(id).orElseThrow();
	}

	@Override
	public Otp getOtpByOrderId(Long oid) {
		Order order = orderRepository.findById(oid).orElseThrow();
		return otpRepository.findByOrder(order).orElseThrow();
	}

	@Override
<<<<<<< HEAD
	public Otp createOtp(Otp otp) {		
		return otpRepository.save(otp);
=======
	public Otp createOtp(Otp otp) {
		// TODO Auto-generated method stub
		return null;
>>>>>>> 2922e6c5dfbf606ffd3bff99206e4b321894f685
	}

}
