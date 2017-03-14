package interfaceGraphique;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import projet.Main;

public class FenetreInfoTimer extends JFrame {
	/**
	 * 
	 */
	private JLabel durSimulation;
	private JTextField dureeSimulation;

	public FenetreInfoTimer() {
		super();
		build();
	}

	private void build() {
		setTitle("Info durée simulation");
		setSize(400, 200);
		setResizable(false);
		setContentPane(buildContentPane());

	}

	private JPanel buildContentPane() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setBackground(Color.white);

		durSimulation = new JLabel("Duree de la simulation");
		panel.add(durSimulation);

		dureeSimulation = new JTextField();
		dureeSimulation.setColumns(10);
		dureeSimulation.setText(Integer.toString(Main.simulation.getSimulationTime()));
		panel.add(dureeSimulation);

		JButton confirmation = new JButton(new ButtonConfirmationTimer(this, "Ok"));
		panel.add(confirmation);

		return panel;
	}

	public JTextField getDureeSimulation() {
		return dureeSimulation;
	}
}