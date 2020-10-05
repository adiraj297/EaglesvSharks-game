import javax.swing.SwingUtilities;

import Controller.MenuController;

/**
 * @author Aditya Raj
 *
 */
public class App {

	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
			public void run() {
            	new MenuController();
            }
        });
	}

}
