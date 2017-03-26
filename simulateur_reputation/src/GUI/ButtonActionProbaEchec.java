package GUI;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.SwingUtilities;

import projet.Main;

public class ButtonActionProbaEchec extends AbstractAction {

	public ButtonActionProbaEchec(InterfaceGraphique interfacegraphique, String texte) {
		super(texte);
	}

	public void actionPerformed(ActionEvent e) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				if (Main.simulation.getFailChanceCase() == 0) {
					Main.simulation.setFailChanceCase(1);
				} else
					Main.simulation.setFailChanceCase(0);

				if (Main.simulation.getFailChanceCase() == 0)
					InterfaceGraphique.getFailChanceCase().setText("Probabilité d'échec en fonction de la formule");

				if (Main.simulation.getFailChanceCase() == 1)
					InterfaceGraphique.getFailChanceCase().setText("Probabilité d'échec fixe pour chaque opérateur");
			}
		});
	}

}
