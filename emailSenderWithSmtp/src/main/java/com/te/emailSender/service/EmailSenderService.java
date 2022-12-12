package com.te.emailSender.service;

import javax.mail.MessagingException;

public interface EmailSenderService {

	public void emailSender(String toEmail, String subject,String body,String attachment) throws MessagingException;
}
