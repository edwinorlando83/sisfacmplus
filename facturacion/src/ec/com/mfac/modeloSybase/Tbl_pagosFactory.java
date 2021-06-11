
package ec.com.mfac.modeloSybase;

import java.util.ArrayList;
import java.util.List;

import ec.com.mfac.db.DataBaseObject;

public class Tbl_pagosFactory {
	private static Tbl_pagosFactory instance = null;
	DataBaseObject objDataBase;
	public static Tbl_pagosFactory getInstance(DataBaseObject objDataBase) {
		if (instance == null) {
			instance = new Tbl_pagosFactory(objDataBase);
		}
		return instance;
	}

	public Tbl_pagosFactory(DataBaseObject objDataBase) {
        this.objDataBase = objDataBase;
	}
    
 
    /** Funci?n que retorna todos los datos de la tabla Tbl_pagos en formato de lista.
	 * @return List<Tbl_pagos> 
	 * @throws Exception
	 */
	public List<Tbl_pagos>  getTbl_pagosAll_List() throws Exception {		 
		List<Tbl_pagos> sublist = objDataBase .SQL_Select(
						Tbl_pagos.class,
						"SELECT * FROM Tbl_pagos; ");
	 	return sublist;
	}
    
    /** Funci?n  que permite ingresar datos en la tabla Tbl_pagos
	 * @param entidad [Tbl_pagos]
	 * @return Los datos se ingresaron correctamente o  No se pudo realizar la operacion solicitada
	 * @throws Exception
	 */
    public String Insert(Tbl_pagos entidad) throws Exception
	{	
    	
    	String sqld ="delete from  Tbl_pagos where claveacceso='"+entidad.getClaveacceso()+"'"; 
    	objDataBase.SQL_COMMAND(sqld);
		
	  String sql="INSERT INTO  Tbl_pagos( formapago,total,claveacceso)    VALUES (?,?,?)";
	  ArrayList<Object> inParametros= new ArrayList<Object>();
	  
 

	  
      inParametros.add(entidad.getFormapago()); 
      inParametros.add(entidad.getTotal()); 
      inParametros.add(entidad.getClaveacceso()); 
	   int filasafectadas=  objDataBase.SQL_COMMAND(sql, inParametros);
	   return objDataBase.mensajeInsert(filasafectadas); 
	}

    /** Funci?n  que permite eliminar datos en la tabla Tbl_pagos, en base a su(s) clave(s) primaria(s)
	 * @param entidad [Tbl_pagos]
	 * @return Los datos se borraron correctamente o  No se pudo realizar la operacion solicitada
	 * @throws Exception
	 */
    public String Delete(Tbl_pagos entidad) throws Exception
	{	
	  String sql="DELETE FROM Tbl_pagos  WHERE formapago=? and claveacceso=?  ";
	  ArrayList<Object> inParametros= new ArrayList<>();
      inParametros.add(entidad.getFormapago()); 
      inParametros.add(entidad.getClaveacceso()); 
	  int filasafectadas=  objDataBase.SQL_COMMAND(sql, inParametros);
	  return objDataBase.mensajeDelete(filasafectadas); 
	}
    
        /** Funci?n  que permite actulizar datos en la tabla Tbl_pagos,no actuliza claves primarias
	 * @param entidad [Tbl_pagos]
	 * @return Los datos se actulizaron correctamente o  No se pudo realizar la operacion solicitada
	 * @throws Exception
	 */
    public String Update(Tbl_pagos entidad) throws Exception
	{	
	  String sql="UPDATE Tbl_pagos  "
	  		+ " SET total=?  "
	  		+ " WHERE formapago=? and claveacceso=?    ";
	  ArrayList<Object> inParametros= new ArrayList<>();
      inParametros.add(entidad.getTotal()); 
      inParametros.add(entidad.getFormapago()); 
      inParametros.add(entidad.getClaveacceso()); 
	  int filasafectadas=  objDataBase.SQL_COMMAND(sql, inParametros);
	  return objDataBase.mensajeUpdate(filasafectadas); 
	}
}
 