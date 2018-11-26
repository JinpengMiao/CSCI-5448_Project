package com.Magazine.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @author jinpeng
 * returning all the magazine information in the order history, which is achieved with JTable
 */
public class OrderHistoryController {
	private int userid;
	/**
	 * @param uid int value point to a specific user
	 */
	public OrderHistoryController(int uid) {
		this.userid = uid;
	}
	/**
	 * @return rows 2d array: retrieve magazine information from order history database and return them to the magazine view
	 */
	public String[][] returnMagazine() {
		try{
	    	ArrayList <String> magazinesType = new ArrayList<>();
	    	ArrayList <String> magazinesName = new ArrayList<>();
	    	ArrayList <String> magazinesDate = new ArrayList<>();
	    	ArrayList <String> magazinesDecorator = new ArrayList<>();
	    	ArrayList <String> magazinesPrice = new ArrayList<>();

	    	Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC","ralphie", "buffalo");
	    	PreparedStatement preparedStmt = myConnection.prepareStatement("SELECT count(*) FROM purchase_history where userid=?");
	    	preparedStmt.setInt (1,userid);
	        ResultSet rs=preparedStmt.executeQuery();       
	        while(rs.next()) {
	        	int rowNum = rs.getInt(1);        
	        	String[][] rows = new String[rowNum][5];
	        	PreparedStatement preparedStmt1 = myConnection.prepareStatement("SELECT magazine_type FROM purchase_history where userid=?");
	        	preparedStmt1.setInt (1,userid);
	            ResultSet rs1=preparedStmt1.executeQuery();
	    		while(rs1.next()) {
	    			String type = rs1.getString(1);
	    			magazinesType.add(type);
	    		}
	    		PreparedStatement preparedStmt2 = myConnection.prepareStatement("SELECT magazine_name FROM purchase_history where userid=?");
	    		preparedStmt2.setInt (1,userid);
	            ResultSet rs2=preparedStmt2.executeQuery();
	    		while(rs2.next()) {
	    			String name = rs2.getString(1);
	    			magazinesName.add(name);
	    		}
	    		PreparedStatement preparedStmt3 = myConnection.prepareStatement("SELECT magazine_date FROM purchase_history where userid=?");
	    		preparedStmt3.setInt (1,userid);
	            ResultSet rs3=preparedStmt3.executeQuery();
	    		while(rs3.next()) {
	    			String date = rs3.getString(1);
	    			magazinesDate.add(date);
	    		}
	    		PreparedStatement preparedStmt4 = myConnection.prepareStatement("SELECT decorator FROM purchase_history where userid=?");
	    		preparedStmt4.setInt (1,userid);
	            ResultSet rs4=preparedStmt4.executeQuery();
	    		while(rs4.next()) {
	    			String decorator = rs4.getString(1);
	    			magazinesDecorator.add(decorator);
	    		}
	    		PreparedStatement preparedStmt5 = myConnection.prepareStatement("SELECT magazine_price FROM purchase_history where userid=?");
	    		preparedStmt5.setInt (1,userid);
	            ResultSet rs5=preparedStmt5.executeQuery();
	    		while(rs5.next()) {
	    			Double price = rs5.getDouble(1);
	            	String price1 = String.valueOf(price);
	            	magazinesPrice.add(price1);      	
	    		}		

	        	String[] typeArray = new String[magazinesType.size()];
	        	magazinesType.toArray(typeArray);
	        	String[] nameArray = new String[magazinesName.size()];
	        	magazinesName.toArray(nameArray);
	        	String[] dateArray = new String[magazinesDate.size()];
	        	magazinesDate.toArray(dateArray);
	        	String[] decoratorArray = new String[magazinesDecorator.size()];
	        	magazinesDecorator.toArray(decoratorArray);
	        	String[] priceArray = new String[magazinesPrice.size()];
	        	magazinesPrice.toArray(priceArray);
	        	
	        	//convert to 2d array
	        	for (int x = 0; x < rowNum; x++) {
	        		    rows[x][0] = typeArray[x];
	        		    rows[x][1] = nameArray[x];
	        		    rows[x][2] = dateArray[x];
						rows[x][3] = decoratorArray[x];
	        		    rows[x][4] = priceArray[x];   		    		    
	        	}
	        	return rows;    	
	        }       	 
	    }
	    catch (Exception ex)
	    {
	        ex.printStackTrace();
	    }	
		return null;
	}
}
