package interfaceGraphique;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.SwingUtilities;

import projet.Simulation;

public class ButtonSimulation extends AbstractAction {
	Simulation simulation;
	public ButtonSimulation(InterfaceGraphique2 interfacegraphique, String texte) {
		super(texte);
	}

	public void actionPerformed(ActionEvent e) {
		simulation = new Simulation();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				simulation.setSimulationTime(20);
		    	simulation.runSimulation();
			}
		});
	}

}
