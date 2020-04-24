package Model;

import Model.Piece.Piece;

/**
 * responsible for moving a piece and checking the validity of moving a piece to a given square
 * @author mohammed
 *
 */
public class MovePiece {
	
	private Square targetSquare;
	private Piece piece;
	private Player player;

	public MovePiece(Piece piece, Player player) {
		super();
		this.piece = piece;
		this.player = player;
	}

	/**
	 * @return
	 */
	public Square getTargetSquare() {
		return targetSquare;
	}

	/**
	 * @param targetSquare
	 */
	public void setTargetSquare(Square targetSquare) {
		this.targetSquare = targetSquare;
	}

	/**
	 * @return
	 */
	public Piece getPiece() {
		return piece;
	}

	/**
	 * @return
	 */
	public Player getPlayer() {
		return player;
	}

}
