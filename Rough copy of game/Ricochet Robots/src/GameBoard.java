import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class GameBoard extends JFrame implements ActionListener{
	//

	Timer timer = new Timer(100, this);
	LaunchPanel launchPanel = new LaunchPanel();
	GamePanel gamePanel;
	DisplaySettings settingsPanel;
	public PlayersSetup playersPanel= new PlayersSetup();//Instantiating this here makes it so player settings are preserved when going back to LaunchPanel
	BettingPanel bettingPanel;
	
	GameBoard(){
		
		System.out.println("MainBoard.MainBoard()");
		
		setResizable(false); //Ensure size of program can't be changed on the fly by the user
		setVisible(true); //Jframe.isVisible() = false for new object
		
		
		
		
		//Setup launchPanel
		launchPanel.startButton.addActionListener(this);
		launchPanel.settingsButton.addActionListener(this);
		launchPanel.loadButton.addActionListener(this);
		launchPanel.exitButton.addActionListener(this);
		getContentPane().add(launchPanel);
		//
		
		timer.start();//Start the timer.This will call actionPerformed(ActionEvent e)
	}
	

	

	@Override//Called by timer. Use to manage the state and logic of JPanels contained within MainBoard
	public void actionPerformed(ActionEvent e) {
		

		
		//launchPanel logic
		
		//launchPanel.startButton logic
		//Code to handle when user presses startButton
		if(launchPanel != null && e.getSource().equals(launchPanel.startButton)) {
			
			
			playersPanel.jCombo.addActionListener(this);
			playersPanel.startSimpleButton.addActionListener(this);
			playersPanel.startComplexButton.addActionListener(this);
			playersPanel.backButton.addActionListener(this);
			getContentPane().remove(launchPanel);
			getContentPane().add(playersPanel);
		}
		//Code to handle when user presses loadButton
		if(launchPanel != null && e.getSource().equals(launchPanel.loadButton)) {
			//code to trigger loading
		}
		//Code to handle when user presses settingsButton
		if(launchPanel != null &&e.getSource().equals(launchPanel.settingsButton)) {
			settingsPanel = new DisplaySettings();
			getContentPane().remove(launchPanel);
			getContentPane().add(settingsPanel);
			settingsPanel.backButton.addActionListener(this);
		}
		//Code to handle when user presses startButton
		if(launchPanel != null &&e.getSource().equals(launchPanel.exitButton)) {
			System.exit(0);
		}
		//end launchPanel logic
		
		
		//SettingsPanel logic
		//Code to handle when user presses settings.backButton
		if(settingsPanel != null && e.getSource().equals(settingsPanel.backButton)) {
			remove(settingsPanel);
			add(launchPanel);
		}
		//end SettingsPanel logic
		
		
		//PlayerPanel logic
		//Code to handle when user presses players.backButton
		if(playersPanel != null && e.getSource().equals(playersPanel.backButton)) {
			remove(playersPanel);
		
			add(launchPanel);
		}
		//Code to handle when user changes the value of players.jCombo
		if(playersPanel != null && e.getSource().equals(playersPanel.jCombo)) {
			playersPanel.update();
		}
		
		
		
		//Code to handle when user presses players.startSimpleButton
		if(playersPanel != null&& e.getSource().equals(playersPanel.startSimpleButton)) {//if players is displayed and the user clicks the start simple button
			
			remove(playersPanel);
			gamePanel = new GamePanel("simple",playersPanel);
			add(gamePanel);
			
			
		}
		
		//Code to handle when user presses players.startComplexButton
		if(playersPanel != null&& e.getSource().equals(playersPanel.startComplexButton)) {//if players is displayed and the user clicks the start complex button
			
			remove(playersPanel);
			gamePanel = new GamePanel("complex",playersPanel);
			add(gamePanel);
			
		}
		//end PlanersPanel logic
		
		
		//GamePanel logic
		if(gamePanel != null && bettingPanel == null && gamePanel.isBettingRound == true) {
			bettingPanel = new BettingPanel(playersPanel.getPlayerArray());
			add(bettingPanel,BorderLayout.EAST);
		}
		if(gamePanel != null && bettingPanel != null && gamePanel.isBettingRound == true) {
			
		}
		
		//end GamePanel logic
		
		
		pack(); //Calling this in a loop like fashion ensures GameBoard is always shaped as intended
		
	}
	
	
}
