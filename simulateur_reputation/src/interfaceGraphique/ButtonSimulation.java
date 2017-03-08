package interfaceGraphique;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.SwingUtilities;

import projet.Main;
import projet.Simulation;

public class ButtonSimulation extends AbstractAction {

	public ButtonSimulation(InterfaceGraphique2 interfacegraphique, String texte) {
		super(texte);
	}

	public void actionPerformed(ActionEvent e) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Main.simulation.setSimulationTime(20);
		    	Main.simulation.runSimulation();
			}
		});
	}

}
