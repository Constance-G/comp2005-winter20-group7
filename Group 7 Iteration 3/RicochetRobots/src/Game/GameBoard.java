package Game;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

public class GameBoard extends JFrame implements ActionListener {
	//

	private Boolean colorCheck = true; // true by defaultCan be modified at runtime in the SettingsPanel
	public int fontSize = 16; // default 16. Can be modified at runtime in the SettingsPanel
	static Dimension SCREENSIZE;//This is assigned live now in GameBoard() as we need the live screensize;
	private TokenBox insertBox;

	private Timer timer = new Timer(50, this);
	LaunchPanel launchPanel = new LaunchPanel();
	GamePanel gamePanel;//
	SettingsPanel settingsPanel = new SettingsPanel();
	PlayersSetup playersPanel = new PlayersSetup();// Instantiating this here makes it so player settings are preserved
													// when going back to LaunchPanel
	BettingPanel bettingPanel;
	ScorePanel scorePanel;
	JButton genBtn;
	

	GameBoard() {

		System.out.println("MainBoard.MainBoard()");

		int ScreenSize = (int)(Math.round((Toolkit.getDefaultToolkit().getScreenSize().height)*.81/100))*100; //This is the code to dynamically set screen size
		SCREENSIZE = new Dimension(ScreenSize, ScreenSize);
		
		setResizable(false); // Ensure size of program can't be changed on the fly by the user
		setVisible(true); // Jframe.isVisible() = false for new object

		// Setup launchPanel
		launchPanel.startButton.addActionListener(this);
		launchPanel.settingsButton.addActionListener(this);
		launchPanel.loadButton.addActionListener(this);
		launchPanel.exitButton.addActionListener(this);
		getContentPane().add(launchPanel);
		//

		timer.start();// Start the timer.This will call actionPerformed(ActionEvent e)
	}
	Robot[] initalState;
	
	@Override // Called by timer. Use to manage the state and logic of JPanels contained
				// within MainBoard
	
