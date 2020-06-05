package Model.Piece;

import Model.Player;

public class Obstacle1 extends Obstacle {

	public Obstacle1(Player player) {
		super(player);

		this.attackPower = 0;
		this.defencePower = 0;
		this.movePower = 0;
	}

	public String iconName() {
		return "obstacle1";
	}

}
