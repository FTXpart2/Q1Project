import javax.swing.JPanel;	// Extending JPanel class
import java.awt.Dimension;	// Setting dimensions of JPanel
import java.awt.Graphics;	// Using Graphics object to draw
import java.awt.Color;		// Import Color to use colors
import java.awt.Polygon;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;
import java.io.Serializable;



public class MyPanel extends JPanel implements Serializable
{
  private static final long serialVersionUID = 1L;
  int x,y;
  int cloudX, cloudY;
  int choice, selection;
  int runner;
  Random rand;
  DLList<coordPair> Coyote;
  DLList<coordPair> BerryBush;
  DLList<coordPair> Cloud;
  DLList<coordPair> Flower;
  DLList<coordPair> Trees;
  coordPair test;
  public MyPanel(){
    
    rand = new Random();
    choice = 1;
    selection = 3;
    //coordinate pairs as Nodes to help draw out the items
    Coyote = new DLList<coordPair>();
    Trees = new DLList<coordPair>();
    Cloud = new DLList<coordPair>();
    Flower = new DLList<coordPair>();
    BerryBush = new DLList<coordPair>();
  }
  public Dimension getPreferredSize() {
        return new Dimension(800,550);
    }

	// Gets called automatically
	public void paintComponent(Graphics g)
	{
    super.paintComponent(g);	//Optional as we are drawing entire screen
    drawSky(g);
    drawMountain(g);
    
    for(int i = 0; i < Coyote.size(); i++){
        
      coordPair current = Coyote.get(i);
    
      drawDog(g,current.getX(), current.getY());
      
    }
    
    for(int i = 0; i < Cloud.size(); i++){
      
      drawCloud(Cloud.get(i).getX(), Cloud.get(i).getY(), g);
    }
    for(int i =0; i < Flower.size(); i++){
      drawFlower(g,Flower.get(i).getX(), Flower.get(i).getY());
    }
    for(int i =0; i < BerryBush.size(); i++){
      drawBerries(g, BerryBush.get(i).getX(), BerryBush.get(i).getY());
    }
    for(int i =0; i < Trees.size(); i++){
      drawTree(Trees.get(i).getX(), Trees.get(i).getY(), g);
    }
    

		
    
    
 
  }


    // Custom draw function to draw tree at (x,y)
  public void drawTree(int xL, int yL, Graphics g)
    {
      x = xL;
    
      y = yL;
		// Draw brown trunk first, so it is behind
        Color trunkBrown = new Color(128, 64, 0);
        g.setColor(trunkBrown);
        g.fillRect(x+30,y+50,40,100); 	
			// Center the 40 pixel width in the 100 width oval top
			// xTrunk = xTree + (widthTree - widthTrunk)/2

		// Draw green top second, so it is in front
      if (selection == 1){
        Color topWhite = new Color(212, 208, 207);
        g.setColor(topWhite);
        g.fillOval(x,y,100,100);
      }
      if(selection == 2){
        g.setColor(new Color(95, 84, 38));
        g.fillOval(x,y,100,100);
      }
      else{
        Color topGreen = new Color(41, 163, 41);
        g.setColor(topGreen);
        g.fillOval(x,y,100,100);
      }
    }
	// Custom draw function to draw an 800x600 background at (0,0)
  public void drawSky(Graphics g)
  {
  // Draw sky first over whole 800x600 JPanel and selection for which color of Sky
    if (choice == 1){
      Color skyBlue = new Color(102, 153, 255);
  
      g.setColor(skyBlue);
      g.fillRect(0,0,800,600); 	
    }
    else{
      Color skyBlack = new Color(62, 75, 79);
      g.setColor(skyBlack);
      g.fillRect(0,0,800,600);
    }
    if (selection == 1){
  
    Color grassSnow = new Color(212, 208, 207);
    g.setColor(grassSnow);
    g.fillRect(0,400,800, 200);
    }
    if(selection == 2){
    Color grassFall = new Color(95, 84, 38);
      g.setColor(grassFall);
      g.fillRect(0,400,800,200);
    }if(selection == 3){

  
    Color grassGreen = new Color(64,128,0);
    g.setColor(grassGreen);
    g.fillRect(0,400,800, 200);
  }
  }
  public void drawCloud(int x, int y, Graphics g){
		// x = 350
		// y = 60
    cloudX=x;
    cloudY=y;
		// Create cloud - circle #1 through #5
		g.setColor(Color.white);	// Use default white
        g.fillOval(cloudX,cloudY+40,60,60);
        g.fillOval(cloudX+40,cloudY+40,60,60);
        g.fillOval(cloudX+80,cloudY+40,60,60);
        g.fillOval(cloudX+20,cloudY,60,60);
        g.fillOval(cloudX+60,cloudY,60,60);
    
	}
 
 
  public void drawFlower(Graphics g, int fx, int fy){
    //flower
    g.setColor(new Color(0,200,0));
    g.fillRect(fx-2,fy,4,30);
    g.setColor(new Color(25,255,0));
    g.fillOval(fx-10,fy-10,20,20);
    g.setColor(new Color(139,69,19));
    g.fillOval(fx-5,fy-5,10,10);
    
  }
  public void drawDog(Graphics g, int x, int y){
    //dog
    x = x;
    y = y;
    g.setColor(new Color(107, 87, 73));
    g.fillPolygon(new int[] {x+45, x+50, x+55}, new int[] {y-5, y-20, y-10}, 3);
    g.fillPolygon(new int[] {x+55, x+60, x+65}, new int[] {y-10, y-20, y-5}, 3);
    g.fillRect(x,y,50,20);
    g.fillRect(x+45,y-10,20,20);
    g.fillPolygon(new int[] {x, x-30, x}, new int[] {y, y+30, y+20}, 3);
    g.fillRect(x,y+20,5,15);
    g.fillRect(x+7,y+20,5,15);
    g.fillRect(x+38,y+20,5,15);
    g.fillRect(x+45,y+20,5,15);
    g.setColor(new Color(31, 29, 28));
    g.fillRect(x+60,y,10,5);
  }
  //drwasmountains
  public void drawMountain(Graphics g)
    {
    Color rockGrey = new Color(204, 199, 184);

    Color snowWhite = new Color(255, 254, 252);






    int[] xCoords = {600,750,250};
	  int[] yCoords = {30,400,400};
    g.setColor(rockGrey);
    g.fillPolygon(xCoords, yCoords, 3);

    

    int[] x = {600,630,535};
	  int[] y = {30,100,100};
    g.setColor(snowWhite);
    g.fillPolygon(x, y, 3);

    int[] xCoords2 = {-600+600,-750+600,-250+600};
	  int[] yCoords2 = {30,400,400};
    g.setColor(rockGrey);
    g.fillPolygon(xCoords2, yCoords2, 3);

    g.setColor(snowWhite);

    int[] x2 = {-600+600,-630+600,-535+600};
	  int[] y2 = {30,100,100};
    g.setColor(snowWhite);
    g.fillPolygon(x2, y2, 3);

    int[] xCoords3 = {200, 50, 650};
    int[] yCoords3= {30,400,400};
    g.setColor(rockGrey);
    g.fillPolygon(xCoords3, yCoords3, 3);
    
    g.setColor(snowWhite);
    int[] x3 = {200,-30+200, -535+600+223};
    int[] y3 = {30,100,100};
    g.fillPolygon(x3,y3,3);

    int[] xCoords4 = {600+120, 750+120, 250+120};
    int[] yCoords4 = {30,400,400};
    g.setColor(rockGrey);
    g.fillPolygon(xCoords4, yCoords4, 3);

    g.setColor(snowWhite);
    int[] x4 = {600+120,630+120,535+120};
    int[] y4 = {30,100,100};
    g.fillPolygon(x4,y4,3);


      }
      //drwas berries
      public void drawBerries(Graphics g, int cx, int cy) 
      { 
          g.setColor(new Color(0, 115, 0));
          g.fillOval(cx-30, cy-50, 50, 70);
          g.setColor(new Color(50, 26, 61));
          g.fillOval(cx-20, cy-35, 5, 5);
          g.fillOval(cx-10, cy-25,5,5);
          g.fillOval(cx, cy-5,5,5);
      }

