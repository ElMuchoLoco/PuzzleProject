import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.Image;

import java.awt.*; //IMPORT ALL .AWT METHODS

import java.awt.event.*;

import javax.swing.*; //IMPORT ALL JAVAX SWING CLASSES/METHODS

import javax.swing.border.*;

import java.util.*;

import java.lang.*;
import java.lang.Object;
import javax.swing.ImageIcon;

public class Seven extends JFrame implements ActionListener
{
	/*
	setDefaultCloseOperation(SecondAttempt.DISPOSE_ON_CLOSE);
	setSize(600,600);
	setVisible(true);
	* */
	
	 public Seven()
	 {
		 setSize(444,410); //Set Size Of JFrame
		 Populate(); //Jump & Link To JPanel Creation & Working
	 }
	 
	 public void Populate() //Code Jump & Link
	 {
		 JPanel WindowContents = new JPanel(); // Create New JPanel Called WindowContects
		 BorderLayout borderlayout = new BorderLayout(); //Creates BorderLayout Object
		 WindowContents.setLayout(borderlayout); //Sets Border Layout Using BorderLayout Object
		 WindowContents.setSize(600,600); //Set Size Of Windows Contents
		 WindowContents.setVisible(true); //Set Window Contents To Be Visible
		 WindowContents.setLayout(new GridLayout(3, 4)); //Sets Ordered Grid LAyout For JPanel
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		Icon IconArray[] = new ImageIcon[12]; //Create Array For Images
		IconArray[0] = new ImageIcon("bart0.jpg"); //Step Through Populate Each Array Entry With Each Image
		IconArray[1] = new ImageIcon("bart1.jpg");
		IconArray[2] = new ImageIcon("bart2.jpg");
		IconArray[3] = new ImageIcon("bart3.jpg");
		IconArray[4] = new ImageIcon("bart4.jpg");
		IconArray[5] = new ImageIcon("bart5.jpg");
		IconArray[6] = new ImageIcon("bart6.jpg");
		IconArray[7] = new ImageIcon("bart7.jpg");
		IconArray[8] = new ImageIcon("bart8.jpg");
		IconArray[9] = new ImageIcon("bart9.jpg");
		IconArray[10] = new ImageIcon("bart10.jpg");
		IconArray[11] = new ImageIcon("bart11.jpg"); //Final Step Through
		
		/*MattButton*/JButton JTileArray[] = new /*MattButton*/JButton[12];//Declare Array To Hold JButtons
		
		int counter = 0; //Initialise Counter For While Loop
		
		while(counter<12)
		{
			JButton tile = new JButton(IconArray[counter]); //Create New JButton With Image called Tile
			tile.addActionListener(this); //AddActionListener To This Tile
			//tile.setOpaque(true);	//Idea For Transparency (REDUNDANT REMOVE)
			JTileArray[counter] = tile   ; //Walks Over Creating JTiles With Each BartImage To Corresponding Button In J Tile Array
			
			//JTileArray[counter].addActionListener(this); //ATTEMPTING TO ADD ACTION LISTENER (REDUNDANT REMOVE)
			counter = counter + 1; //
		}
		counter = counter-counter;
		
		while(counter<12)
		{
			WindowContents.add(JTileArray[counter]); //Add Each JTile From Array To Panel
			counter = counter + 1;
		}
		counter = counter - counter; //ResetLoop Counter
		
		//JTileArray[0].setVisible(false);	//Sets First J Tile To False 
		setContentPane(WindowContents);			//Set The JPanel (WindowsContents To JFrame)
	}
	
	public static void main(String [] args)
	{
		Six ShowMe = new Six();
		ShowMe.setVisible(true);		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{ 
		
		JButton something = (JButton) e.getSource(); //Something Stores The Tile That Clicks The Button
		Icon StoreClickedImage = something.getIcon();
		//JTileArray[0].setIcon(StoreClickedImage);
		
		int isolatedcounter = 0;
		
		while(isolatedcounter < 12)
		{
			JButton ReplacerTile = JTileArray[isolatedcounter];
			ReplacerTile.getIcon();
			//Icon ArrayWalkover = JTileArray[isolatedounter];
			//ArrayWalkover.getIcon();
		}
		/*IMAGEASSIGNMENTCODE*/ Icon GreyBox = new ImageIcon("bart0.jpg"); //Stores The Grey Box As An Image
		/*IMAGEASSIGNMENTCODE*/ JButton tile2 = new JButton(GreyBox); //Assigns The Grey Box To A JButton				
		/*IMAGEASSIGNMENTCode*/ something.setIcon(GreyBox);
				
				/* line 108PROOFOFWORKING something.setOpaque(false);
		PROOFOFWORKING something.setContentAreaFilled(false);
		 line 110PROOFOFWORKING something.setBorderPainted(false);*/
		 
		 		/* line 116 tile2.setOpaque(false);
		 tile2.setContentAreaFilled(false);
		tile2.setBorderPainted(false);
		tile2.setVisible(true); line 119 */
		//WORKINGINVISIBLECODE//something.setVisible(false);
		}
	} 
/*
 * Want to declare a variable to store the source of the action event
 * so that i can then set this variable to false
 * GOAL: To Set The Button Click To Turn Invisible
 * */

	
	
