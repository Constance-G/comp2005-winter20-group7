package Game;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

public class Load {

	// GamePanel gamePanel;
	//These are loaded by the loadGame method
	Player[] players = new Player[4];
	boolean colorCheck;
	String config;
	int fontSize;
	Robot[] robots = new Robot[4];
	MapPanel[] mapLayout = new MapPanel[4];
	String playersTurn;//Only records players name
	boolean isBettingRound;
	boolean isTurnRound;
	int tokenNum;
	String currentShape;
	boolean waitingForTurn = true;

	// Call this method to open a load dialog and fill in the variables above

	public GamePanel getGamePanelFromLoadState() {
		
		
		Player playerIn =null;
		for (Player player : players) {
			if (player.name.equals(playersTurn)) {
				playerIn = player;
			}
		}

		GamePanel gamePanel = new GamePanel(config, players, colorCheck, fontSize, mapLayout,robots, playerIn, isBettingRound,
				isTurnRound,waitingForTurn);
		return gamePanel;

	}
	
	

	public boolean loadGame() {

		GamePanel gamePanel = new GamePanel();

		// Class abc = Class.forName(className);
		// gamePanel.mapLayout[0];

		Path source = Paths.get("").toAbsolutePath().normalize();
		Path saveFolder = Paths.get(source + "/saves");
		File file = new File(saveFolder.toString());

		if (!file.isDirectory()) {//Create the save folder if it doesn't exist. This is just one way to handle the case where the user tries to load without having a save game.
			try {

				Files.createDirectories(saveFolder);
				System.out.println("Creating save folder: ");
			} catch (IOException e) {
				System.out.println("Failed to create save folder: ");
				e.printStackTrace();
			}

		}

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(file);

		int result = fileChooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			BufferedReader reader = null;

			try {
				reader = new BufferedReader(new FileReader(selectedFile));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			String[] stringArray = new String[100];
			int index = 0;
			while (true) {
				try {
					String text = reader.readLine();

					if (text == null) {
						break;
					}
					stringArray[index] = text;
					System.out.println(stringArray[index]);
					index++;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			index = 0;

			for (String str : stringArray) {

				if (str == null) {
					break;
				}

				if (str.equals("#GamePanel")) {
					String[] maps = stringArray[index + 1].split(",");
					mapLayout[0] = getMapPanel(maps[0]);
					mapLayout[1] = getMapPanel(maps[1]);
					mapLayout[2] = getMapPanel(maps[2]);
					mapLayout[3] = getMapPanel(maps[3]);

					if (stringArray[index + 2].equals("true")) {

						colorCheck = true;
					} else {
						colorCheck = false;
					}
					config = stringArray[index + 3];
					fontSize = Integer.parseInt(stringArray[index + 4]);	
					if(!stringArray[index + 5].equals("null")) {
					playersTurn =stringArray[index + 5];
					}else {
						playersTurn =null;
					}
					if (stringArray[index + 6].equals("true")) {

						isBettingRound = true;
					} else {
						isBettingRound = false;
					}
					if (stringArray[index + 7].equals("true")) {

						isTurnRound = true;
					} else {
						isTurnRound = false;
					}
					if (stringArray[index + 8].equals("true")) {

						waitingForTurn = true;
					} else {
						waitingForTurn = false;
					}
					

				}
				if (str.equals("#Robots")) {
					String[] robot1 = stringArray[index + 1].split(",");
					String[] robot2 = stringArray[index + 2].split(",");
					String[] robot3 = stringArray[index + 3].split(",");
					String[] robot4 = stringArray[index + 4].split(",");
					System.out.println(robot1[2]);

					robots[0] = new Robot(Integer.parseInt(robot1[2]), true);
					robots[1] = new Robot(Integer.parseInt(robot2[2]), true);
					robots[2] = new Robot(Integer.parseInt(robot3[2]), true);
					robots[3] = new Robot(Integer.parseInt(robot4[2]), true);
					robots[0].location = new Point((int) Double.parseDouble(robot1[0]),
							(int) Double.parseDouble(robot1[1]));
					robots[1].location = new Point((int) Double.parseDouble(robot2[0]),
							(int) Double.parseDouble(robot2[1]));
					robots[2].location = new Point((int) Double.parseDouble(robot3[0]),
							(int) Double.parseDouble(robot3[1]));
					robots[3].location = new Point((int) Double.parseDouble(robot4[0]),
							(int) Double.parseDouble(robot4[1]));

				}
				if (str.equals("#Players")) {
					String[] player1 = stringArray[index + 1].split(",");
					String[] player2 = stringArray[index + 2].split(",");
					String[] player3 = stringArray[index + 3].split(",");
					String[] player4 = stringArray[index + 4].split(",");

					players[0] = new Player();
					players[0].name = player1[0];
					players[0].tokens = Integer.parseInt(player1[1]);
					players[0].bet = Integer.parseInt(player1[2]);
					if(player1[3].equals("true")) {

						players[0].isComputer = true;
						players[0].configDisplay.playerType.getModel().setSelectedItem("Computer");
					} else {
						players[0].isComputer = false;
						players[0].configDisplay.playerType.getModel().setSelectedItem("Human");
					}
					
					players[1] = new Player();
					players[1].name = player2[0];
					players[1].tokens = Integer.parseInt(player2[1]);
					players[1].bet = Integer.parseInt(player2[2]);
					if( player2[3].equals("true")) {

						players[1].isComputer = true;
						players[1].configDisplay.playerType.getModel().setSelectedItem("Computer");
					} else {
						players[1].isComputer = false;
						players[1].configDisplay.playerType.getModel().setSelectedItem("Human");
					}
					
					players[2] = new Player();
					players[2].name = player3[0];
					players[2].tokens = Integer.parseInt(player3[1]);
					players[2].bet = Integer.parseInt(player3[2]);
					if( player3[3].equals("true")) {

						players[2].isComputer = true;
						players[2].configDisplay.playerType.getModel().setSelectedItem("Computer");
					} else {
						players[2].isComputer = false;
						players[2].configDisplay.playerType.getModel().setSelectedItem("Human");
					}
					
					players[3] = new Player();
					players[3].name = player4[0];
					players[3].tokens = Integer.parseInt(player4[1]);
					players[3].bet = Integer.parseInt(player4[2]);
					if( player4[3].equals("true")) {

						players[3].isComputer = true;
						players[3].configDisplay.playerType.getModel().setSelectedItem("Computer");
					} else {
						players[3].isComputer = false;
						players[3].configDisplay.playerType.getModel().setSelectedItem("Human");
					}
					
				}
				
				
				if(str.contentEquals("#TokenBox")) {
			
					currentShape = stringArray[index +1];
					tokenNum = Integer.parseInt(stringArray[index +2]);
				}
				index++;

			}
			return true;

		}else {
			return false;
		}

	}

	public static MapPanel getMapPanel(String classname) {

		if (classname.equals("Game.SimplePanel1")) {
			return new SimplePanel1();
		}
		if (classname.equals("Game.SimplePanel2")) {
			return new SimplePanel1();
		}
		if (classname.equals("Game.SimplePanel3")) {
			return new SimplePanel1();
		}
		if (classname.equals("Game.SimplePanel4")) {
			return new SimplePanel1();
		}
		if (classname.equals("Game.ComplexPanel1")) {
			return new ComplexPanel1();
		}
		if (classname.equals("Game.ComplexPanel2")) {
			return new ComplexPanel2();
		}
		if (classname.equals("Game.ComplexPanel3")) {
			return new ComplexPanel3();
		}
		if (classname.equals("Game.ComplexPanel4")) {
			return new ComplexPanel4();
		}

		return null;

	}
}
