import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PlayersPanel extends JPanel{
	
	String[] players = {"2","3","4"};
	JComboBox<String> jCombo = new JComboBox<String>(players);
	JTextField nameLabel = new JTextField("Choose number of players: ");
	JButton startSimpleButton = new JButton("Start Simple");
	JButton startComplexButton = new JButton("Start Complex");
	JButton backButton = new JButton("Back");
	
	Player player1 = new Player();
	Player player2 = new Player();
	Player player3 = new Player();
	Player player4 = new Player();
	
	
	PlayersPanel(){
		
		setPreferredSize(new Dimension(400,600));
		nameLabel.setEditable(false);
		add(nameLabel);
		add(jCombo);	
		update();
	}
	
	Player[] getPlayerArray() {
		
		if(jCombo.getSelectedItem().equals("2")) {
			Player[] players = new Player[2];
			players[0] = player1;
			players[1] = player2;
			return players;
		}
		if(jCombo.getSelectedItem().equals("3")) {
			Player[] players = new Player[3];
			players[0] = player1;
			players[1] = player2;
			players[2] = player3;
			return players;
		}
		if(jCombo.getSelectedItem().equals("4")) {
			Player[] players = new Player[4];
			players[0] = player1;
			players[1] = player2;
			players[2] = player3;
			players[3] = player4;
			return players;
		}
		return null;
		
	}
	
	void update() {
		
		
		if(jCombo.getSelectedItem().equals("2")) {
			for(Component comp: getComponents()) {
				if(!comp.equals(jCombo)&& !comp.equals(nameLabel)) {
					remove(comp);
				}
			}
			add(player1.congif);
			add(player2.congif);
			System.out.println("2");
		}
		if(jCombo.getSelectedItem().equals("3")) {
			for(Component comp: getComponents()) {
				if(!comp.equals(jCombo)&& !comp.equals(nameLabel)) {
					remove(comp);
				}
			}
			add(player1.congif);
			add(player2.congif);
			add(player3.congif);
			System.out.println("3");
		}
		if(jCombo.getSelectedItem().equals("4")) {
			for(Component comp: getComponents()) {
				if(!comp.equals(jCombo)&& !comp.equals(nameLabel)) {
					remove(comp);
				}
			}
			add(player1.congif);
			add(player2.congif);
			add(player3.congif);
			add(player4.congif);
			System.out.println("4");
		}
		
		add(startSimpleButton);
		add(startComplexButton);
		add(backButton);
	}
		
	

}
