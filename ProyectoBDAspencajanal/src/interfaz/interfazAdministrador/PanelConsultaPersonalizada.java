package interfaz.interfazAdministrador;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class PanelConsultaPersonalizada extends JPanel implements
		ActionListener {
	
	//private ArrayList<JLabel> nombreJL;
	private ArrayList<JCheckBox> seleccionJCh;
	private VentanaConsultaPersonalizada ventana;
	private JCheckBox cajaJCh;
	private JButton consultarJB;
	
	private static final String CONSULTAR = "Consultar";
	private static final String NOMBRES_ETIQUETAS[] = {"Cedula ", "Fecha de nacimiento ", "Codigo ", "Direccion ", "Barrio ", "Ciudad ", 
		"Departamento ", "Telefono ", "Email ", "Seccional ", "Fecha ingreso ", "Fecha retiro", "Produzcamos", "Ayudemonos", "Observaciones "};
	
	private static final String NOMBRES_COLUMNAS[] = {"cedula", "fechanacimiento", "codigo", "direccion", "barrio", "ciudad", 
		"(SELECT d.descdepartamento FROM departamento d, pensionado p WHERE d.iddepartamento=p.iddepartamento)", "telefono",
		"e_mail", "seccional", "fechaingreso", "fecharetiro", "produzcamos", "ayudemos", "observaciones"};
	
	public PanelConsultaPersonalizada(VentanaConsultaPersonalizada ven) {
		setLayout(new GridLayout(4, 4));
		seleccionJCh = new ArrayList<JCheckBox>();
		
		for (int i=0; i<NOMBRES_ETIQUETAS.length; i++) {
			cajaJCh = new JCheckBox(NOMBRES_ETIQUETAS[i]);
			cajaJCh.setName(NOMBRES_COLUMNAS[i]);
			seleccionJCh.add(cajaJCh);
			cajaJCh.setBackground(Color.white);
		}
		
		for (int j=0; j<seleccionJCh.size(); j++) {
			add(seleccionJCh.get(j));
		}
		
		consultarJB = new JButton(CONSULTAR);
		consultarJB.addActionListener(this);
		consultarJB.setActionCommand(CONSULTAR);
		consultarJB.setSize(90, 30);
		add(consultarJB);
		
		ventana = ven;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getActionCommand().equals(CONSULTAR)) {
			String cadena = "SELECT idpensionado, nombres, apellidos, cedula, fechanacimiento, produzcamos, telefono";
			/*for (int i=0; i<=seleccionJCh.size(); i++) {
				
			}*/
			cadena += " FROM pensionado;";
			ventana.consultarBaseDatos(cadena);
		}
	}
}
