import java.util.ArrayList;
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
		    /* Initialisation des paramètres et création des opérateurs et du client */
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
			
			for (int i = 0; i < lop.size(); ++i) { // on vÃ©rifie pour chaque
													// opÃ©rateur si une requete
													// est finie
				
				lop.get(i).verificationEtatRequete();
			}
			
			double choixop = Math.random() * (somme_rep); // tirage alatoire
															// (entre 0 et
															// somme_rep) pour
															// dÃ©terminer
															// l'opÃ©rateur qui
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
			
			double echec = Math.random(); // dÃ©termine si la requete a rÃ©ussi ou
										  // Ã©chouÃ©
			
			// modification de la réputation et ajout de la requête à l'operateur
			// en cas de reussite
			if (cl.getCap() > top.getCap() || echec <= top.probaEchec()) {
				System.out.println("echec");
				top.setRepEchec();
			} else {
				System.out.println("reussi");
				top.setRepReussi();
				top.addRequest(cl);
			}
			
			// Ecriture en fichier des paramètres de la simulation
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
				System.out.println("La fonction OPEN n'est pas supportÃ©e par votre SystÃ¨me d'exploitation");
			}
		} else {
			System.out.println("La fonction Desktop n'est pas supportÃ©e par votre SystÃ¨me d'exploitation");
		}
	}
}