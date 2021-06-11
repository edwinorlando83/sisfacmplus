package ec.com.mfac.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLTimeoutException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * DataBaseObject: Clase que contiene los metodos necesarios que permiten
 * interactuar con la base de datos. @create. 18/05/2015
 * 
 * @author orlando cholota
 * @version 1.0
 */

public class DataBaseObject {

	
	public static class Util {
		private static DataBaseObject instance;
		public static DataBaseObject getInstance(String inServidor, String inDataBase, String inUsuario, String inPassword, String inPuerto) throws Exception{
			if (instance == null) {
				instance = new DataBaseObject( );
			}
			return instance;
		}
	}
	
	/**
	 * Conexion la base de datos.
	 */
	public static Coneccion con;

	/**
	 * Indica si se ejecuta commit automaticamente.
	 */

	/**
	 * Construye un objeto de la clase DataBaseObject.
	 * 
	 * @param inServidor
	 *            (String) Direccion IP del servidor.
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
	public DataBaseObject( )
			throws Exception {
		 
		con  = new Coneccion( );
 
	}

	/**
	 * Funcion que devuelve ArrayList<T> de una sentencia SQL
	 * 
	 * @param theClass
	 *            obj.Class
	 * @param inSql
	 *            sentencia select sql
	 * @return ArrayList<T>
	 * @throws Exception
	 */
	public <T> ArrayList<T> SQL_Select(Class<T> theClass, String inSql) throws Exception {
		return SQL_Select(theClass, inSql, null);
	}

	/**
	 * Funcion que devuelve ArrayList<T> de una sentencia SQL
	 * 
	 * @param theClass
	 *            obj.Class
	 * @param inSql
	 *            sentencia select sql
	 * @param inParametros
	 *            ArrayList<Object>
	 * @return ArrayList<T>
	 * @throws Exception
	 */
	public <T> ArrayList<T> SQL_Select(Class<T> theClass, String inSql, ArrayList<Object> inParametros)
			throws Exception {
		ResultSet inRs = null;
		java.sql.Connection conexion = null;
		PreparedStatement stmSelect = null;
		ArrayList<T> lista = new ArrayList<T>();
		try {
			conexion = con.getConexion();
			stmSelect = conexion.prepareStatement(inSql);
			if (inParametros != null) {
				for (int i = 0; i < inParametros.size(); i++) {
					Object parametro = inParametros.get(i);
					stmSelect.setObject(i + 1, parametro);
				}
			}
			inRs = stmSelect.executeQuery();

			ResultSetMetaData rsmd = inRs.getMetaData();
			int numCols = rsmd.getColumnCount();

			while (inRs.next()) {
				T o = theClass.newInstance();
				for (int i = 0; i < numCols; i++) {
					String colname = rsmd.getColumnLabel(i + 1);
					Object fieldValue = inRs.getObject(colname);

					set(o, colname, fieldValue);
				}
				lista.add(o);
			}

		} catch (SQLTimeoutException ert) {

			System.out.println("SQLTimeoutException" + new Date());
			closeConnections(inRs, stmSelect, conexion);
			throw new Exception(ert.getMessage(), ert);
		} catch (Exception e) {
			System.err.println(e.getMessage());

			closeConnections(inRs, stmSelect, conexion);

			throw new Exception(e.getMessage(), e);
		} finally {
			closeConnections(inRs, stmSelect, conexion);

		}

		return lista;
	}

	public boolean set(Object object, String fieldName, Object fieldValue) {
		Class<?> clazz = object.getClass();
		try {
			Field field = clazz.getDeclaredField(fieldName);
			field.setAccessible(true);
			field.set(object, fieldValue);
			return true;
		} catch (NoSuchFieldException e) {

		} catch (Exception e) {

		}
		return false;
	}

