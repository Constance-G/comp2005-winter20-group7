package Game;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Save {

	public void saveGame(GamePanel gp, Player[] playersIn,TokenBox token) {

		Path source = Paths.get("").toAbsolutePath().normalize();

		Path newFolder = Paths.get(source + "/saves");

		File file = new File(newFolder.toString());

		if (!file.isDirectory()) {
			try {

				Files.createDirectories(newFolder);
				//
			} catch (IOException e) {
				//
				e.printStackTrace();
			}
		}

		MapPanel[] layout = gp.mapLayout;// hand to mapGen on rebuild
		String boardType = gp.boardType;// simple or complex
		boolean colorCheck = gp.colorCheck;
		Robot[] robots = gp.robots;// Need to preserve these
		Player[] players = playersIn;

		StringBuilder sb = new StringBuilder();
		String line = "";

		// GamePanel info

		line = "#GamePanel";
		sb.append(line);
		sb.append(System.lineSeparator());
		line = layout[0].getClass().getName() + "," + layout[1].getClass().getName() + ","
				+ layout[2].getClass().getName() + "," + layout[3].getClass().getName();// Record mapLayout
		System.out.println(layout[0].getClass().getName() + "," + layout[1].getClass().getName() + ","
				+ layout[2].getClass().getName() + "," + layout[3].getClass().getName());
		sb.append(line);
		sb.append(System.lineSeparator());
		line = Boolean.toString(colorCheck);//colorCheck
		sb.append(line);
		sb.append(System.lineSeparator());
		line = gp.config;//Config
		sb.append(line);
		sb.append(System.lineSeparator());
		line = String.valueOf(gp.fontSize);///fontSize
		sb.append(line);
		sb.append(System.lineSeparator());
		
		if(gp.playersTurn!=null) {
		line = String.valueOf(gp.playersTurn.name);//playersTurn.name
		}else {
			line ="null";
		}	
		sb.append(line);
		sb.append(System.lineSeparator());
		line = String.valueOf(gp.isBettingRound);//isBettingRound
		sb.append(line);
		sb.append(System.lineSeparator());
		line = String.valueOf(gp.isTurnRound);//isTurnRound
		sb.append(line);
		sb.append(System.lineSeparator());
		line = String.valueOf(gp.waitingForTurn);//waitingForTurn
		sb.append(line);
		sb.append(System.lineSeparator());
		
		
		
		line = "#Robots";
		sb.append(line);
		sb.append(System.lineSeparator());
		line = robots[0].location.getX() + "," + robots[0].location.getY() + "," + robots[0].getRobotNum();
		sb.append(line);
		sb.append(System.lineSeparator());
		line = robots[1].location.getX() + "," + robots[1].location.getY() + "," + robots[1].getRobotNum();
		sb.append(line);
		sb.append(System.lineSeparator());
		line = robots[2].location.getX() + "," + robots[2].location.getY() + "," + robots[2].getRobotNum();
		sb.append(line);
		sb.append(System.lineSeparator());
		line = robots[3].location.getX() + "," + robots[3].location.getY() + "," + robots[3].getRobotNum();
		sb.append(line);
		sb.append(System.lineSeparator());
		
		line = "#Players";
		sb.append(line);
		sb.append(System.lineSeparator());
		line = players[0].getPlayerName() + "," + players[0].tokens+ "," + players[0].bet+","+Boolean.toString(players[0].isComputer);
		sb.append(line);
		sb.append(System.lineSeparator());
		line = players[1].getPlayerName() + "," + players[1].tokens+ "," + players[0].bet+","+Boolean.toString(players[1].isComputer);
		sb.append(line);
		sb.append(System.lineSeparator());
		line = players[2].getPlayerName() + "," + players[2].tokens+ "," + players[0].bet+","+Boolean.toString(players[2].isComputer);
		sb.append(line);
		sb.append(System.lineSeparator());
		line = players[3].getPlayerName() + "," + players[3].tokens+ "," + players[0].bet+","+Boolean.toString(players[3].isComputer);
		sb.append(line);
		sb.append(System.lineSeparator());
		
		
		line = "#TokenBox";// Add tokenbox logic
		sb.append(line);
		sb.append(System.lineSeparator());
		line = token.getTokenShape();
		sb.append(line);
		sb.append(System.lineSeparator());
		line = String.valueOf(token.getTokenNumber());
		sb.append(line);
		sb.append(System.lineSeparator());
		

		File fileOut = new File(file.getPath() + "/" + System.currentTimeMillis() + ".txt");
		FileWriter writer = null;
		//
		try {
			fileOut.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			writer = new FileWriter(fileOut.getAbsolutePath(), true);
		} catch (IOException e) {

			e.printStackTrace();
		}
		try {

			for (String str : sb.toString().split(System.lineSeparator())) {

				writer.write(str);
				writer.write(System.getProperty("line.separator"));
				writer.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
