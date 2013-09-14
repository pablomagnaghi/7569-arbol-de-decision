package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import controller.StartViewController;
import utilities.Constants;

public class ChooseOptionView extends JFrame {

	private JPanel contentPane;
	private JRadioButton unoSi;
	private JRadioButton unoNo;
	private JRadioButton unoDesp;
	private JRadioButton dosSi;
	private JRadioButton dosNo;
	private JRadioButton dosDesp;
	private JRadioButton tresSi;
	private JRadioButton tresNo;
	private JRadioButton tresDesp;
	private String attrUno;
	private String attrDos;
	private String attrTres;
	private StartViewController controller;

	/**
	 * Create the frame.
	 */
	public ChooseOptionView(final String nombreAttr, List<String> listaAtributos, StartViewController startController, Integer attrNumber) {
		this.controller = startController;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblValoresPosiblesY = new JLabel("Valores Posibles y decisión");
		lblValoresPosiblesY.setBounds(166, 29, 258, 26);
		contentPane.add(lblValoresPosiblesY);
		
		JLabel lblAtributo = new JLabel(nombreAttr);
		lblAtributo.setBounds(88, 95, 164, 15);
		contentPane.add(lblAtributo);
		
		JLabel lblAtacar = new JLabel("Atacar");
		lblAtacar.setBounds(377, 95, 70, 15);
		contentPane.add(lblAtacar);
		
		JLabel lblOpcin = new JLabel(listaAtributos.get(0));
		lblOpcin.setBounds(56, 141, 70, 15);
		contentPane.add(lblOpcin);
		this.setAttrUno(listaAtributos.get(0));
		
		setUnoSi(new JRadioButton(Constants.si));
		getUnoSi().setBounds(166, 135, 62, 26);
		getUnoSi().setSelected(Boolean.TRUE);
		contentPane.add(getUnoSi());
		
		setUnoNo(new JRadioButton(Constants.no));
		getUnoNo().setBounds(253, 135, 62, 26);
		contentPane.add(getUnoNo());
		
		if (attrNumber != 4){
			setUnoDesp(new JRadioButton(Constants.decidirDespues));
			getUnoDesp().setBounds(349, 135, 187, 26);
			contentPane.add(getUnoDesp());
			ButtonGroup group1 = new ButtonGroup();
			group1.add(getUnoSi());
			group1.add(getUnoNo());
			group1.add(getUnoDesp());
		} else {
			ButtonGroup group1 = new ButtonGroup();
			group1.add(getUnoSi());
			group1.add(getUnoNo());
		}
		
		
		JLabel lblOpcin_1 = new JLabel(listaAtributos.get(1));
		lblOpcin_1.setBounds(56, 208, 70, 15);
		contentPane.add(lblOpcin_1);
		this.setAttrDos(listaAtributos.get(1));
		
		setDosSi(new JRadioButton(Constants.si));
		getDosSi().setBounds(166, 202, 62, 26);
		getDosSi().setSelected(Boolean.TRUE);
		contentPane.add(getDosSi());
		
		setDosNo(new JRadioButton(Constants.no));
		getDosNo().setBounds(253, 202, 62, 26);
		contentPane.add(getDosNo());
		
		if (attrNumber != 4){
			setDosDesp(new JRadioButton(Constants.decidirDespues));
			getDosDesp().setBounds(349, 202, 187, 26);
			contentPane.add(getDosDesp());
			
			ButtonGroup group2 = new ButtonGroup();
			group2.add(getDosSi());
			group2.add(getDosNo());
			group2.add(getDosDesp());
		} else {
			ButtonGroup group1 = new ButtonGroup();
			group1.add(getUnoSi());
			group1.add(getUnoNo());
		}
		
		if (listaAtributos.size()>2){
			JLabel lblOpcin_2 = new JLabel(listaAtributos.get(2));
			lblOpcin_2.setBounds(56, 279, 70, 15);
			contentPane.add(lblOpcin_2);
			this.setAttrTres(listaAtributos.get(2));


			setTresSi(new JRadioButton(Constants.si));
			getTresSi().setBounds(166, 273, 62, 26);
			getTresSi().setSelected(Boolean.TRUE);
			contentPane.add(getTresSi());

			setTresNo(new JRadioButton(Constants.no));
			getTresNo().setBounds(253, 273, 62, 26);
			contentPane.add(getTresNo());

			if (attrNumber != 4){
				setTresDesp(new JRadioButton(Constants.decidirDespues));
				getTresDesp().setBounds(349, 273, 187, 26);
				contentPane.add(getTresDesp());
				
				ButtonGroup group3 = new ButtonGroup();
				group3.add(getTresSi());
				group3.add(getTresNo());
				group3.add(getTresDesp());
			} else {
				ButtonGroup group3 = new ButtonGroup();
				group3.add(getTresSi());
				group3.add(getTresNo());
			}
		}
		
		JButton btnTerminar = new JButton("Terminar");
		btnTerminar.setBounds(230, 361, 117, 25);
		btnTerminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.handleButtonTerminar(nombreAttr);
			}
		});
		contentPane.add(btnTerminar);
		
	}

	public JRadioButton getUnoSi() {
		return unoSi;
	}

	public void setUnoSi(JRadioButton unoSi) {
		this.unoSi = unoSi;
	}

	public JRadioButton getUnoNo() {
		return unoNo;
	}

	public void setUnoNo(JRadioButton unoNo) {
		this.unoNo = unoNo;
	}

	public JRadioButton getUnoDesp() {
		return unoDesp;
	}

	public void setUnoDesp(JRadioButton unoDesp) {
		this.unoDesp = unoDesp;
	}

	public JRadioButton getDosSi() {
		return dosSi;
	}

	public void setDosSi(JRadioButton dosSi) {
		this.dosSi = dosSi;
	}

	public JRadioButton getDosNo() {
		return dosNo;
	}

	public void setDosNo(JRadioButton dosNo) {
		this.dosNo = dosNo;
	}

	public JRadioButton getDosDesp() {
		return dosDesp;
	}

	public void setDosDesp(JRadioButton dosDesp) {
		this.dosDesp = dosDesp;
	}

	public JRadioButton getTresSi() {
		return tresSi;
	}

	public void setTresSi(JRadioButton tresSi) {
		this.tresSi = tresSi;
	}

	public JRadioButton getTresNo() {
		return tresNo;
	}

	public void setTresNo(JRadioButton tresNo) {
		this.tresNo = tresNo;
	}

	public JRadioButton getTresDesp() {
		return tresDesp;
	}

	public void setTresDesp(JRadioButton tresDesp) {
		this.tresDesp = tresDesp;
	}

	public String getAttrUno() {
		return attrUno;
	}

	public void setAttrUno(String attrUno) {
		this.attrUno = attrUno;
	}

	public String getAttrDos() {
		return attrDos;
	}

	public void setAttrDos(String attrDos) {
		this.attrDos = attrDos;
	}

	public String getAttrTres() {
		return attrTres;
	}

	public void setAttrTres(String attrTres) {
		this.attrTres = attrTres;
	}

}
