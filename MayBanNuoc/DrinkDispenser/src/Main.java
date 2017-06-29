import java.awt.EventQueue;

import controller.Controller;
import controller.ControllerInter;
import model.Model;
import model.ModelInter;
import view.View;

public class Main {
	public static void main(String[] args) {
		ModelInter data = new Model();
		ControllerInter controller = new Controller(data);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View(data, controller);
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
