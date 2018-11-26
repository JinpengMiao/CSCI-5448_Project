package com.Magazine.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author jinpeng
 * a concrete class implements interface AbstractMagazine to achieve stategy pattern
 */
public class Magazine implements AbstractMagazine{

	private String name, date;
	/**
	 * @param _name String value magazine name
	 * @param _date String value magazine date
	 */
	public Magazine(String _name, String _date) {
		this.name = _name;	
		this.date = _date;
	}

	/* (non-Javadoc)
	 * @see com.Magazine.Controller.AbstractMagazine#price(): return price of the specific magazine
	 */
	public double price() {
		double price = 0;
		try{			
	    	Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC","ralphie", "buffalo");  	
	    	PreparedStatement preparedStmt1 = myConnection.prepareStatement("SELECT i.price from magazineName n, magazineDate d, magazineInfo i where n.nameid=d.nameid and d.dateid=i.dateid and n.name=? and d.date=?");
    		preparedStmt1.setString (1, name);
    		preparedStmt1.setString (2, date);
            ResultSet rs1=preparedStmt1.executeQuery();
    		while(rs1.next()) {
    			price= rs1.getDouble(1);
    		}
		}
		catch (Exception ex)
	    {
	        ex.printStackTrace();
	    }
		return price;
	}
}
