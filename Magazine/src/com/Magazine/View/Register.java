package com.Magazine.View;

import javax.swing.*;

import com.Magazine.Controller.RegisterController;

import java.awt.event.*;
import java.awt.*;
 
public class Register extends JFrame implements ActionListener {
    JLabel label, username, password, rePassword, email, phoneNumber, address;
    JTextField usernameText, emailText, phoneNumText, addressText;
    JButton register;
    JPasswordField passwordText1, passwordText2;

    public Register()
    {
    	// set window size
        setSize(750, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Registration Page");
        
    	// set label
    	label = new JLabel("Magazine Retail");
        label.setForeground(Color.blue);
        label.setFont(new Font("Serif", Font.BOLD, 30)); 
        
        username = new JLabel("Username:");
        password = new JLabel("Password:");
        rePassword = new JLabel("Confirm Password:");
        email = new JLabel("Email:");
        phoneNumber = new JLabel("Phone Number:");
        address = new JLabel("Address");
        usernameText = new JTextField();
        passwordText1 = new JPasswordField();
        passwordText2 = new JPasswordField();
        emailText = new JTextField();
        phoneNumText = new JTextField();
        addressText = new JTextField();
        register = new JButton("Register");
    	
        register.addActionListener(this);
        
        // Setting position of GUI components
        label.setBounds(250, 100, 450, 40);    
        username.setBounds(200, 150, 200, 40);
        password.setBounds(200, 200, 200, 40);
        rePassword.setBounds(200, 250, 200, 40);
        email.setBounds(200, 300, 200, 40);
        phoneNumber.setBounds(200, 350, 200, 40);
        address.setBounds(200, 400, 200, 40);   
        usernameText.setBounds(380, 150, 200, 40);
        passwordText1.setBounds(380, 200, 200, 40);
        passwordText2.setBounds(380, 250, 200, 40);
        emailText.setBounds(380, 300, 300, 40);
        phoneNumText.setBounds(380, 350, 200, 40);
        addressText.setBounds(380, 400, 200, 40);       
        register.setBounds(380, 450, 150, 40);

        add(label);
        add(username);
        add(password);
        add(rePassword);
        add(email);
        add(phoneNumber);
        add(address);
        add(usernameText);
        add(emailText);
        add(phoneNumText);
        add(addressText);
        add(passwordText1);
        add(passwordText2);
        add(register);
        setVisible(true);      
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    	String password1 = passwordText1.getText();
    	String password2 = passwordText2.getText();
    	String username = usernameText.getText();
    	String email = emailText.getText();
    	String phoneNum = phoneNumText.getText();
    	String address = addressText.getText();
    	
        if(e.getSource()==register)
        {
        	new RegisterController(password1, password2, username, email, phoneNum, address);
        }
    }
}
