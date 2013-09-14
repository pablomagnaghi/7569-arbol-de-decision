package controller;

import java.lang.management.ManagementPermission;
import java.util.List;

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
		
	}

}
