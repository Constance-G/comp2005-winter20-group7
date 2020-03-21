import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


class BettingPanel extends JPanel implements ActionListener {
	

	Dimension size;
    JTextField amount_1 = new JTextField("0");       
    JTextField amount_2 = new JTextField("0");
    JTextField amount_3 = new JTextField("0");
    JTextField amount_4 = new JTextField("0");
    
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
    
    // Third Player
    JButton butt_7 = new JButton("-");
    JButton butt_8 = new JButton("+");
    JButton butt_9 = new JButton("Submit");
    
    //Fourth Player
    JButton butt_10 = new JButton("-");
    JButton butt_11 = new JButton("+");
    JButton butt_12 = new JButton("Submit");

    
    private int first_amount;
    private int second_amount;
    private int third_amount;
    private int fourth_amount;
    

	//Buttons
	

	
	//Displays time
	String countdown=displayTimer(60);
	JLabel time=new JLabel(countdown);
	
	//Shows up when 60 seconds is over
	JLabel timeup=new JLabel(); 
	JLabel timer_label=new JLabel("Timer");
	JLabel empty=new JLabel(" ");
	JLabel emptySpace=new JLabel(" ");
	
	
    //Ensures timer can be started only once
	
	int count=0;
	
	//Ensures that any player can be the first player to bid and start timer
	
	boolean firstBid=false;

	//Timer initialization
	public Timer myTimer;
	
	//Color
	
	public static Color myGrey=new Color(128,128,128);
	

	
	
		BettingPanel(Player[] players){

			setLayout(new GridLayout(5,1));
			setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			
			setVisible(true);
		//	addPlayers(players);
	        add(timer_label);
		    add(time);
		    add(timeup);
		    add(empty);
		    add(emptySpace);
		    setBackground(myGrey);
		    
			    add(label_1);
		        add(butt_1);
		        add(amount_1);
		        add(butt_2);
		        add(butt_3);
		                        
		        add(label_2);
		        add(butt_4);
		        add(amount_2);
		        add(butt_5);
		        add(butt_6);
		        
		        add(label_3);
		        add(butt_7);
		        add(amount_3);
		        add(butt_8);
		        add(butt_9);
		        
		        add(label_4);
		        add(butt_10);
		        add(amount_4);
		        add(butt_11);
		        add(butt_12);
		        

	    
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
		        System.out.println("Here");
		        

		    //This controls the timer aspect, ensures anybody can be the first to bid    
		        butt_3.addActionListener(this);
		        butt_6.addActionListener(this);
		        butt_9.addActionListener(this);
		        butt_12.addActionListener(this);
		        
		
		}
		
		
		
		private String displayTimer(int cTime) {
			final int min=cTime/60;
			final int sec=cTime-(min*60);
			
			final String strMin=displayZero(min);
			final String strSec=displayZero(sec);
			
			return String.format("%s:%s", strMin,strSec);
		}

		
		private String displayZero(int number) {
			return(number>=10)?Integer.toString(number):String.format("0%s", Integer.toString(number));
		}
		
		public void actionPerformed(ActionEvent event)
		
		{
	
			
			Object click=event.getSource();
			
			if (click.equals(butt_3)||click.equals(butt_6)||click.equals(butt_9)||click.equals(butt_12)) {
	            
	            
				 if(!firstBid) {
			    // Count ensures start button can only be pressed once
				//Otherwise multiple timers start simultaneously when pressed more than once
				 count++;
		
				 if(count==0||count==1) {  
					  
				      int delay = 1000; //initial delay in milliseconds
				
				     ActionListener taskPerformer = new ActionListener() {
					     int passedTime=60;
					  
				        public void actionPerformed(ActionEvent evt) {
				    	    time.setText(displayTimer(passedTime));
							passedTime--;
							
							if(passedTime==-1) {
							
							    myTimer.stop();
								timeup.setText("Time Over!");
								time.setText(displayTimer(60));
							
							}
							
							else if(passedTime==10) {
								timeup.setText("10s left");
								
							}
							else if(passedTime==9) {
								timeup.setText(" ");
							}
						
				      }
				      
				  };
				  myTimer=new Timer(delay, taskPerformer);
				  myTimer.start();
				 
			

					} 
			    }
				   
			  }
			
//Ensures any player can make the first bid and first bid starts timer
			 if(!firstBid) {
				 firstBid=true;
			 }
			 
			
		
			

			
		} 
		
	
		
	/**	void addPlayers(Player[] players){
			
			for(Player play : players){
				
				add(play.getPlayerBet(getPreferredSize()));
			}
		} **/
	
}
