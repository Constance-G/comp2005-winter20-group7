package Game;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Token {
	
	String filePath = "/resources/Images/Targets/Numbers/";
	private BufferedImage tokenImage;//This is used to draw the image on to its MapPiece
	Point2D location;//This gets populated during loading. Once the 
	int tokenNum;//Since there are 17 tokens we can organize them from 1-17
	boolean colorCheck;
	
	Token(int tokenNumIn,boolean colorCheckIn){
		 
		colorCheck = colorCheckIn;
		tokenNum = tokenNumIn;
		tokenImage = drawTokens();
	}
	
	BufferedImage drawTokens() {//Start of a method to load the proper image
		
		BufferedImage image = null;
		
		if(tokenNum == 1) {
			try {
				if(colorCheck) {
					URL url = Robot.class.getResource(filePath +"numberToken1.png");
					image = ImageIO.read(url);
				}else {
					URL url = Robot.class.getResource(filePath +"numberToken1BW.png");
					image = ImageIO.read(url);
				}
				                   
			} catch (IOException e) {                        
				e.printStackTrace();                         
			}     
			
			
			                                                 
		}                                                    
		if(tokenNum == 2) {                                  
			try {
				if(colorCheck) {
					URL url = Robot.class.getResource(filePath +"numberToken2.png");
					image = ImageIO.read(url);
				}else {
					URL url = Robot.class.getResource(filePath +"numberToken2BW.png");
					image = ImageIO.read(url);
				}
				                   
			} catch (IOException e) {                        
				e.printStackTrace();                         
			}                                                 
		}                                                    
		if(tokenNum == 3) {                                  
			try {
				if(colorCheck) {
					URL url = Robot.class.getResource(filePath +"numberToken3.png");
					image = ImageIO.read(url);
				}else {
					URL url = Robot.class.getResource(filePath +"numberToken3BW.png");
					image = ImageIO.read(url);
				}
				                   
			} catch (IOException e) {                        
				e.printStackTrace();                         
			}                                                
		}                                                    
		if(tokenNum == 4) {                                  
			try {
				if(colorCheck) {
					URL url = Robot.class.getResource(filePath +"numberToken4.png");
					image = ImageIO.read(url);
				}else {
					URL url = Robot.class.getResource(filePath +"numberToken4BW.png");
					image = ImageIO.read(url);
				}
				                   
			} catch (IOException e) {                        
				e.printStackTrace();                         
			}                                               
		}                                                   
		if(tokenNum == 5) {                                 
			try {
				if(colorCheck) {
					URL url = Robot.class.getResource(filePath +"numberToken5.png");
					image = ImageIO.read(url);
				}else {
					URL url = Robot.class.getResource(filePath +"numberToken5BW.png");
					image = ImageIO.read(url);
				}
				                   
			} catch (IOException e) {                        
				e.printStackTrace();                         
			}                                               
		}                                                  
		if(tokenNum == 6) {                                
			try {
				if(colorCheck) {
					URL url = Robot.class.getResource(filePath +"numberToken6.png");
					image = ImageIO.read(url);
				}else {
					URL url = Robot.class.getResource(filePath +"numberToken6BW.png");
					image = ImageIO.read(url);
				}
				                   
			} catch (IOException e) {                        
				e.printStackTrace();                         
			}                                               
		}                                                   
		if(tokenNum == 7) {                                 
			try {
				if(colorCheck) {
					URL url = Robot.class.getResource(filePath +"numberToken7.png");
					image = ImageIO.read(url);
				}else {
					URL url = Robot.class.getResource(filePath +"numberToken7BW.png");
					image = ImageIO.read(url);
				}
				                   
			} catch (IOException e) {                        
				e.printStackTrace();                         
			}                                                
		}                                                   
		if(tokenNum == 8) {                                 
			try {
				if(colorCheck) {
					URL url = Robot.class.getResource(filePath +"numberToken8.png");
					image = ImageIO.read(url);
				}else {
					URL url = Robot.class.getResource(filePath +"numberToken8BW.png");
					image = ImageIO.read(url);
				}
				                   
			} catch (IOException e) {                        
				e.printStackTrace();                         
			}                                               
		}                                                   
		if(tokenNum == 9) {                                 
			try {
				if(colorCheck) {
					URL url = Robot.class.getResource(filePath +"numberToken9.png");
					image = ImageIO.read(url);
				}else {
					URL url = Robot.class.getResource(filePath +"numberToken9BW.png");
					image = ImageIO.read(url);
				}
				                   
			} catch (IOException e) {                        
				e.printStackTrace();                         
			}                                                
		}                                                    
		if(tokenNum == 10) {                                 
			try {
				if(colorCheck) {
					URL url = Robot.class.getResource(filePath +"numberToken10.png");
					image = ImageIO.read(url);
				}else {
					URL url = Robot.class.getResource(filePath +"numberToken10BW.png");
					image = ImageIO.read(url);
				}
				                   
			} catch (IOException e) {                        
				e.printStackTrace();                         
			}                                               
		}                                                   
		if(tokenNum == 11) {                                
			try {
				if(colorCheck) {
					URL url = Robot.class.getResource(filePath +"numberToken11.png");
					image = ImageIO.read(url);
				}else {
					URL url = Robot.class.getResource(filePath +"numberToken11BW.png");
					image = ImageIO.read(url);
				}
				                   
			} catch (IOException e) {                        
				e.printStackTrace();                         
			}                                                
		}                                                    
		if(tokenNum == 12) {                                 
			try {
				if(colorCheck) {
					URL url = Robot.class.getResource(filePath +"numberToken12.png");
					image = ImageIO.read(url);
				}else {
					URL url = Robot.class.getResource(filePath +"numberToken12BW.png");
					image = ImageIO.read(url);
				}
				                   
			} catch (IOException e) {                        
				e.printStackTrace();                         
			}                                               
		}                                                   
		if(tokenNum == 13) {                                
			try {
				if(colorCheck) {
					URL url = Robot.class.getResource(filePath +"numberToken13.png");
					image = ImageIO.read(url);
				}else {
					URL url = Robot.class.getResource(filePath +"numberToken13BW.png");
					image = ImageIO.read(url);
				}
				                   
			} catch (IOException e) {                        
				e.printStackTrace();                         
			}                                               
		}                                                   
		if(tokenNum == 14) {                                
			try {
				if(colorCheck) {
					URL url = Robot.class.getResource(filePath +"numberToken14.png");
					image = ImageIO.read(url);
				}else {
					URL url = Robot.class.getResource(filePath +"numberToken14BW.png");
					image = ImageIO.read(url);
				}
				                   
			} catch (IOException e) {                        
				e.printStackTrace();                         
			}                                               
		}                                                   
		if(tokenNum == 15) {                                
			try {
				if(colorCheck) {
					URL url = Robot.class.getResource(filePath +"numberToken15.png");
					image = ImageIO.read(url);
				}else {
					URL url = Robot.class.getResource(filePath +"numberToken15BW.png");
					image = ImageIO.read(url);
				}
				                   
			} catch (IOException e) {                        
				e.printStackTrace();                         
			}                                                
		}                                                    
		if(tokenNum == 16) {                                 
			try {
				if(colorCheck) {
					URL url = Robot.class.getResource(filePath +"numberToken16.png");
					image = ImageIO.read(url);
				}else {
					URL url = Robot.class.getResource(filePath +"numberToken16BW.png");
					image = ImageIO.read(url);
				}
				                   
			} catch (IOException e) {                        
				e.printStackTrace();                         
			}                                                
		}                                                    
		if(tokenNum == 17) {                                 
			try {
				if(colorCheck) {
					URL url = Robot.class.getResource(filePath +"numberToken17.png");
					image = ImageIO.read(url);
				}else {
					URL url = Robot.class.getResource(filePath +"numberToken17BW.png");
					image = ImageIO.read(url);
				}
				                   
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
