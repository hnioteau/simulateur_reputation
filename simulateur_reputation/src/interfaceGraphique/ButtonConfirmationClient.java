package interfaceGraphique;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import projet.Main;

public class ButtonConfirmationClient extends AbstractAction {
	private FenetreInfoClient fenetreInfoClient;
	String textClient;
	String textClient2;

	public ButtonConfirmationClient(FenetreInfoClient fenetreInfoClient, String string) {
		super(string);
		this.fenetreInfoClient = fenetreInfoClient;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String valeurTailleRequete = fenetreInfoClient.getValeurRequete().getText();
		int valeurTaille = Integer.parseInt(valeurTailleRequete);
		Main.client.setWeight(valeurTaille);

		String valeurDureeRequete = fenetreInfoClient.getDureeRequete().getText();
		int valeurDuree = Integer.parseInt(valeurDureeRequete);
		Main.client.setDuration(valeurDuree);

		textClient = InterfaceGraphique2.getClientEtoperateur();
		textClient2 = textClient.substring(textClient.indexOf("\n"), textClient.length());
		textClient = "Client : Duree de la requete " + Main.client.getDuration() + "     Taille de la requete "
				+ Main.client.getWeight() + textClient2;
		InterfaceGraphique2.setClientEtOperateur(textClient);
		// InterfaceGraphique2.setClientEtOperateur(
		// "Client : Duree de la requete " + Main.client.getDuration() + "
		// Taille de la requete "
		// + Main.client.getWeight() + "\n" +
		// InterfaceGraphique2.getClientEtoperateur());
		fenetreInfoClient.setVisible(false);

	}

}
