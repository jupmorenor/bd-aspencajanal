package interfaz.interfazAdministrador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import interfaz.PanelDatosMod;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import nucleo.Pensionado;

public class VentanaModificarPen extends JDialog implements ActionListener{

	private JLabel observacionesJL;
	
	private JTextArea observacionesJA;
	
	private JButton salirJB;
	
	private PanelDatosMod panelDatosMod;
	
	private static final String CERRAR = "GUARDAR Y CERRAR";
	
	
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
		if (e.getActionCommand().equals(CERRAR)) {

			Pensionado pensionado = new Pensionado();
			
			pensionado.actualizarPensionado();
			//Pensionado pensionado = panelDatosMod.modificarPensionado();
			pensionado.setObservaciones(observacionesJA.getText());
			//TODO todo lo de conectar y eso
			pensionado.modificarRegistro();
			setVisible(false);
            dispose( );			
		}
		
	}

}