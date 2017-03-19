package test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import projet.Client;
import projet.Operator;
import projet.Simulation;

public class TestTraitementRequete {
	protected Operator op1;
	protected Client client;
	protected int simulationTime = 20;
	protected int capaciteTheorique = 9000;
	
	@Before
	public void setUp() throws Exception {
		op1 = new Operator("op1", 10000, 0.5);
		client = new Client();
		client.setDuration(1);
		new Simulation();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void test() {
		while(simulationTime != 0){
			op1.checkRequestsState();
			op1.addRequest(client);
			assertEquals(capaciteTheorique, op1.getCapacity());
			--simulationTime;
		}
		
	}

}
