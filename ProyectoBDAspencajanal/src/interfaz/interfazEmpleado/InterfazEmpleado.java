package interfaz.interfazEmpleado;

import interfaz.VentanaAgregarPen;
import interfaz.interfazAdministrador.VentanaConsultaCumpleanosAdm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import conexion.Conector;

import nucleo.Pensionado;

public class InterfazEmpleado extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JButton consultaJB;
	private JButton birthdayJB;
	private JButton cerrarJB;
	private JButton agregarPJB;

	private static final String CONSULTAR = "CONSULTA POR C.C.";
	private static final String CUMPLEANOS = "CUMPLEANOS";
	private static final String SALIR = "CERRAR SESION";
	private static final String AGREGAR = "AGREGAR PENSIONADO";
	private static final String MESES[] = { "Enero", "Febrero", "Marzo",
			"Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
			"Octubre", "Noviembre", "Diciembre" };
	private String mesSelecionado;
	private ImageIcon icono;

	public InterfazEmpleado() {
		setLayout(null);
		setTitle("EMPLEADO");
		getContentPane().setBackground(Color.white);
		setSize(270, 235);
		setResizable(false);
		setLocationRelativeTo(null);
		setModalityType(DEFAULT_MODALITY_TYPE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		icono = new ImageIcon("data/pastel.png");

		consultaJB = new JButton(CONSULTAR);
		consultaJB.addActionListener(this);
		consultaJB.setActionCommand(CONSULTAR);

		birthdayJB = new JButton(CUMPLEANOS);
		birthdayJB.addActionListener(this);
		birthdayJB.setActionCommand(CUMPLEANOS);

		agregarPJB = new JButton(AGREGAR);
		agregarPJB.addActionListener(this);
		agregarPJB.setActionCommand(AGREGAR);

		cerrarJB = new JButton(SALIR);
		cerrarJB.addActionListener(this);
		cerrarJB.setActionCommand(SALIR);

		add(consultaJB);
		consultaJB.setBounds(30, 30, 200, 30);
		add(birthdayJB);
		birthdayJB.setBounds(30, 70, 200, 30);
		add(agregarPJB);
		agregarPJB.setBounds(30, 110, 200, 30);
		add(cerrarJB);
		cerrarJB.setBounds(30, 150, 200, 30);

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
	
							VentanaConsultaEmp vCE = new VentanaConsultaEmp(pensionado);
							vCE.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(this, "El cliente que ingresó no existe !!");
						}
					}

					break;

				case CUMPLEANOS:
					String seleccionMes = (String) JOptionPane.showInputDialog(
							null, "SELECIONE EL MES",
							"Consulta Cumpleaños por mes",
							JOptionPane.QUESTION_MESSAGE, icono, MESES,
							"Seleccione mes");
					if (seleccionMes != null) {
						
						for (int i = 0; i < MESES.length; i++)
							if (MESES[i].equals(seleccionMes))
								mesSelecionado = Integer.toString(i + 1);
	
						Pensionado pensionado1 = new Pensionado();
						conector.SetCadena(pensionado1.consultaCumpleanos(mesSelecionado));
						tabla = conector.Consultar();


						VentanaConsultaCumpleanosEmp vCC = new VentanaConsultaCumpleanosEmp(
								tabla, seleccionMes);
						vCC.setVisible(true);
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
