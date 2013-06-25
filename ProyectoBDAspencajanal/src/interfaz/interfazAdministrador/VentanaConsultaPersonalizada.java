package interfaz.interfazAdministrador;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import conexion.Conector;

public class VentanaConsultaPersonalizada extends JDialog {
	
	public JPanel panelConsultaPersonalizada;
	
	public VentanaConsultaPersonalizada() {
		
		setLayout(new GridLayout(1,1));
		setSize(800, 200);
		setTitle("Consulta por seleccion");
		setLocationRelativeTo(null);
		setModalityType(DEFAULT_MODALITY_TYPE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		panelConsultaPersonalizada = new PanelConsultaPersonalizada(this);
		//panelConsultaPersonalizada.setBackground(Color.white);
		add(panelConsultaPersonalizada);
		
		setResizable(false);
	}
	
	public void consultarBaseDatos(String cadena) {
		BufferedReader acceso;
		ArrayList<String> datos;
		try {
			acceso = new BufferedReader(new FileReader("./data/datos.jaa"));
		}catch (Exception ex) {
			acceso = null;
		}
		if (acceso!=null) {
			try {
				String linea;
				datos = new ArrayList<String>();
				
				while((linea = acceso.readLine())!=null) {
					datos.add(linea);
				}
				acceso.close();
				Conector conector = new Conector(datos.get(0), datos.get(1), datos.get(2), datos.get(3));
				conector.SetCadena(cadena);
				ResultSet tabla = conector.Consultar();
				VentanaConsultaExportar vCE = new VentanaConsultaExportar(tabla);
				dispose();
				vCE.setVisible(true);
				
			}catch (Exception ioex) {
				ioex.printStackTrace();
				JOptionPane.showMessageDialog(this, "No se encuentran los datos de conexion", "Error de conexion", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(this, "No se encuentran los datos de conexion", "Error de conexion", JOptionPane.ERROR_MESSAGE);
		}	
	}
}