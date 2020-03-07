import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Robot {

	private String filePath = "/resources/Images/PlayerPieces/";
	private int robotNum;
	private BufferedImage robotImage;
	Point location = new Point(1,1); //from (0-15,0-15) on the grid
	boolean colorCheck;
	
	Robot(int robotNumIn,boolean colorCheckIn){
		robotNum = robotNumIn;
		robotImage = drawTokens();
		colorCheck = colorCheckIn;
	}
	
	public void setLocation(Point locationIn,boolean colorcheck) {
		
		location = locationIn;
	}
	public Point GetLocation() {
		
		return location;
	}
	
	public BufferedImage getRobotImage() {
		return robotImage;
		
	}
	
	BufferedImage drawTokens() {//Start of a method to load the proper image

		BufferedImage image = null;
		
			if(robotNum == 1) {
				URL url = Robot.class.getResource(filePath +"1.png");
				try {
					if(colorCheck ==true) {
						url = Robot.class.getResource(filePath +"1.png");
					}else {
						//url = Robot.class.getResource(filePath +"6.png");
					}
					image = ImageIO.read(url);
					// System.out.println("1");
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
			
			if(robotNum == 2) {
				URL url =Robot.class.getResource(filePath +"2.png");
				try {
					if(colorCheck ==true) {
						url = Robot.class.getResource(filePath +"2.png");
					}else {
						//url = Robot.class.getResource(filePath +"7.png");
					}
						
					image = ImageIO.read(url);
					// System.out.println("2");
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
			if(robotNum == 3) {
				URL url = Robot.class.getResource(filePath +"3.png");
				try {
					if(colorCheck ==true) {
						url = Robot.class.getResource(filePath +"3.png");
						
					}else {
						//url = Robot.class.getResource(filePath +"8.png");
					}
					
					image = ImageIO.read(url);
					// System.out.println("3");
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
			if(robotNum == 4) {
				URL url = Robot.class.getResource(filePath +"5.png");
				try {
					if(colorCheck ==true) {
						url = Robot.class.getResource(filePath +"5.png");		
				
					}else {
						//url = Robot.class.getResource(filePath +"9.png");
					}
					
					image = ImageIO.read(url);
					// System.out.println("4");
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		
		
		
		return image;
		
	}
}
