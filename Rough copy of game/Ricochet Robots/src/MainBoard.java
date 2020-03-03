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
		
		
		
		startupPanel = new StartupPanel();
		getContentPane().add(startupPanel);
		startupPanel.startButton.addActionListener(this);
		startupPanel.settingsButton.addActionListener(this);
		startupPanel.loadButton.addActionListener(this);
		startupPanel.exitButton.addActionListener(this);
		
		players = new PlayersPanel();
		
		
		
		
		timer.start();
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
		
		return settings;
	}
	

	
	GamePanel newGamePanel(String config,PlayersPanel players){
		GamePanel gameP = new GamePanel(config,players);
		
		return gameP;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		

		
		//setupPanel logic
		
		//startupPanel.startButton logic
		if(startupPanel != null && e.getSource().equals(startupPanel.startButton)) {
			
			System.out.println("yeet");
			players.jCombo.addActionListener(this);
			players.startSimpleButton.addActionListener(this);
			players.startComplexButton.addActionListener(this);
			players.backButton.addActionListener(this);
			getContentPane().remove(startupPanel);
			getContentPane().add(players);
		}
		if(startupPanel != null && e.getSource().equals(startupPanel.loadButton)) {
			//code to trigger loading
		}
		
		if(startupPanel != null &&e.getSource().equals(startupPanel.settingsButton)) {
			settings = new SettingsPanel();
			getContentPane().remove(startupPanel);
			getContentPane().add(settings);
			settings.backButton.addActionListener(this);
		}
		
		if(startupPanel != null &&e.getSource().equals(startupPanel.exitButton)) {
			System.exit(0);
		}
		//
		
		//SettingsPanel logic
		
	//	if(settings != null && e.getSource().equals(settings.backButton)) {
		//	remove(settings);
		//	add(startupPanel);
		//}
		//
		
		//if(startupPanel != null && e.getSource().equals(startupPanel.startButton)) {
			
			
		
			
		//}
		//if(players != null && e.getSource().equals(players.backButton)) {
		//	remove(players);
		
		//	add(startupPanel);
		//}
		//if(players != null && e.getSource().equals(players.jCombo)) {
		//	players.update();
		//}
		
		//if(players != null&& e.getSource().equals(players.startSimpleButton)) {//if players is displayed and the user clicks the start simple button
			
		//	remove(players);
		//	gamePanel = newGamePanel("simple",players);
		//	add(gamePanel);
			
		//}
		//if(players != null&& e.getSource().equals(players.startComplexButton)) {//if players is displayed and the user clicks the start complex button
			
		//	remove(players);
		//	gamePanel = newGamePanel("complex",players);
		//	add(gamePanel);
			
		//}
		repaint();
		pack(); 
		
	}
	
	
}
