package Controller;

import javax.swing.JButton;

import View.MainFrame;

/**
 * Game controller class that will transmit data to model and view.
 * @author mohammed
 *
 */
public class GameController {
	
	private MainFrame game;
	private JButton square;
	private JButton selectedSquare;
    private int turn = 0;

	public GameController() {
		this.game = new MainFrame();
		startGame();
	}
	
	public void startGame() {
		game.board.onPressSquare(e->{
			selectedSquare = (JButton)e.getSource();
			if(selectedSquare != null ) { 
				if(selectedSquare.getIcon() != null) {
					square = selectedSquare;
				}else {
					if(square != null) {
						selectedSquare.setIcon(square.getIcon());
						square.setIcon(null);
						square = null;
						turn();
					}
				}
			}
		});

	}
	
	public void turn() {
		this.turn++;
		if(turn>1)  
			turn=0;
	}

}
