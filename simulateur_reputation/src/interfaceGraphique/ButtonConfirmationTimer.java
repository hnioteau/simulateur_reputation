package interfaceGraphique;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import projet.Main;

public class ButtonConfirmationTimer extends AbstractAction {
	private FenetreInfoTimer fenetreInfoTimer;

	public ButtonConfirmationTimer(FenetreInfoTimer fenetreInfoTimer, String string) {
		super(string);
		this.fenetreInfoTimer = fenetreInfoTimer;
	}

	public void actionPerformed(ActionEvent e) {

		String timerSimulation = fenetreInfoTimer.getDureeSimulation().getText();
		int timer = Integer.parseInt(timerSimulation);

		Main.simulation.setSimulationTime(timer);
		InterfaceGraphique2.setTimer("Durée de la simulation : " + Integer.toString(timer));

		fenetreInfoTimer.setVisible(false);

	}
}
