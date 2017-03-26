package GUI;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import projet.Main;

public class ButtonConfirmationClient extends AbstractAction {
	private FenetreInfoClient fenetreInfoClient;
	String clientStr;
	String client2Str;

	public ButtonConfirmationClient(FenetreInfoClient fenetreInfoClient, String string) {
		super(string);
		this.fenetreInfoClient = fenetreInfoClient;
	}

	//@Override
	public void actionPerformed(ActionEvent arg0) {
		String requestWeightValue = fenetreInfoClient.getRequestValue().getText();
		int weightValue = Integer.parseInt(requestWeightValue);
		Main.client.setWeight(weightValue);

		String requestDurationStr = fenetreInfoClient.getRequestDuration().getText();
		int requestDurationValue = Integer.parseInt(requestDurationStr);
		Main.client.setDuration(requestDurationValue);

		clientStr = InterfaceGraphique.getClientAndOperator();
		client2Str = clientStr.substring(clientStr.indexOf("\n"), clientStr.length());
		clientStr = "Client : Duree de la requete " + Main.client.getDuration() + "     Taille de la requete "
				+ Main.client.getWeight() + client2Str;
		InterfaceGraphique.setClientAndOperator(clientStr);
		fenetreInfoClient.setVisible(false);

	}

}
