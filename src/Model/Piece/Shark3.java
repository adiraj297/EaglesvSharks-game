package Model.Piece;

import Model.Player;

/**
 * shark child class
 * @author mohammed
 *
 */
//TODO class name should represent descriptive naming piece
public class Shark3 extends Shark {

	public Shark3(Player player) {
		super(player);
		
		// TODO numbers should change depending on piece
		this.attackPower = 10;
		this.defencePower = 10;
		this.movePower = 10;
	}

}
