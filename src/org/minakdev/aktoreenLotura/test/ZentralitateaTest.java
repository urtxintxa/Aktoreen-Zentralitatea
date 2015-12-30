package org.minakdev.aktoreenLotura.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.minakdev.aktoreak.Aktoreak;
import org.minakdev.aktoreenLotura.Graph2;

public class ZentralitateaTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testZentralitateakLortu() {
		Graph2 grafoa = new Graph2();	
		
		Aktoreak.getNireAktoreak().fitxategiaKargatu("aktore-zerrenda_handia.txt");

		grafoa.grafoaSortu(Aktoreak.getNireAktoreak().aktoreZerrendaItzuli());
		
		grafoa.zentralitateakLortu();
	}

}
