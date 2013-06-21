package conexion;

import java.sql.*;

/**
 * Clase realiza la conexion con la base de datos
 * @author Adriana Maritza Montejo
 */
public class Conector 
{
	//declaracion de atributos
	private Connection dbConecta;
	private String CadenaSql;

	//
	/**
	 * El constructor de la clase crea la conexion con la base de datos
	 * @param pNombreServidor nombre del servidor
	 * @param pNombreBD nombre de la base de datos
	 * @param pLogin nombre del usuario de postgreSQL
	 * @param pPassword contraseña de ingreso de postgreSQL
	 */
	public Conector(String pNombreServidor, String pNombreBD, String pLongin, String pPassword)
	{
		try 
		{           
			Class.forName("org.postgresql.Driver").newInstance();
		}        
		catch(Exception ex) 
		{
			ex.printStackTrace();
		}
		try
		{
			String cone = "jdbc:postgresql://"+pNombreServidor+"/"+pNombreBD+"?user="+pLongin+"&password="+pPassword;
			dbConecta = DriverManager.getConnection(cone);
		}      
		catch (SQLException sqlEx) 
		{
			sqlEx.printStackTrace();
		}
	}

	/**
	 * cargar consultas sql
	 * @param cadena comando de la consulta
	 */
	public void SetCadena(String cadena)
	{
		CadenaSql=cadena;
	}

	/**
	 * ejecutar transacciones (insertar, actualizar, eliminar)
	 * @return rta
	 */
	public String EjecutarSql()
	{
		String rta = "";
		try
		{
			Statement stmt=dbConecta.createStatement();
			rta += stmt.executeUpdate(CadenaSql);  			
			dbConecta.close();

		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		} 
		return rta;
	}

	/**
	 * Ejecutar consultas
	 * @return tabla
	 */
	public ResultSet Consultar()
	{
		ResultSet tabla=null;
		try
		{
			Statement stmt=dbConecta.createStatement();
			tabla=stmt.executeQuery(CadenaSql);			
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		} 
		return tabla;
	}

	/**
	 * cerrar la base de datos despues de las consultas
	 */
	public void CerrarBase()
	{
		try
		{
			dbConecta.close();
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		} 
	}
}