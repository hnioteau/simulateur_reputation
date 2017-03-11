package interfaceGraphique;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import projet.Main;

public class InterfaceGraphique2 extends JFrame {
	private static JTextArea clientEtOperateur;
	private static JLabel useCase;

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

		JButton btnNewButton = new JButton(new ButtonActionReset(this, "Reset simulation"));
		panel.add(btnNewButton);

		JButton btnAffClient = new JButton(new ButtonActionClient(this, "Afficher client"));
		panel.add(btnAffClient);

		JButton btnAffOperateur = new JButton(new ButtonActionOperateur(this, "Afficher operateur"));
		panel.add(btnAffOperateur);
		
		JButton btnChangeCas = new JButton(new ButtonActionCas(this, "Changer cas"));
		panel.add(btnChangeCas);

		JButton btnStartSim = new JButton(new ButtonSimulation(this, "Lancer simulation"));
		panel.add(btnStartSim);
		
		useCase = new JLabel();
		if(Main.simulation.getUseCase() == 0)
			useCase.setText("Tous les opérateurs sont éligible");
		if(Main.simulation.getUseCase() == 1)
			useCase.setText("Seul les opérateurs qui ont assez de capacité sont éligible");
		panel.add(useCase);

		clientEtOperateur = new JTextArea("Client : Duree de la requete " + Main.client.getDuration()
				+ "     Taille de la requete " + Main.client.getWeight() + "\n");
		clientEtOperateur.setEditable(false);
		clientEtOperateur.setOpaque(false);
		panel.add(clientEtOperateur);

		return panel;
	}

	static void setClientEtOperateur(String string) {
		clientEtOperateur.setText(string);
	}
	
	static String getClientEtoperateur(){
		return clientEtOperateur.getText();
	}

 static JLabel getUseCase() {
		return useCase;
	}

 static void setUseCase(String string) {
		useCase.setText(string);
	}
}
