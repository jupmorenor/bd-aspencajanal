package interfaz.interfazAdministrador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import interfaz.PanelDatosMod;

public class VentanaAgregarPen extends JDialog implements ActionListener {

	private JLabel observacionesJL;
	private JTextArea observacionesJA;
	private JButton salirJB;
	private JButton AgregarHVJB;
	private static final String GUARDAR = "GUARDAR Y CERRAR";
	private static final String HOJA_VIDA = "HOJA DE VIDA";
	
	public VentanaAgregarPen(){
		
		setLayout(null);
		setTitle("MODIFICAR PENSIONADO");
		getContentPane().setBackground(Color.white);
		setSize(545, 600);
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
		
		PanelDatosMod panelDatosMod = new PanelDatosMod();
		
		add(AgregarHVJB);
		AgregarHVJB.setBounds(350,470,150,30);	
		
		add(panelDatosMod);
		panelDatosMod.setBounds(20,20,500,400);
		
		add(observacionesJL);
		observacionesJL.setBounds(50,420,200,30);
		
		add(observacionesJA);
		observacionesJA.setBorder(new LineBorder(Color.BLACK));
		observacionesJA.setEditable(false);
		observacionesJA.setBounds(20,460,300,100);
		
		add(salirJB);
		salirJB.setBounds(350,520,150,30);
		
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