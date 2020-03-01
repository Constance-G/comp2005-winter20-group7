import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class SettingsPanel extends JPanel{

	boolean done = true;
	JButton backButton = new JButton("Back");
	
	SettingsPanel(){
		setPreferredSize(new Dimension(400,600));
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		add(Box.createVerticalGlue());
		add(backButton);
	}
	

}
