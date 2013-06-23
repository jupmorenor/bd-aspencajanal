package InterfazAdministrador;

import interfaz.PanelDatosMod;

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
		salirJB = new JButton("GUARDAR Y CERRAR");
		salirJB.addActionListener(this);
		salirJB.setActionCommand("cerrar");
		AgregarHVJB = new JButton("HOJA DE VIDA");
		AgregarHVJB.addActionListener(this);
		AgregarHVJB.setActionCommand("hojaVida");
		
		PanelDatosMod panelDatosMod = new PanelDatosMod();
		
		add(AgregarHVJB);
		AgregarHVJB.setBounds(350,470,150,30);		
		add(panelDatosMod);
		panelDatosMod.setBounds(20,20,500,400);
		add(observacionesJL);
		observacionesJL.setBounds(50,420,200,30);
		add(observacionesJA);
		observacionesJA.setBorder(new LineBorder( Color.BLACK ));
		observacionesJA.setEditable(false);
		observacionesJA.setBounds(20,460,300,100);
		add(salirJB);
		salirJB.setBounds(350,520,150,30);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("cerrar")) {
			setVisible( false );
            dispose( );			
		}
		
	}

}

