package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Model.Player;
import Model.Piece.Eagle1;
import Model.Piece.Eagle2;
import Model.Piece.Eagle3;
import Model.Piece.Eagle4;
import Model.Piece.Eagle5;
import Model.Piece.Shark1;
import Model.Piece.Shark2;
import Model.Piece.Shark3;
import Model.Piece.Shark4;
import Model.Piece.Shark5;


/**
 * @author mohammed
 *
 */
public class GridPanel extends JPanel{
	
	private JButton[][] squares;

	public GridPanel() {
		setLayout(null);
		
		squares = new JButton[12][12];
		
		drawBoard();
		
		setLayout(new GridLayout(12,12, 0, 0));
		setPreferredSize(new Dimension(1000, 1000));
	}
	
    public void drawBoard() {
	    for(int i = 0; i < 12; i++) {
	    	for(int j = 0; j < 12; j++) {
	    		JButton b=new JButton(i+","+j); 
	    		
	    		if((i+j)%2==1) b.setBackground(Color.black);
	    		else b.setBackground(Color.white);
	            b.setOpaque(true);
	            b.setBorderPainted(false);
	            
                squares[i][j] = b;
                
                add(b);
		    }
	    }
        
        squares[0][2].setIcon(scaleImage(new ImageIcon(this.getClass().getResource("/resources/shark1.jpg"))));
		squares[0][3].setIcon(scaleImage(new ImageIcon(this.getClass().getResource("/resources/shark2.jpg"))));
		squares[0][4].setIcon(scaleImage(new ImageIcon(this.getClass().getResource("/resources/shark3.jpg"))));
		squares[0][5].setIcon(scaleImage(new ImageIcon(this.getClass().getResource("/resources/shark4.jpg"))));
		squares[0][6].setIcon(scaleImage(new ImageIcon(this.getClass().getResource("/resources/shark5.jpg"))));
		
		squares[11][2].setIcon(scaleImage(new ImageIcon(this.getClass().getResource("/resources/eagle1.jpg"))));
		squares[11][3].setIcon(scaleImage(new ImageIcon(this.getClass().getResource("/resources/eagle2.jpg"))));
		squares[11][4].setIcon(scaleImage(new ImageIcon(this.getClass().getResource("/resources/eagle3.jpg"))));
		squares[11][5].setIcon(scaleImage(new ImageIcon(this.getClass().getResource("/resources/eagle4.jpg"))));
		squares[11][6].setIcon(scaleImage(new ImageIcon(this.getClass().getResource("/resources/eagle5.jpg"))));
    }
    

    public void onPressSquare(ActionListener e) {
	    for(int i = 0; i < 12; i++) {
	    	for(int j = 0; j < 12; j++) {
	    		if(squares[i][j].getIcon() == null)
	    			squares[i][j].addActionListener(e);
	    	}
	    }
    }
    
    public void onPressPiece(ActionListener e) {
	    for(int i = 0; i < 12; i++) {
	    	for(int j = 0; j < 12; j++) {
	    		if(squares[i][j].getIcon() != null)
	    			squares[i][j].addActionListener(e);
	    	}
	    }
    }
    
    private ImageIcon scaleImage(ImageIcon icon) {
    	Image img = icon.getImage();
    	Image resizedImage = img.getScaledInstance(75, 75,  java.awt.Image.SCALE_SMOOTH);
    	return new ImageIcon(resizedImage);
    }

}
