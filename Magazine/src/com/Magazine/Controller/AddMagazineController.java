package com.Magazine.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import com.Magazine.View.AdminActionForm;

public class AddMagazineController {
	private String magaType, magaName, magaDate, magaPrice;
	private Double magaPrice1;
	public AddMagazineController(String magazineType, String magazineName, String magazineDate, String magazinePrice) {
		this.magaType = magazineType;
		this.magaName = magazineName;
		this.magaDate = magazineDate;
		this.magaPrice = magazinePrice;
		magaPrice1 = Double.parseDouble(magaPrice);		
	    try {
	        //Creating Connection Object
	        Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC","ralphie","buffalo");
	        //Prepared Statement
	        PreparedStatement Pstatement1=connection.prepareStatement("select typeid from magazineType where type=?");
	        Pstatement1.setString(1,magaType);
	        ResultSet rs1=Pstatement1.executeQuery();
	        //if type exists, do not add type, but fetch the typeid
	        if(rs1.next()) {
	        	int typeid = rs1.getInt(1);
	        	PreparedStatement Pstatement2=connection.prepareStatement("select nameid from magazineName where name=?");
		        Pstatement2.setString(1,magaName);
		        ResultSet rs2=Pstatement2.executeQuery();
		        //if name exists, do not add name, but fetch the nameid
		        if(rs2.next()) {
		        	int nameid = rs2.getInt(1);
		        	PreparedStatement Pstatement3=connection.prepareStatement("select * from magazineDate where date=?");
			        Pstatement3.setString(1,magaDate);
			        ResultSet rs3=Pstatement3.executeQuery();
			        //if date exists, do not add anything
			        if(rs3.next()) {
			        	new AdminActionForm();
				        JOptionPane.showMessageDialog(null,"The Magazine already exists!");
			        }
			        //date does not exist, add date, price
			        else {
			        	PreparedStatement Pstatement4=connection.prepareStatement("insert into magazineDate (date, nameid)" + " values (?, ?)"); 
				        Pstatement4.setString(1,magaDate);
				        Pstatement4.setInt(2,nameid);
				        Pstatement4.executeUpdate();
				        PreparedStatement Pstatement5=connection.prepareStatement("select dateid from magazineDate where date=?");
				        Pstatement5.setString(1,magaDate);
				        ResultSet rs5=Pstatement5.executeQuery();
				        if(rs5.next()) {
				        	int dateid = rs5.getInt(1);
				        	PreparedStatement Pstatement6=connection.prepareStatement("insert into magazineInfo (price, dateid)" + " values (?, ?)"); 
					        Pstatement6.setDouble(1,magaPrice1);
					        Pstatement6.setInt(2,dateid);
					        Pstatement6.executeUpdate();
					        updateToCustomer(magazineName, magazineDate);
					        //Redirect to admin Page
					        new AdminActionForm();
					        JOptionPane.showMessageDialog(null,"Add Successfully!");
				        }
			        }	        	
		        }
		        //name does not exist, add name, date, price
		        else {
		        	PreparedStatement Pstatement7=connection.prepareStatement("insert into magazineName (name, typeid)" + " values (?, ?)");  
			        Pstatement7.setString(1,magaName);
			        Pstatement7.setInt(2,typeid);
			        Pstatement7.executeUpdate();
			        PreparedStatement Pstatement8=connection.prepareStatement("select nameid from magazineName where name=?");
			        Pstatement8.setString(1,magaName);
			        ResultSet rs8=Pstatement8.executeQuery();
			        if(rs8.next()) {
			        	int nameid = rs8.getInt(1);
			        	PreparedStatement Pstatement9=connection.prepareStatement("insert into magazineDate (date, nameid)" + " values (?, ?)"); 
				        Pstatement9.setString(1,magaDate);
				        Pstatement9.setInt(2,nameid);
				        Pstatement9.executeUpdate();
				        PreparedStatement Pstatement10=connection.prepareStatement("select dateid from magazineDate where date=?");
				        Pstatement10.setString(1,magaDate);
				        ResultSet rs10=Pstatement10.executeQuery();
				        if(rs10.next()) {
				        	int dateid = rs10.getInt(1);
				        	PreparedStatement Pstatement11=connection.prepareStatement("insert into magazineInfo (price, dateid)" + " values (?, ?)"); 
					        Pstatement11.setDouble(1,magaPrice1);
					        Pstatement11.setInt(2,dateid);
					        Pstatement11.executeUpdate();
					        updateToCustomer(magazineName, magazineDate);
					        //Redirect to admin Page
					        new AdminActionForm();
					        JOptionPane.showMessageDialog(null,"Add Successfully!");
				        }			        	
			        }
		        }   	
	        }
	        //type does not exist, add all
	        else {
	        	PreparedStatement Pstatement11=connection.prepareStatement("insert into magazineType (type)" + " values (?)");
		        Pstatement11.setString(1,magaType);
		        Pstatement11.executeUpdate();
		        //fetch typeid
		        PreparedStatement Pstatement111=connection.prepareStatement("select typeid from magazineType where type=?");
		        Pstatement111.setString(1,magaType);
		        ResultSet rs111=Pstatement111.executeQuery();
		        if(rs111.next()) {
		        	int typeid = rs111.getInt(1);
		        	PreparedStatement Pstatement12=connection.prepareStatement("insert into magazineName (name, typeid)" + " values (?, ?)");  
			        Pstatement12.setString(1,magaName);
			        Pstatement12.setInt(2,typeid);
			        Pstatement12.executeUpdate();
			        PreparedStatement Pstatement112=connection.prepareStatement("select nameid from magazineName where name=?");
			        Pstatement112.setString(1,magaName);
			        ResultSet rs112=Pstatement112.executeQuery();
			        if(rs112.next()) {
			        	int nameid = rs112.getInt(1);
			        	PreparedStatement Pstatement13=connection.prepareStatement("insert into magazineDate (date, nameid)" + " values (?, ?)"); 
				        Pstatement13.setString(1,magaDate);
				        Pstatement13.setInt(2,nameid);
				        Pstatement13.executeUpdate();
				        PreparedStatement Pstatement113=connection.prepareStatement("select dateid from magazineDate where date=?");
				        Pstatement113.setString(1,magaDate);
				        ResultSet rs113=Pstatement113.executeQuery();
				        if(rs113.next()) {
				        	int dateid = rs113.getInt(1);
				        	PreparedStatement Pstatement14=connection.prepareStatement("insert into magazineInfo (price, dateid)" + " values (?, ?)"); 
					        Pstatement14.setDouble(1,magaPrice1);
					        Pstatement14.setInt(2,dateid);
					        Pstatement14.executeUpdate();
					        updateToCustomer(magazineName, magazineDate);
					        //Redirect to admin Page
					        new AdminActionForm();
					        JOptionPane.showMessageDialog(null,"Add Successfully!");
				        }			        	
			        }		        	
		        }		       
	        }
	    }
		catch (SQLException e11) {
			e11.printStackTrace();
		}	    	    
	}
	public void updateToCustomer(String magazineName, String magazineDate) {
		try {
			MagazineServer server = new MagazineServer();
			Connection connection1=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC","ralphie","buffalo");
	        PreparedStatement Pstatement=connection1.prepareStatement("select email from users");
	        ResultSet rs=Pstatement.executeQuery();
	        if(rs.next()) {
	        	String email = rs.getString(1);
	        	MagazineObserver emailAddress = new CustomerObserver(email);
	        	server.registerObserver(emailAddress);
	        }
	        server.setInfomation(magaName, magaDate);
		}catch(SQLException e) {
			e.printStackTrace();
		}		
	}
}
