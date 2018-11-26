package com.Magazine.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @author jinpeng
 * returning all the magazine information to the magazine view, which is achieved with JTable
 */
public class AllMagazinesController {

	/**
	 * @return rows 2d array: retrieve magazine information from database and return them to the magazine view
	 */
	public String[][] returnMagazine(){{
    try{
    	ArrayList <String> magazinesType = new ArrayList<>();
    	ArrayList <String> magazinesName = new ArrayList<>();
    	ArrayList <String> magazinesDate = new ArrayList<>();
    	ArrayList <String> magazinesPrice = new ArrayList<>();

    	Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC","ralphie", "buffalo");
        PreparedStatement preparedStmt = myConnection.prepareStatement("SELECT count(*) FROM magazineInfo");
        ResultSet rs=preparedStmt.executeQuery();       
        while(rs.next()) {
        	int rowNum = rs.getInt(1);        
        	String[][] rows = new String[rowNum][4];
            PreparedStatement preparedStmt1 = myConnection.prepareStatement("SELECT typeid, type FROM magazineType");
            ResultSet rs1=preparedStmt1.executeQuery();
    		while(rs1.next()) {
    			int typeid = rs1.getInt(1);
            	String type = rs1.getString(2); 
            	PreparedStatement preparedStmt2 = myConnection.prepareStatement("SELECT nameid, name FROM magazineName where typeid = ?");
            	preparedStmt2.setInt (1,typeid);
                ResultSet rs2=preparedStmt2.executeQuery();
                while(rs2.next()) {
                	int nameid = rs2.getInt(1);
                	String name = rs2.getString(2); 
                	PreparedStatement preparedStmt3 = myConnection.prepareStatement("SELECT dateid, date FROM magazineDate where nameid = ?");
                	preparedStmt3.setInt (1,nameid);
                    ResultSet rs3=preparedStmt3.executeQuery();  
                    while(rs3.next()) {
                    	int dateid = rs3.getInt(1);
                    	String date = rs3.getString(2);
                    	PreparedStatement preparedStmt4 = myConnection.prepareStatement("SELECT cover, price FROM magazineInfo where dateid = ?");
                    	preparedStmt4.setInt (1,dateid);
                        ResultSet rs4=preparedStmt4.executeQuery();
                        while(rs4.next()) {
                        	Double price = rs4.getDouble(2);
                        	String price1 = String.valueOf(price);                                           	
                        	magazinesType.add(type);
                        	magazinesName.add(name);
                        	magazinesDate.add(date);
                        	magazinesPrice.add(price1);
                        } 	
                    }
                }
            }  		
    	String[] typeArray = new String[magazinesType.size()];
    	magazinesType.toArray(typeArray);
    	String[] nameArray = new String[magazinesName.size()];
    	magazinesName.toArray(nameArray);
    	String[] dateArray = new String[magazinesDate.size()];
    	magazinesDate.toArray(dateArray);
    	String[] priceArray = new String[magazinesPrice.size()];
    	magazinesPrice.toArray(priceArray);
    	//convert to 2d array
    	for (int x = 0; x < rowNum; x++) {
    		    rows[x][0] = typeArray[x];
    		    rows[x][1] = nameArray[x];
    		    rows[x][2] = dateArray[x];
    		    rows[x][3] = priceArray[x];   		    		    
    	}
    	return rows;
        }      
    }
    catch (Exception ex)
    {
        ex.printStackTrace();
    }
	}
	return null;
}}
