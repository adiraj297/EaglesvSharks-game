package Model.Piece;

import Model.Player;

public class Eagle3 extends Eagle {

	private static final int ATTACK_POWER = 8;
	private static final int DEFENCE_POWER = 2;
	private static final int MOVE_POWER = 4;

	public Eagle3(Player player) {
		super(player);
		
		// TODO numbers should change depending on piece
		this.attackPower = 8;
		this.defencePower = 2;
		this.movePower = 4;
	}

	public String iconName() {
		return "eagle3";
	}

}
