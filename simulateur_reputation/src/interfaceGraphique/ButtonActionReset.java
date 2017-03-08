package interfaceGraphique;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.SwingUtilities;

import projet.Main;

public class ButtonActionReset extends AbstractAction {

	public ButtonActionReset(InterfaceGraphique2 interfacegraphique, String texte) {
		super(texte);
	}

	public void actionPerformed(ActionEvent e) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				InterfaceGraphique2.setClientEtOperateur("");
				Main.listOp.clear();
			}
		});
	}

}
