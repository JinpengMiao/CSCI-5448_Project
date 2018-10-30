package com.Magazine;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CustomerAction  extends JFrame implements ActionListener
{
    JLabel l1;
    JButton button1, button2, button3, button4, button5;
    
    CustomerAction(){
    	// set window size
        setSize(750, 600); 
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	//set label
    	l1 = new JLabel("Customer Page");
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Serif", Font.BOLD, 30)); 
    	
    	//set buttons
        button1 = new JButton("View All Magazines");
        button2 = new JButton("Search Magazine");
        button3 = new JButton("Shopping Cart");
        button4 = new JButton("Order History");
        button5 = new JButton("Logout");
        
	    button1.addActionListener(this);
	    button2.addActionListener(this);
	    button3.addActionListener(this);
	    button4.addActionListener(this);
	    button5.addActionListener(this);
        
        // Setting position of GUI components
        l1.setBounds(255, 100, 450, 50);
        button1.setBounds(277, 160, 150, 40);
        button2.setBounds(277, 210, 150, 40);
        button3.setBounds(277, 260, 150, 40);
        button4.setBounds(277, 310, 150, 40);
        button5.setBounds(299, 370, 100, 30);
        
        add(l1);
        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(button5);
        setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == button1)
		{
			new allMagazines();
			setVisible(false);
		}
		else if (e.getSource() == button2)
		{
			new SearchMagazine();
	        setVisible(false);
	    }
		else if (e.getSource() == button3)
		{
			new ShoppingCart();
	        setVisible(false);
	    }
		else if (e.getSource() == button4)
		{
			new OrderHistory();
	        setVisible(false);
	    }
		else
		{
			new index();
	        setVisible(false);
	    }
	}
}
