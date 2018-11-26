package com.Magazine.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.Magazine.View.CustomerActionForm;

/**
 * @author jinpeng
 * add searched magazine and "decorators" to the shopping cart
 * "decorators" have their different prices.
 * when each decorator is selected, the corresponding price will be added to the total price 
 */
public class AddToCartController {
	private int userid;
	private String type, name, date, decorator;
	private double price;
	/**
	 * @param _userid int value user id which is lined with a specific user
	 * @param _type String value magazine type
	 * @param _name String value magazine name
	 * @param _date String value magazine date
	 * @param _decorator String value magazine decorators
	 */
	public AddToCartController(int _userid, String _type, String _name, String _date, String _decorator) {
		this.userid = _userid;
		this.type = _type;
		this.name = _name;
		this.date = _date;
		this.decorator = _decorator;
		
		//decorator pattern: add to total price
		AbstractMagazine magazine = new Magazine(name, date);
		
		if (decorator.indexOf("Gift card")!=-1){
			magazine = new GiftCard(magazine);
	   	}
		if (decorator.indexOf("Wrapping paper")!=-1){
			magazine = new WrappingPaper(magazine);
	   	}
		if (decorator.indexOf("Bookmark")!=-1){
			magazine = new Bookmark(magazine);
	   	}
		price = magazine.price();		
		
	try {
        //Creating Connection Object
        Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC","ralphie","buffalo");
        //Prepared Statement
        PreparedStatement Pstatement=connection.prepareStatement("insert into shopping_cart (magazine_type, magazine_name, magazine_date, decorator, magazine_price, userid)" + " values (?, ?, ?, ?, ?, ?)");
        Pstatement.setString(1,type);
        Pstatement.setString(2,name);
        Pstatement.setString(3,date);
        Pstatement.setString(4,decorator);
        Pstatement.setDouble(5,price);
        Pstatement.setInt(6,userid);                  
        //Executing query
        Pstatement.executeUpdate();
        //Redirect to Login Page
		new CustomerActionForm(userid);
        JOptionPane.showMessageDialog(null,"Add to Shopping Cart Successfully");
    }catch (SQLException e1) {
        e1.printStackTrace();
    } 	
   	
}}
