package Game;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import java.awt.Color;

class ScorePanel extends JPanel {

	JTable j;
	private JLabel board_label;
	private JLabel turn;
	private JLabel winner;
	private Color myGrey = new Color(128, 128, 128); // used same color as the bettingPanel so that it blends perfectly
	String[][] data;
	Player[] play;
	GamePanel gamePanel;
	
	// Constructor
	ScorePanel(Player[] playIn,GamePanel gp)

	{

		gamePanel = gp;
		play = playIn;
		setVisible(true);
		setPreferredSize(new Dimension(150, 100));
		setLayout(new GridLayout(3, 1));
		setBackground(myGrey);
		board_label = new JLabel("Scoreboard");
		turn = new JLabel(""); // TODO Need to add code so that it displays which player's turn it is
		winner = new JLabel(" "); // TODO Need to add code so that it displays which player is the winner
		// Data to be displayed in the JTable
		String[][] data1 = { { play[0].name, String.valueOf(play[0].tokens) }, {  play[1].name, String.valueOf(play[0].tokens) }, {  play[2].name, String.valueOf(play[0].tokens) }, {  play[3].name, String.valueOf(play[0].tokens) } };

		data = data1.clone();
		// Column Names
		String[] columnNames = { "Player", "Score" };

		// Initializing the JTable
		j = new JTable(data, columnNames);
		j.setBounds(300, 200, 10, 10);

		// adding it to JScrollPane

		JScrollPane sp = new JScrollPane(j);

		add(sp);
		add(turn); // added turn and winner but they are correctly empty
		add(winner);

	}
	void update() {
		remove(j);
		String[] columnNames = { "Player", "Score" };
		String[][] data1 = { { play[0].name, String.valueOf(play[0].tokens) }, {  play[1].name, String.valueOf(play[0].tokens) }, {  play[2].name, String.valueOf(play[0].tokens) }, {  play[3].name, String.valueOf(play[0].tokens) } };
		data = data1.clone();
		TableModel newModel = j.getModel();
		for(int i = 0; i <newModel.getRowCount() ;i++) {
			for(int k = 0; k <newModel.getColumnCount() ;k++) {
				//System.out.println("I: "+i+" k: "+ k);
				j.getModel().getValueAt(i, k);
				newModel.setValueAt(j.getModel().getValueAt(i, k), i, k);
			}
		}
		newModel.setValueAt(String.valueOf(play[0].tokens), 0, 1);
		newModel.setValueAt(String.valueOf(play[1].tokens), 1, 1);
		newModel.setValueAt(String.valueOf(play[2].tokens), 2, 1);
		newModel.setValueAt(String.valueOf(play[3].tokens), 3, 1);
		
		if(gamePanel.playersTurn != null) {
			turn.setText(gamePanel.playersTurn.name+"'s Turn:");
		}else {
			turn.setText("");
		}
		
		j.setModel(newModel);
		
	}
}
