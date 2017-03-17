package interfaceGraphique;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import projet.Main;

public class FenetreInfoRho extends JFrame {
	/**
	 * 
	 */
	private JLabel valRho;
	private JTextField valeurRho;

	public FenetreInfoRho() {
		super();
		build();
	}

	private void build() {
		setTitle("Valeur de rho");
		setSize(400, 200);
		setResizable(false);
		setContentPane(buildContentPane());

	}

	private JPanel buildContentPane() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setBackground(Color.white);

		valRho = new JLabel("Valeur de rho");
		panel.add(valRho);

		valeurRho = new JTextField();
		valeurRho.setColumns(10);
		valeurRho.setText(Double.toString(Main.simulation.getRepFactor()));
		panel.add(valeurRho);

		JButton confirmation = new JButton(new ButtonConfirmationRho(this, "Ok"));
		panel.add(confirmation);

		return panel;
	}

	public JTextField getValeurRho() {
		return valeurRho;
	}

}