package interfaz.interfazAdministrador;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;

public class VentanaConsultaPersonalizada extends JDialog {
	
	public JPanel panelConsultaPersonalizada;
	
	public VentanaConsultaPersonalizada() {
		
		setLayout(new GridLayout(1,1));
		setSize(800, 200);
		setTitle("Consulta por seleccion");
		getContentPane().setBackground(Color.white);
		setLocationRelativeTo(null);
		setModalityType(DEFAULT_MODALITY_TYPE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		panelConsultaPersonalizada = new PanelConsultaPersonalizada(this);
		//panelConsultaPersonalizada.setBackground(Color.white);
		add(panelConsultaPersonalizada);
		
		setResizable(false);
	}
	
	public void consultarBaseDatos() {
		//TODO consultar en la base de datos y enviar el resultSet a la ventana de exportar
		VentanaConsultaExportar vCE = new VentanaConsultaExportar(null);
		vCE.setVisible(true);
		dispose();
	}
}