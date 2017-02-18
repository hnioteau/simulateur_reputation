package Package1;
import java.util.ArrayList;

public class Operateur {
	private int capinit; //capacité maximal
	private int cap; //capacité actuel
	private double rep;
	private ArrayList<Client> liste_req = new ArrayList<Client>(); //ensemble des requetes en cours d'execution par l'opérateur
	Operateur(int c, double r){
		setCapinit(c);
		setCap(c);
		setRep(r);
	}
	public double getRep() {
		return rep;
	}
	public void setRep(double rep) {
		this.rep = rep;
	}
	public int getCap() {
		return cap;
	}
	public void setCap(int cap) {
		this.cap = cap;
	}
	public int getCapinit() {
		return capinit;
	}
	public void setCapinit(int capinit) {
		this.capinit = capinit;
	}
	public ArrayList<Client> getListe_req() {
		return liste_req;
	}
	public void setListe_req(ArrayList<Client> liste_req) {
		this.liste_req = liste_req;
	}
}
