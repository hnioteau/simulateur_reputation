package test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import projet.Client;
import projet.Main;
import projet.Operator;
import projet.Simulation;

public class TestModifReputation {
	protected Operator op1;
	protected Client client;
	protected double sumReputation = 0;
	protected int simulationTime = 20;
	protected Simulation simulation;
	protected final double RHO = 0.5;

	@Before
	public void setUp() throws Exception {
		simulation = new Simulation();
		op1 = new Operator("op1", 5000, 0.5);
		client = new Client();
		Main.listOp.add(op1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		simulation.addOperators(Main.listOp);
		while (simulationTime != 0) {
			// Verification, pour chaque operateur, du temps restant pour les
			// requetes.
			for (int i = 0; i < simulation.getListOperators().size(); ++i) {
				simulation.getListOperators().get(i).checkRequestsState();
			}
			double failure = Math.random();
			double op1RepTest = op1.getReputation();

			if (client.getWeight() > op1.getCapacity() || failure <= op1.failChance()) {
				op1RepTest = RHO * op1.getReputation();
				op1.setRepFailed();

			} else {
				op1RepTest = RHO * op1.getReputation() + (1.0 - RHO);
				op1.setRepSuccess();
				op1.addRequest(client.copyClient());
			}
			assertEquals(op1.getReputation(), op1RepTest, 0);
			--simulationTime;
		}
	}

}
