package Package1;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.*;

public class Main {
	static ArrayList<Operateur> lop = new ArrayList<Operateur>();
	static double somme_rep = 0;
	static int duree_simu = 20;
	static double modifrep = 0.5;
	public static void main(String[] args){
		Client cl = new Client();
		Operateur op1 = new Operateur(10000, 0.6);
		lop.add(op1);
		somme_rep += op1.getRep();
		Operateur op2 = new Operateur(5000, 0.8);
		lop.add(op2);
		somme_rep += op2.getRep();
		while (duree_simu != 0){
			for(int i = 0; i < lop.size(); ++i){ // on vérifie pour chaque opérateur si une requete est finie
				for(int j = 0; j < lop.get(i).getListe_req().size(); ++j){
					Client c = lop.get(i).getListe_req().get(j);
					c.setDuree(lop.get(i).getListe_req().get(j).getDuree() - 1);
					if (c.getDuree() != 0){
						lop.get(i).getListe_req().remove(j);
						lop.get(i).setCap(lop.get(i).getCap()+cl.getCap());
					}
				}
			}
			double choixop = Math.random()*(somme_rep); //tirage alatoire (entre 0 et somme_rep) pour déterminer l'opérateur qui prend la requete
			Operateur top;
			if (choixop < op1.getRep()){
				System.out.println("choix op1");
				top = op1;
			}
			else{
				System.out.println(" choix op2");
				top = op2;
			}
			double probaechec = 1-top.getCap()/top.getCapinit(); //determine la probabilité d'échec
			double echec = Math.random(); //détermine si la requete a réussi ou échoué
			if(cl.getCap() > top.getCap() || echec <= probaechec){
				System.out.println("echec");
				top.setRep(modifrep*top.getRep());
			}
			else{
				System.out.println("réussi");
				top.setRep((modifrep*top.getRep())+(1-modifrep));
				top.getListe_req().add(cl);
				top.setCap(top.getCap()-cl.getCap());
			}
			
			--duree_simu;
			System.out.println("op1 rep = "+ op1.getRep());
			System.out.println("op2 rep = "+ op2.getRep());
			
			
			
			
			
			
			
		}
		
		
		JFrame interfaceGraphique = new JFrame();
		interfaceGraphique.setContentPane(new InterfaceGraphique());
		
		interfaceGraphique.setLocation(200, 150);
		interfaceGraphique.pack();
		interfaceGraphique.setVisible(true);
		interfaceGraphique.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
}
