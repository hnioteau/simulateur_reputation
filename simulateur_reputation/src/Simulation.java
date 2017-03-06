import java.util.ArrayList;

public class Simulation {
	private ArrayList<Operator> listOpertors = new ArrayList<Operator>();
	private double sumReputation;
	private int simulationTime;
	
	final int DEFAULT_TIME = 20;
	
	
	/*
	 * Constructeur de la classe.
	 */
	Simulation () {
		setSumReputation(0);
		setSimulationTime(DEFAULT_TIME);
	}

	
	/*
	 * Getters et setters pour les attributs de la classe.
	 */
	public double getSumReputation() {
		return sumReputation;
	}

	public void setSumReputation(double sumReputation) {
		if(sumReputation > 0)
			this.sumReputation = sumReputation;
	}

	public int getSimulationTime() {
		return simulationTime;
	}

	public void setSimulationTime(int simulationTime) {
		if (simulationTime > 0)
			this.simulationTime = simulationTime;
	}
	
	
	/*
	 * Lancement de la boucle de simulation.
	 */
	public void runSimulation() {
		
	}
}
