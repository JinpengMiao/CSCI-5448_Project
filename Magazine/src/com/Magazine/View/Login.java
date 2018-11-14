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
import com.Magazine.Controller.LoginController;

public class Login extends JFrame implements ActionListener{
    JLabel label, username, password;
    JTextField usernameText;
    JButton login, register;
    JPasswordField passwordText;

    public Login()
    {
    	// set window size
        setSize(750, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Login Page");
        
    	// set label
    	label = new JLabel("Magazine Retail");
        label.setForeground(Color.blue);
        label.setFont(new Font("Serif", Font.BOLD, 30)); 

        username = new JLabel("Username:");
        password = new JLabel("Password:");

        usernameText = new JTextField();
        passwordText = new JPasswordField();

        login = new JButton("Login");
        register = new JButton("Register");

        login.addActionListener(this);
        register.addActionListener(this);
        
        // Setting position of GUI components
        label.setBounds(250, 100, 450, 40);
        username.setBounds(200, 170, 200, 40);
        password.setBounds(200, 210, 200, 40);
        usernameText.setBounds(380, 170, 200, 40);
        passwordText.setBounds(380, 210, 200, 40);
        login.setBounds(250, 265, 60, 40);
        register.setBounds(380, 265, 100, 40);

        add(label);
        add(username);
        add(password);
        add(usernameText);
        add(passwordText);
        add(login);
        add(register);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
    	String username = usernameText.getText(); // username
        char[] s = passwordText.getPassword();
        String password = new String(s); // password
        if (e.getSource() == login)
        {
        	new LoginController(username, password);
        	setVisible(false);
        }
        else // Go to registration page
        {
            new Register();
            setVisible(false);
        }
    }
}
