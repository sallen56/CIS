package org;
//Where am I?
import java.awt.Graphics;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;

import javax.swing.SpinnerDateModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.SpinnerNumberModel;

public class SearchFlight extends HomePage {
	JScrollPane pane;
	JPanel base;
	String[] values;
	List<String[]> list = new Vector<String[]>();
	// ArrayList test= new ArrayList();
	TableModel model;
	JTable create;
	private JScrollPane scroll;
	JSpinner spinner;
	int numOfTickets = 0;

	SearchFlight() {

		base = new JPanel();
		frame.setContentPane(base);
		frame.getContentPane().setLayout(null);

	}

	void setValues(String[] values) {
		this.values = new String[one.table.getColumnCount()];
		this.values = values;
	}

	String[] getValues() {
		return values;
	}

	void getSearch(String leave, String dest) {
		one.searchFlight(leave, dest);
		pane = new JScrollPane(one.table);

		pane.setBounds(200, 200, 800, 243);

		frame.getContentPane().add(pane);
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 99, 1));
		spinner.setBounds(172, 41, 115, 20);

		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				numOfTickets = Integer.parseInt(spinner.getValue().toString());

			}
		});

		frame.getContentPane().add(spinner);

		one.table.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unchecked")
			public void mouseClicked(MouseEvent e) {
				String[]value = new String[one.table.getColumnCount()];
				for (int i = 0; i < one.table.getColumnCount(); i++) {
						value[i] = one.table.getValueAt(0, i).toString();
				}
				
				if(one.bookFlight(value[0], numOfTickets) == 0){
					JOptionPane.showMessageDialog(null, "Sorry Flight Is Full");
				}else{
				int result = JOptionPane.showConfirmDialog(null,
						"would you like to add flight to your account",
						"Add Flight?", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					one.addItem = true;
					System.out.println(numOfTickets);
					 
					
						// System.out.println(value[i]);
					}
					
				//		JOptionPane.showMessageDialog(null,
					//			"Sorry Flight is full");
				//	}
					

					setValues(value);
					list.add(value);
					addToArraylist((list));
					for (int i = 0; i < value.length; i++)
						HomePage.model.fireTableCellUpdated(
								HomePage.getModel(customerFlights)
										.getRowCount() + 1, i);
					

					JOptionPane.showMessageDialog(null,
							"Flight is added to your account");
					frame.setVisible(false);
					int question = JOptionPane
							.showConfirmDialog(
									null,
									"would you like to add another flight to your account",
									"Add Flight?", JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION) {
						HomePage.addMore = true;
						HomePage.getModel(customerFlights)
								.fireTableDataChanged();
						System.out.println(HomePage.getModel(customerFlights)
								.getRowCount());
					}
				else {
					one.addItem = false;
					JOptionPane.showMessageDialog(null, "GOODBYE");
					HomePage.addMore = false;
				}

			
			}//end of else = 0
			}
		});
		
	}

	// SearchFlight(String testing){
	// create= new JTable(getVector(list));
	// scroll=new JScrollPane(create);

	// scroll.setBounds(200, 200, 800, 243);
	//
	// frame.getContentPane().add(scroll);
	// }

	static void addToArraylist(List<String[]> one) {
		for (int i = 0; i < one.size(); i++)
			HomePage.customerFlights.add(one.get(i));
		System.out.print(HomePage.customerFlights);
	}

	{
		base = new JPanel()

		{
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				if (getImg() != null) {
					int width = base.getWidth();
					int height = base.getHeight();
					// and do the drawing here:
					g.drawImage(getImg(), 0, 0, width, height, base);
				}
			}

		};
	}

	JPanel getBase() {
		return base;
	}
}