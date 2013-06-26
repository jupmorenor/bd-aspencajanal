package interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import nucleo.Pensionado;

public class PanelDatosMod extends JPanel implements ActionListener{

	private JLabel idJL = new JLabel("IDD:  ");
	private JLabel direccionJL= new JLabel("Direccion:  ");	
	private JLabel nombreJL= new JLabel("Nombre(s):  ");
	private JLabel apellidoJL= new JLabel("Apellidos:  ");
	private JLabel codigoJL= new JLabel("Codigo:  ");
	private JLabel cedulaJL= new JLabel("Cedula:  ");
	private JLabel barrioJL= new JLabel("Barrio:  ");
	private JLabel ciudadJL= new JLabel("Ciudad:  ");
	private JLabel departamentoJL= new JLabel("Departamento:  ");
	private JLabel zonaPostalJL = new JLabel("Zona Postal:  ");
	private JLabel estadoJL = new JLabel("Estado:  ");
	private JLabel fechaNacJL = new JLabel("Fecha Nacimiento:  ");
	private JLabel telefonoJL = new JLabel("Telefono:  ");
	private JLabel telefonoAltJL = new JLabel("Telefono Alternativo:  ");
	private JLabel emailJL = new JLabel("Email:  ");
	private JLabel seleccionalJL = new JLabel("Selecional:  ");
	private JLabel fechaIngresoJL = new JLabel("Fecha Ingreso:  ");
	private JLabel fechaRetiroJL = new JLabel("Fecha Retiro:  ");
	private JLabel perteneceJL = new JLabel("Pertenece A:  ");
	private JLabel blancoJL = new JLabel(); 
	
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
	private JTextField seleccionalJT;
	private JTextField fechaRetiroJT;
	private JTextField fechaIngresoJT;
	
	private JComboBox estadoJT;
	private JComboBox departamentoJT;
	
	private JRadioButton produzcamosJCh;
	private JRadioButton ayudemonosJCh;
	
	private static final String PRODUZCAMOS = "Produzcamos";
	private static final String AYUDEMONOS = "Ayudemonos";
	
	private String departamentos[]= {"Amazonas", "Antioquia", "Arauca","Atlantico","Bolivar","Bogotá D.C",
			"Boyaca", "Caldas","Caqueta","Casanare","Cauca","Cesar","Choco","Cordoba","Cundinamarca","Guainia"
			,"Guaviare","Huila","La Guajira","Magdalena","Meta","Nariño","Norte de Santander","Putumayo","Quindio",
			"Risaralda","San Andrés y Providencia","Santander","Sucre","Tolima","Valle Del Cauca","Vaupes", "Vichada",};
	
	private String estado[]={"Activo","Retirado","Fallecido","Desconocido"};
	
	private Pensionado pensionado;
	
