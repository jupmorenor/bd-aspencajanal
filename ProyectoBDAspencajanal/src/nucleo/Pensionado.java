package nucleo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Pensionado implements AccesoaDatos {
	
	private String idPensionado;
	private String idEstado;
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
	private SimpleDateFormat formato = new SimpleDateFormat("yyyy-mm-dd");
	
	public Pensionado() {
	}
	
	public String getIdPensionado() {
		return idPensionado;
	}

	public void setIdPensionado(String idPensionado) {
		this.idPensionado = idPensionado;
	}

	public String getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(String idEstado) {
		this.idEstado = idEstado;
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
		String fecha = "";
		if (fechaNacimiento!=null) {
			fecha = this.formato.format(fechaNacimiento);
		}
		return fecha;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		try {
			this.fechaNacimiento = this.formato.parse(fechaNacimiento);
		}catch(Exception pE) {
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
		String fecha="";
		if (fechaIngreso!=null) {
			fecha = this.formato.format(fechaIngreso);
		}
		return fecha;
	}

	public void setFechaIngreso(String fechaIngreso) {
		try {
			this.fechaIngreso = this.formato.parse(fechaIngreso);
		}catch(Exception pE) {
			this.fechaIngreso = null;
		}
	}

	public String getFechaRetiro() {
		String fecha="";
		if (fechaRetiro!=null) {
			fecha = this.formato.format(fechaRetiro);
		}
		return fecha;
	}

	public void setFechaRetiro(String fechaRetiro) {
		try {
			this.fechaRetiro = this.formato.parse(fechaRetiro);
		}catch(Exception pE) {
			this.fechaRetiro = null;
		}
	}

	@Override
	public String guardarRegistro() {
		String cadena = "INSERT INTO Pensionado VALUES(" +
				"'"+getIdPensionado()+"', " +
				"'"+getIdEstado()+"', " +
				"'"+getIdDepartamento()+"', " +
				"'"+getNombres()+"', " +
				"'"+getApellidos()+"', " +
				"'"+getCedula()+"', " +
				"'"+getCodigo()+"', " +
				"'"+getDireccion()+"', " +
				"'"+getBarrio()+"', " +
				"'"+getZonaPostal()+"', " +
				"'"+getFechaNacimiento()+"', " +
				"'"+getTelefono()+"', " +
				"'"+getTelefonoAlternativo()+"', " +
				"'"+getObservaciones()+"', " +
				"'"+isProduzcamos()+"', " +
				"'"+isAyudemonos()+"', " +
				"'"+getEmail()+"', " +
				"'"+getFechaIngreso()+"', " +
				"'"+getFechaRetiro()+"', " +
				"'"+getCiudad()+"', " +
				"'"+getSeccional()+"');";
		return cadena;
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
	
	public String modificarConsulta(){
			String cadena ="SELECT  * FROM pensionado WHERE cedula='"+ this.getCedula() + "';";
			return cadena;
		
	}
	
	@Override
	public String consultarRegistro() {
		String cadena ="SELECT p.idpensionado, d.descdepartamento, e.descestado, p.nombres," +
					   " p.apellidos, p.cedula, p.codigo, p.direccion, p,barrio, p.zonapostal," +
					   " p.fechanacimiento, p.telefono, p.telefonoalternativo, p.observaciones," +
					   " p.produzcamos, p.ayudemos, p.e_mail, p.fechaingreso, p.fecharetiro," +
					   " p.ciudad, p.seccional FROM pensionado p, departamento d, estado e WHERE" +
					   " d.iddepartamento=p.iddepartamento AND e.idestado=p.idestado AND  p.cedula='"
					   + this.getCedula() + "';";
		return cadena;
	}
	
	public String consultaCumplanos(String mes){
		
		String cadena = "SELECT nombres, apellidos,  to_char(fechanacimiento, 'dd') FROM pensionado " +
						"WHERE extract(month from fechanacimiento)='"+ mes + "'and idestado='1' " +
						"ORDER by extract(day from fechanacimiento);";				
		return cadena; 
		
	}
	
	public String actualizarPensionado(Pensionado pensionado){
		String cadena="";		
		return cadena; 
	}
}

