package interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import nucleo.Pensionado;

public class PanelDatosMod extends JPanel implements ActionListener{

	private JLabel idJL;
	private JLabel direccionJL;	
	private JLabel nombreJL;
	private JLabel apellidoJL;
	private JLabel codigoJL;
	private JLabel cedulaJL;
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
	private JLabel blancoJL;
	private JLabel idDatosJL;
	
	private JTextField direccionJT;
	private JTextField nombreJT;
	private JTextField apellidoJT;
	private JTextField codigoJT;
	private JTextField cedulaJT;
	private JTextField barrioJT;
	private JTextField ciudadJT;
	private JTextField departamentoJT;
	private JTextField zonaPostalJT;
	private JTextField estadoJT;
	private JTextField fechaNacJT;
	private JTextField telefonoJT;
	private JTextField telefonoAltJT;
	private JTextField emailJT;
	private JTextField seleccionalJT;
	private JTextField fechaRetiroJT;
	private JTextField fechaIngresoJT;
	
	private JRadioButton produzcamosJCh;
	private JRadioButton ayudemonosJCh;
	
	private static final String PRODUZCAMOS = "Produzcamos";
	private static final String AYUDEMONOS = "Ayudemonos";
	
	private Pensionado pensionado;

	public PanelDatosMod(Pensionado pensionado) {
		pensionado= pensionado;
		
		setBorder(BorderFactory.createTitledBorder("Datos Personales"));
		setLayout(new GridLayout(10, 4,15,5));
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
		seleccionalJL = new JLabel("Seccional:  ");
		fechaIngresoJL = new JLabel("Fecha Ingreso:  ");
		fechaRetiroJL = new JLabel("Fecha Retiro:  ");
		perteneceJL = new JLabel("Pertenece A:  ");
		blancoJL = new JLabel(); 
		idDatosJL = new JLabel(pensionado.getIdPensionado());
		
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
		seleccionalJT = new JTextField(pensionado.getSeccional());
		fechaRetiroJT = new JTextField(pensionado.getFechaRetiro());
		fechaIngresoJT = new JTextField(pensionado.getFechaIngreso());

		produzcamosJCh = new JRadioButton(PRODUZCAMOS);
		produzcamosJCh.setBackground(Color.white);
		produzcamosJCh.addActionListener(this);
		produzcamosJCh.setActionCommand(PRODUZCAMOS);
		
		ayudemonosJCh = new JRadioButton(AYUDEMONOS);
		ayudemonosJCh.setBackground(Color.white);
		ayudemonosJCh.addActionListener(this);
		ayudemonosJCh.setActionCommand(AYUDEMONOS);
		
		
		add(idJL);
		add(idDatosJL);
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
		add(seleccionalJL);
		add(seleccionalJT);
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
		add(produzcamosJCh);
		add(zonaPostalJL);	
		add(zonaPostalJT);
		add(blancoJL);	
		add(ayudemonosJCh);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case PRODUZCAMOS:
			
			break;
			
		case AYUDEMONOS:
			
		}	
	}	
	
	public  Pensionado modificarPensionado(){
		pensionado.setNombres(nombreJT.getText());
		pensionado.setApellidos(apellidoJT.getText());
		pensionado.setCedula(cedulaJT.getText());
		pensionado.setCodigo(codigoJT.getText());
		pensionado.setDireccion(direccionJT.getText());
		pensionado.setBarrio(barrioJT.getText());
		pensionado.setCiudad(ciudadJT.getText());
		pensionado.setIdDepartamento(departamentoJT.getText());
		pensionado.setZonaPostal(zonaPostalJT.getText());
		pensionado.setIdEstado(estadoJT.getText());
		pensionado.setFechaNacimiento(fechaNacJT.getText());
		pensionado.setTelefono(telefonoJT.getText());
		pensionado.setTelefonoAlternativo(telefonoAltJT.getText());
		pensionado.setEmail(emailJT.getText());
		pensionado.setSeccional(seleccionalJT.getText());
		pensionado.setFechaIngreso(fechaIngresoJT.getText());
		pensionado.setFechaRetiro(fechaRetiroJT.getText());
	
		return pensionado;
	}
}