package Game;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Robot {

	private String filePath = "/resources/Images/Targets/";
	private int robotNum;


	private BufferedImage robotImage;
	Point2D location = new Point(1,1); //from (0-15,0-15) on the grid
	boolean colorCheck = true;
	String currentShape;
	

	Robot(int robotNumIn,boolean colorCheckIn){
		robotNum = robotNumIn;
		
		colorCheck = colorCheckIn;
		robotImage = drawTokens();
		//
	}

	
	public Robot(Robot robot) {

		this.filePath = robot.filePath;
		this.robotNum = robot.robotNum;
		this.robotImage = robot.robotImage;
		this.location = new Point((int)robot.location.getX(),(int)robot.location.getY());
		
		this.colorCheck = robot.colorCheck;
		this.currentShape = robot.currentShape;
	}


	public Point2D GetLocation() {

		return location;
	}
	

	public BufferedImage getRobotImage() {
		return robotImage;

	}
	void moveRobot(Point2D Point) {
		location = Point;
	}

	BufferedImage drawTokens() {//Start of a method to load the proper image//This should be called drawRobotImage();

		BufferedImage image = null;

		if(robotNum == 1) {
			URL url = Robot.class.getResource(filePath +"diamondSolid.png");
			currentShape= "Diamond";
			//
			if(colorCheck) {
				url = Robot.class.getResource(filePath +"diamondSolid.png");
				currentShape= "Diamond";
			}else {
				url = Robot.class.getResource(filePath +"diamondSolidBW.png");
				currentShape= "Diamond";
			}
			try {
				image = ImageIO.read(url);
				//
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		if(robotNum == 2) {
			URL url =Robot.class.getResource(filePath +"hexagonSolid.png");
			currentShape= "Hexagon";

			if(colorCheck) {
				url = Robot.class.getResource(filePath +"hexagonSolid.png");
				currentShape= "Hexagon";
			}else {
				url = Robot.class.getResource(filePath +"hexagonSolidBW.png");
				currentShape= "Hexagon";
			}
			try {		
				image = ImageIO.read(url);
				//
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		if(robotNum == 3) {
			URL url = Robot.class.getResource(filePath +"moonSolid.png");
			currentShape= "Moon";

			if(colorCheck) {
				url = Robot.class.getResource(filePath +"moonSolid.png");
				currentShape= "Moon";

			}else {
				url = Robot.class.getResource(filePath +"moonSolidBW.png");
				currentShape= "Moon";
			}
			try {
				image = ImageIO.read(url);

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		if(robotNum == 4) {
			URL url = Robot.class.getResource(filePath +"starSolid.png");
			currentShape= "Star";

			if(colorCheck) {
				url = Robot.class.getResource(filePath +"starSolid.png");	
				currentShape= "Star";

			}else {
				url = Robot.class.getResource(filePath +"starSolidBW.png");
				currentShape= "Star";
			}
			try {
				image = ImageIO.read(url);
				// //
			} catch (IOException e) {
				e.printStackTrace();
			}

		}


		
		return image;
		
	}
	public int getRobotNum() {
		return robotNum;
	}


	public void setRobotNum(int robotNum) {
		this.robotNum = robotNum;
	}
}
