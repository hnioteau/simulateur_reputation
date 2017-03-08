package interfaceGraphique;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import projet.Main;
import projet.Operator;

public class ButtonConfirmationOperateur extends AbstractAction {
	private FenetreInfoOperateur fenetreInfoOperateur;

	public ButtonConfirmationOperateur(FenetreInfoOperateur fenetreInfoOperateur, String string) {
		super(string);
		this.fenetreInfoOperateur = fenetreInfoOperateur;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Operator operateur;

		String valeurCapacite = fenetreInfoOperateur.getValeurCapacite().getText();
		int valeurCap = Integer.parseInt(valeurCapacite);

		String valeurReputation = fenetreInfoOperateur.getReputation().getText();
		double valeurReput = Double.parseDouble(valeurReputation);

		operateur = new Operator(valeurCap, valeurReput);

		Main.listOp.add(operateur);

		InterfaceGraphique2.setClientEtOperateur(InterfaceGraphique2.getClientEtoperateur() + "Operateur"
				+ Main.listOp.size() + " : Capacite de l'operateur " + operateur.getMaxCapacity()
				+ "     Reputation de l'operateur " + operateur.getReputation() + "\n");
		fenetreInfoOperateur.setVisible(false);

	}

}
