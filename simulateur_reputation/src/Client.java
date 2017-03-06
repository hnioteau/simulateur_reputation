public class Client {
	private int weight;
	private int duration;
	
	
	/*
	 * Constructeurs de la classe.
	 */
	Client() {
		setWeight(1000);
		setDuration(10);
	}
	
	Client(int c, int d) {
		setWeight(c);
		setDuration(d);
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

}
