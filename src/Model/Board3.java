package Model;

import java.io.Serializable;
import java.util.List;

import Model.Piece.Piece;

/**
 * Board class will keep track of the board and squares in the board
 * @author mohammed
 *
 */
public class Board3 extends BoardBase implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Board size has to be even and above 10
	private final static int BOARD_SIZE = 12;
//	private Square[][] board;
	
	private final List<Piece> sharkPieces;
	private final List<Piece> eaglePieces;
	private final List<Piece> obstaclePieces;

	public Board3(List<Piece> sharkPieces, List<Piece> eaglePieces, List<Piece> obstaclePieces) {
		super(BOARD_SIZE);
		this.sharkPieces = sharkPieces;
		this.eaglePieces = eaglePieces;
		this.obstaclePieces = obstaclePieces;
		populateSquares();
	}	
	
	public void populateSquares() {
		for(int i = 0; i < BOARD_SIZE; i++ ) {
			for(int j = 0; j < BOARD_SIZE; j++) {
				this.board[i][j] = new Square(i, j);
			}
		}
		this.board[0][0].setPiece(eaglePieces.get(0));
		this.board[0][2].setPiece(eaglePieces.get(1));
		this.board[0][4].setPiece(eaglePieces.get(2));
		
		this.board[5][8].setPiece(obstaclePieces.get(0));
		this.board[5][3].setPiece(obstaclePieces.get(1));
		
		
		this.board[BOARD_SIZE-3][BOARD_SIZE-9].setPiece(sharkPieces.get(0));
		this.board[BOARD_SIZE-3][BOARD_SIZE-7].setPiece(sharkPieces.get(1));
		this.board[BOARD_SIZE-3][BOARD_SIZE-5].setPiece(sharkPieces.get(2));
		
		
		
	}
}
