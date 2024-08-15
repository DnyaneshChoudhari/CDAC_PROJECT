package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.PaymentService;
import com.razorpay.RazorpayException;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/payments")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@PostMapping("/create-order")
	public ResponseEntity<String> createOrder(@RequestParam("amount") Double amount, @RequestParam("currency") String currency) {
		try {
			String order = paymentService.createOrder(amount, currency);
			return ResponseEntity.ok(order);
		} catch (RazorpayException e) {
			return ResponseEntity.status(500).body("Error creating Razorpay order: " + e.getMessage());
		}
	}

	@PostMapping("/success")
	public ResponseEntity<String> paymentSuccess(@RequestParam String razorpayPaymentId,
			@RequestParam String razorpayOrderId, @RequestParam String razorpaySignature) throws RazorpayException {
		// Verify payment success
		paymentService.handlePaymentSuccess(razorpayPaymentId, razorpayOrderId, razorpaySignature);
		return ResponseEntity.ok("Payment successful");
	}
}