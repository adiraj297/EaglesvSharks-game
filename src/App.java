import javax.swing.SwingUtilities;

import Controller.GameController;

/**
 * @author mohammed
 *
 */
public class App {

	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
			public void run() {
            	new GameController();
            }
        });
	}

}
