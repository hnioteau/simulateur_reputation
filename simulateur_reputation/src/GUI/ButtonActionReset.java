package GUI;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.SwingUtilities;

import projet.Main;

public class ButtonActionReset extends AbstractAction {

	public ButtonActionReset(InterfaceGraphique interfacegraphique, String texte) {
		super(texte);
	}

	public void actionPerformed(ActionEvent e) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				InterfaceGraphique.setClientAndOperator("Client : Duree de la requete " + Main.client.getDuration()
						+ "     Taille de la requete " + Main.client.getWeight() + "\n");
				Main.listOp.clear();
			}
		});
	}

}
