package interfaceGraphique;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class InterfaceGraphique2 extends JFrame {
	private static JTextArea clientEtOperateur;

	public InterfaceGraphique2() {
		super();
		build();
	}

	private void build() {
		setTitle("Simulation");
		setSize(640, 360);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(buildContentPane());
	}

	private JPanel buildContentPane() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setBackground(Color.white);

		JButton btnNewButton = new JButton("Creer canneva");
		panel.add(btnNewButton);

		JButton btnAffClient = new JButton(new ButtonActionClient(this, "Afficher client"));
		panel.add(btnAffClient);

		JButton btnAffOperateur = new JButton(new ButtonActionOperateur(this, "Afficher operateur"));
		panel.add(btnAffOperateur);

		JButton btnStartSim = new JButton(new ButtonSimulation(this, "Lancer simulation"));
		panel.add(btnStartSim);

		clientEtOperateur = new JTextArea();
		clientEtOperateur.setEditable(false);
		clientEtOperateur.setOpaque(false);
		;
		panel.add(clientEtOperateur);

		return panel;
	}

	static void setClientEtOperateur(String string) {
		clientEtOperateur.setText(string);
	}
	
	static String getClientEtoperateur(){
		return clientEtOperateur.getText();
	}
}
