import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;



public class TokenBox implements ActionListener{

	private JPanel tokenBoxJPanel;
	private JPanel numberBoxJPanel;
	private JPanel shapeBoxJPanel;
	private JButton genBtn;
	private JLabel tokenTitleJLabel;
	private BufferedImage shapeImage;
	private String filePath = "/resources/Images/Targets/";
	private JLabel displayShapeJLabel;
	private Random randomNum = new Random();
	private JLabel displayNumJLabel;
	private ArrayList<String> picNameStrings = new ArrayList<String>();
	private SettingsPanel colorVerify = new SettingsPanel(); // to update the color mode 
	private JPanel titleBoxJPanel;
	private JLabel movingLabel; //second label "Where will you move.."
	private ArrayList<String> pieceNamesArrayList = new ArrayList<String>(); //list of the piece names
	private JLabel shapeJLabel; //label to display the current target shape, getShape method
	private JLabel numberJLabel; //label to display the current target num, getTokenNumber method
	private int tokenNumber;
	private String currentShape = new String();
	
	//Constructor
	public TokenBox() {
		
		//build the arraylist of the token shape pieces names
		//0-5 are color and 6-10 are black and white
		picNameStrings.add("diamondSolid.png");
		picNameStrings.add("hexagonSolid.png");
		picNameStrings.add("moonSolid.png");
		picNameStrings.add("pyramidSolid.png");
		picNameStrings.add("starSolid.png");
		picNameStrings.add("multiColor.png");
		picNameStrings.add("diamondSolidBW.png");
		picNameStrings.add("hexagonSolidBW.png");
		picNameStrings.add("moonSolidBW.png");
		picNameStrings.add("pyramidSolidBW.png");
		picNameStrings.add("starSolidBW.png");
		picNameStrings.add("multiColorBW.png");
		//TODO add black player piece
		
		//build arraylist of names to match the shapes
		pieceNamesArrayList.add("Diamond");
		pieceNamesArrayList.add("Hexagon");
		pieceNamesArrayList.add("Moon");
		pieceNamesArrayList.add("Pyramid");
		pieceNamesArrayList.add("Star");
		pieceNamesArrayList.add("Multi-Color");
		//TODO add black player piece
		
	}
	
	public JPanel makeFrame()
	{
		//a JPanel to hold the random token generator components
		tokenBoxJPanel = new JPanel();
		tokenBoxJPanel.setLayout(new FlowLayout());
		tokenBoxJPanel.setSize(50, 50);
		
		titleBoxJPanel = new JPanel();
		titleBoxJPanel.setLayout(new BoxLayout(titleBoxJPanel, BoxLayout.PAGE_AXIS));
		numberBoxJPanel = new JPanel();
		shapeBoxJPanel = new JPanel();
		
		//put in a holder image at start
		if (colorVerify.getColorCheck()) {
			try {
				shapeImage = ImageIO.read(getClass().getResource(filePath + "holderImage.png"));
			} catch (IOException e) {
				// TODO  add exception code
				e.printStackTrace();
			}
		}
		else {
			try {
				shapeImage = ImageIO.read(getClass().getResource(filePath + "holderImageBW.png"));
			} catch (IOException e) {
				// TODO add exception code
				e.printStackTrace();
			}
		}
		displayShapeJLabel = new JLabel(new ImageIcon(shapeImage));
		shapeBoxJPanel.add(displayShapeJLabel);
		
		displayNumJLabel = new JLabel(new ImageIcon(shapeImage));
		numberBoxJPanel.add(displayNumJLabel);
		
		genBtn = new JButton("Next Turn");
		genBtn.addActionListener(this);
		
		shapeJLabel = new JLabel("Shape: Press the button to start!");
		numberJLabel = new JLabel("Number: Press the button to start!");
		
		
		tokenTitleJLabel = new JLabel("Click for the next round!");
		movingLabel = new JLabel("Where will you move next?!");
		titleBoxJPanel.add(tokenTitleJLabel);
		titleBoxJPanel.add(movingLabel);
		titleBoxJPanel.add(Box.createRigidArea(new Dimension(0,5)));
		titleBoxJPanel.add(genBtn);
		titleBoxJPanel.add(shapeJLabel);
		titleBoxJPanel.add(numberJLabel);
		
		
		
		tokenBoxJPanel.add(titleBoxJPanel);
		tokenBoxJPanel.add(shapeBoxJPanel);
		tokenBoxJPanel.add(numberBoxJPanel);
		//tokenBoxJPanel.add(genBtn);
						
		tokenBoxJPanel.setVisible(true);
		
		return tokenBoxJPanel;
		
	}
	
	//method to change the shape token
	public void generateNewShape() {
		//TODO later add in the black player piece and change the random number range
		//get a Random number between 0 and 5 for color or 6-11 for BW
		int randInt;
		if (colorVerify.getColorCheck()) {
			randInt = randomNum.nextInt(6);
		}
		else {
			randInt = randomNum.nextInt((11-6) + 1) + 6;
		}
		
		//get the shape associated with the number
		String shapeChosenString = picNameStrings.get(randInt);
		try {
			shapeImage = ImageIO.read(getClass().getResource(filePath + shapeChosenString));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//shapeIcon = new ImageIcon(shapeImage);
		displayShapeJLabel.setIcon(new ImageIcon(shapeImage));
		if (randInt > 5) { //if BW number bring down to color for name indexing
			randInt -= 6;
		}
		currentShape = pieceNamesArrayList.get(randInt);
		shapeJLabel.setText("Target Shape: " + currentShape);
				
	}
	
	//method to change the random num token
	public void generateRandomNum() {
		//get a Random number between 1 and 17
		int randInt = randomNum.nextInt((17-1) + 1) + 1;
		tokenNumber = randInt; //storing the number for the get method
		//display this on the JLabel
		String convertToString;
		if (colorVerify.getColorCheck()) {
			convertToString = Integer.toString(randInt);
		}
		else {
			convertToString = Integer.toString(randInt) + "BW";
		}
		try {
			shapeImage = ImageIO.read(getClass().getResource(filePath + "/Numbers/numberToken" + convertToString + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		displayNumJLabel.setIcon(new ImageIcon(shapeImage));
		numberJLabel.setText("Target Number: " + randInt);
	}
	
	//get method to return the currently selected token number
	// @params: none
	// returns: int
	public int getTokenNumber() {
		return tokenNumber;
	}
	
	//get method to return the currently selected token shape
	// @params: none
	// returns: String
	public String getTokenShape() {
		return currentShape;
	}
	
	//Event Listeners
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == genBtn) {
			generateRandomNum();
			generateNewShape();
		}
		
	}

}
