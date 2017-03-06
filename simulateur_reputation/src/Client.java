public class Client {
	private int weight;
	private int duration;
	
	final int DEFAULT_WEIGHT = 1000;
	final int DEFAULT_DURATION = 10;
	
	
	/*
	 * Constructeurs de la classe.
	 */
	Client() {
		this.weight = DEFAULT_WEIGHT;
		this.duration = DEFAULT_DURATION;
	}
	
	Client(int weight, int duration) {
		setWeight(weight);
		setDuration(duration);
	}
	
	
	/*
	 * Getters et setters pour les attributs de la classe.
	 */
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		if(weight >= 0)
			this.weight = weight;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public void setDuration(int duration) {
		if(duration >= 0)
			this.duration = duration;
	}

	
	/*
	 * Fait une copie du client.
	 */
	public Client copyClient() {
		Client newClient = new Client(this.getWeight(), this.getDuration());
		
		return newClient;
	}
}
