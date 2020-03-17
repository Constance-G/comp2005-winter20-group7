// I still need to finish the check for only digit input and no alphabet.
// Increase the reuseability of the code. 


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

class test{
           
    JTextField amount_1 = new JTextField(3);       
    JTextField amount_2 = new JTextField(3);
    JTextField amount_3 = new JTextField(3);
    JTextField amount_4 = new JTextField(3);
    
    String player_name_1 = "Simran";
    String player_name_2 = "Constance";
    String player_name_3 = "Josh";
    String player_name_4 = "Solomon";
    
    JLabel label_1 = new JLabel(player_name_1);
    JLabel label_2 = new JLabel(player_name_2);
    JLabel label_3 = new JLabel(player_name_3);
    JLabel label_4 = new JLabel(player_name_4);
    
    // First Player
    JButton butt_1 = new JButton("-");
    JButton butt_2 = new JButton("+");
    JButton butt_3 = new JButton("Submit");
    
    // Second Player
    JButton butt_4 = new JButton("-");
    JButton butt_5 = new JButton("+");
    JButton butt_6 = new JButton("Submit");
    
    // Third Palyer
    JButton butt_7 = new JButton("-");
    JButton butt_8 = new JButton("+");
    JButton butt_9 = new JButton("Submit");
    
    //Fourth Player
    JButton butt_10 = new JButton("-");
    JButton butt_11 = new JButton("+");
    JButton butt_12 = new JButton("Submit");
    
    JPanel pan_1  = new JPanel(); // whole panel
    JPanel pan_2  = new JPanel(); // first player panel
    JPanel pan_3  = new JPanel(); // second player panel
    JPanel pan_4  = new JPanel(); // third player panel
    JPanel pan_5  = new JPanel(); // fourth player panel
    
    private int first_amount;
    private int second_amount;
    private int third_amount;
    private int fourth_amount;
    
   
    public void main(){
        JFrame frame = new JFrame("Betting Panel");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setSize(500, 200);
                
        pan_1.setLayout(new GridLayout (4, 1, 80, 10));
        pan_1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
                
        pan_2.setLayout(new GridLayout (1, 5, 10, 10));
        pan_2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        
        pan_3.setLayout(new GridLayout (1, 5, 10, 10));
        pan_3.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        
        pan_4.setLayout(new GridLayout (1, 5, 10, 10));
        pan_4.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        
        pan_5.setLayout(new GridLayout (1, 5, 10, 10));
        pan_5.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
                                      
        // First player Minus
        butt_1.addActionListener(e -> {                        
            int first_value = Integer.parseInt(amount_1.getText());           
            first_value = first_value - 1;            
            amount_1.setText( String.valueOf(first_value));            
            first_amount = first_value;                        
        });
        
        // First player Plus
        butt_2.addActionListener(e -> {            
            int first_value = Integer.parseInt(amount_1.getText()); // change amount to respective amount_2,3 and so on
            first_value = first_value + 1;            
            amount_1.setText(String.valueOf(first_value));            
            first_amount = first_value;
        });
        
        // First player Submit
        butt_3.addActionListener(e -> {
            int first_value = Integer.parseInt(amount_1.getText());
            first_amount = first_value;
            System.out.println( "First player : " + first_amount + " steps.");            
            amount_1.setEditable(false);
            butt_1.setEnabled(false);
            butt_2.setEnabled(false);
        });
        
        // Second player Minus
        butt_4.addActionListener(e -> {
            int second_value = Integer.parseInt(amount_2.getText()); // change amount to respective amount_2,3 and so on            
            second_value = second_value - 1;            
            amount_2.setText(String.valueOf(second_value));// change amount to respective amount_2,3 and so on
            second_amount = second_value;            
        });
        
        // Second player Plus
        butt_5.addActionListener(e -> {
            int second_value = Integer.parseInt(amount_2.getText()); 
            second_value = second_value + 1;            
            amount_2.setText(String.valueOf(second_value));
            second_amount = second_value;
        });
        
        // Second player Submit
        butt_6.addActionListener(e -> {
            int second_value = Integer.parseInt(amount_2.getText());
            second_amount = second_value;
            System.out.println("Second player: " + second_amount + " steps.");
            amount_2.setEditable(false);
            butt_4.setEnabled(false);
            butt_5.setEnabled(false);
        });
        
        // Third player Minus
        butt_7.addActionListener(e -> {
            int third_value = Integer.parseInt(amount_3.getText());            
            third_value = third_value - 1;            
            amount_3.setText(String.valueOf(third_value));
            third_amount = third_value;
        });
        
        // Third player Plus
        butt_8.addActionListener(e -> {
            int third_value = Integer.parseInt(amount_3.getText());             
            third_value = third_value + 1;            
            amount_3.setText(String.valueOf(third_value));
            third_amount = third_value;
        });
        
        // Third player Submit
        butt_9.addActionListener(e -> {
            int third_value = Integer.parseInt(amount_3.getText());
            third_amount = third_value;
            System.out.println("Third player: " + third_amount + " steps.");
            amount_3.setEditable(false);
            butt_7.setEnabled(false);
            butt_8.setEnabled(false);
        });
        
        // Fourth player Minus
        butt_10.addActionListener(e -> {
            int fourth_value = Integer.parseInt(amount_4.getText());            
            fourth_value = fourth_value - 1;            
            amount_4.setText(String.valueOf(fourth_value));
            fourth_amount = fourth_value; 
        });
        
        // Fourth player Plus
        butt_11.addActionListener(e -> {
            int fourth_value = Integer.parseInt(amount_4.getText());            
            fourth_value = fourth_value + 1;            
            amount_4.setText(String.valueOf(fourth_value));
            fourth_amount = fourth_value; 
        });
        
        // Fourth Player Submit
        butt_12.addActionListener(e -> {
            int fourth_value = Integer.parseInt(amount_4.getText());
            fourth_amount = fourth_value;
            System.out.println("Fourth player: " + fourth_amount + " steps.");
            amount_4.setEditable(false);
            butt_10.setEnabled(false);
            butt_11.setEnabled(false);
        });
        
        pan_2.add(label_1);
        pan_2.add(butt_1);
        pan_2.add(amount_1);
        pan_2.add(butt_2);
        pan_2.add(butt_3);
                        
        pan_3.add(label_2);
        pan_3.add(butt_4);
        pan_3.add(amount_2);
        pan_3.add(butt_5);
        pan_3.add(butt_6);
        
        pan_4.add(label_3);
        pan_4.add(butt_7);
        pan_4.add(amount_3);
        pan_4.add(butt_8);
        pan_4.add(butt_9);
        
        pan_5.add(label_4);
        pan_5.add(butt_10);
        pan_5.add(amount_4);
        pan_5.add(butt_11);
        pan_5.add(butt_12);
        
        pan_1.add(pan_2);
        pan_1.add(pan_3);
        pan_1.add(pan_4);
        pan_1.add(pan_5);
                        
        frame.add(pan_1);
    }
}
