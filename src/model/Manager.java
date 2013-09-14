package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import utilities.Constants;

public class Manager {
	
	private HashMap<String, List<String>> atributosYOpciones;
	private Atributo primerAtributo;
	private Atributo segundoAtributo;
	private Atributo tercerAtributo;
	private Atributo cuartoAtributo;
	private Integer currentAttr;
	
	public Manager(){
		this.atributosYOpciones = new HashMap<String, List<String>>();
		this.fillList(Constants.distancia);
		this.fillList(Constants.tipoArma);
		this.fillList(Constants.nivelVida);
		this.fillList(Constants.visibilidad);
		this.setCurrentAttr(1);
	}

	private void fillList(String tipoAttr) {
		switch (tipoAttr) {
		case Constants.distancia:
			ArrayList<String> listaDistancia = new ArrayList<String>();
			listaDistancia.add(Constants.distancia_cercana);
			listaDistancia.add(Constants.distancia_lejana);
			listaDistancia.add(Constants.distancia_mediana);
			this.atributosYOpciones.put(Constants.distancia, listaDistancia);
			break;
		case Constants.tipoArma:
			ArrayList<String> listaTipoArma = new ArrayList<String>();
			listaTipoArma.add(Constants.tipoArma_ametralladora);
			listaTipoArma.add(Constants.tipoArma_cuchillo);
			listaTipoArma.add(Constants.tipoArma_revolver);
			this.atributosYOpciones.put(Constants.tipoArma, listaTipoArma);
			break;
		case Constants.nivelVida:
			ArrayList<String> listaNivelVida = new ArrayList<String>();
			listaNivelVida.add(Constants.nivelVida_alto);
			listaNivelVida.add(Constants.nivelVida_bajo);
			listaNivelVida.add(Constants.nivelVida_medio);
			this.atributosYOpciones.put(Constants.nivelVida, listaNivelVida);
			break;
		default:
			ArrayList<String> listaVisibilidad = new ArrayList<String>();
			listaVisibilidad.add(Constants.visibilidad_buena);
			listaVisibilidad.add(Constants.visibilidad_mala);
			this.atributosYOpciones.put(Constants.visibilidad, listaVisibilidad);
			break;
		}
	}
	
	public void showTree(){
		for (String s : this.atributosYOpciones.keySet()) {
			System.out.println("Attr: " + s);
			List<String> list = this.atributosYOpciones.get(s);
			for (String string : list) {
				System.out.println("\tValor: " + string);
			}
		}
	}

	public List<String> getListOfAttribute(String nombreAttributo) {
		return this.atributosYOpciones.get(nombreAttributo);
	}

	public Atributo getPrimerAtributo() {
		return primerAtributo;
	}

	public void setPrimerAtributo(Atributo primerAtributo) {
		this.primerAtributo = primerAtributo;
		this.setCurrentAttr(this.getCurrentAttr() + 1);
	}

	public Atributo getSegundoAtributo() {
		return segundoAtributo;
	}

	public void setSegundoAtributo(Atributo segundoAtributo) {
		this.segundoAtributo = segundoAtributo;
		this.setCurrentAttr(this.getCurrentAttr() + 1);
	}

	public Atributo getTercerAtributo() {
		return tercerAtributo;
	}

	public void setTercerAtributo(Atributo tercerAtributo) {
		this.tercerAtributo = tercerAtributo;
		this.setCurrentAttr(this.getCurrentAttr() + 1);
	}

	public Atributo getCuartoAtributo() {
		return cuartoAtributo;
	}

	public void setCuartoAtributo(Atributo cuartoAtributo) {
		this.cuartoAtributo = cuartoAtributo;
		this.setCurrentAttr(this.getCurrentAttr() + 1);
	}

	public Integer getCurrentAttr() {
		return currentAttr;
	}

	public void setCurrentAttr(Integer currentAttr) {
		this.currentAttr = currentAttr;
	}

	public void showFilledTree() {
		System.out.println("Primer atributo");
		System.out.println(this.primerAtributo.toString());
		System.out.println("Segundo atributo");
		System.out.println(this.segundoAtributo.toString());
		System.out.println("Tercer atributo");
		System.out.println(this.tercerAtributo.toString());
		System.out.println("Cuarto atributo");
		System.out.println(this.cuartoAtributo.toString());
	}

}
