package com.Magazine.View;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import com.Magazine.Controller.OrderHistoryController;

/**
 * @author jinpeng
 * create a page on which customers can check their order history: magazines and payment
 */
public class OrderHistory{

	private int uid;
	/**
	 * @param uid int value, which is linked with a specific user
	 * use JFrame to build the window, like window size, bounds
	 * use JTable to create a table containing all the order information
	 */
	public OrderHistory(int uid) {
		this.uid = uid;
	
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Container content = frame.getContentPane();
	OrderHistoryController orderHisContr = new OrderHistoryController(uid);
	String[][] rows;
	rows = orderHisContr.returnMagazine();
	//set up column names
	Object columns[] = { "Type", "Name", "Release Date", "Decorator", "Price $" };
	JTable table = new JTable(rows, columns);
	//set up column width
	TableColumnModel columnModel = table.getColumnModel();
	columnModel.getColumn(0).setPreferredWidth(100);
	columnModel.getColumn(1).setPreferredWidth(100);
	columnModel.getColumn(2).setPreferredWidth(150);
	columnModel.getColumn(3).setPreferredWidth(300);
	columnModel.getColumn(4).setPreferredWidth(100);
	//set up a scroll bar
	JScrollPane scrollPane = new JScrollPane(table);
	JOptionPane.showMessageDialog(null, new JScrollPane(table), "All Magazines Your Purchased", JOptionPane.INFORMATION_MESSAGE);
	content.add(scrollPane, BorderLayout.CENTER);
    
	frame.setSize(750, 600);
	frame.setVisible(true);
	new CustomerActionForm(uid);      	 	
}}