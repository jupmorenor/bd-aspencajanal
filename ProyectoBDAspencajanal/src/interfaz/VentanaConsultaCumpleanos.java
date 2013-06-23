package interfaz;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

public class VentanaConsultaCumpleanos extends JDialog implements ActionListener{

	private JLabel cumpleanosJL;
	
	private JTable listadoCumJA;
	
	private JButton cerrarJB;
	
	private static final String SALIR = "SALIR";
	
	public VentanaConsultaCumpleanos(String mes){
		
		setLayout(null);
		setTitle("CUNSULTA CUMPLEANOS");
		getContentPane().setBackground(Color.white);
		setSize(400,500);
		setResizable(false);
		setLocationRelativeTo(null);
        setModalityType(DEFAULT_MODALITY_TYPE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		cumpleanosJL = new JLabel("Cumpleaños de "+ mes);
		listadoCumJA = new JTable();
		listadoCumJA.setBorder(new LineBorder( Color.BLACK ));
		cerrarJB = new JButton(SALIR);
		cerrarJB.addActionListener(this);
		cerrarJB.setActionCommand(SALIR);
		
		add(cumpleanosJL);
		cumpleanosJL.setBounds(30, 30, 200, 30);
		add(listadoCumJA);
		listadoCumJA.setBounds(22, 70, 346, 350);
		add(cerrarJB);
		cerrarJB.setBounds(280, 430,100,30);
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(SALIR)) {
			setVisible( false );
            dispose( );
		}		
	}
	
	
}
