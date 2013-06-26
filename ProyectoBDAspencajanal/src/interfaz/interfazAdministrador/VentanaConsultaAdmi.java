package interfaz.interfazAdministrador;

import interfaz.PanelDatos;

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

public class VentanaConsultaAdmi extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;

	private JLabel observacionesJL;

	private JTextArea observacionesJA;

	private JButton salirJB;
	private JButton hojaVidaJB;
	
	private PanelDatos panelDatos;
	
	private static final String CERRAR = "CERRAR";
	private static final String HOJA_VIDA = "HOJA DE VIDA";
	
	private Pensionado pensionado;
	
	
	public VentanaConsultaAdmi(Pensionado pensionado){
		
		this.pensionado = pensionado;
		
		setLayout(null);
		setTitle("CONSULTA DEL EMPLEADO");
		getContentPane().setBackground(Color.white);
		setSize(545, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setModalityType(DEFAULT_MODALITY_TYPE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		observacionesJL= new JLabel ("OBSERVACIONES: ");
		observacionesJA= new JTextArea();
		
		salirJB = new JButton(CERRAR);
		salirJB.addActionListener(this);
		salirJB.setActionCommand(CERRAR);
		
		hojaVidaJB = new JButton(HOJA_VIDA);
		hojaVidaJB.addActionListener(this);
		hojaVidaJB.setActionCommand(HOJA_VIDA);
		
		panelDatos = new PanelDatos(pensionado);
		add(panelDatos);
		panelDatos.setBounds(20,20,500,400);
		
		add(observacionesJL);
		observacionesJL.setBounds(50,420,200,30);
		
		add(observacionesJA);
		observacionesJA.setBorder(new LineBorder( Color.BLACK ));
		observacionesJA.setText(pensionado.getObservaciones());
		observacionesJA.setBounds(20,460,300,100);
		
		add(hojaVidaJB);
		hojaVidaJB.setBounds(350,470,150,30);
		
		add(salirJB);
		salirJB.setBounds(350,520,150,30);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (e.getActionCommand()) {
		
		case CERRAR:
			
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
			setVisible( false );
	        dispose( );	
	        break;
	        
		case HOJA_VIDA:
			//TODO abrir la imagen desde la ubicacion dada
			break;
		}
	}
}
