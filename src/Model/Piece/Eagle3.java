package Model.Piece;

import Model.Player;

/**
 * @author mohammed
 *
 */
//TODO class name should represent descriptive naming piece
public class Eagle3 extends Eagle {

	public Eagle3(Player player) {
		super(player);
		
		// TODO numbers should change depending on piece
		this.attackPower = 10;
		this.defencePower = 10;
		this.movePower = 10;
	}

}
