package Model;

import java.util.ArrayList;
import java.util.List;

import Model.Piece.Piece;

/**
 * this class is for player and all required information about them such as pieces they have
 * @author mohammed
 *
 */
public class Player {
	private String name;
	private List<Piece> pieces;

	public Player(String name) {
		this.name = name;
		this.pieces = new ArrayList<Piece>(); 
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param piece
	 */
	public void addPiece(Piece piece) {
		this.pieces.add((Piece) pieces);
	}
	
	public List<Piece> getPieces(){
		return this.pieces;
	}

	
}
