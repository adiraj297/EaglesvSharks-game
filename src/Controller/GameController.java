package Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import Model.Board;
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
import View.MainFrame;

/**
 * Game controller class that will transmit data to model and view.
 * 
 * @author mohammed
 *
 */
public class GameController {

	private MainFrame game;
	private JButton square;
	private JButton selectedSquare;
	private int turn = 0;
	private Game engine;
	private final Board board;
	private List<Piece> sharkPieces;
	private List<Piece> eaglePieces;
	private List<Piece> obstaclePieces;

	public GameController() {

		this.sharkPieces = null;
		this.sharkPieces = new ArrayList<Piece>();
		this.eaglePieces = new ArrayList<Piece>();
		this.obstaclePieces = new ArrayList<Piece>();

		// temp func
		makePieces();

		this.board = new Board(sharkPieces, eaglePieces, obstaclePieces);

		this.game = new MainFrame(this.board, this);
		this.engine = new Game(this.board);

		startGame();
	}

	public GameController(Board board) {
		this.sharkPieces = null;
		this.board = board;

		this.game = new MainFrame(this.board, this);
		this.engine = new Game(this.board);

		startGame();
	}

	private void makePieces() {
		Piece s1 = new Shark1(null);
		Piece s2 = new Shark2(null);
		Piece s3 = new Shark3(null);
		Piece s4 = new Shark4(null);
		Piece s5 = new Shark5(null);

		sharkPieces.add(s1);
		sharkPieces.add(s2);
		sharkPieces.add(s3);
		sharkPieces.add(s4);
		sharkPieces.add(s5);

		Piece e1 = new Eagle1(null);
		Piece e2 = new Eagle2(null);
		Piece e3 = new Eagle3(null);
		Piece e4 = new Eagle4(null);
		Piece e5 = new Eagle5(null);

		eaglePieces.add(e1);
		eaglePieces.add(e2);
		eaglePieces.add(e3);
		eaglePieces.add(e4);
		eaglePieces.add(e5);

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

	public boolean movePiece(Square srcSquare, Square targetSquare) {
		// check piece belongs to curr player
		if (srcSquare.getPiece().getPlayer() == engine.getCurrentPlayer())

			if (engine.move(srcSquare, targetSquare)) {
				System.out.println("piece moved");
				return true;
			} else
				return false;
		return false;
	}

	public String checkGameStatus() {
		Square[][] square = this.board.getBoard();
		int length = square.length;
		int eagleCount = 0;
		int sharkCount = 0;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < square[0].length; j++) {
				if (null != square[i][j].getPiece()) {
					if (!square[i][j].getPiece().isKnocked() && square[i][j].getPiece().iconName().contains("eagle")) {
						eagleCount++;
					} else if (!square[i][j].getPiece().isKnocked()
							&& square[i][j].getPiece().iconName().contains("shark")) {
						sharkCount++;
					}
				}
			}
		}
		if (eagleCount == 0 && sharkCount >= 1) {
			return "Shark's Win";
		} else if (sharkCount == 0 && eagleCount >= 1) {
			return "Eagle's win";
		}

		return null;
	}
	
	public void undo() {
		engine.undo();
	}
	
	public void redo() {
		engine.redo();
	}

	public void writeState() {

		try {
			FileOutputStream f = new FileOutputStream(new File("GameDataLargeboard.txt"));
			ObjectOutputStream w = new ObjectOutputStream(f);

			// Write objects to file
			w.writeObject(this.board);

			w.close();
			f.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error initializing stream");
		}

	}
	
	public Board getBoard() {
		return this.board;
	}

}
