import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Token {
	
	String filePath = "/resources/Images/Targets/";
	private BufferedImage tokenImage;//This is used to draw the image on to its MapPiece
	Point2D location;//This gets populated during loading. Once the 
	int tokenNum;//Since there are 17 tokens we can organize them from 1-17
	
	Token(int tokenNumIn){
		 
		tokenNum = tokenNumIn;
		tokenImage = drawTokens();
	}
	
	BufferedImage drawTokens() {//Start of a method to load the proper image
		
		BufferedImage image = null;
		
		if(tokenNum == 1) {
			try {
				URL url = Robot.class.getResource(filePath +"1.png");
				 image = ImageIO.read(url);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		if(tokenNum == 2) {
			try {
				URL url = Robot.class.getResource(filePath +"2.png");
				 image = ImageIO.read(url);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(tokenNum == 3) {
			try {
				URL url = Robot.class.getResource(filePath +"3.png");
				 image = ImageIO.read(url);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(tokenNum == 4) {
			try {
				URL url = Robot.class.getResource(filePath +"4.png");
				 image = ImageIO.read(url);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(tokenNum == 5) {
			try {
				URL url = Robot.class.getResource(filePath +"5.png");
				 image = ImageIO.read(url);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(tokenNum == 6) {
			try {
				URL url = Robot.class.getResource(filePath +"6.png");
				 image = ImageIO.read(url);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(tokenNum == 7) {
			try {
				URL url = Robot.class.getResource(filePath +"7.png");
				 image = ImageIO.read(url);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(tokenNum == 8) {
			try {
				URL url = Robot.class.getResource(filePath +"8.png");
				 image = ImageIO.read(url);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(tokenNum == 9) {
			try {
				URL url = Robot.class.getResource(filePath +"9.png");
				 image = ImageIO.read(url);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(tokenNum == 10) {
			try {
				URL url = Robot.class.getResource(filePath +"10.png");
				 image = ImageIO.read(url);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(tokenNum == 11) {
			try {
				URL url = Robot.class.getResource(filePath +"11.png");
				 image = ImageIO.read(url);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(tokenNum == 12) {
			try {
				URL url = Robot.class.getResource(filePath +"12.png");
				 image = ImageIO.read(url);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(tokenNum == 13) {
			try {
				URL url = Robot.class.getResource(filePath +"13.png");
				 image = ImageIO.read(url);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(tokenNum == 14) {
			try {
				URL url = Robot.class.getResource(filePath +"14.png");
				 image = ImageIO.read(url);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(tokenNum == 15) {
			try {
				URL url = Robot.class.getResource(filePath +"15.png");
				 image = ImageIO.read(url);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(tokenNum == 16) {
			try {
				URL url = Robot.class.getResource(filePath +"16.png");
				 image = ImageIO.read(url);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(tokenNum == 17) {
			try {
				URL url = Robot.class.getResource(filePath +"17.png");
				 image = ImageIO.read(url);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return image;
		
	}
	
	public BufferedImage getTokenImage() {
		
		return tokenImage;
		
	}
}