	public PanelDatosMod() {
		setBorder(BorderFactory.createTitledBorder("Datos Personales"));
		setLayout(new GridLayout(10, 4,15,5));
		setBackground( Color.white);
		
		idJLT = new JTextField();
		direccionJT = new JTextField();
		nombreJT = new JTextField();
		apellidoJT = new JTextField();
		codigoJT = new JTextField();
		cedulaJT = new JTextField();
		barrioJT = new JTextField();
		ciudadJT = new JTextField();
		departamentoJT = new JComboBox(departamentos);
		zonaPostalJT = new JTextField();
		estadoJT = new JComboBox(estado);
		fechaNacJT = new JTextField();
		telefonoJT = new JTextField();
		telefonoAltJT = new JTextField();
		emailJT = new JTextField();
		seleccionalJT = new JTextField();
		fechaRetiroJT = new JTextField();
		fechaIngresoJT = new JTextField();

		produzcamosJCh = new JRadioButton(PRODUZCAMOS);
		produzcamosJCh.setBackground(Color.white);
		produzcamosJCh.addActionListener(this);
		produzcamosJCh.setActionCommand(PRODUZCAMOS);
		
		ayudemonosJCh = new JRadioButton(AYUDEMONOS);
		ayudemonosJCh.setBackground(Color.white);
		ayudemonosJCh.addActionListener(this);
		ayudemonosJCh.setActionCommand(AYUDEMONOS);
		
		
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
	
	
	public PanelDatosMod(Pensionado pensionado) {
		pensionado= pensionado;
		
		setBorder(BorderFactory.createTitledBorder("Datos Personales"));
		setLayout(new GridLayout(10, 4,15,5));
		setBackground( Color.white);
		
		idJLT = new JTextField(pensionado.getIdPensionado());
		idJLT.setEditable(false);
		idJLT.setBackground(Color.white);
		direccionJT = new JTextField(pensionado.getDireccion());
		nombreJT = new JTextField(pensionado.getNombres());
		apellidoJT = new JTextField(pensionado.getApellidos());
		codigoJT = new JTextField(pensionado.getCodigo());
		cedulaJT = new JTextField(pensionado.getCedula());
		barrioJT = new JTextField(pensionado.getBarrio());
		ciudadJT = new JTextField(pensionado.getCiudad());
		zonaPostalJT = new JTextField(pensionado.getZonaPostal());
		fechaNacJT = new JTextField(pensionado.getFechaNacimiento());
		telefonoJT = new JTextField(pensionado.getTelefono());
		telefonoAltJT = new JTextField(pensionado.getTelefonoAlternativo());
		emailJT = new JTextField(pensionado.getEmail());
		seleccionalJT = new JTextField(pensionado.getSeccional());
		fechaRetiroJT = new JTextField(pensionado.getFechaRetiro());
		fechaIngresoJT = new JTextField(pensionado.getFechaIngreso());
		
		estadoJT = new JComboBox(estado);
		estadoJT.setSelectedItem(estado[Integer.parseInt(pensionado.getIdEstado())-1]);
		departamentoJT = new JComboBox(departamentos);
		departamentoJT.setSelectedItem(departamentos[Integer.parseInt(pensionado.getIdDepartamento())-1]);
		
		produzcamosJCh = new JRadioButton(PRODUZCAMOS);
		produzcamosJCh.setBackground(Color.white);
		produzcamosJCh.addActionListener(this);
		produzcamosJCh.setActionCommand(PRODUZCAMOS);
		produzcamosJCh.setSelected(pensionado.isProduzcamos());
		ayudemonosJCh = new JRadioButton(AYUDEMONOS);
		ayudemonosJCh.setBackground(Color.white);
		ayudemonosJCh.addActionListener(this);
		ayudemonosJCh.setActionCommand(AYUDEMONOS);
		ayudemonosJCh.setSelected(pensionado.isAyudemonos());
		
		
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
	
	public  void modificarPensionado(){
		pensionado.setNombres(nombreJT.getText());
		pensionado.setApellidos(apellidoJT.getText());
		pensionado.setCedula(cedulaJT.getText());
		pensionado.setCodigo(codigoJT.getText());
		pensionado.setDireccion(direccionJT.getText());
		pensionado.setBarrio(barrioJT.getText());
		pensionado.setCiudad(ciudadJT.getText());
		pensionado.setIdDepartamento(Integer.toString(departamentoJT.getSelectedIndex()+1));
		pensionado.setZonaPostal(zonaPostalJT.getText());
		pensionado.setIdEstado(Integer.toString(estadoJT.getSelectedIndex()+1));
		pensionado.setFechaNacimiento(fechaNacJT.getText());
		pensionado.setTelefono(telefonoJT.getText());
		pensionado.setTelefonoAlternativo(telefonoAltJT.getText());
		pensionado.setEmail(emailJT.getText());
		pensionado.setSeccional(seleccionalJT.getText());
		pensionado.setFechaIngreso(fechaIngresoJT.getText());
		pensionado.setFechaRetiro(fechaRetiroJT.getText());
		pensionado.setProduzcamos(produzcamosJCh.isSelected());
		pensionado.setAyudemonos(ayudemonosJCh.isSelected());
	}
}