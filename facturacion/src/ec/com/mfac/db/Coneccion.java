/*
* Coneccion.java 18/mayo/2015
*  
*/
package ec.com.mfac.db;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

/**
 * Coneccion: Clase que contiene los m�todos necesarios que permiten establecer
 * conexi�n con la base de datos. @create. 07/02/2014
 * 
 * @author ocholota
 * @version 1.0
 */
public final class Coneccion {

	/**
	 * Ip del servidor de base de datos.
	 */
	public static String ip;
	/**
	 * Nombre de la base de datos.
	 */
	public static String  bd;
	/**
	 * Nombre del Usuario.
	 */
	public static String  usr;
	/**
	 * Contrase�a del Usuario.
	 */
	public static String pass;
	/**
	 * Puerto del servidor de base de dato.
	 */
	public static String puerto;
 
 

 

	/**
	 * Construye un objeto de la clase Coneccion.
	 * 
	 * @param inServidor
	 *            (String) Direccion IP o nombre del servidor.
	 * @param inDataBase
	 *            (String) Nombre de la base de datos.
	 * @param inUsuario
	 *            (String) Nombre del usuario.
	 * @param inPassword
	 *            (String) Contrase�a del usuario.
	 * @param inPuerto
	 *            (String) Puerto del servidor de base de datos.
	 * @throws Exception
	 */

	public Coneccion( )
			throws Exception {
  
	}

	/**
	 * Retorna una conexi�n a la base de datos.
	 * 
	 * @return conexion
	 * @throws Exception
	 */
	public Connection getConexion() throws Exception {

		Connection conexion=null;
		try {
			                                        
   DriverManager.registerDriver(  (Driver) Class.forName("com.sybase.jdbc2.jdbc.SybDriver").newInstance());
  String url=  "jdbc:sybase:Tds:"+Coneccion.ip+":"+Coneccion.puerto+"/"+Coneccion.bd+"";
  // DriverManager.registerDriver(  (Driver) Class.forName("com.sybase.jdbc2.jdbc.SybDriver").newInstance());
 //  String url=  "jdbc:sqlanywhere:Tds:"+Coneccion.ip+":"+Coneccion.puerto+"?eng="+Coneccion.bd+"";	 
 
     
   
   conexion = DriverManager.getConnection(url, Coneccion.usr, Coneccion.pass);
			    
                
			    
		} catch (Exception er) {
			String mgs = er.getMessage();
			System.out.println(mgs);
			throw new Exception(mgs);
		}

		return conexion;
	}

 
 
	 
}