	/**
	 * Funcion que devuelve un ArrayList<List<Object>> desde una sentencia sql
	 * 
	 * @param inSql
	 *            sentecia selec
	 * @param inParametros
	 *            parametros ArrayList<Object>
	 * @return
	 * @throws Exception
	 */
	public ArrayList<List<Object>> SQL_SELECT_list(String inSql, ArrayList<Object> inParametros) throws Exception {
		ResultSet rs = null;
		ArrayList<List<Object>> valor = new ArrayList<List<Object>>();
		java.sql.Connection conexion = null;
		PreparedStatement stmSelect = null;
		try {
			conexion = con.getConexion();
			stmSelect = conexion.prepareStatement(inSql);
			if (inParametros != null) {
				for (int i = 0; i < inParametros.size(); i++) {
					if (inParametros.get(i) != null
							&& inParametros.get(i).getClass().toString().toLowerCase().contains("date")) {
						java.util.Date dt = (java.util.Date) inParametros.get(i);
						stmSelect.setObject(i + 1, new java.sql.Timestamp(dt.getTime()));
					} else if (inParametros.get(i) != null && inParametros.get(i) instanceof Integer)
						stmSelect.setObject(i + 1, inParametros.get(i), Types.INTEGER);
					else if (inParametros.get(i) != null && inParametros.get(i) instanceof Double)
						stmSelect.setObject(i + 1, inParametros.get(i), Types.DOUBLE);
					else if (inParametros.get(i) != null && inParametros.get(i) instanceof String[][]) {
						Array inArray = conexion.createArrayOf("varchar", (String[][]) inParametros.get(i));
						stmSelect.setArray(i + 1, inArray);
					} else
						stmSelect.setObject(i + 1, inParametros.get(i));
				}
			}

			rs = stmSelect.executeQuery();

			valor = ResultSetToArray(rs);
			rs.close();
			conexion.close();

		} catch (SQLTimeoutException ert) {

			throw new Exception(ert.getMessage(), ert);

		} catch (Exception e) {

			throw new Exception(e.getMessage(), e);

		} finally {
			if (conexion != null)
				conexion.close();

		}

		return valor;
	}

	public ArrayList<List<Object>> SQL_SELECT_list(String sql) throws Exception {
		ResultSet rs = null;
		ArrayList<List<Object>> valor = new ArrayList<List<Object>>();
		java.sql.Connection conexion = null;
		try {

			conexion = con.getConexion();
			rs = conexion.createStatement().executeQuery(sql);
			valor = ResultSetToArray(rs);
			rs.close();

		} catch (SQLTimeoutException ert) {
			closeConnections(rs, null, conexion);
			throw new Exception(ert.getMessage(), ert);

		} catch (Exception e) {
			closeConnections(rs, null, conexion);
			throw new Exception(e.getMessage(), e);

		} finally {
			closeConnections(rs, null, conexion);

		}
 
		return valor;

	}

	private ArrayList<List<Object>> ResultSetToArray(ResultSet rs) {

		ArrayList<List<Object>> lo = new ArrayList<List<Object>>();
		try {

			ResultSetMetaData rsmd = rs.getMetaData();
			int numCols = rsmd.getColumnCount();

			while (rs.next()) {

				List<Object> aux = new ArrayList<Object>();
				for (int i = 0; i < numCols; i++) {

					Object dato = rs.getObject(i + 1);
					aux.add(dato);
				}

				lo.add(aux);
			}
		} catch (Exception e) {

		}

		return lo;
	}

	/**
	 * Funcion que permite la ejecucion de una sentencia DML.
	 * 
	 * @param inSql
	 *            (String) Sentencia DML.
	 * @return int - N�mero de registros afectados por la sentencia DML
	 *         [0:Vacio] [-1:Error].
	 * @throws Exception
	 */
	public int SQL_COMMAND(String inSql) throws Exception {
		int retorno = -1;
		java.sql.Connection conexion = null;
		try {
			conexion = con.getConexion();
			retorno = conexion.createStatement().executeUpdate(inSql);
		} catch (SQLTimeoutException ert) {

			closeConnections(null, null, conexion);

			throw new Exception(ert.getMessage(), ert);
		} catch (Exception e) {

			closeConnections(null, null, conexion);
			throw new Exception(e.getMessage(), e);
		} finally {
			closeConnections(null, null, conexion);
		}
		return retorno;
	}

