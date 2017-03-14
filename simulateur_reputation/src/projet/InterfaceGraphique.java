package projet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InterfaceGraphique extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Simulation simulation = new Simulation();
	private JLabel label = new JLabel();

	private JPanel panelDessin = new JPanel();
	private JPanel paletteBtn = new JPanel();

	public InterfaceGraphique() {

		this.getContentPane().add(panelDessin, BorderLayout.CENTER);

		paletteBtn.setBackground(Color.WHITE);
		this.getContentPane().add(paletteBtn, BorderLayout.NORTH);

		// Creation des boutons
		JButton btnNewButton = new JButton("Creer canneva");
		JButton btnAffClient = new JButton("Afficher client");
		JButton btnAffOperateur = new JButton("Afficher operateur");
		JButton btnStartSim = new JButton("Lancer simulation");

		btnNewButton.addActionListener(this);
		btnAffClient.addActionListener(this);
		btnAffOperateur.addActionListener(this);
		btnStartSim.addActionListener(this);

		paletteBtn.add(btnNewButton);
		paletteBtn.add(btnAffClient);
		paletteBtn.add(btnAffOperateur);
		paletteBtn.add(btnStartSim);

		// Ce sont maintenant nos classes internes qui ecoutent nos boutons
		btnNewButton.addActionListener(new btnNewButtonListener());
		btnAffClient.addActionListener(new btnAffClientListener());
		btnAffOperateur.addActionListener(new btnAffOperateurListener());
		btnStartSim.addActionListener(new btnStartSimListener());
	}

	// Classe ecoutant notre premier bouton
	class btnNewButtonListener implements ActionListener {
		// Redefinition de la methode actionPerformed()
		public void actionPerformed(ActionEvent arg0) {
			label.setText("Vous avez clique sur Creer canneva");
			System.out.println("Creer canneva");
		}
		// Reset la zone de dessin
	}

	// Classe ecoutant notre deuxieme bouton
	class btnAffClientListener implements ActionListener {
		// Redefinition de la methode actionPerformed()
		public void actionPerformed(ActionEvent arg0) {
			label.setText("Vous avez clique sur Afficher client");
			System.out.println("Afficher client");
		}
	}

	// Classe ecoutant notre troisieme bouton
	class btnAffOperateurListener implements ActionListener {
		// Redefinition de la methode actionPerformed()
		public void actionPerformed(ActionEvent arg0) {
			label.setText("Vous avez clique sur Afficher operateur");
			System.out.println("Afficher operateur");
		}
	}

	// Classe ecoutant notre quatrieme bouton
	class btnStartSimListener implements ActionListener {
		// Redefinition de la methode actionPerformed()
		public void actionPerformed(ActionEvent arg0) {
			label.setText("Vous avez clique sur Lancer simulation");
			System.out.println("Lancer simulation");
			simulation.setSimulationTime(20);
			simulation.runSimulation();
		}
	}

	public InterfaceGraphique(GraphicsConfiguration arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public InterfaceGraphique(String arg0, GraphicsConfiguration arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public InterfaceGraphique(String arg0) throws HeadlessException {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
