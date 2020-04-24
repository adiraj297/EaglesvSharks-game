package Model.Piece;

import Model.Player;

/**
 * piece class is an abstract class that gives the important and common functionalities that other ancestors can use. 
 * @author mohammed
 *
 */
public abstract class Piece {
	
	protected int attackPower;
	protected int defencePower;
	protected int movePower;
	private Player player;
	private boolean knocked;

	public Piece(Player player) {
		this.player = player;
		this.knocked = false;
		this.player.addPiece(this);
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
}
