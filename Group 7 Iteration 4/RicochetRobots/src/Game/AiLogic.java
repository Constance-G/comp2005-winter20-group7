package Game;

import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Random;



/*
 * This is the class that controls the computer players.
 * This implementation 
 */

public class AiLogic {


	// Main logic;
	String[] directions = { "N", "S", "E", "W" };
	
	double[] weights;
	double[] nLayer;
	double[] sLayer;
	double[] eLayer;
	double[] wLayer;

	double[] outputLayer = new double[4];// Corresponds to the likelihood of each direction being the correct one

	String targetShape;
	Robot targetRobot;

	Robot[] robots;

	double[] initalValues;
	double[][] possibleValues;//
	double[] finalValues;//

	String direction;
	boolean isDoingTurn = false;

	ArrayList<String> directionHistory = new ArrayList<String>();
	Random r = new Random();

	AiLogic() {

	}

	String getNext(Player player, GameBoard gb) {

		int moveChoice = -1;
		double largestValue = -1;
		// Get the direction from outputLayer
		for (int i = 0; i < 4; i++) {

			if (outputLayer[i] > largestValue) {
				largestValue = outputLayer[i];
				moveChoice = i;
			}
		}
		if (largestValue == -1) {
			loadLiveData(player, gb);
		}

		moveChoice = -1;
		largestValue = -1;
		// Get the direction from outputLayer
		for (int i = 0; i < 4; i++) {

			if (outputLayer[i] > largestValue) {
				largestValue = outputLayer[i];
				moveChoice = i;

			}
		}
		outputLayer[moveChoice] = -1;

		if (directionHistory.size() > 5) {

			//
			//
			//
			//

			if (directionHistory.get(directionHistory.size() - 1)
					.equals(directionHistory.get(directionHistory.size() - 2))) {
				//

				while (true) {

					int num = r.nextInt(4);
					

					if(directions[num].equals(directionHistory.get(directionHistory.size() - 1))) {
						
					}else {
						//
						directionHistory.add(directions[num]);
						return directions[num];

					}
				}

			}

			if (direction.equals(directionHistory.get(directionHistory.size() - 3)) && directionHistory
					.get(directionHistory.size() - 2).equals(directionHistory.get(directionHistory.size() - 4))) {
				//

				while (true) {

					int num = r.nextInt(4);
					
					if(directions[num].equals(directionHistory.get(directionHistory.size() - 1))) {
						
					}else {
						//
						directionHistory.add(directions[num]);
						return directions[num];

					}
				}

			}

			if (direction.equals(directionHistory.get(directionHistory.size() - 5)) && directionHistory
					.get(directionHistory.size() - 2).equals(directionHistory.get(directionHistory.size() - 6))) {
				//
				while (true) {

					int num = r.nextInt(4);

					if(directions[num].equals(directionHistory.get(directionHistory.size() - 1))) {
						
					}else {
						//
						directionHistory.add(directions[num]);
						return directions[num];

					}
				}

			}
		}
		directionHistory.add(directions[moveChoice]);
		direction = directions[moveChoice];
		//
		//
		//
		//
		//

		return directions[moveChoice];
	}

	void loadLiveData(Player player, GameBoard gb) {// True of works

		if (weights == null) {
			loadWeights();
		}
		loadInitalValues(gb);
		 outputLayer[0]=1;
		 outputLayer[1]=1;
		 outputLayer[2]=1;
		 outputLayer[3]=1;
				 

		outputLayer[0] = outputLayer[0] * nLayer[0] * (initalValues[0] / 15);
		outputLayer[0] = outputLayer[0] * nLayer[1] * (initalValues[1] / 15);

		outputLayer[1] = outputLayer[1] * sLayer[0] * (initalValues[0] / 15);
		outputLayer[1] = outputLayer[1] * sLayer[1] * (initalValues[1] / 15);

		outputLayer[2] = outputLayer[2] * eLayer[0] * (initalValues[0] / 15);
		outputLayer[2] = outputLayer[2] * eLayer[1] * (initalValues[1] / 15);

		outputLayer[3] = outputLayer[3] * wLayer[0] * (initalValues[0] / 15);
		outputLayer[3] = outputLayer[3] * wLayer[1] * (initalValues[1] / 15);

	}

	// Input from the state of the game
	private void loadInitalValues(GameBoard gb) {

		targetShape = gb.insertBox.getTokenShape();
		int index = 0;
		for (Robot robot : gb.gamePanel.robots) {
			//
			if (robot.currentShape.equals(targetShape)) {
				//
				targetRobot = robot;
			}

		}
		MapPiece targetPiece = null;

		MapPiece[][] mpArray = (MapPiece[][]) gb.gamePanel.imageMap;
		for (MapPiece[] mpArray1 : mpArray) {
			for (MapPiece mp : mpArray1) {
				if (mp.token != null) {
					// //
					// //
					if (mp.token.tokenNum == gb.insertBox.getTokenNumber()) {
						targetPiece = mp;
						break;
					}
				}
			}
			
		}
		if(gb.insertBox.getTokenNumber() == 18) {
			targetPiece = mpArray[1][1];
		}
		
		initalValues = new double[2];
		if (targetPiece == null) {
			initalValues[0] = 0;
			initalValues[1] = 0;
			return;
		}
		initalValues[0] = (targetPiece.point.getX() - targetRobot.location.getX());// Robot1 x position difference
		initalValues[1] = (targetPiece.point.getY() - targetRobot.location.getY());// Robot1 y position difference

	}

	// The ai's "Memory" of sorts
	private void loadWeights() {
		// TODO Auto-generated method stub
		String filePath = "/resources/Images/Targets/AiWeights.txt";
		//URL url = getClass().getResource(filePath);
		//File weightFile = new File(url.getFile());
		//BufferedReader reader = null;
		weights = new double[8];

		//try {
			//reader = new BufferedReader(new FileReader(weightFile));
		//} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}

		int index = 0;
		//while (true) {
			//try {
				//String text = reader.readLine();

				//if (text == null) {
					//break;
				//}

				//weights[index] = Double.parseDouble(text);
			//	//
			//	index++;
			//} catch (IOException e) {
				// TODO Auto-generated catch block
			//	e.printStackTrace();
			//}
		//}
		//These are being hard coded and the code above is commented out.
		//This is to allow for future implementation  of a more complex Ai with multiple layers
		//Right
		weights[0] = 0.5;
		weights[1] = 1.0;
		weights[2] = 0.5;
		weights[3] = 0.0;
		weights[4] = 1.0;
		weights[5] = 0.5;
		weights[6] = 0.0;
		weights[7] = 0.5;

		nLayer = new double[2];
		sLayer = new double[2];
		eLayer = new double[2];
		wLayer = new double[2];

		nLayer[0] = weights[0];
		nLayer[1] = weights[1];

		sLayer[0] = weights[2];
		sLayer[1] = weights[3];

		eLayer[0] = weights[4];
		eLayer[1] = weights[5];

		wLayer[0] = weights[6];
		wLayer[1] = weights[7];

	}
}
