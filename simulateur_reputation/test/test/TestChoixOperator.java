package test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import projet.Client;
import projet.Main;
import projet.Operator;
import projet.Simulation;

public class TestChoixOperator {
	protected Operator op1;
	protected Operator op2;
	protected Client client;
	protected double sumReputation = 0;
	protected int simulationTime = 20;
	protected Simulation simulation;

	@Before
	public void setUp() throws Exception {
		simulation = new Simulation();
		op1 = new Operator("op1", 5000, 0.5);
		op2 = new Operator("op2", 10000, 0.6);
		client = new Client();
		Main.listOp.add(op1);
		Main.listOp.add(op2);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		simulation.addOperators(Main.listOp);
		while (simulationTime != 0) {

			Operator chosenOp = null;
			Operator testOp = null;
			int i = 0;

			// Tirage aleatoire (entre 0 et 'sumReputation') pour le choix de
			// l'operateur.
			double opChoice = Math.random() * (sumReputation);
			double sum = 0;

			while (i < simulation.getListOperators().size() && chosenOp == null) {
				sum += simulation.getListOperators().get(i).getReputation();
				if (opChoice < sum) {
					chosenOp = simulation.getListOperators().get(i);
				}

				i++;
			}
			if (opChoice < 0.5)
				testOp = op1;
			else
				testOp = op2;
			assertEquals(chosenOp, testOp);
			--simulationTime;
		}
	}
}