	public void actionPerformed(ActionEvent e) {

		
		// launchPanel logic

		// launchPanel.startButton logic
		// Code to handle when user presses startButton
		if (launchPanel != null && e.getSource().equals(launchPanel.startButton)) {

			playersPanel.jCombo.addActionListener(this);
			playersPanel.startSimpleButton.addActionListener(this);
			playersPanel.startComplexButton.addActionListener(this);
			playersPanel.backButton.addActionListener(this);
			for (Player play : playersPanel.getPlayerArray()) {// adding these so the difficultly button can be added
																// when "Computer" is selected
				play.getPlayerConfig().playerType.addActionListener(this);
			}
			getContentPane().remove(launchPanel);
			getContentPane().add(playersPanel);
		}
		// Code to handle when user presses loadButton
		if (launchPanel != null && e.getSource().equals(launchPanel.loadButton)) {
			// code to trigger loading
		}
		// Code to handle when user presses settingsButton
		if (launchPanel != null && e.getSource().equals(launchPanel.settingsButton)) {

			getContentPane().remove(launchPanel);
			getContentPane().add(settingsPanel);
			settingsPanel.backButton.addActionListener(this);
		}
		// Code to handle when user presses startButton
		if (launchPanel != null && e.getSource().equals(launchPanel.exitButton)) {
			System.exit(0);
		}
		// end launchPanel logic

		// SettingsPanel logic
		// Code to handle when user presses settings.backButton
		if (settingsPanel != null && e.getSource().equals(settingsPanel.backButton) && settingsPanel.isShowing()) {
			remove(settingsPanel);
			add(launchPanel);

			colorCheck = settingsPanel.getColorCheck();// Updates the default values with the updates ones from settings
			fontSize = settingsPanel.getFontSize();// Updates the default values with the updates ones from settings

		}
		// end SettingsPanel logic

		// PlayerSetup logic
		// Code to handle when user presses players.backButton
		if (playersPanel != null && e.getSource().equals(playersPanel.backButton)) {
			remove(playersPanel);

			add(launchPanel);
		}
		// Code to handle when user changes the value of players.jCombo
		if (playersPanel != null && e.getSource().equals(playersPanel.jCombo)) {
			playersPanel.update();
		}

		// Code to handle when user presses players.startSimpleButton
		if (playersPanel != null && e.getSource().equals(playersPanel.startSimpleButton)) {// if players is displayed
																							// and the user clicks the
																							// start simple button

			remove(playersPanel);
			playersPanel.assignPlayerNames();// Assign player names upon end of useful life of playersPanel
			gamePanel = new GamePanel("simple", playersPanel, colorCheck, fontSize);
			add(gamePanel);
			insertBox = new TokenBox(gamePanel); // ****** create token box
			add(insertBox.makeFrame(), BorderLayout.NORTH);
			insertBox.getGenBtn().addActionListener(this);
			scorePanel = new ScorePanel(gamePanel.players,gamePanel);
			add(scorePanel,BorderLayout.EAST);

		}

		// Code to handle when user presses players.startComplexButton
		if (playersPanel != null && e.getSource().equals(playersPanel.startComplexButton)) {// if players is displayed
																							// and the user clicks the
																							// start complex button

			remove(playersPanel);
			playersPanel.assignPlayerNames();// Assign player names upon end of useful life of playersPanel
			gamePanel = new GamePanel("complex", playersPanel, colorCheck, fontSize);
			add(gamePanel);
			insertBox = new TokenBox(gamePanel); // ****** create token box
			
			add(insertBox.makeFrame(), BorderLayout.NORTH);
			insertBox.getGenBtn().addActionListener(this);
			scorePanel = new ScorePanel(gamePanel.players,gamePanel);
			add(gamePanel,BorderLayout.EAST);

		}

		// This causes the difficultly settings to be added to playerSetup when
		// switching from human to computer
		if (e.getSource().equals(playersPanel.player2.getPlayerConfig().playerType)) {
			playersPanel.update();
		}
		if (e.getSource().equals(playersPanel.player3.getPlayerConfig().playerType)) {
			playersPanel.update();
		}
		if (e.getSource().equals(playersPanel.player4.getPlayerConfig().playerType)) {
			playersPanel.update();
		}

		// end PlayersSetup logic

		// GamePanel logic

		

		// Logic to start betting

		// Code to get the first turn started
		
		if (gamePanel != null && gamePanel.isBettingRound == false && gamePanel.isTurnRound == false) {
			//System.out.println(gamePanel.isBettingRound +"  "+gamePanel.isTurnRound);
			
				if (e.getSource().equals(insertBox.getGenBtn())) {// Code for genBtn
					System.out.println("System.");
					bettingPanel = new BettingPanel(gamePanel.players,
							Integer.parseInt(String.valueOf(playersPanel.jCombo.getSelectedItem())));
					insertBox.generateNewShape();
					insertBox.generateRandomNum();
					
					
					gamePanel.isBettingRound = true;
					bettingPanel.setPreferredSize(new Dimension(70, 150));
					System.out.println("Start betting");
					add(bettingPanel, BorderLayout.SOUTH);
					return;
				}
				
			

		}
		// Code to add the bettingPanel when isBettingRound is true;
		if (gamePanel != null && bettingPanel != null && gamePanel.isBettingRound == true
				&& !bettingPanel.isShowing()) {// Need to update isBettingRound to e.get(Generate

			// System.out.println("Betting Round: True");
			bettingPanel.setPreferredSize(new Dimension(70, 150));
			System.out.println("Start betting");
			add(bettingPanel, BorderLayout.SOUTH);
			
			return;
		}
		
		if(scorePanel != null) {
			
			if(gamePanel.playersTurn != null) {
				
			}
			scorePanel.update();
		}
		
		if(gamePanel != null) {
			repaint();
		}
		
		if(gamePanel != null && gamePanel.robotClicked != null) {
			
			Robot test = null;
			Point2D point = gamePanel.robotClicked.location;
			MapPiece[][] mapPieces = (MapPiece[][]) gamePanel.imageMap;
			for(MapPiece[] mapArray :mapPieces) {//Check Win
				for(MapPiece piece :mapArray) {
					
					if(point.equals(piece.point)) {
						
						scorePanel.robotClicked = gamePanel.robotClicked;
						
					
					}	
				}
			}
			
			
		}
		
		if(gamePanel != null && gamePanel.robotClicked == null) {
			scorePanel.robotClicked = null;
		}
		
		if(gamePanel != null && gamePanel.isTurnRound == true) {
			MapPiece[][] mapPieces = (MapPiece[][]) gamePanel.imageMap;
			for(MapPiece[] mapArray :mapPieces) {//Check Win
				for(MapPiece piece :mapArray) {
					
					if(piece.token != null&& piece.robotDisplayed != null) {
						//System.out.println("Checking Winner");
						if(piece.robotDisplayed.currentShape.equals(insertBox.getTokenShape())) {
							
							if(piece.token.tokenNum == insertBox.getTokenNumber()) {
								System.out.println("Winner!");
								gamePanel.playersTurn.tokens++;
								gamePanel.isTurnRound = false;
								gamePanel.isBettingRound = false;
								gamePanel.clickedMapPiece = null;
								gamePanel.robotClicked = null;
								gamePanel.playersTurn = null;

								return;
							}
						}
					}
				}
			}
		}
		
		// Logic for TurnRound being active
		if (gamePanel != null && bettingPanel != null && gamePanel.isTurnRound == true) {
			
			
			

			getContentPane().remove(bettingPanel);
			// List of the bets
			if (gamePanel.playersTurn == null) {// If its a turn round and no player is selected to move
				int[] bets = { Integer.parseInt(bettingPanel.amount_1.getText()), // List of the bets
						Integer.parseInt(bettingPanel.amount_2.getText()),
						Integer.parseInt(bettingPanel.amount_3.getText()),
						Integer.parseInt(bettingPanel.amount_4.getText()) };

				int snallestBet = 10000;
				for (int bet : bets) {
					if (bet < snallestBet && bet > 0) {
						snallestBet = bet;
					}
				}

				for (int i = 0; i < bets.length; i++) {

					if (bets[i] == snallestBet) {
						if (i == 0) {
							bettingPanel.amount_1.setText("-1");
						}
						if (i == 1) {
							bettingPanel.amount_2.setText("-1");
						}
						if (i == 2) {
							bettingPanel.amount_3.setText("-1");
						}
						if (i == 3) {
							bettingPanel.amount_4.setText("-1");
						}

						gamePanel.playersTurn = playersPanel.getPlayerArray()[i];
						gamePanel.playersTurn.bet = snallestBet;
						System.out.println(gamePanel.playersTurn.name + "'s turn");
						initalState = new Robot[4];
						initalState[0] = new Robot(gamePanel.robots[0]);
						initalState[1] = new Robot(gamePanel.robots[1]);
						initalState[2] = new Robot(gamePanel.robots[2]);
						initalState[3] = new Robot(gamePanel.robots[3]);
					
						return;
					}

				}

			}

			if (gamePanel.clickedMapPiece != null && gamePanel.robotClicked != null && gamePanel.playersTurn != null) {//

			
				
				
				
				MapPiece[][] mapPieces = (MapPiece[][]) gamePanel.imageMap;

				
				System.out.println("AttemptingMove");

				if ((!GamePanel.isLegalMovev2(mapPieces, gamePanel.robots, gamePanel.robotClicked,
						GamePanel.getDirection(gamePanel.robotClicked, gamePanel.clickedMapPiece)))) {
					gamePanel.clickedMapPiece = null;
					gamePanel.robotClicked = null;
					return;
				}

				gamePanel.robotClicked.location = GamePanel.attemptMove(mapPieces, gamePanel.robots,
						gamePanel.robotClicked,
						GamePanel.getDirection(gamePanel.robotClicked, gamePanel.clickedMapPiece));
				
				
				gamePanel.playersTurn.bet--;
				//System.out.println("InitalState");
				if (gamePanel.playersTurn.bet == 0) {
					
					for(MapPiece[] mapArray :mapPieces) {
						for(MapPiece piece :mapArray) {
							
							if(piece.token != null&& piece.robotDisplayed != null) {
								//System.out.println("Checking Winner");
								
								
								if(piece.robotDisplayed.currentShape.equals(insertBox.getTokenShape())) {
									
									if(piece.token.tokenNum == 17) {
										
										System.out.println("Winner!");
										gamePanel.playersTurn.tokens++;
										gamePanel.isTurnRound = false;
										gamePanel.isBettingRound = false;
										gamePanel.clickedMapPiece = null;
										gamePanel.robotClicked = null;
										gamePanel.playersTurn = null;
										gamePanel.waitingForTurn = true;
										return;
									}
									
									if(piece.token.tokenNum == insertBox.getTokenNumber()) {
										System.out.println("Winner!");
										gamePanel.playersTurn.tokens++;
										gamePanel.isTurnRound = false;
										gamePanel.isBettingRound = false;
										gamePanel.clickedMapPiece = null;
										gamePanel.robotClicked = null;
										gamePanel.playersTurn = null;

										gamePanel.waitingForTurn = true;
										return;
									}
								}
							}
						}
					}
					System.out.println("InitalState");
					gamePanel.robots = initalState;
					
	
					
					gamePanel.playersTurn.bet = -1;
					gamePanel.clickedMapPiece = null;
					gamePanel.robotClicked = null;
					gamePanel.playersTurn = null;
					return;
				}
				

				gamePanel.clickedMapPiece = null;
				gamePanel.robotClicked = null;
				System.out.println("AttemptingMove");
				return;
			}

			if (gamePanel.robotClicked == null && gamePanel.playersTurn != null) {
				gamePanel.clickedMapPiece = null;
			}

			if (gamePanel.robotClicked != null && gamePanel.playersTurn != null) {
				//System.out.println(gamePanel.robotClicked.location.toString());// Draw MoveHints (Directions robot can
																				// move)
			}
			if (gamePanel.robotClicked != null && gamePanel.clickedMapPiece != null && gamePanel.playersTurn != null) {
				System.out.println("RobotMove");
			}
			
			for(Player player : gamePanel.players) {
				
				if(player.bet != -1) {
					return;
				}else {
					
				}
				
			}
			gamePanel.waitingForTurn = true;
			gamePanel.isTurnRound = false;
			return;
		}
		

		if (bettingPanel != null && gamePanel.isTurnRound == false && bettingPanel.isAllSubmitted()&&gamePanel.isBettingRound == true) {// Checking if all
																										// 4 players
																										// have
																										// submitted to
																										// skip the
																										// timer
			System.out.println("Turn Round: Turn triggred by 4 submited");
			gamePanel.isTurnRound = true;
			gamePanel.isBettingRound = false;
		}

		if (bettingPanel != null && gamePanel.isTurnRound == false && bettingPanel.isDone&&gamePanel.isBettingRound == true) {// Turn triggered by lack of
																							// time
			System.out.println("Turn Round: Turn triggred by time out");
			gamePanel.isTurnRound = true;
			gamePanel.isBettingRound = false;
		}

		// end GamePanel logic
		// System.out.println("ImALive");

		pack(); // Calling this in a loop like fashion ensures GameBoard is always shaped as
				// intended

	}

}
