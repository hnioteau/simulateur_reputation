package Package1;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;



public class InterfaceGraphique extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel label = new JLabel();
	
	private JPanel panelDessin = new JPanel();
	private JPanel paletteBtn = new JPanel();
	
	

	public InterfaceGraphique() {
		
		
		this.getContentPane().add(panelDessin, BorderLayout.CENTER);
		
		
		paletteBtn.setBackground(Color.WHITE);
		this.getContentPane().add(paletteBtn, BorderLayout.NORTH);
		
		//Création des boutons
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
		
		//Ce sont maintenant nos classes internes qui écoutent nos boutons 
        btnNewButton.addActionListener(new btnNewButtonListener());
        btnAffClient.addActionListener(new btnAffClientListener());
        btnAffOperateur.addActionListener(new btnAffOperateurListener());
        btnStartSim.addActionListener(new btnStartSimListener());
	}
	
	//Classe écoutant notre premier bouton
	class btnNewButtonListener implements ActionListener{
	    //Redéfinition de la méthode actionPerformed()
		public void actionPerformed(ActionEvent arg0) {
	    	label.setText("Vous avez cliqué sur Creer canneva");
	    	System.out.println("Creer canneva");
	    }
		//Reset la zone de dessin
	}
	
	//Classe écoutant notre deuxieme bouton
		class btnAffClientListener implements ActionListener{
		    //Redéfinition de la méthode actionPerformed()
			public void actionPerformed(ActionEvent arg0) {
		    	label.setText("Vous avez cliqué sur Afficher client");
		    	System.out.println("Afficher client");
		    }
		}
	
		//Classe écoutant notre troisieme bouton
		class btnAffOperateurListener implements ActionListener{
		    //Redéfinition de la méthode actionPerformed()
			public void actionPerformed(ActionEvent arg0) {
		    	label.setText("Vous avez cliqué sur Afficher operateur");
		    	System.out.println("Afficher operateur");
		    }
		}
		
		//Classe écoutant notre quatrieme bouton
		class btnStartSimListener implements ActionListener{
		    //Redéfinition de la méthode actionPerformed()
			public void actionPerformed(ActionEvent arg0) {
		    	label.setText("Vous avez cliqué sur Lancer simulation");
		    	System.out.println("Lancer simulation");
		    	Main.duree_simu = 20;
		    	Main.main(null);
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
