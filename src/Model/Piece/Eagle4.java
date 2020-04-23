package Model.Piece;

import Model.Player;

/**
 * @author mohammed
 *
 */
//TODO class name should represent descriptive naming piece
public class Eagle4 extends Eagle {

	public Eagle4(Player player) {
		super(player);
		
		// TODO numbers should change depending on piece
		this.attackPower = 10;
		this.defencePower = 10;
		this.movePower = 10;
	}

}
