import java.util.Scanner;
import java.util.Random;

public class TicTacToe {
	//Initializing Varibles 
	int playerChoice;
	int computerChoice;
	int flipCoin;
	int choice;
	
	public static void main(String[] args) {
		TicTacToe tictac = new TicTacToe();
		tictac.toss();
		tictac.printGameBoard();
	}

	//Here the function printGameBoard is used to print gameBoard aur used to refresh the Board
	private void printGameBoard() {
		char [] [] gameBoard = {{ ' ' , ' ' ,'|' , ' ' , ' ' , '|' , ' ' , ' ' },
      				     { '-' ,  '-' , '+' , '-' ,   '-' , '+' ,'-' , '-' },
				     { ' ' , ' ' ,'|' , ' ' , ' ' , '|' , ' ' , ' ' },
				     { '-' ,  '-' , '+' , '-' ,   '-' , '+' ,'-' , '-' },
				     { ' ' , ' ' ,'|' , ' ' , ' ' , '|' , ' ' , ' '}};

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
			System.out.println("Enter your Choice among these 1-X or 2-O.");
			playerChoice = scan.nextInt();
			Choice(playerChoice);
		} else {
			System.out.println("Computer won the Toss!!!");
			computerChoice = random.nextInt();
			Choice(computerChoice);
		}
		scan.close();
	}

	//Here the function choice is used to choose either X or O 
	private void Choice(int choice) {
		if (choice == 1 ) {
			System.out.println("Choice made by Winning the toss is X.");
		} else {
			System.out.println("Choice made by Winning the toss is O.");
		}
	}
}

