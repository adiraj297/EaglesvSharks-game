package Model;

import Model.Piece.Piece;

/**
 * responsible for checking the validity of moving a piece to a given square
 * 
 * @author Aditya Raj
 * @author Rajesh Choudhari
 *
 */
public class MoveValidity {

	private Piece piece;

	public MoveValidity(Piece piece) {
		this.piece = piece;
	}

	/**
	 * @param square
	 * @return
	 */
	public boolean isValidMove(Square square) {
		int srcRow = this.piece.getSquare().getRow();
		int srcCol = this.piece.getSquare().getCol();

		int distRow = square.getRow();
		int distCol = square.getCol();

		int resRow = Math.abs(srcRow - distRow);
		int resCol = Math.abs(srcCol - distCol);

		return (resRow + resCol <= this.piece.getMovePower()) ? true : false;
	}

	/**
	 * @return
	 */
	public Square[] validMoves() {
		return null;
	}

}
