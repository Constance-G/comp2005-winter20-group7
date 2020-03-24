package Game;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GamePanel extends JPanel {//Refactored from GamePanel

	//Dimension SCREENSIZE = Toolkit.getDefaultToolkit().getScreenSize();
	private final Dimension SCREENSIZE =GameBoard.SCREENSIZE;
	String boardType;
	int fontSize;
	boolean colorCheck;
	Robot[] robots =null;
	Player[] players;
	Player playersTurn = null;//used with GameBoard//Used to denote who's turn it is
	String[][] mapGen;
	String config;
	boolean waitingForTurn = true;
	
	GamePanel(){
		
	}
	
	GamePanel(String configIn,PlayersSetup playersIn,boolean colorCheckIn,int fontSizeIn){
		
		setPreferredSize(new Dimension((int) (SCREENSIZE.width)/20*16,(int) (SCREENSIZE.height)/20*16));
		setLayout(new BorderLayout());

		players = assignPlayers(playersIn);
		
		boardType = config;
		fontSize = fontSizeIn;
		colorCheck = colorCheckIn;
		
		System.out.println(colorCheckIn);
		config = configIn;
		
		if(config.equals("simple")) {//Creates the game in Simple formatting
			mapLayout = simpleMapPanel();
			mapGen = buildMap(mapLayout);
			frame =createFrame(mapGen);

		}else {//Creates the game in Complex formatting
			mapLayout = complexMapPanel();
			mapGen = buildMap(mapLayout);
			frame =createFrame(mapGen);
		}
		robots =generateRobots(colorCheckIn);
		addMouseListener(new MListener());
		
	}
	
	
	//Code to account for the number of Players chosen of range (2)->(4).
		//Used with GamePanel.players. Called by GamePanel() constructor
		Player[] assignPlayers(PlayersSetup playersIn) {
			
			int numberOfPlayers = Integer.parseInt(String.valueOf(playersIn.jCombo.getSelectedItem()));
			
			Player[] players = new Player[numberOfPlayers];
			
			for(int i = 0; i<numberOfPlayers; i++) {
				players[i] = playersIn.getPlayerArray()[i];
				System.out.println(playersIn.getPlayerArray()[i].getPlayerName());
			}
			return players;
		}
		
		//Move Logic
		//Attempt at a recursive function for turn
		//Not functioning
		void startPlayerTurn(Player player,int betRemaining) {
			
			if(betRemaining == 0) {//Code for when the user is out of moves
				
			}
				
		}
		
		//This method takes 2 MapPieces and 
		
		//This method is meant to be directed at the GamePanel.robots variable. It updates the robot to the next legal position in the direction of travel.
		//Denote the String direction variable as ("N","S",'E","W"). This indicates attempted direction of travel.
		//return null if the move can't be completed. (No robot moves)
		//return the updated array of robots if the move is successful. (A change is made)
		//Start robot move logic
		public static Point2D attemptMove(MapPiece[][] map, Robot[] robots, Robot toMove, String direction) {
			
			
			if(!isLegalMovev2(map,robots,toMove,direction)) {
				return toMove.location;
			}

			//System.out.println("1");
			// null conditions
			
			Point2D toCheck = toMove.location;

			//System.out.println("2");
			// Code to handle different directors
			if (direction.equals("N")) {
				Point2D endPoint = new Point((int) toMove.location.getX(), (int) toMove.location.getY());

				toCheck = new Point((int) endPoint.getX(), (int) endPoint.getY() - 1);// Check this, not sure if
																								// this will be buggy.

				if (toCheck.getX() >= 16 || toCheck.getX() < 0 || toCheck.getY() >= 16 || toCheck.getY() < 0) {
					return null;
				}
				if (!isUnobstructed(map[(int)toMove.location.getX()][(int)toMove.location.getY()],direction,map)) {
					System.out.println("Illegal Move: isUnobstructed");
					return null;
				}
				
				toMove.location = toCheck;
				return attemptMove(map,robots,toMove,direction);
				

			}
			if (direction.equals("S")) {
				Point2D endPoint = new Point((int) toMove.location.getX(), (int) toMove.location.getY());

				toCheck = new Point((int) endPoint.getX(), (int) endPoint.getY() + 1);// Check this, not sure if
																								// this will be buggy.
				if (toCheck.getX() >= 16 || toCheck.getX() < 0 || toCheck.getY() >= 16 || toCheck.getY() < 0) {
					return null;
				}
				if (!isUnobstructed(map[(int)toMove.location.getX()][(int)toMove.location.getY()],direction,map)) {
					System.out.println("Illegal Move: isUnobstructed");
					return null;
				}
				
				toMove.location = toCheck;
				return attemptMove(map,robots,toMove,direction);

			}
			if (direction.equals("E")) {
				Point2D endPoint = new Point((int) toMove.location.getX(), (int) toMove.location.getY());

				toCheck = new Point((int) endPoint.getX() + 1, (int) endPoint.getY());// Check this, not sure if
																								// this will be buggy.
				if (toCheck.getX() >= 16 || toCheck.getX() < 0 || toCheck.getY() >= 16 || toCheck.getY() < 0) {
					return null;
				}
				if (!isUnobstructed(map[(int)toMove.location.getX()][(int)toMove.location.getY()],direction,map)) {
					System.out.println("Illegal Move: isUnobstructed");
					return null;
				}
				
				toMove.location = toCheck;
				return attemptMove(map,robots,toMove,direction);

			}
			if (direction.equals("W")) {
				Point2D endPoint = new Point((int) toMove.location.getX(), (int) toMove.location.getY());

				toCheck = new Point((int) endPoint.getX() - 1, (int) endPoint.getY());// Check this, not sure if
																								// this will be buggy.
				if (toCheck.getX() >= 16 || toCheck.getX() < 0 || toCheck.getY() >= 16 || toCheck.getY() < 0) {
					return null;
				}
				if (!isUnobstructed(map[(int)toMove.location.getX()][(int)toMove.location.getY()],direction,map)) {
					System.out.println("Illegal Move: isUnobstructed");
					return null;
				}
				
				toMove.location = toCheck;
				return attemptMove(map,robots,toMove,direction);

			}
			
			
		
			//System.out.println("3");
			return toCheck;

		}
		
		public static boolean isLegalMovev2(MapPiece[][] map, Robot[] robots, Robot toMove, String direction) {

			//System.out.println("1");
			// null conditions
			
			

			//System.out.println("2");
			// Code to handle different directors
			if (direction.equals("N")) {
				Point2D endPoint = new Point((int) toMove.location.getX(), (int) toMove.location.getY());

				Point2D toCheck = new Point((int) endPoint.getX(), (int) endPoint.getY() - 1);// Check this, not sure if
																								// this will be buggy.

				if (toCheck.getX() >= 16 || toCheck.getX() < 0 || toCheck.getY() >= 16 || toCheck.getY() < 0) {
					return false;
				}
				if (!isUnobstructed(map[(int)toMove.location.getX()][(int)toMove.location.getY()],direction,map)) {
					System.out.println("Illegal Move: isLegalMovev2");
					return false;
				}
				
				//toMove.location = toCheck;
				return true;
				

			}
			if (direction.equals("S")) {
				Point2D endPoint = new Point((int) toMove.location.getX(), (int) toMove.location.getY());

				Point2D toCheck = new Point((int) endPoint.getX(), (int) endPoint.getY() + 1);// Check this, not sure if
																								// this will be buggy.
				if (toCheck.getX() >= 16 || toCheck.getX() < 0 || toCheck.getY() >= 16 || toCheck.getY() < 0) {
					return false;
				}
				if (!isUnobstructed(map[(int)toMove.location.getX()][(int)toMove.location.getY()],direction,map)) {
					System.out.println("Illegal Move: isLegalMovev2");
					return false;
				}
				
				//toMove.location = toCheck;
				return true;

			}
			if (direction.equals("E")) {
				Point2D endPoint = new Point((int) toMove.location.getX(), (int) toMove.location.getY());

				Point2D toCheck = new Point((int) endPoint.getX() + 1, (int) endPoint.getY());// Check this, not sure if
																								// this will be buggy.
				if (toCheck.getX() >= 16 || toCheck.getX() < 0 || toCheck.getY() >= 16 || toCheck.getY() < 0) {
					return false;
				}
				if (!isUnobstructed(map[(int)toMove.location.getX()][(int)toMove.location.getY()],direction,map)) {
					System.out.println("Illegal Move: isLegalMovev2");
					return false;
				}
				
				//toMove.location = toCheck;
				return true;

			}
			if (direction.equals("W")) {
				Point2D endPoint = new Point((int) toMove.location.getX(), (int) toMove.location.getY());

				Point2D toCheck = new Point((int) endPoint.getX() - 1, (int) endPoint.getY());// Check this, not sure if
																								// this will be buggy.
				if (toCheck.getX() >= 16 || toCheck.getX() < 0 || toCheck.getY() >= 16 || toCheck.getY() < 0) {
					return false;
				}
				if (!isUnobstructed(map[(int)toMove.location.getX()][(int)toMove.location.getY()],direction,map)) {
					System.out.println("Illegal Move: isLegalMovev2");
					return false;
				}
				
				//toMove.location = toCheck;
				return true;

			}
			
			
		
			//System.out.println("3");
			return false;

		}

	

		static boolean isUnobstructed(MapPiece mp,String direction, MapPiece[][] map) {//This check if a robot is unable to start a move due to an obstacle
			//Unlike checkObstacleInDirection, this is meant to be used at the start of the move
			
			Point2D centerpiece1 = new Point(7,7);
			Point2D  centerpiece2= new Point(7,8);
			Point2D  centerpiece3= new Point(8,7);
			Point2D  centerpiece4= new Point(8,8);
			
			
			
			
			Point2D[] centerPieces =  {centerpiece1,centerpiece2,centerpiece3,centerpiece4};
			
			if(direction.equals("N")) {
				
				for(Point2D cenPiece: centerPieces) {
				if(map[(int)mp.point.getX()][(int)mp.point.getY()-1].point.equals(cenPiece)) {
					
					System.out.println("Blocked by:  isBlocked");
					return false;
				}
				}
				if(map[(int)mp.point.getX()][(int)mp.point.getY()-1].robotDisplayed != null) {
					
					System.out.println("Blocked by:  isBlocked");
					return false;
				}
				
				
				//System.out.println("Split: "+ mp.getPieceType().split(",")[0]);
				if(mp.point.getY()==0) {
					System.out.println("Blocked by:  isBlocked");
					return false;
				}
				
				if(mp.getPieceType().split(",")[0].contains("topWall")
						|| map[(int)mp.point.getX()][(int)mp.point.getY()-1].getPieceType().contains("bottomWall")) {
					System.out.println("Blocked by:  isBlocked");
					return false;
				}
				if(mp.getPieceType().split(",")[0].contains("bottomWall")) {
					return true;
				}
				if(mp.getPieceType().split(",")[0].contains("leftWall")) {
					return true;
				}
				if(mp.getPieceType().split(",")[0].contains("rightWall")) {
					return true;
				}
				if(mp.getPieceType().split(",")[0].contains("1l")
						|| map[(int)mp.point.getX()][(int)mp.point.getY()-1].getPieceType().split(",")[0].contains("3l")) {
					System.out.println("Blocked by:  isBlocked");
					return false;
				}
				if(mp.getPieceType().split(",")[0].contains("2l")
						|| map[(int)mp.point.getX()][(int)mp.point.getY()-1].getPieceType().split(",")[0].contains("4l")) {
					System.out.println("Blocked by:  isBlocked");
					return false;
				}
				if(mp.getPieceType().split(",")[0].contains("3l")) {
					return true;
				}
				if(mp.getPieceType().split(",")[0].contains("4l")) {
					return true;
				}
				if(mp.getPieceType().split(",")[0].contains("13")) {//This is where we add the color check
					return true;
				}
				if(mp.getPieceType().split(",")[0].contains("24")) {
					return true;
				}
				

			}
			if(direction.equals("S")) {
				
				for(Point2D cenPiece: centerPieces) {
					if(map[(int)mp.point.getX()][(int)mp.point.getY()+1].point.equals(cenPiece)) {
						
						System.out.println("Blocked by:  isBlocked");
						return false;
					}
				}
				if(map[(int)mp.point.getX()][(int)mp.point.getY()+1].robotDisplayed != null) {
					
					System.out.println("Blocked by:  isBlocked");
					return false;
				}
				
				if(mp.point.getY()==15) {
					System.out.println("Blocked by:  isBlocked1");
					return false;
				}
				
				if(mp.getPieceType().split(",")[0].contains("topWall")) {
					return true;
				}
				//System.out.println("Split: "+ mp.getPieceType().split(",")[0]);
				if(mp.getPieceType().split(",")[0].contains("bottomWall")
						|| map[(int)mp.point.getX()][(int)mp.point.getY()+1].getPieceType().contains("topWall")) {
					System.out.println("Blocked by:  isBlocked");
					return false;
				}
				if(mp.getPieceType().split(",")[0].contains("leftWall")) {
					return true;
				}
				if(mp.getPieceType().split(",")[0].contains("rightWall")) {
					return true;
				}
				if(mp.getPieceType().split(",")[0].contains("1l")) {
					return true;
				}
				if(mp.getPieceType().split(",")[0].contains("2l")) {
					return true;
				}
				if(mp.getPieceType().split(",")[0].contains("3l")|| map[(int)mp.point.getX()][(int)mp.point.getY()+1].getPieceType().split(",")[0].contains("1l")) {
					System.out.println("Blocked by:  isBlocked");
					return false;
				}
				if(mp.getPieceType().split(",")[0].contains("4l")|| map[(int)mp.point.getX()][(int)mp.point.getY()+1].getPieceType().split(",")[0].contains("2l")) {
					System.out.println("Blocked by:  isBlocked");
					return false;
				}
				if(mp.getPieceType().split(",")[0].contains("13")) {
					return true;
				}
				if(mp.getPieceType().split(",")[0].contains("24")) {
					return true;
				}
				
				
			}
			if(direction.equals("E")) {
				
				
				for(Point2D cenPiece: centerPieces) {
					if(map[(int)mp.point.getX()+1][(int)mp.point.getY()].point.equals(cenPiece)) {
						
						System.out.println("Blocked by:  isBlocked");
						return false;
					}
				}
				
				if(map[(int)mp.point.getX()+1][(int)mp.point.getY()].robotDisplayed != null) {
					
					System.out.println("Blocked by:  isBlocked");
					return false;
				}
				//System.out.println("Split: "+ mp.getPieceType().split(",")[0]);
				if(mp.point.getX()==15) {
					System.out.println("Blocked by:  isBlocked1");
					return false;
				}
				
				if(mp.getPieceType().split(",")[0].contains("topWall")) {
					return true;
				}
				if(mp.getPieceType().split(",")[0].contains("bottomWall")) {
					return true;
				}
				if(mp.getPieceType().split(",")[0].contains("leftWall")) {
					return true;
				}
				if(mp.getPieceType().split(",")[0].contains("rightWall")
						|| map[(int)mp.point.getX()+1][(int)mp.point.getY()].getPieceType().contains("leftWall")) {
					System.out.println("Blocked by:  isBlocked");
					return false;
				}
				if(mp.getPieceType().split(",")[0].contains("1l")
						|| map[(int)mp.point.getX()+1][(int)mp.point.getY()].getPieceType().split(",")[0].contains("2l")) {
					System.out.println("Blocked by:  isBlocked");
					return false;
				}
				if(mp.getPieceType().split(",")[0].contains("2l")) {
					return true;
				}
				if(mp.getPieceType().split(",")[0].contains("3l")) {
					return true;
				}
				if(mp.getPieceType().split(",")[0].contains("4l")
						|| map[(int)mp.point.getX()+1][(int)mp.point.getY()].getPieceType().split(",")[0].contains("3l")) {
					System.out.println("Blocked by:  isBlocked");
					return false;
				}
				if(mp.getPieceType().split(",")[0].contains("13")) {
					return true;
				}
				if(mp.getPieceType().split(",")[0].contains("24")) {
					return true;
				}
			}
			if(direction.equals("W")) {
				
				for(Point2D cenPiece: centerPieces) {
					if(map[(int)mp.point.getX()-1][(int)mp.point.getY()].point.equals(cenPiece)) {
						
						System.out.println("Blocked by:  isBlocked");
						return false;
					}
				}
				if(map[(int)mp.point.getX()-1][(int)mp.point.getY()].robotDisplayed != null) {
					
					System.out.println("Blocked by:  isBlocked");
					return false;
				}
				
				//System.out.println("Split: "+ mp.getPieceType().split(",")[0]);
				if(mp.point.getX()==0) {
					System.out.println("Blocked by:  isBlocked1");
					return false;
				}
				
				if(mp.getPieceType().split(",")[0].contains("topWall")) {
					return true;
				}
				if(mp.getPieceType().split(",")[0].contains("bottomWall")) {
					return true;
				}
				if(mp.getPieceType().split(",")[0].contains("leftWall")
						|| map[(int)mp.point.getX()-1][(int)mp.point.getY()].getPieceType().contains("rightWall")) {
					System.out.println("Blocked by:  isBlocked");
					return false;
				}
				if(mp.getPieceType().split(",")[0].contains("rightWall")) {
					return true;
				}
				if(mp.getPieceType().split(",")[0].contains("1l")) {
					return true;
				}
				if(mp.getPieceType().split(",")[0].contains("2l")
						|| map[(int)mp.point.getX()-1][(int)mp.point.getY()].getPieceType().split(",")[0].contains("1l")) {
					System.out.println("Blocked by:  isBlocked");
					return false;
				}
				if(mp.getPieceType().split(",")[0].contains("3l")
						|| map[(int)mp.point.getX()-1][(int)mp.point.getY()].getPieceType().split(",")[0].contains("4l")) {
					System.out.println("Blocked by:  isBlocked");
					return false;
				}
				if(mp.getPieceType().split(",")[0].contains("4l")) {
					return true;
				}
				if(mp.getPieceType().split(",")[0].contains("13")) {
					return true;
				}
				if(mp.getPieceType().split(",")[0].contains("24")) {
					return true;
				}
				
				
			}
			
			return true;
			
			
		}
		
	
		
		//Checks if the MapPiece is a centerpiece or occupied by a robot already
		 static boolean isMapPieceLegal(MapPiece piece) {
			
			//Check if the piece is a Centerpiece
			String[] illegalValues = {"1","2","3","4","1D","2D","3D","4D"};
			for(String illegalValue: illegalValues) {
				
				if(piece.getPieceType().equals(illegalValue)) {
					return false;
				}
			}
			//end
			if(isMapPieceTarget(piece)) {
				return false;
			}
			
			
			//Otherwise, return true indicating that the piece is a legal move
			return true;
		}
		 
		 static boolean isMapPieceTarget(MapPiece piece) {//Checks if a piece has a target on it (Also doubles as a checker for generateRobot since each piece with a target is illegal to spawn on)
			 
			 if(piece.token != null) {
				 return true;
			 }
		
			return false;
			 
		 }
		 
		 MapPiece[][] getmapPieceArray(){
			 
			 
			 
			return null;
			 
		 }
		 //Gets direction from the robot selected and the next leftclicked MapPiece
		 //Used in GameBoard
		 static String getDirection(Robot robot, MapPiece mp) {
			 
			 Point2D pointA = robot.location;
			 //System.out.println("PointA: " + pointA);
			 Point2D pointB = mp.point;
			 //System.out.println("PointB: " + pointB);
			 
			int xDifference = (int) (pointB.getX() - pointA.getX());
			int yDifference = (int) (pointB.getY() - pointA.getY());
			
			if(Math.abs(xDifference) > Math.abs(yDifference)) {
				if(xDifference > 0) {
					//System.out.println("E");
					return "E";
				}else {
					//System.out.println("W");
					return "W";
				}
				
			}else {
				if(yDifference > 0) {
					//System.out.println("S");
					return "S";
				}else {
					//System.out.println("N");
					return "N";
				}
				
			}
			 
			 
		 }
		 
		 //To be used with the MouseEvent mouseClicked
		 //Gets the MapPiece clicked by the player
		 //Returns null if no MapPiece can be found.
		 //Returns a single MapPiece if one is found
		 //Don't use this with (0,0)->(15,15) calls as this is looking for a point on the screen not in the game {(0,0)->(1920,1080) or (0,0)->(1280,800)} for example} 
		  MapPiece getMapPieceFromMouse(Point2D point) {
			  
			  for(MapPiece mp: getMapPieceArray()) {
				  
				  Point2D pnt = mp.point;
				  Rectangle toTest = new Rectangle((int)(mp.getWidth()*pnt.getX()),(int)(mp.getHeight()*pnt.getY()),mp.getWidth(),mp.getHeight());
				  if(toTest.contains(point)) {
					 // System.out.println("Point clicked: " + pnt);//Prints the Point selected in range (0,0)->(15,15);
					  return mp;
				  }
			  }  
			return null;
			 
		 }
		
		//End static robotMove Logic
		//End move logic
		
		//Use this to get an ArrayList of the MapPieces.
		//This can be used if iterating through the pieces 
		//The MapPiece[X][Y] array can be accessed directly to get the point at (X,Y)
		public ArrayList<MapPiece> getMapPieceArray(){
			
			ArrayList<MapPiece> pieces = new ArrayList<MapPiece>();
			
			for(BufferedImage[] mpArray : imageMap) {
				for(BufferedImage mp : mpArray) {
					
					MapPiece mapPiece = (MapPiece) mp;
					pieces.add(mapPiece);
				}
				
			}
			return pieces;
			
		}

	Robot[] generateRobots(boolean colorCheckIn) {
		
		Robot[] robotArray = new Robot[4];
		//System.out.println(colorCheckIn);
		robotArray[0] = new Robot(1,colorCheckIn);
		robotArray[1] = new Robot(2,colorCheckIn);
		robotArray[2] = new Robot(3,colorCheckIn);
		robotArray[3] = new Robot(4,colorCheckIn);
		
		for(Robot robot: robotArray) {
			
			
			Point point = new Point((int)(Math.random()*15),(int)(Math.random()*15));
		
			//System.out.println(point.x+"   "+point.y);
			robot.moveRobot(point);	
		}
		for (MapPiece mp : getMapPieceArray()) {

			
			if(mp.point.equals(robotArray[0].location)&& mp.token != null) {
				//System.out.println("00");
				return generateRobots(colorCheckIn);
			}
			if(mp.point.equals(robotArray[1].location)&& mp.token != null) {
				//System.out.println("11");
				return generateRobots(colorCheckIn);
			}
			if(mp.point.equals(robotArray[2].location)&& mp.token != null) {
				//System.out.println("22");
				return generateRobots(colorCheckIn);
			}
			if(mp.point.equals(robotArray[3].location)&& mp.token != null) {
				//System.out.println("33");
				return generateRobots(colorCheckIn);
			}
			if(mp.point.equals(robotArray[0].location)&& !isMapPieceLegal(mp)) {
				//System.out.println("000");
				return generateRobots(colorCheckIn);
			}
			if(mp.point.equals(robotArray[1].location)&& !isMapPieceLegal(mp)) {
				//System.out.println("111");
				return generateRobots(colorCheckIn);
			}
			if(mp.point.equals(robotArray[2].location)&& !isMapPieceLegal(mp)) {
				//System.out.println("222");
				return generateRobots(colorCheckIn);
			}
			if(mp.point.equals(robotArray[3].location)&& !isMapPieceLegal(mp)) {
				//System.out.println("333");
				return generateRobots(colorCheckIn);
			}
		}
		
		return robotArray;
		
	}
	
	
	BufferedImage frame;//THis is created by createFrame();
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		if(mapLayout == null) {
			if(config.equals("complex")) {
				mapLayout = complexMapPanel();
			}else {
				mapLayout = simpleMapPanel();
			}
			
			
			mapGen = buildMap(mapLayout);
			frame =createFrame(mapGen);
		}
		
		
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

	BufferedImage[][] imageMap = null;

	BufferedImage createFrame(String[][] stringMapArray) {// This will be the 16X16 Map to be displayed to the user

		// imageMap = new BufferedImage[16][16];

		imageMap = new MapPiece[16][16];
		for (int i = 0; i < 16; i++) {

			for (int j = 0; j < 16; j++) {
				//System.out.println("making frame");
				imageMap[i][j] = new MapPiece(stringMapArray[i][j], SCREENSIZE, fontSize, colorCheck, robots,new Point(i, j));
			}
		}

		BufferedImage toDisplay = new BufferedImage(SCREENSIZE.width / 20 * 16, SCREENSIZE.height / 20 * 16,
				BufferedImage.TYPE_INT_ARGB);

		for (int i = 0; i < 16; i++) {

			for (int j = 0; j < 16; j++) {

				for (int k = 0; k < imageMap[i][j].getWidth(); k++) {

					for (int l = 0; l < imageMap[i][j].getHeight(); l++) {

						toDisplay.setRGB((i * SCREENSIZE.width / 20) + k, (j * SCREENSIZE.height / 20) + l,
								imageMap[i][j].getRGB(k, l));

					}
				}

			}

		}
		// TODO: Add players and goals
		return toDisplay;

	}

	int mapIndex = 0;
	MapPanel[] mapLayout = new MapPanel[4];
	public boolean isBettingRound = false;
	public boolean isTurnRound = false;

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

	Robot robotClicked = null;
	MapPiece clickedMapPiece = null;
	class MListener implements MouseListener{
	@Override
	public void mouseClicked(MouseEvent e) {
		
		
		
		
		if(isTurnRound&& robotClicked != null){
			//System.out.println("??? robotCLicked");
			if(SwingUtilities.isRightMouseButton(e)) {
				robotClicked = null;
				clickedMapPiece = null;
			}
			if(SwingUtilities.isLeftMouseButton(e)) {
				clickedMapPiece = getMapPieceFromMouse(e.getPoint());
			}
			
		}
	
		if(isTurnRound&& robotClicked == null&&clickedMapPiece == null&&getMapPieceFromMouse(e.getPoint()).robotDisplayed != null&& SwingUtilities.isLeftMouseButton(e)) {
			robotClicked = getMapPieceFromMouse(e.getPoint()).robotDisplayed;//Gets the robot clicked by the player during the Turn Round
			//System.out.println("Populating robotCLicked");
		}
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
	
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		// TODO Auto-generated method stub
		
	}
	}

	
}