	/**
	 * Funcion que permite la ejecucion de una sentencia DML, utilizando
	 * par�metros.
	 * 
	 * @param inSql
	 *            (String) Sentencia DML.
	 * @param inParametros
	 *            (ArrayList&#60;Object&#62;) Listado de par�metros.
	 * @return int - N�mero de registros afectados por la sentencia DML
	 *         [0:Vacio] [-1:Error].
	 * @throws Exception
	 */
	public int SQL_COMMAND(String inSql, ArrayList<Object> inParametros) throws Exception {
		int retorno = -1;
		java.sql.Connection conexion = null;
		PreparedStatement var = null;
		try {
			conexion = con.getConexion();
			var = conexion.prepareStatement(inSql);
			for (int i = 1; i <= inParametros.size(); i++) {
				
			Object param=	inParametros.get(i - 1);
				if (param!= null
						&& param.getClass().toString().toLowerCase().contains("date")) {
					java.util.Date dt = (java.util.Date) inParametros.get(i - 1);
					var.setObject(i, new java.sql.Timestamp(dt.getTime()));
				} else if (param != null && inParametros.get(i - 1) instanceof Integer)
					var.setObject(i, param, Types.INTEGER);
				else if (param != null && inParametros.get(i - 1) instanceof Double)
					var.setObject(i,param, Types.DOUBLE);
				else if (param != null && inParametros.get(i - 1) instanceof Boolean)
					var.setObject(i,param, Types.BOOLEAN);

				else if (param!= null && param instanceof String[][]) {
					Array inArray = conexion.createArrayOf("varchar", (String[][]) inParametros.get(i - 1));
					var.setArray(i, inArray);
				} else if (param != null && param instanceof InputStream) {
					InputStream ip = (InputStream) inParametros.get(i - 1);
					var.setBinaryStream(i, ip, ip.available());
				}
				else if (param != null && param instanceof String) {
					 
					var.setString(i, param.toString());
				}
				else
				{
		 
				 
			 
					var.setObject(i, param);
				}
				
				 
			}
			retorno = var.executeUpdate();
		} catch (SQLTimeoutException ert) {

			closeConnections(null, var, conexion);
			throw new Exception(ert.getMessage(), ert);
		} catch (Exception e) {

			closeConnections(null, var, conexion);
			throw new Exception(e.getMessage(), e);
		} finally {
			closeConnections(null, var, conexion);
		}
		return retorno;
	}

	/**
	 * Funcion que permite la ejecucion de un conjunto de sentencias DML en una
	 * sola transaccion, utilizando par�metros.
	 * 
	 * @param inLstParametros
	 *            (ArrayList&#60;ArrayList&#60;Object&#62;&#62;) Listado de
	 *            par�metros.
	 * @param inLstSql
	 *            (String...) Listado de sentencias DML.
	 * @return int - N�mero de registros afectados por la sentencia DML
	 *         [0:Vacio] [-1:Error].
	 * @throws Exception
	 */
	public int SQL_COMMAND_TRANSAC(ArrayList<ArrayList<Object>> inLstParametros, String... inLstSql) throws Exception {
		int retorno = -1;
		java.sql.Connection conexion = null;
		PreparedStatement var = null;
		try {
			conexion = con.getConexion();
			conexion.setAutoCommit(false);
			int j = 0;
			for (String SQL : inLstSql) {
				var = conexion.prepareStatement(SQL);
				ArrayList<Object> parametros = new ArrayList<Object>();
				if (j < inLstParametros.size())
					parametros = inLstParametros.get(j);
				for (int i = 1; i <= parametros.size(); i++) {
					if (parametros.get(i - 1) != null
							&& parametros.get(i - 1).getClass().toString().toLowerCase().contains("date")) {
						java.util.Date dt = (java.util.Date) parametros.get(i - 1);
						var.setObject(i, new java.sql.Timestamp(dt.getTime()));
					} else if (parametros.get(i - 1) != null && parametros.get(i - 1) instanceof Integer)
						var.setObject(i, parametros.get(i - 1), Types.INTEGER);
					else if (parametros.get(i - 1) != null && parametros.get(i - 1) instanceof Double)
						var.setObject(i, parametros.get(i - 1), Types.DOUBLE);
					else if (parametros.get(i - 1) != null && parametros.get(i - 1) instanceof String[][]) {
						Array inArray = conexion.createArrayOf("varchar", (String[][]) parametros.get(i - 1));
						var.setArray(i, inArray);
					} else
						var.setObject(i, parametros.get(i - 1));
				}
				retorno += var.executeUpdate();
				j++;
			}

		} catch (SQLTimeoutException ert) {

			closeConnections(null, var, conexion);
			throw new Exception(ert.getMessage(), ert);
		} catch (Exception e) {

			closeConnections(null, var, conexion);
			throw new Exception(e.getMessage(), e);
		} finally {
			closeConnections(null, var, conexion);
		}
		return retorno;
	}

