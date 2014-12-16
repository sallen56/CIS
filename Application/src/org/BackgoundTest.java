package org;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
// this is just to test if i can clean the code by calling a method
abstract  class BackgoundTest {
public static BufferedImage img;
public static JPanel panel;
	BackgoundTest(){
		
	}
	
	public  static JPanel getBackground(){
	{//"C:\\Users\\Flagg\\Pictures\\wrapperback.jpg"
		try {
			img=(ImageIO.read(new File(
					"C:\\Users\\reesey\\Pictures\\usvi-beachview5__large.jpg")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		{
			panel = new JPanel()

			{
				@Override
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					if (img != null) {
						int width = img.getWidth();
						int height = img.getHeight();
						// and do the drawing here:
						g.drawImage(img, 0, 0, width, height,panel);
					}
				}

			};	
	
		}
	}
	return panel;
}
}
