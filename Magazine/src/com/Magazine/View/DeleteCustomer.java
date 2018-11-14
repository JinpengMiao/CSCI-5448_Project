package com.Magazine.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.Magazine.Controller.DeleteCustomerController;

public class DeleteCustomer extends JFrame implements ActionListener{
    JLabel label, username;
    JTextField usernameText;
    JButton delete, myPage;
    public DeleteCustomer()
    {
    	// set window size
        setSize(750, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    	// set label
    	label = new JLabel("Delete Customer");
        label.setForeground(Color.blue);
        label.setFont(new Font("Serif", Font.BOLD, 30)); 

        username = new JLabel("Username:");
        usernameText = new JTextField();

        delete = new JButton("Delete");
        delete.addActionListener(this);
        
        myPage = new JButton("My Page");
        myPage.addActionListener(this);
        
        // Setting position of GUI components
        label.setBounds(250, 100, 450, 40);
        username.setBounds(220, 180, 100, 40);
        usernameText.setBounds(300, 180, 200, 40);
        delete.setBounds(250, 240, 100, 40);
        myPage.setBounds(380, 240, 100, 40);

        add(label);
        add(username);
        add(usernameText);
        add(delete);
        add(myPage);
        setVisible(true);
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
    	String username = usernameText.getText();
    	
        if(e.getSource()==delete)
        {
        	new DeleteCustomerController(username);
        }else {
        	new AdminActionForm();
        }	
	}
}