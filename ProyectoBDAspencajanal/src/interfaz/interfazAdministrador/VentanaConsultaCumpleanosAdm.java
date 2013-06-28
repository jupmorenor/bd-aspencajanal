package interfaz.interfazAdministrador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import exportador.ExportarAExcel;

public class VentanaConsultaCumpleanosAdm extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;

	private JLabel cumpleanosJL;
	
	private JTable listadoCumJA;
	public JScrollPane tablero;
	private JButton cerrarJB;

	private DefaultTableModel modelo;
	
	private static final String EXPORTAR = "Exportar";
	
	
	public VentanaConsultaCumpleanosAdm(ResultSet tabla,String mes) throws SQLException{
		
		setLayout(null);
		setTitle("CONSULTA CUMPLEANOS");
		getContentPane().setBackground(Color.white);
		setSize(520,600);
		setResizable(false);
		setLocationRelativeTo(null);
        setModalityType(DEFAULT_MODALITY_TYPE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		cumpleanosJL = new JLabel("Cumpleaños de "+ mes);			
		modelo = new DefaultTableModel();
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		modelo.addColumn("Dia");

		while (tabla.next()){
			Object[] fila = new Object[3];
			for (int i = 0; i < 3; i++){
				fila[i]=tabla.getObject(i+1);
			}
			modelo.addRow(fila);
		}
	 
		listadoCumJA = new JTable(modelo);
		tablero = new JScrollPane();
		tablero.setViewportView(listadoCumJA);
		listadoCumJA.setBorder(new LineBorder( Color.BLACK ));
		cerrarJB = new JButton(EXPORTAR);
		cerrarJB.addActionListener(this);
		cerrarJB.setActionCommand(EXPORTAR);
		
		add(cumpleanosJL);
		cumpleanosJL.setBounds(30, 30, 200, 30);
		add(tablero);
		tablero.setBounds(22, 70, 466, 450);
		add(cerrarJB);
		cerrarJB.setBounds(400, 530,100,30);
	}
	
	/**
	 * Genera un archivo de excel con los datos que se estan visualizando en la ventana
	 * usando la API jxl
	 */
	private void exportarExcel() {
		List<JTable> lista = new ArrayList<JTable>();
		ExportarAExcel exportar = null;
		lista.add(listadoCumJA);
		try {
			exportar = new ExportarAExcel(lista, new File("C:\\Users\\" + System.getProperty("user.name") + "\\desktop\\cumpleaños.xls"));
			if (exportar.export()) {
				JOptionPane.showMessageDialog(this, "Datos exportados con exito", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error de exportacion", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(EXPORTAR)) {
			exportarExcel();
		}		
	}
}