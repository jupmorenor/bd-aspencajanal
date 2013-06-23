package interfaz.interfazAdministrador;

import interfaz.PanelDatos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class VentanaConsultaAdmi extends JDialog implements ActionListener{

	private JLabel observacionesJL;

	private JTextArea observacionesJA;

	private JButton salirJB;
	private JButton hojaVidaJB;
	
	private PanelDatos panelDatos;
	
	private static final String CERRAR = "CERRAR";
	private static final String HOJA_VIDA = "HOJA DE VIDA";
	
	
	public VentanaConsultaAdmi(){
		
		setLayout(null);
		setTitle("CONSULTA DEL EMPLEADO");
		getContentPane().setBackground(Color.white);
		setSize(545, 600);
		setResizable(false);
		this.setLocationRelativeTo(null);
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
		
		panelDatos= new PanelDatos();
		
		add(panelDatos);
		panelDatos.setBounds(20,20,500,400);
		
		add(observacionesJL);
		observacionesJL.setBounds(50,420,200,30);
		
		add(observacionesJA);
		observacionesJA.setBorder(new LineBorder( Color.BLACK ));
		observacionesJA.setText("Ingresar de la base de datos las observaciones");
		observacionesJA.setEditable(false);
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
			setVisible( false );
	        dispose( );	
	        break;
	        
		case HOJA_VIDA:
			//TODO abrir la imagen desde la ubicacion dada
			break;
		}
	}
}
