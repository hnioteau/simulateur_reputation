package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import projet.Client;
import projet.Operator;
import projet.Simulation;

public class TestChoixOperator {
	protected Operator op1;
	protected Operator op2;
	protected Client client;
	protected double sumReputation = 0;
	protected int simulationTime = 20;
	protected ArrayList<Operator> listOperators;
	protected ArrayList<Operator> listOp;
	protected Simulation simulation;

	@Before
	public void setUp() throws Exception {
		op1 = new Operator(5000, 0.5);
		op2 = new Operator(10000, 0.6);
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
		listOp.add(op2);
		addOperators(listOp);
		while (simulationTime != 0) {
			// Verification, pour chaque operateur, du temps restant pour les
			// requetes.
			for (int i = 0; i < listOperators.size(); ++i) {
				listOperators.get(i).checkRequestsState();
			}

			Operator chosenOp = null;
			Operator testOp = null;
			int i = 0;

			// Tirage aleatoire (entre 0 et 'sumReputation') pour le choix de
			// l'operateur.
			double opChoice = Math.random() * (sumReputation);
			double sum = 0;

			while (i < listOperators.size() && chosenOp == null) {
				sum += listOperators.get(i).getReputation();
				if (opChoice < sum) {
					chosenOp = listOperators.get(i);
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