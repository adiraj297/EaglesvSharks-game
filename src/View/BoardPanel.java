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

import Controller.GameController;
import Model.Board;
import Model.Square;
import Model.Piece.Piece;


/**
 * @author mohammed
 *
 */
public class BoardPanel extends JPanel{
	
	final List<SquarePanel> boardSquares; 
	
	Board board;
	final GameController controller;
	
	private Square srcSquare;
	private Square targetSquare;
	private Piece selectedPiece;
	

	public BoardPanel(Board board, GameController controller) {
		
		this.board = board;
		this.controller = controller;
		
		this.boardSquares = new ArrayList<SquarePanel>();
		setLayout(null);
		
		
		drawBoard();
		
//		onPressSquare();
		
		setLayout(new GridLayout(12,12, 0, 0));
		setPreferredSize(new Dimension(1000, 1000));
	}
	
    public void drawBoard() {
	    for(int i = 0; i < 12; i++) {
	    	for(int j = 0; j < 12; j++) {
	    		final SquarePanel squarePanel = new SquarePanel(this, i, j);
	    		boardSquares.add(squarePanel);
	    		

                
                add(squarePanel); 
		    }
	    }
        
    }
    
	public void redraw(Board board) {
		removeAll();
		for(SquarePanel sqrPanel: boardSquares) {
			sqrPanel.drawSquare(board);
			add(sqrPanel);
		}
		validate();
		repaint();
	}

    
    
    private class SquarePanel extends JPanel{
    	private final int row;
    	private final int col;
    	
    	SquarePanel(final BoardPanel boardPanel, final int row, final int col){
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
				public void mousePressed(MouseEvent e) {}

				@Override
				public void mouseReleased(MouseEvent e) {
					if(SwingUtilities.isRightMouseButton(e)) {
						System.out.println("piece deselected");
						srcSquare = null;
						targetSquare = null;
						selectedPiece = null;
					}else if(SwingUtilities.isLeftMouseButton(e)) {
						if(srcSquare == null) {
							
							srcSquare = board.getSquare(row, col);
							selectedPiece = srcSquare.getPiece();
							if(selectedPiece == null) {
								srcSquare = null;
								
							}else
								System.out.println("first piece selected");
						}else {
							System.out.println("second piece selected");
							targetSquare = board.getSquare(row, col);
							controller.movePiece(srcSquare, targetSquare);
							srcSquare = null;
							targetSquare = null;
							selectedPiece = null;
							boardPanel.revalidate();
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
				public void mouseEntered(MouseEvent e) {}

				@Override
				public void mouseExited(MouseEvent e) {}
    			
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
    	private void squareColor() {
    		if((this.row+this.col)%2==1) setBackground(Color.black);
    		else setBackground(Color.white);
    	}
    	
    	private void squareIcon(final Board board) throws IOException {
    		removeAll();
    		Piece piece = board.getSquare(this.row, this.col).getPiece();
    		if(piece != null) {    		
				ImageIcon icon = scaleImage(new ImageIcon(this.getClass().getResource("/resources/" + piece.iconName() +".png")));
				add(new JLabel(icon));
    		}
    	}
    	
        private ImageIcon scaleImage(ImageIcon icon) {
        	Image img = icon.getImage();
        	Image resizedImage = img.getScaledInstance(75, 75,  java.awt.Image.SCALE_SMOOTH);
        	return new ImageIcon(resizedImage);
        }
    	
    }
    
    private class BoardMouseListener implements MouseListener{

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
