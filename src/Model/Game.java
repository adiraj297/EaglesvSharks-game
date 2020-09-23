package Model;

import java.util.ArrayList;
import java.util.List;

import Model.Piece.Piece;

/**
 * this is the engine class that will control all the game and its logic.
 * 
 *
 */
public class Game {

	private List<Player> players;
	private Player currPlayer;
	private Piece selecetdPiece;
	private Square selectedSquare;
	private Board board;

	public Game() {

	}

	public void startGame() {

	}

	public Player getCurrentPlayer() {
		return currPlayer;
	}

	public void setTurn(Player p) {
		this.currPlayer = p;
	}

	public Piece getSelecetdPiece() {
		return selecetdPiece;
	}

	public void setSelecetdPiece(Piece selecetdPiece) {
		this.selecetdPiece = selecetdPiece;
	}

	public Square getSelectedSquare() {
		return selectedSquare;
	}

	public void setSelectedSquare(Square selectedSquare) {
		this.selectedSquare = selectedSquare;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public Board getBoard() {
		return board;
	}

	public boolean attackable(Square square, Square targetSquare) {
		// obstacle is not attackable and implement code so that piece that attacks it
		// is knocked

		if (null != targetSquare.getPiece())
			return true;

		if (null != targetSquare.getPiece() && targetSquare.getPiece().isKnocked())
			return true;

		if (null != targetSquare.getPiece() && targetSquare.getPiece().iconName().contains("obstacle"))
			return false;

		if (null != targetSquare.getPiece() && null != square.getPiece()
				&& targetSquare.getPiece().iconName().contains("shark")
				&& square.getPiece().iconName().contains("shark"))
			return false;

		if (null != targetSquare.getPiece() && null != square.getPiece()
				&& targetSquare.getPiece().iconName().contains("eagle")
				&& square.getPiece().iconName().contains("eagle"))
			return false;

		return true;
	}

	private boolean checkVisinity(Square square, Square targetSquare) {

		int x = square.getCol();
		int y = square.getRow();
		List<Integer> col = new ArrayList<Integer>();
		col.add(x - 1);
		col.add(x);
		col.add(x + 1);
		List<Integer> row = new ArrayList<Integer>();
		row.add(y - 1);
		row.add(y);
		row.add(y + 1);
		System.out.println("Source X: " + square.getCol() + " Y:" + square.getRow());
		System.out.println("Targert X: " + targetSquare.getCol() + " Y:" + targetSquare.getRow());
		for (int i = 0; i < col.size(); i++) {
			for (int j = 0; j < row.size(); j++) {
				System.err.println("X: " + col.get(i) + " Y: " + row.get(j));
				if (col.get(i).intValue() == targetSquare.getCol() && row.get(j).intValue() == targetSquare.getRow()) {
					return true;
				}
			}
		}

		return false;
	}

	public boolean attack(Square attackerPiece, Square defencePiece) {

		if (null == attackerPiece.getPiece() || null == defencePiece.getPiece())
			return true;

		if (checkVisinity(attackerPiece, defencePiece)) {

			int attackPower = attackerPiece.getPiece().getAttackPower();
			int defencePower = defencePiece.getPiece().getDefencePower();
			int outcome = defencePower - attackPower;
			System.err.println("attackPower: " + attackPower);
			System.err.println("defencePower: " + defencePower);
			System.err.println("outcome: " + outcome);
			if (outcome <= 0) {
				System.out.println("Attacked Success");
				defencePiece.getPiece().setDefencePower(0);
				return true;
			} else {
				System.out.println("Attacked Failed");
				defencePiece.getPiece().setDefencePower(outcome);
				return false;
			}
		}
		return false;

	}

	public boolean move(Square srcSquare, Square targetSquare) {
		MovePiece m = new MovePiece(srcSquare, targetSquare);
		if (!attackable(srcSquare, targetSquare)) {
			System.out.println(attackable(srcSquare, targetSquare));
			return false;

		} else {
			System.out.println("Attacking");
			if (!attack(srcSquare, targetSquare))
				return false;
		}
		return m.move();
	}

}
