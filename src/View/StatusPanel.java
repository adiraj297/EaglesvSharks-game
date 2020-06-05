package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Controller.BoardController;
import Controller.GameController;
import Controller.GameController2;
import Controller.GameController3;
import Model.Board;

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

	public StatusPanel(GameController controller, Board board2) {
		super();
		setPreferredSize(new Dimension(200, 1000));
		setBackground(Color.lightGray);
		JButton startGame = new JButton("Start The Game");
		JLabel label = new JLabel("Game Status");
		List<JLabel> iconLabels = new ArrayList<JLabel>();  
		
		for(int i = 0; i< board2.getBoard().length;i++)
		{
			for (int j = 0; j < board2.getBoard()[0].length; j++) {
				if (null != board2.getBoard()[i][j].getPiece() && !board2.getBoard()[i][j].getPiece().iconName().contains("obstacle")) {
					iconLabels.add(new JLabel(board2.getBoard()[i][j].getPiece().iconName()+ "\n Attack: "+ board2.getBoard()[i][j].getPiece().getAttackPower()+"\n Defence : "+ board2.getBoard()[i][j].getPiece().getDefencePower()));
				}
			}
		}
		
		JButton saveButton = new JButton("Save State");
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.writeState(); 
				JOptionPane.showMessageDialog(null,"Game State Saved");
			}
        });
		add(label);
		add(saveButton);
		for(JLabel l : iconLabels)
		{
			add(l);
		}
		startGame.addActionListener(board);
	}
	
	public StatusPanel(GameController2 controller) {
		super();
		setPreferredSize(new Dimension(200, 1000));
		setBackground(Color.lightGray);
		JButton startGame = new JButton("Start The Game");
		JLabel label = new JLabel("Game Status");
		
		JButton saveButton = new JButton("Save State");
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.writeState(); 
				JOptionPane.showMessageDialog(null,"Game State Saved");
			}
        });
		add(label);
		add(saveButton);
		startGame.addActionListener(board);
	}
	
	public StatusPanel(GameController3 controller) {
		super();
		setPreferredSize(new Dimension(200, 1000));
		setBackground(Color.lightGray);
		JButton startGame = new JButton("Start The Game");
		JLabel label = new JLabel("Game Status");
		
		JButton saveButton = new JButton("Save State");
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.writeState();  
				JOptionPane.showMessageDialog(null,"Game State Saved");
			}
			
        });
		add(label);
		add(saveButton);
		startGame.addActionListener(board);
	}
	
}
