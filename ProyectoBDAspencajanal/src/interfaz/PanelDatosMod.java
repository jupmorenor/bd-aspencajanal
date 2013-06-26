package interfaz;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import nucleo.Pensionado;

public class PanelDatosMod extends JPanel{

	private static final long serialVersionUID = 1L;

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
	private JLabel seccionalJL = new JLabel("Selecional:  ");
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
	private JTextField seccionalJT;
	private JTextField fechaRetiroJT;
	private JTextField fechaIngresoJT;
	
	private JComboBox<String> estadoJT;
	private JComboBox<String> departamentoJT;
	
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
	
	public PanelDatosMod(String id) {
		
		idJLT = new JTextField(id);
		direccionJT = new JTextField();
		nombreJT = new JTextField();
		apellidoJT = new JTextField();
		codigoJT = new JTextField();
		cedulaJT = new JTextField();
		barrioJT = new JTextField();
		ciudadJT = new JTextField();
		departamentoJT = new JComboBox<String>(departamentos);
		zonaPostalJT = new JTextField();
		estadoJT = new JComboBox<String>(estado);
		fechaNacJT = new JTextField("yyyy-mm-dd");
		telefonoJT = new JTextField();
		telefonoAltJT = new JTextField();
		emailJT = new JTextField();
		seccionalJT = new JTextField();
		fechaRetiroJT = new JTextField("yyyy-mm-dd");
		fechaIngresoJT = new JTextField("yyyy-mm-dd");
		pensionado = new Pensionado();

		inicializar();
	}
	
	
	public PanelDatosMod(Pensionado pensionado) {
		
		this.pensionado = pensionado;
				
		idJLT = new JTextField(pensionado.getIdPensionado());
		idJLT.setEditable(false);
		direccionJT = new JTextField(pensionado.getDireccion());
		nombreJT = new JTextField(pensionado.getNombres());
		apellidoJT = new JTextField(pensionado.getApellidos());
		codigoJT = new JTextField(pensionado.getCodigo());
		cedulaJT = new JTextField(pensionado.getCedula());
		barrioJT = new JTextField(pensionado.getBarrio());
		ciudadJT = new JTextField(pensionado.getCiudad());
		zonaPostalJT = new JTextField(pensionado.getZonaPostal());
		if (pensionado.getFechaNacimiento()==null) {
			fechaNacJT = new JTextField("yyyy-mm-dd");
		} else {
			fechaNacJT = new JTextField(pensionado.getFechaNacimiento());
		}
		
		telefonoJT = new JTextField(pensionado.getTelefono());
		telefonoAltJT = new JTextField(pensionado.getTelefonoAlternativo());
		emailJT = new JTextField(pensionado.getEmail());
		seccionalJT = new JTextField(pensionado.getSeccional());
		
		if (pensionado.getFechaRetiro()==null) {
			fechaRetiroJT = new JTextField("yyyy-mm-dd");
		} else {
			fechaRetiroJT = new JTextField(pensionado.getFechaRetiro());
		}
		
		if (pensionado.getFechaIngreso()==null) {
			fechaIngresoJT = new JTextField("yyyy-mm-dd");
		} else {
			fechaIngresoJT = new JTextField(pensionado.getFechaIngreso());
		}
		
		
		estadoJT = new JComboBox<String>(estado);
		estadoJT.setSelectedItem(estado[Integer.parseInt(pensionado.getIdEstado())-1]);
		departamentoJT = new JComboBox<String>(departamentos);
		departamentoJT.setSelectedItem(departamentos[Integer.parseInt(pensionado.getIdDepartamento())-1]);
		
		inicializar();
		
		produzcamosJCh.setSelected(pensionado.isProduzcamos());
		ayudemonosJCh.setSelected(pensionado.isAyudemonos());
	}

	private void inicializar() {
		
		setBorder(BorderFactory.createTitledBorder("Datos Personales"));
		setLayout(new GridLayout(10, 4,15,5));
		setBackground( Color.white);
		
		produzcamosJCh = new JRadioButton(PRODUZCAMOS);
		produzcamosJCh.setBackground(Color.white);
		ayudemonosJCh = new JRadioButton(AYUDEMONOS);
		ayudemonosJCh.setBackground(Color.white);
		
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
		add(produzcamosJCh);
		add(zonaPostalJL);	
		add(zonaPostalJT);
		add(blancoJL);	
		add(ayudemonosJCh);
	}
	
	public Pensionado modificarPensionado(){
		pensionado.setIdPensionado(idJLT.getText());
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
		
		if (fechaNacJT.getText().equals("yyyy-mm-dd")) {
			pensionado.setFechaNacimiento("0001-01-01");
		} else {
			pensionado.setFechaNacimiento(fechaNacJT.getText());
		}
		
		pensionado.setTelefono(telefonoJT.getText());
		pensionado.setTelefonoAlternativo(telefonoAltJT.getText());
		pensionado.setEmail(emailJT.getText());
		pensionado.setSeccional(seccionalJT.getText());
		
		if (fechaIngresoJT.getText().equals("yyyy-mm-dd")) {
			pensionado.setFechaIngreso("0001-01-01");
		} else {
			pensionado.setFechaIngreso(fechaIngresoJT.getText());
		}
		
		if (fechaRetiroJT.getText().equals("yyyy-mm-dd")) {
			pensionado.setFechaRetiro("0001-01-01");
		} else {
			pensionado.setFechaRetiro(fechaRetiroJT.getText());
		}
		
		pensionado.setProduzcamos(produzcamosJCh.isSelected());
		pensionado.setAyudemonos(ayudemonosJCh.isSelected());
	
		return pensionado;
	}
}