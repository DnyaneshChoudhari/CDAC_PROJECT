package com.app.service;

import com.app.entities.Otp;

public interface OtpService {
<<<<<<< HEAD
	Otp getOtpById(Long id);

	Otp getOtpByOrderId(Long oid);
=======
	Optional<Otp> getOtpById(Long id);

	Optional<Otp> getOtpByOrderId(Long oid);
>>>>>>> 2922e6c5dfbf606ffd3bff99206e4b321894f685

	Otp createOtp(Otp otp);
}


