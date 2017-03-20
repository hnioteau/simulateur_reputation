package interfaceGraphique;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
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
		setSize(1000, 500);
		setLocationRelativeTo(null);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(buildContentPane());
	}

	private JPanel buildContentPane() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		mainPanel.setBackground(Color.white);
		
		JPanel subPanel1 = new JPanel();
		subPanel1.setLayout(new FlowLayout());
		subPanel1.setBackground(Color.white);
		
		JPanel subPanel2 = new JPanel();
		subPanel2.setLayout(new FlowLayout());
		subPanel2.setBackground(Color.white);
		
		JPanel subPanel3 = new JPanel();
		subPanel3.setLayout(new FlowLayout());
		subPanel3.setBackground(Color.white);
		
		JPanel subPanel4 = new JPanel();
		subPanel4.setLayout(new FlowLayout());
		subPanel4.setBackground(Color.white);

		JPanel subPanel5 = new JPanel();
		subPanel5.setLayout(new FlowLayout());
		subPanel5.setBackground(Color.white);
		
		JPanel subPanel6 = new JPanel();
		subPanel6.setLayout(new FlowLayout());
		subPanel6.setBackground(Color.white);
		
		JButton btnNewButton = new JButton(new ButtonActionReset(this, "Reset simulation"));
		subPanel1.add(btnNewButton);

		JButton btnAffClient = new JButton(new ButtonActionClient(this, "Mofidier client"));
		subPanel1.add(btnAffClient);

		JButton btnAffOperateur = new JButton(new ButtonActionOperateur(this, "Créer operateur"));
		subPanel1.add(btnAffOperateur);

		JButton btnChangeCas = new JButton(new ButtonActionCas(this, "Changer cas choix opérateur"));
		subPanel1.add(btnChangeCas);

		JButton btnChangeProbaEchec = new JButton(
				new ButtonActionProbaEchec(this, "Changer méthode choix probabilité d'échec"));
		subPanel1.add(btnChangeProbaEchec);

		JButton btnSetTimer = new JButton(new ButtonSetTimer(this, "Durée de la simulation"));
		subPanel1.add(btnSetTimer);
		
		JButton btnSetRho = new JButton(new ButtonSetRho(this, "Modifier rho"));
		subPanel1.add(btnSetRho);
		
		JButton btnSetOperator = new JButton(new ButtonSetOperator(this, "Modifier opérateur"));
		subPanel1.add(btnSetOperator);

		JButton btnStartSim = new JButton(new ButtonSimulation(this, "Lancer simulation"));
		subPanel1.add(btnStartSim);
		
		mainPanel.add(subPanel1);
		
		valRho = new JLabel();
		valRho.setText("Valeur de rho : "+ Main.simulation.getRepFactor());
		subPanel2.add(valRho);
		
		mainPanel.add(subPanel2);

		timerSimulation = new JLabel();
		timerSimulation.setText("Durée de la simulation : " + Main.simulation.getSimulationTime());
		subPanel3.add(timerSimulation);
		
		mainPanel.add(subPanel3);

		useCase = new JLabel();
		if (Main.simulation.getUseCase() == 0)
			useCase.setText("Tous les opérateurs sont éligible");
		if (Main.simulation.getUseCase() == 1)
			useCase.setText("Seul les opérateurs qui ont assez de capacité sont éligible");
		subPanel4.add(useCase);
		
		mainPanel.add(subPanel4);

		echecCase = new JLabel();
		if (Main.simulation.getProbaEchecCase() == 0)
			echecCase.setText("Probabilité d'échec en fonction de la formule");
		if (Main.simulation.getProbaEchecCase() == 1)
			echecCase.setText("Probabilité d'échec fixe pour chaque opérateur");
		subPanel5.add(echecCase);

		mainPanel.add(subPanel5);
		
		clientEtOperateur = new JTextArea("Client : Duree de la requete " + Main.client.getDuration()
				+ "     Taille de la requete " + Main.client.getWeight() + "\n");
		clientEtOperateur.setEditable(false);
		clientEtOperateur.setOpaque(false);
		subPanel6.add(clientEtOperateur);

		mainPanel.add(subPanel6);
		
		return mainPanel;
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
