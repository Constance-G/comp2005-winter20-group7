import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class LaunchPanel extends JPanel{

	JButton startButton = new JButton("New Game");
	JButton loadButton = new JButton("Load Game");
	JButton settingsButton = new JButton("Settings");
	JButton exitButton = new JButton("Exit");
	
	
	public boolean complete = false;

	LaunchPanel(){
		
		setPreferredSize(new Dimension(400,400));
		
		startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		loadButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		settingsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		add(Box.createVerticalGlue());
		add(startButton);
		add(Box.createVerticalGlue());
		add(loadButton);
		add(Box.createVerticalGlue());
		add(settingsButton);
		add(Box.createVerticalGlue());
		add(exitButton);
		add(Box.createVerticalGlue());
	
	}


}
