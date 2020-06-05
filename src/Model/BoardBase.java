package Model;

public abstract class BoardBase {
	
	protected Square[][] board;
	
	protected BoardBase(final int size) {
		this.board = new Square[size][size];
	}

	/**
	 * Get Square based on coordinates x,y => row,col
	 * @param x
	 * @param y
	 * @return
	 */
	public Square getSquare(int row, int col) {
		if(this.board[row][col] != null) return this.board[row][col];
		return null;
	}
	
	public Square[][] getBoard(){
		return this.board;
	}
	
}
