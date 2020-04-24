package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


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
	    		JButton b=new JButton(); 
	    		
	    		if((i+j)%2==1) b.setBackground(Color.black);
	    		else b.setBackground(Color.white);
	            b.setOpaque(true);
	            b.setBorderPainted(false);
	            
                squares[i][j] = b;
                
                add(b);
		    }
	    }
        
        squares[0][2].setIcon(scaleImage(new ImageIcon(this.getClass().getResource("/resources/shark1.jpg"))));
		squares[0][4].setIcon(scaleImage(new ImageIcon(this.getClass().getResource("/resources/shark2.png"))));
		squares[0][6].setIcon(scaleImage(new ImageIcon(this.getClass().getResource("/resources/shark3.png"))));
		squares[0][8].setIcon(scaleImage(new ImageIcon(this.getClass().getResource("/resources/shark4.png"))));
		squares[0][10].setIcon(scaleImage(new ImageIcon(this.getClass().getResource("/resources/shark5.png"))));
		
		squares[11][1].setIcon(scaleImage(new ImageIcon(this.getClass().getResource("/resources/eagle1.png"))));
		squares[11][3].setIcon(scaleImage(new ImageIcon(this.getClass().getResource("/resources/eagle2.png"))));
		squares[11][5].setIcon(scaleImage(new ImageIcon(this.getClass().getResource("/resources/eagle3.png"))));
		squares[11][7].setIcon(scaleImage(new ImageIcon(this.getClass().getResource("/resources/eagle4.png"))));
		squares[11][9].setIcon(scaleImage(new ImageIcon(this.getClass().getResource("/resources/eagle5.png"))));
    }
    

    public void onPressSquare(ActionListener e) {
	    for(int i = 0; i < 12; i++) {
	    	for(int j = 0; j < 12; j++) {
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
