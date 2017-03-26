package GUI;

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
	private JLabel rhoValueLabel;
	private JTextField rhoValueTF;

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

		rhoValueLabel = new JLabel("Valeur de rho");
		panel.add(rhoValueLabel);

		rhoValueTF = new JTextField();
		rhoValueTF.setColumns(10);
		rhoValueTF.setText(Double.toString(Main.simulation.getRepFactor()));
		panel.add(rhoValueTF);

		JButton confirmation = new JButton(new ButtonConfirmationRho(this, "Ok"));
		panel.add(confirmation);

		return panel;
	}

	public JTextField getValeurRho() {
		return rhoValueTF;
	}

}