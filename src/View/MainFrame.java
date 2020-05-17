package View;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Model.Board;

/**
 * @author mohammed
 *
 */
public class MainFrame extends JFrame{
	
	private final BoardPanel boardPanel;
	private final Board board;

	public MainFrame(Board board) {
		super();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.board = board;
    
		boardPanel = new BoardPanel(this.board);
		JPanel statusP = new StatusPanel();
		
		add(boardPanel, BorderLayout.CENTER);
		add(statusP, BorderLayout.WEST);

		setSize(1200,1000);
        setVisible(true);
	}

}
