package GUI;

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

		String rhoString = fenetreInfoRho.getValeurRho().getText();
		double rhoValue = Double.parseDouble(rhoString);

		Simulation.setRepFactor(rhoValue);
		InterfaceGraphique.setRho("Valeur de rho : " + Double.toString(rhoValue));

		fenetreInfoRho.setVisible(false);

	}
}
