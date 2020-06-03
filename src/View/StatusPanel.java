package View;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.BoardController;

/**
 * This panel will show status of players, movements, and pieces' strength and weaknesses
 * @author mohammed
 *
 */
public class StatusPanel extends JPanel {

	private BoardController board = new BoardController() ;
	
	public StatusPanel() {
		super();
		setPreferredSize(new Dimension(200, 1000));
		setBackground(Color.lightGray);
		JButton startGame = new JButton("Start The Game");
		JLabel label = new JLabel("Game Status");
		
		add(label);
		startGame.addActionListener(board);
	}

}
