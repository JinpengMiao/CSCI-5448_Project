package com.Magazine.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;

import com.Magazine.View.CustomerActionForm;

/**
 * @author jinpeng
 * buy the magazines and decorators in the shopping cart
 * remove the entities from shopping cart database and add them to order history database
 *  strategy pattern: based on the membership levels(gold, silver, ordinary), discount differently(20% off, 10% off, no discount)
 */
public class BuyController {
	private int userid;
	/**
	 * @param uid int value, point to a specific user
	 */
	public BuyController(int uid) {
		this.userid = uid;
		//Strategy Pattern & Simple Factory Pattern: discount based on membership level(Gold, Silver, Ordinary)
		try{
	    	Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC","ralphie", "buffalo");
	    	PreparedStatement preparedStmt = myConnection.prepareStatement("SELECT level FROM users where userid=?");
    		preparedStmt.setInt (1,userid);
            ResultSet rs=preparedStmt.executeQuery();
    		while(rs.next()) {
    			String level= rs.getString(1);
    			double price = 0;//total price
    			
    			//add check-out magazines to purchase history 
    			PreparedStatement preparedStmt2 = myConnection.prepareStatement("SELECT magazine_type, magazine_name, magazine_date, decorator, magazine_price FROM shopping_cart where userid=?");
        		preparedStmt2.setInt (1,userid);
                ResultSet rs2=preparedStmt2.executeQuery();
        		while(rs2.next()) {
        			String magType= rs2.getString(1);
        			String magName= rs2.getString(2);
        			String magDate= rs2.getString(3);
        			
        			String decorator= rs2.getString(4);        			
        			String[] r = decorator.split("(?=[A-Z])");
        			StringBuilder sb=new StringBuilder();
       	         	for(int i=0;i<r.length;i++){    
       	             if(i>0)    
       	                 sb.append(",");    
       	             sb.append(r[i]);    
       	         	}
       	         	String deco = sb.toString();
       	         	
       	         	Double price1= rs2.getDouble(5);
       	         	
       	         	//strategy pattern
       	         	PriceContext priceContext = new PriceContext(level); 			
       	         	double totalPrices = priceContext.getReslt(price1);
       	         	DecimalFormat df = new DecimalFormat("#.00");
       	         	String totalPrice = df.format(totalPrices);
       	         	double value = Double.valueOf(totalPrice.toString());
       	         	price += value;      	         	    	         	
       	         	
        			PreparedStatement Pstatement3=myConnection.prepareStatement("insert into purchase_history (magazine_type, magazine_name, magazine_date, decorator, magazine_price, userid)" + " values (?, ?, ?, ?, ?, ?)"); 
        			Pstatement3.setString(1,magType);
        			Pstatement3.setString(2,magName);
        			Pstatement3.setString(3,magDate);
        			Pstatement3.setString(4,deco);   		        
    		        Pstatement3.setDouble(5,value);
    		        Pstatement3.setInt(6,userid);
    		        Pstatement3.executeUpdate();
        		}
        		
        		
        		//delete check-out magazines from shopping cart
    			PreparedStatement preparedStmt6 = myConnection.prepareStatement("delete from shopping_cart where userid=?");
    			preparedStmt6.setInt (1,userid);
    			preparedStmt6.execute();			
    			
    			new CustomerActionForm(uid);
    			JOptionPane.showMessageDialog(null, "Pay Successfully!!" + "  Your membership level is: " + level + ".  Thank you for your payment: " + price + "$");    			
	        }
		}
		catch (Exception ex)
	    {
	        ex.printStackTrace();
	    }
	}

}
