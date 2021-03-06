package com.Magazine.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.Magazine.Controller.DeleteMagazineController;

/**
 * @author jinpeng
 * create a page admin can delete magazines
 */
public class DeleteMagazine extends JFrame implements ActionListener{
	/**
     * create three labels
     */
    JLabel label, magaName, magaDate;
    /**
     * create two text boxes for magazine date and magazine name
     */
    JTextField magaNameText, magaDateText;
    /**
     * create two buttons
     */
    JButton delete, myPage;
    /**
     * a constructor to achieve delete-magazine function
     */
    public DeleteMagazine()
    {
    	// set window size
        setSize(750, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    	// set label
    	label = new JLabel("Delete Magazine");
        label.setForeground(Color.blue);
        label.setFont(new Font("Serif", Font.BOLD, 30)); 

        magaName = new JLabel("Magazine Name:");
        magaNameText = new JTextField();
        magaDate = new JLabel("Magazine Date:");
        magaDateText = new JTextField();

        delete = new JButton("Delete");
        delete.addActionListener(this);
        
        myPage = new JButton("Back");
        myPage.addActionListener(this);
        
        // Setting position of GUI components
        label.setBounds(250, 100, 450, 40);
        magaName.setBounds(210, 180, 120, 40);
        magaNameText.setBounds(320, 180, 200, 40);
        magaDate.setBounds(210, 240, 120, 40);
        magaDateText.setBounds(320, 240, 200, 40);
        delete.setBounds(240, 290, 100, 40);
        myPage.setBounds(380, 290, 100, 40);

        add(label);
        add(magaName);
        add(magaNameText);
        add(magaDate);
        add(magaDateText);
        add(delete);
        add(myPage);
        setVisible(true);
    }
    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent): actions for button clicks
     */
	@Override
	public void actionPerformed(ActionEvent e) {
    	String magaName = magaNameText.getText();
    	String magaDate = magaDateText.getText();
    	
        if(e.getSource()==delete)
        {
        	new DeleteMagazineController(magaName, magaDate);
        }else {
        	new AdminActionForm();
        }	
	}
}
