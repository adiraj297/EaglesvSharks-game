package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Model.Piece.*;

public class Board {
	
	private final int BOARD_SIZE = 9;
	private Square[][] squares;

	public Board() {
		this.squares = new Square[BOARD_SIZE][BOARD_SIZE];

		initSquares();
	}
	
	private void initSquares() {
		for(int i = 0 ; i < BOARD_SIZE; i++) {
			for(int j = 0; j < BOARD_SIZE; j++) {
				this.squares[i][j] = new Square(i,j);
				System.out.printf("square[%d][%d] created\n", i,j);
			}
		}
        Player playerOne = new Player("Mohammed");
        Player playerTwo = new Player("Rajesh");

//        List<Player> players = new ArrayList<>(Arrays.asList(playerOne, playerTwo));
        squares[0][2].setPiece(new Shark1(playerOne));
		squares[0][3].setPiece(new Shark2(playerOne));
		squares[0][4].setPiece(new Shark3(playerOne));
		squares[0][5].setPiece(new Shark4(playerOne));
		squares[0][6].setPiece(new Shark5(playerOne));
		
		squares[8][2].setPiece(new Eagle1(playerTwo));
		squares[8][3].setPiece(new Eagle2(playerTwo));
		squares[8][4].setPiece(new Eagle3(playerTwo));
		squares[8][5].setPiece(new Eagle4(playerTwo));
		squares[8][6].setPiece(new Eagle5(playerTwo));
		
		System.out.println("Pices is satup --");
	}
	
	
}
