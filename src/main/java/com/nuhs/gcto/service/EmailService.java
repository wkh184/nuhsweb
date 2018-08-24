package com.nuhs.gcto.service;

import java.lang.invoke.MethodHandles;
import java.net.PasswordAuthentication;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailService {
	final static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	public static void sendMail(String subject, String content) {    
		final String username = "username@gmail.com";
		final String password = "password";

		logger.debug("SSLEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
		props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
		props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
		props.put("mail.smtp.port", "465"); //SMTP Port
		
		//TODO create authenticator
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication(username, password);
//			}
		};
		
		Session session = Session.getDefaultInstance(props, auth);
		logger.debug("Session created");

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("from-email@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("to-email@gmail.com"));
			message.setSubject(subject);
			message.setText(content);

			Transport.send(message);

			logger.debug("Done");

		} catch (MessagingException e) {
			logger.error("SSLEmail Exception", e);
			throw new RuntimeException(e);
		}
	}
}
