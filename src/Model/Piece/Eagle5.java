package Model.Piece;

import Model.Player;

public class Eagle5 extends Eagle {

	private static final int ATTACK_POWER = 3;
	private static final int DEFENCE_POWER = 7;
	private static final int MOVE_POWER = 4;

	public Eagle5(Player player) {
		super(player);

		this.attackPower = ATTACK_POWER;
		this.defencePower = DEFENCE_POWER;
		this.movePower = MOVE_POWER;
	}

	public String iconName() {
		return "eagle5";
	}

}
