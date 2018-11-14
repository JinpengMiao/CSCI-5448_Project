package com.Magazine.Controller;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class CustomerObserver implements MagazineObserver {

	private String magazineName;
	private String magazineDate;
	private String email;
	
	public CustomerObserver(String email) {
        this.email = email;
    }

	@Override
	public void update(String magazineName, String magazineDate) {
		this.magazineName = magazineName;
		this.magazineDate = magazineDate;
		sendEmail();
	}

	private void sendEmail() {
		String to = email;
	    String from = "Jinpeng.miao@colorado.edu";
	    String host = "localhost";
	    Properties properties = System.getProperties();
	    properties.setProperty("mail.smtp.host", host);
	    Session session = Session.getDefaultInstance(properties);
	    try {
	         MimeMessage message = new MimeMessage(session);
	         message.setFrom(new InternetAddress(from));
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	         message.setSubject("New Magzine Arrival!");
	         message.setText("Welcome to order new magazine: " + "Name: " + magazineName + "Release Date:" + magazineDate);
	         String server = "smtp.163.com";
	         String username = "";
	         String password = "";
	         		
	         Transport transport = session.getTransport();
	         transport.connect(server, username, password);
	         Transport.send(message);
	         System.out.println("Sent message to " + email + "successfully!");
	      } catch (MessagingException mex) {
	         mex.printStackTrace();
	      }	
	}
}
