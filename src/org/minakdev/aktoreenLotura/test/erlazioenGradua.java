package org.minakdev.aktoreenLotura.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.minakdev.aktoreak.Aktoreak;
import org.minakdev.aktoreenLotura.Graph2;

public class erlazioenGradua {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Graph2 grafoa = new Graph2();	
		
		Aktoreak.getNireAktoreak().fitxategiaKargatu("aktore-zerrenda_lotura3.txt");

		grafoa.grafoaSortu(Aktoreak.getNireAktoreak().aktoreZerrendaItzuli());
		double gradua = grafoa.erlazioenGradua();
		System.out.println(gradua);
		assertEquals(gradua, 1.92857, 0.1);
		
		
		
	}

}
