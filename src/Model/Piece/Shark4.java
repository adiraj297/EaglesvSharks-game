package Model.Piece;

import Model.Player;

public class Shark4 extends Shark {

	private static final int ATTACK_POWER = 5;
	private static final int DEFENCE_POWER = 5;
	private static final int MOVE_POWER = 5;

	public Shark4(Player player) {
		super(player);
		
		// TODO numbers should change depending on piece
		this.attackPower = 5;
		this.defencePower = 5;
		this.movePower = 5;
	}

	public String iconName() {
		return "shark4";
	}

}
