package com.Magazine.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.Magazine.Controller.AddMagazineController;

/**
 * @author jinpeng
 * create a page admin can add magazines
 */
public class AddMagazine extends JFrame implements ActionListener{
    /**
     * create five labels
     */
    JLabel label, magType, magName, magDate, magPrice;
    /**
     * create four text boxes for magazine information
     */
    JTextField magTypeText, magNameText, magDateText, magPriceText;
    /**
     * create 2 buttons
     */
    JButton addMagazine, myPage;

    /**
     * a constructor to achieve add-magazine function
     */
    public AddMagazine()
    {
    	// set window size
        setSize(750, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    	// set label
    	label = new JLabel("Add New Magazine");
        label.setForeground(Color.blue);
        label.setFont(new Font("Serif", Font.BOLD, 30)); 
        
        magType = new JLabel("Magazine Type:");
        magName = new JLabel("Magazine Name:");
        magDate = new JLabel("Magazine Date:");
        magPrice = new JLabel("Magazine Price:");

        magTypeText = new JTextField();
        magNameText = new JTextField();
        magDateText = new JTextField();
        magPriceText = new JTextField();
        addMagazine = new JButton("Add");
        myPage = new JButton("Back");
    	
        addMagazine.addActionListener(this);
        myPage.addActionListener(this);
        
        // Setting position of GUI components
        label.setBounds(250, 100, 450, 40);    
        magType.setBounds(200, 170, 200, 40);
        magName.setBounds(200, 230, 200, 40);
        magDate.setBounds(200, 290, 200, 40);
        magPrice.setBounds(200, 350, 200, 40);  
        magTypeText.setBounds(380, 170, 200, 40);
        magNameText.setBounds(380, 230, 300, 40);
        magDateText.setBounds(380, 290, 200, 40);
        magPriceText.setBounds(380, 350, 200, 40);       
        addMagazine.setBounds(240, 400, 100, 40);
        myPage.setBounds(400, 400, 100, 40);

        add(label);
        add(magType);
        add(magName);
        add(magDate);
        add(magPrice);
        add(magTypeText);
        add(magNameText);
        add(magDateText);
        add(magPriceText);
        add(addMagazine);
        add(myPage);
        setVisible(true);      
    }
    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent): actions for button clicks
     */
    @Override
    public void actionPerformed(ActionEvent e) {
    	String magazineType = magTypeText.getText();
    	String magazineName = magNameText.getText();
    	String magazineDate = magDateText.getText();
    	String magazinePrice = magPriceText.getText();
    	
        if(e.getSource()==addMagazine)
        {
        	new AddMagazineController(magazineType, magazineName, magazineDate, magazinePrice);
        }else {
        	new AdminActionForm();
        }
    }
}
