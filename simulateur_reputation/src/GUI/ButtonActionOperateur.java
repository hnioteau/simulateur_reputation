package GUI;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.SwingUtilities;

public class ButtonActionOperateur extends AbstractAction {
	public ButtonActionOperateur(InterfaceGraphique interfacegraphique, String texte) {
		super(texte);
	}

	public void actionPerformed(ActionEvent e) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FenetreInfoOperateur infoOperateur = new FenetreInfoOperateur();
				infoOperateur.setVisible(true);
			}
		});
	}

}
