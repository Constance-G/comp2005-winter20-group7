import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JPanel;

public class GamePanel extends JPanel {//Refactored from GamePanel

	//Dimension SCREENSIZE = Toolkit.getDefaultToolkit().getScreenSize();
	private final Dimension SCREENSIZE =GameBoard.SCREENSIZE;
	String boardType;
	int fontSize;
	boolean colorCheck;
	Robot[] robots =null;

	
	GamePanel(String config,PlayersSetup players,boolean colorCheckIn,int fontSizeIn){
		
		setPreferredSize(new Dimension((int) (SCREENSIZE.width),(int) (SCREENSIZE.height)));
		setLayout(new BorderLayout());

		boardType = config;
		fontSize = fontSizeIn;
		colorCheck = colorCheckIn;
		String[][] mapGen;
		System.out.println(colorCheckIn);
		robots =generateRobots(colorCheckIn);
		if(config.equals("simple")) {//Creates the game in Simple formatting
			mapLayout = simpleMapPanel();
			mapGen = buildMap(mapLayout);

			frame =createFrame(mapGen);

		}else {//Creates the game in Complex formatting
			mapLayout = complexMapPanel();
			mapGen = buildMap(mapLayout);
			frame =createFrame(mapGen);
		}
		
		
		
			
	}
	
	private void checkRobotOverlap() {//This is used when generating the inital Robots to make sure they are in legal spots


		Point[] robotPoints = new Point[4];

		ArrayList<Point> obsticles = new ArrayList<Point>();

		robotPoints[0] = robots[0].location;
		robotPoints[1] = robots[1].location;
		robotPoints[2] = robots[2].location;
		robotPoints[3] = robots[3].location;

		obsticles.add(new Point(7,7));
		obsticles.add(new Point(8,7));
		obsticles.add(new Point(8,8));
		obsticles.add(new Point(7,8));

		Point pointIndex;
		int index = 0;
		//Check if 2 are on the same piece
		for(Point robotPoint : robotPoints) {
			pointIndex = robotPoint;
			
			for(int i = 0; i < robotPoints.length;i++) {
				
				if(robotPoints[i].equals(pointIndex)&& !robotPoints[i].equals(robotPoints[index])) {
					
					generateRobots(colorCheck);
					//checkRobotOverlap();
					return;
				}
				
			}
			index++;
			
		}
		
		//Check if they are on an obsticle
		
		for(Point obsticle: obsticles) {
			
			for(Point robotPoint: robotPoints) {
				
				
				if(obsticle.equals(robotPoints)) {
					generateRobots(colorCheck);
					//checkRobotOverlap();
					return;
				}
			}
			
		}
		//Check if they are on a goal
		
		for(BufferedImage[] image : imageMap) {
			
			for(BufferedImage imag: image) {
				
				MapPiece mapPanel = (MapPiece) imag;
				
				if(mapPanel.token != null&&mapPanel.token.location.equals(robotPoints[0])) {
					generateRobots(colorCheck);
					//checkRobotOverlap();
					return;
				}
				if(mapPanel.token != null&&mapPanel.token.location.equals(robotPoints[1])) {
					generateRobots(colorCheck);
					//checkRobotOverlap();
					return;
				}
				if(mapPanel.token != null&&mapPanel.token.location.equals(robotPoints[2])) {
					generateRobots(colorCheck);
					//checkRobotOverlap();
					return;
				}
				if(mapPanel.token != null&&mapPanel.token.location.equals(robotPoints[3])) {
					generateRobots(colorCheck);
					//checkRobotOverlap();
					return;
				}
			}
		}
		

	}

	Robot[] generateRobots(boolean colorCheckIn) {
		
		Robot[] robotArray = new Robot[4];
		System.out.println(colorCheckIn);
		robotArray[0] = new Robot(1,colorCheckIn);
		robotArray[1] = new Robot(2,colorCheckIn);
		robotArray[2] = new Robot(3,colorCheckIn);
		robotArray[3] = new Robot(4,colorCheckIn);
		
		for(Robot robot: robotArray) {
			
			
			Point point = new Point((int)(Math.random()*15),(int)(Math.random()*15));
		
			//System.out.println(point.x+"   "+point.y);
			robot.setLocation(point,colorCheckIn);	
		}
		
		return robotArray;
		
	}
	
	
	BufferedImage frame;//THis is created by createFrame();
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		if(frame == null) {//If the frame is not generated
			
			String[][] mapGen = buildMap(mapLayout); //Generate a 16x16 String array accurate to the mapLayout	
			frame =createFrame(mapGen); //Create the frame 
			g.drawImage(frame, 0, 0, null);
			
		}else {
			
			g.drawImage(frame, 0, 0, null);//Draw the frame
			frame = null;
		}
		
