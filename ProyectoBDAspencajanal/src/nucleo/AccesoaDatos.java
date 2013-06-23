/* 
 * ------------------------------------------
 * 
 * AccesoaDatos.java
 * 
 * ------------------------------------------
 */
package nucleo;

/**
 * Interfaz con metodos para generar los comandos de acceso a la base de datos
 * @author Juan Pablo Moreno Rico
 * @version 1.0
 */
public interface AccesoaDatos {

	/**
	 * Devuelve el comando de postgreSql que inserta un registro en la base de datos
	 * @return String
	 */
	public String guardarRegistro();

	/**
	 * Devuelve el comando de postgreSql que elimina un registro de la base de datos
	 * @return String
	 */
	public String eliminarRegistro();

	/**
	 * Devuelve el comando de postgreSql que actualiza un registro de la base de datos
	 * @return String
	 */
	public String modificarRegistro();

	/**
	 * Devuelve el comando de postgreSql que busca un registro en la base de datos
	 * @return String
	 */
	public String consultarRegistro();

}
