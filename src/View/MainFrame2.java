package View;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Controller.GameController2;
import Model.Board2;

/**
 * @author mohammed
 *
 */
public class MainFrame2 extends JFrame {

	private final BoardPanel2 boardPanel2;
	private final Board2 board2;
	private final GameController2 controller2;

	public MainFrame2(Board2 board3, GameController2 controller) {
		super();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		this.board2 = board3;
		this.controller2 = controller;
		JPanel statusP = new StatusPanel(this.controller2,this.board2);
		boardPanel2 = new BoardPanel2(this.board2, this.controller2, statusP);
		

		add(boardPanel2, BorderLayout.CENTER);
		add(statusP, BorderLayout.WEST);

		setSize(1200, 1000);
		setVisible(true);
	}

}
