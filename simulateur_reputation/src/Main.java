import java.util.ArrayList;

import javax.swing.JFrame;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
	static ArrayList<Operateur> lop = new ArrayList<Operateur>();
	static double somme_rep = 0;
	static int duree_simu = 20;

	
	public static void main(String[] args) {
		InterfaceGraphique interfaceGraphique = new InterfaceGraphique();
		interfaceGraphique.setTitle("Simulateur Reputation");
		interfaceGraphique.setSize(640, 360);
		interfaceGraphique.setLocationRelativeTo(null);
		interfaceGraphique.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		interfaceGraphique.setVisible(true);
	}
	
	public static void lancerSimulation(){
		    /* Initialisation des param�tres et cr�ation des op�rateurs et du client */
		OutputStreamWriter fout = null;
		try {
			fout = new OutputStreamWriter(new FileOutputStream(new File("results.txt")));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		
		Operateur op1 = new Operateur(10000, 0.6);
		lop.add(op1);
		somme_rep += op1.getRep();
		Operateur op2 = new Operateur(5000, 0.8);
		lop.add(op2);
		somme_rep += op2.getRep();
		
		
		                         /* Lancement de la simulation */
		while (duree_simu != 0) {
			Client cl = new Client();
			
			for (int i = 0; i < lop.size(); ++i) { // on vérifie pour chaque
													// opérateur si une requete
													// est finie
				
				lop.get(i).verificationEtatRequete();
			}
			
			double choixop = Math.random() * (somme_rep); // tirage alatoire
															// (entre 0 et
															// somme_rep) pour
															// déterminer
															// l'opérateur qui
															// prend la requete
			
			// choix de l'operateur
			Operateur top;
			if (choixop < op1.getRep()) {
				System.out.println("choix op1");
				top = op1;
			} else {
				System.out.println(" choix op2");
				top = op2;
			}
			
			double echec = Math.random(); // détermine si la requete a réussi ou
										  // échoué
			
			// modification de la r�putation et ajout de la requ�te � l'operateur
			// en cas de reussite
			if (cl.getCap() > top.getCap() || echec <= top.probaEchec()) {
				System.out.println("echec");
				top.setRepEchec();
			} else {
				System.out.println("reussi");
				top.setRepReussi();
				top.addRequest(cl);
			}
			
			// Ecriture en fichier des param�tres de la simulation
			try {
				fout.write("op1 rep = " + op1.getRep() + " op2 rep = " + op2.getRep() + System.lineSeparator());
				fout.flush();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			--duree_simu;
			System.out.println("op1 rep = " + op1.getRep());
			System.out.println("op2 rep = " + op2.getRep());
		}

		// Fermeture du fichier
		try {
			if (fout != null)
				fout.close();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		
		// Ouverture du fichier en fin de simulation
		if (Desktop.isDesktopSupported()) {
			if (Desktop.getDesktop().isSupported(java.awt.Desktop.Action.OPEN)) {
				File file = new File("results.txt");
				try {
					java.awt.Desktop.getDesktop().open(file);
				} catch (IOException exc) {
					System.out.println("Exception: " + exc.toString());
				}
			} else {
				System.out.println("La fonction OPEN n'est pas supportée par votre Système d'exploitation");
			}
		} else {
			System.out.println("La fonction Desktop n'est pas supportée par votre Système d'exploitation");
		}
	}
}