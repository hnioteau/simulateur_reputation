package projet;

import java.util.ArrayList;

public class Operator {
	private String name;
	private int maxCapacity; // capacite maximal
	private int capacity; // capacite actuel
	private double reputationInit;
	private double reputation;
	private double fixedFailChance = 0.5;

	private ArrayList<Client> listRequests = new ArrayList<Client>(); // ensemble
																		// des
																		// requetes
																		// en
																		// cours
																		// d'execution
																		// par
																		// l'operateur

	/*
	 * Constructeur de la classe.
	 */
	public Operator(String name, int capa, double rep) {
		setName(name);
		setMaxCapacity(capa);
		setCapacity(capa);
		setReputationInit(rep);
		setReputation(rep);
	}

	
	/*
	 * Ajout d'une nouvelle requete a la liste.
	 */
	public void addRequest(Client client) {
		getListRequests().add(client);
		setCapacity(getCapacity() - client.getWeight());
	}
	

	/*
	 * Modifie la reputation de l'operateur suite a l'echec d'une requete.
	 */
	public void setRepSuccess() {
		reputation = Main.simulation.getRepFactor() * reputation + (1 - Main.simulation.getRepFactor());
	}

	
	/*
	 * Modifie la reputation de l'operateur suite a la reussite d'une requete.
	 */
	public void setRepFailed() {
		reputation = Main.simulation.getRepFactor() * reputation;
	}

	
	/*
	 * Calcule la probabilite d'echec de l'operateur.
	 */
	public double failChance() {
		return 1 - ((double) capacity / (double) maxCapacity);
	}

	
	/*
	 * Verifie l'etat des requetes. Si une requete atteint 0 de duree, la
	 * supprime de la liste des requetes.
	 */
	public void checkRequestsState() {
		for (int j = 0; j < getListRequests().size(); j++) {
			Client client = getListRequests().get(j);
			int reqTime = client.getDuration();
			client.setDuration(reqTime - 1);

			if (client.getDuration() == 0) {
				getListRequests().remove(j);
				setCapacity(getCapacity() + client.getWeight());
			}
		}
	}

	
	/*
	 * Getters et setters pour les attributs de la classe.
	 */
	public double getReputation() {
		return reputation;
	}

	public void setReputation(double rep) {
		if (rep <= 1 && rep >= 0)
			this.reputation = rep;
	}

	public double getReputationInit() {
		return reputationInit;
	}

	public void setReputationInit(double rep) {
		
		if (rep <= 1 && rep >= 0)
			reputationInit = rep;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int cap) {
		if (cap <= this.maxCapacity && cap >= 0)
			this.capacity = cap;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCap) {
		this.maxCapacity = maxCap;
	}
	
	public double getFixedFailChance() {
		return fixedFailChance;
	}

	public void setFixedFailChance(double failChance) {
		this.fixedFailChance = failChance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Client> getListRequests() {
		return listRequests;
	}

	public void setListRequests(ArrayList<Client> listReq) {
		int i;
		int sumCap = 0;

		for (i = 0; i < listReq.size(); i++) {
			sumCap += listReq.get(i).getWeight();
		}

		if (sumCap <= this.maxCapacity)
			this.listRequests = listReq;
	}
	

}
