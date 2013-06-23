package interfaz;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

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

	public PanelDatos() {
		setBorder(BorderFactory.createTitledBorder("Datos Personales"));
		setLayout(new GridLayout(10, 2));
		setBackground( Color.white);
		idJL = new JLabel("IDD:  ");
		nombreJL = new JLabel("Nombre(s):  ");
		apellidoJL = new JLabel("Apellidos:  ");
		cedulaJL = new JLabel("Cedula:  ");
		codigoJL = new JLabel("Codigo:  ");
		direccionJL = new JLabel("Direccion:  ");
		barrioJL = new JLabel("Barrio:  ");
		ciudadJL = new JLabel("Ciudad:  ");
		departamentoJL = new JLabel("Departamento:  ");
		zonaPostalJL = new JLabel("Zona Postal:  ");
		estadoJL = new JLabel("Estado:  ");
		fechaNacJL = new JLabel("Fecha Nacimiento:  ");
		telefonoJL = new JLabel("Telefono:  ");
		telefonoAltJL = new JLabel("Telefono Alternativo:  ");
		emailJL = new JLabel("Email:  ");
		seleccionalJL = new JLabel("Selecional:  ");
		fechaIngresoJL = new JLabel("Fecha Ingreso:  ");
		fechaRetiroJL = new JLabel("Fecha Retiro:  ");
		perteneceJL = new JLabel("Pertenece A:  ");

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
