package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import projet.Client;
import projet.Operator;
import projet.Simulation;

public class testModifReputation {
	protected Operator op1;
	protected Client client;
	protected double sumReputation = 0;
	protected int simulationTime = 20;
	protected ArrayList<Operator> listOperators;
	protected ArrayList<Operator> listOp;
	protected Simulation simulation;

	@Before
	public void setUp() throws Exception {
		op1 = new Operator("op1", 5000, 0.5);
		client = new Client();
		listOperators = new ArrayList<Operator>();

	}

	@After
	public void tearDown() throws Exception {
	}

	public void addOperator(Operator operator) {
		this.listOperators.add(operator);
		this.sumReputation += operator.getReputation();
	}

	public void addOperators(ArrayList<Operator> listOperators) {
		for (int i = 0; i < listOperators.size(); i++) {
			addOperator(listOperators.get(i));
		}
	}

	@Test
	public void test() {
		ArrayList<Operator> listOp = new ArrayList<Operator>();
		listOp.add(op1);
		addOperators(listOp);
		while (simulationTime != 0) {
			// Verification, pour chaque operateur, du temps restant pour les
			// requetes.
			for (int i = 0; i < listOperators.size(); ++i) {
				listOperators.get(i).checkRequestsState();
			}
			double failure = Math.random();
			double op1RepTest = op1.getReputation();

			if (client.getWeight() > op1.getCapacity() || failure <= op1.failChance()) {
				op1RepTest = 0.5 * op1.getReputation();
				op1.setRepFailed();

			} else {
				op1RepTest = 0.5 * op1.getReputation() + (1.0 - 0.5);
				op1.setRepSuccess();
				op1.addRequest(client.copyClient());
			}
			assertEquals(op1.getReputation(), op1RepTest, 0);
			--simulationTime;
		}
	}

}
