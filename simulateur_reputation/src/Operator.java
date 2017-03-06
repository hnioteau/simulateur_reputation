import java.util.ArrayList;

public class Operator {
	private int maxCapacity; //capacite maximal
	private int capacity; //capacite actuel
	private double reputation;
	private static double repFactor = 0.5; // facteur de la formule de modification de reputation
	private ArrayList<Client> listRequests = new ArrayList<Client>(); //ensemble des requetes en cours d'execution par l'operateur
	
	
	/*
	 * Constructeur de la classe.
	 */
	Operator(int capa, double rep){
		setMaxCapacity(capa);
		setCapacity(capa);
		setReputation(rep);
	}
	
	
	/*
	 * Getters et setters pour les attributes de la classe.
	 */
	public double getReputation() {
		return reputation;
	}
	
	public void setReputation(double rep) {
		if(rep <= 1 && rep >= 0)
			this.reputation = rep;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public void setCapacity(int cap) {
		if(cap <= this.maxCapacity && cap >= 0)
			this.capacity = cap;
	}
	
	public int getMaxCapacity() {
		return maxCapacity;
	}
	
	public void setMaxCapacity(int maxCap) {
		this.maxCapacity = maxCap;
	}
	
	public ArrayList<Client> getListRequests() {
		return listRequests;
	}
	
	public void setListRequests(ArrayList<Client> listReq) {
		int i;
		int sumCap = 0;
		
		for(i = 0 ; i < listReq.size() ; i++) {
			sumCap += listReq.get(i).getWeight();
		}
		
		if(sumCap <= this.maxCapacity)
			this.listRequests = listReq;
	}
	
	
	/*
	 * Ajout d'une nouvelle requete à la liste.
	 */
	public void addRequest (Client client) {
		getListRequests().add(client);
		setCapacity(getCapacity() - client.getWeight());
	}
	
	
	/*
	 * Modifie la reputation de l'operateur suite à l'echec d'une requete.
	 */
	public void setRepSuccess(){
		reputation=repFactor*reputation+(1-repFactor);
	}
	
	/*
	 * Modifie la reputation de l'operateur suite à la reussite d'une requete.
	 */
	public void setRepFailed(){
		reputation=repFactor*reputation;
	}
	
	
	/*
	 * Calcule la probabilite d'echec de l'operateur.
	 */
	public double failChance(){
		return 1-((double) capacity/(double) maxCapacity);
	}
	
	
	/*
	 *  Verifie l'état des requetes. Si une requete atteint 0 de durée,
	 *  la supprime de la liste des requetes.
	*/
	public void checkRequestsState(){
		for(int j = 0; j < getListRequests().size(); j++){
			Client client = getListRequests().get(j);
			int reqTime = client.getDuration();
			client.setDuration(reqTime - 1);
			
			if (client.getDuration() == 0){
				getListRequests().remove(j);
				setCapacity(getCapacity()+client.getWeight());
			}
		}
	}
	
}
