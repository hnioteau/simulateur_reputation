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
	private Client client = new Client();
	private double sumReputation;
	private int simulationTime;
	private int opChoiceCase = 0;
	private int failChanceCase = 0;
	private static double repFactor = 0.5; // facteur de la formule de
											// modification de reputation

	private final int DEFAULT_TIME = 20;
	private final String FILE_NAME = "results.txt";

	/*
	 * Constructeur de la classe.
	 */
	public Simulation() {
		setSumReputation(0);
		setSimulationTime(DEFAULT_TIME);
	}


	/*
	 * Mise a jour de la somme des reputations.
	 */
	public void updateSumReputation() {
		double sum = 0;

		for (int i = 0; i < getListOperators().size(); i++) {
			sum += getListOperators().get(i).getReputation();
		}

		setSumReputation(sum);
	}

	/*
	 * Ajout d'un ensemble d'operateurs a la liste des operateurs.
	 */
	public void addOperators(ArrayList<Operator> listOperators) {
		for (int i = 0; i < listOperators.size(); i++) {
			this.getListOperators().add(listOperators.get(i));
			this.sumReputation += listOperators.get(i).getReputation();
		}
	}

	/*
	 * Recupere tous les operateurs capables d'executer la requete.
	 */
	public ArrayList<Operator> getAvailalbleOperators(ArrayList<Operator> listOp) {
		ArrayList<Operator> newList = new ArrayList<Operator>();

		for (int i = 0; i < listOp.size(); ++i) {
			if (listOp.get(i).getCapacity() >= client.getWeight())
				newList.add(listOp.get(i));
		}

		return newList;
	}

	/*
	 * Choix de l'operateur qui prendra la requete.
	 */
	public Operator pickOperator() {
		Operator chosenOp = null;
		ArrayList<Operator> tmpList = new ArrayList<Operator>();
		int i = 0;
		double sum = 0;
		double opChoice;

		if (opChoiceCase == 0) {
			tmpList = getListOperators();
			opChoice = Math.random() * (sumReputation);
		} else {
			tmpList = getAvailalbleOperators(getListOperators());
			double tmp = 0;
			for (int j = 0; j < tmpList.size(); j++) {
				tmp += tmpList.get(i).getReputation();
			}
			opChoice = Math.random() * (tmp);
		}

		while (i < tmpList.size() && chosenOp == null) {
			sum += tmpList.get(i).getReputation();
			if (opChoice < sum)
				chosenOp = tmpList.get(i);

			i++;
		}

		if (chosenOp == null) {
			return null;
		}

		return chosenOp;
	}

	/*
	 * Modification de la reputation et ajout de la requete en cas de reussite.
	 */
	public void requestTreatment(Client client, Operator operator) {
		double failure = Math.random();

		if (failChanceCase == 0) {

			if (client.getWeight() > operator.getCapacity() || failure <= operator.failChance()) {
				operator.setRepFailed();
			} else {
				operator.setRepSuccess();
				operator.addRequest(client.copyClient());
			}

		} else {

			if (client.getWeight() > operator.getCapacity() || failure <= operator.getFixedFailChance()) {
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
		int tmp = simulationTime;

		// Initialisation de l'entree/sortie fichier.
		OutputStreamWriter fileOut = null;
		try {
			fileOut = new OutputStreamWriter(new FileOutputStream(new File(FILE_NAME)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		addOperators(Main.listOp);
		/* Lancement de la simulation */
		while (simulationTime != 0) {
			// Ecriture en fichier des parametres de la simulation
			try {
				for (int i = 0; i < getListOperators().size(); ++i) {
					fileOut.write(
							getListOperators().get(i).getName() + " rep = " + Main.listOp.get(i).getReputation() + " ");
				}
				fileOut.write(System.lineSeparator());
				fileOut.flush();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			// Verification, pour chaque operateur, du temps restant pour les requetes.
			for (int i = 0; i < getListOperators().size(); ++i) {
				getListOperators().get(i).checkRequestsState();
			}

			// Choix de l'operateur par le client.
			chosenOp = pickOperator();
			if (chosenOp != null)
				requestTreatment(client, chosenOp);
			else {
				try {
					fileOut.write("Aucun opérateur ne peut etre choisi.");
					fileOut.write(System.lineSeparator());
					fileOut.flush();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				break;
			}
			--simulationTime;
		}

		// Ecriture en fichier des parametres de la simulation
		try {
			for (int i = 0; i < getListOperators().size(); ++i) {
				fileOut.write(
						getListOperators().get(i).getName() + " rep = " + Main.listOp.get(i).getReputation() + " ");
			}
			fileOut.write(System.lineSeparator());
			fileOut.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		// On reinitialise les parametres pour la prochaine simulation.
		for (int i = 0; i < Main.listOp.size(); ++i)
			Main.listOp.get(i).setReputation(Main.listOp.get(i).getReputationInit());
		updateSumReputation();
		simulationTime = tmp;
		

		// Fermeture de la sortie fichier
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

	public double getRepFactor() {
		return repFactor;
	}

	public static void setRepFactor(double repFactor) {
		Simulation.repFactor = repFactor;
	}

	public int getUseCase() {
		return opChoiceCase;
	}

	public void setUseCase(int useCase) {
		this.opChoiceCase = useCase;
	}

	public int getFailChanceCase() {
		return failChanceCase;
	}

	public void setFailChanceCase(int failChanceCase) {
		this.failChanceCase = failChanceCase;
	}

	public ArrayList<Operator> getListOperators() {
		return listOperators;
	}

	public void setListOperators(ArrayList<Operator> listOperators) {
		this.listOperators = listOperators;
	}

}
