package interfaz.interfazAdministrador;

import interfaz.VentanaAgregarPen;
import interfaz.VentanaConsultaCumpleanos;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;


public class InterfazAdministrador extends JDialog implements ActionListener {

	private JButton consultaJB;
	private JButton consultaPerJB;
	private JButton birthdayJB;
	private JButton modificarPJB;
	private JButton agregarPJB;
	private JButton cerrarJB;
	
	private static final String CONSULTAR = "CONSULTA POR C.C.";
	private static final String CONSULTARPER = "CONSULTA PERSONALIZADA";
	private static final String CUMPLEANOS = "CUMPLEANOS";
	private static final String MODIFICAR = "MODIFICAR PENSIONADO";
	private static final String SALIR = "CERRAR SESION";	
	private static final String	AGREGAR = "AGREGAR PENSIONADO";

	private ImageIcon icono;
	
	public InterfazAdministrador() {
		setLayout(null);
		setTitle("ADMINISTRADOR");
		getContentPane().setBackground(Color.white);
		setSize(270, 315);
		setResizable(false);
		this.setLocationRelativeTo(null);
		setModalityType(DEFAULT_MODALITY_TYPE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		icono = new ImageIcon("data/pastel.png");
		consultaJB = new JButton(CONSULTAR);
		consultaJB.addActionListener(this);
		consultaJB.setActionCommand(CONSULTAR);
		
		consultaPerJB = new JButton(CONSULTARPER);
		consultaPerJB.addActionListener(this);
		consultaPerJB.setActionCommand(CONSULTARPER);
		
		birthdayJB = new JButton(CUMPLEANOS);
		birthdayJB.addActionListener(this);
		birthdayJB.setActionCommand(CUMPLEANOS);
		
		modificarPJB = new JButton(MODIFICAR);
		modificarPJB.addActionListener(this);
		modificarPJB.setActionCommand(MODIFICAR);
		
		agregarPJB = new JButton(AGREGAR);
		agregarPJB.addActionListener(this);
		agregarPJB.setActionCommand(AGREGAR);
		
		cerrarJB = new JButton(SALIR);
		cerrarJB.addActionListener(this);
		cerrarJB.setActionCommand(SALIR);

		add(consultaJB);
		consultaJB.setBounds(30, 30, 200, 30);
		add(consultaPerJB);
		consultaPerJB.setBounds(30, 70, 200, 30);
		add(birthdayJB);
		birthdayJB.setBounds(30, 110, 200, 30);
		add(modificarPJB);
		modificarPJB.setBounds(30, 150, 200, 30);
		add(agregarPJB);
		agregarPJB.setBounds(30, 190, 200, 30);
		add(cerrarJB);
		cerrarJB.setBounds(30, 230, 200, 30);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (e.getActionCommand()) {
		
		case CONSULTAR:
			String buscar = JOptionPane.showInputDialog(this,
					"Ingrese la cedula del pensionado",
					"Buscar Pensionado por C.C",
					JOptionPane.INFORMATION_MESSAGE);
			if (Integer.parseInt(buscar) == 1) {
				VentanaConsultaAdmi vCA = new VentanaConsultaAdmi();
				vCA.setVisible(true);
			} else
				JOptionPane.showMessageDialog(this,"El cliente que ingresó no existe !!");
						
			break;
			
		case CONSULTARPER:
			VentanaConsultaPersonalizada vCP = new VentanaConsultaPersonalizada();
			vCP.setVisible(true);
			break;
			
		case CUMPLEANOS:
			String seleccionMes = (String) JOptionPane.showInputDialog(null,
					"SELECIONE EL MES", "Consulta Cumpleaños por mes",
					JOptionPane.QUESTION_MESSAGE, icono, new Object[] { "Enero",
							"Febrero", "Marzo", "Abrir", "Mayo", "Junio",
							"Julio", "Agosto", "Septiembre", "Octubre",
							"Nobiembre", "Diciembre" }, "Seleccione mes");
			VentanaConsultaCumpleanos vCC = new VentanaConsultaCumpleanos(seleccionMes);
			vCC.setVisible(true);
			break;
			
		case MODIFICAR:
			String buscar1 = JOptionPane.showInputDialog(this,
					"Ingrese la cedula del pensionado",
					"Modificar Pensionado ",
					JOptionPane.INFORMATION_MESSAGE);
			if (Integer.parseInt(buscar1) == 1) {
				VentanaModificarPen vMP= new VentanaModificarPen();
				vMP.setVisible(true);
			} else
				JOptionPane.showMessageDialog(this,"El cliente que ingresó no existe !!");
			
			break;
			
		case AGREGAR:
			VentanaAgregarPen vAP= new VentanaAgregarPen();
			vAP.setVisible(true);
			break;
			
		case SALIR:
			// Cierra Sesión de la secretaria
			setVisible(false);
			dispose();
			break;

		}
	}

}
