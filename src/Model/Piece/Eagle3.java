package Model.Piece;

import Model.Player;

public class Eagle3 extends Eagle {

	private static final int ATTACK_POWER = 8;
	private static final int DEFENCE_POWER = 2;
	private static final int MOVE_POWER = 4;

	public Eagle3(Player player) {
		super(player);

		this.attackPower = ATTACK_POWER;
		this.defencePower = DEFENCE_POWER;
		this.movePower = MOVE_POWER;
	}

	public String iconName() {
		return "eagle3";
	}

}
