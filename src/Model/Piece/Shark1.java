package Model.Piece;

import Model.Player;

/**
 * shark child class
 * @author mohammed
 * 
 */
// TODO class name should represent descriptive naming piece
public class Shark1 extends Shark {

	public Shark1(Player player) {
		super(player);
		
		// TODO numbers should change depending on piece
		this.attackPower = 5;
		this.defencePower = 6;
		this.movePower = 4;
	}
	
	public String iconName() {
		return "shark1";
	}

}
