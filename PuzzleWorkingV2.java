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

public class PuzzleWorkingV2 extends JFrame implements ActionListener
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

  JPanel WindowContents = new JPanel(); //PUSHED TO GLOBAL FOR ACCESS
  
  	JPanel TopMenuBar = new JPanel(); //PUSHED TO GLOBAL FOR ACCESS
  	
  		  JLabel textLabel = new JLabel("Score =" + numberofclicks, SwingConstants.CENTER); //PUSHED TO GLOBAL FOR ACESS
  		  
  		   JPanel TopMenuPanel = new JPanel(); //TOP MENU BAR PUSHED TO GLOBAL FOR ACCESS
  		   
  		    JButton TopMenuButtonLeft = new JButton("Current Score = " + numberofclicks);

			JButton TopMenuButtonMiddle = new JButton("Randomiser Button");
			
			JButton TopMenuButtonRight = new JButton("New Game");
			
				 JPanel NewOverPanel = new JPanel();


 public PuzzleWorkingV2() 
  {
   //setSize(474,396);-50For Top Menu Bar
   setSize(474,446);
   Populate();
   setTitle("Number Of Clicks = " + numberofclicks);
  }

 public void Populate()
 {
	 Dimension OverPanelSize = new Dimension(474,446); //Set Size Of OverPanel
	 //JPanel NewOverPanel = new JPanel();
	 NewOverPanel.setPreferredSize(OverPanelSize);
	 NewOverPanel.setVisible(true); //Set Overpanel To Size (480,400);
	 setContentPane(NewOverPanel); //Create This Windows As The OverPanel
	
	TopMenuBar();
		 
  WindowContents.setSize(474,404); //SetSize of Panel
  WindowContents.setVisible(true); //Set Panel To Visible
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

//for(int randomisercounter = 0; randomisercounter <20; randomisercounter++)
//{
Randomiser(); //RANDOMISER CODE
//}

	NewOverPanel.add(WindowContents);
  //WindowContents.pack();
 }
 public void TileSwap()
 {
	 		Icon storeblankTile = new ImageIcon("bart0.jpg");	//Create An Icon Of Bart 0.jpg
			Icon storeclickedicon = new ImageIcon(clickediconreference.getIcon().toString()); //Copy The Image  From The Tile That Was Clicked
			TileArray[greyrowlocation][greycolumnlocation].setIcon(storeclickedicon); // Assign The Image Of The Tile That Was Clicked To The Reference For The Tile Where Thre Grey Box Is
			clickediconreference.setIcon(storeblankTile); //Assign The GreyBox Image To The Tile That Was Clicked
			System.out.println("Eligible And Executed 4");
			numberofclicks++;
 }
 
 public void TopMenuBar()
 {

 TopMenuPanel.setLayout(new GridLayout(1,3));
 TopMenuPanel.setSize(474,50);
 TopMenuPanel.setVisible(true);
 
 //JButton TopMenuButtonLeft = new JButton("Current Score = " + numberofclicks);
 TopMenuButtonLeft.addActionListener(this);
 //JButton TopMenuButtonMiddle = new JButton("Randomiser Button");
 TopMenuButtonMiddle.addActionListener(this);
// JButton TopMenuButtonRight = new JButton("New Game");
 TopMenuButtonRight.addActionListener(this);
 
 TopMenuPanel.add(TopMenuButtonLeft);
 TopMenuPanel.add(TopMenuButtonMiddle);
 TopMenuPanel.add(TopMenuButtonRight);
 
 NewOverPanel.add(TopMenuPanel);
 
 }

 public void Randomiser2() //REWRITE RANDOMISER TO SHUFFLE THE GREY BOX RATHER THAN RANDOMLY SELECT
 { 
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
 
 public void Randomiser()
 { 
	 for(int clickcounter = 0; clickcounter<400; clickcounter++)
	 {
	 Random rand = new Random();
	 Random rand2 = new Random();
	 
	 int robotrandomisercolumn = rand.nextInt(3);
	 int robotrandomiserrow = rand2.nextInt(2);
	 
	 TileArray[robotrandomiserrow][robotrandomisercolumn].doClick();
	 }
	 
 }
 
 public void RandomiserNew()
 {
	 Random rand = new Random();
	 
	 int greyrandomisercolumn = 0;
	 int greyrandomiserrow = 0;
	 
	 for(int counterofrows = 0; counterofrows<rows; counterofrows++)
	 {
		 for(int counterofcolumns = 0; counterofcolumns<columns; counterofcolumns++)
		 {
			 if(TileArray[counterofrows][counterofcolumns].getIcon().toString().compareTo(GreyBoxGlobalStorageString) == 0)
			 {
				greyrandomisercolumn = counterofcolumns;
				greyrandomiserrow = counterofrows;
			 }
		 }
	 }
	 
	 for(int numberofrotations = 600; numberofrotations > 0; numberofrotations--)
	 {	
	 int randomupto3 = rand.nextInt(3);//For Columns
	 int randomupto2 = rand.nextInt(2);//For Rows
	 
	 if(TileArray[randomupto2][randomupto3].getIcon().toString().compareTo(GreyBoxGlobalStorageString) != 0)
	 {
	 if(randomupto2 == greyrandomiserrow)
	 {
		 if(randomupto3 - 1 == greyrandomisercolumn)
		 {
			Icon IconOfRandomTile = TileArray[randomupto2][randomupto3].getIcon(); //Take the image from the randomly selected tile
			TileArray[randomupto2][randomupto3].setIcon(GreyBoxGlobalStorageIcon); //Set The Image Of The Grey Box To The Randomly Selected Tile (Eligibility Confirmed)
			TileArray[greyrandomiserrow][greyrandomisercolumn].setIcon(IconOfRandomTile); //Set The Image Of The The Randomly Selected Tile To The Location Of The Grey Box
		 }
		 if(randomupto3 + 1 == greyrandomisercolumn)
		 {
			 Icon IconOfRandomTile = TileArray[randomupto2][randomupto3].getIcon(); //Take the image from the randomly selected tile
			TileArray[randomupto2][randomupto3].setIcon(GreyBoxGlobalStorageIcon); //Set The Image Of The Grey Box To The Randomly Selected Tile (Eligibility Confirmed)
			TileArray[greyrandomiserrow][greyrandomisercolumn].setIcon(IconOfRandomTile); //Set The Image Of The The Randomly Selected Tile To The Location Of The Grey Box
		 }
	 }
		if(randomupto3 == greyrandomisercolumn)
		{
			if(randomupto2 - 1 == greyrandomiserrow)
			{
				Icon IconOfRandomTile = TileArray[randomupto2][randomupto3].getIcon(); //Take the image from the randomly selected tile
			TileArray[randomupto2][randomupto3].setIcon(GreyBoxGlobalStorageIcon); //Set The Image Of The Grey Box To The Randomly Selected Tile (Eligibility Confirmed)
			TileArray[greyrandomiserrow][greyrandomisercolumn].setIcon(IconOfRandomTile); //Set The Image Of The The Randomly Selected Tile To The Location Of The Grey Box
			}
			if(randomupto2 + 1 ==  greyrandomiserrow)
			{
			Icon IconOfRandomTile = TileArray[randomupto2][randomupto3].getIcon(); //Take the image from the randomly selected tile
			TileArray[randomupto2][randomupto3].setIcon(GreyBoxGlobalStorageIcon); //Set The Image Of The Grey Box To The Randomly Selected Tile (Eligibility Confirmed)
			TileArray[greyrandomiserrow][greyrandomisercolumn].setIcon(IconOfRandomTile); //Set The Image Of The The Randomly Selected Tile To The Location Of The Grey Box
			}
		}
	}
	}
}
public static void main(String [] args)
  {
   PuzzleWorkingV2 ShowMe = new PuzzleWorkingV2();
   ShowMe.setVisible(true);
  }
	@Override
	public void actionPerformed(ActionEvent e) 
	{	
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
				numberofclicks++;
			}
			
			if((clickedrowlocation - 1 == greyrowlocation))
				{
				TileSwap();
				numberofclicks++;
				}
			}
			
			if(clickedrowlocation == greyrowlocation)
			{
			if((clickedcolumnlocation + 1 == greycolumnlocation)) 
	 			{
					TileSwap();
					numberofclicks++;
				}
			
			if((clickedrowlocation == greyrowlocation && clickedcolumnlocation - 1 == greycolumnlocation))
			{
				TileSwap();
				numberofclicks++;
			}			
		} 
				
				JButton TopMenuButtonLeftReplacement = new JButton("Number Of Clicks" + numberofclicks);
				TopMenuButtonLeft = TopMenuButtonLeftReplacement;
				
				if(e.getSource() == TopMenuButtonLeft)
				{
				
					//NO PARTICULAR FUNCTION NEEDED IF SCORE BUTTON IS CLICKED
				}
				
				if(e.getSource() == TopMenuButtonMiddle)
				{
				
					Randomiser();
				}
				
				if(e.getSource() == TopMenuButtonRight)
				{
					//FUNCTIONS TO CREATE HIGH SCORE
					//e.getSource() ("Number Of Clicks = " + numberofclicks);
				}
}

}
