import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

/*
 * This class responsible is for an individual tile of the game.
 */




class MapPiece extends BufferedImage{

	private Dimension SCREENSIZE;
	private String pieceType;//
	int fontSize;


	MapPiece(String type,Dimension MapSize,int fontSizeTemp){

		super(GameBoard.SCREENSIZE.width/20, GameBoard.SCREENSIZE.height/20, BufferedImage.TYPE_INT_ARGB);
		SCREENSIZE = MapSize;
		this.pieceType = type;
		fontSize = fontSizeTemp;
		System.out.println(fontSizeTemp);
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
		//Draw Tiles
		if(pieceType.equals("reg")) {

			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(0, 0, SCREENSIZE.width/20-1,SCREENSIZE.height/20-1);
			g.setColor(Color.BLACK);
			g.setFont(new Font("TimesRoman", Font.PLAIN, SCREENSIZE.width/50)); 
			g.drawString("",10,30);
		}
		if(pieceType.startsWith("1l")) {
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(0, 0, SCREENSIZE.width/20-1,SCREENSIZE.height/20-1);
			g.setColor(Color.BLACK);
			g.setFont(new Font("TimesRoman", Font.PLAIN, SCREENSIZE.width/50)); 
			g.drawString("",10,30);
			g.fillRect((SCREENSIZE.height/20-1)-(SCREENSIZE.height/80-1),0,SCREENSIZE.width/80-1,SCREENSIZE.height/20-1);
			g.fillRect(0,0,SCREENSIZE.width/20-1,SCREENSIZE.height/80-1);

		}
		if(pieceType.startsWith("2l")) {
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(0, 0, SCREENSIZE.width/20-1,SCREENSIZE.height/20-1);
			g.setColor(Color.BLACK);
			g.setFont(new Font("TimesRoman", Font.PLAIN, SCREENSIZE.width/50)); 
			g.drawString("",10,30);
			g.fillRect(0,0,SCREENSIZE.width/20-1,SCREENSIZE.height/80-1);
			g.fillRect((SCREENSIZE.height/20-1)-(SCREENSIZE.height/20-1),0,SCREENSIZE.width/80-1,SCREENSIZE.height/20-1);

		}
		if(pieceType.startsWith("3l")) {
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(0, 0, SCREENSIZE.width/20-1,SCREENSIZE.height/20-1);
			g.setColor(Color.BLACK);
			g.setFont(new Font("TimesRoman", Font.PLAIN, SCREENSIZE.width/50)); 
			g.drawString("",10,30);
			g.fillRect(0,(SCREENSIZE.height/20-1)-(SCREENSIZE.height/80-1),SCREENSIZE.width/20-1,SCREENSIZE.height/80-1);
			g.fillRect((SCREENSIZE.height/20-1)-(SCREENSIZE.height/20-1),0,SCREENSIZE.width/80-1,SCREENSIZE.height/20-1);

		}
		if(pieceType.startsWith("4l")) {
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(0, 0, SCREENSIZE.width/20-1,SCREENSIZE.height/20-1);
			g.setColor(Color.BLACK);
			g.setFont(new Font("TimesRoman", Font.PLAIN, SCREENSIZE.width/50)); 
			g.drawString("",10,30);
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
			g.drawString("",20,30);
			g.fillRect(0,(SCREENSIZE.height/20-1)-(SCREENSIZE.height/80-1),SCREENSIZE.width/20-1,SCREENSIZE.height/80-1);
		}
		if(pieceType.equals("leftWall")) {
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(0, 0, SCREENSIZE.width/20-1,SCREENSIZE.height/20-1);
			g.setColor(Color.BLACK);
			g.setFont(new Font("TimesRoman", Font.PLAIN, SCREENSIZE.width/100)); 
			g.drawString("",20,30);
			g.fillRect((SCREENSIZE.height/20-1)-(SCREENSIZE.height/20-1),0,SCREENSIZE.width/80-1,SCREENSIZE.height/20-1);

		}
		if(pieceType.equals("rightWall")) {
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(0, 0, SCREENSIZE.width/20-1,SCREENSIZE.height/20-1);
			g.setColor(Color.BLACK);
			g.setFont(new Font("TimesRoman", Font.PLAIN, SCREENSIZE.width/100)); 
			g.drawString("",20,30);
			g.fillRect((SCREENSIZE.height/20-1)-(SCREENSIZE.height/80-1),0,SCREENSIZE.width/80-1,SCREENSIZE.height/20-1);
		}
		if(pieceType.equals("topWall")) {
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(0, 0, SCREENSIZE.width/20-1,SCREENSIZE.height/20-1);
			g.setColor(Color.BLACK);
			g.setFont(new Font("TimesRoman", Font.PLAIN, SCREENSIZE.width/100)); 
			g.drawString("",20,30);

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
		//End Draw Tiles

		
		
		String[] splt = pieceType.split(",");
		if(splt.length>1) {
			g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize)); 
			g.drawString(splt[1],20,30);
		}

		return this;

	}


	void addToken(BufferedImage tokenImage) {
		
		
		
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

}