import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Player {//Maybe extend this into Human player and Computer Player
	

	
	int tokens;
	String name;
	PlayerConfig configDisplay = null;
	PlayerBet betDisplay = null;
	InGameDisplay gameDisplay = null;
	
	Player(){
		configDisplay = new PlayerConfig();
	}
	
	Player(boolean forceHuman){//This constructor is used for player 1 to make sure only human can be selected from the JComboBox
		//TODO: This could use a some refining
		configDisplay = new PlayerConfig(forceHuman);//Displays PlayerConfig with only "Human" available for selection
	}
	
	PlayerConfig getPlayerConfig() {
		return configDisplay;
		
	}
	
	PlayerBet getPlayerBet(Dimension size) {
		betDisplay = new PlayerBet(size);
		return betDisplay;

	}
	
	InGameDisplay getInGameDisplay(){
		
		return new InGameDisplay();
	}
	
	
	class InGameDisplay extends JPanel{
		
		
		
		InGameDisplay(){
	
			
		}
		
	}
	
	class PlayerBet extends JPanel{
		
		PlayerBet(Dimension size){
			
			setVisible(true);
			setPreferredSize(new Dimension(size.getSize().width,size.getSize().height/4));
			JButton button = new JButton("Test");
			add(button);
			//System.out.println("test");
			
		}
		
	}
	
	
	class PlayerConfig extends JPanel{
		
		String[] players = {"Human","Computer"};
		JComboBox<String> playerType = new JComboBox<String>(players);
		JTextField nameLabel = new JTextField("Player name: ");
		JTextField name = new PlayerName();
		String[] difficulty = {"Easy","Hard"};
		JComboBox<String> computerDifficulty= new JComboBox<String>(difficulty);
		
		

		
		PlayerConfig(){
			
			this.setLayout(new FlowLayout());
			
			nameLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
			name.setAlignmentY(Component.CENTER_ALIGNMENT);

			setPreferredSize(new Dimension(400,120));
			add(playerType);
			
			nameLabel.setEditable(false);
			add(nameLabel);
			add(name);
			
		}
		
		PlayerConfig(boolean forceHuman){//TODO: This could use a some refining
			
			//Used to force Human option
			players = new String[] {"Human"};
			playerType = new JComboBox<String>(players);
			//
			
			this.setLayout(new FlowLayout());
			
			nameLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
			name.setAlignmentY(Component.CENTER_ALIGNMENT);

			setPreferredSize(new Dimension(400,120));
			add(playerType);
			
			nameLabel.setEditable(false);
			add(nameLabel);
			add(name);
			
		}
		
		void addComputerDifficulty(){
			if(playerType.getModel().getSelectedItem().equals("Computer")) {
				computerDifficulty.setAlignmentY(Component.CENTER_ALIGNMENT);
				add(computerDifficulty);
			}
		}
		void removeComputerDifficulty(){
			if(playerType.getModel().getSelectedItem().equals("Human")) {
				
				remove(computerDifficulty);
			}
		}
		
		class PlayerName extends JTextField{//TODO:
			 
			PlayerName(){
				setColumns(10);
				
			}
		}
	}
}
