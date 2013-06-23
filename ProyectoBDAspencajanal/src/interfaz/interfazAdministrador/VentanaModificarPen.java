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

public class VentanaModificarPen extends JDialog implements ActionListener{

	private JLabel observacionesJL;
	
	private JTextArea observacionesJA;
	
	private JButton salirJB;
	
	private PanelDatosMod panelDatosMod;
	
	private static final String CERRAR = "GUARDAR Y CERRAR";
	
	
	public VentanaModificarPen(){
		
		setLayout(null);
		setTitle("MODIFICAR PENSIONADO");
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
		
		panelDatosMod = new PanelDatosMod();
		
		add(panelDatosMod);
		panelDatosMod.setBounds(20,20,500,350);
		
		add(observacionesJL);
		observacionesJL.setBounds(50,400,200,30);
		
		add(observacionesJA);
		observacionesJA.setBorder(new LineBorder( Color.BLACK ));
		observacionesJA.setEditable(false);
		observacionesJA.setBounds(20,440,300,120);
		
		add(salirJB);
		salirJB.setBounds(350,530,150,30);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(CERRAR)) {
			//TODO guardar los datos modificados en la BD
			setVisible( false );
            dispose( );			
		}
		
	}

}