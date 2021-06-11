
package ec.com.mfac.modeloSybase;

import java.util.ArrayList;
import java.util.List;

import ec.com.mfac.db.DataBaseObject;

public class Tbl_impuestos_detalleFactory {
	private static Tbl_impuestos_detalleFactory instance = null;
	DataBaseObject objDataBase;
	public static Tbl_impuestos_detalleFactory getInstance(DataBaseObject objDataBase) {
		if (instance == null) {
			instance = new Tbl_impuestos_detalleFactory(objDataBase);
		}
		return instance;
	}

	public Tbl_impuestos_detalleFactory(DataBaseObject objDataBase) {
        this.objDataBase = objDataBase;
	}
    
     
    /** Funci?n que retorna todos los datos de la tabla Tbl_impuestos_detalle en formato de lista.
	 * @return List<Tbl_impuestos_detalle> 
	 * @throws Exception
	 */
	public List<Tbl_impuestos_detalle>  getTbl_impuestos_detalleAll_List() throws Exception {		 
		List<Tbl_impuestos_detalle> sublist = objDataBase .SQL_Select(
						Tbl_impuestos_detalle.class,
						"SELECT * FROM Tbl_impuestos_detalle; ");
	 	return sublist;
	}
    
    /** Funci?n  que permite ingresar datos en la tabla Tbl_impuestos_detalle
	 * @param entidad [Tbl_impuestos_detalle]
	 * @return Los datos se ingresaron correctamente o  No se pudo realizar la operacion solicitada
	 * @throws Exception
	 */
    public String Insert(Tbl_impuestos_detalle entidad) throws Exception
	{	
	  String sql="INSERT INTO  Tbl_impuestos_detalle( codigo,codigoporcentaje,tarifa,baseimponible,valor,pk_detalle)    VALUES (?,?,?,?,?,?)";
	  ArrayList<Object> inParametros= new ArrayList<Object>();
      inParametros.add(entidad.getCodigo()); 
      inParametros.add(entidad.getCodigoporcentaje()); 
      inParametros.add(entidad.getTarifa()); 
      inParametros.add(entidad.getBaseimponible()); 
      inParametros.add(entidad.getValor()); 
      inParametros.add(entidad.getPk_detalle()); 
	   int filasafectadas=  objDataBase.SQL_COMMAND(sql, inParametros);
	   return objDataBase.mensajeInsert(filasafectadas); 
	}

    /** Funci?n  que permite eliminar datos en la tabla Tbl_impuestos_detalle, en base a su(s) clave(s) primaria(s)
	 * @param entidad [Tbl_impuestos_detalle]
	 * @return Los datos se borraron correctamente o  No se pudo realizar la operacion solicitada
	 * @throws Exception
	 */
    public String Delete(Tbl_impuestos_detalle entidad) throws Exception
	{	
	  String sql="DELETE FROM Tbl_impuestos_detalle  WHERE codigo=? and pk_detalle=?  ";
	  ArrayList<Object> inParametros= new ArrayList<>();
      inParametros.add(entidad.getCodigo()); 
      inParametros.add(entidad.getPk_detalle()); 
	  int filasafectadas=  objDataBase.SQL_COMMAND(sql, inParametros);
	  return objDataBase.mensajeDelete(filasafectadas); 
	}
    
        /** Funci?n  que permite actulizar datos en la tabla Tbl_impuestos_detalle,no actuliza claves primarias
	 * @param entidad [Tbl_impuestos_detalle]
	 * @return Los datos se actulizaron correctamente o  No se pudo realizar la operacion solicitada
	 * @throws Exception
	 */
    public String Update(Tbl_impuestos_detalle entidad) throws Exception
	{	
	  String sql="UPDATE Tbl_impuestos_detalle  "
	  		+ " SET codigoporcentaje=?,tarifa=?,baseimponible=?,valor=?  "
	  		+ " WHERE codigo=? and pk_detalle=?    ";
	  ArrayList<Object> inParametros= new ArrayList<>();
      inParametros.add(entidad.getCodigoporcentaje()); 
      inParametros.add(entidad.getTarifa()); 
      inParametros.add(entidad.getBaseimponible()); 
      inParametros.add(entidad.getValor()); 
      inParametros.add(entidad.getCodigo()); 
      inParametros.add(entidad.getPk_detalle()); 
	  int filasafectadas=  objDataBase.SQL_COMMAND(sql, inParametros);
	  return objDataBase.mensajeUpdate(filasafectadas); 
	}
}
 