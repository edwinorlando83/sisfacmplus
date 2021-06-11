
package ec.com.mfac.modeloSybase;

import java.util.ArrayList;
import java.util.List;

import ec.com.mfac.db.DataBaseObject;

public class Tbl_totalimpuestoFactory {
	private static Tbl_totalimpuestoFactory instance = null;
	DataBaseObject objDataBase;
	public static Tbl_totalimpuestoFactory getInstance(DataBaseObject objDataBase) {
		if (instance == null) {
			instance = new Tbl_totalimpuestoFactory(objDataBase);
		}
		return instance;
	}

	public Tbl_totalimpuestoFactory(DataBaseObject objDataBase) {
        this.objDataBase = objDataBase;
	}
    
     
    
    /** Funci?n que retorna todos los datos de la tabla Tbl_totalimpuesto en formato de lista.
	 * @return List<Tbl_totalimpuesto> 
	 * @throws Exception
	 */
	public List<Tbl_totalimpuesto>  getTbl_totalimpuestoAll_List() throws Exception {		 
		List<Tbl_totalimpuesto> sublist = objDataBase .SQL_Select(
						Tbl_totalimpuesto.class,
						"SELECT * FROM Tbl_totalimpuesto; ");
	 	return sublist;
	}
    
    /** Funci?n  que permite ingresar datos en la tabla Tbl_totalimpuesto
	 * @param entidad [Tbl_totalimpuesto]
	 * @return Los datos se ingresaron correctamente o  No se pudo realizar la operacion solicitada
	 * @throws Exception
	 */
    public String Insert(Tbl_totalimpuesto entidad) throws Exception
	{	
    	
    	String sqld ="delete from  Tbl_totalimpuesto where claveacceso='"+entidad.getClaveacceso()+"'"; 
    	objDataBase.SQL_COMMAND(sqld);
    	
	  String sql="INSERT INTO  Tbl_totalimpuesto( codigo,codigoporcentaje,baseimponible,valor,claveacceso)    VALUES (?,?,?,?,?)";
	  ArrayList<Object> inParametros= new ArrayList<Object>();
      inParametros.add(entidad.getCodigo()); 
      inParametros.add(entidad.getCodigoporcentaje()); 
      inParametros.add(entidad.getBaseimponible()); 
      inParametros.add(entidad.getValor()); 
      inParametros.add(entidad.getClaveacceso()); 
	   int filasafectadas=  objDataBase.SQL_COMMAND(sql, inParametros);
	   return objDataBase.mensajeInsert(filasafectadas); 
	}

    /** Funci?n  que permite eliminar datos en la tabla Tbl_totalimpuesto, en base a su(s) clave(s) primaria(s)
	 * @param entidad [Tbl_totalimpuesto]
	 * @return Los datos se borraron correctamente o  No se pudo realizar la operacion solicitada
	 * @throws Exception
	 */
    public String Delete(Tbl_totalimpuesto entidad) throws Exception
	{	
	  String sql="DELETE FROM Tbl_totalimpuesto  WHERE codigo=? and claveacceso=?  ";
	  ArrayList<Object> inParametros= new ArrayList<>();
      inParametros.add(entidad.getCodigo()); 
      inParametros.add(entidad.getClaveacceso()); 
	  int filasafectadas=  objDataBase.SQL_COMMAND(sql, inParametros);
	  return objDataBase.mensajeDelete(filasafectadas); 
	}
    
        /** Funci?n  que permite actulizar datos en la tabla Tbl_totalimpuesto,no actuliza claves primarias
	 * @param entidad [Tbl_totalimpuesto]
	 * @return Los datos se actulizaron correctamente o  No se pudo realizar la operacion solicitada
	 * @throws Exception
	 */
    public String Update(Tbl_totalimpuesto entidad) throws Exception
	{	
	  String sql="UPDATE Tbl_totalimpuesto  "
	  		+ " SET codigoporcentaje=?,baseimponible=?,valor=?  "
	  		+ " WHERE codigo=? and claveacceso=?    ";
	  ArrayList<Object> inParametros= new ArrayList<>();
      inParametros.add(entidad.getCodigoporcentaje()); 
      inParametros.add(entidad.getBaseimponible()); 
      inParametros.add(entidad.getValor()); 
      inParametros.add(entidad.getCodigo()); 
      inParametros.add(entidad.getClaveacceso()); 
	  int filasafectadas=  objDataBase.SQL_COMMAND(sql, inParametros);
	  return objDataBase.mensajeUpdate(filasafectadas); 
	}
}
 