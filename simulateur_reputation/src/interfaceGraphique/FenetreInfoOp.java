package interfaceGraphique;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	//private JPanel grosPanel = new JPanel();
	private JPanel panel;

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
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setBackground(Color.white);

		choixOp = new JLabel("Opérateur à modifier");
		panel.add(choixOp);

		combo = new JComboBox<String>();

		for (int i = 0; i < Main.listOp.size(); i++) {
			combo.addItem(Main.listOp.get(i).getName());
		}

		combo.addActionListener(new ItemAction());
		combo.setPreferredSize(new Dimension(150, 20));
		panel.add(combo);

		//grosPanel.add(panel);
		
		JButton confirmation = new JButton(new ButtonConfirmationSetOp(this, "Ok"));
		panel.add(confirmation);

		return panel;
	}

	class ItemAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JPanel jp = new JPanel();
			jp.setLayout(new FlowLayout());
			jp.setBackground(Color.white);
			
			int choixop = 0;
			for (int i = 0; i < Main.listOp.size(); i++) {
				if (Main.listOp.get(i).getName() == combo.getSelectedItem())
					choixop = i;
			}

			nomOp = new JLabel("Nom de l'opérateur");
			panel.add(nomOp);

			nomOperator = new JTextField();
			nomOperator.setColumns(10);
			nomOperator.setText(Main.listOp.get(choixop).getName());
			panel.add(nomOperator);

			valCapacite = new JLabel("\nCapacite de l'operateur");
			panel.add(valCapacite);

			valeurCapacite = new JTextField();
			valeurCapacite.setColumns(10);
			valeurCapacite.setText(Integer.toString(Main.listOp.get(choixop).getCapacity()));
			panel.add(valeurCapacite);

			reputation = new JLabel("\nRéputation");
			panel.add(reputation);

			reput = new JTextField();
			reput.setColumns(10);
			reput.setText(Double.toString(Main.listOp.get(choixop).getReputationInit()));
			panel.add(reput);

			if (Main.simulation.getProbaEchecCase() == 1) {
				probEchec = new JLabel("\nProbilité échec");
				panel.add(probEchec);

				probabiliteEchec = new JTextField();
				probabiliteEchec.setColumns(10);
				probabiliteEchec.setText(Double.toString(Main.listOp.get(choixop).getProbaEchecfixe()));
				panel.add(probabiliteEchec);
			}
			
			panel.revalidate();
			panel.repaint();
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
}