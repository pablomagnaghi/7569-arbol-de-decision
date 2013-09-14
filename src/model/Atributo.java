package model;

import java.util.HashMap;

public class Atributo {

	private String name;
	private HashMap<String, String> valoresPosibles;
	
	public Atributo(String name){
		this.setName(name);
		this.valoresPosibles  = new HashMap<String, String>();
	}
	
	public void addResultadoParaValorPosible(String nombre, String decision){
		valoresPosibles.put(nombre, decision);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		String s = "Nombre: " + name + "\r\n";
		s += "ValoresPosibles: \r\n";
		for (String valores : valoresPosibles.keySet()) {
			s += valores;
			s += " - " + valoresPosibles.get(valores);
			s += "\r\n";
		}
		return s;
	}

}
