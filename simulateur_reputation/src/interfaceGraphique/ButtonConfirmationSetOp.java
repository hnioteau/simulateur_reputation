package interfaceGraphique;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import projet.Main;
import projet.Operator;

public class ButtonConfirmationSetOp extends AbstractAction {
	private FenetreInfoOp fenetreInfoOp;
	String text;
	String text2;

	public ButtonConfirmationSetOp(FenetreInfoOp fenetreInfoOp, String string) {
		super(string);
		this.fenetreInfoOp = fenetreInfoOp;
	}

	public void actionPerformed(ActionEvent e) {
		Operator operateur;
		text = InterfaceGraphique2.getClientEtoperateur();
		text2 = text.substring(0,text.indexOf("\n"));
		InterfaceGraphique2.setClientEtOperateur(text2+ "\n");

		for (int i = 0; i < Main.listOp.size(); ++i) {
			String nomOp = fenetreInfoOp.getNomOperateur().getText();

			String valeurCapacite = fenetreInfoOp.getValeurCapacite().getText();
			int valeurCap = Integer.parseInt(valeurCapacite);

			String valeurReputation = fenetreInfoOp.getReputation().getText();
			double valeurReput = Double.parseDouble(valeurReputation);

			operateur = new Operator(nomOp, valeurCap, valeurReput);

			if (Main.simulation.getProbaEchecCase() == 1) {
				String valeurProbaEchec = fenetreInfoOp.getProbaEchec().getText();
				double valeurProbabiliteEchec = Double.parseDouble(valeurProbaEchec);
				operateur.setProbaEchecfixe(valeurProbabiliteEchec);
			}

			if (Main.simulation.getProbaEchecCase() == 0) {
				InterfaceGraphique2.setClientEtOperateur(InterfaceGraphique2.getClientEtoperateur() + nomOp
						+ " : Capacite de l'operateur " + operateur.getMaxCapacity() + "     Reputation de l'operateur "
						+ operateur.getReputation() + "\n");
			}

			if (Main.simulation.getProbaEchecCase() == 1) {
				InterfaceGraphique2.setClientEtOperateur(InterfaceGraphique2.getClientEtoperateur() + nomOp
						+ " : Capacite de l'operateur " + operateur.getMaxCapacity() + "     Reputation de l'operateur "
						+ operateur.getReputation() + " probabilité d'échec " + operateur.getProbaEchecfixe() + "\n");

			}
		}
		fenetreInfoOp.setVisible(false);

	}

}
