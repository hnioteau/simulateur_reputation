package interfaceGraphique;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.SwingUtilities;

public class ButtonActionClient extends AbstractAction {
	public ButtonActionClient(InterfaceGraphique2 interfacegraphique, String texte) {
		super(texte);
	}

	public void actionPerformed(ActionEvent e) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FenetreInfoClient infoClient = new FenetreInfoClient();
				infoClient.setVisible(true);
			}
		});
	}

}
