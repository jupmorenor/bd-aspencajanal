package interfaz;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;


public class VentanaAgregarPen extends JDialog implements ActionListener {

	private JLabel observacionesJL;
	private JTextArea observacionesJA;
	private JButton salirJB;
	private JButton AgregarHVJB;
	private static final String GUARDAR = "GUARDAR Y CERRAR";
	private static final String HOJA_VIDA = "HOJA DE VIDA";
	
	public VentanaAgregarPen(){
		
		setLayout(null);
		setTitle("AGREGAR PENSIONADO");
		getContentPane().setBackground(Color.white);
		setSize(645, 600);
		setResizable(false);
		this.setLocationRelativeTo(null);
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
		
		PanelDatosAgregar panelDatosAgregar = new PanelDatosAgregar();
		

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
			//TODO agregar el nuevo pensionado a la BD
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