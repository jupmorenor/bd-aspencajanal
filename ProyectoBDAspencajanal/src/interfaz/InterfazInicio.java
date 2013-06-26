package interfaz;

import interfaz.interfazAdministrador.InterfazAdministrador;
import interfaz.interfazEmpleado.InterfazEmpleado;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import autenticacion.Usuario;

import conexion.Conector;

public class InterfazInicio extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel imagen;
	private JLabel usuarioJL;
	private JLabel passwordJL;

	private JTextField usuarioJT;
	private JTextField passwordJT;

	private JButton ingresarJB;
	
	private ImageIcon icono;
	
	private static final String INGRESAR = "INGRESAR";
	
	public InterfazInicio() {
		
		icono = new ImageIcon("data/aspen.png");
		setIconImage(icono.getImage());
		setLayout(null);
		setTitle("Inicio");
		getContentPane().setBackground(Color.white);
		setSize(500, 260);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		usuarioJL = new JLabel(" Usuario");
		passwordJL = new JLabel(" Contraseña");		
		usuarioJT = new JTextField();
		passwordJT = new JPasswordField();
		icono = new ImageIcon("data/aspen.png");
		
		ingresarJB = new JButton(INGRESAR);
		ingresarJB.addActionListener(this);
		ingresarJB.setActionCommand(INGRESAR);
		
		imagen = new JLabel();
		imagen.setBounds(280, 20, 200, 180);
		imagen.setIcon(icono);
		add(imagen);
		
		add(usuarioJL);
		usuarioJL.setBounds(20, 30, 100, 30);
		add(usuarioJT);
		usuarioJT.setBounds(100, 30, 125, 30);
		add(passwordJL);
		passwordJL.setBounds(20, 80, 100, 30);
		add(passwordJT);
		passwordJT.setBounds(100, 80, 125, 30);
		add(ingresarJB);
		ingresarJB.setBounds(120, 160, 100, 30);
	}


	public static void main(String[] args) {
		InterfazInicio v = new InterfazInicio();
		v.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(INGRESAR)) {
			BufferedReader acceso;
			ArrayList<String> datos;
			String tipoUsuario = "";
			try {
				acceso = new BufferedReader(new FileReader("./data/datos.jaa"));
			}catch (Exception ex) {
				acceso = null;
			}
			if (acceso!=null) {
				try {
					String linea;
					datos = new ArrayList<String>();
					
					while((linea = acceso.readLine())!=null) {
						datos.add(linea);
					}
					acceso.close();
					Conector conector = new Conector(datos.get(0), datos.get(1), datos.get(2), datos.get(3));
					Usuario usuario = new Usuario();
					usuario.setIdUsuario(usuarioJT.getText());
					conector.SetCadena(usuario.consultarUsuario());
					ResultSet tabla = conector.Consultar();
					if(tabla.next()) {
						String pass = tabla.getString("password");
						if (pass.equals(passwordJT.getText())) {
							tipoUsuario = tabla.getString("idcargo");
						
							switch (tipoUsuario) {
							case "1":
								InterfazAdministrador iA = new InterfazAdministrador();
								iA.setVisible(true);
								break;
								
							case "2":				
								InterfazEmpleado iE = new InterfazEmpleado();
								iE.setVisible(true);
								break;
								
							}
						} else {
							JOptionPane.showMessageDialog(this, "Contraseña incorrecta", "Error de acceso", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(this, "Usuario '" + usuario.getIdUsuario() + "' no encontrado", "No encontrado", JOptionPane.ERROR_MESSAGE);
					}
					conector.CerrarBase();
				}catch (Exception ioex) {
					JOptionPane.showMessageDialog(this, "No se encuentran los datos de conexion", "Error de conexion", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this, "No se encuentran los datos de conexion", "Error de conexion", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}

