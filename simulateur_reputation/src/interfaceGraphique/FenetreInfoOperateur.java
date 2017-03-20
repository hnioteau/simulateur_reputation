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
	private JLabel nomOp;
	private JTextField nomOperator;

	private JLabel valCapacite;
	private JTextField valeurCapacite;

	private JLabel reputation;
	private JTextField reput;

	private JLabel probEchec;
	private JTextField probabiliteEchec;

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
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		mainPanel.setBackground(Color.white);

		JPanel subPanel1 = new JPanel();
		subPanel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		subPanel1.setBackground(Color.white);
		
		JPanel subPanel2 = new JPanel();
		subPanel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		subPanel2.setBackground(Color.white);
		
		JPanel subPanel3 = new JPanel();
		subPanel3.setLayout(new FlowLayout(FlowLayout.LEFT));
		subPanel3.setBackground(Color.white);
		
		JPanel subPanel4 = new JPanel();
		subPanel4.setLayout(new FlowLayout(FlowLayout.LEFT));
		subPanel4.setBackground(Color.white);
		
		
		nomOp = new JLabel("Nom de l'opérateur");
		subPanel1.add(nomOp);

		nomOperator = new JTextField();
		nomOperator.setColumns(10);
		nomOperator.setText("Operateur" + Main.listOp.size());
		subPanel1.add(nomOperator);
		
		mainPanel.add(subPanel1);

		valCapacite = new JLabel("Capacite de l'operateur");
		subPanel2.add(valCapacite);

		valeurCapacite = new JTextField();
		valeurCapacite.setColumns(10);
		valeurCapacite.setText("10000");
		subPanel2.add(valeurCapacite);
		
		mainPanel.add(subPanel2);

		reputation = new JLabel("Réputation");
		subPanel3.add(reputation);

		reput = new JTextField();
		reput.setColumns(10);
		reput.setText("0.5");
		subPanel3.add(reput);
		
		mainPanel.add(subPanel3);

		if (Main.simulation.getProbaEchecCase() == 1) {
			probEchec = new JLabel("Probilité échec");
			subPanel4.add(probEchec);

			probabiliteEchec = new JTextField();
			probabiliteEchec.setColumns(10);
			probabiliteEchec.setText("0.5");
			subPanel4.add(probabiliteEchec);
			
			mainPanel.add(subPanel4);
		}

		JButton confirmation = new JButton(new ButtonConfirmationOperateur(this, "Ok"));
		mainPanel.add(confirmation);
		
		return mainPanel;
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
