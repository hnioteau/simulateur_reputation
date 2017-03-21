package interfaceGraphique;

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
	private JLabel choixOp;

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
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		mainPanel.setBackground(Color.white);
		
		subPanel1 = new JPanel();
		subPanel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		subPanel1.setBackground(Color.white);

		subPanel2 = new JPanel();
		subPanel2.setLayout(new FlowLayout(FlowLayout.CENTER));
		subPanel2.setBackground(Color.white);
		
		choixOp = new JLabel("Opérateur à modifier");
		subPanel1.add(choixOp);

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

			nomOp = new JLabel("Nom de l'opérateur");
			subPanel3.add(nomOp);

			nomOperator = new JTextField();
			nomOperator.setColumns(10);
			nomOperator.setText(Main.listOp.get(choixop).getName());
			subPanel3.add(nomOperator);

			mainPanel.add(subPanel3);
			
			valCapacite = new JLabel("Capacite de l'operateur");
			subPanel4.add(valCapacite);

			valeurCapacite = new JTextField();
			valeurCapacite.setColumns(10);
			valeurCapacite.setText(Integer.toString(Main.listOp.get(choixop).getMaxCapacity()));
			subPanel4.add(valeurCapacite);
			
			mainPanel.add(subPanel4);

			reputation = new JLabel("Réputation");
			subPanel5.add(reputation);

			reput = new JTextField();
			reput.setColumns(10);
			reput.setText(Double.toString(Main.listOp.get(choixop).getReputationInit()));
			subPanel5.add(reput);
			
			mainPanel.add(subPanel5);

			if (Main.simulation.getProbaEchecCase() == 1) {
				probEchec = new JLabel("Probilité échec");
				subPanel6.add(probEchec);

				probabiliteEchec = new JTextField();
				probabiliteEchec.setColumns(10);
				probabiliteEchec.setText(Double.toString(Main.listOp.get(choixop).getProbaEchecfixe()));
				subPanel6.add(probabiliteEchec);
			}
			
			mainPanel.add(subPanel6);
			
			mainPanel.add(subPanel2);

			mainPanel.revalidate();
			mainPanel.repaint();
		}
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

	public int getOperateurChoisi() {
		return operateurChoisi;
	}

	public void setOperateurChoisi(int operateurChoisi) {
		this.operateurChoisi = operateurChoisi;
	}
}