package com.Magazine.View;

import javax.swing.*;

import com.Magazine.View.AllMagazines;
import com.Magazine.Model.Magazine;
import com.Magazine.Model.ShoppingCart;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class Index extends JFrame implements ActionListener
{
    JLabel l1;
    JButton b1, b2, b3, b4;
    
    Index(){
    	// set window size
        setSize(750, 600); 
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	//set label
    	l1 = new JLabel("Magazine Retail");
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Serif", Font.BOLD, 30)); 
    	
    	//set buttons
        b1 = new JButton("Magazines");
        b2 = new JButton("Login");
        b3 = new JButton("Sign Up");
        b4 = new JButton("My Cart");
        
	    b1.addActionListener(this);
	    b2.addActionListener(this);
	    b3.addActionListener(this);
	    b4.addActionListener(this);
        
        // Setting position of GUI components
        l1.setBounds(250, 100, 450, 40);
        b1.setBounds(200, 170, 150, 40);
        b2.setBounds(380, 170, 150, 40);
        b3.setBounds(200, 220, 150, 40);
        b4.setBounds(380, 220, 150, 40);
        
        add(l1);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
	    
		//Index page functions
		//Everyone can view the detailed information of various magazines.
		if (e.getSource() == b1)
		{
			new AllMagazines();
			setVisible(false);
		}
		//Users can purchase magazines
		else if (e.getSource() == b2)
		{
			new Login();
	        setVisible(false);
	    }
		//If the user has his own account, he can login directly. If not, the user can register.
	    else if (e.getSource() == b3)
	    {
	        new Register();
	        setVisible(false);
	    }
		//Users can view their own shopping cart
	    else
	    {
	        new ShoppingCart();
	        setVisible(false);
	    }
	}
	
    public static void main(String[] args) {
    	//start from index page
        Index indexPage = new Index();
        indexPage.setVisible(true);
    }
}