package Model.Piece;

import Model.Player;

public class Shark4 extends Shark {

	private static final int ATTACK_POWER = 5;
	private static final int DEFENCE_POWER = 5;
	private static final int MOVE_POWER = 5;

	public Shark4(Player player) {
		super(player);
		
		this.attackPower = ATTACK_POWER;
		this.defencePower = DEFENCE_POWER;
		this.movePower = MOVE_POWER;
	}

	public String iconName() {
		return "shark4";
	}

}
