package interfaz.interfazAdministrador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import interfaz.PanelDatosMod;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import conexion.Conector;

import nucleo.Pensionado;

public class VentanaModificarPen extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;

	private JLabel observacionesJL;
	
	private JTextArea observacionesJA;
	
	private JButton salirJB;
	
	private PanelDatosMod panelDatosMod;
	
	private static final String CERRAR = "GUARDAR Y CERRAR";
	
	private Pensionado pensionado;
	
	
	public VentanaModificarPen(Pensionado pensionado){		
		setLayout(null);
		setTitle("MODIFICAR PENSIONADO");
		getContentPane().setBackground(Color.white);
		setSize(645, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setModalityType(DEFAULT_MODALITY_TYPE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		observacionesJL= new JLabel ("OBSERVACIONES: ");
		observacionesJA= new JTextArea();
		
		salirJB = new JButton(CERRAR);
		salirJB.addActionListener(this);
		salirJB.setActionCommand(CERRAR);
		
		panelDatosMod = new PanelDatosMod(pensionado);
		
		add(panelDatosMod);
		panelDatosMod.setBounds(20,20,600,350);
		
		add(observacionesJL);
		observacionesJL.setBounds(50,400,200,30);
		
		add(observacionesJA);
		observacionesJA.setBorder(new LineBorder( Color.BLACK ));
		observacionesJA.setEditable(false);
		observacionesJA.setBounds(20,440,400,120);
		
		add(salirJB);
		salirJB.setBounds(450,530,150,30);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	switch (e.getActionCommand()) {
		
		case CERRAR:
			pensionado = this.panelDatosMod.modificarPensionado();			
			pensionado.setObservaciones(observacionesJA.getText());
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
					conector.SetCadena(pensionado.modificarRegistro());
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
					setVisible( false );
					dispose( );
					
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
}