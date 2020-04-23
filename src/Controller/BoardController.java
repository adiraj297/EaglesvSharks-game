package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Model.Game;

/**
 * @author mohammed
 *
 */
public class BoardController implements ActionListener{
	
	private Game game = new Game();

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton src = (JButton) e.getSource();
		
		//start game
		if(src instanceof JButton && src.getText() == "Start The Game") {
			game.startGame();
			src.setVisible(false);
		}

	}

	

}
