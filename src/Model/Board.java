package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Model.Piece.*;

/**
 * @author mohammed
 *
 */
public class Board {
	
	private final int BOARD_SIZE = 9;
	private Square[][] squares;

	public Board() {
		this.squares = new Square[BOARD_SIZE][BOARD_SIZE];
	}	
	
	
	/**
	 * @param x
	 * @param y
	 * @return
	 */
	public Square getSquare(int x, int y) {
		if(this.squares[x][y] != null) return this.squares[x][y];
		return null;
	}
}
