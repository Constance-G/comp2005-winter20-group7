import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class GamePanel extends JPanel {//Refactored from GamePanel

	//Dimension SCREENSIZE = Toolkit.getDefaultToolkit().getScreenSize();
	static final Dimension SCREENSIZE = new Dimension(1000,1000);
	String boardType;

	
	GamePanel(String config,PlayersSetup players){
		//Game Panel config
		setPreferredSize(new Dimension((int) (SCREENSIZE.width),(int) (SCREENSIZE.height)));
		setLayout(new BorderLayout());
		//

		
		boardType = config;
	

		if(config.equals("simple")) {//Creates the game in Simple formatting
			mapLayout = simpleMapPanel();
			String[][] mapGen = buildMap(mapLayout);
			frame =createFrame(mapGen);

		}else {//Creates the game in Complex formatting
			mapLayout = complexMapPanel();
			String[][] mapGen = buildMap(mapLayout);
			frame =createFrame(mapGen);

		}
	}


	BufferedImage frame;
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if(boardType.equals("simple")) {
			
			if(frame == null) {
				String[][] mapGen = buildMap(mapLayout);
				frame =createFrame(mapGen);
				
			}else {
				g.drawImage(frame, 0, 0, null);
			}
		}
		if(boardType.equals("complex")) {
			
			if(frame == null) {
				String[][] mapGen = buildMap(mapLayout);
				frame =createFrame(mapGen);
				
			}else {
				g.drawImage(frame, 0, 0, null);
			}
		}

	}

	 class MapPiece extends BufferedImage{
		 
	 String pieceType;
		 
		MapPiece(String type){
			super(SCREENSIZE.width/20, SCREENSIZE.height/20, BufferedImage.TYPE_INT_ARGB);
			
			this.pieceType = type;
			generateMapPiece();
	
		}
		
		String getPieceType() {
			return pieceType;
		}
		
		void setPieceType(String ty) {
			
			this.pieceType = ty;
		}
		
		//Paints the piece on to a smaller image 
		BufferedImage generateMapPiece() { //Rectangles are a temporary fix until we get graphics to replace
			
			Graphics2D g = (Graphics2D) getGraphics();
			
			if(pieceType.equals("reg")) {
				
				g.setColor(Color.LIGHT_GRAY);
				g.fillRect(0, 0, SCREENSIZE.width/20-1,SCREENSIZE.height/20-1);
				g.setColor(Color.BLACK);
				g.setFont(new Font("TimesRoman", Font.PLAIN, SCREENSIZE.width/50)); 
				g.drawString("reg",10,30);
			}
			if(pieceType.equals("1l")) {
				g.setColor(Color.LIGHT_GRAY);
				g.fillRect(0, 0, SCREENSIZE.width/20-1,SCREENSIZE.height/20-1);
				g.setColor(Color.BLACK);
				g.setFont(new Font("TimesRoman", Font.PLAIN, SCREENSIZE.width/50)); 
				g.drawString("1l",10,30);
				g.fillRect((SCREENSIZE.height/20-1)-(SCREENSIZE.height/80-1),0,SCREENSIZE.width/80-1,SCREENSIZE.height/20-1);
				g.fillRect(0,0,SCREENSIZE.width/20-1,SCREENSIZE.height/80-1);
				
			}
			if(pieceType.equals("2l")) {
				g.setColor(Color.LIGHT_GRAY);
				g.fillRect(0, 0, SCREENSIZE.width/20-1,SCREENSIZE.height/20-1);
				g.setColor(Color.BLACK);
				g.setFont(new Font("TimesRoman", Font.PLAIN, SCREENSIZE.width/50)); 
				g.drawString("2l",10,30);
				g.fillRect(0,0,SCREENSIZE.width/20-1,SCREENSIZE.height/80-1);
				g.fillRect((SCREENSIZE.height/20-1)-(SCREENSIZE.height/20-1),0,SCREENSIZE.width/80-1,SCREENSIZE.height/20-1);
				
			}
			if(pieceType.equals("3l")) {
				g.setColor(Color.LIGHT_GRAY);
				g.fillRect(0, 0, SCREENSIZE.width/20-1,SCREENSIZE.height/20-1);
				g.setColor(Color.BLACK);
				g.setFont(new Font("TimesRoman", Font.PLAIN, SCREENSIZE.width/50)); 
				g.drawString("3l",10,30);
				g.fillRect(0,(SCREENSIZE.height/20-1)-(SCREENSIZE.height/80-1),SCREENSIZE.width/20-1,SCREENSIZE.height/80-1);
				g.fillRect((SCREENSIZE.height/20-1)-(SCREENSIZE.height/20-1),0,SCREENSIZE.width/80-1,SCREENSIZE.height/20-1);
				
			}
			if(pieceType.equals("4l")) {
				g.setColor(Color.LIGHT_GRAY);
				g.fillRect(0, 0, SCREENSIZE.width/20-1,SCREENSIZE.height/20-1);
				g.setColor(Color.BLACK);
				g.setFont(new Font("TimesRoman", Font.PLAIN, SCREENSIZE.width/50)); 
				g.drawString("4l",10,30);
				g.fillRect((SCREENSIZE.height/20-1)-(SCREENSIZE.height/80-1),0,SCREENSIZE.width/80-1,SCREENSIZE.height/20-1);
				g.fillRect(0,(SCREENSIZE.height/20-1)-(SCREENSIZE.height/80-1),SCREENSIZE.width/20-1,SCREENSIZE.height/80-1);
				
			}
			if(pieceType.equals("1")) {
				g.setColor(Color.WHITE);
				g.fillRect(0, 0, SCREENSIZE.width/20-1,SCREENSIZE.height/20-1);
				g.setColor(Color.BLACK);
				g.setFont(new Font("TimesRoman", Font.PLAIN, SCREENSIZE.width/50)); 
				g.drawString("1",10,30);
				
			}
			if(pieceType.equals("2")) {
				g.setColor(Color.WHITE);
				g.fillRect(0, 0, SCREENSIZE.width/20-1,SCREENSIZE.height/20-1);
				g.setColor(Color.BLACK);
				g.setFont(new Font("TimesRoman", Font.PLAIN, SCREENSIZE.width/50)); 
				g.drawString("2",10,30);
				
			}
			if(pieceType.equals("3")) {
				g.setColor(Color.WHITE);
				g.fillRect(0, 0, SCREENSIZE.width/20-1,SCREENSIZE.height/20-1);
				g.setColor(Color.BLACK);
				g.setFont(new Font("TimesRoman", Font.PLAIN, SCREENSIZE.width/50)); 
				g.drawString("3",10,30);
				
			}
			if(pieceType.equals("4")) {
				g.setColor(Color.WHITE);
				g.fillRect(0, 0, SCREENSIZE.width/20-1,SCREENSIZE.height/20-1);
				g.setColor(Color.BLACK);
				g.setFont(new Font("TimesRoman", Font.PLAIN, SCREENSIZE.width/50)); 
				g.drawString("4",10,30);
				
			}
			if(pieceType.equals("1D")) {
				g.setColor(Color.WHITE);
				g.fillRect(0, 0, SCREENSIZE.width/20-1,SCREENSIZE.height/20-1);
				g.setColor(Color.BLACK);
				g.setFont(new Font("TimesRoman", Font.PLAIN, SCREENSIZE.width/50)); 
				g.drawString("1D",10,30);
				
			}
			if(pieceType.equals("2D")) {
				g.setColor(Color.WHITE);
				g.fillRect(0, 0, SCREENSIZE.width/20-1,SCREENSIZE.height/20-1);
				g.setColor(Color.BLACK);
				g.setFont(new Font("TimesRoman", Font.PLAIN, SCREENSIZE.width/50)); 
				g.drawString("2D",10,30);
				
			}
			if(pieceType.equals("3D")) {
				g.setColor(Color.WHITE);
				g.fillRect(0, 0, SCREENSIZE.width/20-1,SCREENSIZE.height/20-1);
				g.setColor(Color.BLACK);
				g.setFont(new Font("TimesRoman", Font.PLAIN, SCREENSIZE.width/50)); 
				g.drawString("3D",10,30);
				
			}
			if(pieceType.equals("4D")) {
				g.setColor(Color.WHITE);
				g.fillRect(0, 0, SCREENSIZE.width/20-1,SCREENSIZE.height/20-1);
				g.setColor(Color.BLACK);
				g.setFont(new Font("TimesRoman", Font.PLAIN, SCREENSIZE.width/50)); 
				g.drawString("4D",10,30);
				
			}
			if(pieceType.equals("bottomWall")) {
				g.setColor(Color.LIGHT_GRAY);
				g.fillRect(0, 0, SCREENSIZE.width/20-1,SCREENSIZE.height/20-1);
				g.setColor(Color.BLACK);
				g.setFont(new Font("TimesRoman", Font.PLAIN, SCREENSIZE.width/100)); 
				g.drawString("bottom",20,30);
				g.fillRect(0,(SCREENSIZE.height/20-1)-(SCREENSIZE.height/80-1),SCREENSIZE.width/20-1,SCREENSIZE.height/80-1);
			}
			if(pieceType.equals("leftWall")) {
				g.setColor(Color.LIGHT_GRAY);
				g.fillRect(0, 0, SCREENSIZE.width/20-1,SCREENSIZE.height/20-1);
				g.setColor(Color.BLACK);
				g.setFont(new Font("TimesRoman", Font.PLAIN, SCREENSIZE.width/100)); 
				g.drawString("left",20,30);
				g.fillRect((SCREENSIZE.height/20-1)-(SCREENSIZE.height/20-1),0,SCREENSIZE.width/80-1,SCREENSIZE.height/20-1);
				
			}
			if(pieceType.equals("rightWall")) {
				g.setColor(Color.LIGHT_GRAY);
				g.fillRect(0, 0, SCREENSIZE.width/20-1,SCREENSIZE.height/20-1);
				g.setColor(Color.BLACK);
				g.setFont(new Font("TimesRoman", Font.PLAIN, SCREENSIZE.width/100)); 
				g.drawString("right",20,30);
				g.fillRect((SCREENSIZE.height/20-1)-(SCREENSIZE.height/80-1),0,SCREENSIZE.width/80-1,SCREENSIZE.height/20-1);
			}
			if(pieceType.equals("topWall")) {
				g.setColor(Color.LIGHT_GRAY);
				g.fillRect(0, 0, SCREENSIZE.width/20-1,SCREENSIZE.height/20-1);
				g.setColor(Color.BLACK);
				g.setFont(new Font("TimesRoman", Font.PLAIN, SCREENSIZE.width/100)); 
				g.drawString("top",20,30);
				
				g.fillRect(0,0,SCREENSIZE.width/20-1,SCREENSIZE.height/80-1);
			}
			if(pieceType.substring(1).equals("24")) {
				g.setColor(Color.LIGHT_GRAY);
				g.fillRect(0, 0, SCREENSIZE.width/20-1,SCREENSIZE.height/20-1);
				Rectangle rect = new Rectangle(0,0-SCREENSIZE.height/200-1, SCREENSIZE.width/10-1,SCREENSIZE.height/80-1);
				AffineTransform at = g.getTransform();
				g.setTransform(AffineTransform.getRotateInstance(Math.PI /4));
				g.setColor(getColor(String.valueOf(pieceType.charAt(0))));
				g.fill(rect);
				g.setTransform(at);
				//g.setColor(Color.BLACK);
				//g.setFont(new Font("TimesRoman", Font.PLAIN, SCREENSIZE.width/100)); 
				//g.drawString("24",20,30);
				
				//g.fillRect(0,0,SCREENSIZE.width/20-1,SCREENSIZE.height/80-1);
			}
			if(pieceType.substring(1).equals("13")) {//
				g.setColor(Color.LIGHT_GRAY);
				g.fillRect(0, 0, SCREENSIZE.width/20-1,SCREENSIZE.height/20-1);
				Rectangle rect = new Rectangle(-SCREENSIZE.width/10-1,SCREENSIZE.height/33-1, SCREENSIZE.width/1-1,SCREENSIZE.height/80-1);
				AffineTransform at = g.getTransform();
				g.setTransform(AffineTransform.getRotateInstance(-Math.PI/4));
				g.setColor(getColor(String.valueOf(pieceType.charAt(0))));
				g.fill(rect);
				g.setTransform(at);
				//g.setColor(Color.BLACK);
				//g.setFont(new Font("TimesRoman", Font.PLAIN, SCREENSIZE.width/100)); 
				//g.drawString("24",20,30);
				
				//g.fillRect(0,0,SCREENSIZE.width/20-1,SCREENSIZE.height/80-1);
			}
			
			
			return this;
			
		}
		
	}
	
	Color getColor(String c) {
		
		if("b".equals(c)) {
			return Color.BLUE;
		}
		if("g".equals(c)) {
			return Color.GREEN;
		}
		if("y".equals(c)) {
			return Color.YELLOW;
		}
		if("r".equals(c)) {
			return Color.red;
		}
		return Color.red;
		
	}
	
	


	BufferedImage createFrame(String[][] stringMapArray){//This will be the 16X16 Map to be displayed to the user
		
		BufferedImage[][] imageMap = new BufferedImage[16][16];

		for(int i = 0; i <16;i++) {
			
			for(int j = 0; j <16;j++) {
				
				imageMap[i][j] = new MapPiece(stringMapArray[i][j]);
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
					if(mp != null && mp.getClass().equals(SimplePanel1.class)) {
						return simpleMapPanel();			
					}
				}
				mapLayout[mapIndex]= new SimplePanel1(); 
				System.out.println(":1");
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
				System.out.println(":2");
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
				System.out.println(":3");
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
				System.out.println(":4");
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
				System.out.println(":1D");
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
				System.out.println(":2D");
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
				System.out.println(":3D");
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
				System.out.println(":4D");
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
		
		
		System.out.println("mp1: " + mp1.getMap()[7][7]);
		System.out.println("mp2: " + mp2.getMap()[0][7]);
		System.out.println("mp3: " + mp3.getMap()[0][0]);
		System.out.println("mp4: " + mp4.getMap()[7][0]);


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

		System.out.println("outputQuadrant: "+outputQuadrant +"  toRotate: " +toRotate.getPanelLocation());
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
					if(toRetu.equals("1l")) {
						toReturn[indexJ][indexI] ="4l";
						//break;
					}
					if(toRetu.equals("4l")) {
						toReturn[indexJ][indexI] ="3l";
						//break;
					}
					if(toRetu.equals("3l")) {
						toReturn[indexJ][indexI] ="2l";
						//break;
					}
					if(toRetu.equals("2l")) {
						toReturn[indexJ][indexI] ="1l";
						//break;
					}
					if(toRetu.substring(1).equals("24")) {
						System.out.println(String.valueOf(toRetu.charAt(0)).concat("24"));
						toReturn[indexJ][indexI] = String.valueOf(toRetu.charAt(0)).concat("13");
						
					}
					if(toRetu.substring(1).equals("13")) {
						System.out.println(String.valueOf(toRetu.charAt(0)).concat("13"));
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



	abstract class MapPanel{ //Wrapper class for SimplePanel1,SimplePanel2,...


		String[][] map =  {{"reg","reg","reg","reg","reg","reg","reg","reg"},
				{"reg","reg","reg","reg","reg","reg","reg","reg"},
				{"reg","reg","reg","reg","reg","reg","reg","reg"},
				{"reg","reg","reg","reg","reg","reg","reg","reg",},
				{"reg","reg","reg","reg","reg","reg","reg","reg",},
				{"reg","reg","reg","reg","reg","reg","reg","reg",},
				{"reg","reg","reg","reg","reg","reg","reg","reg",},
				{"reg","reg","reg","reg","reg","reg","reg","reg",}};

		MapPanel(){

		}	

		abstract String[][] getMap();

		abstract void setMap(String[][] newMap);

		abstract void setPanelLocation(int a);


		abstract int getPanelNum();

		abstract int getPanelLocation();


	}

	class SimplePanel1 extends MapPanel{//This is board 1A

		//By default, each panel is stored like 1A in simple.png, in the equivalent Cartesian quadrant 2.

		public int panelNum = 1;
		public int panelLocation = 2;//in Quadrants

		SimplePanel1(){
			super();

		}

		int SIZE = 8;

		//This an 8x8 Matrix used to store the board.
		//Note: This Matrix looks transposed compared to the drawn boards. This is intended. The first row is actually the first column to be drawn.
		//To access a piece, call map[i][j] where i is in the positive x direction
		//and j is in the negative y value. (map[0][0] = "reg" , map[7][7] = "1")

		String[][] map = {{"reg","reg","reg","reg","reg","bottomWall","reg","reg"},//Column 1
						{"reg","reg","1l","reg","reg","reg","reg","reg"},
						{"leftWall","reg","reg","reg","reg","reg","reg","reg"},
						{"reg","reg","reg","reg","reg","reg","3l","reg",},
						{"reg","2l","reg","reg","reg","reg","reg","reg",},
						{"reg","reg","reg","reg","reg","reg","reg","reg",},
						{"reg","reg","reg","4l","reg","reg","reg","reg",},
						{"reg","reg","reg","reg","reg","reg","reg","1",}};//Column 8

		@Override
		String[][] getMap(){
			return map;

		}
		@Override
		int getPanelNum() {
			return panelNum;

		}

		@Override
		void setMap(String[][] newMap) {
			map = newMap;

		}
		@Override
		int getPanelLocation() {
			return panelLocation;
		}
		@Override
		void setPanelLocation(int a) {

			panelLocation = a;
		}

	}

	class SimplePanel2 extends MapPanel{

		//By default, each panel is stored like 1A in simple.png, in the equivalent Cartesian quadrant 2.
		
		int panelNum = 2;
		public int panelLocation = 2;//in Quadrants

		SimplePanel2(){
			super();
		}
		//This an 8x8 Matrix used to store the board.
		//Note: This Matrix looks transposed compared to the drawn boards. This is intended. The first row is actually the first column to be drawn.
		//To access a piece, call map[i][j] where i is in the positive x direction
		//and j is in the negative y value. (map[0][0] = "reg" , map[7][7] = "2")
	
		String[][] map = {{"reg","reg","reg","bottomWall","reg","reg","reg","reg"},//Column 1
						{"reg","reg","3l","reg","reg","reg","reg","reg"},
						{"reg","reg","reg","reg","reg","reg","1l","reg"},
						{"reg","reg","reg","reg","reg","reg","reg","reg",},
						{"leftWall","reg","reg","reg","reg","reg","reg","reg",},
						{"reg","4l","reg","reg","reg","reg","reg","reg",},
						{"reg","reg","reg","reg","2l","reg","reg","reg",},
						{"reg","reg","reg","reg","reg","reg","reg","2",}};//Column 8

		@Override
		String[][] getMap(){
			return map;

		}
		@Override
		int getPanelNum() {
			return panelNum;

		}

		@Override
		void setMap(String[][] newMap) {
			map = newMap;

		}
		@Override
		int getPanelLocation() {

			return panelLocation;
		}
		@Override
		void setPanelLocation(int a) {

			panelLocation = a;		
		}

	}

	class SimplePanel3 extends MapPanel{
		
		//By default, each panel is stored like 1A in simple.png, in the equivalent Cartesian quadrant 2.

		int panelNum = 3;
		public int panelLocation = 2;//in Quadrants

		SimplePanel3(){
			super();
		}

		//This an 8x8 Matrix used to store the board.
		//Note: This Matrix looks transposed compared to the drawn boards. This is intended. The first row is actually the first column to be drawn.
		//To access a piece, call map[i][j] where i is in the positive x direction
		//and j is in the negative y value. (map[0][0] = "reg" , map[7][7] = "3")

		String[][] map = {{"reg","reg","reg","reg","bottomWall","reg","reg","reg"},//Column 1
						{"reg","reg","reg","reg","reg","reg","2l","reg"},
						{"reg","reg","reg","reg","1l","reg","reg","reg"},
						{"reg","reg","reg","reg","reg","reg","reg","reg",},
						{"leftWall","reg","reg","reg","reg","reg","reg","reg",},
						{"reg","reg","4l","reg","reg","reg","reg","reg",},
						{"reg","reg","reg","reg","reg","reg","reg","reg",},
						{"reg","reg","reg","reg","reg","3l","reg","3",}};//Column 8
		@Override
		String[][] getMap(){
			return map;

		}
		@Override
		int getPanelNum() {
			return panelNum;

		}

		@Override
		void setMap(String[][] newMap) {
			map = newMap;

		}
		@Override
		int getPanelLocation() {

			return panelLocation;
		}

		@Override
		void setPanelLocation(int a) {

			panelLocation = a;
		}
	}

	class SimplePanel4 extends MapPanel{
		
		//By default, each panel is stored like 1A in simple.png, in the equivalent Cartesian quadrant 2.

		int panelNum = 4;
		public int panelLocation = 2;//in Quadrants

		SimplePanel4(){
			super();
		}

		//This an 8x8 Matrix used to store the board.
		//Note: This Matrix looks transposed compared to the drawn boards. This is intended. The first row is actually the first column to be drawn.
		//To access a piece, call map[i][j] where i is in the positive x direction
		//and j is in the negative y value. (map[0][0] = "reg" , map[7][7] = "4")
		

		String[][] map = {{"reg","reg","reg","reg","reg","reg","bottomWall","reg"},//Column 1
						{"reg","reg","reg","1l","reg","reg","reg","reg"},
						{"reg","reg","reg","reg","reg","4l","reg","reg"},
						{"reg","reg","reg","reg","reg","reg","reg","reg",},
						{"leftWall","reg","reg","reg","reg","reg","reg","reg",},
						{"reg","reg","reg","reg","2l","reg","reg","reg",},
						{"reg","3l","reg","reg","reg","reg","reg","reg",},
						{"reg","reg","reg","reg","reg","4l","reg","4",}};//Column 8
		@Override
		String[][] getMap(){
			return map;

		}
		@Override
		int getPanelNum() {
			return panelNum;

		}

		@Override
		void setMap(String[][] newMap) {
			map = newMap;

		}
		@Override
		int getPanelLocation() {

			return panelLocation;
		}

		@Override
		void setPanelLocation(int a) {

			panelLocation = a;
		}
	}

	class ComplexPanel1 extends MapPanel{
		
		//By default, each panel is stored like 1A in simple.png, in the equivalent Cartesian quadrant 2.

				public int panelNum = 5;
				public int panelLocation = 2;//in Quadrants

				ComplexPanel1(){
					super();

				}

				int SIZE = 8;

				//This an 8x8 Matrix used to store the board.
				//Note: This Matrix looks transposed compared to the drawn boards. This is intended. The first row is actually the first column to be drawn.
				//To access a piece, call map[i][j] where i is in the positive x direction
				//and j is in the negative y value. (map[0][0] = "reg" , map[7][7] = "1")

				String[][] map = {{"reg","reg","reg","reg","reg","bottomWall","reg","reg"},//Column 1
								{"reg","reg","reg","2l","reg","reg","reg","reg"},
								{"reg","reg","reg","reg","reg","reg","topWall","reg"},
								{"reg","reg","reg","reg","reg","reg","3l","reg",},
								{"reg","g13","reg","reg","reg","reg","reg","reg",},
								{"reg","reg","reg","reg","reg","reg","reg","y24",},
								{"leftWall","reg","reg","reg","4l","reg","reg","reg",},
								{"reg","reg","reg","reg","reg","reg","reg","1D",}};//Column 8

				@Override
				String[][] getMap(){
					return map;

				}
				@Override
				int getPanelNum() {
					return panelNum;

				}

				@Override
				void setMap(String[][] newMap) {
					map = newMap;

				}
				@Override
				int getPanelLocation() {
					return panelLocation;
				}
				@Override
				void setPanelLocation(int a) {

					panelLocation = a;
				}
	}
	
	class ComplexPanel2 extends MapPanel{

		//By default, each panel is stored like 1A in simple.png, in the equivalent Cartesian quadrant 2.

		public int panelNum = 6;
		public int panelLocation = 2;//in Quadrants

		ComplexPanel2(){
			super();

		}

		int SIZE = 8;

		//This an 8x8 Matrix used to store the board.
		//Note: This Matrix looks transposed compared to the drawn boards. This is intended. The first row is actually the first column to be drawn.
		//To access a piece, call map[i][j] where i is in the positive x direction
		//and j is in the negative y value. (map[0][0] = "reg" , map[7][7] = "1")

		String[][] map = {{"reg","reg","reg","reg","reg","reg","bottomWall","reg"},//Column 1
						{"reg","reg","reg","reg","reg","3l","reg","reg"},
						{"reg","b13","reg","reg","reg","reg","reg","reg"},
						{"leftWall","reg","reg","reg","reg","reg","reg","reg",},
						{"reg","reg","reg","reg","reg","reg","reg","1l",},
						{"reg","reg","4l","reg","reg","reg","reg","reg",},
						{"reg","reg","topWall","reg","reg","reg","reg","reg",},
						{"reg","reg","reg","reg","r24","reg","reg","2D",}};//Column 8

		@Override
		String[][] getMap(){
			return map;

		}
		@Override
		int getPanelNum() {
			return panelNum;

		}

		@Override
		void setMap(String[][] newMap) {
			map = newMap;

		}
		@Override
		int getPanelLocation() {
			return panelLocation;
		}
		@Override
		void setPanelLocation(int a) {

			panelLocation = a;
		}
	}
	
	class ComplexPanel3 extends MapPanel{
		//By default, each panel is stored like 1A in simple.png, in the equivalent Cartesian quadrant 2.

		public int panelNum = 7;
		public int panelLocation = 2;//in Quadrants

		ComplexPanel3(){
			super();

		}

		int SIZE = 8;

		//This an 8x8 Matrix used to store the board.
		//Note: This Matrix looks transposed compared to the drawn boards. This is intended. The first row is actually the first column to be drawn.
		//To access a piece, call map[i][j] where i is in the positive x direction
		//and j is in the negative y value. (map[0][0] = "reg" , map[7][7] = "1")

		String[][] map = {{"reg","reg","bottomWall","reg","reg","reg","reg","reg"},//Column 1
						{"reg","reg","reg","reg","reg","reg","reg","reg"},
						{"reg","reg","reg","reg","1l","reg","reg","reg"},
						{"reg","reg","reg","reg","bottomWall","reg","reg","reg",},
						{"reg","b24","reg","reg","reg","reg","reg","reg",},
						{"leftWall","reg","reg","reg","reg","reg","2l","reg",},
						{"reg","reg","4l","y24","reg","reg","reg","reg",},
						{"reg","reg","reg","reg","reg","reg","reg","3D",}};//Column 8

		@Override
		String[][] getMap(){
			return map;

		}
		@Override
		int getPanelNum() {
			return panelNum;

		}

		@Override
		void setMap(String[][] newMap) {
			map = newMap;

		}
		@Override
		int getPanelLocation() {
			return panelLocation;
		}
		@Override
		void setPanelLocation(int a) {

			panelLocation = a;
		}
	}
	
	class ComplexPanel4 extends MapPanel{
		
		//By default, each panel is stored like 1A in simple.png, in the equivalent Cartesian quadrant 2.

		public int panelNum = 8;
		public int panelLocation = 2;//in Quadrants

		ComplexPanel4(){
			super();

		}

		int SIZE = 8;

		//This an 8x8 Matrix used to store the board.
		//Note: This Matrix looks transposed compared to the drawn boards. This is intended. The first row is actually the first column to be drawn.
		//To access a piece, call map[i][j] where i is in the positive x direction
		//and j is in the negative y value. (map[0][0] = "reg" , map[7][7] = "1")

		String[][] map = {{"reg","reg","reg","reg","reg","reg","bottomWall","reg"},//Column 1
						{"reg","reg","reg","reg","reg","4l","reg","reg"},
						{"reg","r24","reg","topWall","reg","reg","reg","reg"},
						{"reg","reg","reg","3l","reg","reg","g24","reg",},
						{"reg","reg","reg","reg","reg","reg","reg","reg",},
						{"leftWall","reg","reg","reg","reg","reg","reg","4l",},
						{"reg","reg","2l","reg","reg","reg","reg","reg",},
						{"reg","reg","reg","reg","reg","reg","reg","4D",}};//Column 8

		@Override
		String[][] getMap(){
			return map;

		}
		@Override
		int getPanelNum() {
			return panelNum;

		}

		@Override
		void setMap(String[][] newMap) {
			map = newMap;

		}
		@Override
		int getPanelLocation() {
			return panelLocation;
		}
		@Override
		void setPanelLocation(int a) {

			panelLocation = a;
		}
	}

	
}
