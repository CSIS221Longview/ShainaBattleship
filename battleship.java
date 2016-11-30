package battleshipgame;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;


public class battleship {
	
	static Gameboard gameboard1;
	public static void main(String[] args) {
		gameboard1 = new Gameboard();
		
		gameboard1.difficultyInfo();
		gameboard1.positionShips();
		
		
	}

}
