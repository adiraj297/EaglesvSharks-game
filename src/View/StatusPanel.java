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

import Controller.GameController;
import Controller.GameController2;
import Controller.GameController3;
import Model.Board;
import Model.Board2;
import Model.Board3;

/**
 * 
 * @author Aditya Raj
 *
 */

//This panel will show status of players, movements, and pieces' strength and weaknesses
public class StatusPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	public StatusPanel(GameController controller, Board board2) {
		super();
		setPreferredSize(new Dimension(300, 1000));
		setBackground(Color.lightGray);

		JLabel label = new JLabel("Game Info");
		List<JLabel> iconLabels = new ArrayList<JLabel>();

		for (int i = 0; i < board2.getBoard().length; i++) {
			for (int j = 0; j < board2.getBoard()[0].length; j++) {
				if (null != board2.getBoard()[i][j].getPiece()
						&& !board2.getBoard()[i][j].getPiece().iconName().contains("obstacle")) {
					iconLabels.add(new JLabel(board2.getBoard()[i][j].getPiece().iconName() + "\n Attack: "
							+ board2.getBoard()[i][j].getPiece().getAttackPower() + "\n Defence : "
							+ board2.getBoard()[i][j].getPiece().getDefencePower() + "\n Move : "
							+ board2.getBoard()[i][j].getPiece().getMovePower()));
				}
			}
		}

		JButton saveButton = new JButton("Save State");
		JLabel hover = new JLabel("\n Hover over the Pieces to see their power");
		JLabel info = new JLabel("\n Powers for each piece for both teams:");
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.writeState();
				JOptionPane.showMessageDialog(null, "Game State Saved");
			}
		});

		add(label);
		add(saveButton);
		add(hover);
		add(info);

		for (JLabel l : iconLabels) {
			add(l);
		}

	}

	public StatusPanel(GameController2 controller, Board2 board3) {
		super();
		setPreferredSize(new Dimension(300, 1000));
		setBackground(Color.lightGray);

		JLabel label = new JLabel("Game Info");
		List<JLabel> iconLabels = new ArrayList<JLabel>();

		for (int i = 0; i < board3.getBoard().length; i++) {
			for (int j = 0; j < board3.getBoard()[0].length; j++) {
				if (null != board3.getBoard()[i][j].getPiece()
						&& !board3.getBoard()[i][j].getPiece().iconName().contains("obstacle")) {
					iconLabels.add(new JLabel(board3.getBoard()[i][j].getPiece().iconName() + "\n Attack: "
							+ board3.getBoard()[i][j].getPiece().getAttackPower() + "\n Defence : "
							+ board3.getBoard()[i][j].getPiece().getDefencePower() + "\n Move : "
							+ board3.getBoard()[i][j].getPiece().getMovePower()));
				}
			}
		}

		JButton saveButton = new JButton("\n Save State");
		JLabel hover = new JLabel("\n Hover over the Pieces to see their power");
		JLabel info = new JLabel("\n Powers for each piece for both teams:");
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.writeState();
				JOptionPane.showMessageDialog(null, "Game State Saved");
			}
		});
		add(label);
		add(saveButton);
		add(hover);
		add(info);
		for (JLabel l : iconLabels) {
			add(l);
		}

	}

	public StatusPanel(GameController3 controller, Board3 board4) {
		super();
		setPreferredSize(new Dimension(300, 1000));
		setBackground(Color.lightGray);

		JLabel label = new JLabel("Game Info");

		List<JLabel> iconLabels = new ArrayList<JLabel>();

		for (int i = 0; i < board4.getBoard().length; i++) {
			for (int j = 0; j < board4.getBoard()[0].length; j++) {
				if (null != board4.getBoard()[i][j].getPiece()
						&& !board4.getBoard()[i][j].getPiece().iconName().contains("obstacle")) {
					iconLabels.add(new JLabel(board4.getBoard()[i][j].getPiece().iconName() + "\n Attack: "
							+ board4.getBoard()[i][j].getPiece().getAttackPower() + "\n Defence : "
							+ board4.getBoard()[i][j].getPiece().getDefencePower() + "\n Move : "
							+ board4.getBoard()[i][j].getPiece().getMovePower()));
				}
			}
		}

		JButton saveButton = new JButton("Save State");
		JLabel hover = new JLabel("\n Hover over the Pieces to see their power");
		JLabel info = new JLabel("\n Powers for each piece for both teams:");
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.writeState();
				JOptionPane.showMessageDialog(null, "Game State Saved");
			}

		});
		add(label);
		add(saveButton);
		add(hover);
		add(info);
		for (JLabel l : iconLabels) {
			add(l);
		}

	}

}
