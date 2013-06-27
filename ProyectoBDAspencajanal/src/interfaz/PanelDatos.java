package interfaz;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import nucleo.Pensionado;

public class PanelDatos extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JLabel idJL;
	private JLabel nombreJL;
	private JLabel apellidoJL;
	private JLabel cedulaJL;
	private JLabel codigoJL;
	private JLabel direccionJL;
	private JLabel barrioJL;
	private JLabel ciudadJL;
	private JLabel departamentoJL;
	private JLabel zonaPostalJL;
	private JLabel estadoJL;
	private JLabel fechaNacJL;
	private JLabel telefonoJL;
	private JLabel telefonoAltJL;
	private JLabel emailJL;
	private JLabel seccionalJL;
	private JLabel fechaIngresoJL;
	private JLabel fechaRetiroJL;
	private JLabel perteneceJL;
	private JLabel blancoJL;
	
	private JTextField idJLT;
	private JTextField direccionJT;
	private JTextField nombreJT;
	private JTextField apellidoJT;
	private JTextField codigoJT;
	private JTextField cedulaJT;
	private JTextField barrioJT;
	private JTextField ciudadJT;
	private JTextField zonaPostalJT;
	private JTextField fechaNacJT;
	private JTextField telefonoJT;
	private JTextField telefonoAltJT;
	private JTextField emailJT;
	private JTextField seccionalJT;
	private JTextField fechaRetiroJT;
	private JTextField fechaIngresoJT;
	private JTextField departamentoJT;
	private JTextField estadoJT;
	private JTextField ayudemonosJT;
	private JTextField produzcamosJT;
	
	
	public PanelDatos(Pensionado pensionado) {
		setBorder(BorderFactory.createTitledBorder("Datos Personales"));
		setLayout(new GridLayout(10, 4,15,5));
		setBackground( Color.white);
		idJL = new JLabel("IDD: ");
		nombreJL = new JLabel("Nombre(s): ");
		apellidoJL = new JLabel("Apellidos: ");
		cedulaJL = new JLabel("Cedula: ");
		codigoJL = new JLabel("Codigo: ");
		direccionJL = new JLabel("Direccion: ");
		barrioJL = new JLabel("Barrio: ");
		ciudadJL = new JLabel("Ciudad: ");
		departamentoJL = new JLabel("Departamento: ");
		zonaPostalJL = new JLabel("Zona Postal: ");
		estadoJL = new JLabel("Estado: ");
		fechaNacJL = new JLabel("Fecha Nacimiento: ");
		telefonoJL = new JLabel("Telefono: ");
		telefonoAltJL = new JLabel("Telefono Alternativo: ");
		emailJL = new JLabel("Email: ");
		seccionalJL = new JLabel("Selecional: ");
		fechaIngresoJL = new JLabel("Fecha Ingreso: ");
		fechaRetiroJL = new JLabel("Fecha Retiro: ");
		perteneceJL = new JLabel("Pertenece A: ");
		blancoJL = new JLabel("");
		
		idJLT = new JTextField(pensionado.getIdPensionado());
		direccionJT = new JTextField(pensionado.getDireccion());
		nombreJT = new JTextField(pensionado.getNombres());
		apellidoJT = new JTextField(pensionado.getApellidos());
		codigoJT = new JTextField(pensionado.getCodigo());
		cedulaJT = new JTextField(pensionado.getCedula());
		barrioJT = new JTextField(pensionado.getBarrio());
		ciudadJT = new JTextField(pensionado.getCiudad());
		departamentoJT = new JTextField(pensionado.getIdDepartamento());
		zonaPostalJT = new JTextField(pensionado.getZonaPostal());
		estadoJT = new JTextField(pensionado.getIdEstado());
		fechaNacJT = new JTextField(pensionado.getFechaNacimiento());
		telefonoJT = new JTextField(pensionado.getTelefono());
		telefonoAltJT = new JTextField(pensionado.getTelefonoAlternativo());
		emailJT = new JTextField(pensionado.getEmail());
		seccionalJT = new JTextField(pensionado.getSeccional());
		fechaRetiroJT = new JTextField(pensionado.getFechaIngreso());
		fechaIngresoJT = new JTextField(pensionado.getFechaRetiro());
		ayudemonosJT = new JTextField(((pensionado.isAyudemonos())?"Ayudemonos":""));
		produzcamosJT = new JTextField(((pensionado.isProduzcamos())?"Produzcamos\n ":""));
		
		idJLT.setEditable(false);
		direccionJT.setEditable(false);
		nombreJT.setEditable(false);
		apellidoJT.setEditable(false);
		codigoJT.setEditable(false);
		cedulaJT.setEditable(false);
		barrioJT.setEditable(false);
		ciudadJT.setEditable(false);
		departamentoJT.setEditable(false);
		zonaPostalJT.setEditable(false);
		estadoJT.setEditable(false);
		fechaNacJT.setEditable(false);
		telefonoJT.setEditable(false);
		telefonoAltJT.setEditable(false);
		emailJT.setEditable(false);
		seccionalJT.setEditable(false);
		fechaRetiroJT.setEditable(false);
		fechaIngresoJT.setEditable(false);
		ayudemonosJT.setEditable(false);
		produzcamosJT.setEditable(false);
		
		idJLT.setBackground(Color.white);
		direccionJT.setBackground(Color.white);
		nombreJT.setBackground(Color.white);
		apellidoJT.setBackground(Color.white);
		codigoJT.setBackground(Color.white);
		cedulaJT.setBackground(Color.white);
		barrioJT.setBackground(Color.white);
		ciudadJT.setBackground(Color.white);
		departamentoJT.setBackground(Color.white);
		zonaPostalJT.setBackground(Color.white);
		estadoJT.setBackground(Color.white);
		fechaNacJT.setBackground(Color.white);
		telefonoJT.setBackground(Color.white);
		telefonoAltJT.setBackground(Color.white);
		emailJT.setBackground(Color.white);
		seccionalJT.setBackground(Color.white);
		fechaRetiroJT.setBackground(Color.white);
		fechaIngresoJT.setBackground(Color.white);
		ayudemonosJT.setBackground(Color.white);
		produzcamosJT.setBackground(Color.white);
		
		add(idJL);
		add(idJLT);
		add(estadoJL);
		add(estadoJT);
		add(nombreJL);
		add(nombreJT);
		add(fechaNacJL);
		add(fechaNacJT);
		add(apellidoJL);
		add(apellidoJT);
		add(telefonoJL);
		add(telefonoJT);
		add(cedulaJL);
		add(cedulaJT);
		add(telefonoAltJL);
		add(telefonoAltJT);
		add(codigoJL);
		add(codigoJT);
		add(emailJL);
		add(emailJT);
		add(direccionJL);
		add(direccionJT);
		add(seccionalJL);
		add(seccionalJT);
		add(barrioJL);
		add(barrioJT);
		add(fechaIngresoJL);
		add(fechaIngresoJT);
		add(ciudadJL);
		add(ciudadJT);
		add(fechaRetiroJL);
		add(fechaRetiroJT);
		add(departamentoJL);
		add(departamentoJT);
		add(perteneceJL);
		add(ayudemonosJT);
		add(zonaPostalJL);	
		add(zonaPostalJT);
		add(blancoJL);
		add(produzcamosJT);


	}
}