	/**
	 * Funcion que permite la ejecucion de un conjunto de sentencias DML en una
	 * sola transaccion, utilizando par�metros.
	 * 
	 * @param inLstParametros
	 *            (ArrayList&#60;ArrayList&#60;Object&#62;&#62;) Listado de
	 *            par�metros.
	 * @param inLstSql
	 *            (String...) Listado de sentencias DML.
	 * @return int - N�mero de registros afectados por la sentencia DML
	 *         [0:Vacio] [-1:Error].
	 * @throws Exception
	 */
	public int SQL_COMMAND_TRANSAC(String inLstSql) throws Exception {
		int retorno = -1;
		java.sql.Connection conexion = null;
		PreparedStatement var = null;
		try {
			conexion = con.getConexion();
			conexion.setAutoCommit(false);
			var = conexion.prepareStatement(inLstSql);
			retorno = var.executeUpdate();
			conexion.commit();
			conexion.close();
		} catch (SQLTimeoutException ert) {

			closeConnections(null, var, conexion);

			throw new Exception(ert.getMessage(), ert);
		} catch (Exception e) {

			closeConnections(null, var, conexion);
			throw new Exception(e.getMessage(), e);
		} finally {
			closeConnections(null, var, conexion);
		}
		return retorno;
	}

	/**
	 * Funcion que permite la ejecucion de una sentencia DML, utilizando
	 * par�metros.
	 * 
	 * @param inSql
	 *            (String) Sentencia DML .
	 * @param inParametros
	 *            (ArrayList&#60;Object&#62;) Listado de par�metros.
	 * @return Un valor int que indica el número de filas afectadas o 0 si se
	 *         usa una instrucción DDL.
	 * @throws Exception
	 */
	public int SQL_COMMAND_DML(String inSql, ArrayList<Object> inParametros) throws Exception {
		Integer retorno;
		java.sql.Connection conexion = null;
		PreparedStatement var = null;
		try {
			conexion = con.getConexion();
			var = conexion.prepareStatement(inSql);
			for (int i = 1; i <= inParametros.size(); i++) {
				if (inParametros.get(i - 1) != null
						&& inParametros.get(i - 1).getClass().toString().toLowerCase().contains("date")) {
					java.util.Date dt = (java.util.Date) inParametros.get(i - 1);
					var.setObject(i, new java.sql.Timestamp(dt.getTime()));
				} else if (inParametros.get(i - 1) != null && inParametros.get(i - 1) instanceof Integer)
					var.setObject(i, inParametros.get(i - 1), Types.INTEGER);
				else if (inParametros.get(i - 1) != null && inParametros.get(i - 1) instanceof Double)
					var.setObject(i, inParametros.get(i - 1), Types.DOUBLE);
				else if (inParametros.get(i - 1) != null && inParametros.get(i - 1) instanceof String[][]) {
					Array inArray = conexion.createArrayOf("varchar", (String[][]) inParametros.get(i - 1));
					var.setArray(i, inArray);
				} else
					var.setObject(i, inParametros.get(i - 1));
			}
			retorno = var.executeUpdate();

		} catch (SQLTimeoutException ert) {
			retorno = 0;

			closeConnections(null, var, conexion);

			throw new Exception("Error: " + ert.getMessage(), ert);
		} catch (Exception e) {
			retorno = 0;

			closeConnections(null, var, conexion);

			throw new Exception("Error: " + e.getMessage(), e);
		} finally {
			closeConnections(null, var, conexion);
		}
		return retorno;
	}

