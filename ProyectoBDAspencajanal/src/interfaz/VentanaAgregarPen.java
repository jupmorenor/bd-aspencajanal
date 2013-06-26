package interfaz;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.ResultSet;
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

	private JLabel observacionesJL;
	private JTextArea observacionesJA;
	private JButton salirJB;
	private JButton AgregarHVJB;
	private PanelDatosMod panelDatosAgregar;
	private static final String GUARDAR = "GUARDAR Y CERRAR";
	private static final String HOJA_VIDA = "HOJA DE VIDA";
	
	public VentanaAgregarPen(){
		
		setLayout(null);
		setTitle("AGREGAR PENSIONADO");
		getContentPane().setBackground(Color.white);
		setSize(645, 600);
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
		
		panelDatosAgregar = new PanelDatosMod();
		
		add(panelDatosAgregar);
		panelDatosAgregar.setBounds(20,20,600,350);		
		add(observacionesJL);
		observacionesJL.setBounds(50,400,300,30);
		add(observacionesJA);
		observacionesJA.setBorder(new LineBorder(Color.BLACK));
		observacionesJA.setWrapStyleWord(true);
		observacionesJA.setLineWrap(true); 
		observacionesJA.setBounds(20,440,300,120);
		add(AgregarHVJB);
		AgregarHVJB.setBounds(450,460,150,30);	
		add(salirJB);
		salirJB.setBounds(450,510,150,30);	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (e.getActionCommand()) {
		
		case GUARDAR:
			Pensionado pensionado = this.panelDatosAgregar.modificarPensionado();
			pensionado.setObservaciones(observacionesJA.getText());
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
					
					conector.SetCadena("SELECT count(*) FROM pensionado;");
					tabla = conector.Consultar();
					pensionado.setIdPensionado(""+(tabla.getInt("count")+1));
					conector.SetCadena(pensionado.guardarRegistro());
					conector.EjecutarSql();
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
		
			setVisible(false);
            dispose();
            break;
            
		case HOJA_VIDA:
			//TODO agregar la imagen a la carpeta de imagenes
			//XXX validad la necesidad de ingresar las imagenes por aca
			break;
			
		}	
	}
}