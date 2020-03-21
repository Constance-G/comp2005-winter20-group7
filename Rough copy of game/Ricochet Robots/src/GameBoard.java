import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class GameBoard extends JFrame implements ActionListener{
	//

	private Boolean colorCheck =  true; // true by defaultCan be modified at runtime in the SettingsPanel
	public int fontSize = 16; // default 16. Can be modified at runtime in the SettingsPanel
	static final Dimension SCREENSIZE = new Dimension(900,900);
	private TokenBox insertBox;
	
	private Timer timer = new Timer(100, this);
	LaunchPanel launchPanel = new LaunchPanel();
	GamePanel gamePanel;//
	SettingsPanel settingsPanel = new SettingsPanel();
	PlayersSetup playersPanel= new PlayersSetup();//Instantiating this here makes it so player settings are preserved when going back to LaunchPanel
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
			for(Player play :playersPanel.getPlayerArray()) {//adding these so the difficultly button can be added when "Computer" is selected
				play.getPlayerConfig().playerType.addActionListener(this);
			}
			getContentPane().remove(launchPanel);
			getContentPane().add(playersPanel);
		}
		//Code to handle when user presses loadButton
		if(launchPanel != null && e.getSource().equals(launchPanel.loadButton)) {
			//code to trigger loading
		}
		//Code to handle when user presses settingsButton
		if(launchPanel != null &&e.getSource().equals(launchPanel.settingsButton)) {
			
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
		if(settingsPanel != null && e.getSource().equals(settingsPanel.backButton)&& settingsPanel.isShowing()) {
			remove(settingsPanel);
			add(launchPanel);
			
			colorCheck = settingsPanel.getColorCheck();//Updates the default values with the updates ones from settings
			fontSize = settingsPanel.getFontSize();//Updates the default values with the updates ones from settings
			
		}
		//end SettingsPanel logic
		
		
		//PlayerSetup logic
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
			
			gamePanel = new GamePanel("simple",playersPanel,colorCheck,fontSize);
			add(gamePanel);
			insertBox = new TokenBox(); //****** create token box
			add(insertBox.makeFrame(), BorderLayout.NORTH);
			insertBox.getGenBtn().addActionListener(this);
		
			
			
			
		}
		
		//Code to handle when user presses players.startComplexButton
		if(playersPanel != null&& e.getSource().equals(playersPanel.startComplexButton)) {//if players is displayed and the user clicks the start complex button
			
			remove(playersPanel);
			gamePanel = new GamePanel("complex",playersPanel,colorCheck,fontSize);
			add(gamePanel);
			insertBox = new TokenBox(); //****** create token box
			add(insertBox.makeFrame(), BorderLayout.NORTH);
			insertBox.getGenBtn().addActionListener(this);
		
			
		}
		
		//This causes the difficultly settings to be added to playerSetup when switching from human to computer
		if(e.getSource().equals(playersPanel.player2.getPlayerConfig().playerType)) {
			playersPanel.update();
		}
		if(e.getSource().equals(playersPanel.player3.getPlayerConfig().playerType)) {
			playersPanel.update();
		}
		if(e.getSource().equals(playersPanel.player4.getPlayerConfig().playerType)) {
			playersPanel.update();
		}
		
		//end PlayersSetup logic


		//GamePanel logic

		//Logic to start betting

		//Code to get the first turn started
		if(gamePanel != null &&  gamePanel.isBettingRound == false && gamePanel.isTurnRound == false) {



			if(e.getSource().equals(insertBox.getGenBtn())) {

				bettingPanel = new BettingPanel(gamePanel.players);
				gamePanel.isBettingRound = true;
			}


			//Logic to pick starting Player NOTE: Only works with 4 players right now
			for(Player player: gamePanel.players) {

			}

		}

		if(gamePanel != null && bettingPanel != null && gamePanel.isBettingRound == true/* e.getSource().equals(gamePanel.generate)*/) {//Need to update isBettingRound to e.get(Generate

			//System.out.println("Betting Round: True");
			bettingPanel.setPreferredSize(new Dimension(70,150));
			add(bettingPanel,BorderLayout.SOUTH);

		}

		if(gamePanel != null && bettingPanel != null && gamePanel.isTurnRound == true && bettingPanel.isShowing()) {

			System.out.println("Turn Round: True");
			gamePanel.isBettingRound = false;
			remove(bettingPanel);
			if(gamePanel.robotClicked != null) {

			}
		}

		//Code for insertBox.genBtn





		//end GamePanel logic




		pack(); //Calling this in a loop like fashion ensures GameBoard is always shaped as intended

	}


}
