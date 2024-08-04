package com.app.service;

import java.util.Optional;

import com.app.entities.Order;
import com.app.entities.Otp;

public interface OtpService {
 Optional<Otp> getOtpById(Long id);
 
 Optional<Otp> getOtpByOrderId(Long oid);
	 
	 Order createOtp(Otp otp);
}
