package interfaceGraphique;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.SwingUtilities;

public class ButtonSetRho extends AbstractAction {
	public ButtonSetRho(InterfaceGraphique2 interfacegraphique, String texte) {
		super(texte);
	}

	public void actionPerformed(ActionEvent e) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FenetreInfoRho infoRho = new FenetreInfoRho();
				infoRho.setVisible(true);
			}
		});
	}

}
