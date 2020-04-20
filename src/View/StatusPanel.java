package View;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

import Controller.BoardController;

public class StatusPanel extends JPanel {

	private BoardController board = new BoardController() ;
	
	public StatusPanel() {
		super();
		setPreferredSize(new Dimension(200, 1000));
		setBackground(Color.RED);
		JButton startGame = new JButton("Start The Game");
		
		add(startGame);
		startGame.addActionListener(board);
	}

}
