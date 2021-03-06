package interfaz;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import conexion.Conector;

import nucleo.Pensionado;


public class VentanaAgregarPen extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JLabel observacionesJL;
	private JTextArea observacionesJA;
	private JButton salirJB;
	private JButton AgregarHVJB;
	private PanelDatosMod panelDatosAgregar;
	private static final String GUARDAR = "GUARDAR Y CERRAR";
	private static final String HOJA_VIDA = "HOJA DE VIDA";
	
	public VentanaAgregarPen(String nuevoID){
		
		setLayout(null);
		setTitle("AGREGAR PENSIONADO");
		getContentPane().setBackground(Color.white);
		setSize(695, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setModalityType(DEFAULT_MODALITY_TYPE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		observacionesJL= new JLabel ("OBSERVACIONES: ");
		observacionesJA= new JTextArea();
		
		salirJB = new JButton(GUARDAR);
		salirJB.addActionListener(this);
		salirJB.setActionCommand(GUARDAR);
		
		AgregarHVJB = new JButton(HOJA_VIDA);
		AgregarHVJB.addActionListener(this);
		AgregarHVJB.setActionCommand(HOJA_VIDA);
		
		panelDatosAgregar = new PanelDatosMod(nuevoID);
		
		add(panelDatosAgregar);
		panelDatosAgregar.setBounds(20,20,650,350);		
		add(observacionesJL);
		observacionesJL.setBounds(50,400,300,30);
		add(observacionesJA);
		observacionesJA.setBorder(new LineBorder(Color.BLACK));
		observacionesJA.setWrapStyleWord(true);
		observacionesJA.setLineWrap(true); 
		observacionesJA.setBounds(20,440,350,120);
		add(AgregarHVJB);
		AgregarHVJB.setBounds(500,460,150,30);	
		add(salirJB);
		salirJB.setBounds(500,510,150,30);	
	}
	
	/**
	 * Metodo que abre un archivo con el programa asociado a la extension
	 * el resto es relleno XD
	 * @param ubicacion
	 */
	private void abrirCarpeta(String ubicacion) {
		if (Desktop.isDesktopSupported()) {
			Desktop escritorio = Desktop.getDesktop();
			File archivo;
			try {
				archivo = new File(ubicacion);
				escritorio.open(archivo);
			}catch(Exception io) {
				JOptionPane.showMessageDialog(null, "No se encuentra la ruta");
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		BufferedReader acceso;
		switch (e.getActionCommand()) {
		
		case GUARDAR:
			Pensionado pensionado = this.panelDatosAgregar.modificarPensionado();
			pensionado.setObservaciones(observacionesJA.getText());
			
			ArrayList<String> datos;
			Conector conector;
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
					conector.SetCadena(pensionado.guardarRegistro());

					conector.EjecutarSql();
					String cadenaAuxiliar = "UPDATE pensionado SET fechanacimiento=NULL WHERE " +
							"fechanacimiento='0001/01/01' AND cedula='"+ pensionado.getCedula() +"'; " +
							"UPDATE pensionado set fechaingreso=NULL WHERE fechaingreso='0001/01/01' AND " +
							"cedula='"+ pensionado.getCedula() +"'; UPDATE pensionado SET fecharetiro=NULL " +
							"WHERE fecharetiro='0001/01/01' AND cedula='"+ pensionado.getCedula() +"';";
					
					conector = new Conector(datos.get(0), datos.get(1),
							datos.get(2), datos.get(3));
					conector.SetCadena(cadenaAuxiliar);
					conector.EjecutarSql();
					setVisible(false);
		            dispose();
					
				} catch (Exception ioex) {
					JOptionPane.showMessageDialog(this,
							"No se encuentran los datos de conexion",
							"Error de conexion", JOptionPane.ERROR_MESSAGE);
					ioex.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(this,
						"No se encuentran los datos de conexion",
						"Error de conexion", JOptionPane.ERROR_MESSAGE);
			}
		
            break;
            
		case HOJA_VIDA:

			String ubicacion = "";
			try {
				acceso = new BufferedReader(new FileReader("./data/archivos.jaa"));
			} catch (Exception ex) {
				acceso = null;
			}
			if (acceso!=null) {
				try {
					String cedula = panelDatosAgregar.getCedula();
					if (cedula.isEmpty()) {
						JOptionPane.showMessageDialog(this, "No ha ingresado la cedula", 
								"Error", JOptionPane.ERROR_MESSAGE);
					} else {
						ubicacion = acceso.readLine() + cedula;
						File nuevo = new File(ubicacion);
						nuevo.mkdir();
						abrirCarpeta(ubicacion);
						acceso.close();
					}
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(this, 
							"No hay imagenes asociadas a este registro",
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this,
						"No se encuentran los archivos",
						"Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
			
		}	
	}
}