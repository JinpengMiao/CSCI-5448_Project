package com.Magazine.Controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.JOptionPane;

import com.Magazine.View.Login;
import com.Magazine.View.Register;

public class RegisterController{
	private String passwordText1, passwordText2, usernameText, emailText, phoneNumText, addressText;
	public RegisterController(String password1, String password2, String username, String email, String phoneNum, String address) {
		this.passwordText1 = password1;
		this.passwordText2 = password2;
		this.usernameText = username;
		this.emailText = email;
		this.phoneNumText = phoneNum;
		this.addressText = address;	
		
	    try {
	        //Creating Connection Object
	        Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC","ralphie","buffalo");
	        //Prepared Statement
	        PreparedStatement Pstatement=connection.prepareStatement("insert into users (username, password, salt, email, phone_number, mailing_address)" + " values (?, ?, ?, ?, ?, ?)");
	        //Checking for the Password match
	        if(passwordText1.equalsIgnoreCase(passwordText2))
	        {
	            //Improve password security using SHA256 algorithms with salt
	        	byte[] salt = getSalt();
	            String securePassword = SHA_256(passwordText1, salt);
	         
	            //Specifying the values of it's parameter
	            Pstatement.setString(1,usernameText);
	            Pstatement.setString(2,securePassword);
	            Pstatement.setBytes(3,salt);
	            Pstatement.setString(4,emailText);
	            Pstatement.setString(5,phoneNumText);
	            Pstatement.setString(6,addressText);                  
	            //Executing query
	            Pstatement.executeUpdate();
	            //Redirect to Login Page
				new Login();
	            JOptionPane.showMessageDialog(null,"Registered Successfully");
	        }
	        else
	        {
	            JOptionPane.showMessageDialog(null,"password did not match");
	            new Register();
	        }
	    }catch (SQLException e1) {
            e1.printStackTrace();
        } catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
