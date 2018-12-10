package tdmu.edu;

import java.util.ArrayList;

public class Board {
	public char board[][];
	char humanPlayer = 'O';
	char aiPlayer = 'X';

	public Board() {
		super();
		board = new char[3][3];
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				board[i][j] = (char) (i*3 + j+1);
	}
	
	public void showBoard() {
		for (int i = 0; i < 3; i++) {
			System.out.println("---------------");
			for (int j = 0; j < 3; j++)
				System.out.print(" | " + board[i][j]);
			System.out.println(" | ");
		}
		System.out.println("---------------");
	}
	
	public ArrayList<Move> getMoves() {
		ArrayList<Move> moves = new ArrayList<Move>();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++)
				if (this.board[i][j] != 'O' && this.board[i][j] != 'X') {
					Move temp = new Move();
					temp.x = i;
					temp.y = j;
					moves.add(temp);
				}
		}
		return moves;
	}
	
	public boolean isGameOver() {
		
	}
	
	public int evaluate(char player) {
		
	}
	
	public char currentPlayer() {
		int human = 0;
		int ai = 0;
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (this.board[i][j] == 'O') human++;
				else if (this.board[i][j] == 'X') ai++;
		if (human > ai) return 'O';
		else return 'X';
	}
	
	public Board makeMove(Move move) {
		Board tempBoard = new Board();
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				tempBoard.board[i][j] = this.board[i][j];
		tempBoard.board[move.x][move.y] = currentPlayer();
		return tempBoard;
	}
}
