import java.awt.*; //IMPORT ALL .AWT METHODS

import java.awt.event.*;

import javax.swing.*; //IMPORT ALL JAVAX SWING CLASSES/METHODS

import javax.swing.border.*;

import java.util.*;

import java.lang.*;
import java.lang.Object;
import javax.swing.ImageIcon;

import java.lang.Object;
import java.lang.Math;

import java.util.concurrent.ThreadLocalRandom;

public class Puzzle10 extends JFrame implements ActionListener
{
 int rows = 3;//value for y rows 
 int columns = 4;//value for x columns
 int rowscounter = 0; //counter for for loops for y axis
 int columnscounter = 0; //counter for for loops x axis
 int insertcounter = 0; //insertcounter to count across executions

 JButton[][] TileArray = new JButton[rows][columns]; //JButton 2d Array To Put Tiles On
 Icon[] IconArray = new ImageIcon[12]; //Image Icons With Extra For Potential Temp Storage
 int counter = 0; //Generic Global Counter

 Icon GreyBoxGlobalStorageIcon = new ImageIcon("bart0.jpg"); //Permanent Global Storage OF GreyBox Image
 String GreyBoxGlobalStorageString = GreyBoxGlobalStorageIcon.toString(); //Permanent Global Storage Of String For GreyBox Image
 
 Icon ImageToBeChecked; //Icon Image To Be Checked To Be Declared In Global For Accesibility

 int greyrowlocation; //GreyRowLocation Declared In Global For Accessibility Is Re-Written Each Time Function Is Called Anyway
 int greycolumnlocation; //GreyColumnLocation Declared In Global For Accessibility Is Re-Written Each Time Function Is Called Anyway
 
 int clickedrowlocation; //clickedrowlocation declared in global for accesibility
 int clickedcolumnlocation; //clicked column declared in global for accesibility

int numberofclicks; //numberofclicks declared in global to carry over across whole program AKA Accesibility

JButton clickediconreference; //JButton declared in global so as to be accessed across constructor/accessor/mutator methods - ACCESSIBLE

 public Puzzle10() 
  {
   setSize(440,400);
   Populate();
  }

