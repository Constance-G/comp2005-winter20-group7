/**
 * The settings panel accessed via the main menu.  This will offer the ability to change the 
 * font size and the display color from full color to black and white.
 */

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.xml.transform.Templates;

public class SettingsPanel extends JPanel implements ActionListener{

	private boolean done = true;
	public JButton backButton = new JButton("Back");
	private JButton applyButton = new JButton("Apply");
	private JLabel titleJLabel = new JLabel("Display Settings");
	private String[] colorChoices = {"Full Color", "Black & White"};
	private JComboBox colorOptionsBox = new JComboBox(colorChoices);
	private Boolean colorCheck = true; //to track if the current setting is B&W (false) or color (true)
	private String[] fontSizes = {"Small", "Medium", "Large"};
	private JComboBox fontSizeBox = new JComboBox(fontSizes);
	private int font = 16;
	private JLabel colorJLabel = new JLabel("Select Color Palette: ");
	private JLabel fontLabel = new JLabel("Select Font Size: ");
	
	
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

	}
	
	//method to convert the font to a numeric equivalent
	//returns the numeric font size
	public int updateFontSize()
	{
		String x = fontSizeBox.getSelectedItem().toString();
		
		if (x == "small") {
			font = 12;
		}
		
		else if (x == "medium") {
			font = 16;
		}
		
		else {
			font = 20;
		}
		
		return font;
		
	}
	
	public void actionPerformed(ActionEvent event)
	{
		if (event.getSource() == applyButton) {
			String temp = colorOptionsBox.getSelectedItem().toString();
			font = updateFontSize();
			if (temp == "Full Color") {
				colorCheck = true;
			}
			else {
				colorCheck = false;
			}
		}
	}
	//TODO send colorCheck and font values when the back button is selected
	

}
