package interfaceGraphique;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.SwingUtilities;

import projet.Main;

public class ButtonActionProbaEchec extends AbstractAction {

	public ButtonActionProbaEchec(InterfaceGraphique2 interfacegraphique, String texte) {
		super(texte);
	}

	public void actionPerformed(ActionEvent e) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				if (Main.simulation.getProbaEchecCase() == 0) {
					Main.simulation.setProbaEchecCase(1);
				} else
					Main.simulation.setProbaEchecCase(0);

				if (Main.simulation.getProbaEchecCase() == 0)
					InterfaceGraphique2.getProbaCase().setText("Probabilité d'échec en fonction de la formule");

				if (Main.simulation.getProbaEchecCase() == 1)
					InterfaceGraphique2.getProbaCase().setText("Probabilité d'échec fixe pour chaque opérateur");
			}
		});
	}

}
