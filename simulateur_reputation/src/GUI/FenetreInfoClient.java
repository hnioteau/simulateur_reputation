package GUI;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
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
	private JPanel mainPanel;
	private JPanel subPanel1;
	private JPanel subPanel2;
	private JPanel subPanel3;
	
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
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		mainPanel.setBackground(Color.white);
		
		subPanel1 = new JPanel();
		subPanel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		subPanel1.setBackground(Color.white);

		subPanel2 = new JPanel();
		subPanel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		subPanel2.setBackground(Color.white);
		
		subPanel3 = new JPanel();
		subPanel3.setLayout(new FlowLayout(FlowLayout.CENTER));
		subPanel3.setBackground(Color.white);

		requestWeightLabel = new JLabel("Taille de la requete");
		subPanel1.add(requestWeightLabel);

		requestWeightTF = new JTextField();
		requestWeightTF.setColumns(10);
		requestWeightTF.setText(Integer.toString(Main.client.getWeight()));
		subPanel1.add(requestWeightTF);

		requestDurationLabel = new JLabel("Duree de la requete");
		subPanel2.add(requestDurationLabel);

		requestDurationTF = new JTextField();
		requestDurationTF.setColumns(10);
		requestDurationTF.setText(Integer.toString(Main.client.getDuration()));
		subPanel2.add(requestDurationTF);

		JButton confirmation = new JButton(new ButtonConfirmationClient(this, "Ok"));
		subPanel3.add(confirmation);
		
		mainPanel.add(subPanel1);
		mainPanel.add(subPanel2);
		mainPanel.add(subPanel3);

		return mainPanel;
	}

	public JTextField getRequestValue() {
		return requestWeightTF;
	}

	public JTextField getRequestDuration() {
		return requestDurationTF;
	}

}
