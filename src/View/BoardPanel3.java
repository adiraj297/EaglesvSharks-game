package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import Controller.GameController3;
import Model.Board3;
import Model.Square;
import Model.Piece.Piece;

/**
 * @author mohammed
 *
 */
public class BoardPanel3 extends JPanel {

	final List<SquarePanel> boardSquares;

	Board3 board;
	final GameController3 controller;
	private SquarePanel lastSqrPanel;
	private String lastPlayer = null;
	private Square srcSquare;
	private Square targetSquare;
	private Piece selectedPiece;

	public BoardPanel3(Board3 board, GameController3 controller) {

		this.board = board;
		this.controller = controller;

		this.boardSquares = new ArrayList<SquarePanel>();
		setLayout(null);

		drawBoard();

//		onPressSquare();

		setLayout(new GridLayout(10, 10, 0, 0));
		setPreferredSize(new Dimension(1000, 1000));
	}

	public void drawBoard() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				final SquarePanel squarePanel = new SquarePanel(this, i, j);
				boardSquares.add(squarePanel);

				add(squarePanel);
			}
		}

	}

	public void redraw(Board3 borad) {
		removeAll();
		for (SquarePanel sqrPanel : boardSquares) {
			sqrPanel.drawSquare(board);
			add(sqrPanel);
		}
		validate();
		repaint();
	}

	private class SquarePanel extends JPanel {
		private final int row;
		private final int col;

		SquarePanel(final BoardPanel3 boardPanel3, final int row, final int col) {
			super(new GridBagLayout());
			this.row = row;
			this.col = col;

			squareColor();

			try {
				squareIcon(board);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
			Border redBorder = BorderFactory.createLineBorder(Color.RED, 5);
			
			System.out.println("piece init");
			addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
				}

				@Override
				public void mousePressed(MouseEvent e) {
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					if (SwingUtilities.isRightMouseButton(e)) {
						System.out.println("piece deselected");

						if (null != lastSqrPanel) {
							lastSqrPanel.setBorder(blackBorder);
							lastSqrPanel = null;
						}
						srcSquare = null;
						targetSquare = null;
						selectedPiece = null;
					} else if (SwingUtilities.isLeftMouseButton(e)) {

						if (srcSquare == null) {

							srcSquare = board.getSquare(row, col);

							if (null != srcSquare.getPiece()
									&& (null == lastPlayer || !srcSquare.getPiece().iconName().contains(lastPlayer))) {
								selectedPiece = srcSquare.getPiece();
								if (selectedPiece == null) {
									srcSquare = null;

								} else {
									lastSqrPanel = (SquarePanel) e.getSource();
								}
								if (null != lastSqrPanel)
									lastSqrPanel.setBorder(redBorder);
								System.out.println("first piece selected");
							} else {
								srcSquare = null;
								if (null != lastPlayer) {
									String player = lastPlayer.contains("shark") ? "Eagle" : "Shark";
									JOptionPane.showMessageDialog(SwingUtilities.getRootPane(boardPanel3),
											player + "'s turn to play. Please wait for your turn.");
								}
							}

						} else {
							System.out.println("second piece selected");
							targetSquare = board.getSquare(row, col);
							if (null != lastSqrPanel)
								lastSqrPanel.setBorder(blackBorder);
							lastSqrPanel = null;
							
							boolean moveStatus  = controller.movePiece(srcSquare, targetSquare);
							if (null != selectedPiece) {
								lastPlayer = selectedPiece.iconName();
								lastPlayer = lastPlayer.substring(0, lastPlayer.length() - 1);
								if(!moveStatus)
									lastPlayer = null;
							}
							srcSquare = null;
							targetSquare = null;
							selectedPiece = null;
							boardPanel3.revalidate();
							String gameStatus = controller.checkGameStatus();
							if (null != controller.checkGameStatus()) {
								JOptionPane.showMessageDialog(SwingUtilities.getRootPane(boardPanel3), gameStatus);
							}

						}
						SwingUtilities.invokeLater(new Runnable() {

							@Override
							public void run() {
								boardPanel3.redraw(board);

							}

						});

					}
				}

				@Override
				public void mouseEntered(MouseEvent e) {
				}

				@Override
				public void mouseExited(MouseEvent e) {
				}

			});

			validate();
		}

		public void drawSquare(Board3 board) {
			squareColor();
			try {
				squareIcon(board);
				validate();
				repaint();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		private void squareColor() {
			if ((this.row + this.col) % 2 == 1)
				setBackground(Color.black);
			else
				setBackground(Color.white);
		}

		private void squareIcon(final Board3 board) throws IOException {
			removeAll();
			Piece piece = board.getSquare(this.row, this.col).getPiece();
			if (piece != null) {
				ImageIcon icon = scaleImage(
						new ImageIcon(this.getClass().getResource("/resources/" + piece.iconName() + ".png")));
				add(new JLabel(icon));
			}
		}

		private ImageIcon scaleImage(ImageIcon icon) {
			Image img = icon.getImage();
			Image resizedImage = img.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH);
			return new ImageIcon(resizedImage);
		}

	}

	private class BoardMouseListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}
}
