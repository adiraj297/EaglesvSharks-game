package Model;

import Model.Piece.Piece;

/**
 * responsible for checking the validity of moving a piece to a given square
 * @author mohammed
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
		return false;
	}
	
	/**
	 * @return
	 */
	public Square[] validMoves() {
		return null;
	}

}
