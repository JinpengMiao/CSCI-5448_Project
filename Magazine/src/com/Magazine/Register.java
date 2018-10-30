package com.Magazine;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.Arrays;
import java.util.Random;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
 
public class Register extends JFrame implements ActionListener {
    JLabel label, username, password, rePassword, email, phoneNumber, address;
    JTextField usernameText, emailText, phoneNumText, addressText;
    JButton register;
    JPasswordField passwordText1, passwordText2;

    Register()
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
        
        if(e.getSource()==register)
        {
            try {
                //Creating Connection Object
                Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC","ralphie","buffalo");
                //Prepared Statement
                PreparedStatement Pstatement=connection.prepareStatement("insert into users (username, password, salt, email, phone_number, mailing_address)" + " values (?, ?, ?, ?, ?, ?)");
                //Checking for the Password match
                if(passwordText1.getText().equalsIgnoreCase(passwordText2.getText()))
                {
                    //Improve password security using SHA256 algorithms with salt
                	byte[] salt = getSalt();
                    String securePassword = SHA_256(passwordText1.getText(), salt);
                 
                    //Specifying the values of it's parameter
                    Pstatement.setString(1,usernameText.getText());
                    Pstatement.setString(2,securePassword);
                    Pstatement.setBytes(3,salt);
                    Pstatement.setString(4,emailText.getText());
                    Pstatement.setString(5,phoneNumText.getText());
                    Pstatement.setString(6,addressText.getText());                  
                    //Executing query
                    Pstatement.executeUpdate();
                    //Redirect to Login Page
        			new Login();
        	        setVisible(false);
                    JOptionPane.showMessageDialog(null,"Registered Successfully");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"password did not match");
                    new Register();
        	        setVisible(false);
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            } catch (NoSuchAlgorithmException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
    }
    private static String SHA_256(String password, byte[] salt)
    {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return generatedPassword;
    }
    private static byte[] getSalt() throws NoSuchAlgorithmException
    {
        Random sr = new SecureRandom();
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }
}
