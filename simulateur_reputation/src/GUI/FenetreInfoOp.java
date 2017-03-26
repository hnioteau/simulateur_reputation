package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import projet.Main;

public class FenetreInfoOp extends JFrame {
	/**
	 * 
	 */
	private int operateurChoisi = 0;
	
	private JPanel mainPanel;
	private JPanel subPanel1;
	private JPanel subPanel2;
	private JPanel subPanel3;
	private JPanel subPanel4;
	private JPanel subPanel5;
	private JPanel subPanel6;

	private JComboBox<String> combo;
	private JLabel opChoiceLabel;

	private JLabel opNameLabel;
	private JTextField opNameTF;

	private JLabel capacityLabel;
	private JTextField capacityTF;

	private JLabel reputationLabel;
	private JTextField reputationTF;

	private JLabel failChanceLabel;
	private JTextField failChanceTF;

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
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		mainPanel.setBackground(Color.white);
		
		subPanel1 = new JPanel();
		subPanel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		subPanel1.setBackground(Color.white);

		subPanel2 = new JPanel();
		subPanel2.setLayout(new FlowLayout(FlowLayout.CENTER));
		subPanel2.setBackground(Color.white);
		
		opChoiceLabel = new JLabel("Opérateur à modifier");
		subPanel1.add(opChoiceLabel);

		combo = new JComboBox<String>();

		for (int i = 0; i < Main.listOp.size(); i++) {
			combo.addItem(Main.listOp.get(i).getName());
		}

		combo.addActionListener(new ItemAction());
		combo.setPreferredSize(new Dimension(150, 20));
		subPanel1.add(combo);
		
		

		JButton confirmation = new JButton(new ButtonConfirmationSetOp(this, "Ok"));
		subPanel2.add(confirmation);
		
		mainPanel.add(subPanel1);
		mainPanel.add(subPanel2);

		return mainPanel;
	}

	class ItemAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			subPanel3 = new JPanel();
			subPanel3.setLayout(new FlowLayout(FlowLayout.LEFT));
			subPanel3.setBackground(Color.white);
			
			subPanel4 = new JPanel();
			subPanel4.setLayout(new FlowLayout(FlowLayout.LEFT));
			subPanel4.setBackground(Color.white);
			
			subPanel5 = new JPanel();
			subPanel5.setLayout(new FlowLayout(FlowLayout.LEFT));
			subPanel5.setBackground(Color.white);
			
			subPanel6 = new JPanel();
			subPanel6.setLayout(new FlowLayout(FlowLayout.LEFT));
			subPanel6.setBackground(Color.white);
			
			int choixop = 0;
			for (int i = 0; i < Main.listOp.size(); i++) {
				if (Main.listOp.get(i).getName() == combo.getSelectedItem()) {
					choixop = i;
					operateurChoisi = i;
				}
			}

			opNameLabel = new JLabel("Nom de l'opérateur");
			subPanel3.add(opNameLabel);

			opNameTF = new JTextField();
			opNameTF.setColumns(10);
			opNameTF.setText(Main.listOp.get(choixop).getName());
			subPanel3.add(opNameTF);

			mainPanel.add(subPanel3);
			
			capacityLabel = new JLabel("Capacite de l'operateur");
			subPanel4.add(capacityLabel);

			capacityTF = new JTextField();
			capacityTF.setColumns(10);
			capacityTF.setText(Integer.toString(Main.listOp.get(choixop).getMaxCapacity()));
			subPanel4.add(capacityTF);
			
			mainPanel.add(subPanel4);

			reputationLabel = new JLabel("Réputation");
			subPanel5.add(reputationLabel);

			reputationTF = new JTextField();
			reputationTF.setColumns(10);
			reputationTF.setText(Double.toString(Main.listOp.get(choixop).getReputationInit()));
			subPanel5.add(reputationTF);
			
			mainPanel.add(subPanel5);

			if (Main.simulation.getFailChanceCase() == 1) {
				failChanceLabel = new JLabel("Probilité échec");
				subPanel6.add(failChanceLabel);

				failChanceTF = new JTextField();
				failChanceTF.setColumns(10);
				failChanceTF.setText(Double.toString(Main.listOp.get(choixop).getFixedFailChance()));
				subPanel6.add(failChanceTF);
			}
			
			mainPanel.add(subPanel6);
			
			mainPanel.add(subPanel2);

			mainPanel.revalidate();
			mainPanel.repaint();
		}
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

	public int getOperateurChoisi() {
		return operateurChoisi;
	}

	public void setOperateurChoisi(int operateurChoisi) {
		this.operateurChoisi = operateurChoisi;
	}
}