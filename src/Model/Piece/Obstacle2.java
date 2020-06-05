package Model.Piece;

import Model.Player;

public class Obstacle2 extends Obstacle {

	public Obstacle2(Player player) {
		super(player);

		this.attackPower = 0;
		this.defencePower = 0;
		this.movePower = 0;
	}

	public String iconName() {
		return "obstacle2";
	}

}
