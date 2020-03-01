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
		
		timer.start();
		//Called last to ensure proper look
	}
	
	StartupPanel setUpGame(){
		
		StartupPanel startup = new StartupPanel(); //SetupPanel is displayed when the program starts by default 
		getContentPane().add(startup);
		startup.startButton.addActionListener(this);
		startup.settingsButton.addActionListener(this);
		startup.loadButton.addActionListener(this);
		startup.exitButton.addActionListener(this);
		return startup;
	}
	
	SettingsPanel openSettings() {
		
		SettingsPanel settings = new SettingsPanel();
		getContentPane().remove(startupPanel);
		getContentPane().add(settings);
		settings.backButton.addActionListener(this);
		return settings;
	}
	
	PlayersPanel newGame(){	
		
		getContentPane().remove(startupPanel);
		PlayersPanel players = new PlayersPanel();
		getContentPane().add(players);
		return players;
	}
	
	GamePanel newGamePanel(String config,PlayersPanel players){
		GamePanel gameP = new GamePanel(config,players);
		
		return gameP;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(startupPanel == null &&gamePanel == null ) {
			startupPanel = setUpGame();
		}
		
		//setupPanel logic
		if(e.getSource().equals(startupPanel.startButton)) {
			startupPanel.complete = true;
		}
		if(e.getSource().equals(startupPanel.loadButton)) {
			//code to trigger loading
		}
		
		if(e.getSource().equals(startupPanel.settingsButton)) {
			settings = openSettings();
		}
		if(e.getSource().equals(startupPanel.exitButton)) {
			System.exit(0);
		}
		//
		
		//SettingsPanel logic
		
		if(settings != null && e.getSource().equals(settings.backButton)) {
			remove(settings);
			add(startupPanel);
		}
		//
		
		if(startupPanel != null && startupPanel.complete == true && players == null) {
			
			players = newGame();
			players.jCombo.addActionListener(this);
			players.startSimpleButton.addActionListener(this);
			players.startComplexButton.addActionListener(this);
			
		}
		
		if(players != null && e.getSource().equals(players.jCombo)) {
			players.test();
		}
		
		if(players != null&& e.getSource().equals(players.startSimpleButton)) {
			
			remove(players);
			gamePanel = newGamePanel("simple",players);
			add(gamePanel);
			
		}
		if(players != null&& e.getSource().equals(players.startComplexButton)) {
			
			remove(players);
			gamePanel = newGamePanel("complex",players);
			add(gamePanel);
			
		}
		repaint();
		pack(); 
		
	}
	
	
}
