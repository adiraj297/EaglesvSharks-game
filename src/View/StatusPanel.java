package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.ModuleLayer.Controller;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
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
	private MainFrame mainFrame1;
	private MainFrame2 mainFrame2;
	private MainFrame3 mainFrame3;
	private GameController controller;
	
	public StatusPanel() {
		super();
		setPreferredSize(new Dimension(200, 1000));
		setBackground(Color.lightGray);
		JButton startGame = new JButton("Start The Game");
		JLabel label = new JLabel("Game Status");
		add(label);
		startGame.addActionListener(board);
	}

	public StatusPanel(GameController controller, Board board2, MainFrame mFrame) {
		super();
		mainFrame1 = mFrame;
		this.controller = controller;
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
		JButton undo = new JButton("Undo Move");
		JButton redo = new JButton("Redo Move");
		add(undo);
		add(redo);
		for(JLabel l : iconLabels)
		{
			add(l);
		}
		startGame.addActionListener(board);
		undo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.undo();
				mainFrame1.boardPanel.redraw(controller.getBoard());
			}
		});
		
		redo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.redo();
				mainFrame1.boardPanel.redraw(controller.getBoard());
			}
		});
	}
	
	public StatusPanel(GameController2 controller, MainFrame2 mFrame) {
		super();
		mainFrame2 = mFrame;
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
		JButton undo = new JButton("Undo Move");
		JButton redo = new JButton("Redo Move");
		add(undo);
		add(redo);
		startGame.addActionListener(board);
		undo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.undo();
				mainFrame2.boardPanel2.redraw(controller.getBoard());
			}
		});
		
		redo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.redo();
				mainFrame2.boardPanel2.redraw(controller.getBoard());
			}
		});
	}
	
	public StatusPanel(GameController3 controller, MainFrame3 mFrame) {
		super();
		mainFrame3 = mFrame;
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
		JButton undo = new JButton("Undo Move");
		JButton redo = new JButton("Redo Move");
		add(undo);
		add(redo);
		startGame.addActionListener(board);
		undo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.undo();
				mainFrame3.boardPanel3.redraw(controller.getBoard());
			}
		});
		
		redo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.redo();
				mainFrame3.boardPanel3.redraw(controller.getBoard());
			}
		});
	}
	
}
