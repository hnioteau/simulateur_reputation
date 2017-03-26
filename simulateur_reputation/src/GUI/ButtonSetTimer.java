package GUI;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.SwingUtilities;

public class ButtonSetTimer extends AbstractAction {
	public ButtonSetTimer(InterfaceGraphique interfacegraphique, String texte) {
		super(texte);
	}

	public void actionPerformed(ActionEvent e) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FenetreInfoTimer infoTimer = new FenetreInfoTimer();
				infoTimer.setVisible(true);
			}
		});
	}

}
