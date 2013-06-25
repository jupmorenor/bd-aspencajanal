package interfaz;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class VentanaConsultaCumpleanos extends JDialog implements ActionListener{

	private JLabel cumpleanosJL;
	
	private JTable listadoCumJA;
	public JScrollPane tablero;
	private JButton cerrarJB;

	private DefaultTableModel modelo;
	
	private static final String SALIR = "SALIR";
	
	
	public VentanaConsultaCumpleanos(ResultSet tabla,String mes) throws SQLException{
		
		setLayout(null);
		setTitle("CONSULTA CUMPLEANOS");
		getContentPane().setBackground(Color.white);
		setSize(400,500);
		setResizable(false);
		setLocationRelativeTo(null);
        setModalityType(DEFAULT_MODALITY_TYPE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		cumpleanosJL = new JLabel("Cumpleaños de "+ mes);			
		modelo = new DefaultTableModel();
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		modelo.addColumn("Dia");
		
		 while (tabla.next()) {
			  Object[] fila = new Object[3];
			  for (int i = 0; i < 3; i++) {
			    fila[i]=tabla.getObject(i+1);
			  }
			  modelo.addRow(fila);
			 }
		listadoCumJA = new JTable(modelo);
		tablero = new JScrollPane();
		tablero.setViewportView(listadoCumJA);
		listadoCumJA.setBorder(new LineBorder( Color.BLACK ));
		cerrarJB = new JButton(SALIR);
		cerrarJB.addActionListener(this);
		cerrarJB.setActionCommand(SALIR);
		
		add(cumpleanosJL);
		cumpleanosJL.setBounds(30, 30, 200, 30);
		add(tablero);
		tablero.setBounds(22, 70, 346, 350);
		add(cerrarJB);
		cerrarJB.setBounds(280, 430,100,30);
		
		
		DefaultTableModel modelo = new DefaultTableModel();
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(SALIR)) {
			setVisible( false );
            dispose( );
		}		
	}
}