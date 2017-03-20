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
	private static JLabel echecCase;
	private static JLabel timerSimulation;
	private static JLabel valRho;

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

		JButton btnAffClient = new JButton(new ButtonActionClient(this, "Mofidier client"));
		panel.add(btnAffClient);

		JButton btnAffOperateur = new JButton(new ButtonActionOperateur(this, "Créer operateur"));
		panel.add(btnAffOperateur);

		JButton btnChangeCas = new JButton(new ButtonActionCas(this, "Changer cas choix opérateur"));
		panel.add(btnChangeCas);

		JButton btnChangeProbaEchec = new JButton(
				new ButtonActionProbaEchec(this, "Changer méthode choix probabilité d'échec"));
		panel.add(btnChangeProbaEchec);

		JButton btnSetTimer = new JButton(new ButtonSetTimer(this, "Durée de la simulation"));
		panel.add(btnSetTimer);
		
		JButton btnSetRho = new JButton(new ButtonSetRho(this, "Modifier rho"));
		panel.add(btnSetRho);
		
		JButton btnSetOperator = new JButton(new ButtonSetOperator(this, "Modifier opérateur"));
		panel.add(btnSetOperator);

		JButton btnStartSim = new JButton(new ButtonSimulation(this, "Lancer simulation"));
		panel.add(btnStartSim);
		
		valRho = new JLabel();
		valRho.setText("Valeur de rho : "+ Main.simulation.getRepFactor());
		panel.add(valRho);

		timerSimulation = new JLabel();
		timerSimulation.setText("Durée de la simulation : " + Main.simulation.getSimulationTime());
		panel.add(timerSimulation);

		useCase = new JLabel();
		if (Main.simulation.getUseCase() == 0)
			useCase.setText("Tous les opérateurs sont éligible");
		if (Main.simulation.getUseCase() == 1)
			useCase.setText("Seul les opérateurs qui ont assez de capacité sont éligible");
		panel.add(useCase);

		echecCase = new JLabel();
		if (Main.simulation.getProbaEchecCase() == 0)
			echecCase.setText("Probabilité d'échec en fonction de la formule");
		if (Main.simulation.getProbaEchecCase() == 1)
			echecCase.setText("Probabilité d'échec fixe pour chaque opérateur");
		panel.add(echecCase);

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

	static String getClientEtoperateur() {
		return clientEtOperateur.getText();
	}

	static JLabel getUseCase() {
		return useCase;
	}

	static void setUseCase(String string) {
		useCase.setText(string);
	}

	static void setTimer(String string) {
		timerSimulation.setText(string);
	}

	static JLabel getProbaCase() {
		return echecCase;
	}

	static void setProbaCase(JLabel echecCase) {
		InterfaceGraphique2.echecCase = echecCase;
	}
	
	static void setRho(String string){
		valRho.setText(string);
	}
}
