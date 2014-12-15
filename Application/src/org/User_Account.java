package org;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;



public class User_Account extends HomePage{/*

	private JTextField username;
	private JTextField password;
	private JTextField textField;
	private JTextField passwordField;
	private JTextField passwordField_1;
	private JTextField social;
	private JLabel createPassword;
	private JLabel createUserName;
	private JLabel userName;
	private JLabel userLogin;
	private JLabel newAccount;
	private JLabel re;
	private JLabel ssn;
	private JLabel pword;
	private JButton btnLogin;
	private	JButton btnForgot;
	private JLabel email;
	private JTextField userEmail;
	private JLabel fName;
	private JTextField firstName;
	private JLabel lName;
	private JTextField lastName;
	private JLabel sq;
	private JTextField security;
	private JLabel sqAnswer;
	private JTextField securityAnswer;
	private JLabel dob;
	private JTextField birthday;
	private JLabel state;
	private JTextField st;
	private JLabel zip;
	private JTextField zipcode;
	private JLabel address;
	private JTextField enterAddress;
	private JLabel city;
	private JTextField enterCity;
	private JButton create;
	
	
	
	
	protected User_Account() {
		
		 getMenue();
		frame.setContentPane(other);
		frame.getContentPane().setLayout(null);
		
		userLogin = new JLabel("User Login");
		userLogin.setBounds(223, 161, 223, 14);
		other.add(userLogin);
		
		username = new JTextField();
		username.setBounds(223, 206, 189, 20);
		other.add(username);
		username.setColumns(10);
		
		userName = new JLabel("User Name");
		userName.setBounds(125, 207, 76, 18);
		other.add(userName);
		
		password = new JPasswordField();
		password.setBounds(223, 237, 189, 20);
		other.add(password);
		
		pword = new JLabel("Password");
		pword.setBounds(125, 236, 76, 21);
		other.add(pword);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(223, 279, 189, 23);
		other.add(btnLogin);
		btnLogin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(one.login(username.getText(),password.getText())==true){
					frame.setVisible(false);
					new CustomerView();
				}
					
					
			}
		});
		
		btnForgot = new JButton("Forgot Username/ Password");
		btnForgot.setBounds(223, 352, 189, 23);
		other.add(btnForgot);
		
		newAccount = new JLabel("Register For New Account");
		newAccount.setBounds(736, 161, 150, 20);
		other.add(newAccount);
		
		textField = new JTextField();
		textField.setBounds(736, 206, 189, 20);
		other.add(textField);
		textField.setColumns(10);
		
		createUserName = new JLabel("Create User Name");
		createUserName.setBounds(614, 206, 104, 20);
		other.add(createUserName);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(736, 237, 189, 20);
		other.add(passwordField);
		
		createPassword = new JLabel("Create Password");
		createPassword.setBounds(614, 237, 104, 20);
		other.add(createPassword);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(736, 268, 189, 20);
		other.add(passwordField_1);
		
		re = new JLabel("Reenter Password");
		re.setBounds(614, 268, 115, 20);
		other.add(re);
		
		
		ssn = new JLabel("Social Security Number");
		ssn.setBounds(598, 299, 140, 20);
		other.add(ssn);
		
		social = new JPasswordField();
		social.setBounds(736, 299, 189, 20);
		other.add(social);
		
		fName=new JLabel("First Name");
		fName.setBounds(614,330,104,14);
		other.add(fName);
		
		firstName= new JTextField();
		firstName.setBounds(736,330,189,20);
		other.add(firstName);
		
		lName= new JLabel("Last Name");
		lName.setBounds(614,361,104,20);
		other.add(lName);
		
		lastName= new JTextField();
		lastName.setBounds(736,361,189,20);
		other.add(lastName);
		
		address= new JLabel("Address");
		address.setBounds(614,392,104,20);
		other.add(address);
		
		enterAddress=new JTextField();
		enterAddress.setBounds(736,392,189,20);
		other.add(enterAddress);
		
		city=new JLabel("City");
		city.setBounds(614,423,104,20);
		other.add(city);
		
		enterCity= new JTextField();
		enterCity.setBounds(736,423,189,20);
		other.add(enterCity);
		
		state= new JLabel("State");
		state.setBounds(614,454,104,20);
		other.add(state);
		
		st= new JTextField();
		st.setBounds(736,454,189,20);
		other.add(st);
		
		zip=new JLabel("Zipcode");
		zip.setBounds(614,485,104,20);
		other.add(zip);
		
		zipcode= new JTextField();
		zipcode.setBounds(737,485,189,20);
		other.add(zipcode);
		
		dob= new JLabel("Date of Birth");
		dob.setBounds(614,516,104,20);
		other.add(dob);
		
		birthday= new JTextField();
		birthday.setBounds(736,516,189,20);
		other.add(birthday);
		
		email= new JLabel("Email Address");
		email.setBounds(614,547,104,20);
		other.add(email);
		
		userEmail= new JTextField();
		userEmail.setBounds(736,547,189,20);
		other.add(userEmail);
		
		sq= new JLabel("Create Security Question");
		sq.setBounds(585,578,150,20);
		other.add(sq);
		
		security= new JTextField();
		security.setBounds(736,578,189,20);
		other.add(security);
		
		sqAnswer= new JLabel("Security Question Answer");
		sqAnswer.setBounds(585,609,150,20);
		other.add(sqAnswer);
		
		securityAnswer= new JTextField();
		securityAnswer.setBounds(736,609,189,20);
		other.add(securityAnswer);
		
		create = new JButton("Create User");
		create.setBounds(736,640,120,30);
		other.add(create);
		create.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				if(passwordField.getText().equals(passwordField_1.getText())){
				one.addUser(firstName.getText(), lastName.getText(), enterAddress.getText(),enterCity.getText(), st.getText(),
				zipcode.getText(),birthday.getText(), textField.getText(),
				passwordField.getText(), userEmail.getText(), social.getText(),securityAnswer.getText(),security.getText());	
				
					if(one.success==true){
							firstName.setText(""); lastName.setText(""); enterAddress.setText("");enterCity.setText(""); st.setText("");
							zipcode.setText("");birthday.setText(""); textField.setText("");
							passwordField.setText(""); userEmail.setText(""); social.setText("");securityAnswer.setText("");security.setText("");	
					}
					
				}	
				else
					JOptionPane.showMessageDialog(null, "Password Values Must Match");
			}
		});
		
		
		try {
			setImg(ImageIO.read(new File("C:\\Users\\reesey\\Pictures\\vacations.jpg")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	{
	 other = new JPanel()
	   
	  {
	    @Override
	    protected void paintComponent(Graphics g)
	    {
	      super.paintComponent(g);
	      if (getImg() != null)
	      {
	        int width = other.getWidth();
	        int height = other.getHeight();
	        // and do the drawing here:
	        g.drawImage(getImg(), 0, 0, width, height, other);
	      }
	    }

		
	  };
}
	  
	public static void main(String[]args){
		User_Account test = new User_Account();
		test.getMenue();
		
	}
	*/}

	
