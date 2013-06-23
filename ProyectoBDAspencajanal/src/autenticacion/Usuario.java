package autenticacion;

public abstract class Usuario {
	
	private String idUsuario;
	private String idCargo;
	private String password;

	public Usuario() {
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getIdcargo() {
		return idCargo;
	}

	public void setIdcargo(String idcargo) {
		this.idCargo = idcargo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String consultarUsuario(){
		String cadena = "SELECT idCargo, password FROM Usuario WHERE idUsuario='" + getIdUsuario() + "';";
		return cadena;
	}

}
