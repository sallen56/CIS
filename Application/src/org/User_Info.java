package org;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class User_Info{
	private static HomePage User_Info;

	public static void main(String[]args){
		
		try{
		User_Info= new HomePage();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
}
}