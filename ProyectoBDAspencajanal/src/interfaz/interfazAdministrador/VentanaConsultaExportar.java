package interfaz.interfazAdministrador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import exportador.ExportarAExcel;

public class VentanaConsultaExportar extends JDialog implements ActionListener{
	
	public DefaultTableModel modelo;
	public JTable tabla;
	public JButton boton;
	public JScrollPane tablero;
	public ResultSet consulta;
	private static String EXPORTAR = "Exportar";
	
	public VentanaConsultaExportar(ResultSet consultaPrevia) {
		setSize(800, 485);
		setLayout(new BorderLayout());
		setTitle("Consulta Personalizada");
		getContentPane().setBackground(Color.white);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setModalityType(DEFAULT_MODALITY_TYPE);
		
		modelo = new DefaultTableModel();
		tabla = new JTable(modelo);
		tablero = new JScrollPane();
		tablero.setViewportView(tabla);
		add(tablero, BorderLayout.NORTH);
		
		consulta = consultaPrevia;
		
		boton = new JButton(EXPORTAR);
		boton.addActionListener(this);
		boton.setActionCommand(EXPORTAR);
		add(boton, BorderLayout.SOUTH);
		
		llenarTabla();
	}
	 /**
	  * Metodo que pasa los datos del ResultSet obtenido de la consulta SQL
	  * a la tabla de datos que se muestra en la ventana
	  */
	private void llenarTabla() {
		try {
			ResultSetMetaData metaData = consulta.getMetaData();
			int cantidad = metaData.getColumnCount();
			for(int i=1; i<=cantidad; i++ ) {
				modelo.addColumn(metaData.getColumnName(i));
			}
			while(consulta.next()) {
				Object[] fila = new Object[cantidad];
				for(int j=1; j<=cantidad; j++) {
					fila[j-1] = consulta.getObject(j);
				}
				modelo.addRow(fila);
			}
		}catch(SQLException sqlEx) {
			JOptionPane.showMessageDialog(this, "La consulta esta vacia", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Genera un archivo de excel con los datos que se estan visualizando en la ventana
	 * usando la API jxl
	 */
	private void exportarExcel() {
		List<JTable> lista = new ArrayList<JTable>();
		ExportarAExcel exportar = null;
		lista.add(tabla);
		try {
			exportar = new ExportarAExcel(lista, new File("consulta.xls"));
			if (exportar.export()) {
				JOptionPane.showMessageDialog(this, "Datos exportados con exito", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error de exportacion", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals(EXPORTAR)) {
			exportarExcel();
		}
	}
}
