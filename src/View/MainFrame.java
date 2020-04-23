package View;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author mohammed
 *
 */
public class MainFrame extends JFrame{

	public MainFrame() {
//		JFrame f=new JFrame();//creating instance of JFrame 
		super();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
		JPanel gridP = new GridPanel();
		JPanel statusP = new StatusPanel();
		JPanel player1P = new Player1Panel();
		JPanel player2P = new Player1Panel();
		
		add(gridP, BorderLayout.CENTER);
		add(statusP, BorderLayout.WEST);
//		add(player2P, BorderLayout.SOUTH); //PLAYER2 STATUS
//		add(player1P, BorderLayout.NORTH); //PLAYER1 STATUS
		
		
		setSize(1200,1000);//400 width and 500 height  
//		add(statusP);
//        add(gridP);
//        pack();
//        setLocationByPlatform(true);
        setVisible(true);
	}

}
