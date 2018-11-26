package com.Magazine.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author jinpeng
 * create a window on which admin can change magazines: add or delete
 */
public class ChangeMagazine extends JFrame implements ActionListener
{
	/**
     * create one label
     */
    JLabel l1;    
    /**
     * create three buttons
     */
    JButton button1, button2, button3;
    
    public ChangeMagazine(){
    	// set window size
        setSize(750, 600); 
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	//set label
    	l1 = new JLabel("Change Magazine");
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Serif", Font.BOLD, 30)); 
    	
    	//set buttons
        button1 = new JButton("Add New Magazine");
        button2 = new JButton("Delete Magazine");
        button3 = new JButton("Logout");
        
	    button1.addActionListener(this);
	    button2.addActionListener(this);
	    button3.addActionListener(this);
	    
        // Setting position of GUI components
        l1.setBounds(230, 100, 450, 50);
        button1.setBounds(264, 180, 150, 40);
        button2.setBounds(264, 240, 150, 40);
        button3.setBounds(287, 300, 100, 30);
        
        add(l1);
        add(button1);
        add(button2);
        add(button3);
        setVisible(true);
    }
    
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent): actions for button clicks
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button1)
		{
			new AddMagazine();
			setVisible(false);
		}
		//Users can purchase magazines
		else if (e.getSource() == button2)
		{
			new DeleteMagazine();
	        setVisible(false);
	    }
		else
		{
			new Index();
	        setVisible(false);
	    }		
	}
}