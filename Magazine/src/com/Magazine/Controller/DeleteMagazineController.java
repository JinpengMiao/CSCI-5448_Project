package com.Magazine.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.Magazine.View.AdminActionForm;
import com.Magazine.View.DeleteCustomer;

/**
 * @author jinpeng
 * delete magazine with name and release date from magazine datebase
 */
public class DeleteMagazineController {
	private String magazineNameText, magazineDateText;
	/**
	 * @param magazineName String value magazine name
	 * @param magazineDate String value magazine release date
	 */
	public DeleteMagazineController(String magazineName, String magazineDate) {
		this.magazineNameText = magazineName;
		this.magazineDateText = magazineDate;
		
	    try {
            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC","ralphie", "buffalo");
            PreparedStatement preparedStmt1 = myConnection.prepareStatement("select * from magazineName where name=?");
            preparedStmt1.setString (1,magazineNameText);
            ResultSet rs1=preparedStmt1.executeQuery();
            PreparedStatement preparedStmt2 = myConnection.prepareStatement("select dateid from magazineDate where date=?");
            preparedStmt2.setString (1,magazineDateText);
            ResultSet rs2=preparedStmt2.executeQuery();
			if(rs1.next() & rs2.next()) {
				int dateid = rs2.getInt(1);
	            PreparedStatement preStmt1 = myConnection.prepareStatement("delete from magazineDate where dateid=?");
	            preStmt1.setInt (1,dateid);
	            preStmt1.execute();
	            PreparedStatement preStmt2 = myConnection.prepareStatement("delete from magazineInfo where dateid=?");
	            preStmt2.setInt (1,dateid);
	            preStmt2.execute();
	            new AdminActionForm();
	            JOptionPane.showMessageDialog(null, "Delete Successfully");
            }  
			else
            {
                JOptionPane.showMessageDialog(null, "The username does not exists, please try again!");
                new AdminActionForm();
            }
	    }catch (SQLException e1) {
            e1.printStackTrace();
        }	
	}
}
