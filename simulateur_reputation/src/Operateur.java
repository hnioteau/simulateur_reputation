import java.util.ArrayList;

public class Operateur {
	private int capinit; //capacité maximal
	private int cap; //capacité actuel
	private double rep;
	static double modifrep = 0.5;
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
	
	public void setRepReussi(){
		rep=modifrep*rep+(1-modifrep);
	}
	
	public void setRepEchec(){
		rep=modifrep*rep;
	}
	
	public double ProbaEchec(){
		return 1-cap/capinit;
	}
	
	public void verifiacationEtatRequete(){
		for(int j = 0; j < getListe_req().size(); ++j){
			Client c = getListe_req().get(j);
			c.setDuree(getListe_req().get(j).getDuree() - 1);
			if (c.getDuree() != 0){
				getListe_req().remove(j);
				setCap(getCap()+c.getCap());
			}
		}
	}
}
