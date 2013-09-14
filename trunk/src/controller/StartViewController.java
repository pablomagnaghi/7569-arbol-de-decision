package controller;

import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import model.Atributo;
import model.Manager;
import utilities.Constants;
import view.AttackCalculatorView;
import view.ChooseOptionView;
import view.StartView;

public class StartViewController {
	
	private StartView view;
	private AttackCalculatorView attackView;
	private ChooseOptionView currentOption = null;
	private Manager manager;

	public StartViewController(){
		this.manager = new Manager();
	}
	
	public void setView(StartView window) {
		this.view = window;
	}

	public void elegir(String nombreAttributo) {
		List<String> listOfAttribute = this.manager.getListOfAttribute(nombreAttributo);
		currentOption = new ChooseOptionView(nombreAttributo, listOfAttribute, this, this.manager.getCurrentAttr());
		this.view.hide();
		this.currentOption.setVisible(Boolean.TRUE);
	}

	public void handleButtonTerminar(String nombreAttr) {
		Boolean goToNextView = Boolean.FALSE;
		this.view.getAtributos().remove(nombreAttr);
		Atributo att = new Atributo(nombreAttr);
		
		String attrUno = this.currentOption.getAttrUno();
		JRadioButton unoSi = this.currentOption.getUnoSi();
		JRadioButton unoNo = this.currentOption.getUnoNo();
		if (unoSi.isSelected()){
			att.addResultadoParaValorPosible(attrUno, Constants.si);
		} else if (unoNo.isSelected()){
			att.addResultadoParaValorPosible(attrUno, Constants.no);
		} else {
			att.addResultadoParaValorPosible(attrUno, Constants.decidirDespues);
		}
		
		String attrdos = this.currentOption.getAttrDos();
		JRadioButton dosSi = this.currentOption.getDosSi();
		JRadioButton dosNo = this.currentOption.getDosNo();
		if (dosSi.isSelected()){
			att.addResultadoParaValorPosible(attrdos, Constants.si);
		} else if (dosNo.isSelected()){
			att.addResultadoParaValorPosible(attrdos, Constants.no);
		} else {
			att.addResultadoParaValorPosible(attrdos, Constants.decidirDespues);
		}
		
		if (this.currentOption.getAttrTres() != null){
			String attrTres = this.currentOption.getAttrTres();
			JRadioButton tresSi = this.currentOption.getTresSi();
			JRadioButton tresNo = this.currentOption.getTresNo();
			if (tresSi.isSelected()){
				att.addResultadoParaValorPosible(attrTres, Constants.si);
			} else if (tresNo.isSelected()){
				att.addResultadoParaValorPosible(attrTres, Constants.no);
			} else {
				att.addResultadoParaValorPosible(attrTres, Constants.decidirDespues);
			}
		}
		
		if (this.manager.getCurrentAttr()==1){
			this.manager.setPrimerAtributo(att);
		} else if  (this.manager.getCurrentAttr()==2){
			this.manager.setSegundoAtributo(att);
		} else if  (this.manager.getCurrentAttr()==3){
			this.manager.setTercerAtributo(att);
		} else if  (this.manager.getCurrentAttr()==4){
			this.manager.setCuartoAtributo(att);
			goToNextView = Boolean.TRUE;
		}
		this.currentOption.setVisible(Boolean.FALSE);
		this.currentOption = null;
		if (!goToNextView){
			this.view.show();
			this.view.fillTable();
		} else {
			this.manager.showFilledTree();
			this.attackView = new AttackCalculatorView();
			this.attackView.setController(this);
			this.attackView.setVisible(Boolean.TRUE);
		}
	}

