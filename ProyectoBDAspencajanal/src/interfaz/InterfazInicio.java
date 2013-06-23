package interfaz;

import interfaz.interfazAdministrador.InterfazAdministrador;
import interfaz.interfazEmpleado.InterfazEmpleado;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class InterfazInicio extends JFrame implements ActionListener {

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
			//TODO consultar los usuarios de la BD y validar que tipo de usuario es
			switch (usuarioJT.getText()) {
			case "1":
				// Ventana para el Administrador
				InterfazAdministrador iA = new InterfazAdministrador();
				iA.setVisible(true);
				break;
			case "2":
				// Ventana para el trabajador					
				InterfazEmpleado iE = new InterfazEmpleado();
				iE.setVisible(true);
				
				break;
			}
		}
	}
}