		//checkRobotOverlap();
	}
	BufferedImage[][] imageMap;
	BufferedImage createFrame(String[][] stringMapArray){//This will be the 16X16 Map to be displayed to the user
		
		imageMap = new BufferedImage[16][16];

		for(int i = 0; i <16;i++) {
			
			for(int j = 0; j <16;j++) {
				
				imageMap[i][j] = new MapPiece(stringMapArray[i][j],SCREENSIZE,fontSize,colorCheck,robots,new Point(i,j));
			}
		}
		
		BufferedImage toDisplay = new BufferedImage(SCREENSIZE.width/20*16,SCREENSIZE.height/20*16,BufferedImage.TYPE_INT_ARGB);
		
		for(int i = 0; i <16;i++) {
	
			for(int j = 0; j <16;j++) {
				
				for(int k = 0; k < imageMap[i][j].getWidth(); k++) {
					
					for(int l = 0; l < imageMap[i][j].getHeight(); l++) {
						
						toDisplay.setRGB((i*SCREENSIZE.width/20)+k, (j*SCREENSIZE.height/20)+l, imageMap[i][j].getRGB(k, l));
						
					}
				}
				
			}
		}
		//TODO: Add players and goals
		return toDisplay;

	}

	
	int mapIndex = 0;
	MapPanel[] mapLayout = new MapPanel[4];
	public boolean isBettingRound = false;

	MapPanel[] simpleMapPanel() {// Recursively creates mapLayout randomly using Math.random();

		if(mapIndex == 4) {
			//Turn these on to hard code the map layout to mp1,mp2,mp3,mp4
			//mapLayout[0] = new SimplePanel1(); 
			//mapLayout[1] = new SimplePanel2(); 
			//mapLayout[2] = new SimplePanel3(); 
			//mapLayout[3] = new SimplePanel4(); 
			return mapLayout;

		}else {
			double rnd =Math.random();
			

			//1
			if(0 <= rnd && rnd <= .25) {			
				for(MapPanel mp : mapLayout) {
					if(mp != null && mp.getClass().equals(SimplePanel1.class)) {//Checks if the map is already in play
						return simpleMapPanel();								//restart the process if so
					}
				}
				mapLayout[mapIndex]= new SimplePanel1(); 
				//System.out.println(":1");
				mapIndex++;	
			}
			//2
			if(.25 < rnd && rnd <= .5) {
				for(MapPanel mp : mapLayout) {
					if(mp != null && mp.getClass().equals(SimplePanel2.class)) {
						return simpleMapPanel();			
					}
				}
				mapLayout[mapIndex] = new SimplePanel2(); 
				//System.out.println(":2");
				mapIndex++;
			}
			//3
			if(.5 < rnd && rnd <= .75) {
				for(MapPanel mp : mapLayout) {
					if(mp != null && mp.getClass().equals(SimplePanel3.class)) {
						return simpleMapPanel();			
					}
				}
				mapLayout[mapIndex] = new SimplePanel3(); 
				//System.out.println(":3");
				mapIndex++;
			}
			//4
			if(.75 < rnd && rnd <= 1) {
				for(MapPanel mp : mapLayout) {
					if(mp != null && mp.getClass().equals(SimplePanel4.class)) {
						return simpleMapPanel();

					}
				}
				mapLayout[mapIndex] = new SimplePanel4(); 
				//System.out.println(":4");
				mapIndex++;
			}
			
			return simpleMapPanel();
		}
	}
	MapPanel[] complexMapPanel() {// Recursively creates mapLayout randomly using Math.random();

		if(mapIndex == 4) {
			//Turn these on to hard code the map layout to mp1,mp2,mp3,mp4
			//mapLayout[0] = new SimplePanel1(); 
			//mapLayout[1] = new SimplePanel2(); 
			//mapLayout[2] = new SimplePanel3(); 
			//mapLayout[3] = new SimplePanel4(); 
			return mapLayout;

		}else {
			double rnd =Math.random();
			

			//1
			if(0 <= rnd && rnd <= .25) {			
				for(MapPanel mp : mapLayout) {
					if(mp != null && mp.getClass().equals(ComplexPanel1.class)) {
						return complexMapPanel();			
					}
				}
				mapLayout[mapIndex]= new ComplexPanel1(); 
				//System.out.println(":1D");
				mapIndex++;	
			}
			//2
			if(.25 < rnd && rnd <= .5) {
				for(MapPanel mp : mapLayout) {
					if(mp != null && mp.getClass().equals(ComplexPanel2.class)) {
						return complexMapPanel();			
					}
				}
				mapLayout[mapIndex] = new ComplexPanel2(); 
				//System.out.println(":2D");
				mapIndex++;
			}
			//3
			if(.5 < rnd && rnd <= .75) {
				for(MapPanel mp : mapLayout) {
					if(mp != null && mp.getClass().equals(ComplexPanel3.class)) {
						return complexMapPanel();			
					}
				}
				mapLayout[mapIndex] = new ComplexPanel3(); 
				//System.out.println(":3D");
				mapIndex++;
			}
			//4
			if(.75 < rnd && rnd <= 1) {
				for(MapPanel mp : mapLayout) {
					if(mp != null && mp.getClass().equals(ComplexPanel4.class)) {
						return complexMapPanel();

					}
				}
				mapLayout[mapIndex] = new ComplexPanel4(); 
				//System.out.println(":4D");
				mapIndex++;
			}
			
			return complexMapPanel();
		}
	}


	//Takes an array MapPanel[] and create a 16x16 GameMap of type String[][]
	String[][] buildMap(MapPanel[] mapLayout ){

		String[][] map = new String[16][16];

		MapPanel mp1 = rotate2DStringArray(mapLayout[0],2);
		MapPanel mp2 = rotate2DStringArray(mapLayout[1],1);
		MapPanel mp3 = rotate2DStringArray(mapLayout[2],4);
		MapPanel mp4 = rotate2DStringArray(mapLayout[3],3);
		
		
		//System.out.println("mp1: " + mp1.getMap()[7][7]);
		//System.out.println("mp2: " + mp2.getMap()[0][7]);
		//System.out.println("mp3: " + mp3.getMap()[0][0]);
		//System.out.println("mp4: " + mp4.getMap()[7][0]);


		for(int i = 0; i< 8; i++) {

			for(int j = 0; j< 8; j++) {

				map[i][j] = mp1.getMap()[i][j];

			}
		}
		for(int i = 0; i< 8; i++) {

			for(int j = 0; j< 8; j++) {

				map[i+8][j] = mp2.getMap()[i][j];

			}
		}
		for(int i = 0; i< 8; i++) {

			for(int j = 0; j< 8; j++) {

				map[i+8][j+8] = mp3.getMap()[i][j];

			}
		}
		for(int i = 0; i< 8; i++) {

			for(int j = 0; j< 8; j++) {

				map[i][j+8] = mp4.getMap()[i][j];

			}
		}

		return map;

	}
	//Recursive function to rotate a MapPanel to a specified outputQuadrant 
	MapPanel rotate2DStringArray(MapPanel toRotate,int outputQuadrant) {

		//System.out.println("outputQuadrant: "+outputQuadrant +"  toRotate: " +toRotate.getPanelLocation());
		if(outputQuadrant == toRotate.getPanelLocation()) {
			return toRotate;
		}else {

			int size = 7;
			String[][] toReturn = new String[8][8];

			for(int i = 0 ;i<=size ;i++) {

				toReturn[i][0] = toRotate.getMap()[0][size-i];
				toReturn[i][1] = toRotate.getMap()[1][size-i];
				toReturn[i][2] = toRotate.getMap()[2][size-i];
				toReturn[i][3] = toRotate.getMap()[3][size-i];
				toReturn[i][4] = toRotate.getMap()[4][size-i];
				toReturn[i][5] = toRotate.getMap()[5][size-i];
				toReturn[i][6] = toRotate.getMap()[6][size-i];
				toReturn[i][7] = toRotate.getMap()[7][size-i];

			}
			
			int indexJ=0;
			
			//We need to rotate the MapPieces as well
			for(String[] toRetur: toReturn) {
				int indexI=0;
				for(String toRetu: toRetur) {
					
					
					if(toRetu.equals("topWall")) {
						toReturn[indexJ][indexI] ="rightWall";
						//break;
					}
					if(toRetu.equals("rightWall")) {
						toReturn[indexJ][indexI] ="bottomWall";
						//break;
					}
					if(toRetu.equals("bottomWall")) {
						toReturn[indexJ][indexI] ="leftWall";
						//break;
					}
					if(toRetu.equals("leftWall")) {
						toReturn[indexJ][indexI] ="topWall";
						//break;
					}
					if(toRetu.startsWith("1l")) {
						String[] toAdd = toRetu.split(",");
						toReturn[indexJ][indexI] ="4l"+","+toAdd[1];//Rotates but keeps token data
						//break;
					}
					if(toRetu.startsWith("4l")) {
						String[] toAdd = toRetu.split(",");
						toReturn[indexJ][indexI] ="3l"+","+toAdd[1];
						
						//break;
					}
					if(toRetu.startsWith("3l")) {
						String[] toAdd = toRetu.split(",");
						toReturn[indexJ][indexI] ="2l"+","+toAdd[1];
						
						//break;
					}
					if(toRetu.startsWith("2l")) {
						String[] toAdd = toRetu.split(",");
						toReturn[indexJ][indexI] ="1l"+","+toAdd[1];
						//break;
					}
					if(toRetu.substring(1).equals("24")) {
						//System.out.println(String.valueOf(toRetu.charAt(0)).concat("24"));
						toReturn[indexJ][indexI] = String.valueOf(toRetu.charAt(0)).concat("13");
						
					}
					if(toRetu.substring(1).equals("13")) {
						//System.out.println(String.valueOf(toRetu.charAt(0)).concat("13"));
						toReturn[indexJ][indexI] =String.valueOf(toRetu.charAt(0)).concat("24");
						
					}
					indexI++;
				}
				indexJ++;
			}

			toRotate.setMap(toReturn);
			//Need to add logic to rotate l1,l2,l3,l4 and walls
			toRotate.setPanelLocation(toRotate.getPanelLocation()-1);

			if(toRotate.getPanelLocation() <1) {

				toRotate.setPanelLocation(4);
			}

			return rotate2DStringArray(toRotate,outputQuadrant);

		}


	}



	
}
