package Model.Piece;

import java.io.Serializable;

import Model.Player;
import Model.Square;

/**
 * piece class is an abstract class that gives the important and common functionalities that other ancestors can use. 
 * @author mohammed
 *
 */
public abstract class Piece implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
//		this.player.addPiece(this);
	}
	
	
	public Square getSquare() {
		return square;
	}

	public void setSquare(Square square) {
		this.square = square;
	}

	/**
	 * @return
	 */
	public int getAttackPower() {
		return attackPower;
	}

	/**
	 * @param attackPower
	 */
	public void setAttackPower(int attackPower) {
		this.attackPower = attackPower;
	}

	/**
	 * @return
	 */
	public int getDefencePower() {
		return defencePower;
	}

	/**
	 * @param defencePower
	 */
	public void setDefencePower(int defencePower) {
		this.defencePower = defencePower;
	}

	/**
	 * @return
	 */
	public boolean isKnocked() {
		return knocked;
	}

	/**
	 * 
	 */
	public void setKnocked() {
		this.knocked = true;
	}

	/**
	 * @return
	 */
	public int getMovePower() {
		return movePower;
	}

	/**
	 * @return
	 */
	public Player getPlayer() {
		return player;
	}

	
	public abstract String iconName();
}
