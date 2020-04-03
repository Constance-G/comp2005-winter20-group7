package Game;

public class RicochetRobots implements Runnable{
	
	
	
	public static void main(String[] args) {
			
		Thread t1 = new Thread(new RicochetRobots());
		t1.run();
	}

	@Override
	public void run() {
		
		new GameBoard();
		
	}	
	
}
