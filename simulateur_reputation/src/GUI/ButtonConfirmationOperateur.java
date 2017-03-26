package GUI;

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

	//@Override
	public void actionPerformed(ActionEvent e) {
		Operator operator;

		String opName = fenetreInfoOperateur.getNomOperateur().getText();

		String capacityStr = fenetreInfoOperateur.getValeurCapacite().getText();
		int capacityValue = Integer.parseInt(capacityStr);

		String reputationStr = fenetreInfoOperateur.getReputation().getText();
		double reputationValue = Double.parseDouble(reputationStr);

		operator = new Operator(opName, capacityValue, reputationValue);

		if (Main.simulation.getFailChanceCase() == 1) {
			String failChanceStr = fenetreInfoOperateur.getProbaEchec().getText();
			double failChanceValue = Double.parseDouble(failChanceStr);
			operator.setFixedFailChance(failChanceValue);
		}

		Main.listOp.add(operator);
		
		/*System.out.println(Main.listOp.get(Main.listOp.size() - 1).getName() + " réputation initiale : "
				+ Main.listOp.get(Main.listOp.size() - 1).getReputationInit() + " capacité initiale : "
				+ Main.listOp.get(Main.listOp.size() - 1).getCapacity());
*/
		if (Main.simulation.getFailChanceCase() == 0) {
			InterfaceGraphique.setClientAndOperator(InterfaceGraphique.getClientAndOperator() + opName
					+ " : Capacite de l'operateur " + operator.getMaxCapacity() + "     Reputation de l'operateur "
					+ operator.getReputation() + "\n");
		}

		if (Main.simulation.getFailChanceCase() == 1) {
			InterfaceGraphique.setClientAndOperator(InterfaceGraphique.getClientAndOperator() + opName
					+ " : Capacite de l'operateur " + operator.getMaxCapacity() + "     Reputation de l'operateur "
					+ operator.getReputation() + " Probabilité d'échec " + operator.getFixedFailChance() + "\n");

		}

		fenetreInfoOperateur.setVisible(false);

	}

}
