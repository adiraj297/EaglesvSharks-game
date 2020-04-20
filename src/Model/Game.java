package Model;

public class Game {
	
	private Board board;

	public Game() {
		
	}
	
	public void startGame() {
		createBoard();
	}
	
	public void createBoard() {
		board = new Board();
	}

}
