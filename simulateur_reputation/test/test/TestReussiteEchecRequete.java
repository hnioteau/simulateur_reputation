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
	protected Client client;
	protected double sumReputation = 0;
	protected int simulationTime = 20;
	boolean testEchec = true;
	boolean testEchec2 = false;
	protected Simulation simulation;

	@Before
	public void setUp() throws Exception {
		simulation = new Simulation();
		op1 = new Operator("op1", 15000, 0.5);
		client = new Client();
		Main.listOp.add(op1);
	}

	@After
	public void tearDown() throws Exception {
	}

	public void requestTreatment(Client client, Operator operator) {
		double failure = Math.random();
		if(this.client.getWeight() > op1.getCapacity() || failure <= op1.failChance()){
			testEchec = true;
		}else{
			testEchec = false;
		}
		if (client.getWeight() > operator.getCapacity() || failure <= operator.failChance()) {
			operator.setRepFailed();
			testEchec2 = true;
		} else {
			operator.setRepSuccess();
			operator.addRequest(client.copyClient());
			testEchec2 = false;
		}

		simulation.updateSumReputation();
	}

	@Test
	public void test() {
		simulation.addOperators(Main.listOp);

		/* Lancement de la simulation */
		while (simulationTime != 0) {

			// Verification, pour chaque operateur, du temps restant pour les
			// requetes.
			for (int i = 0; i < simulation.getListOperators().size(); ++i) {
				simulation.getListOperators().get(i).checkRequestsState();
			}
				requestTreatment(client, op1);
			--simulationTime;
			assertEquals(testEchec, testEchec2);
		}
	}
}
