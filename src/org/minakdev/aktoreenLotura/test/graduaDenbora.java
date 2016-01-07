package org.minakdev.aktoreenLotura.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.minakdev.aktoreak.Aktoreak;
import org.minakdev.aktoreenLotura.Graph2;

public class graduaDenbora {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Graph2 grafoa = new Graph2();
		Stopwatch denbora;
		
		Aktoreak.getNireAktoreak().fitxategiaKargatu("aktore-zerrenda_lotura3.txt");
		grafoa.grafoaSortu(Aktoreak.getNireAktoreak().aktoreZerrendaItzuli());	
		
		System.out.println("aktore-zerrenda_lotura3.txt----------------------------");
		System.out.println("Tamaina: " + Aktoreak.getNireAktoreak().luzera());
		
		System.out.print("Denbora: ");
		denbora = new Stopwatch();
		grafoa.erlazioenGradua();
		System.out.println(denbora.elapsedTime());
		
		System.out.println();
		Aktoreak.getNireAktoreak().erreseteatu();
		
		//------------------------------------------------
		
		Aktoreak.getNireAktoreak().fitxategiaKargatu("aktore-zerrenda_ertaina.txt");
		grafoa.grafoaSortu(Aktoreak.getNireAktoreak().aktoreZerrendaItzuli());	
		
		System.out.println("aktore-zerrenda_ertaina.txt----------------------------");
		System.out.println("Tamaina: " + Aktoreak.getNireAktoreak().luzera());
		
		System.out.print("Denbora: ");
		denbora = new Stopwatch();
		grafoa.erlazioenGradua();
		System.out.println(denbora.elapsedTime());
		
		System.out.println();
		Aktoreak.getNireAktoreak().erreseteatu();
		
		//------------------------------------------------
		
		Aktoreak.getNireAktoreak().fitxategiaKargatu("aktore-zerrenda_handia.txt");
		grafoa.grafoaSortu(Aktoreak.getNireAktoreak().aktoreZerrendaItzuli());	
		
		System.out.println("aktore-zerrenda_handia.txt----------------------------");
		System.out.println("Tamaina: " + Aktoreak.getNireAktoreak().luzera());
		
		System.out.print("Denbora: ");
		denbora = new Stopwatch();
		grafoa.erlazioenGradua();
		System.out.println(denbora.elapsedTime());
		
		System.out.println();
	}

}
