package Model.Piece;

import Model.Player;
import Model.Square;

/**
 * piece class is an abstract class that gives the important and common
 * functionalities that other ancestors can use.
 */
public abstract class Piece {

	protected int attackPower;
	protected int defencePower;
	protected int movePower;
	private Player player;
	private boolean knocked;
	private Square square;

	public Piece(Player player) {
		this.player = player;
		this.knocked = false;
		this.square = null;
		// this.player.addPiece(this);
	}

	public Square getSquare() {
		return square;
	}

	public void setSquare(Square square) {
		this.square = square;
	}

	public int getAttackPower() {
		return attackPower;
	}

	public void setAttackPower(int attackPower) {
		this.attackPower = attackPower;
	}

	public int getDefencePower() {
		return defencePower;
	}

	public void setDefencePower(int defencePower) {
		this.defencePower = defencePower;
	}

	public boolean isKnocked() {
		return knocked;
	}

	public void setKnocked() {
		this.knocked = true;
	}

	public int getMovePower() {
		return movePower;
	}

	public Player getPlayer() {
		return player;
	}

	public abstract String iconName();
}
