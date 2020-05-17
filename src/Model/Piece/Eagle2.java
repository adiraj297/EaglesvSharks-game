package Model.Piece;

import Model.Player;

/**
 * eagle child class
 * @author mohammed
 *
 */
//TODO class name should represent descriptive naming piece
public class Eagle2 extends Eagle {
	public Eagle2(Player player) {
		super(player);
		
		// TODO numbers should change depending on piece
		this.attackPower = 10;
		this.defencePower = 10;
		this.movePower = 10;
	}
	
	public String iconName() {
		return "eagle2";
	}

}
