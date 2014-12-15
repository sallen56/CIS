package org;

import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class HomePage extends JFrame {

	protected JFrame frame;
	private JPanel loginView;
	private JPanel customerView;
	private JPanel adminView;
	private JPanel parent = new JPanel();
	private JPanel register;
	private JPanel menu;
	private JPanel mainPanel;
	private CardLayout view = new CardLayout();
	private JButton support = new JButton("Support");
	protected JButton logout2 = new JButton("Logout");
	protected JButton home = new JButton("home");
	private String valueOfDept;
	private String valueOfArrive;
	private JComboBox arrive_list;
	private JComboBox dept_list;
	protected Data_base one = new Data_base();
	private boolean isLogedin;
	private boolean isAdmin;
	private SearchFlight test;
	private JToggleButton roundTrip = new JToggleButton("Round Trip");
	private JToggleButton oneWay = new JToggleButton("One Way");
	private JButton go = new JButton("GO");
	private String date;
	private String statement;
	private JTable customer;
	private JScrollPane customerF;
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
	private JButton btnForgot;
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
	static List<String[]> customerFlights = new Vector<String[]>();
	private JTable table;
	private JComboBox selection;
	private JButton loginHome;
	private JButton btnLogin_1;
	private JButton button_1;
	private JButton btnSupport;
	private JButton btnSupport_1;
	private JButton btnHome;
	private JButton btnLogin_2;
	private JPanel lookupView;
	private JPanel lookupView_1;
	private JButton btnNewUser;
	private BufferedImage img;
	private JLabel lblToLookupYour;
	private JLabel forgot_usernameLb;
	private JTextField forgot_user;
	private JLabel forgotSQ;
	private JTextField forgot_Sq;
	private JButton btnGetLogin;
	private JLabel forgotSAnswer;
	private JTextField forgot_Sa;
	static DefaultTableModel model;
	static boolean addMore;
	private JPanel userFlights;
	private JTable table_2;
	private JComboBox selection1;
	private JPanel adminFlight;

	// Method that creates the frame and adds the initial content of the frame
	protected HomePage() {

		frame = new JFrame();
		frame.setTitle("Java Flights");
		frame.setSize(1025, 700);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		parent.setLayout(view);
		frame.getContentPane().add(parent);
		view.show(parent, "Login");

		// setting the image for the login view page
		{
			try {
				setImg(ImageIO.read(new File(
						"C:\\Users\\reesey\\Pictures\\vacations.jpg")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			{
				loginView = new JPanel()

				{
					@Override
					protected void paintComponent(Graphics g) {
						super.paintComponent(g);
						if (getImg() != null) {
							int width = loginView.getWidth();
							int height = loginView.getHeight();
							// and do the drawing here:
							g.drawImage(getImg(), 0, 0, width, height,
									loginView);
						}
					}

				};
			}
			// creating the panel loginView with the call name Login
			loginView.setLayout(null);
			parent.add(loginView, "Login");

			userLogin = new JLabel("User Login");
			userLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
			userLogin.setBounds(223, 161, 223, 14);
			loginView.add(userLogin);

			username = new JTextField();
			username.setBounds(223, 206, 189, 20);
			loginView.add(username);
			username.setColumns(10);

			userName = new JLabel("User Name");
			userName.setFont(new Font("Tahoma", Font.BOLD, 12));
			userName.setBounds(125, 207, 76, 18);
			loginView.add(userName);

			password = new JPasswordField();
			password.setBounds(223, 237, 189, 20);
			loginView.add(password);

			pword = new JLabel("Password");
			pword.setFont(new Font("Tahoma", Font.BOLD, 12));
			pword.setBounds(125, 236, 76, 21);
			loginView.add(pword);

			btnLogin = new JButton("Login");
			btnLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnLogin.setBounds(223, 279, 189, 23);
			loginView.add(btnLogin);

			// setting login action to check if the username and password is
			// correct if correct user can login. if the user is an admin the
			// will see
			// admin page else the user will see the customer view page
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (checkLogin(username.getText(), password.getText()) == true) {
						if (isAdmin == true) {
							view.show(parent, "Admin View");
						} else {
							view.show(parent, "Customer View");
						}
					}

					else
						JOptionPane
								.showMessageDialog(null,
										"Incorrect username or Password please try again");

				}
			});

			btnForgot = new JButton("Forgot Username/ Password");
			btnForgot.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnForgot.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					view.show(parent, "Lookup");

				}
			});
			btnForgot.setBounds(220, 350, 206, 23);
			loginView.add(btnForgot);

			btnNewUser = new JButton("New User");
			btnNewUser.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnNewUser.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					view.show(parent, "New Account");
				}
			});
			btnNewUser.setBounds(467, 279, 189, 23);
			loginView.add(btnNewUser);

			btnLogin_1 = new JButton("Login");
			btnLogin_1.setBounds(838, 0, 89, 29);
			loginView.add(btnLogin_1);
			btnLogin_1.setFont(new Font("Tahoma", Font.BOLD, 11));

			loginHome = new JButton("Home");
			loginHome.setBounds(920, 0, 89, 29);
			loginView.add(loginHome);
			loginHome.setFont(new Font("Tahoma", Font.BOLD, 11));
			loginHome.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (isLogedin == true) {
						if (isAdmin == true) {
							view.show(parent, "Admin View");
						} else
							view.show(parent, "Customer View");
					} else
						view.show(parent, "Login");

				}
			});
			btnLogin_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (isLogedin == true) {
						JOptionPane.showMessageDialog(null,
								"You are already logged in");
						if (isAdmin == true) {
							view.show(parent, "Admin View");
						} else
							view.show(parent, "Customer View");
					} else
						view.show(parent, "Login");

				}
			});

			// Method to set background for LoginView panel
			// to change background for each panel the method must be rewritten
			// each time

		}

		// creating the registration view register, with the name New Account

		// setting the background image of the register page
		{
			try {
				setImg(ImageIO.read(new File(
						"C:\\Users\\reesey\\Pictures\\vacations.jpg")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// overriding the graphics method to set the register page with the
			// background image
			{
				register = new JPanel()

				{
					@Override
					protected void paintComponent(Graphics g) {
						super.paintComponent(g);
						if (getImg() != null) {
							int width = register.getWidth();
							int height = register.getHeight();
							// and do the drawing here:
							g.drawImage(getImg(), 0, 0, width, height, register);
						}
					}

				};
			}
		}

		register.setLayout(null);
		parent.add(register, "New Account");

		newAccount = new JLabel("Register For New Account");
		newAccount.setFont(new Font("Tahoma", Font.BOLD, 12));
		newAccount.setBounds(369, 79, 176, 20);
		register.add(newAccount);

		createUserName = new JLabel("Create User Name");
		createUserName.setFont(new Font("Tahoma", Font.BOLD, 12));
		createUserName.setBounds(174, 149, 140, 20);
		register.add(createUserName);

		textField = new JTextField();
		textField.setBounds(461, 149, 189, 20);
		register.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(461, 180, 189, 20);
		register.add(passwordField);

		createPassword = new JLabel("Create Password");
		createPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		createPassword.setBounds(174, 180, 104, 20);
		register.add(createPassword);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(461, 211, 189, 20);
		register.add(passwordField_1);

		re = new JLabel("Reenter Password");
		re.setFont(new Font("Tahoma", Font.BOLD, 12));
		re.setBounds(174, 211, 115, 20);
		register.add(re);

		ssn = new JLabel("Social Security Number");
		ssn.setFont(new Font("Tahoma", Font.BOLD, 12));
		ssn.setBounds(174, 242, 140, 20);
		register.add(ssn);

		social = new JPasswordField();
		social.setBounds(461, 242, 189, 20);
		register.add(social);

		fName = new JLabel("First Name");
		fName.setFont(new Font("Tahoma", Font.BOLD, 12));
		fName.setBounds(174, 276, 104, 14);
		register.add(fName);

		firstName = new JTextField();
		firstName.setBounds(461, 273, 189, 20);
		register.add(firstName);

		lName = new JLabel("Last Name");
		lName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lName.setBounds(174, 301, 104, 20);
		register.add(lName);

		lastName = new JTextField();
		lastName.setBounds(461, 301, 189, 20);
		register.add(lastName);

		address = new JLabel("Address");
		address.setFont(new Font("Tahoma", Font.BOLD, 12));
		address.setBounds(174, 327, 104, 20);
		register.add(address);

		enterAddress = new JTextField();
		enterAddress.setBounds(461, 327, 189, 20);
		register.add(enterAddress);

		city = new JLabel("City");
		city.setFont(new Font("Tahoma", Font.BOLD, 12));
		city.setBounds(174, 358, 104, 20);
		register.add(city);

		enterCity = new JTextField();
		enterCity.setBounds(461, 358, 189, 20);
		register.add(enterCity);

		state = new JLabel("State");
		state.setFont(new Font("Tahoma", Font.BOLD, 12));
		state.setBounds(174, 388, 104, 20);
		register.add(state);

		st = new JTextField();
		st.setBounds(461, 388, 189, 20);
		register.add(st);

		zip = new JLabel("Zipcode");
		zip.setFont(new Font("Tahoma", Font.BOLD, 12));
		zip.setBounds(174, 415, 104, 20);
		register.add(zip);

		zipcode = new JTextField();
		zipcode.setBounds(461, 415, 189, 20);
		register.add(zipcode);

		dob = new JLabel("Date of Birth");
		dob.setFont(new Font("Tahoma", Font.BOLD, 12));
		dob.setBounds(174, 446, 104, 20);
		register.add(dob);

		birthday = new JTextField();
		birthday.setBounds(461, 446, 189, 20);
		register.add(birthday);

		email = new JLabel("Email Address");
		email.setFont(new Font("Tahoma", Font.BOLD, 12));
		email.setBounds(174, 477, 104, 20);
		register.add(email);

		userEmail = new JTextField();
		userEmail.setBounds(461, 477, 189, 20);
		register.add(userEmail);

		sq = new JLabel("Create Security Question");
		sq.setFont(new Font("Tahoma", Font.BOLD, 12));
		sq.setBounds(174, 508, 176, 20);
		register.add(sq);

		security = new JTextField();
		security.setBounds(461, 508, 189, 20);
		register.add(security);

		sqAnswer = new JLabel("Security Question Answer");
		sqAnswer.setFont(new Font("Tahoma", Font.BOLD, 12));
		sqAnswer.setBounds(174, 547, 176, 20);
		register.add(sqAnswer);

		securityAnswer = new JTextField();
		securityAnswer.setBounds(461, 547, 189, 20);
		register.add(securityAnswer);

		create = new JButton("Create User");
		create.setFont(new Font("Tahoma", Font.BOLD, 12));
		create.setBounds(302, 606, 120, 30);
		register.add(create);

		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (passwordField.getText().equals(passwordField_1.getText())) {
					one.addUser(firstName.getText(), lastName.getText(),
							enterAddress.getText(), enterCity.getText(),
							st.getText(), zipcode.getText(),
							birthday.getText(), textField.getText(),
							passwordField.getText(), userEmail.getText(),
							social.getText(), security.getText(),
							securityAnswer.getText());

					if (one.success == true) {
						view.show(parent, "Login");
						JOptionPane.showMessageDialog(null, "Please Login");
					}

				} else
					JOptionPane.showMessageDialog(null,
							"Password Values Must Match");
			}
		});

		btnLogin_2 = new JButton("Login");
		btnLogin_2.setBounds(834, 0, 89, 25);
		register.add(btnLogin_2);

		btnHome = new JButton("Home");
		btnHome.setBounds(920, 0, 89, 25);
		register.add(btnHome);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isLogedin == true) {
					if (isAdmin == true) {
						view.show(parent, "Admin View");
					} else
						view.show(parent, "Customer View");
				} else
					view.show(parent, "Login");

			}
		});
		btnLogin_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isLogedin == true) {
					JOptionPane.showMessageDialog(null,
							"You are already logged in");
					if (isAdmin == true) {
						view.show(parent, "Admin View");
					} else
						view.show(parent, "Customer View");
				} else
					view.show(parent, "Login");

			}
		});

		// creating the customerView panel this pannel and the admin panel will
		// be the same with a few minor changes

		{
			try {
				setImg(ImageIO.read(new File(
						"C:\\Users\\reesey\\Pictures\\vacations.jpg")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// overriding the graphics method to set the customerView page with
			// the background image
			{
				customerView = new JPanel()

				{
					@Override
					protected void paintComponent(Graphics g) {
						super.paintComponent(g);
						if (getImg() != null) {
							int width = customerView.getWidth();
							int height = customerView.getHeight();
							// and do the drawing here:
							g.drawImage(getImg(), 0, 0, width, height,
									customerView);
						}
					}

				};
			}
		}

		customerView.setLayout(null);
		parent.add(customerView, "Customer View");

		userFlights = new JPanel();
		parent.add(userFlights, "UserFlight");
		userFlights.setLayout(null);

		JButton btnHome_1 = new JButton("Home");
		btnHome_1.setBounds(920, 0, 89, 23);
		userFlights.add(btnHome_1);

		JButton userLogout = new JButton("Logout");
		userLogout.setBounds(833, 0, 89, 23);
		userFlights.add(userLogout);

		JLabel yourAccount = new JLabel("Your Account");
		yourAccount.setFont(new Font("Tahoma", Font.BOLD, 12));
		yourAccount.setBounds(72, 55, 139, 39);
		customerView.add(yourAccount);

		selection = new JComboBox();
		selection.setFont(new Font("Tahoma", Font.BOLD, 11));
		selection.setBounds(10, 105, 268, 39);
		customerView.add(selection);
		selection.addItem("Please Select");
		selection.addItem("Search Flights");
		selection.addItem("My Flights");
		selection.addItem("Remove Flights");
		selection.addItem("Update Information");

		selection.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getItem().equals("Search Flights")) {
					view.show(parent, "Search");

				} else if (selection.getSelectedItem().equals("My Flights")) {
					table_2 = new JTable(getModel(customerFlights));
					model.fireTableDataChanged();
					table_2.addMouseListener(new MouseAdapter() {
						@SuppressWarnings("unchecked")
						public void mouseClicked(MouseEvent e) {
							int result = JOptionPane
									.showConfirmDialog(
											null,
											"would you like to remove flight to your account",
											"Add Flight?",
											JOptionPane.YES_NO_OPTION);
							if (result == JOptionPane.YES_OPTION) {
								String[] value = new String[table_2
										.getColumnCount()];
								model.removeRow(table_2.getSelectedRow());
								// System.out.println(value[i]);
							}

							else {
								JOptionPane.showMessageDialog(null,
										"Nothing Changed");
							}

						}
					});

					JScrollPane user = new JScrollPane(table_2);
					user.setBounds(90, 205, 782, 272);
					userFlights.add(user);
					view.show(parent, "UserFlight");
				}

				else if (selection.getSelectedItem().equals("Remove Flights")) {
					// System.out.println(customerFlights.get(0));
				} else if (selection.getSelectedItem().equals(
						"Update Information")) {
					// TODO
				}

			}
		});

		JButton logout = new JButton("Logout");
		logout.setBounds(832, 0, 89, 26);
		customerView.add(logout);
		logout.setFont(new Font("Tahoma", Font.BOLD, 11));

		button_1 = new JButton("Home");
		button_1.setBounds(920, 0, 89, 26);
		customerView.add(button_1);
		button_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.show(parent, "Login");

			}
		});
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isAdmin = false;
				isLogedin = false;
				view.show(parent, "Login");

			}
		});

		// creating the admin view

		{
			try {
				setImg(ImageIO.read(new File(
						"C:\\Users\\reesey\\Pictures\\vacations.jpg")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// overriding the graphics method to set the adminView page with the
			// background image
			{
				adminView = new JPanel()

				{
					@Override
					protected void paintComponent(Graphics g) {
						super.paintComponent(g);
						if (getImg() != null) {
							int width = adminView.getWidth();
							int height = adminView.getHeight();
							// and do the drawing here:
							g.drawImage(getImg(), 0, 0, width, height,
									adminView);
						}
					}

				};
			}
		}

		parent.add(adminView, "Admin View");
		adminView.setLayout(null);

		adminFlight = new JPanel();
		parent.add(adminFlight, "adminFlight");

		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(836, 0, 89, 25);
		adminView.add(btnLogout);
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 11));

		JButton adminBtn1 = new JButton("Home");
		adminBtn1.setBounds(920, 0, 89, 25);
		adminView.add(adminBtn1);

		adminBtn1.setFont(new Font("Tahoma", Font.BOLD, 11));
		JLabel yourAccount1 = new JLabel("Your Account");
		yourAccount1.setFont(new Font("Tahoma", Font.BOLD, 12));
		yourAccount1.setBounds(72, 55, 139, 39);
		adminView.add(yourAccount1);

		selection1 = new JComboBox();
		selection1.setFont(new Font("Tahoma", Font.BOLD, 11));
		selection1.setBounds(10, 105, 268, 39);
		adminView.add(selection1);
		selection1.addItem("Please Select");
		selection1.addItem("Search Flights");
		selection1.addItem("My Flights");
		selection1.addItem("Update Flights");

		selection1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getItem().equals("Search Flights")) {
					view.show(parent, "Search");

				} else if (selection1.getSelectedItem().equals("My Flights")) {
					table = new JTable(getModel(customerFlights));
					model.fireTableDataChanged();
					table.addMouseListener(new MouseAdapter() {
						@SuppressWarnings("unchecked")
						public void mouseClicked(MouseEvent e) {
							int result = JOptionPane
									.showConfirmDialog(
											null,
											"would you like to remove flight to your account",
											"Add Flight?",
											JOptionPane.YES_NO_OPTION);
							if (result == JOptionPane.YES_OPTION) {
								String[] value = new String[table
										.getColumnCount()];
								model.removeRow(table.getSelectedRow());
								// System.out.println(value[i]);
							}

							else {
								JOptionPane.showMessageDialog(null,
										"Nothing Changed");
							}

						}
					});

					JScrollPane administrator = new JScrollPane(table);
					administrator.setBounds(90, 205, 782, 272);
					userFlights.add(administrator);
					view.show(parent, "UserFlight");
				}

				else if (selection.getSelectedItem().equals("Remove Flights")) {
					// System.out.println(customerFlights.get(0));
				} else if (selection.getSelectedItem().equals(
						"Update Information")) {
					// TODO
				}

			}
		});

		// creating the mainpanel view named home

		{
			try {
				setImg(ImageIO.read(new File(
						"C:\\Users\\reesey\\Pictures\\vacations.jpg")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// overriding the graphics method to set the mainPanel page with the
			// background image
			{
				mainPanel = new JPanel()

				{
					@Override
					protected void paintComponent(Graphics g) {
						super.paintComponent(g);
						if (getImg() != null) {
							int width = mainPanel.getWidth();
							int height = mainPanel.getHeight();
							// and do the drawing here:
							g.drawImage(getImg(), 0, 0, width, height,
									mainPanel);
						}
					}

				};
			}
		}
		mainPanel.setLayout(null);
		parent.add(mainPanel, "Search");
		roundTrip.setFont(new Font("Tahoma", Font.BOLD, 11));
		roundTrip.setBounds(325, 87, 108, 25);
		mainPanel.add(roundTrip);
		oneWay.setFont(new Font("Tahoma", Font.BOLD, 11));

		oneWay.setBounds(436, 87, 94, 25);
		mainPanel.add(oneWay);
		// populating data for flights into JLists

		one.getFlights();
		dept_list = new JComboBox(one.listModel);
		dept_list.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED)
					return;
				valueOfDept = dept_list.getSelectedItem().toString();
			}
		});

		dept_list.setBounds(191, 195, 242, 25);
		mainPanel.add(dept_list);

		arrive_list = new JComboBox(one.listModel2);
		arrive_list.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED)
					return;
				valueOfArrive = arrive_list.getSelectedItem().toString();
			}
		});

		arrive_list.setBounds(534, 195, 242, 25);
		mainPanel.add(arrive_list);

		JLabel city_Dept = new JLabel("Departing City");
		city_Dept.setFont(new Font("Tahoma", Font.BOLD, 12));
		city_Dept.setBounds(191, 156, 115, 28);
		mainPanel.add(city_Dept);

		JLabel city_Dest = new JLabel("Destination City");
		city_Dest.setFont(new Font("Tahoma", Font.BOLD, 12));
		city_Dest.setBounds(534, 156, 137, 28);
		mainPanel.add(city_Dest);

		go.setFont(new Font("Tahoma", Font.BOLD, 11));

		go.setBounds(790, 348, 89, 25);
		mainPanel.add(go);
		go.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new SearchFlight().getSearch(dept_list.getSelectedItem()
						.toString(), arrive_list.getSelectedItem().toString());
						
				System.out.println(customerFlights);
				getModel(customerFlights).fireTableDataChanged();

			}
		});
		home.setBounds(834, 0, 89, 25);
		mainPanel.add(home);
		home.setFont(new Font("Tahoma", Font.BOLD, 11));
		logout2.setBounds(920, 0, 89, 25);
		mainPanel.add(logout2);
		logout2.setFont(new Font("Tahoma", Font.BOLD, 11));
		logout2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isLogedin = false;
				isAdmin = false;
				view.show(null, "Login");

			}
		});
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isLogedin == true) {
					if (isAdmin == true) {
						view.show(parent, "Admin View");
					} else
						view.show(parent, "Customer View");
				} else
					view.show(parent, "Login");

			}
		});

		// creating the lookup page view that will call methods of retrieving
		// password

		{
			try {
				setImg(ImageIO.read(new File(
						"C:\\Users\\reesey\\Pictures\\vacations.jpg")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// overriding the graphics method to set the register page with the
			// background image
			{
				lookupView = new JPanel()

				{
					@Override
					protected void paintComponent(Graphics g) {
						super.paintComponent(g);
						if (getImg() != null) {
							int width = lookupView.getWidth();
							int height = lookupView.getHeight();
							// and do the drawing here:
							g.drawImage(getImg(), 0, 0, width, height,
									lookupView);
						}
					}

				};
			}
		}

		parent.add(lookupView, "Lookup");
		lookupView.setLayout(null);

		lblToLookupYour = new JLabel(
				"If you forgot your password complete the informaton below");
		lblToLookupYour.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblToLookupYour.setBounds(259, 127, 383, 22);
		lookupView.add(lblToLookupYour);

		forgot_usernameLb = new JLabel("Enter your username");
		forgot_usernameLb.setFont(new Font("Tahoma", Font.BOLD, 12));
		forgot_usernameLb.setBounds(158, 213, 205, 22);
		lookupView.add(forgot_usernameLb);

		forgot_user = new JTextField();
		forgot_user.setBounds(483, 214, 263, 22);
		lookupView.add(forgot_user);
		forgot_user.setColumns(10);

		forgotSQ = new JLabel("Enter Your Security Question");
		forgotSQ.setFont(new Font("Tahoma", Font.BOLD, 12));
		forgotSQ.setBounds(158, 245, 205, 22);
		lookupView.add(forgotSQ);

		forgot_Sq = new JTextField();
		forgot_Sq.setBounds(483, 247, 400, 20);
		lookupView.add(forgot_Sq);
		forgot_Sq.setColumns(10);

		btnGetLogin = new JButton("Get Login ");
		btnGetLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				one.getLogin(forgot_user.getText(), forgot_Sq.getText(),
						forgot_Sa.getText());
			}
		});
		btnGetLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGetLogin.setBounds(158, 340, 132, 35);
		lookupView.add(btnGetLogin);

		forgotSAnswer = new JLabel("Security Answer");
		forgotSAnswer.setFont(new Font("Tahoma", Font.BOLD, 12));
		forgotSAnswer.setBounds(158, 278, 205, 22);
		lookupView.add(forgotSAnswer);

		forgot_Sa = new JTextField();
		forgot_Sa.setBounds(483, 280, 263, 20);
		lookupView.add(forgot_Sa);
		forgot_Sa.setColumns(10);

		JButton logoutBtn = new JButton("Login");
		logoutBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		logoutBtn.setBounds(837, 0, 89, 28);
		lookupView.add(logoutBtn);

		JButton logoutHome = new JButton("Home");
		logoutHome.setFont(new Font("Tahoma", Font.BOLD, 11));
		logoutHome.setBounds(920, 0, 89, 28);
		lookupView.add(logoutHome);

		logoutHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isLogedin == true) {
					if (isAdmin == true) {
						view.show(parent, "Admin View");
					} else
						view.show(parent, "Customer View");
				} else
					view.show(parent, "Login");
			}
		});
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isLogedin == true) {
					if (isAdmin == true) {
						view.show(parent, "Admin View");
					} else
						view.show(parent, "Customer View");
				} else
					view.show(parent, "Login");
			}
		});

		// creating the password lookup panel

	}

	protected BufferedImage getImg() {

		return img;
	}

	private boolean checkLogin(String username, String password) {

		if ((username.equals("") || (password.equals("")) != true)
				&& (one.login(username, password) == true)) {
			isLogedin = true;
			if (one.isAdmin(username) == true) {
				isAdmin = true;
			}
			return true;
		}
		return false;

	}

	static DefaultTableModel getModel(List<String[]> list) {

		Vector<String> info = new Vector<String>();
		info.addElement("Flight Number");
		info.addElement("Departing City");
		info.addElement("Departing State");
		info.addElement("Destination City");
		info.addElement("Destination State");
		info.addElement("Airline");
		info.addElement("Departing Time");
		info.addElement("Departing Date");

		Vector<Vector<String>> result = new Vector<Vector<String>>();
		Vector<String> data = new Vector<String>();
		for (int i = 0; i < list.size(); i++){
			for (int row = 0; row < 8; row++){
				data.addElement(list.get(i)[row]);
			}
			result.addElement(data);
		}
		
		model = new DefaultTableModel(result, info);
		model.fireTableDataChanged();
		return model;
	}

	protected void setImg(BufferedImage read) {
		img = read;

	}

	public static void main(String[] args) {
		new HomePage();
	}
}