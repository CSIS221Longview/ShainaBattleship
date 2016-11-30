package battleshipgame;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Gameboard {

	// Declare constants
	String EMPTY_SPACE = "0";
	
	// ships
	private int AIRCRAFT=5;
	private int BATTLESHIP=4;
	private int DESTROYER=3;
	private int SUBMARINE=3;
	private int PATROL=2;
	
	// hits and misses
	private int hits, misses;
	// private ArrayList<String> location = new ArrayList<String>();
	int guess;
	private int level;
	private int availableMissiles;
	private int boardSize;
	private char[][] gameBoard;
	private int ship;
	private int shipSize;
	private char shipMarker;
	private String shipString;
	
	Random rand = new Random();
	
	// Scanner to retain user input
	Scanner input = new Scanner(System.in);
	
	//constructor for Gameboard

	//public Gameboard(char[][] game){
		//this.gameBoard = game;
		//outputGame();
	//}
	
	
	// method to print board
	public void outputGame() 
	{ 
		System.out.print("   ");
		for (int i = 0; i < gameBoard[0].length; i++) {
			System.out.printf("%4d", i+1);
		}
		
		System.out.println();
		//loop through array's rows
		for (int row = 0; row < gameBoard.length; row++)
		{	 
			System.out.printf("%3c", getLetter(row+1));
	
			// loop through columns of current row
			for (int column = 0; column < gameBoard.length; column++) {
				    // gameBoard[row][column] = '~';
					System.out.printf("%3s", gameBoard[row][column]);
					
				//System.out.print(gameBoard[row][column]);
			}
			System.out.println();

		}
	}
	
	// converts int to char for column
	public char getLetter(int i){
		  return (char) (i + 64);
		}
	
	// method to prompt user to choose difficulty, assign level, and print board
	public void difficultyInfo() {
		// prompt user to choose difficult
			
		System.out.print("Choose your level of difficulty.");
		System.out.print("\n" + "Enter 1 for Easy, 2 for Standard, and 3 for Advanced. ");
		level = input.nextInt();
			
		// checks to ensure valid level is chosen
		while (level != 1 && level != 2 && level != 3)
		{
			level = 0;
			System.out.print("You have not chosen a valid option. Please try again.");
				if (level == 0)
				{
					System.out.print("Choose your level of difficulty.");
					System.out.print("\n" + "Enter 1 for Easy, 2 for Standard, and 3 for Advanced. ");
					level = input.nextInt();
				} 
			}
			
			if (level == 1)
			{
				level = 1;
				System.out.println("I see you've chosen to take it EASY. Sharpen up those skills my friend."); 
				availableMissiles = 30;
				System.out.println("You have " + availableMissiles + " missiles to start with. Don't waste them.");
				boardSize = 6;
				gameBoard = new char[6][6];
				
			} else if (level == 2)
			{
				System.out.println("STANDARD eh? You're on your way!");
				availableMissiles = 50;
				System.out.println("You have " + availableMissiles + " missiles to start with. Best of luck!");
				boardSize = 9;
				gameBoard = new char[9][9];
				
			} else if (level == 3)
			{
				System.out.println("Feeling risky today huh? You're probably going to lose, but give ADVANCED a try.");
				availableMissiles = 75;
				System.out.println("You have " + availableMissiles + " missiles to start with. Put those skills to good use.");
				boardSize = 12;
				gameBoard = new char[12][12];
			}
			System.out.println();
	}
	
	public void set(char[][] gameBoard){
		this.gameBoard=gameBoard;
	}
	
	public int missiles(int bombs) {
		bombs = this.availableMissiles;
		return bombs;
	}
	
	public int boardSize(int size) {
		size = this.boardSize;
		return size;
	}
	
	//SHIP CLASS
	// constructor for ships-should I create class just for ships?
	
	//public Ship(String shipString, char shipMarker, int shipSize){
		//this.shipString = shipString;
		//this.shipMarker = shipMarker;
		//this.shipSize = shipSize;
	//}
	
	
	// get ship location
	//public ArrayList<String> getLocations() {
	//	return location;
	//}
	
	// get ship String
	public String getShipString(){
		return this.shipString;
	}
	
	// get ship size
	public int getSize(){
		return this.shipSize;
	}
	
	// method to set random location of ships
	//public void setShips(ArrayList<String> locToSet) {
	//	this.location.addAll(locToSet);
	//}
	
	// method to check user's guess
	public String checkGuess(String userGuess) {
		String result = "miss";
		// check to see if userGuess is inside location arrayList
		int index = location.indexOf(userGuess);
		
		if (index >= 0){
			location.remove(index);
			if (location.isEmpty()) {
				result = "kill";
			} else {
				result = "hit";
			}
		}
		
		System.out.println(result);
		
		return result;
	}
	
	// method to track score
	public int trackScore(int score) {
		return score;
	}
	
	// method to set ship info
	public void setShipInfo()
	{
		System.out.println();
		// ship = 3;
		String shipString = null;
		switch(ship){
		case 1: shipString = "AIRCRAFT";
				shipMarker = 'A';
				shipSize = 5;
				break;
		case 2: shipString = "BATTLESHIP";
				shipMarker = 'B';
				shipSize = 4;
				break;
		case 3: shipString = "DESTROYER";
				shipMarker = 'D';
				shipSize = 3;
				break;
		case 4: shipString = "SUBMARINE";
				shipMarker = 'S';
				shipSize = 3;
				break;
		case 5: shipString = "PATROL";
				shipMarker = 'P';
				shipSize = 2;	
				break;
		}
		System.out.println(shipMarker);
	}
	
	
	// method to position ships
		public void positionShips() 
		{

			ship = 1;
		while (ship < 5) {	
			if (ship == 1) {
			int temp = rand.nextInt(boardSize);
			for (int i = 0; i < 5; i++) 
			gameBoard[i+1][temp] = 'A';
			temp++;
			} 
			ship = 2;
			if (ship == 2) {
				int temp = rand.nextInt(boardSize);
				for (int i = 0; i < 4; i++)
				gameBoard[i+1][temp] = 'B';
				temp++;
			}
			ship = 3;
			if (ship == 3) {
				int temp = rand.nextInt(boardSize);
				for (int i = 0; i < 3; i++)
				gameBoard[i+1][temp] = 'D';
				temp++;
			}
			ship = 4;
			if (ship == 4) {
				int temp = rand.nextInt(boardSize);
				for (int i = 0; i < 3; i++)
				gameBoard[i+1][temp] = 'S';
				temp++;
			}
			ship = 5;
			if (ship == 5) {
				int temp = rand.nextInt(boardSize) ;
				for (int i = 0; i < 2; i++)
				gameBoard[i+1][temp] = 'P';
				temp++;
			}
			outputGame();
		} 
		}
		
		
}
