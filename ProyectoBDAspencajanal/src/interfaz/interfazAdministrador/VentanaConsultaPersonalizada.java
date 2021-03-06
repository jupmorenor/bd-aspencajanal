package interfaz.interfazAdministrador;

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

	private static final long serialVersionUID = 1L;

	public JPanel panelConsultaPersonalizada;
	
	public VentanaConsultaPersonalizada() {
		
		setLayout(new GridLayout(1,1));
		setSize(300, 400);
		setTitle("Consulta por seleccion");
		setLocationRelativeTo(null);
		setModalityType(DEFAULT_MODALITY_TYPE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		panelConsultaPersonalizada = new PanelConsultaPersonalizada(this);
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
				JOptionPane.showMessageDialog(this, "No se encuentran los datos de conexion", "Error de conexion", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(this, "No se encuentran los datos de conexion", "Error de conexion", JOptionPane.ERROR_MESSAGE);
		}	
	}
}