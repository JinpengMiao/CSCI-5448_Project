package com.Magazine.View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import com.Magazine.Controller.BuyController;
import com.Magazine.Controller.LoginController;
import com.Magazine.Controller.ShoppingCartController;

/**
 * @author jinpeng
 * create a page on which customers can check their shopping cart: magazines and payment
 * and decide buy them or not
 */
public class ShoppingCart{
	private int uid;
	/**
	 * @param uid int value, which is linked with a specific user
	 * use JFrame to build the window, like window size, bounds
	 * use JTable to create a table containing all the potential order information
	 */
	public ShoppingCart(int uid) {
		this.uid = uid;

    JFrame frame = new JFrame();
    frame.setLayout(new BorderLayout());
    ShoppingCartController magaContr = new ShoppingCartController(uid);
	String[][] rows;
	rows = magaContr.returnMagazine();
	//set up column names
	Object columns[] = { "Type", "Name", "Release Date", "Decorator", "Price $" };
	JTable table = new JTable(rows, columns);
	TableColumnModel columnModel = table.getColumnModel();
	columnModel.getColumn(0).setPreferredWidth(100);
	columnModel.getColumn(1).setPreferredWidth(100);
	columnModel.getColumn(2).setPreferredWidth(150);
	columnModel.getColumn(3).setPreferredWidth(300);
	columnModel.getColumn(4).setPreferredWidth(100);
    JPanel btnPnl = new JPanel(new BorderLayout());
    JPanel bottombtnPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
    
    JButton Buy = new JButton("Buy");
    JButton Back = new JButton("Back");
    
    bottombtnPnl.add(Buy);
    bottombtnPnl.add(Back);
    btnPnl.add(bottombtnPnl, BorderLayout.CENTER);
    
    JScrollPane scrPane = new JScrollPane(btnPnl);
    frame.getContentPane().add(scrPane);
    table.getTableHeader().setReorderingAllowed(false);

    frame.add(table.getTableHeader(), BorderLayout.NORTH);
    frame.add(table, BorderLayout.CENTER);
    frame.add(btnPnl, BorderLayout.SOUTH);
    
    frame.setTitle("Shopping Cart");
    frame.setSize(750, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);	
    
    Buy.addActionListener(/**
     * action for clicking "Buy" button: buy magazine and "decorators"
     */
    new ActionListener() { 
    	public void actionPerformed(ActionEvent e) { 
    		new BuyController(uid);
    	} 
    });
    
    Back.addActionListener(/**
     * action for clicking "Back" button: back to customer main page
     */
    new ActionListener() { 
    	public void actionPerformed(ActionEvent e) { 
    		new CustomerActionForm(uid);
    	} 
    });
}}