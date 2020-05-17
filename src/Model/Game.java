package Model;

import java.util.List;

import Model.Piece.Piece;

/**
 * this is the engine class that will control all the game and its logic.
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
	 * get current player to play
	 * @return player
	 */
	public Player getTurn() {
		return turn;
	}

	
	/**
	 * set current player to play
	 * @param turn
	 */
	public void setTurn(Player turn) {
		this.turn = turn;
	}

	
	/**
	 * get Piece that is selected on board
	 * @return piece
	 */
	public Piece getSelecetdPiece() {
		return selecetdPiece;
	}

	
	/**
	 * set Piece that is selected on board
	 * @param selecetdPiece
	 */
	public void setSelecetdPiece(Piece selecetdPiece) {
		this.selecetdPiece = selecetdPiece;
	}

	
	/**
	 * get Square that is selected on board
	 * @return
	 */
	public Square getSelectedSquare() {
		return selectedSquare;
	}

	
	/**
	 * set Square that is selected on board
	 * @param selectedSquare
	 */
	public void setSelectedSquare(Square selectedSquare) {
		this.selectedSquare = selectedSquare;
	}

	
	/**
	 * get players array
	 * @return
	 */
	public List<Player> getPlayers() {
		return players;
	}

	
	/**
	 * get board object
	 * @return
	 */
	public Board getBoard() {
		return board;
	}
	
	
	/**
	 * this will check if given targetSquare is attackable by square and will return boolean 
	 * @param square
	 * @param targetSquare
	 * @return boolean
	 */
	public boolean attackable(Square square, Square targetSquare) {
		return false;
	}
	
	
	/**
	 * attack piece
	 * @param attackerPiece
	 * @param square
	 */
	public void attack(Piece attackerPiece, Square square) {
		
	}
	
	
	/**
	 * moves selected piece to selected square
	 * @param srcSquare
	 * @param targetSquare 
	 */
	public boolean move(Square srcSquare, Square targetSquare) {
		return false;
	}

}
