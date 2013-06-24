package interfaz;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import nucleo.Pensionado;

public class PanelDatos extends JPanel {

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
	private JLabel seleccionalJL;
	private JLabel fechaIngresoJL;
	private JLabel fechaRetiroJL;
	private JLabel perteneceJL;

	public PanelDatos(Pensionado pensionado) {
		setBorder(BorderFactory.createTitledBorder("Datos Personales"));
		setLayout(new GridLayout(10, 2));
		setBackground( Color.white);
		idJL = new JLabel("IDD: " + pensionado.getIdPensionado());
		nombreJL = new JLabel("Nombre(s): " + pensionado.getNombres());
		apellidoJL = new JLabel("Apellidos: " + pensionado.getApellidos());
		cedulaJL = new JLabel("Cedula: " + pensionado.getCedula());
		codigoJL = new JLabel("Codigo: " + pensionado.getCodigo());
		direccionJL = new JLabel("Direccion: " + pensionado.getDireccion());
		barrioJL = new JLabel("Barrio: " + pensionado.getBarrio());
		ciudadJL = new JLabel("Ciudad: " + pensionado.getCiudad());
		departamentoJL = new JLabel("Departamento: " + pensionado.getIdDepartamento());
		zonaPostalJL = new JLabel("Zona Postal: " + pensionado.getZonaPostal());
		estadoJL = new JLabel("Estado: " + pensionado.getIdEstado());
		fechaNacJL = new JLabel("Fecha Nacimiento: " + pensionado.getFechaNacimiento());
		telefonoJL = new JLabel("Telefono: " + pensionado.getTelefono());
		telefonoAltJL = new JLabel("Telefono Alternativo: " + pensionado.getTelefonoAlternativo());
		emailJL = new JLabel("Email: " + pensionado.getEmail());
		seleccionalJL = new JLabel("Selecional: " + pensionado.getSeccional());
		fechaIngresoJL = new JLabel("Fecha Ingreso: " + pensionado.getFechaIngreso());
		fechaRetiroJL = new JLabel("Fecha Retiro: " + pensionado.getFechaRetiro());
		perteneceJL = new JLabel("Pertenece A: " + ((pensionado.isProduzcamos())?"Produzcamos\n":"")
				+ ((pensionado.isAyudemonos())?"Ayudemonos":""));

		add(idJL);
		add(estadoJL);
		add(nombreJL);
		add(fechaNacJL);
		add(apellidoJL);
		add(telefonoJL);
		add(cedulaJL);
		add(telefonoAltJL);
		add(codigoJL);
		add(emailJL);
		add(direccionJL);
		add(seleccionalJL);
		add(barrioJL);
		add(fechaIngresoJL);
		add(ciudadJL);
		add(fechaRetiroJL);
		add(departamentoJL);
		add(perteneceJL);
		add(zonaPostalJL);	
	}
}
