package it.polito.tdp.parole.model;

import java.util.*;

public class Parole {
	
	List<String>parole;
		
	public Parole() {
		parole= new LinkedList<String>();
		
	}
	
	public void addParola(String p) {
		parole.add(p);
		
		
	}
	
	public List<String> getElenco() {
		LinkedList <String> temp=new LinkedList<String>(parole);
		Collections.sort(temp, new ComparatoreParoleAlfa());
		
		return temp;
	}
	
	public void reset() {
		parole.removeAll(parole);
		
	}

}
