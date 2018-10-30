package com.Magazine;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

public class Login extends JFrame implements ActionListener{
    JLabel label, username, password;
    JTextField usernameText;
    JButton login, register;
    JPasswordField passwordText;

    Login()
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
        username.setBounds(200, 160, 200, 40);
        password.setBounds(200, 200, 200, 40);
        usernameText.setBounds(380, 160, 200, 40);
        passwordText.setBounds(380, 200, 200, 40);
        login.setBounds(250, 280, 60, 40);
        register.setBounds(380, 280, 100, 40);

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
        if (e.getSource() == login)
        {

            String username = usernameText.getText(); // username
            char[] s = passwordText.getPassword();
            String password = new String(s); // password
            
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC","ralphie", "buffalo");
                PreparedStatement preparedStmt = myConnection.prepareStatement("select userid, password, salt from users where username=?");
                preparedStmt.setString (1,username);
                ResultSet rs=preparedStmt.executeQuery();
				if(rs.next()) {
					int uid = rs.getInt(1);
                	String pass = rs.getString(2);
                	byte[] salt1 = rs.getBytes(3);
                	String securePass = SHA_256(password, salt1);
                	if(securePass.equals(pass)) {
                		if(uid == 1) //admin
                		{	
                			new AdminAction();
                            setVisible(false);
                            JOptionPane.showMessageDialog(login, "Login Successfully!");
                        }
                        else //user is customer
                        {
                        	new CustomerAction();
                            setVisible(false);
                            JOptionPane.showMessageDialog(login, "Login Successfully!");
                        }
    				}
                	else {
                		JOptionPane.showMessageDialog(register, "invalid username or password");
                	}               	
                }  
				else
                {
                    JOptionPane.showMessageDialog(register, "You do not have an account. Please create one first!");
                    new Register();
                }
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
        else // Go to registration page
        {
            new Register();
            setVisible(false);
        }
    }
    private static String SHA_256(String password, byte[] salt)
    {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return generatedPassword;
    }
}
