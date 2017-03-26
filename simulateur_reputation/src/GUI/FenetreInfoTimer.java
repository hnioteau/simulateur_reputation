package GUI;

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
	private JLabel simulationTimeLabel;
	private JTextField simulationTimeTF;

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

		simulationTimeLabel = new JLabel("Duree de la simulation");
		panel.add(simulationTimeLabel);

		simulationTimeTF = new JTextField();
		simulationTimeTF.setColumns(10);
		simulationTimeTF.setText(Integer.toString(Main.simulation.getSimulationTime()));
		panel.add(simulationTimeTF);

		JButton confirmation = new JButton(new ButtonConfirmationTimer(this, "Ok"));
		panel.add(confirmation);

		return panel;
	}

	public JTextField getDureeSimulation() {
		return simulationTimeTF;
	}
}