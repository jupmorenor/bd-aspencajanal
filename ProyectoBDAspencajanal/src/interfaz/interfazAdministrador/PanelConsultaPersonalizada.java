package interfaz.interfazAdministrador;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class PanelConsultaPersonalizada extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<JCheckBox> seleccionJCh;
	private VentanaConsultaPersonalizada ventana;
	private JCheckBox cajaJCh;
	private JButton consultarJB;
	
	private static final String CONSULTAR = "Consultar";
	private static final String NOMBRES_ETIQUETAS[] = {"Produzcamos", "Ayudemonos", "Cedula", 
		"Fecha de nacimiento", "Codigo", "Direccion", "Barrio", "Ciudad", "Departamento", "Telefono", 
		"Telefono alternativo", "Email", "Seccional", "Fecha ingreso", "Fecha retiro", "Estado", "Observaciones"};
	
	private static final String NOMBRES_COLUMNAS[] = {null, null, "p.cedula", "p.fechanacimiento", "p.codigo", 
		"p.direccion", "p.barrio", "p.ciudad", "d.descdepartamento", "p.telefono", "p.telefonoalternativo", 
		"p.e_mail", "p.seccional", "p.fechaingreso", "p.fecharetiro", "e.descestado", "p.observaciones"};
	
	public PanelConsultaPersonalizada(VentanaConsultaPersonalizada ven) {
		setLayout(new GridLayout(9, 2));
		seleccionJCh = new ArrayList<JCheckBox>();
		
		for (int i=0; i<NOMBRES_ETIQUETAS.length; i++) {
			cajaJCh = new JCheckBox(NOMBRES_ETIQUETAS[i]);
			cajaJCh.setName(NOMBRES_COLUMNAS[i]);
			if (NOMBRES_ETIQUETAS[i].equals("Produzcamos") || NOMBRES_ETIQUETAS[i].equals("Ayudemonos")) {
				cajaJCh.setBackground(new Color(70, 150, 70));
			} else {
				cajaJCh.setBackground(Color.white);
			}
			seleccionJCh.add(cajaJCh);
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
			boolean ayud = false;
			boolean prod = false;
			for (int i=0; i<seleccionJCh.size(); i++) {
				if (seleccionJCh.get(i).isSelected()) {	
					if (seleccionJCh.get(i).getName()!=null) {
						cadena += ", " + seleccionJCh.get(i).getName();
					}
					if (seleccionJCh.get(i).getText().equals("Departamento")) {
						depto = true;
					}
					if (seleccionJCh.get(i).getText().equals("Estado")) {
						estado = true;
					}
					if (seleccionJCh.get(i).getText().equals("Ayudemonos")) {
						ayud = true;
					}
					if (seleccionJCh.get(i).getText().equals("Produzcamos")) {
						prod = true;
					}
				}
			}
			cadena += " FROM pensionado p";
			if (depto && estado) {
				cadena += ", departamento d, estado e WHERE d.iddepartamento=p.iddepartamento AND e.idestado=p.idestado";
				if (ayud) {
					cadena += " AND p.ayudemos='TRUE'";
				}
				if (prod) {
					cadena += " AND p.produzcamos='TRUE'";
				}
			}
			if (depto && !estado) {
				cadena += ", departamento d WHERE d.iddepartamento=p.iddepartamento";
				if (ayud) {
					cadena += " AND p.ayudemos='TRUE'";
				}
				if (prod) {
					cadena += " AND p.produzcamos='TRUE'";
				}
			}
			if (!depto && estado) {
				cadena += ", estado e WHERE e.idestado=p.idestado";
				if (ayud) {
					cadena += " AND p.ayudemos='TRUE'";
				}
				if (prod) {
					cadena += " AND p.produzcamos='TRUE'";
				}
			}
			if (!depto && !estado) {
				if (ayud && prod) {
					cadena += " WHERE p.ayudemos='TRUE' AND p.produzcamos='TRUE'";
				}
				if (ayud && !prod) {
					cadena += " WHERE p.produzcamos='TRUE'";
				}
				if (!ayud && prod) {
					cadena += " WHERE p.ayudemos='TRUE'";
				}
			}
			cadena += ";";
			System.out.println(cadena);
			ventana.consultarBaseDatos(cadena);
		}
	}
}
