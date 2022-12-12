package com.te.emailSender.service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


@Service
public class EmailSenderImpl implements EmailSenderService{

	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void emailSender(String toEmail,  String body,String subject,String attachment) throws MessagingException {
			
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper= new MimeMessageHelper(message, true);
		mimeMessageHelper.setFrom("vedhaa20@gmail.com");
		mimeMessageHelper.setTo(toEmail);
		mimeMessageHelper.setText(body);
		mimeMessageHelper.setSubject(subject);
		
		FileSystemResource fileSystemResource= new FileSystemResource(new File(attachment));
		
		mimeMessageHelper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);
		
		mailSender.send(message);
		System.out.println("Mail attachment sent successfully");
		


//		
//		mailSender.send(message);
//		
//		System.out.println("Message sent successfully");
//		
	}
	
	
	
}
