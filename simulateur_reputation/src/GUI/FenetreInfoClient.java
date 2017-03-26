package GUI;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import projet.Main;

public class FenetreInfoClient extends JFrame {
	/**
	 * 
	 */
	private JLabel requestWeightLabel;
	private JTextField requestWeightTF;

	private JLabel requestDurationLabel;
	private JTextField requestDurationTF;

	public FenetreInfoClient() {
		super();
		build();
	}

	private void build() {
		setTitle("Info client");
		setSize(400, 200);
		setResizable(false);
		setContentPane(buildContentPane());

	}

	private JPanel buildContentPane() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setBackground(Color.white);

		requestWeightLabel = new JLabel("Taille de la requete");
		panel.add(requestWeightLabel);

		requestWeightTF = new JTextField();
		requestWeightTF.setColumns(10);
		requestWeightTF.setText(Integer.toString(Main.client.getWeight()));
		panel.add(requestWeightTF);

		requestDurationLabel = new JLabel("Duree de la requete");
		panel.add(requestDurationLabel);

		requestDurationTF = new JTextField();
		requestDurationTF.setColumns(10);
		requestDurationTF.setText(Integer.toString(Main.client.getDuration()));
		panel.add(requestDurationTF);

		JButton confirmation = new JButton(new ButtonConfirmationClient(this, "Ok"));
		panel.add(confirmation);

		return panel;
	}

	public JTextField getRequestValue() {
		return requestWeightTF;
	}

	public JTextField getRequestDuration() {
		return requestDurationTF;
	}

}
