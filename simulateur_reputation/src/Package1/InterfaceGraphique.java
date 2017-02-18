package Package1;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JButton;



public class InterfaceGraphique extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

	public InterfaceGraphique() {
		
		JPanel panelDessin = new JPanel();
		this.getContentPane().add(panelDessin, BorderLayout.CENTER);
		
		JPanel paletteBtn = new JPanel();
		paletteBtn.setBackground(Color.WHITE);
		this.getContentPane().add(paletteBtn, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("Creer canneva");
		paletteBtn.add(btnNewButton);
		
		JButton btnAffClient = new JButton("Afficher client");
		paletteBtn.add(btnAffClient);
		
		JButton btnAffOperateur = new JButton("Afficher operateur");
		paletteBtn.add(btnAffOperateur);
		
		JButton btnStartSim = new JButton("Lancer simulation");
		paletteBtn.add(btnStartSim);
	}
	
	public void creerCanneva(){
		
	}

	public void afficherClient(){
		
	}
	
	public void afficherOperateur(){
		
	}
	
	public void boutonLancementSimulation(){
		
	}
	
}
