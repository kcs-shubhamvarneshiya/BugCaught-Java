package com.example.demo.mailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class mailSenderService {

	@Autowired
	private JavaMailSender mailsender;
	
	public void sendSimpleMail(String toEmail,String body,String subject)
	{
		System.out.println("Mail Called!!");
		SimpleMailMessage mailMessage=new SimpleMailMessage();
		
		mailMessage.setFrom("semicolon.webhelp@gmail.com");
		mailMessage.setTo(toEmail);
		mailMessage.setText(body);
		mailMessage.setSubject(subject);
		
		mailsender.send(mailMessage);
		System.out.println("Email Send SuccessFully !!");
	}
}
