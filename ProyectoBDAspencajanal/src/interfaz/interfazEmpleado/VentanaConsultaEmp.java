package interfaz.interfazEmpleado;

import interfaz.PanelDatos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
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


public class VentanaConsultaEmp extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;

	private JLabel observacionesJL;
	
	private JTextArea observacionesJA;
	
	private JButton salirJB;
	
	private PanelDatos panelDatos;
	
	private Pensionado pensionado;
	
	private static final String CERRAR = "CERRAR";
	
	
	public VentanaConsultaEmp(Pensionado pensionado){
		
		this.pensionado = pensionado;
		
		setLayout(null);
		setTitle("CONSULTA DEL EMPLEADO");
		getContentPane().setBackground(Color.white);
		setSize(695, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setModalityType(DEFAULT_MODALITY_TYPE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		observacionesJL= new JLabel("OBSERVACIONES: ");
		observacionesJA= new JTextArea(pensionado.getObservaciones());
		salirJB = new JButton(CERRAR);
		salirJB.addActionListener(this);
		salirJB.setActionCommand(CERRAR);
		
		panelDatos= new PanelDatos(pensionado);
		add(panelDatos);
		panelDatos.setBounds(20,20,650,400);
		
		add(observacionesJL);
		observacionesJL.setBounds(50,420,300,30);
		
		add(observacionesJA);
		observacionesJA.setBorder(new LineBorder( Color.BLACK ));
		observacionesJA.setWrapStyleWord(true);
		observacionesJA.setLineWrap(true); 
		observacionesJA.setBounds(20,460,450,100);
		
		add(salirJB);
		salirJB.setBounds(500,530,150,30);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(CERRAR)) {
			
			BufferedReader acceso;
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
					pensionado.setObservaciones(observacionesJA.getText());
					conector.SetCadena(pensionado.modificarObservacion());
					conector.EjecutarSql();
					
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
		}		
	}

}
