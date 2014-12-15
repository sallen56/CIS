package org;

import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


	public class CustomerView extends User_Account{/*
		protected Data_base one= new Data_base();
		private ArrayList customerFlights;
		private JTable table;
		private JComboBox selection;
		protected JTextField leaving;
		private JToggleButton roundTrip = new JToggleButton("Round Trip");
		private JToggleButton oneWay = new JToggleButton("One Way");
		private JButton go = new JButton("GO");
		protected JTextField arrive;
		private JLabel leaveDate;
		protected String date;
		private String statement;
		private JSpinner spinner;
		
		
		
		
public static void main(String[]args){
	CustomerView testing = new CustomerView();
}
		
		
		
		protected  CustomerView()
		{
			
			frame.setContentPane(base);
			frame.getContentPane().setLayout(null);
			
			
			
			getMenue();
			
			JButton logout= new JButton("Logout");
			logout.setBounds(660,0,89,25);
			base.add(logout);
			
			JLabel yourAccount = new JLabel("Your Account");
			yourAccount.setBounds(78, 0, 77, 39);
			base.add(yourAccount);
			
			selection = new JComboBox();
			selection.setBounds(10, 36, 268, 39);
			base.add(selection);
			selection.addItem("Please Select");
			selection.addItem("Search Flights");
			selection.addItem("My Flights");
			selection.addItem("Remove Flights");
			selection.addItem("Update Information");
			
			selection.addItemListener(new ItemListener() {
			    public void itemStateChanged(ItemEvent e) {
			    	if(e.getItem().equals("Search Flights")){
			    		createHome();
			    		
			    		
			    	
			    	}
			    	else
			    		if(selection.getSelectedItem().equals("My Flights")){
			    			
			    			//one.table.setBounds(361, 97, 638, 362);
			    			//base.add(one.table);
			    		}
			    		else
			    			if(selection.getSelectedItem().equals("Remove Flights")){
			    				//TODO
			    			}
			    			else 
			    				if(selection.getSelectedItem().equals("Update Information")){
			    					//TODO
			    				}
			    
			    	}
			
			
			});
			try {
				setImg(ImageIO.read(new File("C:\\Users\\reesey\\Pictures\\vacation-beach.jpg")));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	
			
		
	
	{
		 base = new JPanel()
		   
		  {
		    @Override
		    protected void paintComponent(Graphics g)
		    {
		      super.paintComponent(g);
		      if (getImg() != null)
		      {
		        int width = base.getWidth();
		        int height = base.getHeight();
		        // and do the drawing here:
		        g.drawImage(getImg(), 0, 0, width, height, base);
		      }
		    }

			
		  };
	}	
	
	*/}

	
