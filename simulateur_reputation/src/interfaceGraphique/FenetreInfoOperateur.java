package interfaceGraphique;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import projet.Main;

public class FenetreInfoOperateur extends JFrame {
	/**
	 * 
	 */
	private JLabel valCapacite;
	private JTextField valeurCapacite;

	private JLabel reputation;
	private JTextField reput;

	public FenetreInfoOperateur() {
		super();
		build();
	}

	private void build() {
		setTitle("Info opérateur");
		setSize(400, 200);
		setResizable(false);
		setContentPane(buildContentPane());

	}


	private JPanel buildContentPane() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setBackground(Color.white);

		valCapacite = new JLabel("Capacite de l'operateur");
		panel.add(valCapacite);

		valeurCapacite = new JTextField();
		valeurCapacite.setColumns(10);
		valeurCapacite.setText("10000");
		panel.add(valeurCapacite);

		reputation = new JLabel("Réputation");
		panel.add(reputation);

		reput = new JTextField();
		reput.setColumns(10);
		reput.setText("0.5");
		panel.add(reput);

		JButton confirmation = new JButton(new ButtonConfirmationOperateur(this, "Ok"));
		panel.add(confirmation);

		return panel;
	}

	public JTextField getValeurCapacite() {
		return valeurCapacite;
	}

	public JTextField getReputation() {
		return reput;
	}
}
