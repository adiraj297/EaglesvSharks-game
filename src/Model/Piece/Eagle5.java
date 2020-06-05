package Model.Piece;

import Model.Player;

public class Eagle5 extends Eagle {

	private static final int ATTACK_POWER = 3;
	private static final int DEFENCE_POWER = 7;
	private static final int MOVE_POWER = 4;

	public Eagle5(Player player) {
		super(player);
		
		// TODO numbers should change depending on piece
		this.attackPower = 3;
		this.defencePower = 7;
		this.movePower = 4;
	}

	public String iconName() {
		return "eagle5";
	}

}