	/**
	 * Funcion que permite la ejecucion de una sentencia DML, utilizando
	 * par�metros.
	 * 
	 * @param inSql
	 *            (String) Sentencias DML.
	 * @param inParametros
	 *            (ArrayList&#60;Object&#62;) Listado de par�metros.
	 * @return Object - Valor devuelto como resultado de la consulta [0:Error].
	 * @throws Exception
	 */
	public Object SQL_ESCALAR(String inSql, ArrayList<Object> inParametros) throws Exception {
		Object retorno = null;
		java.sql.Connection conexion = null;
		PreparedStatement var = null;
		ResultSet rs = null;
		try {
			conexion = con.getConexion();
			var = conexion.prepareStatement(inSql);
			for (int i = 1; i <= inParametros.size(); i++) {
				if (inParametros.get(i - 1) != null
						&& inParametros.get(i - 1).getClass().toString().toLowerCase().contains("date")) {
					java.util.Date dt = (java.util.Date) inParametros.get(i - 1);
					var.setObject(i, new java.sql.Timestamp(dt.getTime()));
				} else if (inParametros.get(i - 1) != null && inParametros.get(i - 1) instanceof Integer)
					var.setObject(i, inParametros.get(i - 1), Types.INTEGER);
				else if (inParametros.get(i - 1) != null && inParametros.get(i - 1) instanceof Double)
					var.setObject(i, inParametros.get(i - 1), Types.DOUBLE);
				else if (inParametros.get(i - 1) != null && inParametros.get(i - 1) instanceof String[][]) {
					Array inArray = conexion.createArrayOf("varchar", (String[][]) inParametros.get(i - 1));
					var.setArray(i, inArray);
				} else if (inParametros.get(i - 1) != null && inParametros.get(i - 1) instanceof byte[]) {
					var.setBytes(i, (byte[]) inParametros.get(i - 1));
				} else if (inParametros.get(i - 1) == null) {
					var.setNull(i, Types.NULL);
				} else
					var.setObject(i, inParametros.get(i - 1));
			}
			rs = var.executeQuery();
			while (rs.next()) {
				retorno = rs.getObject(1);
			}
		} catch (SQLTimeoutException ert) {

			closeConnections(rs, var, conexion);

			throw new Exception(ert.getMessage());
		} catch (Exception e) {

			closeConnections(rs, var, conexion);

			throw new Exception(e.getMessage());
		} finally {
			closeConnections(rs, var, conexion);
		}
		return retorno;
	}
	
	 
	/**
	 * Funcion que permite la ejecucion de una sentencia DML.
	 * 
	 * @param inSql
	 *            (String) Sentencias DML.
	 * @return Object - Valor devuelto como resultado de la consulta [0:Error].
	 * @throws Exception
	 */
	public Object SQL_ESCALAR(String inSql) throws Exception {
		return SQL_ESCALAR(inSql, new ArrayList<Object>());
	}

	/**
	 * Funcion que permite la ejecucion de una sentencia DML que almacena
	 * archivos en la base de datos.
	 * 
	 * @param inSql
	 *            (String) Sentencia DML.
	 * @param inParametros
	 *            (ArrayList&#60;Object&#62;) Listado de par�metros [IMAGE_HERE:
	 *            Si es una imagen].
	 * @param inImage
	 *            (byte[]) Archivo.
	 * @return Object - Valor devuelto como resultado de la consulta [0:Error].
	 * @throws Exception
	 */
	public Object SQL_ESCALAR_IMAGE(String inSql, ArrayList<Object> inParametros, byte[] inImage) throws Exception {
		Object retorno = 0;
		java.sql.Connection conexion = null;
		PreparedStatement var = null;
		ResultSet rs = null;
		try {
			conexion = con.getConexion();
			var = conexion.prepareCall(inSql);
			for (int i = 1; i <= inParametros.size(); i++) {
				if (inParametros.get(i - 1) != null && inParametros.get(i - 1).getClass().toString().contains("String")
						&& inParametros.get(i - 1).toString().contains("IMAGE_HERE"))
					var.setBytes(i, inImage);
				else if (inParametros.get(i - 1) != null
						&& inParametros.get(i - 1).getClass().toString().toLowerCase().contains("date")) {
					java.util.Date dt = (java.util.Date) inParametros.get(i - 1);
					var.setObject(i, new java.sql.Timestamp(dt.getTime()));
				} else if (inParametros.get(i - 1) != null && inParametros.get(i - 1) instanceof Integer)
					var.setObject(i, inParametros.get(i - 1), Types.INTEGER);
				else if (inParametros.get(i - 1) != null && inParametros.get(i - 1) instanceof Double)
					var.setObject(i, inParametros.get(i - 1), Types.DOUBLE);
				else if (inParametros.get(i - 1) != null && inParametros.get(i - 1) instanceof String[][]) {
					Array inArray = conexion.createArrayOf("varchar", (String[][]) inParametros.get(i - 1));
					var.setArray(i, inArray);
				} else
					var.setObject(i, inParametros.get(i - 1));
			}
			rs = var.executeQuery();
			while (rs.next()) {
				retorno = rs.getObject(1);
			}
		} catch (SQLTimeoutException ert) {

			closeConnections(rs, var, conexion);

			throw new Exception(ert.getMessage());
		} catch (Exception e) {

			closeConnections(rs, var, conexion);

			throw new Exception(e.getMessage());
		} finally {
			closeConnections(rs, var, conexion);
		}
		return retorno;
	}

