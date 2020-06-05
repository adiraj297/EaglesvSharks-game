package View;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Controller.GameController3;
import Model.Board3;

public class MainFrame3 extends JFrame {

	private static final long serialVersionUID = 1L;
	private final BoardPanel3 boardPanel3;
	private final Board3 board3;
	private final GameController3 controller3;

	public MainFrame3(Board3 board, GameController3 controller) {
		super();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		this.board3 = board;
		this.controller3 = controller;

		JPanel statusP = new StatusPanel(this.controller3);
		boardPanel3 = new BoardPanel3(this.board3, this.controller3);
		

		add(boardPanel3, BorderLayout.CENTER);
		add(statusP, BorderLayout.WEST);

		setSize(1200, 1000);
		setVisible(true);
	}

}
