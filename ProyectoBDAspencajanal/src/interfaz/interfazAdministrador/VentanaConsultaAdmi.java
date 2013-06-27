package interfaz.interfazAdministrador;

import interfaz.PanelDatos;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import nucleo.Pensionado;

public class VentanaConsultaAdmi extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	private static final String CERRAR = "CERRAR";
	private static final String HOJA_VIDA = "HOJA DE VIDA";

	private JLabel observacionesJL;

	private JTextArea observacionesJA;

	private JButton salirJB;
	private JButton hojaVidaJB;
	
	private PanelDatos panelDatos;
	
	private Pensionado pensionado;
	
	
	public VentanaConsultaAdmi(Pensionado pensionado){
		
		this.pensionado = pensionado;
		
		setLayout(null);
		setTitle("CONSULTA DEL EMPLEADO");
		getContentPane().setBackground(Color.white);
		setSize(695, 600);
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
		panelDatos.setBounds(20,20,650,400);
		
		add(observacionesJL);
		observacionesJL.setBounds(50,420,200,30);
		
		add(observacionesJA);
		observacionesJA.setBorder(new LineBorder( Color.BLACK ));
		observacionesJA.setText(pensionado.getObservaciones());
		observacionesJA.setEditable(false);
		observacionesJA.setBounds(20,460,450,100);
		
		add(hojaVidaJB);
		hojaVidaJB.setBounds(500,470,150,30);
		
		add(salirJB);
		salirJB.setBounds(500,520,150,30);
	
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
		
		switch (e.getActionCommand()) {
		
		case CERRAR:
			
			setVisible( false );
	        dispose( );	
	        break;
	        
		case HOJA_VIDA:
			BufferedReader acceso;
			String ubicacion = "";
			try {
				acceso = new BufferedReader(new FileReader("./data/archivos.jaa"));
			} catch (Exception ex) {
				acceso = null;
			}
			if (acceso!=null) {
				try {
					ubicacion = acceso.readLine()+pensionado.getIdPensionado();
					abrirCarpeta(ubicacion);
					acceso.close();
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
