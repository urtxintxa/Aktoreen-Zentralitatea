package org.minakdev.aktoreenLotura.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.minakdev.aktoreak.Aktorea;
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
		
		Aktoreak.getNireAktoreak().fitxategiaKargatu("aktore-zerrenda_lotura3.txt");

		grafoa.grafoaSortu(Aktoreak.getNireAktoreak().aktoreZerrendaItzuli());
		
		grafoa.zentralitateakLortu(1000);
		assertEquals(Aktoreak.getNireAktoreak().bilatuZentralitatea("Lynn, Sonia").getZentralitatea(), 0.0, 0);
		assertEquals(Aktoreak.getNireAktoreak().bilatuZentralitatea("Harrington, Adria").getZentralitatea(), 0.0, 0);
		assertEquals(Aktoreak.getNireAktoreak().bilatuZentralitatea("McKown, Anna K.").getZentralitatea(), 0.0, 0);
		assertEquals(Aktoreak.getNireAktoreak().bilatuZentralitatea("Koenig, CJ").getZentralitatea(), 0.0, 0);
		assertEquals(Aktoreak.getNireAktoreak().bilatuZentralitatea("Alcala, Jennifer").getZentralitatea(), 0.0, 0);
		System.out.println(Aktoreak.getNireAktoreak().bilatuZentralitatea("McKelly, Mike").getZentralitatea());
		System.out.println(Aktoreak.getNireAktoreak().bilatuZentralitatea("Walker, Kristin (II)").getZentralitatea());
		System.out.println(Aktoreak.getNireAktoreak().bilatuZentralitatea("Marconi, Gino").getZentralitatea());
		System.out.println(Aktoreak.getNireAktoreak().bilatuZentralitatea("Rondon, Ali").getZentralitatea());
		System.out.println(Aktoreak.getNireAktoreak().bilatuZentralitatea("Aktorea123").getZentralitatea());
		assertEquals(Aktoreak.getNireAktoreak().bilatuZentralitatea("McKelly, Mike").getZentralitatea(), 0.3529, 0.1);
		assertEquals(Aktoreak.getNireAktoreak().bilatuZentralitatea("Walker, Kristin (II)").getZentralitatea(), 0.4706, 0.1);
		assertEquals(Aktoreak.getNireAktoreak().bilatuZentralitatea("Marconi, Gino").getZentralitatea(), 0.5294, 0.1);
		assertEquals(Aktoreak.getNireAktoreak().bilatuZentralitatea("Rondon, Ali").getZentralitatea(), 0.0588, 0.1);
		assertEquals(Aktoreak.getNireAktoreak().bilatuZentralitatea("Aktorea123").getZentralitatea(), 0.1176, 0.1);
		
		Aktoreak.getNireAktoreak().zentralitatearenAraberaOrdenatu();
		ArrayList<Aktorea> aktZer= Aktoreak.getNireAktoreak().getZentralitateHandienekoak(0);
		assertSame(aktZer.size(), 0);
		
		aktZer = Aktoreak.getNireAktoreak().getZentralitateHandienekoak(1);
		assertSame(aktZer.size(), 1);
		assertEquals("Marconi, Gino", aktZer.get(0).getIzena());
		
		aktZer = Aktoreak.getNireAktoreak().getZentralitateHandienekoak(5);
		assertSame(aktZer.size(), 5);
		assertEquals("Marconi, Gino", aktZer.get(0).getIzena());
		assertEquals("Walker, Kristin (II)", aktZer.get(1).getIzena());
		assertEquals("McKelly, Mike", aktZer.get(2).getIzena());
		assertEquals("Aktorea123", aktZer.get(3).getIzena());
		assertEquals("Rondon, Ali", aktZer.get(4).getIzena());
		
		
		
	}

}
