
package ec.com.mfac.modeloSybase;

import java.util.ArrayList;
import java.util.List;

import ec.com.mfac.db.DataBaseObject;

public class Tbl_infoadicionalFactory {
	private static Tbl_infoadicionalFactory instance = null;
	DataBaseObject objDataBase;
	public static Tbl_infoadicionalFactory getInstance(DataBaseObject objDataBase) {
		if (instance == null) {
			instance = new Tbl_infoadicionalFactory(objDataBase);
		}
		return instance;
	}

	public Tbl_infoadicionalFactory(DataBaseObject objDataBase) {
        this.objDataBase = objDataBase;
	}
    
   
    /** Funci?n que retorna todos los datos de la tabla Tbl_infoadicional en formato de lista.
	 * @return List<Tbl_infoadicional> 
	 * @throws Exception
	 */
	public List<Tbl_infoadicional>  getTbl_infoadicionalAll_List() throws Exception {		 
		List<Tbl_infoadicional> sublist = objDataBase .SQL_Select(
						Tbl_infoadicional.class,
						"SELECT * FROM Tbl_infoadicional; ");
	 	return sublist;
	}
    
    /** Funci?n  que permite ingresar datos en la tabla Tbl_infoadicional
	 * @param entidad [Tbl_infoadicional]
	 * @return Los datos se ingresaron correctamente o  No se pudo realizar la operacion solicitada
	 * @throws Exception
	 */
    public String Insert(Tbl_infoadicional entidad) throws Exception
	{	
	  String sql="INSERT INTO  Tbl_infoadicional( pk_infodicional,campo,valor,claveacceso)    VALUES (?,?,?,?)";
	  ArrayList<Object> inParametros= new ArrayList<Object>();
      inParametros.add(entidad.getPk_infodicional()); 
      inParametros.add(entidad.getCampo()); 
      inParametros.add(entidad.getValor()); 
      inParametros.add(entidad.getClaveacceso()); 
	   int filasafectadas=  objDataBase.SQL_COMMAND(sql, inParametros);
	   return objDataBase.mensajeInsert(filasafectadas); 
	}

    /** Funci?n  que permite eliminar datos en la tabla Tbl_infoadicional, en base a su(s) clave(s) primaria(s)
	 * @param entidad [Tbl_infoadicional]
	 * @return Los datos se borraron correctamente o  No se pudo realizar la operacion solicitada
	 * @throws Exception
	 */
    public String Delete(Tbl_infoadicional entidad) throws Exception
	{	
	  String sql="DELETE FROM Tbl_infoadicional  WHERE pk_infodicional=?  ";
	  ArrayList<Object> inParametros= new ArrayList<>();
      inParametros.add(entidad.getPk_infodicional()); 
	  int filasafectadas=  objDataBase.SQL_COMMAND(sql, inParametros);
	  return objDataBase.mensajeDelete(filasafectadas); 
	}
    
        /** Funci?n  que permite actulizar datos en la tabla Tbl_infoadicional,no actuliza claves primarias
	 * @param entidad [Tbl_infoadicional]
	 * @return Los datos se actulizaron correctamente o  No se pudo realizar la operacion solicitada
	 * @throws Exception
	 */
    public String Update(Tbl_infoadicional entidad) throws Exception
	{	
	  String sql="UPDATE Tbl_infoadicional  "
	  		+ " SET campo=?,valor=?,claveacceso=?  "
	  		+ " WHERE pk_infodicional=?    ";
	  ArrayList<Object> inParametros= new ArrayList<>();
      inParametros.add(entidad.getCampo()); 
      inParametros.add(entidad.getValor()); 
      inParametros.add(entidad.getClaveacceso()); 
      inParametros.add(entidad.getPk_infodicional()); 
	  int filasafectadas=  objDataBase.SQL_COMMAND(sql, inParametros);
	  return objDataBase.mensajeUpdate(filasafectadas); 
	}
}
 