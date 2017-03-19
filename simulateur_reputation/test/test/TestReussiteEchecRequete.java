package test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import projet.Client;
import projet.Main;
import projet.Operator;
import projet.Simulation;

public class TestReussiteEchecRequete {
	protected Operator op1;
	protected Operator op2;
	protected Client client;
	protected double sumReputation = 0;
	protected int simulationTime = 20;
	int testEchec = 0;
	int testEchec2 = 0;
	protected Simulation simulation;

	@Before
	public void setUp() throws Exception {
		simulation = new Simulation();
		op1 = new Operator("op1", 5000, 0.5);
		op2 = new Operator("op2", 10000, 0.6);
		client = new Client();
		Main.listOp.add(op1);
		Main.listOp.add(op2);
		System.out.println(Main.listOp.size());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Operator chosenOp;
		simulation.addOperators(Main.listOp);

		/* Lancement de la simulation */
		while (simulationTime != 0) {

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
			assertEquals(testEchec, testEchec2);
		}
	}
}
