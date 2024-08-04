package com.app.service.Impl;

import java.util.Random;

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
	
	private static final int OTP_LENGTH = 6;
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
		Random random  = new Random();
		StringBuilder otpcode = new StringBuilder();
		for(int i=0;i<OTP_LENGTH;i++) {
			otpcode.append(random.nextInt(10));
		}
		otp.setOtp_code(otpcode.toString());		
=======

	public Otp createOtp(Otp otp) {		
>>>>>>> 1a79d9a9e16d117cf3c46a4bab12a2299cce1a2d
		return otpRepository.save(otp);
	}

}
