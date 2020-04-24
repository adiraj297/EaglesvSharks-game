package Model;

import Model.Piece.Piece;

/**
 * this class is responsible for a specific square in the board and it holds coordinates information and piece if it has one 
 * @author mohammed
 *
 */
public class Square {
	private int row;
	private int col;
	private Piece piece;

	public Square(int row, int col) {
		this.row = row;
		this.col = col;
		this.piece = null;
	}
	
	/**
	 * @return
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @param row
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * @return
	 */
	public int getCol() {
		return col;
	}

	/**
	 * @param col
	 */
	public void setCol(int col) {
		this.col = col;
	}
	
	/**
	 * @param piece
	 */
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
	/**
	 * @return
	 */
	public Piece getPiece() {
		return this.piece;
	}

	public String toString() {
		return this.piece != null ? "p":row + "|" + col + " ";
	}
}
