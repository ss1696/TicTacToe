import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
public class TicTacToe {
	//Initializing Varibles 
	int playerChoice;
	int computerChoice;
	int flipCoin;
	int choice;
	int position;
	char playerSymbol;
	char computerSymbol;
	String user;
	char [] [] gameBoard;
	List<Integer> playerPosition = new ArrayList<Integer>();
	List<Integer> computerPosition = new ArrayList<Integer>();
	List<Integer> occupiedPosition = new ArrayList<>();

	public static void main(String[] args) {
		TicTacToe tictac = new TicTacToe();
		System.out.println("Welcome to TicTacToe game!!!\nTo start the game we flip the coin.");
		tictac.gameBoard();
	}

	//Here the function printGameBoard is used to print gameBoard aur used to refresh the Board
	private void gameBoard() {
		char [] [] gameBoard = {{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '}};
		toss(gameBoard);
	}

	//used to print the TicTacToe board 
	private void printGameBoard(char [] [] gameBoard) {
		for (char [] row : gameBoard) {
			for(char c : row) {
				System.out.print(c);
			}
			System.out.println();
		}

	}

	//Here the function toss is used to choose who will begin first player aur Computer.
	private void toss(char[][] gameBoard) {
		position = 0;
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		flipCoin = random.nextInt(2);

		if(flipCoin == 1) {
			user = "player";
			System.out.println("Player won the Toss!!!");
			System.out.println("Enter your Choice among these 0-X or 1-O.");
			playerChoice = scan.nextInt();
			eachplaySymbol(playerChoice,user);
			printGameBoard(gameBoard);
			System.out.println("Symbol taken by Player:"+playerSymbol);
			System.out.println("Symbol taken by Computer:"+computerSymbol);
			playGame(gameBoard);
		} else {
			user = "computer";
			System.out.println("Computer won the Toss!!!");
			computerChoice = random.nextInt(2);
			eachplaySymbol(computerChoice,user);
			System.out.println("Symbol taken by Player:"+playerSymbol);
			System.out.println("Symbol taken by Computer:"+computerSymbol);
			printGameBoard(gameBoard);
			playGame(gameBoard);
		}
		scan.close();
	}
	//Here this function is used to play the game till the winning , loosing aur tie condition reached 
	void playGame(char[][] gameBoard) {
		while (checkWinning()) {
			Scanner scan = new Scanner(System.in);
			System.out.print("Enter your Placement (1-9):");
			int playerPlacement = scan.nextInt();
			occupiedPosition.contains(playerPlacement);
			//check that player could not enter the value at place which is already taken
			while (playerPosition.contains(playerPlacement) || computerPosition.contains(playerPlacement)) {
				System.out.println("Position is Taken!! Enter a correct Position");
				playerPlacement = scan.nextInt();
				occupiedPosition.contains(playerPlacement);
			}
			placeChoice(gameBoard,playerPlacement,"player");
			Random random = new Random();
			int computerPlacement = random.nextInt(9) + 1;
			occupiedPosition.contains(computerPlacement);
			//check that computer could not enter the value at place which is already taken
			while (playerPosition.contains(computerPlacement) || computerPosition.contains(computerPlacement)) {
				computerPlacement = random.nextInt(9) + 1;
				occupiedPosition.contains(computerPlacement);
			}
			placeChoice(gameBoard,computerPlacement,"computer");
			printGameBoard(gameBoard);
			checkWinning();
		}
		System.out.println(computerPosition);
		System.out.println(playerPosition);
	}

	//Here this function is used to place the symbol X or O according to the selection of player and computer
	char eachplaySymbol(int choice, String user) {
		if(user.equals("player")) {
			if (choice == 0 ) {
				playerSymbol = 'X';
				computerSymbol = 'O';
				return playerSymbol;
			} else {
				playerSymbol = 'O';
				computerSymbol = 'X';
				return playerSymbol;
			}
		} else if(user.equals("computer")){
			if (choice == 0 ) {
				computerSymbol = 'X';
				playerSymbol = 'O';
				return playerSymbol;
			} else {
				computerSymbol = 'O';
				playerSymbol = 'X';
				return playerSymbol;
			}
		}
		return computerSymbol;
	}

	//Placing the element  at respected position 
	void placeChoice (char[][] gameBoard,int position,String user) {
		char symbol = ' ';
		if(user.equals("player")) {
			if (playerSymbol == 'X' ) {
				symbol = 'X';
				playerPosition.add(position);
			} else {
				symbol = 'O';
				playerPosition.add(position);
			}
		} else {
			if (computerSymbol == 'X') {
				symbol = 'X';
				computerPosition.add(position);
			} else {
				symbol = 'O';
				computerPosition.add(position);
			}
		}

		switch (position) {
		case 1: 
			gameBoard [0][0] = symbol;
			break;
		case 2: 
			gameBoard [0][2] = symbol;
			break;
		case 3: 
			gameBoard [0][4] = symbol;
			break;
		case 4: 
			gameBoard [2][0] = symbol;
			break;
		case 5: 
			gameBoard [2][2] = symbol;
			break;
		case 6: 
			gameBoard [2][4] = symbol;
			break;
		case 7: 
			gameBoard [4][0] = symbol;
			break;
		case 8: 
			gameBoard [4][2] = symbol;
			break;
		case 9: 
			gameBoard [4][4] = symbol;
			break;
		default:
			break;
		}
	}

	//Here this function is used to check the winning conditions
	boolean checkWinning() {
		List<Integer> topRow = Arrays.asList(1,2,3);
		List<Integer> midRow = Arrays.asList(4,5,6);
		List<Integer> lastRow = Arrays.asList(7,8,9);
		List<Integer> leftCol = Arrays.asList(1,4,7);
		List<Integer> midCol = Arrays.asList(2,5,8);
		List<Integer> rightCol = Arrays.asList(3,6,9);
		List<Integer> cross1 = Arrays.asList(1,5,9);
		List<Integer> cross2 = Arrays.asList(3,5,7);

		List<List> winningConditions = new ArrayList<>();
		winningConditions.add(topRow);
		winningConditions.add(midRow);
		winningConditions.add(lastRow);
		winningConditions.add(lastRow);
		winningConditions.add(leftCol);
		winningConditions.add(midCol);
		winningConditions.add(rightCol);
		winningConditions.add(cross1);
		winningConditions.add(cross2);

		for(List l : winningConditions) {
			if(playerPosition.containsAll(l)) {
				System.out.println("Congratulation you Won!!");
				return false;
			} else if(computerPosition.containsAll(l)) {
				System.out.println("Computer Wins!! Sorry :(");
				return false;
			} else if (playerPosition.size() + computerPosition.size() == 9) {
				System.out.println("Match is Draw!!!");
				return false;
			}
		} 
		return true;
	}

	//Here if computer get the win position than he will move there..
		int computerMove(int computerPlacement) {
		if (winCondition(computerPlacement) == true) {
			return computerPlacement;
		} else {
			Random random = new Random();
			return computerPlacement = random.nextInt(9) + 1;
		}
	}

	boolean winCondition(int computerPlacement) {
		int[][] winPosition = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 4, 7 }, { 2, 5, 8 }, { 3, 6, 9 }, { 1, 5, 9 },
                { 3, 5, 7 } };
		int k = 0;
		List<Integer> unMatched = new ArrayList<>();

		while (k < 8) {
			int matchCount = 0;
			unMatched.clear();

			for (int i = 0; i < winPosition[k].length; i++) {
				if (occupiedPosition.contains(winPosition[k][i])) {
					if (computerPosition.contains(winPosition[k][i])) {
						matchCount++;
					}
				} else {
					unMatched.add(winPosition[k][i]);
				}
			}

			if (matchCount == 2 && unMatched.size() == 1) {
				computerPlacement = unMatched.get(0);
				break;
			}
			k++;
		}
		return true;
	}
}
