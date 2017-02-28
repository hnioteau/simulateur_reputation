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
		if(rep <= 1 && rep >= 0)
			this.rep = rep;
	}
	
	public int getCap() {
		return cap;
	}
	
	public void setCap(int cap) {
		if(cap <= this.capinit && cap >= 0)
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
		int i;
		int sommeCap = 0;
		
		for(i = 0 ; i < liste_req.size() ; i++) {
			sommeCap += liste_req.get(i).getCap();
		}
		
		if(sommeCap <= this.capinit)
			this.liste_req = liste_req;
	}
	
	public void addRequest (Client client) {
		getListe_req().add(client);
		setCap(getCap() - client.getCap());
	}
	
	public void setRepReussi(){
		rep=modifrep*rep+(1-modifrep);
	}
	
	public void setRepEchec(){
		rep=modifrep*rep;
	}
	
	public double probaEchec(){
		return 1-((double) cap/(double) capinit);
	}
	
	public void verificationEtatRequete(){
		
		for(int j = 0; j < getListe_req().size(); j++){
			Client c = getListe_req().get(j);
			int duree = c.getDuree();
			c.setDuree(duree - 1);
			
			if (c.getDuree() == 0){
				getListe_req().remove(j);
				setCap(getCap()+c.getCap());
			}
		}
	}
	
}