	public void handleButtonCalcular() {
		long time_start, time_end;
		time_start = System.currentTimeMillis();
		String valor = this.getValorParaAtributo(this.manager.getPrimerAtributo());
		if (valor.equals(Constants.si) || valor.equals(Constants.no)){
			time_end = System.currentTimeMillis();
			JDialog dialogo = new JDialog(); 
			String resultado = "Ataca: " + valor + ", la regla activada es: " +
					this.manager.getPrimerAtributo().getName() + "=" + this.getValorComboParaAtributo(this.manager.getPrimerAtributo()) + "\r\n";
			resultado += "La tarea tomó"+ ( time_end - time_start ) +" milisegundos";
			JOptionPane.showMessageDialog(dialogo,resultado, "Notificacion",
		                    JOptionPane.INFORMATION_MESSAGE);
		} else {
			valor = this.getValorParaAtributo(this.manager.getSegundoAtributo());
			if (valor.equals(Constants.si) || valor.equals(Constants.no)){
				time_end = System.currentTimeMillis();
				JDialog dialogo = new JDialog(); 
				String resultado = "Ataca: " + valor + ", la regla activada es: " +
						this.manager.getPrimerAtributo().getName() + "=" + this.getValorComboParaAtributo(this.manager.getPrimerAtributo()) + "\r\n";
				resultado += this.manager.getSegundoAtributo().getName() + "=" + this.getValorComboParaAtributo(this.manager.getSegundoAtributo()) + "\r\n";
				resultado += "La tarea tomó"+ ( time_end - time_start ) +" milisegundos";
				JOptionPane.showMessageDialog(dialogo,resultado, "Notificacion",
			                    JOptionPane.INFORMATION_MESSAGE);
			} else {
				valor = this.getValorParaAtributo(this.manager.getTercerAtributo());
				if (valor.equals(Constants.si) || valor.equals(Constants.no)){
					time_end = System.currentTimeMillis();
					JDialog dialogo = new JDialog(); 
					String resultado = "Ataca: " + valor + ", la regla activada es: " +
							this.manager.getPrimerAtributo().getName() + "=" + this.getValorComboParaAtributo(this.manager.getPrimerAtributo());
					resultado += this.manager.getSegundoAtributo().getName() + "=" + this.getValorComboParaAtributo(this.manager.getSegundoAtributo()) + "\r\n";
					resultado += this.manager.getTercerAtributo().getName() + "=" + this.getValorComboParaAtributo(this.manager.getTercerAtributo()) + "\r\n";
					resultado += "La tarea tomó"+ ( time_end - time_start ) +" milisegundos";
					JOptionPane.showMessageDialog(dialogo,resultado, "Notificacion",
				                    JOptionPane.INFORMATION_MESSAGE);
				} else {
					valor = this.getValorParaAtributo(this.manager.getCuartoAtributo());
					time_end = System.currentTimeMillis();
					JDialog dialogo = new JDialog(); 
					String resultado = "Ataca: " + valor + ", la regla activada es: " +
							this.manager.getPrimerAtributo().getName() + "=" + this.getValorComboParaAtributo(this.manager.getPrimerAtributo());
					resultado += this.manager.getSegundoAtributo().getName() + "=" + this.getValorComboParaAtributo(this.manager.getSegundoAtributo()) + "\r\n";
					resultado += this.manager.getTercerAtributo().getName() + "=" + this.getValorComboParaAtributo(this.manager.getTercerAtributo()) + "\r\n";
					resultado += this.manager.getCuartoAtributo().getName() + "=" + this.getValorComboParaAtributo(this.manager.getCuartoAtributo()) + "\r\n";
					resultado += "La tarea tomó"+ ( time_end - time_start ) +" milisegundos";
					JOptionPane.showMessageDialog(dialogo,resultado, "Notificacion",
				                    JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}

	private String getValorParaAtributo(Atributo primerAtributo) {
		String valor = null;
		if (primerAtributo.getName().equals(Constants.distancia)){
			valor =  (String) this.attackView.getDistanciaCombo().getSelectedItem();
		} else if (primerAtributo.getName().equals(Constants.nivelVida)){
			valor = (String) this.attackView.getVidaCombo().getSelectedItem();
		} else if (primerAtributo.getName().equals(Constants.tipoArma)){
			valor = (String) this.attackView.getTipoArmaCombo().getSelectedItem();
		} else if (primerAtributo.getName().equals(Constants.visibilidad)){
			valor = (String) this.attackView.getVisibilidadCombo().getSelectedItem();
		}
		if (valor != null){
			return primerAtributo.getAttackLevel(valor);
		}
		return null;
	}

	private String getValorComboParaAtributo(Atributo primerAtributo) {
		String valor = null;
		if (primerAtributo.getName().equals(Constants.distancia)){
			valor =  (String) this.attackView.getDistanciaCombo().getSelectedItem();
		} else if (primerAtributo.getName().equals(Constants.nivelVida)){
			valor = (String) this.attackView.getVidaCombo().getSelectedItem();
		} else if (primerAtributo.getName().equals(Constants.tipoArma)){
			valor = (String) this.attackView.getTipoArmaCombo().getSelectedItem();
		} else if (primerAtributo.getName().equals(Constants.visibilidad)){
			valor = (String) this.attackView.getVisibilidadCombo().getSelectedItem();
		}
		return valor;
	}
	

}
