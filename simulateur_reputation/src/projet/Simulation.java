package projet;

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
	private int useCase = 0;
	private int probaEchecCase = 0;
	Client client = new Client();
	final int DEFAULT_TIME = 20;
	private static double repFactor = 0.5; // facteur de la formule de
	// modification de reputation
	final String FILE_NAME = "results.txt";

	/*
	 * Constructeur de la classe.
	 */
	public Simulation() {
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
		if (probaEchecCase == 0) {
			if (client.getWeight() > operator.getCapacity() || failure <= operator.failChance()) {
				operator.setRepFailed();
			} else {
				operator.setRepSuccess();
				operator.addRequest(client.copyClient());
			}
		} else {
			if (client.getWeight() > operator.getCapacity() || failure <= operator.getProbaEchecfixe()) {
				operator.setRepFailed();
			} else {
				operator.setRepSuccess();
				operator.addRequest(client.copyClient());
			}
		}

		updateSumReputation();
	}

	/*
	 * Lancement de la boucle de simulation.
	 */
	public void runSimulation() {
		Operator chosenOp;

		// Initialisation de l'entr�e/sortie fichier.
		OutputStreamWriter fileOut = null;
		try {
			fileOut = new OutputStreamWriter(new FileOutputStream(new File(FILE_NAME)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		addOperators(Main.listOp);

		/* Lancement de la simulation */
		while (simulationTime != 0) {
			// Ecriture en fichier des param�tres de la simulation
			try {
				for (int i = 0; i < listOperators.size(); ++i) {
					fileOut.write(
							listOperators.get(i).getName() + " rep = " + Main.listOp.get(i).getReputation() + " ");
				}
				fileOut.write(System.lineSeparator());
				fileOut.flush();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
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

			--simulationTime;
		}
		// On r�initialise les param�tres pour la prochaine simulation.
		listOperators.clear();
		setSumReputation(0);
		for (int i = 0; i < Main.listOp.size(); ++i)
			Main.listOp.get(i).setReputation(Main.listOp.get(i).getReputationInit());

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

	public int getUseCase() {
		return useCase;
	}

	public void setUseCase(int useCase) {
		this.useCase = useCase;
	}

	public double getRepFactor() {
		return repFactor;
	}

	public static void setRepFactor(double repFactor) {
		Simulation.repFactor = repFactor;
	}

	public int getProbaEchecCase() {
		return probaEchecCase;
	}

	public void setProbaEchecCase(int probaEchecCase) {
		this.probaEchecCase = probaEchecCase;
	}
}
