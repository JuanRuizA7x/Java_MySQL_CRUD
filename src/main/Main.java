package main;

import controller.Controller;
import view.View;

/**
 * @author juan_ruiz
 *
 */
public class Main {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		View view = new View();
		new Controller(view);
		view.setTitle("CRUD MySQL");
		view.setLocationRelativeTo(null);
		view.setVisible(true);
	}

}
