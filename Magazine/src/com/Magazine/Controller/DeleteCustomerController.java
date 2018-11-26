package com.Magazine.Controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.JOptionPane;

import com.Magazine.View.AdminActionForm;
import com.Magazine.View.DeleteCustomer;

/**
 * @author jinpeng
 * delete customers with the username
 */
public class DeleteCustomerController {
	private String usernameText;
	/**
	 * @param username String value: based on the username to delete the customer
	 */
	public DeleteCustomerController(String username) {
		this.usernameText = username;
		
	    try {
            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC","ralphie", "buffalo");
            PreparedStatement preparedStmt = myConnection.prepareStatement("select * from users where username=?");
            preparedStmt.setString (1,usernameText);
            ResultSet rs=preparedStmt.executeQuery();
			if(rs.next()) {
	            PreparedStatement preStmt = myConnection.prepareStatement("delete from users where username=?");
	            preStmt.setString (1,usernameText);
	            preStmt.execute();
	            new AdminActionForm();
	            JOptionPane.showMessageDialog(null, "Delete Successfully");
            }  
			else
            {
                JOptionPane.showMessageDialog(null, "The username does not exists, please try again!");
                new DeleteCustomer();
            }
	    }catch (SQLException e1) {
            e1.printStackTrace();
        }	
	}
}
