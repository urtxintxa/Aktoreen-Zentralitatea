package org.minakdev.aktoreak;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import TartetikKanpoException.TartetikKanpoException;

public class Aktoreak {

	private static Aktoreak nireAktoreak;
	private AktoreZerrenda aktoreZerrenda;

	private Aktoreak() {
		aktoreZerrenda = new AktoreZerrenda();
	}
	
	
	public static Aktoreak getNireAktoreak() {
		if (nireAktoreak == null) {
			nireAktoreak = new Aktoreak();
		}
		return nireAktoreak;
	}

	
//	public static void main(String[] args) {
//		
//		Scanner sc = new Scanner(System.in);
//		String fitxategia = "aktore-zerrenda_handia.txt";
//		
//		Aktoreak.getNireAktoreak().fitxategiaKargatu(fitxategia);
//		
//		System.out.println("AKOTEAK ETA PELIKULAK KUDEATZEKO APLIKAZIOA");
//		do{
//			System.out.println("\nAplikazio honek aukera hauek ditu:");
//			System.out.println("1 - Aktore bat bilatu");
//			System.out.println("2 - Aktore berri bat txertatu");
//			System.out.println("3 - Aktore baten pelikulak ikusi");
//			System.out.println("4 - Pelikula baten aktoreak ikusi");
//			System.out.println("5 - Pelikula batek lortutako dirua ezarri");
//			System.out.println("6 - Aktore bat ezabatu");
//			System.out.println("7 - Aktoreen zerrenda gorde");
//			System.out.println("8 - Irten");
//			
//			System.out.println();
//			
//			int aukera = 0;
//			boolean ezAmaitu = true;
//			
//			do {
//				try {
//					System.out.println("Hautatu nahi duzun aukera: ");
//					aukera = sc.nextInt();	
//					if(aukera > 8 || aukera < 1){
//						throw new TartetikKanpoException("Zenbaki okerra hautatu duzu.");
//					}
//					ezAmaitu = false;
//				} catch (InputMismatchException  e) {
//					sc.nextLine();
//					aukera = 0;
//					System.out.println("Zenbaki okerra hautatu duzu.");
//				} catch (TartetikKanpoException e) {
//					System.out.println(e.getMessage());
//				}
//			} while (ezAmaitu);
//			
//			if (aukera == 1){
//				String izena =Aktoreak.getNireAktoreak().stringEskatu();
//				if (Aktoreak.getNireAktoreak().aktoreaBilatu(izena) == null) 
//					System.out.println("Aktorea ez da bilatu");
//				else
//					System.out.println("Aktorea bilatu da.");
//			}
//			else if(aukera == 2){
//				String izena =Aktoreak.getNireAktoreak().stringEskatu();
//				Aktoreak.getNireAktoreak().aktoreaTxertatu(izena);
//			}
//			else if(aukera == 3){
//				Aktoreak.getNireAktoreak().aktoreBatenPelikulakBueltatu();
//			}
//			else if(aukera == 4){
//				Aktoreak.getNireAktoreak().pelikulaBatekoAktoreakBueltatu();
//			}
//			else if(aukera == 5){
//				Aktoreak.getNireAktoreak().diruaGehitu();
//			}
//			else if(aukera == 6){
//				String izena =Aktoreak.getNireAktoreak().stringEskatu();
//				Aktoreak.getNireAktoreak().aktoreaEzabatu(izena);
//			}
//			else if(aukera == 7){
//				try {
//					Aktoreak.getNireAktoreak().aktoreenZerrendaGorde();
//				} catch (FileNotFoundException e) {
//					e.printStackTrace();
//				} catch (UnsupportedEncodingException e) {
//					e.printStackTrace();
//				} 
//			}
//			else if(aukera == 8){
//				System.exit(0);
//			}
//		}while(true);
//		
//		
//	}
	
	private float diruaEskatu(){
		float n;
		Scanner sc = new Scanner(System.in);
		boolean ezAmaitu = true;
		
		do {
			try {
				System.out.println("Sartu diru kantitate bat: ");
				n = sc.nextFloat();
				ezAmaitu=false;
			} catch (InputMismatchException e) {
				sc.nextLine();
				n = 0;
				System.out.println("Sartu duzuna ez da diru kantitate bat.");
			} 
		}while (ezAmaitu);
		
		return n;
	}
	
	private String stringEskatu(){
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		String izena = sc.nextLine();
		return izena;
		
	}
	
