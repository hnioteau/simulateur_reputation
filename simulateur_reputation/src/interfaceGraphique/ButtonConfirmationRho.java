package interfaceGraphique;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import projet.Simulation;

public class ButtonConfirmationRho extends AbstractAction {
	private FenetreInfoRho fenetreInfoRho;

	public ButtonConfirmationRho(FenetreInfoRho fenetreInfoRho, String string) {
		super(string);
		this.fenetreInfoRho = fenetreInfoRho;
	}

	public void actionPerformed(ActionEvent e) {

		String valRho = fenetreInfoRho.getValeurRho().getText();
		double valeurRho = Double.parseDouble(valRho);

		Simulation.setRepFactor(valeurRho);
		InterfaceGraphique2.setRho("Valeur de rho : " + Double.toString(valeurRho));

		fenetreInfoRho.setVisible(false);

	}
}
