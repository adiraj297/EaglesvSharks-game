package Model;

import Model.Piece.Piece;

public class Square {
	private int row;
	private int col;
	private Piece piece;

	public Square(int row, int col) {
		this.row = row;
		this.col = col;
		this.piece = null;
	}
	
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}
	
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
	public Piece getPiece() {
		return this.piece;
	}

	public String toString() {
		return this.piece != null ? "p":row + "|" + col + " ";
	}
}
