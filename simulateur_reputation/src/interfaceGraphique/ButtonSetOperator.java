package interfaceGraphique;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.SwingUtilities;

public class ButtonSetOperator extends AbstractAction {
	public ButtonSetOperator(InterfaceGraphique2 interfacegraphique, String texte) {
		super(texte);
	}

	public void actionPerformed(ActionEvent e) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FenetreInfoOp infoOp = new FenetreInfoOp();
				infoOp.setVisible(true);
			}
		});
	}

}