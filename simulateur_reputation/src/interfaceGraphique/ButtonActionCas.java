package interfaceGraphique;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.SwingUtilities;

import projet.Main;

public class ButtonActionCas extends AbstractAction {

	public ButtonActionCas(InterfaceGraphique2 interfacegraphique, String texte) {
		super(texte);
	}

	public void actionPerformed(ActionEvent e) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				if(Main.simulation.getUseCase() == 0)
					Main.simulation.setUseCase(1);
				if(Main.simulation.getUseCase() == 1)
					Main.simulation.setUseCase(0);
				System.out.println(Main.simulation.getUseCase());
				if(Main.simulation.getUseCase() == 0)
					InterfaceGraphique2.getUseCase().setText("Tous les opérateurs sont éligible");
				if(Main.simulation.getUseCase() == 1)
					InterfaceGraphique2.getUseCase().setText("seul les opérateurs qui ont assez de capacité sont éligible");
			}
		});
	}

}
