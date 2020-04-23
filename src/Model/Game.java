package Model;

import java.util.List;

import Model.Piece.Piece;

/**
 * @author mohammed
 *
 */
public class Game {

	private List<Player> players;
	private Player turn;
	private Piece selecetdPiece;
	private Square selectedSquare;
	private Board board;
	
	public Game() {
		
	}
	
	
	/**
	 * 
	 */
	public void startGame() {

	}

	
	/**
	 * @return
	 */
	public Player getTurn() {
		return turn;
	}

	
	/**
	 * @param turn
	 */
	public void setTurn(Player turn) {
		this.turn = turn;
	}

	
	/**
	 * @return
	 */
	public Piece getSelecetdPiece() {
		return selecetdPiece;
	}

	
	/**
	 * @param selecetdPiece
	 */
	public void setSelecetdPiece(Piece selecetdPiece) {
		this.selecetdPiece = selecetdPiece;
	}

	
	/**
	 * @return
	 */
	public Square getSelectedSquare() {
		return selectedSquare;
	}

	
	/**
	 * @param selectedSquare
	 */
	public void setSelectedSquare(Square selectedSquare) {
		this.selectedSquare = selectedSquare;
	}

	
	/**
	 * @return
	 */
	public List<Player> getPlayers() {
		return players;
	}

	
	/**
	 * @return
	 */
	public Board getBoard() {
		return board;
	}
	
	
	/**
	 * @param square
	 * @param targetSquare
	 * @return
	 */
	public boolean attackable(Square square, Square targetSquare) {
		return false;
	}
	
	
	/**
	 * @param attackerPiece
	 * @param square
	 */
	public void attack(Piece attackerPiece, Square square) {
		
	}
	
	
	/**
	 * moves selected piece to selected square
	 * 
	 */
	public void move() {
		
	}

}
