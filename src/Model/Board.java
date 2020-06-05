package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

import Model.Piece.Piece;

/**
 * Board class will keep track of the board and squares in the board
 * @author mohammed
 *
 */
public class Board implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Board size has to be even and above 10
	private final int BOARD_SIZE = 12;
	private Square[][] board;
	
	private final List<Piece> sharkPieces;
	private final List<Piece> eaglePieces;
	private final List<Piece> obstaclePieces;

	public Board(List<Piece> sharkPieces, List<Piece> eaglePieces, List<Piece> obstaclePieces) {
		this.board = new Square[BOARD_SIZE][BOARD_SIZE];
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
		this.board[0][6].setPiece(eaglePieces.get(3));
		this.board[0][8].setPiece(eaglePieces.get(4));
		
		this.board[5][8].setPiece(obstaclePieces.get(0));
		this.board[5][3].setPiece(obstaclePieces.get(1));
		
		this.board[BOARD_SIZE-1][BOARD_SIZE-9].setPiece(sharkPieces.get(0));
		this.board[BOARD_SIZE-1][BOARD_SIZE-7].setPiece(sharkPieces.get(1));
		this.board[BOARD_SIZE-1][BOARD_SIZE-5].setPiece(sharkPieces.get(2));
		this.board[BOARD_SIZE-1][BOARD_SIZE-3].setPiece(sharkPieces.get(3));
		this.board[BOARD_SIZE-1][BOARD_SIZE-1].setPiece(sharkPieces.get(4));
		
	}
	
	/**
	 * Get Square based on coordinates x,y => row,col
	 * @param x
	 * @param y
	 * @return
	 */
	public Square getSquare(int row, int col) {
		if(this.board[row][col] != null) return this.board[row][col];
		return null;
		
	}
	
	public Square[][] getBoard(){
		return this.board;
	}

	
	
}
