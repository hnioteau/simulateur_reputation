package interfaceGraphique;

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
	private JLabel valRequete;
	private JTextField valeurRequete;

	private JLabel durRequete;
	private JTextField dureeRequete;

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

		valRequete = new JLabel("Taille de la requete");
		panel.add(valRequete);

		valeurRequete = new JTextField();
		valeurRequete.setColumns(10);
		valeurRequete.setText(Integer.toString(Main.client.getWeight()));
		panel.add(valeurRequete);

		durRequete = new JLabel("Duree de la requete");
		panel.add(durRequete);

		dureeRequete = new JTextField();
		dureeRequete.setColumns(10);
		dureeRequete.setText(Integer.toString(Main.client.getDuration()));
		panel.add(dureeRequete);

		JButton confirmation = new JButton(new ButtonConfirmationClient(this, "Ok"));
		panel.add(confirmation);

		return panel;
	}

	public JTextField getValeurRequete() {
		return valeurRequete;
	}

	public JTextField getDureeRequete() {
		return dureeRequete;
	}

}
