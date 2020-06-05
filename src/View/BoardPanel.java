package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import Controller.GameController;
import Model.Board;
import Model.Square;
import Model.Piece.Piece;


/**
 * @author mohammed
 *
 */
public class BoardPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	final List<SquarePanel> boardSquares;

	Board board;
	final GameController controller;

	private Square srcSquare;
	private Square targetSquare;
	private Piece selectedPiece;
	private SquarePanel lastSqrPanel;
	private String lastPlayer = null;

	public BoardPanel(Board board, GameController controller, JPanel statusP) {

		this.board = board;
		this.controller = controller;
		this.boardSquares = new ArrayList<SquarePanel>();
		setLayout(null);

		drawBoard();

		// onPressSquare();

		setLayout(new GridLayout(12, 12, 0, 0));
		setPreferredSize(new Dimension(1000, 1000));
	}

	public void drawBoard() {
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 12; j++) {
				final SquarePanel squarePanel = new SquarePanel(this, i, j);
				boardSquares.add(squarePanel);

				add(squarePanel);
			}
		}

	}

	public void redraw(Board board) {
		removeAll();
		for (SquarePanel sqrPanel : boardSquares) {
			sqrPanel.drawSquare(board);
			add(sqrPanel);
		}
		validate();
		repaint();
	}

	private class SquarePanel extends JPanel {
		private static final long serialVersionUID = 183436188435541249L;
		private final int row;
		private final int col;

		SquarePanel(final BoardPanel boardPanel, final int row, final int col) {

			super(new GridBagLayout());
			this.row = row;
			this.col = col;

			squareColor();

			try {
				squareIcon(board);
			} catch (IOException e) {
				e.printStackTrace();
			}
			Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
			Border redBorder = BorderFactory.createLineBorder(Color.RED, 5);

			
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
									JOptionPane.showMessageDialog(SwingUtilities.getRootPane(boardPanel),
											player + "'s turn to play. Please wait for your turn.");
								}
							}

						} else {
							System.out.println("second piece selected");
							targetSquare = board.getSquare(row, col);
							if (null != lastSqrPanel)
								lastSqrPanel.setBorder(blackBorder);
							lastSqrPanel = null;

							boolean moveStatus = controller.movePiece(srcSquare, targetSquare);
							if (null != selectedPiece) {
								lastPlayer = selectedPiece.iconName();
								lastPlayer = lastPlayer.substring(0, lastPlayer.length() - 1);
								if (!moveStatus)
									lastPlayer = null;
							}
							srcSquare = null;
							targetSquare = null;
							selectedPiece = null;
							boardPanel.revalidate();
							String gameStatus = controller.checkGameStatus();
							if (null != controller.checkGameStatus()) {
								JOptionPane.showMessageDialog(SwingUtilities.getRootPane(boardPanel), gameStatus);
							}

						}
						SwingUtilities.invokeLater(new Runnable() {

							@Override
							public void run() {
								boardPanel.redraw(board);

							}

						});

					}
				}

				@Override
				public void mouseEntered(MouseEvent e) {

					SquarePanel currentSqrPanel = (SquarePanel) e.getSource();

					if (null != board.getSquare(row, col).getPiece()) {
						Square currentSqr = board.getSquare(row, col);
					
						if(currentSqr.getPiece().iconName().contains("obstacle"))
						{
							String toolTipText = "<html><b>obstacle</b> Can not be attacked.</html>";
							currentSqrPanel.setToolTipText(toolTipText);
						}
						else
						{	
						String toolTipText = "<html><b> Name:</b> " + currentSqr.getPiece().iconName()
								+ "<br /><b>Attack:</b> " + currentSqr.getPiece().getAttackPower() + "<br /><b>Defence:</b> "
								+ currentSqr.getPiece().getDefencePower() + "<br /><b>Move:</b> "
								+ currentSqr.getPiece().getMovePower()+"</html>";
						currentSqrPanel.setToolTipText(toolTipText);
						}
					}
				}


				@Override
				public void mouseExited(MouseEvent e) {
				}

			});

			validate();
		}

		public void drawSquare(Board board) {
			squareColor();
			try {
				squareIcon(board);
				validate();
				repaint();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		private void squareColor() {
			if ((this.row + this.col) % 2 == 1)
				setBackground(Color.black);
			else
				setBackground(Color.white);
		}

		private void squareIcon(final Board board) throws IOException {
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
}
