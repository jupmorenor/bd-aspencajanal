package autenticacion;

public class Usuario {
	
	private String idUsuario;

	public Usuario() {
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public String consultarUsuario(){
		String cadena = "SELECT idcargo, password FROM usuario WHERE idusario='" + getIdUsuario() + "';";
		return cadena;
	}

}
