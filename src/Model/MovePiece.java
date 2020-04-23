package Model;

import Model.Piece.Piece;

/**
 * @author mohammed
 *
 */
public class MovePiece {
	
	private Square targetSquare;
	private Square currentSquare;
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
	 * @return
	 */
	public Square getCurrentSquare() {
		return currentSquare;
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
