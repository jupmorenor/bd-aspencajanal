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
	private static final String NOMBRES_ETIQUETAS[] = {"Cedula ", "Fecha de nacimiento ", "Codigo ", 
		"Direccion ", "Barrio ", "Ciudad ", "Departamento ", "Telefono ", "Telefono alternativo", 
		"Email ", "Seccional ", "Fecha ingreso ", "Fecha retiro", "Produzcamos", "Ayudemonos", 
		"Observaciones ", "Estado "};
	
	private static final String NOMBRES_COLUMNAS[] = {"p.cedula", "p.fechanacimiento", "p.codigo", 
		"p.direccion", "p.barrio", "p.ciudad", "d.descdepartamento", "p.telefono", "p.telefonoalternativo", 
		"p.e_mail", "p.seccional", "p.fechaingreso", "p.fecharetiro", "p.produzcamos", "p.ayudemos", 
		"p.observaciones", "e.descestado"};
	
	public PanelConsultaPersonalizada(VentanaConsultaPersonalizada ven) {
		setLayout(new GridLayout(9, 2));
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
			String cadena = "SELECT p.idpensionado, p.nombres, p.apellidos";
			boolean estado = false;
			boolean depto = false;
			for (int i=0; i<seleccionJCh.size(); i++) {
				if (seleccionJCh.get(i).isSelected()) {		
					cadena += ", " + seleccionJCh.get(i).getName();
					if (seleccionJCh.get(i).getText().equals("Departamento ")) {
						depto = true;
					}
					if (seleccionJCh.get(i).getText().equals("Estado ")) {
						estado = true;
					}
				}
			}
			cadena += " FROM pensionado p";
			if (depto && estado) {
				cadena += ", departamento d, estado e WHERE d.iddepartamento=p.iddepartamento AND e.idestado=p.idestado";
			}
			if (depto && !estado) {
				cadena += ", departamento d WHERE d.iddepartamento=p.iddepartamento";
			}
			if (!depto && estado) {
				cadena += ", estado e WHERE e.idestado=p.idestado";
			}
			cadena += ";";
			ventana.consultarBaseDatos(cadena);
		}
	}
}
