package interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class PanelDatosMod extends JPanel implements ChangeListener{

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

	private JTextField idJLT;
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

	public PanelDatosMod() {
		setBorder(BorderFactory.createTitledBorder("Datos Personales"));
		setLayout(new GridLayout(10, 4));
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
		blancoJL = new JLabel(); 
		
		idJLT= new JTextField();
		direccionJT= new JTextField();
		nombreJT= new JTextField();
		apellidoJT= new JTextField();
		codigoJT= new JTextField();
		cedulaJT= new JTextField();
		barrioJT= new JTextField();
		ciudadJT= new JTextField();
		departamentoJT= new JTextField();
		zonaPostalJT= new JTextField();
		estadoJT= new JTextField();
		fechaNacJT= new JTextField();
		telefonoJT= new JTextField();
		telefonoAltJT= new JTextField();
		emailJT= new JTextField();
		seleccionalJT= new JTextField();
		fechaRetiroJT= new JTextField();
		fechaIngresoJT= new JTextField();

		produzcamosJCh= new JRadioButton("Produzcamos");
		produzcamosJCh.setBackground(Color.white);
		produzcamosJCh.addChangeListener(this);
		ayudemonosJCh= new JRadioButton("Ayudemonos");
		ayudemonosJCh.setBackground(Color.white);
		ayudemonosJCh.addChangeListener(this);
		
		
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
	public void stateChanged(ChangeEvent evento) {
		if(produzcamosJCh.isSelected()== true) { 
			
		}
		
		if (ayudemonosJCh.isSelected()== true){
			
		}
		
	}
		
	}

