package Model.Piece;

import Model.Player;

public class Shark1 extends Shark {

	private static final int ATTACK_POWER = 7;
	private static final int DEFENCE_POWER = 3;
	private static final int MOVE_POWER = 4;

	public Shark1(Player player) {
		super(player);
		
		// TODO numbers should change depending on piece
		this.attackPower = 7;
		this.defencePower = 3;
		this.movePower = 4;
	}

	public String iconName() {
		return "shark1";
	}

}
