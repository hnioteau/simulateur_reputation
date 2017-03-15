package interfaceGraphique;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import projet.Main;

public class FenetreInfoOp extends JFrame {
	/**
	 * 
	 */
	private JLabel nomOp;
	private JTextField nomOperator;

	private JLabel valCapacite;
	private JTextField valeurCapacite;

	private JLabel reputation;
	private JTextField reput;

	private JLabel probEchec;
	private JTextField probabiliteEchec;

	public FenetreInfoOp() {
		super();
		build();
	}

	private void build() {
		setTitle("Modifier Operateur");
		setSize(600, 200);
		setResizable(false);
		setContentPane(buildContentPane());

	}

	private JPanel buildContentPane() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setBackground(Color.white);

		for (int i = 0; i < Main.listOp.size(); i++) {
			nomOp = new JLabel("Nom de l'opérateur");
			panel.add(nomOp);
			
			nomOperator = new JTextField();
			nomOperator.setColumns(10);
			nomOperator.setText(Main.listOp.get(i).getName());
			panel.add(nomOperator);

			valCapacite = new JLabel("\nCapacite de l'operateur");
			panel.add(valCapacite);

			valeurCapacite = new JTextField();
			valeurCapacite.setColumns(10);
			valeurCapacite.setText(Integer.toString(Main.listOp.get(i).getCapacity()));
			panel.add(valeurCapacite);

			reputation = new JLabel("\nRéputation");
			panel.add(reputation);

			reput = new JTextField();
			reput.setColumns(10);
			reput.setText(Double.toString(Main.listOp.get(i).getReputationInit()));
			panel.add(reput);

			if (Main.simulation.getProbaEchecCase() == 1) {
				probEchec = new JLabel("\nProbilité échec");
				panel.add(probEchec);

				probabiliteEchec = new JTextField();
				probabiliteEchec.setColumns(10);
				probabiliteEchec.setText(Double.toString(Main.listOp.get(i).getProbaEchecfixe()));
				panel.add(probabiliteEchec);
			}
		}

		JButton confirmation = new JButton(new ButtonConfirmationSetOp(this, "Ok"));
		panel.add(confirmation);

		return panel;
	}

	public JTextField getValeurCapacite() {
		return valeurCapacite;
	}

	public JTextField getReputation() {
		return reput;
	}

	public JTextField getNomOperateur() {
		return nomOperator;
	}

	public JTextField getProbaEchec() {
		return probabiliteEchec;
	}
}