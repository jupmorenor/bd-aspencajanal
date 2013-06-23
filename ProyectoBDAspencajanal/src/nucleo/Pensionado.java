package nucleo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Pensionado implements AccesoaDatos {
	
	private String idPensionado;
	private String idDepartamento;
	private String nombres;
	private String apellidos;
	private String cedula;
	private String codigo;
	private String direccion;
	private String barrio;
	private String ciudad;
	private String zonaPostal;
	private Date fechaNacimiento;
	private String telefono;
	private String telefonoAlternativo;
	private String observaciones;
	private boolean produzcamos; 
	private boolean ayudemonos;
	private String email;
	private String seccional;
	private Date fechaIngreso;
	private Date fechaRetiro;
	private SimpleDateFormat formato = new SimpleDateFormat("dd-mm-yyyy");
	
	public Pensionado() {
	}
	
	public String getIdPensionado() {
		return idPensionado;
	}

	public void setIdPensionado(String idPensionado) {
		this.idPensionado = idPensionado;
	}

	public String getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(String idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getZonaPostal() {
		return zonaPostal;
	}

	public void setZonaPostal(String zonaPostal) {
		this.zonaPostal = zonaPostal;
	}

	public String getFechaNacimiento() {
		return this.formato.format(fechaNacimiento);
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		try {
			this.fechaNacimiento = this.formato.parse(fechaNacimiento);
		}catch(ParseException pE) {
			this.fechaNacimiento = null;
		}
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTelefonoAlternativo() {
		return telefonoAlternativo;
	}

	public void setTelefonoAlternativo(String telefonoAlternativo) {
		this.telefonoAlternativo = telefonoAlternativo;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public boolean isProduzcamos() {
		return produzcamos;
	}

	public void setProduzcamos(boolean produzcamos) {
		this.produzcamos = produzcamos;
	}

	public boolean isAyudemonos() {
		return ayudemonos;
	}

	public void setAyudemonos(boolean ayudemonos) {
		this.ayudemonos = ayudemonos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSeccional() {
		return seccional;
	}

	public void setSeccional(String seccional) {
		this.seccional = seccional;
	}

	public String getFechaIngreso() {
		return this.formato.format(fechaIngreso);
	}

	public void setFechaIngreso(String fechaIngreso) {
		try {
			this.fechaIngreso = this.formato.parse(fechaIngreso);
		}catch(ParseException pE) {
			this.fechaIngreso = null;
		}
	}

	public String getFechaRetiro() {
		return this.formato.format(fechaRetiro);
	}

	public void setFechaRetiro(String fechaRetiro) {
		try {
			this.fechaRetiro = this.formato.parse(fechaRetiro);
		}catch(ParseException pE) {
			this.fechaRetiro = null;
		}
	}

	@Override
	public String guardarRegistro() {
		String cadena = "INSERT INTO Pensionado VALUES";
		return cadena;//TODO sentencia SQL
	}

	@Override
	public String eliminarRegistro() {
		String cadena = "DELETE FROM Pensionado WHERE cedula='" + this.getCedula() + "';";
		return cadena;
	}

	@Override
	public String modificarRegistro() {
		String cadena = "";//TODO sentencia SQL
		return cadena;
	}

	@Override
	public String consultarRegistro() {
		String cadena = "SELECT * FROM Pensionado WHERE cedula='" + this.getCedula() + "';";
		return cadena;
	}

}
