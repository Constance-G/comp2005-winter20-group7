import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Player {
	
	boolean isHuman;
	int tokens;
	PlayerConfig congif = null;
	PlayerBet bet = null;
	
	Player(){
		congif = new PlayerConfig();
	}
	
	PlayerBet getPlayerBet(Dimension size) {
		bet = new PlayerBet(size);
		return bet;

	}
	
	class PlayerBet extends JPanel{
		
		PlayerBet(Dimension size){
			
			setVisible(true);
			setPreferredSize(new Dimension(size.getSize().width,size.getSize().height/4));
			JButton button = new JButton("Test");
			add(button);
			System.out.println("test");
			
		}
		
	}
	
	
	class PlayerConfig extends JPanel{
		
		String[] players = {"Human","Computer"};
		JComboBox<String> jCombo = new JComboBox<String>(players);
		JTextField nameLabel = new JTextField("Player name: ");
		JTextField name = new PlayerName();
		
		
		
		PlayerConfig(){
			
			this.setLayout(new FlowLayout());
			
			nameLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
			name.setAlignmentY(Component.CENTER_ALIGNMENT);

			setPreferredSize(new Dimension(400,120));
			add(jCombo);
			
			nameLabel.setEditable(false);
			add(nameLabel);
			add(name);
		}
		
		class PlayerName extends JTextField{
			 
			PlayerName(){
				setColumns(10);
				
			}
		}
	}
}
