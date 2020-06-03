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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Controller.GameController2;
import Model.Board2;
import Model.Square;
import Model.Piece.Piece;

/**
 * @author mohammed
 *
 */
public class BoardPanel2 extends JPanel {

	final List<SquarePanel> boardSquares;

	Board2 board;
	final GameController2 controller;

	private Square srcSquare;
	private Square targetSquare;
	private Piece selectedPiece;

	public BoardPanel2(Board2 board, GameController2 controller) {

		this.board = board;
		this.controller = controller;

		this.boardSquares = new ArrayList<SquarePanel>();
		setLayout(null);

		drawBoard();

//		onPressSquare();

		setLayout(new GridLayout(11, 11, 0, 0));
		setPreferredSize(new Dimension(1000, 1000));
	}

	public void drawBoard() {
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				final SquarePanel squarePanel = new SquarePanel(this, i, j);
				boardSquares.add(squarePanel);

				add(squarePanel);
			}
		}

	}

	public void redraw(Board2 borad) {
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

		SquarePanel(final BoardPanel2 boardPanel2, final int row, final int col) {
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
						srcSquare = null;
						targetSquare = null;
						selectedPiece = null;
					} else if (SwingUtilities.isLeftMouseButton(e)) {
						if (srcSquare == null) {

							srcSquare = board.getSquare(row, col);
							selectedPiece = srcSquare.getPiece();
							if (selectedPiece == null) {
								srcSquare = null;

							} else
								System.out.println("first piece selected");
						} else {
							System.out.println("second piece selected");
							targetSquare = board.getSquare(row, col);
							controller.movePiece(srcSquare, targetSquare);
							srcSquare = null;
							targetSquare = null;
							selectedPiece = null;
							boardPanel2.revalidate();
						}
						SwingUtilities.invokeLater(new Runnable() {

							@Override
							public void run() {
								boardPanel2.redraw(board);

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

		public void drawSquare(Board2 board) {
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

		private void squareIcon(final Board2 board) throws IOException {
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
