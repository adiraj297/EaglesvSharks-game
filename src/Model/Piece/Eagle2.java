package Model.Piece;

import Model.Player;

public class Eagle2 extends Eagle {
	
	private static final int ATTACK_POWER = 2;
	private static final int DEFENCE_POWER = 8;
	private static final int MOVE_POWER = 3;

	public Eagle2(Player player) {
		super(player);
		
		// TODO numbers should change depending on piece
		this.attackPower = 2;
		this.defencePower = 8;
		this.movePower = 3;
	}
	
	public String iconName() {
		return "eagle2";
	}

}
