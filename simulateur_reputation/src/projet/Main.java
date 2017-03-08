package projet;

import java.util.ArrayList;

import javax.swing.SwingUtilities;

import interfaceGraphique.InterfaceGraphique2;

public class Main {
	public static Client client = new Client();
	public static ArrayList<Operator> listOp = new ArrayList<Operator>();

	public static void main(String[] args) {
		// InterfaceGraphique interfaceGraphique = new InterfaceGraphique();
		// interfaceGraphique.setTitle("Simulateur Reputation");
		// interfaceGraphique.setSize(640, 360);
		// interfaceGraphique.setLocationRelativeTo(null);
		// interfaceGraphique.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// interfaceGraphique.setVisible(true);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				InterfaceGraphique2 interfaceGraphique = new InterfaceGraphique2();
				interfaceGraphique.setVisible(true);
			}
		});
	}

}