      //adds item to the dllist
    public void addItemsToList(int xx, int yy, String d){
      int itemx= xx;
      int itemy=yy;
      System.out.println(itemx);
      System.out.println(itemy);
      coordPair newAddition = new coordPair(itemx, itemy);
      switch(d){
        case "Flower":
        
          Flower.add(newAddition);
          
          break;
        case "Cloud":
          Cloud.add(newAddition);
          break;
        case "Coyote":
          Coyote.add(newAddition);
          break;
        case "Berry Bush":
          BerryBush.add(newAddition);
          break;
        case "Trees":
          Trees.add(newAddition);
          break;
        default:
          System.out.println("Nothing added");
      }

    }

    //deletes randomly
    public void deleteItems(String x){
      int i =0;
      switch (x) {
        case "Coyote":
            i = rand.nextInt(Coyote.size());
            Coyote.remove(i);
            break;
        case "Berry Bush":
          i = rand.nextInt(Coyote.size());
          BerryBush.remove(i);
          break;
        case "Flower":
          i = rand.nextInt(Flower.size());
          Flower.remove(i);
            break;
        case "Cloud":
          i = rand.nextInt(Cloud.size());
          Cloud.remove(i);
          
            break;
        case "Trees":
          i = rand.nextInt(Trees.size());
          Trees.remove(i);
            
            break;
    }
  }

  //Randomizes everything
  public void randomizeItems(){
    for(int i = 0; i < Coyote.size(); i++){
      test = Coyote.get(i);
      test.randomize(700,200,400);
      Coyote.set(i, test);
    
    }
    
    for(int i = 0; i < Cloud.size(); i++){
      test = Cloud.get(i);
      test.randomize(700,0,50);
      Cloud.set(i, test);
      
    }
    for(int i =0; i < Flower.size(); i++){
      test = Flower.get(i);
      test.randomize(700,200,400);
      Flower.set(i,test);
      
    }
    for(int i =0; i < BerryBush.size(); i++){
      test= BerryBush.get(i);
      test.randomize(700,200,400);
      BerryBush.set(i, test);
    }
    for(int i =0; i < Trees.size(); i++){
      test = Trees.get(i);
      test.randomize(700,200,400);
      Trees.set(i, test);
    }

    repaint();
  }
  //clears screen
  public void clear(){
    for(int i = Coyote.size()-1; i >=0; i--){
      
      Coyote.remove(i);
     

    }
    
    for(int i = Cloud.size()-1; i >=0; i--){
      
      Cloud.remove(i);
    }
    for(int i = Flower.size()-1; i>=0; i--){
      Flower.remove(i);
    }
    for(int i= BerryBush.size()-1;i>=0;i--){
      BerryBush.remove(i);
    }
    for(int i = Trees.size()-1; i>=0; i--){
      Trees.remove(i);
    }

  }

  //save code
  public void saveData(String filename) {
    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
        out.writeObject(this);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public static MyPanel loadData(String filename) {
    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
        return (MyPanel) in.readObject();
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
  
  }
 

  
}
    
  
  

