package org.minakdev.aktoreenLotura.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.minakdev.aktoreak.Aktoreak;
import org.minakdev.aktoreenLotura.Graph2;

public class Graph2Test {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void testKonektatutaErlazioa() {
		Graph2 grafoa = new Graph2();
		ArrayList<String> erlazioa;		
		
		Aktoreak.getNireAktoreak().fitxategiaKargatu("aktore-zerrenda_lotura2.txt");

		grafoa.grafoaSortu(Aktoreak.getNireAktoreak().aktoreZerrendaItzuli());
		grafoa.print();
		
		
		//erlazio sinplea
		erlazioa = grafoa.konektatutaErlazioa("Lynn, Sonia", "Harrington, Adria");
		System.out.println(erlazioa.toString()); //[Lynn, Sonia, I Kill to Luv You, Harrington, Adria]
		assertTrue(grafoa.konektatuta("Lynn, Sonia", "Harrington, Adria"));
		assertSame(erlazioa.size(), 3);
		assertEquals("Lynn, Sonia", erlazioa.get(0));
		assertEquals("I Kill to Luv You", erlazioa.get(1));
		assertEquals("Harrington, Adria", erlazioa.get(2));
		
		
		//ez daude konektatuta
		assertNull(grafoa.konektatutaErlazioa("Alcala, Jennifer", "Lynn, Sonia"));
		assertFalse(grafoa.konektatuta("Alcala, Jennifer", "Lynn, Sonia"));
		
		//erlazio luzea
		erlazioa = grafoa.konektatutaErlazioa("McKown, Anna K.", "Rondon, Ali");
		System.out.println(erlazioa.toString());
		//[McKown, Anna K., Kalamazoo?, McKelly, Mike, The Dread, Walker, Kristin (II), Angel Unaware: The Tara Cole Story, Marconi, Gino, Hermano, Rondon, Ali]
		assertTrue(grafoa.konektatuta("McKown, Anna K.", "Rondon, Ali"));
		assertSame(erlazioa.size(), 9);
		assertEquals("McKown, Anna K.", erlazioa.get(0));
		assertEquals("Kalamazoo?", erlazioa.get(1));
		assertEquals("McKelly, Mike", erlazioa.get(2));
		assertEquals("The Dread", erlazioa.get(3));
		assertEquals("Walker, Kristin (II)", erlazioa.get(4));
		assertEquals("Angel Unaware: The Tara Cole Story", erlazioa.get(5));
		assertEquals("Marconi, Gino", erlazioa.get(6));
		assertEquals("Hermano", erlazioa.get(7));
		assertEquals("Rondon, Ali", erlazioa.get(8));
		
		
		Aktoreak.getNireAktoreak().erreseteatu();
		Aktoreak.getNireAktoreak().fitxategiaKargatu("aktore-zerrenda_lotura3.txt");

		grafoa.grafoaSortu(Aktoreak.getNireAktoreak().aktoreZerrendaItzuli());
		grafoa.print();
		
		//2 bide daudenean laburrena
		erlazioa = grafoa.konektatutaErlazioa("McKown, Anna K.", "Rondon, Ali");
		System.out.println(erlazioa.toString());
		//[McKown, Anna K., Kalamazoo?, McKelly, Mike, The Dread, Aktorea123, Me Pesas en la Cabeza, Rondon, Ali]
		assertTrue(grafoa.konektatuta("McKown, Anna K.", "Rondon, Ali"));
		assertSame(erlazioa.size(), 7);
		assertEquals("McKown, Anna K.", erlazioa.get(0));
		assertEquals("Kalamazoo?", erlazioa.get(1));
		assertEquals("McKelly, Mike", erlazioa.get(2));
		assertEquals("The Dread", erlazioa.get(3));
		assertEquals("Aktorea123", erlazioa.get(4));
		assertEquals("Me Pesas en la Cabeza", erlazioa.get(5));
		assertEquals("Rondon, Ali", erlazioa.get(6));
	}
	
}
