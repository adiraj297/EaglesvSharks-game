package Model.Piece;

import Model.Player;

public class Shark1 extends Shark {

	private static final int ATTACK_POWER = 7;
	private static final int DEFENCE_POWER = 3;
	private static final int MOVE_POWER = 4;

	public Shark1(Player player) {
		super(player);

		this.attackPower = ATTACK_POWER;
		this.defencePower = DEFENCE_POWER;
		this.movePower = MOVE_POWER;
	}

	public String iconName() {
		return "shark1";
	}

}
