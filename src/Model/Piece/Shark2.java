package Model.Piece;

import Model.Player;

public class Shark2 extends Shark {

	private static final int ATTACK_POWER = 4;
	private static final int DEFENCE_POWER = 6;
	private static final int MOVE_POWER = 3;

	public Shark2(Player player) {
		super(player);

		this.attackPower = ATTACK_POWER;
		this.defencePower = DEFENCE_POWER;
		this.movePower = MOVE_POWER;
	}

	public String iconName() {
		return "shark2";
	}

}
