package com.Magazine.View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.Magazine.Controller.AddToCartController;
import com.Magazine.Controller.SearchMagazineController;

/**
 * @author jinpeng
 * customers can add magazines to their shopping cart
 * decorator pattern: customers can add "decorators" to their cart together with magazines
 */
public class SearchMagazine {
	private String mname;
	private String mdate; 
	private int userid;
	String decorator;
	/**
	 * @param userid int value, which is linked with a specific user
	 * @param magaName magazine name searched
	 * @param magaDate magazine date searched
	 * use JFrame to build the window, like window size, bounds
	 * use JTable to create a table containing the matched magazine information and "decorators", also two buttons
	 */
	public SearchMagazine(int userid, String magaName, String magaDate) {
		this.userid = userid;
		this.mname = magaName;
		this.mdate = magaDate;	
	
	    JFrame frame = new JFrame();
	    frame.setLayout(new BorderLayout());
	    
	    SearchMagazineController magaContr = new SearchMagazineController(userid, mname, mdate);
		String[][] rows;
		rows = magaContr.returnMagazine();
		//set up column names
		Object columns[] = { "Type", "Name", "Release Date", "Price $" };
		JTable table = new JTable(rows, columns);
	    JPanel btnPnl = new JPanel(new BorderLayout());
	    JPanel panel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
	    JPanel bottombtnPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
	    
	    JButton Add = new JButton("Add to Cart");
	    JButton Back = new JButton("Back");
	    
	    bottombtnPnl.add(Add);
	    bottombtnPnl.add(Back);
	    
	    //Decorator Pattern: add checkbox for giftcard, wrapping paper, or bookmark
	    //and then add these decorators to shopping_cart decorator column
		JCheckBox giftCard = new JCheckBox("Gift card");
		giftCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		         if (giftCard.isSelected()) { 
		        	 decorator += giftCard.getText();
		        	 if (decorator.indexOf("null")!=-1){
		           		 decorator = decorator.replace("null", "");
		           	 	}
			     } else {
			    	 decorator = decorator.replace(giftCard.getText(), ""); 
			     } 
			}
		});
		giftCard.setBounds(70, 6, 66, 23);
		panel.add(giftCard);
		
		JCheckBox wrapPaper = new JCheckBox("Wrapping paper");
		wrapPaper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(wrapPaper.isSelected()){
					decorator += wrapPaper.getText();
					if (decorator.indexOf("null")!=-1){
				   		 decorator = decorator.replace("null", "");
				   	}
				}else{
					decorator = decorator.replace(wrapPaper.getText(), "");
				}
			}
		});
		wrapPaper.setBounds(138, 6, 66, 23);
		panel.add(wrapPaper);
		
		JCheckBox bookmark = new JCheckBox("Bookmark");
		bookmark.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(bookmark.isSelected()){
					decorator += bookmark.getText();
					if (decorator.indexOf("null")!=-1){
				   		 decorator = decorator.replace("null", "");
				   	 	}
				}else{
					decorator = decorator.replace(bookmark.getText(), "");
				}
			}
		});
		//bookmark.setBounds(200, 6, 66, 23);
		panel.add(bookmark);
		
		btnPnl.add(panel, BorderLayout.NORTH);
	    btnPnl.add(bottombtnPnl, BorderLayout.CENTER);
	    
	    JScrollPane scrPane = new JScrollPane(btnPnl);
	    frame.getContentPane().add(scrPane);
	    table.getTableHeader().setReorderingAllowed(false);

	    frame.add(table.getTableHeader(), BorderLayout.NORTH);
	    frame.add(table, BorderLayout.CENTER);
	    frame.add(btnPnl, BorderLayout.SOUTH);

	    frame.setTitle("Magazine Searched");
	    frame.setSize(750, 600);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);	
	    
	    String type = rows[0][0];
	    String name = rows[0][1];
	    String date = rows[0][2];
	    String price = rows[0][3];
	    
	    Add.addActionListener(/**
	     * action for clicking "Add" button: add magazine and "decorators" to their shopping carts
	     */
	    new ActionListener() { 
	    	public void actionPerformed(ActionEvent e) { 
	    		new AddToCartController(userid, type, name, date, decorator);
	    	} 
	    });
	    
	    Back.addActionListener(/**
	     * action for clicking "Back" button: back to customer main page
	     */
	    new ActionListener() { 
	    	public void actionPerformed(ActionEvent e) { 
	    		new CustomerActionForm(userid);
	    	} 
	    });
	
}}


