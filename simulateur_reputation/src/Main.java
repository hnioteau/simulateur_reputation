import java.util.ArrayList;
import java.awt.Desktop;
import java.io.BufferedWriter;
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
		OutputStreamWriter fout = null;
		try {
			fout = new OutputStreamWriter(new FileOutputStream(new File("results.txt")));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Client cl = new Client();
		Operateur op1 = new Operateur(10000, 0.6);
		lop.add(op1);
		somme_rep += op1.getRep();
		Operateur op2 = new Operateur(5000, 0.8);
		lop.add(op2);
		somme_rep += op2.getRep();
		while (duree_simu != 0) {
			for (int i = 0; i < lop.size(); ++i) { // on vérifie pour chaque
													// opérateur si une requete
													// est finie
				lop.get(i).verifiacationEtatRequete();
			}
			double choixop = Math.random() * (somme_rep); // tirage alatoire
															// (entre 0 et
															// somme_rep) pour
															// déterminer
															// l'opérateur qui
															// prend la requete
			Operateur top;
			if (choixop < op1.getRep()) {
				System.out.println("choix op1");
				top = op1;
			} else {
				System.out.println(" choix op2");
				top = op2;
			}
			double probaechec = top.ProbaEchec(); // determine la probabilité
													// d'échec
			double echec = Math.random(); // détermine si la requete a réussi ou
											// échoué
			if (cl.getCap() > top.getCap() || echec <= probaechec) {
				System.out.println("echec");
				top.setRepEchec();
			} else {
				System.out.println("réussi");
				top.setRepReussi();
				top.getListe_req().add(cl);
				top.setCap(top.getCap() - cl.getCap());
			}

			try {
				fout.write("op1 rep = " + op1.getRep() + " op2 rep = " + op2.getRep() + System.lineSeparator());
				fout.flush();
				System.out.println("Try");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			--duree_simu;
			System.out.println("op1 rep = " + op1.getRep());
			System.out.println("op2 rep = " + op2.getRep());
		}

		try {
			if (fout != null)
				fout.close();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
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