package com.Magazine.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author jinpeng
 * returning all the magazine information in the shopping cart, which is achieved with JTable
 */
public class ShoppingCartController {
	private int userid;
	/**
	 * @param uid int value point to a specific user
	 */
	public ShoppingCartController(int uid) {
		this.userid = uid;
	}
	/**
	 * @return rows 2d array: retrieve magazine information from shopping cart database and return them to the magazine view
	 */
	public String[][] returnMagazine(){
    try{
    	ArrayList <String> magazinesType = new ArrayList<>();
    	ArrayList <String> magazinesName = new ArrayList<>();
    	ArrayList <String> magazinesDate = new ArrayList<>();
    	ArrayList <String> magazinesDecorator = new ArrayList<>();
    	ArrayList <String> magazinesPrice = new ArrayList<>();

    	Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC","ralphie", "buffalo");
    	PreparedStatement preparedStmt = myConnection.prepareStatement("SELECT count(*) FROM shopping_cart where userid=?");
    	preparedStmt.setInt (1,userid);
        ResultSet rs=preparedStmt.executeQuery();       
        while(rs.next()) {
        	int rowNum = rs.getInt(1);        
        	String[][] rows = new String[rowNum][5];
        	PreparedStatement preparedStmt1 = myConnection.prepareStatement("SELECT magazine_type, magazine_name, magazine_date, decorator, magazine_price FROM shopping_cart where userid=?");
         	preparedStmt1.setInt (1,userid);
            ResultSet rs1=preparedStmt1.executeQuery();
    		while(rs1.next()) {
    			String type = rs1.getString(1);
    			magazinesType.add(type);
    			
    			String name = rs1.getString(2);
    			magazinesName.add(name);
    			
    			String date = rs1.getString(3);
    			magazinesDate.add(date);
    			
    			String decorator = rs1.getString(4);
    			String[] r = decorator.split("(?=[A-Z])");
    			StringBuilder sb=new StringBuilder();    
    	         for(int i=0;i<r.length;i++){    
    	             if(i>0)    
    	                 sb.append(",");    
    	             sb.append(r[i]);    
    	         }
    	        String deco = sb.toString();
    			magazinesDecorator.add(deco);
    			
    			double price = rs1.getDouble(5);
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
}}
