package com.Magazine.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.Magazine.View.SearchWindow;

/**
 * @author jinpeng
 * returning the magazine information searched, which is achieved with JTable
 */
public class SearchMagazineController {
	private String magazineName, magazineDate;
	private int userid;
	/**
	 * @param userid int value point to a specific user
	 * @param magaName String value magazine name
	 * @param magaDate String value magazine release date
	 */
	public SearchMagazineController(int userid, String magaName, String magaDate) {
		this.userid = userid;
		this.magazineName = magaName;
		this.magazineDate = magaDate;		
	}
	/**
	 * @return rows 2d array: retrieve magazine information from magazine database and return it to the magazine view
	 */
	public String[][] returnMagazine() {
		try{
			ArrayList <String> magazinesType = new ArrayList<>();
	    	ArrayList <String> magazinesName = new ArrayList<>();
	    	ArrayList <String> magazinesDate = new ArrayList<>();
	    	ArrayList <String> magazinesPrice = new ArrayList<>();	    	
	    	
	    	Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC","ralphie", "buffalo");
	    	PreparedStatement preparedStmt1 = myConnection.prepareStatement("SELECT t.type, i.price from magazineType t, magazineName n, magazineDate d, magazineInfo i where t.typeid=n.typeid and n.nameid=d.nameid and d.dateid=i.dateid and n.name=? and d.date=?");
            preparedStmt1.setString (1,magazineName);
            preparedStmt1.setString (2,magazineDate);
            ResultSet rs1=preparedStmt1.executeQuery();
			if(rs1.next()) {
				String type = rs1.getString(1);
    			magazinesType.add(type);    			
    			Double price = rs1.getDouble(2);
    			String price1 = String.valueOf(price);
            	magazinesPrice.add(price1);   						
				magazinesName.add(magazineName);
				magazinesDate.add(magazineDate);
				String[] typeArray = new String[magazinesType.size()];
	        	magazinesType.toArray(typeArray);
	        	String[] nameArray = new String[magazinesName.size()];
	        	magazinesName.toArray(nameArray);
	        	String[] dateArray = new String[magazinesDate.size()];
	        	magazinesDate.toArray(dateArray);
	        	String[] priceArray = new String[magazinesPrice.size()];
	        	magazinesPrice.toArray(priceArray);
	        	
	        	String[][] rows = new String[1][4];
	        	//convert to 2d array
	        	for (int x = 0; x < 1; x++) {
	        		    rows[x][0] = typeArray[x];
	        		    rows[x][1] = nameArray[x];
	        		    rows[x][2] = dateArray[x];
	        		    rows[x][3] = priceArray[x];   		    		    
	        	}
	        	return rows;             
            }  
			else
            {
                JOptionPane.showMessageDialog(null, "The magazine does not exists, please try again!");
                new SearchWindow(userid);
            }    	 
		}
	    catch (Exception ex)
	    {
	        ex.printStackTrace();
	    }
		return null;
	}
}
