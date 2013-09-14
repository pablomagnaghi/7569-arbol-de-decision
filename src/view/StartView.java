package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import utilities.ButtonColumn;
import utilities.Constants;
import controller.StartViewController;

public class StartView {

	private JFrame frame;
	private JTable table;
	private DefaultTableModel tableAttributes;
	private StartViewController controller;
	private ArrayList<String> atributos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartView window = new StartView();
					window.setController(new StartViewController());
					window.controller.setView(window);
					window.fillTable();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void setController(StartViewController startViewController) {
		this.controller = startViewController;
	}

	/**
	 * Create the application.
	 */
	public StartView() {
		this.setAtributos(new ArrayList<String>());
		this.getAtributos().add(Constants.distancia);
		this.getAtributos().add(Constants.tipoArma);
		this.getAtributos().add(Constants.nivelVida);
		this.getAtributos().add(Constants.visibilidad);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 356);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblElijaUnAtributo = new JLabel("Elija un atributo principal");
		lblElijaUnAtributo.setBounds(123, 33, 212, 15);
		frame.getContentPane().add(lblElijaUnAtributo);
		tableAttributes = new DefaultTableModel() {
			 /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int rowIndex, int mColIndex) {
				if (mColIndex == 1){
					return true;
				}
			        return false;
			    }
		};
		setTable(new JTable(tableAttributes));
		getTableAttributes().addColumn ("Atributo");
		getTableAttributes().addColumn ("Elegir");
        getTable().setRowHeight(50);

		getTable().setBounds(60, 86, 337, 203);
		frame.getContentPane().add(getTable());
		
	}

	public void fillTable() {
		this.tableAttributes.getDataVector().removeAllElements();
		this.tableAttributes.fireTableDataChanged();
		for (String attr : this.getAtributos()) {
			Object[] row = {
					attr, "Elegir" 
			};
			Action elegirAtributo = new AbstractAction()
			{
			    /**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public void actionPerformed(ActionEvent e)
			    {
			        elegirAtributo();
			    }

			};
			ButtonColumn elegir = new ButtonColumn(this.table, elegirAtributo, 1);
			this.tableAttributes.addRow(row);
		}
	}

	private void elegirAtributo() {
		int[] rows = this.table.getSelectedRows();
		int index = rows[0];
		String nombreAttributo = ((Vector) this.tableAttributes.getDataVector()	.elementAt(index)).elementAt(0).toString();
		this.controller.elegir(nombreAttributo);
	}
	
	public DefaultTableModel getTableAttributes() {
		return tableAttributes;
	}

	public void setTableAttributes(DefaultTableModel tableAttributes) {
		this.tableAttributes = tableAttributes;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
	
	public void show(){
		this.frame.setVisible(Boolean.TRUE);
	}
	
	public void hide(){
		this.frame.setVisible(Boolean.FALSE);
	}

	public ArrayList<String> getAtributos() {
		return atributos;
	}

	public void setAtributos(ArrayList<String> atributos) {
		this.atributos = atributos;
	}
	
	
}
