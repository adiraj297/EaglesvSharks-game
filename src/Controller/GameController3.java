package Controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import Model.Board3;
import Model.Game;
import Model.Square;
import Model.Piece.Eagle1;
import Model.Piece.Eagle2;
import Model.Piece.Eagle3;
import Model.Piece.Eagle4;
import Model.Piece.Eagle5;
import Model.Piece.Obstacle1;
import Model.Piece.Obstacle2;
import Model.Piece.Piece;
import Model.Piece.Shark1;
import Model.Piece.Shark2;
import Model.Piece.Shark3;
import Model.Piece.Shark4;
import Model.Piece.Shark5;
import View.MainFrame3;

/**
 * Game controller class that will transmit data to model and view.
 * 
 * @author mohammed
 *
 */
public class GameController3 {

	private MainFrame3 game;
	private JButton square;
	private JButton selectedSquare;
	private int turn = 0;
	private Game engine;
	private final Board3 board;
	private final List<Piece> sharkPieces;
	private final List<Piece> eaglePieces;
	private final List<Piece> obstaclePieces;

	public GameController3() {

		sharkPieces = new ArrayList<Piece>();
		eaglePieces = new ArrayList<Piece>();
		obstaclePieces = new ArrayList<Piece>();

		// temp func
		makePieces();

		this.board = new Board3(sharkPieces, eaglePieces, obstaclePieces);

		this.game = new MainFrame3(this.board, this);
		this.engine = new Game();

		startGame();
	}

	private void makePieces() {
		
		Piece s2 = new Shark2(null);
		Piece s3 = new Shark3(null);
		Piece s4 = new Shark4(null);
		

	
		sharkPieces.add(s2);
		sharkPieces.add(s3);
		sharkPieces.add(s4);
	

		Piece e1 = new Eagle1(null);
		Piece e2 = new Eagle2(null);
		Piece e3 = new Eagle3(null);
		
	

		eaglePieces.add(e1);
		eaglePieces.add(e2);
		eaglePieces.add(e3);
		
		Piece o1 = new Obstacle1(null);
		obstaclePieces.add(o1);

		Piece o2 = new Obstacle2(null);
		obstaclePieces.add(o2);
		
	
	}

	public void startGame() {
//		game.board.onPressSquare(e->{
//			selectedSquare = (JButton)e.getSource();
//			if(selectedSquare != null ) { 
//				if(selectedSquare.getIcon() != null) {
//					square = selectedSquare;
//				}else {
//					if(square != null) {
//						selectedSquare.setIcon(square.getIcon());
//						square.setIcon(null);
//						square = null;
//						turn();
//					}
//				}
//			}
//		});
	}

	public void turn() {
		this.turn++;
		if (turn > 1)
			turn = 0;
	}

	public void movePiece(Square srcSquare, Square targetSquare) {
		// check piece belongs to curr player
		if (srcSquare.getPiece().getPlayer() == engine.getCurrentPlayer())

			if (engine.move(srcSquare, targetSquare)) {
				System.out.println("piece moved");
			} else
				System.out.println("piece NOT moved");
	}

}
