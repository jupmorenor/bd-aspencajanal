package InterfazAdministrador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import interfaz.PanelDatos;
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
	
	
	public VentanaModificarPen(){
		
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
		salirJB = new JButton("GUARDAR Y CERRAR");
		salirJB.addActionListener(this);
		salirJB.setActionCommand("cerrar");
		panelDatosMod= new PanelDatosMod();
		
		add(panelDatosMod);
		panelDatosMod.setBounds(20,20,500,400);
		add(observacionesJL);
		observacionesJL.setBounds(50,420,200,30);
		add(observacionesJA);
		observacionesJA.setBorder(new LineBorder( Color.BLACK ));
		observacionesJA.setEditable(false);
		observacionesJA.setBounds(20,460,250,100);
		add(salirJB);
		salirJB.setBounds(350,530,150,30);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("cerrar")) {
			setVisible( false );
            dispose( );			
		}
		
	}

}