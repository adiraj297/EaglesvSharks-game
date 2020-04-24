package Model;

/**
 * Board class will keep track of the board and squares in the board
 * @author mohammed
 *
 */
public class Board {
	
	private final int BOARD_SIZE = 9;
	private Square[][] squares;

	public Board() {
		this.squares = new Square[BOARD_SIZE][BOARD_SIZE];
	}	
	
	
	/**
	 * Get Square based on coordinates x,y => col,row
	 * @param x
	 * @param y
	 * @return
	 */
	public Square getSquare(int x, int y) {
		if(this.squares[x][y] != null) return this.squares[x][y];
		return null;
	}
}
