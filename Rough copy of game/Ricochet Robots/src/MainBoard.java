import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class MainBoard extends JFrame implements ActionListener{
	

	Timer timer = new Timer(100, this);
	StartupPanel startupPanel = null;
	GamePanel gamePanel = null;
	SettingsPanel settings = null;
	PlayersPanel players = null;
	
	MainBoard(){
		
		System.out.println("MainBoard.MainBoard()");
		
		setResizable(false); //Ensure size of program can't be changed on the fly by the user
		setVisible(true); //Jframe.isVisible() = false for new object
		
		
		//Create and add a StartupPanel
		startupPanel = new StartupPanel();
		getContentPane().add(startupPanel);
		startupPanel.startButton.addActionListener(this);
		startupPanel.settingsButton.addActionListener(this);
		startupPanel.loadButton.addActionListener(this);
		startupPanel.exitButton.addActionListener(this);
		
		players = new PlayersPanel();
		
		
		
		
		timer.start();
	}
	

	

	@Override//Called by timer. Use to manage the state and logic of JPanels contained within MainBoard
	public void actionPerformed(ActionEvent e) {
		

		
		//startupPanel logic
		
		//startupPanel.startButton logic
		//Code to handle when user presses startButton
		if(startupPanel != null && e.getSource().equals(startupPanel.startButton)) {
			
			
			players.jCombo.addActionListener(this);
			players.startSimpleButton.addActionListener(this);
			players.startComplexButton.addActionListener(this);
			players.backButton.addActionListener(this);
			getContentPane().remove(startupPanel);
			getContentPane().add(players);
		}
		//Code to handle when user presses loadButton
		if(startupPanel != null && e.getSource().equals(startupPanel.loadButton)) {
			//code to trigger loading
		}
		//Code to handle when user presses settingsButton
		if(startupPanel != null &&e.getSource().equals(startupPanel.settingsButton)) {
			settings = new SettingsPanel();
			getContentPane().remove(startupPanel);
			getContentPane().add(settings);
			settings.backButton.addActionListener(this);
		}
		//Code to handle when user presses startButton
		if(startupPanel != null &&e.getSource().equals(startupPanel.exitButton)) {
			System.exit(0);
		}
		//end setupPanel logic
		
		
		//SettingsPanel logic
		//Code to handle when user presses settings.backButton
		if(settings != null && e.getSource().equals(settings.backButton)) {
			remove(settings);
			add(startupPanel);
		}
		//end SettingsPanel logic
		
		
		//PlayerPanel logic
		//Code to handle when user presses players.backButton
		if(players != null && e.getSource().equals(players.backButton)) {
			remove(players);
		
			add(startupPanel);
		}
		//Code to handle when user changes the value of players.jCombo
		if(players != null && e.getSource().equals(players.jCombo)) {
			players.update();
		}
		//Code to handle when user presses players.startSimpleButton
		if(players != null&& e.getSource().equals(players.startSimpleButton)) {//if players is displayed and the user clicks the start simple button
			
			remove(players);
			gamePanel = new GamePanel("simple",players);
			add(gamePanel);
			
		}
		//Code to handle when user presses players.startComplexButton
		if(players != null&& e.getSource().equals(players.startComplexButton)) {//if players is displayed and the user clicks the start complex button
			
			remove(players);
			gamePanel = new GamePanel("complex",players);
			add(gamePanel);
			
		}
		//end PlanersPanel logic
		repaint();
		pack(); 
		
	}
	
	
}
