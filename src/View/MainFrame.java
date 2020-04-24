package View;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author mohammed
 *
 */
public class MainFrame extends JFrame{
	
	public GridPanel board;

	public MainFrame() {
		super();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
		board = new GridPanel();
		JPanel statusP = new StatusPanel();
		
		add(board, BorderLayout.CENTER);
		add(statusP, BorderLayout.WEST);

		setSize(1200,1000);
        setVisible(true);
	}

}
