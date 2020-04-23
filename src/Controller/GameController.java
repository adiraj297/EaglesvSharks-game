package Controller;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import View.MainFrame;
import Model.Board;
import Model.Player;

/**
 * @author mohammed
 *
 */
public class GameController {
	
	private MainFrame game;
	private JButton square;
	private JButton selectedSquare;
	private ImageIcon icon;
    private Player eagleP;
    private Player sharkP;
    private int turn = 0;

	public GameController() {
		this.game = new MainFrame();
//		this.square = null;
		
//        board = new Board();
//        board.game = this;
//        game = new game(board, whitePlayer, blackPlayer);
//        startGame();
		startGame();
	}
	
	public void startGame() {
		game.board.onPressSquare(e->{
			selectedSquare = (JButton)e.getSource();
			boolean isPiece = (ImageIcon)selectedSquare.getIcon() != null;
			if(!isPiece) { 
				ImageIcon temp = (ImageIcon) selectedSquare.getIcon();
				selectedSquare.setIcon(icon);
				square.setIcon(temp);
				selectedSquare = null;
				square = null;
				turn();
			}
		});
		
		game.board.onPressPiece(e->{
			square = (JButton)e.getSource();
			icon = (ImageIcon) square.getIcon();
		});
	}
	
	public void turn() {
		this.turn++;
		if(turn>1)  
			turn=0;
	}

}