 public void Populate()
 {
  JPanel WindowContents = new JPanel();
  BorderLayout borderlayout = new BorderLayout();
  WindowContents.setLayout(borderlayout);
  WindowContents.setSize(240,400);
  WindowContents.setVisible(true);
  WindowContents.setLayout(new GridLayout(3, 4));
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Icon IconArray[] = new ImageIcon[12];
		
		for (int imagecounter = 0; imagecounter <12; imagecounter++)
		{
			IconArray[imagecounter] = new ImageIcon("bart" + imagecounter + ".jpg");
		}


rowscounter = 0;
columnscounter = 0;
insertcounter = 0;

 while(rowscounter < rows)
 {
  columnscounter = 0;
  while(columnscounter<columns)
   {
    JButton Tile = new JButton(IconArray[insertcounter]);
    Tile.addActionListener(this);
    TileArray[rowscounter][columnscounter] = Tile;
    columnscounter = columnscounter + 1;
    insertcounter = insertcounter + 1;
   }
  rowscounter = rowscounter + 1;
 }

rowscounter = 0;
columnscounter = 0;
insertcounter = 0;

while(rowscounter < rows)
  {
   columnscounter = 0;
   while(columnscounter < columns)
   {
    WindowContents.add(TileArray[rowscounter][columnscounter]);
    columnscounter = columnscounter + 1;
   }
  rowscounter = rowscounter + 1;
 }

 rowscounter = 0;
 columnscounter = 0;
 insertcounter = 0;

for(int randomisercounter = 0; randomisercounter <20; randomisercounter++)
{
Randomiser();
}

  setContentPane(WindowContents);
 }
 public void TileSwap()
 {
	 		Icon storeblankTile = new ImageIcon("bart0.jpg");	//Create An Icon Of Bart 0.jpg
			Icon storeclickedicon = new ImageIcon(clickediconreference.getIcon().toString()); //Copy The Image  From The Tile That Was Clicked
			TileArray[greyrowlocation][greycolumnlocation].setIcon(storeclickedicon); // Assign The Image Of The Tile That Was Clicked To The Reference For The Tile Where Thre Grey Box Is
			clickediconreference.setIcon(storeblankTile); //Assign The GreyBox Image To The Tile That Was Clicked
			System.out.println("Eligible And Executed 4");
 }
 //threadlocalrandom
 //import a new library
 public void Randomiser()
 { //threadlocalrandom
	 Random rand = new Random();
	 int randombetween12a = rand.nextInt(12);
	 int randombetween12b = rand.nextInt(12);
	 int randomylocation1 = rand.nextInt(2);
	 int randomxlocation1 = rand.nextInt(3);
	 int randomylocation2 = rand.nextInt(2);
	 int randomxlocation2 = rand.nextInt(3);
	 
	 Icon First = new ImageIcon(TileArray[randomxlocation1][randomylocation1].getIcon().toString());
	 Icon Second = new ImageIcon(TileArray[randomxlocation2][randomylocation2].getIcon().toString());
	 TileArray[randomxlocation1][randomylocation1].setIcon(Second);
	 TileArray[randomxlocation2][randomylocation2].setIcon(First);
 }

public static void main(String [] args)
  {
   Puzzle10 ShowMe = new Puzzle10();
   ShowMe.setVisible(true);
  }
	@Override
	public void actionPerformed(ActionEvent e) 
	{ //1
		numberofclicks++;
		
	clickediconreference = (JButton) e.getSource();

 	rowscounter = 0;
 	columnscounter = 0;	
 	
	while(rowscounter < rows)
	  {
	   columnscounter = 0;
	   while(columnscounter < columns) //walks through whole array to find the grey tile
	   {
	    if(TileArray[rowscounter][columnscounter].getIcon().toString().compareTo(GreyBoxGlobalStorageString) == 0) //confirms by comparing strings
		{
		greyrowlocation = rowscounter; //when grey box is found stored it's row value
		greycolumnlocation = columnscounter; //when grey box is found do a flash copy of it's column location
				break;		
		}	    
		columnscounter = columnscounter + 1; //INCREMENT THROUGH X DIRECTION
	   }
	  rowscounter = rowscounter + 1; //INCREMENT THROUGH Y DIRECTION
	 }

	 for(rowscounter = 0; rowscounter < rows; rowscounter++){ //FINDS THE CLICKED BOX
		 columnscounter = 0;
		 for(columnscounter = 0; columnscounter < columns; columnscounter++){
			 if(TileArray[rowscounter][columnscounter].getIcon().toString().compareTo(clickediconreference.getIcon().toString()) == 0)
				{
					clickedrowlocation = rowscounter;
					clickedcolumnlocation = columnscounter;
					break;
				}
		 }
	 }
			System.out.println("No. Of Click  -->  (" + numberofclicks + ")");
			System.out.println("greyrowlocation = " + greyrowlocation);
			System.out.println("greycolumnlocation = " + greycolumnlocation);
			System.out.println("clickedrowlocation = " + clickedrowlocation);
			System.out.println("clickedcolumnlocation = " + clickedcolumnlocation);
			
			if(clickedcolumnlocation == greycolumnlocation)
			{
			if((clickedrowlocation + 1 == greyrowlocation))
			{
				TileSwap();
			}
			
			if((clickedrowlocation - 1 == greyrowlocation))
				{
				TileSwap();
				}
			}
			
			if(clickedrowlocation == greyrowlocation)
			{
			if((clickedcolumnlocation + 1 == greycolumnlocation))
	 			{
					TileSwap();
				}
			
			if((clickedrowlocation == greyrowlocation && clickedcolumnlocation - 1 == greycolumnlocation))
			{
				TileSwap();
			}			
		} 
}
}
//}

