package test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import projet.Client;
import projet.Main;
import projet.Operator;
import projet.Simulation;

public class EcritureFichier {
	protected Operator op1;
	protected Client client;
	protected double sumReputation = 0;
	protected int simulationTime = 20;
	protected Simulation simulation;
	protected static final String FILE_NAME = "result.txt";
	protected static final int NB_ECRITURE_FICHIER = 21;
	protected int nbTest = 0;

	@Before
	public void setUp() throws Exception {
		op1 = new Operator("op1", 5000, 0.5);
		simulation = new Simulation();
		client = new Client();
		Main.listOp.add(op1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Operator chosenOp;
		// Initialisation de l'entree/sortie fichier.
		OutputStreamWriter fileOut = null;
		try {
			fileOut = new OutputStreamWriter(new FileOutputStream(new File(FILE_NAME)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		simulation.addOperators(Main.listOp);

		/* Lancement de la simulation */
		while (simulationTime != 0) {
			// Ecriture en fichier des parametres de la simulation
			try {
				++nbTest;
				for (int i = 0; i < simulation.getListOperators().size(); ++i) {
					fileOut.write(simulation.getListOperators().get(i).getName() + " rep = "
							+ Main.listOp.get(i).getReputation() + " ");
				}
				fileOut.write(System.lineSeparator());
				fileOut.flush();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			// Verification, pour chaque operateur, du temps restant pour les
			// requetes.
			for (int i = 0; i < simulation.getListOperators().size(); ++i) {
				simulation.getListOperators().get(i).checkRequestsState();
			}

			// Choix de l'operateur par le client.
			chosenOp = simulation.pickOperator();
			if (chosenOp != null)
				simulation.requestTreatment(client, chosenOp);
			else
				break;

			--simulationTime;
		}

		// Ecriture en fichier des parametres de la simulation
		try {
			++nbTest;
			for (int i = 0; i < simulation.getListOperators().size(); ++i) {
				fileOut.write(simulation.getListOperators().get(i).getName() + " rep = "
						+ Main.listOp.get(i).getReputation() + " ");
			}
			fileOut.write(System.lineSeparator());
			fileOut.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		// Fermeture du fichier
		try {
			if (fileOut != null)
				fileOut.close();
		} catch (IOException e2) {
			e2.printStackTrace();
		}

		assertEquals(nbTest, NB_ECRITURE_FICHIER);

	}
}