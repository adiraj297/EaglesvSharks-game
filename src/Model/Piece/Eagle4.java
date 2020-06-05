package Model.Piece;

import Model.Player;

public class Eagle4 extends Eagle {

	private static final int ATTACK_POWER = 1;
	private static final int DEFENCE_POWER = 9;
	private static final int MOVE_POWER = 6;

	public Eagle4(Player player) {
		super(player);
		
		// TODO numbers should change depending on piece
		this.attackPower = 1;
		this.defencePower = 9;
		this.movePower = 6;
	}

	public String iconName() {
		return "eagle4";
	}

}
