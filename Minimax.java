package tdmu.edu;

public class Minimax {
	int bestScore;
	Move bestMove;
	int currentScore;
	Move currentMove;
	
	public Minimax() {}
	public Minimax(int bestScore, Move bestMove) {
		this.bestScore = bestScore;
		this.bestMove = bestMove;
	}
	
	public Minimax minimax(Board board, char player, int maxDepth, int currentDepth) {
		
		if (board.isGameOver() || currentDepth == maxDepth)
			return new Minimax(board.evaluate(player), null);
		
		bestMove = null;
		if (board.currentPlayer() == player) this.bestScore = -10;
		else this.bestScore = 10;
		
		for (Move move : board.getMoves()) {
			
			Board newBoard = board.makeMove(move);
			
			Minimax temp = new Minimax();
			temp = temp.minimax(newBoard, player, maxDepth, currentDepth + 1);
			this.currentScore = temp.bestScore;
			this.currentMove = temp.bestMove;
			
			// Update the best score
			if (board.currentPlayer() == player) {
				if (this.currentScore > this.bestScore) {
					this.bestScore = this.currentScore;
					this.bestMove = move;
				}
			}
			else {
				if (this.currentScore < this.bestScore) {
					this.bestScore = this.currentScore;
					this.bestMove = move;
				}
			}
						
		}
		return new Minimax(bestScore, bestMove);
	}
}
