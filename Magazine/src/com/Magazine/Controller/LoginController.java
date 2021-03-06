package com.Magazine.Controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.Magazine.View.AdminActionForm;
import com.Magazine.View.CustomerActionForm;
import com.Magazine.View.Login;
import com.Magazine.View.Register;

/**
 * @author jinpeng
 * check if the customer has an acount with the username and password typed by customers
 */
public class LoginController {
	private String usernameText, passwordText;
	/**
	 * @param username String value user name
	 * @param password String value user password
	 */
	public LoginController(String username, String password) {
		this.passwordText = password;
		this.usernameText = username;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC","ralphie", "buffalo");
            PreparedStatement preparedStmt = myConnection.prepareStatement("select userid, password, salt from users where username=?");
            preparedStmt.setString (1,username);
            ResultSet rs=preparedStmt.executeQuery();
			if(rs.next()) {
				int uid = rs.getInt(1);
            	String pass = rs.getString(2);
            	byte[] salt1 = rs.getBytes(3);
            	String securePass = SHA_256(password, salt1);
            	if(securePass.equals(pass)) {
            		if(uid == 1) //admin
            		{	
            			new AdminActionForm();
                        JOptionPane.showMessageDialog(null, "Login Successfully!");
                    }
                    else //user is customer
                    {
                    	new CustomerActionForm(uid);
                        JOptionPane.showMessageDialog(null, "Login Successfully!");
                    }
				}
            	else {
            		JOptionPane.showMessageDialog(null, "invalid username or password");
            		new Login();
            	}               	
            }  
			else
            {
                JOptionPane.showMessageDialog(null, "You do not have an account. Please create one first!");
                new Register();
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
	/**
     * @param password String value the passoword stored in the user database
     * @param salt String value salt stored in the user database
     * @return String value returning a final password to be stored in the database
     */
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
}
