package Game;

/*
 * This class and its nested classes are the recordings of the 4 simple and 4 complex game maps provided
 */


abstract class MapPanel{ 

	

		String[][] map =  {{"reg","reg","reg","reg","reg","reg","reg","reg"},
				{"reg","reg","reg","reg","reg","reg","reg","reg"},
				{"reg","reg","reg","reg","reg","reg","reg","reg"},
				{"reg","reg","reg","reg","reg","reg","reg","reg",},
				{"reg","reg","reg","reg","reg","reg","reg","reg",},
				{"reg","reg","reg","reg","reg","reg","reg","reg",},
				{"reg","reg","reg","reg","reg","reg","reg","reg",},
				{"reg","reg","reg","reg","reg","reg","reg","reg",}};

		MapPanel(){

		}	

		abstract String[][] getMap();

		abstract void setMap(String[][] newMap);

		abstract void setPanelLocation(int a);


		abstract int getPanelNum();

		abstract int getPanelLocation();


	}

	class SimplePanel1 extends MapPanel{//This is board 1A

		//By default, each panel is stored like 1A in simple.png, in the equivalent Cartesian quadrant 2.

		public int panelNum = 1;
		public int panelLocation = 2;//in Quadrants

		SimplePanel1(){
			super();

		}

		int SIZE = 8;

		//This an 8x8 Matrix used to store the board.
		//Note: This Matrix looks transposed compared to the drawn boards. This is intended. The first row is actually the first column to be drawn.
		//To access a piece, call map[i][j] where i is in the positive x direction
		//and j is in the negative y value. (map[0][0] = "reg" , map[7][7] = "1")

		String[][] map = {{"reg","reg","reg","reg","reg","bottomWall","reg","reg"},//Column 1
						{"reg","reg","1l,1","reg","reg","reg","reg","reg"},
						{"leftWall","reg","reg","reg","reg","reg","reg","reg"},
						{"reg","reg","reg","reg","reg","reg","3l,2","reg",},
						{"reg","2l,3","reg","reg","reg","reg","reg","reg",},
						{"reg","reg","reg","reg","reg","reg","reg","reg",},
						{"reg","reg","reg","4l,4","reg","reg","reg","reg",},
						{"reg","reg","reg","reg","reg","reg","reg","1",}};//Column 8

		@Override
		String[][] getMap(){
			return map;

		}
		@Override
		int getPanelNum() {
			return panelNum;

		}

		@Override
		void setMap(String[][] newMap) {
			map = newMap;

		}
		@Override
		int getPanelLocation() {
			return panelLocation;
		}
		@Override
		void setPanelLocation(int a) {

			panelLocation = a;
		}

	}

	class SimplePanel2 extends MapPanel{

		//By default, each panel is stored like 1A in simple.png, in the equivalent Cartesian quadrant 2.
		
		int panelNum = 2;
		public int panelLocation = 2;//in Quadrants

		SimplePanel2(){
			super();
		}
		//This an 8x8 Matrix used to store the board.
		//Note: This Matrix looks transposed compared to the drawn boards. This is intended. The first row is actually the first column to be drawn.
		//To access a piece, call map[i][j] where i is in the positive x direction
		//and j is in the negative y value. (map[0][0] = "reg" , map[7][7] = "2")
	
		String[][] map = {{"reg","reg","reg","bottomWall","reg","reg","reg","reg"},//Column 1
						{"reg","reg","3l,5","reg","reg","reg","reg","reg"},
						{"reg","reg","reg","reg","reg","reg","1l,6","reg"},
						{"reg","reg","reg","reg","reg","reg","reg","reg",},
						{"leftWall","reg","reg","reg","reg","reg","reg","reg",},
						{"reg","4l,7","reg","reg","reg","reg","reg","reg",},
						{"reg","reg","reg","reg","2l,8","reg","reg","reg",},
						{"reg","reg","reg","reg","reg","reg","reg","2",}};//Column 8

		@Override
		String[][] getMap(){
			return map;

		}
		@Override
		int getPanelNum() {
			return panelNum;

		}

		@Override
		void setMap(String[][] newMap) {
			map = newMap;

		}
		@Override
		int getPanelLocation() {

			return panelLocation;
		}
		@Override
		void setPanelLocation(int a) {

			panelLocation = a;		
		}

	}

	class SimplePanel3 extends MapPanel{
		
		//By default, each panel is stored like 1A in simple.png, in the equivalent Cartesian quadrant 2.

		int panelNum = 3;
		public int panelLocation = 2;//in Quadrants

		SimplePanel3(){
			super();
		}

		//This an 8x8 Matrix used to store the board.
		//Note: This Matrix looks transposed compared to the drawn boards. This is intended. The first row is actually the first column to be drawn.
		//To access a piece, call map[i][j] where i is in the positive x direction
		//and j is in the negative y value. (map[0][0] = "reg" , map[7][7] = "3")

		String[][] map = {{"reg","reg","reg","reg","bottomWall","reg","reg","reg"},//Column 1
						{"reg","reg","reg","reg","reg","reg","2l,9","reg"},
						{"reg","reg","reg","reg","1l,10","reg","reg","reg"},
						{"reg","reg","reg","reg","reg","reg","reg","reg",},
						{"leftWall","reg","reg","reg","reg","reg","reg","reg",},
						{"reg","reg","4l,11","reg","reg","reg","reg","reg",},
						{"reg","reg","reg","reg","reg","reg","reg","reg",},
						{"reg","reg","reg","reg","reg","3l,12","reg","3",}};//Column 8
		@Override
		String[][] getMap(){
			return map;

		}
		@Override
		int getPanelNum() {
			return panelNum;

		}

		@Override
		void setMap(String[][] newMap) {
			map = newMap;

		}
		@Override
		int getPanelLocation() {

			return panelLocation;
		}

		@Override
		void setPanelLocation(int a) {

			panelLocation = a;
		}
	}

	class SimplePanel4 extends MapPanel{
		
		//By default, each panel is stored like 1A in simple.png, in the equivalent Cartesian quadrant 2.

		int panelNum = 4;
		public int panelLocation = 2;//in Quadrants

		SimplePanel4(){
			super();
		}

		//This an 8x8 Matrix used to store the board.
		//Note: This Matrix looks transposed compared to the drawn boards. This is intended. The first row is actually the first column to be drawn.
		//To access a piece, call map[i][j] where i is in the positive x direction
		//and j is in the negative y value. (map[0][0] = "reg" , map[7][7] = "4")
		

		String[][] map = {{"reg","reg","reg","reg","reg","reg","bottomWall","reg"},//Column 1
						{"reg","reg","reg","1l,13","reg","reg","reg","reg"},
						{"reg","reg","reg","reg","reg","4l,14","reg","reg"},
						{"reg","reg","reg","reg","reg","reg","reg","reg",},
						{"leftWall","reg","reg","reg","reg","reg","reg","reg",},
						{"reg","reg","reg","reg","2l,15","reg","reg","reg",},
						{"reg","3l,16","reg","reg","reg","reg","reg","reg",},
						{"reg","reg","reg","reg","reg","4l,17","reg","4",}};//Column 8
		@Override
		String[][] getMap(){
			return map;

		}
		@Override
		int getPanelNum() {
			return panelNum;

		}

		@Override
		void setMap(String[][] newMap) {
			map = newMap;

		}
		@Override
		int getPanelLocation() {

			return panelLocation;
		}

		@Override
		void setPanelLocation(int a) {

			panelLocation = a;
		}
	}

	class ComplexPanel1 extends MapPanel{
		
		//By default, each panel is stored like 1A in simple.png, in the equivalent Cartesian quadrant 2.

				public int panelNum = 5;
				public int panelLocation = 2;//in Quadrants

				ComplexPanel1(){
					super();

				}

				int SIZE = 8;

				//This an 8x8 Matrix used to store the board.
				//Note: This Matrix looks transposed compared to the drawn boards. This is intended. The first row is actually the first column to be drawn.
				//To access a piece, call map[i][j] where i is in the positive x direction
				//and j is in the negative y value. (map[0][0] = "reg" , map[7][7] = "1")

				String[][] map = {{"reg","reg","reg","reg","reg","bottomWall","reg","reg"},//Column 1
								{"reg","reg","reg","2l,1","reg","reg","reg","reg"},
								{"reg","reg","reg","reg","reg","reg","1l,2","reg"},
								{"reg","reg","reg","reg","reg","reg","3l,3","reg",},
								{"reg","g13","reg","reg","reg","reg","reg","reg",},
								{"reg","reg","reg","reg","reg","reg","reg","y24",},
								{"leftWall","reg","reg","reg","4l,4","reg","reg","reg",},
								{"reg","reg","reg","reg","reg","reg","reg","1D",}};//Column 8

				@Override
				String[][] getMap(){
					return map;

				}
				@Override
				int getPanelNum() {
					return panelNum;

				}

				@Override
				void setMap(String[][] newMap) {
					map = newMap;

				}
				@Override
				int getPanelLocation() {
					return panelLocation;
				}
				@Override
				void setPanelLocation(int a) {

					panelLocation = a;
				}
	}
	
	class ComplexPanel2 extends MapPanel{

		//By default, each panel is stored like 1A in simple.png, in the equivalent Cartesian quadrant 2.

		public int panelNum = 6;
		public int panelLocation = 2;//in Quadrants

		ComplexPanel2(){
			super();

		}

		int SIZE = 8;

		//This an 8x8 Matrix used to store the board.
		//Note: This Matrix looks transposed compared to the drawn boards. This is intended. The first row is actually the first column to be drawn.
		//To access a piece, call map[i][j] where i is in the positive x direction
		//and j is in the negative y value. (map[0][0] = "reg" , map[7][7] = "1")

		String[][] map = {{"reg","reg","reg","reg","reg","reg","bottomWall","reg"},//Column 1
						{"reg","reg","reg","reg","reg","3l,5","reg","reg"},
						{"reg","b13","reg","reg","reg","reg","reg","reg"},
						{"leftWall","reg","reg","reg","reg","reg","reg","reg",},
						{"reg","reg","reg","reg","reg","reg","reg","1l,6",},
						{"reg","reg","4l,7","reg","reg","reg","reg","reg",},
						{"reg","reg","2l,8","reg","reg","reg","reg","reg",},
						{"reg","reg","reg","reg","r24","reg","reg","2D",}};//Column 8

		@Override
		String[][] getMap(){
			return map;

		}
		@Override
		int getPanelNum() {
			return panelNum;

		}

		@Override
		void setMap(String[][] newMap) {
			map = newMap;

		}
		@Override
		int getPanelLocation() {
			return panelLocation;
		}
		@Override
		void setPanelLocation(int a) {

			panelLocation = a;
		}
	}
	
	class ComplexPanel3 extends MapPanel{
		//By default, each panel is stored like 1A in simple.png, in the equivalent Cartesian quadrant 2.

		public int panelNum = 7;
		public int panelLocation = 2;//in Quadrants

		ComplexPanel3(){
			super();

		}

		int SIZE = 8;

		//This an 8x8 Matrix used to store the board.
		//Note: This Matrix looks transposed compared to the drawn boards. This is intended. The first row is actually the first column to be drawn.
		//To access a piece, call map[i][j] where i is in the positive x direction
		//and j is in the negative y value. (map[0][0] = "reg" , map[7][7] = "1")

		String[][] map = {{"reg","reg","bottomWall","reg","reg","reg","reg","reg"},//Column 1
						{"reg","reg","reg","reg","reg","reg","reg","reg"},
						{"reg","reg","reg","reg","1l,9","reg","reg","reg"},
						{"reg","reg","reg","reg","3l,10","reg","reg","reg",},
						{"reg","b24","reg","reg","reg","reg","reg","reg",},
						{"leftWall","reg","reg","reg","reg","reg","2l,11","reg",},
						{"reg","reg","4l,12","y24","reg","reg","reg","reg",},
						{"reg","reg","reg","reg","reg","reg","reg","3D",}};//Column 8

		@Override
		String[][] getMap(){
			return map;

		}
		@Override
		int getPanelNum() {
			return panelNum;

		}

		@Override
		void setMap(String[][] newMap) {
			map = newMap;

		}
		@Override
		int getPanelLocation() {
			return panelLocation;
		}
		@Override
		void setPanelLocation(int a) {

			panelLocation = a;
		}
	}
	
	class ComplexPanel4 extends MapPanel{
		
		//By default, each panel is stored like 1A in simple.png, in the equivalent Cartesian quadrant 2.

		public int panelNum = 8;
		public int panelLocation = 2;//in Quadrants

		ComplexPanel4(){
			super();

		}

		int SIZE = 8;

		//This an 8x8 Matrix used to store the board.
		//Note: This Matrix looks transposed compared to the drawn boards. This is intended. The first row is actually the first column to be drawn.
		//To access a piece, call map[i][j] where i is in the positive x direction
		//and j is in the negative y value. (map[0][0] = "reg" , map[7][7] = "1")

		String[][] map = {{"reg","reg","reg","reg","reg","reg","bottomWall","reg"},//Column 1
						{"reg","reg","reg","reg","reg","4l,13","reg","reg"},
						{"reg","r24","reg","1l,14","reg","reg","reg","reg"},
						{"reg","reg","reg","3l,15","reg","reg","g24","reg",},
						{"reg","reg","reg","reg","reg","reg","reg","reg",},
						{"leftWall","reg","reg","reg","reg","reg","reg","4l,17",},
						{"reg","reg","2l,16","reg","reg","reg","reg","reg",},
						{"reg","reg","reg","reg","reg","reg","reg","4D",}};//Column 8

		@Override
		String[][] getMap(){
			return map;

		}
		@Override
		int getPanelNum() {
			return panelNum;

		}

		@Override
		void setMap(String[][] newMap) {
			map = newMap;

		}
		@Override
		int getPanelLocation() {
			return panelLocation;
		}
		@Override
		void setPanelLocation(int a) {

			panelLocation = a;
		}
	}
