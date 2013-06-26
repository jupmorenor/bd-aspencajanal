package interfaz.interfazAdministrador;

import interfaz.VentanaAgregarPen;
import interfaz.VentanaConsultaCumpleanos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.*;

import conexion.Conector;

import nucleo.Pensionado;

public class InterfazAdministrador extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	
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
	private static final String AGREGAR = "AGREGAR PENSIONADO";
	private static final String MESES[] = { "Enero", "Febrero", "Marzo",
			"Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
			"Octubre", "Noviembre", "Diciembre" };
	private String mesSelecionado;

	private ImageIcon icono;

	public InterfazAdministrador() {
		setLayout(null);
		setTitle("ADMINISTRADOR");
		getContentPane().setBackground(Color.white);
		setSize(270, 315);
		setResizable(false);
		setLocationRelativeTo(null);
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

		BufferedReader acceso;
		ArrayList<String> datos;
		Conector conector;
		ResultSet tabla;
		try {
			acceso = new BufferedReader(new FileReader("./data/datos.jaa"));
		} catch (Exception ex) {
			acceso = null;
		}
		if (acceso != null) {
			try {
				String linea;
				datos = new ArrayList<String>();

				while ((linea = acceso.readLine()) != null) {
					datos.add(linea);
				}
				acceso.close();
				conector = new Conector(datos.get(0), datos.get(1),
						datos.get(2), datos.get(3));

				switch (e.getActionCommand()) {

				case CONSULTAR:
					String buscar = JOptionPane.showInputDialog(this,
							"Ingrese la cedula del pensionado",
							"Buscar Pensionado por C.C",
							JOptionPane.INFORMATION_MESSAGE);
					
					if (buscar != null) {

						Pensionado pensionado = new Pensionado();
						pensionado.setCedula(buscar);
						conector.SetCadena(pensionado.consultarRegistro());
						tabla = conector.Consultar();
	
						if (tabla.next()) {
							pensionado.setIdPensionado(tabla.getString("idpensionado"));
							pensionado.setIdEstado(tabla.getString("descestado"));
							pensionado.setIdDepartamento(tabla.getString("descdepartamento"));
							pensionado.setNombres(tabla.getString("nombres"));
							pensionado.setApellidos(tabla.getString("apellidos"));
							pensionado.setCedula(tabla.getString("cedula"));
							pensionado.setCodigo(tabla.getString("codigo"));
							pensionado.setDireccion(tabla.getString("direccion"));
							pensionado.setBarrio(tabla.getString("barrio"));
							pensionado.setZonaPostal(tabla.getString("zonapostal"));
							pensionado.setFechaNacimiento(tabla.getString("fechanacimiento"));
							pensionado.setTelefono(tabla.getString("telefono"));
							pensionado.setTelefonoAlternativo(tabla.getString("telefonoalternativo"));
							pensionado.setObservaciones(tabla.getString("observaciones"));
							pensionado.setProduzcamos(tabla.getBoolean("produzcamos"));
							pensionado.setAyudemonos(tabla.getBoolean("ayudemos"));
							pensionado.setEmail(tabla.getString("e_mail"));
							pensionado.setFechaIngreso(tabla.getString("fechaingreso"));
							pensionado.setFechaRetiro(tabla.getString("fecharetiro"));
							pensionado.setCiudad(tabla.getString("ciudad"));
							pensionado.setSeccional(tabla.getString("seccional"));
	
							VentanaConsultaAdmi vCA = new VentanaConsultaAdmi(pensionado);
							vCA.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(this, "El cliente que ingresó no existe !!");
						}
					}
					break;

				case CONSULTARPER:
					VentanaConsultaPersonalizada vCP = new VentanaConsultaPersonalizada();
					vCP.setVisible(true);
					break;

				case CUMPLEANOS:
					String seleccionMes = (String) JOptionPane.showInputDialog(
							null, "SELECIONE EL MES",
							"Consulta Cumpleaños por mes",
							JOptionPane.QUESTION_MESSAGE, icono, MESES,
							"Seleccione mes");
					
					if(seleccionMes != null) {

						for (int i = 0; i < MESES.length; i++)
							if (MESES[i].equals(seleccionMes))
								mesSelecionado =Integer.toString(i+1);

						Pensionado pensionado1 = new Pensionado();
						conector.SetCadena(pensionado1.consultaCumpleanos(mesSelecionado));
						tabla = conector.Consultar();

						VentanaConsultaCumpleanos vCC = new VentanaConsultaCumpleanos(tabla, seleccionMes);
						vCC.setVisible(true);
					}
					break;

				case MODIFICAR:
					String buscar1 = JOptionPane.showInputDialog(this,
							"Ingrese la cedula del pensionado",
							"Modificar Pensionado ",
							JOptionPane.INFORMATION_MESSAGE);
					if (buscar1 != null) {
						
						Pensionado pensionado2 = new Pensionado();
						pensionado2.setCedula(buscar1);
						conector.SetCadena(pensionado2.modificarConsulta());
						tabla = conector.Consultar();
	
						if (tabla.next()) {
							pensionado2.setIdPensionado(tabla.getString("idpensionado"));
							pensionado2.setIdEstado(tabla.getString("idestado"));
							pensionado2.setIdDepartamento(tabla.getString("iddepartamento"));
							pensionado2.setNombres(tabla.getString("nombres"));
							pensionado2.setApellidos(tabla.getString("apellidos"));
							pensionado2.setCedula(tabla.getString("cedula"));
							pensionado2.setCodigo(tabla.getString("codigo"));
							pensionado2.setDireccion(tabla.getString("direccion"));
							pensionado2.setBarrio(tabla.getString("barrio"));
							pensionado2.setZonaPostal(tabla.getString("zonapostal"));
							pensionado2.setFechaNacimiento(tabla.getString("fechanacimiento"));
							pensionado2.setTelefono(tabla.getString("telefono"));
							pensionado2.setTelefonoAlternativo(tabla.getString("telefonoalternativo"));
							pensionado2.setObservaciones(tabla.getString("observaciones"));
							pensionado2.setProduzcamos(tabla.getBoolean("produzcamos"));
							pensionado2.setAyudemonos(tabla.getBoolean("ayudemos"));
							pensionado2.setEmail(tabla.getString("e_mail"));
							pensionado2.setFechaIngreso(tabla.getString("fechaingreso"));
							pensionado2.setFechaRetiro(tabla.getString("fecharetiro"));
							pensionado2.setCiudad(tabla.getString("ciudad"));
							pensionado2.setSeccional(tabla.getString("seccional"));
	
							VentanaModificarPen vMP = new VentanaModificarPen(pensionado2);
							vMP.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(this, "El cliente que ingresó no existe !!");
						}
					}
					break;

				case AGREGAR:
					conector.SetCadena("SELECT count(*) FROM pensionado;");
					tabla = conector.Consultar();
					tabla.next();
					VentanaAgregarPen vAP = new VentanaAgregarPen(""+(tabla.getInt("count")+1));
					vAP.setVisible(true);
					break;

				case SALIR:
					setVisible(false);
					dispose();
					break;

				}

				conector.CerrarBase();

			} catch (Exception ioex) {
				JOptionPane.showMessageDialog(this,
						"No se encuentran los datos de conexion",
						"Error de conexion", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(this,
					"No se encuentran los datos de conexion",
					"Error de conexion", JOptionPane.ERROR_MESSAGE);
		}

	}

}