	/**
	 * Funcion que permite cerrar conexiones a la de base de datos, que fueron
	 * creadas por ejecucion de sentencias DML.
	 * 
	 * @param inRs
	 *            (ResultSet) Conjunto de datos, proveniente de la ejecucion de
	 *            una consulta a la base de datos.
	 * @param inPsmSelect
	 *            (PreparedStatement) Ejecucion de sentencias DML.
	 * @param inConexion
	 *            (Connection) Conexion a la base de datos.
	 * @param inIsError
	 *            (boolean) Indica si se produjo error durante la ejecucion
	 *            [true:si][false:no].
	 */
	public void closeConnections(ResultSet inRs, PreparedStatement inPsmSelect, java.sql.Connection inConexion) {
		try {
			if (inRs != null    ) {
				inRs.close();
				inRs = null;
			}
			if (inPsmSelect != null   ) {
				inPsmSelect.close();
				inPsmSelect = null;
			}
			if (inConexion != null && !inConexion.isClosed()) {

				inConexion.close();
				inConexion = null;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String mensajeInsert(int filasafectadas) {
		return filasafectadas > 0 ? "Los datos se ingresaron correctamente" : mensajeError();
	}

	public String mensajeDelete(int filasafectadas) {
		return filasafectadas > 0 ? "Los datos se borraron correctamente" : mensajeError();
	}

	public String mensajeUpdate(int filasafectadas) {

		return filasafectadas > 0 ? "Los datos se actulizaron correctamente" : mensajeError();
	}

	public String mensajeError() {
		return "No se pudo realizar la operaci\u00F3n solicitada";
	}
	
	public int SQL_ESCALAR_UPDATE_FILE(String inSql, ArrayList<Object> inParametros, File file,boolean borrarArchivo) throws Exception {

		java.sql.Connection conexion = null;
		PreparedStatement var = null;
		FileInputStream in = null ;
		int filas_afectadas = 0;
		try {
			conexion = con.getConexion();
			var = conexion.prepareStatement(inSql);
			if (inParametros == null) {
				  in = new FileInputStream(file);
				var.setBinaryStream(1, in, (int) file.length());
			} else {
				  in = new FileInputStream(file);
				var.setBinaryStream(1, in, (int) file.length());

				for (int i = 2; i < inParametros.size()+2; i++) {
					if (inParametros.get(i - 2) != null && inParametros.get(i - 2).getClass().toString().toLowerCase().contains("date")) {
						java.util.Date dt = (java.util.Date) inParametros.get(i - 2);
						var.setObject(i, new java.sql.Timestamp(dt.getTime()));
					} else if (inParametros.get(i - 2) != null && inParametros.get(i - 2) instanceof Integer)
						var.setObject(i, inParametros.get(i - 2), Types.INTEGER);
					else if (inParametros.get(i - 2) != null && inParametros.get(i - 2) instanceof Double)
						var.setObject(i, inParametros.get(i - 2), Types.DOUBLE);
					else if (inParametros.get(i - 2) != null && inParametros.get(i -2) instanceof String[][]) {
						Array inArray = conexion.createArrayOf("varchar", (String[][]) inParametros.get(i - 2));
						var.setArray(i, inArray);
					} else
						var.setObject(i, inParametros.get(i - 2));
				 
				}
			}
			filas_afectadas = var.executeUpdate();
			if(filas_afectadas>0)
			{
				if (file != null&&borrarArchivo) {
				file.delete();
				}
				file = null;
			}
		} catch (SQLTimeoutException ert) {
			closeConnections(null, var, conexion);
			throw new Exception(ert.getMessage());
		} catch (Exception e) {
			closeConnections(null, var, conexion);
			throw new Exception(e.getMessage());
		} finally {
			if(in!=null)
			in.close();
			in=null;
			closeConnections(null, var, conexion);
		}
		return filas_afectadas;
	}

}