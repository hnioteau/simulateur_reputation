package projet;

import java.util.ArrayList;

import javax.swing.SwingUtilities;

import interfaceGraphique.InterfaceGraphique2;

public class Main {
	public static Client client = new Client();
	public static ArrayList<Operator> listOp = new ArrayList<Operator>();
	public static Simulation simulation = new Simulation();

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				InterfaceGraphique2 interfaceGraphique = new InterfaceGraphique2();
				interfaceGraphique.setVisible(true);
			}
		});
	}

}