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
		text = InterfaceGraphique2.getClientEtoperateur();
		text2 = text.substring(0, text.indexOf("\n"));
		InterfaceGraphique2.setClientEtOperateur(text2 + "\n");

		for (int i = 0; i < Main.listOp.size(); ++i) {
			if (i == fenetreInfoOp.getOperateurChoisi()) {
				String nomOp = fenetreInfoOp.getNomOperateur().getText();
				Main.listOp.get(i).setName(nomOp);

				String valeurCapacite = fenetreInfoOp.getValeurCapacite().getText();
				int valeurCap = Integer.parseInt(valeurCapacite);
				Main.listOp.get(i).setCapacity(valeurCap);
				Main.listOp.get(i).setMaxCapacity(valeurCap);

				String valeurReputation = fenetreInfoOp.getReputation().getText();
				double valeurReput = Double.parseDouble(valeurReputation);
				Main.listOp.get(i).setReputationInit(valeurReput);
				Main.listOp.get(i).setReputation(valeurReput);

				if (Main.simulation.getProbaEchecCase() == 1) {
					String valeurProbaEchec = fenetreInfoOp.getProbaEchec().getText();
					double valeurProbabiliteEchec = Double.parseDouble(valeurProbaEchec);
					Main.listOp.get(i).setProbaEchecfixe(valeurProbabiliteEchec);
				}

				if (Main.simulation.getProbaEchecCase() == 0) {
					InterfaceGraphique2.setClientEtOperateur(InterfaceGraphique2.getClientEtoperateur()
							+ Main.listOp.get(i).getName() + " : Capacite de l'operateur "
							+ Main.listOp.get(i).getMaxCapacity() + "     Reputation de l'operateur "
							+ Main.listOp.get(i).getReputationInit() + "\n");
				}

				if (Main.simulation.getProbaEchecCase() == 1) {
					InterfaceGraphique2.setClientEtOperateur(
							InterfaceGraphique2.getClientEtoperateur() + Main.listOp.get(i).getName()
									+ " : Capacite de l'operateur " + Main.listOp.get(i).getMaxCapacity()
									+ "     Reputation de l'operateur " + Main.listOp.get(i).getReputationInit()
									+ " probabilité d'échec " + Main.listOp.get(i).getProbaEchecfixe() + "\n");

				}
			} else {
				if (Main.simulation.getProbaEchecCase() == 0) {
					InterfaceGraphique2.setClientEtOperateur(InterfaceGraphique2.getClientEtoperateur()
							+ Main.listOp.get(i).getName() + " : Capacite de l'operateur "
							+ Main.listOp.get(i).getMaxCapacity() + "     Reputation de l'operateur "
							+ Main.listOp.get(i).getReputationInit() + "\n");
				}

				if (Main.simulation.getProbaEchecCase() == 1) {
					InterfaceGraphique2.setClientEtOperateur(
							InterfaceGraphique2.getClientEtoperateur() + Main.listOp.get(i).getName()
									+ " : Capacite de l'operateur " + Main.listOp.get(i).getMaxCapacity()
									+ "     Reputation de l'operateur " + Main.listOp.get(i).getReputationInit()
									+ " probabilité d'échec " + Main.listOp.get(i).getProbaEchecfixe() + "\n");

				}
			}
		
		}
		fenetreInfoOp.setVisible(false);

	}

}
