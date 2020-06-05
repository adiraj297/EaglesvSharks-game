package Model.Piece;

import Model.Player;

public class Shark3 extends Shark {

	private static final int ATTACK_POWER = 3;
	private static final int DEFENCE_POWER = 7;
	private static final int MOVE_POWER = 2;

	public Shark3(Player player) {
		super(player);
		
		// TODO numbers should change depending on piece
		this.attackPower = 3;
		this.defencePower = 7;
		this.movePower = 2;
	}

	public String iconName() {
		return "shark3";
	}

}
