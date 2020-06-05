package Model.Piece;

import Model.Player;

/**
 * eagle child class
 * @author mohammed
 *
 */
//TODO class name should represent descriptive naming piece
public class Obstacle1 extends Obstacle {

	public Obstacle1(Player player) {
		super(player);
		
		// TODO numbers should change depending on piece
		this.attackPower = 0;
		this.defencePower = 0;
		this.movePower = 0;
	}

	public String iconName() {
		return "obstacle1";
	}
	
}
