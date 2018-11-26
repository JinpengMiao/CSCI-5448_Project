package com.Magazine.View;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.Magazine.Controller.AllMagazinesController;

/**
 * @author jinpeng
 * create a window showing all magazine information
 * use JFrame to build the window, like window size, bounds
 * use JTable to create a table containing all the magazine information
 */
public class AllMagazines{{
	JFrame frame = new JFrame();
	frame.setLayout(new BorderLayout());
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Container content = frame.getContentPane();	
	AllMagazinesController magaContr = new AllMagazinesController();
	String[][] rows;
	rows = magaContr.returnMagazine();
	//set up column names
	Object columns[] = { "Type", "Name", "Release Date", "Price $" };
	JTable table = new JTable(rows, columns);
	//set up a scroll bar
	JScrollPane scrollPane = new JScrollPane(table);
	JOptionPane.showMessageDialog(null, new JScrollPane(table), "All Magazines", JOptionPane.INFORMATION_MESSAGE);
	content.add(scrollPane, BorderLayout.CENTER);
	frame.setSize(750, 600);
	frame.setVisible(true);
	new Index();	
}}
