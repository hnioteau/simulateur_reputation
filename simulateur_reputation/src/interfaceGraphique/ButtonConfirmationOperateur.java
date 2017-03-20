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

		String nomOp = fenetreInfoOperateur.getNomOperateur().getText();

		String valeurCapacite = fenetreInfoOperateur.getValeurCapacite().getText();
		int valeurCap = Integer.parseInt(valeurCapacite);

		String valeurReputation = fenetreInfoOperateur.getReputation().getText();
		double valeurReput = Double.parseDouble(valeurReputation);

		operateur = new Operator(nomOp, valeurCap, valeurReput);

		if (Main.simulation.getProbaEchecCase() == 1) {
			String valeurProbaEchec = fenetreInfoOperateur.getProbaEchec().getText();
			double valeurProbabiliteEchec = Double.parseDouble(valeurProbaEchec);
			operateur.setProbaEchecfixe(valeurProbabiliteEchec);
		}

		Main.listOp.add(operateur);
		System.out.println(Main.listOp.get(Main.listOp.size() - 1).getName() + " réputation initiale : "
				+ Main.listOp.get(Main.listOp.size() - 1).getReputationInit() + " capacité initiale : "
				+ Main.listOp.get(Main.listOp.size() - 1).getCapacity());

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

		fenetreInfoOperateur.setVisible(false);

	}

}
