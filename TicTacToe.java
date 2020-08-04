public class TicTacToe {

	public static void main(String[] args) {

		TicTacToe tictac = new TicTacToe();
		System.out.println("Welcome to TicTacToe game!!");
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
}

