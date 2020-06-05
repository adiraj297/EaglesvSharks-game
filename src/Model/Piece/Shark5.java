package Model.Piece;

import Model.Player;

public class Shark5 extends Shark {

	private static final int ATTACK_POWER = 9;
	private static final int DEFENCE_POWER = 1;
	private static final int MOVE_POWER = 1;

	public Shark5(Player player) {
		super(player);
		
		// TODO numbers should change depending on piece
		this.attackPower = 9;
		this.defencePower = 1;
		this.movePower = 1;
	}

	public String iconName() {
		return "shark5";
	}

}
