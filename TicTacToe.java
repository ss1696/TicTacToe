import java.util.Scanner;
import java.util.Random;

public class TicTacToe {
	//Initializing Varibles 
	int playerChoice;
	int flipCoin;
	
	public static void main(String[] args) {
		TicTacToe tictac = new TicTacToe();
		System.out.println("Welcome to TicTacToe game!!!\nTo start the game we flip the coin.");
		tictac.toss();
		tictac.printGameBoard();
	}

	//Here the function printGameBoard is used to print gameBoard aur used to refresh the Board
	private void printGameBoard() {
		char [] [] gameBoard = {{' ','|',' ','|',' '},
					{'-','+','-','+','-'},
					{' ','|',' ','|',' '},
					{'-','+','-','+','-'},
					{' ','|',' ','|',' '}};
		for (char [] row : gameBoard) {
			for(char c : row) {
				System.out.print(c);
			}
			System.out.println();
		}
	}

	//Here the function toss is used to choose who will begin first player aur Computer.
	private void toss() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please choose among these 0-head and 1-tail");
		playerChoice = scan.nextInt();
		
		Random random = new Random();
		flipCoin = random.nextInt(2);
		
		if(playerChoice == flipCoin) {
			System.out.println("Player won the Toss!!!");
		} else {
			System.out.println("Computer won the Toss!!!");
		}
		scan.close();
	}
}

