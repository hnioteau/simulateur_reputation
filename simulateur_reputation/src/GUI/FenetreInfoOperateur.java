package GUI;

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
	private JLabel opNameLabel;
	private JTextField opNameTF;

	private JLabel capacityLabel;
	private JTextField capacityTF;

	private JLabel reputationLabel;
	private JTextField reputationTF;

	private JLabel failChanceLabel;
	private JTextField failChanceTF;

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
		
		
		opNameLabel = new JLabel("Nom de l'opérateur");
		subPanel1.add(opNameLabel);

		opNameTF = new JTextField();
		opNameTF.setColumns(10);
		opNameTF.setText("Operateur" + Main.listOp.size());
		subPanel1.add(opNameTF);
		
		mainPanel.add(subPanel1);

		capacityLabel = new JLabel("Capacite de l'operateur");
		subPanel2.add(capacityLabel);

		capacityTF = new JTextField();
		capacityTF.setColumns(10);
		capacityTF.setText("10000");
		subPanel2.add(capacityTF);
		
		mainPanel.add(subPanel2);

		reputationLabel = new JLabel("Réputation");
		subPanel3.add(reputationLabel);

		reputationTF = new JTextField();
		reputationTF.setColumns(10);
		reputationTF.setText("0.5");
		subPanel3.add(reputationTF);
		
		mainPanel.add(subPanel3);

		if (Main.simulation.getFailChanceCase() == 1) {
			failChanceLabel = new JLabel("Probilité échec");
			subPanel4.add(failChanceLabel);

			failChanceTF = new JTextField();
			failChanceTF.setColumns(10);
			failChanceTF.setText("0.5");
			subPanel4.add(failChanceTF);
			
			mainPanel.add(subPanel4);
		}

		JButton confirmation = new JButton(new ButtonConfirmationOperateur(this, "Ok"));
		mainPanel.add(confirmation);
		
		return mainPanel;
	}

	public JTextField getValeurCapacite() {
		return capacityTF;
	}

	public JTextField getReputation() {
		return reputationTF;
	}

	public JTextField getNomOperateur() {
		return opNameTF;
	}

	public JTextField getProbaEchec() {
		return failChanceTF;
	}
}
