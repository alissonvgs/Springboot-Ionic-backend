package com.alissonvgs.services;

import org.springframework.mail.SimpleMailMessage;

import com.alissonvgs.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);

}
