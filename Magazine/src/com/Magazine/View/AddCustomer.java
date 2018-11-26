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

import com.Magazine.Controller.AddCustomerController;

/**
 * @author jinpeng
 * create a page admin can add customers
 */
public class AddCustomer extends JFrame implements ActionListener{
	/**
     * create seven labels
     */
    JLabel label, username, password, rePassword, email, phoneNumber, address;
    /**
     * create four text boxes for users' personal information
     */
    JTextField usernameText, emailText, phoneNumText, addressText;
    /**
     * create 2 buttons
     */
    JButton addCustomer, myPage;
    /**
     * create two password text boxes
     */
    JPasswordField passwordText1, passwordText2;

    /**
     * a constructor to achieve add-customer function
     */
    public AddCustomer()
    {
    	// set window size
        setSize(750, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    	// set label
    	label = new JLabel("Add New Customer");
        label.setForeground(Color.blue);
        label.setFont(new Font("Serif", Font.BOLD, 30)); 
        
        username = new JLabel("Username:");
        password = new JLabel("Password:");
        rePassword = new JLabel("Confirm Password:");
        email = new JLabel("Email:");
        phoneNumber = new JLabel("Phone Number:");
        address = new JLabel("Address");
        usernameText = new JTextField();
        passwordText1 = new JPasswordField();
        passwordText2 = new JPasswordField();
        emailText = new JTextField();
        phoneNumText = new JTextField();
        addressText = new JTextField();
        addCustomer = new JButton("Add");
        myPage = new JButton("Back");
    	
        addCustomer.addActionListener(this);
        myPage.addActionListener(this);
        
        // Setting position of GUI components
        label.setBounds(250, 100, 450, 40);    
        username.setBounds(200, 150, 200, 40);
        password.setBounds(200, 200, 200, 40);
        rePassword.setBounds(200, 250, 200, 40);
        email.setBounds(200, 300, 200, 40);
        phoneNumber.setBounds(200, 350, 200, 40);
        address.setBounds(200, 400, 200, 40);   
        usernameText.setBounds(380, 150, 200, 40);
        passwordText1.setBounds(380, 200, 200, 40);
        passwordText2.setBounds(380, 250, 200, 40);
        emailText.setBounds(380, 300, 300, 40);
        phoneNumText.setBounds(380, 350, 200, 40);
        addressText.setBounds(380, 400, 200, 40);       
        addCustomer.setBounds(240, 450, 100, 40);
        myPage.setBounds(400, 450, 100, 40);

        add(label);
        add(username);
        add(password);
        add(rePassword);
        add(email);
        add(phoneNumber);
        add(address);
        add(usernameText);
        add(emailText);
        add(phoneNumText);
        add(addressText);
        add(passwordText1);
        add(passwordText2);
        add(addCustomer);
        add(myPage);
        setVisible(true);      
    }
    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent): actions for button clicks
     */
    @Override
    public void actionPerformed(ActionEvent e) {
    	String password1 = passwordText1.getText();
    	String password2 = passwordText2.getText();
    	String username = usernameText.getText();
    	String email = emailText.getText();
    	String phoneNum = phoneNumText.getText();
    	String address = addressText.getText();
    	
        if(e.getSource()==addCustomer)
        {
        	new AddCustomerController(password1, password2, username, email, phoneNum, address);
        }else {
        	new AdminActionForm();
        }
    }
}