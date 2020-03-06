import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PlayersSetup extends JPanel{
	
	
	String[] players = {"2","3","4"};
	JComboBox<String> jCombo = new JComboBox<String>(players);
	JTextField nameLabel = new JTextField("Choose number of players: ");
	JButton startSimpleButton = new JButton("Start Simple");
	JButton startComplexButton = new JButton("Start Complex");
	JButton backButton = new JButton("Back");
	
	Player player1 = new Player(true);//This is used with the Player(boolean forceHuman) and the PlayerConfig(boolean forceHuman) 
									  //	to make sure player 1 is always a human to satisfy the requirement of at least 1 human player
									  //TODO: This could use a some refining
	Player player2 = new Player();
	Player player3 = new Player();
	Player player4 = new Player();
	
	
	PlayersSetup(){
		
		setPreferredSize(new Dimension(400,600));
		nameLabel.setEditable(false);
		add(nameLabel);
		
		jCombo.setSelectedIndex(2);//Make 4 be the default selected value
		add(jCombo);	
		
		update();
	}
	
	Player[] getPlayerArray() {//Returns an array of all 4 players
		

			Player[] players = new Player[4];
			players[0] = player1;
			players[1] = player2;
			players[2] = player3;
			players[3] = player4;
			return players;
	
	}
	
	void update() { //called when object is created and when the number of players is changed
		
		
		if(jCombo.getSelectedItem().equals("2")) {
			for(Component comp: getComponents()) {
				if(!comp.equals(jCombo)&& !comp.equals(nameLabel)) {
					remove(comp);
				}
			}
			
			add(player1.configDisplay);
			add(player2.configDisplay);
			//Ensures at least one player is human 
			System.out.println("2");
		
		}//
		if(jCombo.getSelectedItem().equals("3")) {
			for(Component comp: getComponents()) {
				if(!comp.equals(jCombo)&& !comp.equals(nameLabel)) {
					remove(comp);
				}
			}
			add(player1.configDisplay);
			add(player2.configDisplay);
			add(player3.configDisplay);
			
			System.out.println("3");
		}
		if(jCombo.getSelectedItem().equals("4")) {
			for(Component comp: getComponents()) {
				if(!comp.equals(jCombo)&& !comp.equals(nameLabel)) {
					remove(comp);
				}
			}
			add(player1.configDisplay);
			add(player2.configDisplay);
			add(player3.configDisplay);
			add(player4.configDisplay);
			
			System.out.println("4");
		}
		
		for(Player play :getPlayerArray()) {
			//Check if the selected value is "Computer" and the difficulty settings are not displayed.
			//If the user goes from "Human" to "Computer" need to add the computer difficultly settings. 
			if((play.getPlayerConfig().playerType.getModel().getSelectedItem().equals("Computer")) && (play.getPlayerConfig().computerDifficulty.getParent() != play.getPlayerConfig())) {													
				
						play.getPlayerConfig().addComputerDifficulty();//Display difficulty settings for each player that this is true for
						repaint();//This repaint() eliminates some weird issue with the difficultly settings not appearing completely when computer is reselected.
			
		
			}	
			   
		}
		for(Player play :getPlayerArray()) {
			//Check if the selected value is "Human" and the difficulty settings are displayed as this is only needed when "Computer is selected"
			if((play.getPlayerConfig().playerType.getModel().getSelectedItem().equals("Human")) && (play.getPlayerConfig().computerDifficulty.getParent() == play.getPlayerConfig())) {													
				
						play.getPlayerConfig().removeComputerDifficulty();//Remove the difficulty settings;
						repaint();//This repaint() eliminates some weird issue with the difficultly settings not disappearing completely when human is reselected.
			
		
			}	
			   
		}
			
		
		add(startSimpleButton);
		add(startComplexButton);
		add(backButton);
	
		
		
	}

}
