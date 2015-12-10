package org.minakdev.aktoreenLotura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import org.minakdev.aktoreak.AktoreZerrenda;
import org.minakdev.aktoreak.Aktorea;
import org.minakdev.aktoreak.Pelikula;

public class Graph2 {
	HashMap<String, Integer> th;
	String[] keys;
	ArrayList<Integer>[] adjList;
	
	public void grafoaSortu(AktoreZerrenda lAktoreak) {
		// Post: aktoreen zerrendatik grafoa sortzen du
		//       Adabegiak aktoreen izenak eta pelikulen izenburuak dira 
		int kont = 0;
		// 1. pausoa: â€œthâ€� bete
		th = new HashMap<String, Integer>();
		
		for (int j = 0; j < lAktoreak.luzera(); j++){
			Aktorea a = lAktoreak.getZerrenda().get(j);
			if (!(th.containsKey(a.getIzena()))){
				th.put(a.getIzena(), kont++);
			}
			ArrayList<Pelikula> pz = a.pelikulakBueltatu().getPelikulaZerrenda();
			for(int k=0; k < pz.size(); k++){
				Pelikula p = pz.get(k);
				if (!(th.containsKey(p.getIzena()))){
					th.put(p.getIzena(), kont++);
				}
			}
		}
		
		// 2. pausoa: â€œkeysâ€� bete
		keys = new String[th.size()];
		for (String k: th.keySet()) keys[th.get(k)] = k;
		
		// 3. pausoa: â€œadjListâ€� bete
		adjList =  new ArrayList[th.size()];
		
		for(int w = 0; w < th.size(); w++){
			adjList[w] = new ArrayList<Integer>();
		}
		
		for(int m = 0; m < lAktoreak.luzera(); m++){
			Aktorea eaktorea = lAktoreak.getZerrenda().get(m);
			ArrayList<Pelikula> epelikulak = eaktorea.pelikulakBueltatu().getPelikulaZerrenda();
			int aktore = th.get(eaktorea.getIzena());
			for(int n=0; n < epelikulak.size(); n++){
				int pelikula = th.get(epelikulak.get(n).getIzena());
				adjList[aktore].add(pelikula);
				adjList[pelikula].add(aktore);
				
			}
			
		}
		
	}
	
	public void print(){
		for (int i = 0; i < adjList.length; i++){
			System.out.print("Element: " + i + " " + keys[i] + " --> ");
			for (int k: adjList[i])  System.out.print(keys[k] + " ### ");
				System.out.println();
		}
	}
		
	public boolean konektatuta(String a1, String a2){
		//aurre: parametroko aktoreak zerrendan (grafoan) egon behar dute
		Queue<Integer> aztertuGabeak = new LinkedList<Integer>();
	
		int pos1 = th.get(a1);
		int pos2 = th.get(a2);
		boolean aurkitua = false;
		boolean[] aztertuak = new boolean[th.size()];
	
		aztertuak[pos1] = true;
		aztertuGabeak.add(pos1);
		
		while(!aurkitua && !aztertuGabeak.isEmpty()) {
				
			Integer egungoa = aztertuGabeak.remove();
			
			if (egungoa == pos2) {
				aurkitua = true;
			}
			else { 
				for(int i: adjList[egungoa]) {
					if(!aztertuak[i]){
						aztertuGabeak.add(i);
						aztertuak[i] = true;
					}
				}
			}
		
		}
		
		return aurkitua;
	}
	
	public ArrayList<String> konektatutaErlazioa(String a1, String a2){
		//aurre: parametroko aktoreak zerrendan (grafoan) egon behar dute
		Integer[] nondik= new Integer[th.size()];
		Queue<Integer> aztertuGabeak = new LinkedList<Integer>();
		
		int pos1 = th.get(a1);
		int pos2 = th.get(a2);
		boolean aurkitua = false;
		boolean[] aztertuak = new boolean[th.size()];
	
		aztertuak[pos1] = true;
		nondik[pos1] = -1;
		aztertuGabeak.add(pos1);
		
		
		while(!aurkitua && !aztertuGabeak.isEmpty()) {
				
			Integer egungoa = aztertuGabeak.remove();
			
			if (egungoa == pos2) {
				aurkitua = true;
			}
			else { 
				for(int i: adjList[egungoa]) {
					if(!aztertuak[i]){
						aztertuGabeak.add(i);
						aztertuak[i]= true;
						nondik[i] = egungoa;
					}
				}
			}
		
		}
		if(!aurkitua){
			return null;
		}
		else{
			int j = pos2;
			ArrayList<String> eran = new ArrayList<String>();
			while(j!=pos1){
				eran.add(this.keys[j]);
				j = nondik[j];
			}
			eran.add(this.keys[j]);
			Collections.reverse(eran);
			return eran;
		}
	}
}
