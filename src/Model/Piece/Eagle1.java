package Model.Piece;

import Model.Player;

/**
 * eagle child class
 * @author mohammed
 *
 */
//TODO class name should represent descriptive naming piece
public class Eagle1 extends Eagle {

	public Eagle1(Player player) {
		super(player);
		
		// TODO numbers should change depending on piece
		this.attackPower = 3;
		this.defencePower = 7;
		this.movePower = 2;
	}

	public String iconName() {
		return "eagle1";
	}
	
}