	public void fitxategiaKargatu(String pFitxategia) {
		
		try {
			
			Scanner sc = new Scanner(new FileReader(pFitxategia));
						
			Aktoreak.getNireAktoreak().sortuAktorea(sc);
			
			sc.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Aktoreak.getNireAktoreak().aktoreakOrdenatu();
	}
	
	public void aktoreenZerrendaGorde() throws FileNotFoundException, UnsupportedEncodingException {		
		PrintWriter idatzi = new PrintWriter("ZerrendaBerria.txt", "UTF-8");
		
		Iterator<Aktorea> itr =  Aktoreak.getNireAktoreak().getAktoreZerrenda().iterator();
		
		while(itr.hasNext()) {
			Aktorea egungoAktorea = itr.next();
			idatzi.print(egungoAktorea.getIzena());
			
			Iterator<Pelikula> itr2 = egungoAktorea.getIteradorea();
			while (itr2.hasNext()) {
				Pelikula egungoPelikula = itr2.next();
				idatzi.print(" ### "+egungoPelikula.getIzena());
			}
			idatzi.print("\n");
		}
		
		idatzi.close();
		
		System.out.println("Zerrenda \"ZerrendaBerria.txt\" fitxategia gorde da");
	}
	

	public PelikulaZerrenda aktoreBatenPelikulakBueltatu() {
		System.out.println("Sartu aktorearen izena:");
		String izena = this.stringEskatu();
		Aktorea aktorea = Aktoreak.getNireAktoreak().aktoreaBilatu(izena);
		if(aktorea == null) {
			System.out.println("Aktorea ez da existitzen edo izena txarto sartu duzu.");
			return null;
		}
		else {
			return aktorea.pelikulakBueltatu();
		}
	}
	
	public AktoreZerrenda pelikulaBatekoAktoreakBueltatu() {
		System.out.println("Sartu pelikularen izena:");
		String izenburu = this.stringEskatu();
		Pelikula pelikula = Pelikulak.getNirePelikulak().pelikulaBueltatu(izenburu);
		if (pelikula == null){
			System.out.println("Pelikula ez da existitzen edo izena txarto sartu duzu");
			return null;
		}
		else { 
			return pelikula.aktoreakBueltatu();
			
		}
	}
	
	
	public void diruaGehitu() {
		System.out.println("Sartu pelikularen izena");
		String pelIzen=this.stringEskatu();
		Pelikula peli= Pelikulak.getNirePelikulak().pelikulaBueltatu(pelIzen);
		if(peli==null){
			System.out.println("Pelikula hori ez dago. Ezin da dirurik gehitu.");
		}
		else{
			float n=this.diruaEskatu();
			peli.diruaGehitu(n);
		}	
		
	}
	
	
	public ArrayList<Aktorea> getAktoreZerrenda() {
		return this.aktoreZerrenda.getZerrenda();
	}
	
	public AktoreZerrenda aktoreZerrendaItzuli(){
		return this.aktoreZerrenda;
	}
	
	private void sortuAktorea(Scanner pFitxategi) {
		HashMap<String, Pelikula> hashTable = new HashMap<String, Pelikula>();
		int k=0;
		while(pFitxategi.hasNext()){
			System.out.println(k++);
			String pAktoreaPelikulak = pFitxategi.nextLine();
			String [] atalak = pAktoreaPelikulak.split("\\s*###\\s*");
			
			Aktorea aktoreBerria = new Aktorea(atalak[0]);
			
			for (int i = 1; i < atalak.length; i++) {
				String pelikulaIzena = atalak[i];
				Pelikula pelikula = hashTable.get(pelikulaIzena);
			
				if(pelikula == null) {
					pelikula = new Pelikula(pelikulaIzena);
					Pelikulak.getNirePelikulak().sartuPelikula(pelikula);
					hashTable.put(pelikulaIzena, pelikula);
				}
				
				aktoreBerria.sartuPelikula(pelikula);
				pelikula.sartuAktorea(aktoreBerria);
			}
			
			aktoreZerrenda.aktoreaSartu(aktoreBerria);
		}
	}
	
	public void aktoreaSartu(Aktorea pAktorea) {
		aktoreZerrenda.aktoreaSartu(pAktorea);
	}
	
	public Aktorea aktoreaBilatu (String izena) {
		return aktoreZerrenda.aktoreaBilatu(izena);
		
	}
	
	public void aktoreakOrdenatu() {
		 this.aktoreZerrenda.aktoreakOrdenatu();
	}
	
	public void aktoreaEzabatu(String izena){
		Aktorea aktorea=this.aktoreaBilatu(izena);
		if (aktorea==null){
			System.out.println("Ezin da aktorea ezabatu ez baitago.");
		}
		else{
			aktorea.pelikuletatikEzabatu();
			aktoreZerrenda.aktoreaEzabatu(aktorea);
		}
		
	}
	
	public void aktoreaTxertatu(String izena){
		aktoreZerrenda.aktoreaTxertatu(izena);
	}
	
	//Junit-ak probatzeko
	
	public void erreseteatu(){
		this.aktoreZerrenda.erreseteatu();
	}
	
	public int luzera(){
		return this.aktoreZerrenda.luzera();
	}
}
