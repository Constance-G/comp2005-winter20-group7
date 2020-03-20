/**
 * The settings panel accessed via the main menu.  This will offer the ability to change the 
 * font size and the display color from full color to black and white.
 */

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


public class SettingsPanel extends JPanel implements ActionListener{

	public JButton backButton = new JButton("Back");
	private JButton applyButton = new JButton("Apply");
	private JLabel titleJLabel = new JLabel("Display Settings");
	private String[] colorChoices = {"Full Color", "Black & White"};
	private JComboBox colorOptionsBox = new JComboBox(colorChoices);
	private static Boolean colorCheck = true; //to track if the current setting is B&W (false) or color (true)
	private String[] fontSizes = {"Small", "Medium", "Large"};
	private JComboBox fontSizeBox = new JComboBox(fontSizes);
	private int fontSize = 16; //Had to Refactor to fontSize because font is a field in "Component" and JPanel is a child of Component
	private JLabel colorJLabel = new JLabel("Select Color Palette: ");
	private JLabel fontLabel = new JLabel("Select Font Size: ");
	private JLabel updateMsgLabel = new JLabel("Display settings updated!");
	
	
	public SettingsPanel()
	{
		setPreferredSize(new Dimension(300,400));
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		add(Box.createRigidArea(new Dimension(0, 20)));
		add(titleJLabel);
		add(Box.createVerticalGlue());
		
		add(colorJLabel);
		add(colorOptionsBox);
		colorOptionsBox.setMaximumSize(new Dimension(200,200));
		add(Box.createRigidArea(new Dimension(0, 20)));
		add(fontLabel);
		add(fontSizeBox);
		fontSizeBox.setMaximumSize(new Dimension(200,200));
		add(Box.createRigidArea(new Dimension(0, 50)));
		add(applyButton);
		applyButton.addActionListener(this);
		add(Box.createRigidArea(new Dimension(0, 10)));
		updateMsgLabel = new JLabel("Display Settings Updated!");
		add(updateMsgLabel);
		updateMsgLabel.setVisible(false);
		add(Box.createRigidArea(new Dimension(0, 20)));
		add(backButton);
		add(Box.createRigidArea(new Dimension(0, 20)));
		
		backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		colorJLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		colorOptionsBox.setAlignmentX(Component.CENTER_ALIGNMENT);
		fontLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		fontSizeBox.setAlignmentX(Component.CENTER_ALIGNMENT);
		applyButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		titleJLabel.setAlignmentX(Component.CENTER_ALIGNMENT);		
		updateMsgLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

	}
	
	//method to return if the setting is for full color (true) or BW (false)
	public Boolean getColorCheck() {
		return colorCheck;
	}

	//method to return the currently selected font size
	//"Small", "Medium", "Large"
	public int getFontSize() {
		return fontSize;
	}



	//method to convert the font to a numeric equivalent
	//returns the numeric font size
	public int updateFontSize()
	{				
		String x = fontSizeBox.getSelectedItem().toString(); 
			
		if (x == "Small") {
			fontSize = 12;
		}
				 
		else if (x.equals("Medium")) {
			fontSize = 16;
		}
		
		else {
			fontSize = 20;
		}
		
		return fontSize;
		
	}
	
	//method to display the label of successful or failure of updating settings
	//after the apply button is clicked.
	
	public void timedDisplay() {
		Timer timer = new Timer(3000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				updateMsgLabel.setVisible(false);
				
			}
		});
		timer.start();
	}
	
	public void actionPerformed(ActionEvent event)
	{
		if (event.getSource() == applyButton) {
			
			try {
				String temp = colorOptionsBox.getSelectedItem().toString();
				fontSize = updateFontSize();
					
				if (temp == "Full Color") {
					colorCheck = true;
				}
				else {
					colorCheck = false;
				}
				//display msg to user that settings have been updated
				updateMsgLabel.setVisible(true);
				timedDisplay();//call the timer to remove the msg after 3 seconds
			} 
			
			catch (Exception e) {
				updateMsgLabel.setText("Oops! Something went wrong.");
				updateMsgLabel.setVisible(true);
				timedDisplay();//call the timer to remove the msg after 3 seconds
			}
			
			
		}
	}
	

}
