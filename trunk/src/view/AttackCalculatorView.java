package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.StartViewController;
import utilities.Constants;

@SuppressWarnings("rawtypes")
public class AttackCalculatorView extends JFrame {

	private JPanel contentPane;
	String[] distancia = { Constants.distancia_cercana, Constants.distancia_lejana, Constants.distancia_mediana };
	String[] tipoArma = {Constants.tipoArma_ametralladora, Constants.tipoArma_cuchillo, Constants.tipoArma_revolver};
	String[] vida = { Constants.nivelVida_alto, Constants.nivelVida_bajo, Constants.nivelVida_medio};
	String[] visibilidad = {Constants.visibilidad_buena, Constants.visibilidad_mala};
	private JComboBox distanciaCombo;
	private JComboBox visibilidadCombo;
	private JComboBox vidaCombo;
	private JComboBox tipoArmaCombo;
	private StartViewController controller;

	public AttackCalculatorView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 553, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAttr = new JLabel(Constants.distancia);
		lblAttr.setBounds(35, 34, 164, 39);
		contentPane.add(lblAttr);
		
		JLabel lblAttr_1 = new JLabel(Constants.visibilidad);
		lblAttr_1.setBounds(35, 101, 203, 15);
		contentPane.add(lblAttr_1);
		
		JLabel lblAttr_2 = new JLabel(Constants.nivelVida);
		lblAttr_2.setBounds(35, 153, 164, 15);
		contentPane.add(lblAttr_2);
		
		JLabel lblAttr_3 = new JLabel(Constants.tipoArma);
		lblAttr_3.setBounds(35, 215, 164, 15);
		contentPane.add(lblAttr_3);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(234, 279, 117, 47);
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.handleButtonCalcular();
			}
		});
		contentPane.add(btnCalcular);
		
		setDistanciaCombo(new JComboBox(distancia));
		getDistanciaCombo().setBounds(256, 41, 151, 24);
		contentPane.add(getDistanciaCombo());
		
		setVisibilidadCombo(new JComboBox(visibilidad));
		getVisibilidadCombo().setBounds(256, 96, 151, 24);
		contentPane.add(getVisibilidadCombo());
		
		setVidaCombo(new JComboBox(vida));
		getVidaCombo().setBounds(256, 148, 151, 24);
		contentPane.add(getVidaCombo());
		
		setTipoArmaCombo(new JComboBox(tipoArma));
		getTipoArmaCombo().setBounds(256, 210, 151, 24);
		contentPane.add(getTipoArmaCombo());
	}

	public void setController(StartViewController startViewController) {
		this.controller = startViewController;
	}

	public JComboBox getDistanciaCombo() {
		return distanciaCombo;
	}

	public void setDistanciaCombo(JComboBox distanciaCombo) {
		this.distanciaCombo = distanciaCombo;
	}

	public JComboBox getVisibilidadCombo() {
		return visibilidadCombo;
	}

	public void setVisibilidadCombo(JComboBox visibilidadCombo) {
		this.visibilidadCombo = visibilidadCombo;
	}

	public JComboBox getVidaCombo() {
		return vidaCombo;
	}

	public void setVidaCombo(JComboBox vidaCombo) {
		this.vidaCombo = vidaCombo;
	}

	public JComboBox getTipoArmaCombo() {
		return tipoArmaCombo;
	}

	public void setTipoArmaCombo(JComboBox tipoArmaCombo) {
		this.tipoArmaCombo = tipoArmaCombo;
	}
	
}
