import java.awt.Dimension;
import javax.swing.JPanel;

class BettingPanel extends JPanel{
		
	Dimension size;
	
		BettingPanel(Player[] players){
			size = GameBoard.SCREENSIZE;
			setPreferredSize(new Dimension(size.width-(size.width/20)*16,size.height));
			setVisible(true);
			addPlayers(players);
		}
		
		void addPlayers(Player[] players){
			
			for(Player play : players){
				
				add(play.getPlayerBet(getPreferredSize()));
			}
		}
}
