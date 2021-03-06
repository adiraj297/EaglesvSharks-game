package View;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Controller.GameController;
import Model.Board;

public class MainFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private final BoardPanel boardPanel;
	private final Board board;
	private final GameController controller;

	public MainFrame(Board board, GameController controller) {
		super();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.board = board;
		this.controller = controller;
		JPanel statusP = new StatusPanel(this.controller,this.board);
		boardPanel = new BoardPanel(this.board, this.controller,statusP);
		
		
		add(boardPanel, BorderLayout.CENTER);
		add(statusP, BorderLayout.WEST);

		setSize(1200,1000);
        setVisible(true);
	}

}
