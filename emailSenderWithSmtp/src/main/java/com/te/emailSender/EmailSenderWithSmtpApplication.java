package com.te.emailSender;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.te.emailSender.service.EmailSenderImpl;
import com.te.emailSender.service.EmailSenderService;

@SpringBootApplication
public class EmailSenderWithSmtpApplication {

	@Autowired
	private EmailSenderService senderService;
	
	public static void main(String[] args) {
		SpringApplication.run(EmailSenderWithSmtpApplication.class, args);
		
		}

	@EventListener(ApplicationReadyEvent.class)
	
	public void sendEmail() throws MessagingException {
		//senderService.emailSender(("vedanayaki.k@testyantra.in","Mail subject" , "mail with attachment","D:\\Desktop\\Vedanayaki K_TYResume.docx"),("shermivijay@gmail.com,","Mail subject" , "mail with attachment","D:\\Desktop\\Vedanayaki K_TYResume.docx"));
		senderService.emailSender("vedanayaki.k@testyantra.in","Mail subject" , "mail with attachment","D:\\Desktop\\Vedanayaki K_TYResume.docx");
		senderService.emailSender("shermivijay@gmail.com,","Mail subject" , "mail with attachment","D:\\Desktop\\Vedanayaki K_TYResume.docx");
	}
}
