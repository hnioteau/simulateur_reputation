
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Simulation {
	private ArrayList<Operator> listOperators = new ArrayList<Operator>();
	private double sumReputation;
	private int simulationTime;
	int useCase = 0;
	Client client = new Client();
	final int DEFAULT_TIME = 20;
	final String FILE_NAME = "results.txt";

	/*
	 * Constructeur de la classe.
	 */
	Simulation() {
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
		if (sumReputation >= 0)
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
	 * Mise a jour de la somme des reputations.
	 */
	public void updateSumReputation() {
		double sum = 0;

		for (int i = 0; i < listOperators.size(); i++) {
			if (useCase == 0 || (useCase == 1 && listOperators.get(i).getCapacity() >= client.getWeight())) {
				sum += listOperators.get(i).getReputation();
			}
		}

		setSumReputation(sum);
	}

	/*
	 * Ajout d'un seul operateur � la liste et mise � jour de la somme des
	 * reputations.
	 */
	public void addOperator(Operator operator) {
		this.listOperators.add(operator);
		this.sumReputation += operator.getReputation();
	}

	/*
	 * Ajout d'un ensemble d'operateurs � la liste des operateurs.
	 */
	public void addOperators(ArrayList<Operator> listOperators) {
		for (int i = 0; i < listOperators.size(); i++) {
			addOperator(listOperators.get(i));
		}
	}

	/*
	 * Choix de l'operateur qui prendra la requete.
	 */
	public Operator pickOperator() {
		Operator chosenOp = null;
		int i = 0;

		// Tirage aleatoire (entre 0 et 'sumReputation') pour le choix de
		// l'operateur.
		double opChoice = Math.random() * (sumReputation);
		double sum = 0;

		while (i < listOperators.size() && chosenOp == null) {
			if (useCase == 0 || (useCase == 1 && listOperators.get(i).getCapacity() >= client.getWeight())) {
				sum += listOperators.get(i).getReputation();
				if (opChoice < sum) {
					chosenOp = listOperators.get(i);
				}
			}
			i++;
		}
		if (chosenOp == null) {
			System.out.println("Aucun opérateur ne peut accepter la requete");
			return null;
		}
		return chosenOp;
	}

	/*
	 * Modification de la reputation et ajout de la requete en cas de reussite.
	 */
	public void requestTreatment(Client client, Operator operator) {
		double failure = Math.random();

		if (client.getWeight() > operator.getCapacity() || failure <= operator.failChance()) {
			operator.setRepFailed();
		} else {
			operator.setRepSuccess();
			operator.addRequest(client.copyClient());
		}

		updateSumReputation();
	}

	/*
	 * Lancement de la boucle de simulation.
	 */
	public void runSimulation() {
		ArrayList<Operator> listOp = new ArrayList<Operator>();
		Operator chosenOp;
		// Initialisation des valeurs par defaut.
		final int DEFAULT_CAP1 = 10000;
		final int DEFAULT_CAP2 = 5000;
		final double DEFAULT_REP1 = 0.6;
		final double DEFAULT_REP2 = 0.8;

		// Initialisation de l'entr�e/sortie fichier.
		OutputStreamWriter fileOut = null;
		try {
			fileOut = new OutputStreamWriter(new FileOutputStream(new File(FILE_NAME)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// Creation des operateurs et du client.
		Operator op1 = new Operator(DEFAULT_CAP1, DEFAULT_REP1);
		Operator op2 = new Operator(DEFAULT_CAP2, DEFAULT_REP2);
		Client client = new Client();
		listOp.add(op1);
		listOp.add(op2);
		addOperators(listOp);

		/* Lancement de la simulation */
		while (simulationTime != 0) {
			// Verification, pour chaque operateur, du temps restant pour les
			// requetes.
			for (int i = 0; i < listOperators.size(); ++i) {
				listOperators.get(i).checkRequestsState();
			}

			chosenOp = pickOperator();
			if (chosenOp != null)
				requestTreatment(client, chosenOp);
			else
				break;
			// Ecriture en fichier des param�tres de la simulation
			try {
				fileOut.write("op1 rep = " + op1.getReputation() + " op2 rep = " + op2.getReputation()
						+ System.lineSeparator());
				fileOut.flush();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			--simulationTime;
		}
		// On r�initialise les param�tres pour la prochaine simulation.
		listOperators.clear();
		setSumReputation(0);

		// Fermeture du fichier
		try {
			if (fileOut != null)
				fileOut.close();
		} catch (IOException e2) {
			e2.printStackTrace();
		}

		// Ouverture du fichier en fin de simulation
		if (Desktop.isDesktopSupported()) {
			if (Desktop.getDesktop().isSupported(java.awt.Desktop.Action.OPEN)) {
				File file = new File(FILE_NAME);
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
