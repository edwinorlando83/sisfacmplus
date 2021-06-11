
package ec.com.mfac.modeloSybase;

import java.util.ArrayList;
import java.util.List;

import ec.com.mfac.db.DataBaseObject;

public class Tbl_detalle_retencionFactory {
	private static Tbl_detalle_retencionFactory instance = null;
	DataBaseObject objDataBase;
	public static Tbl_detalle_retencionFactory getInstance(DataBaseObject objDataBase) {
		if (instance == null) {
			instance = new Tbl_detalle_retencionFactory(objDataBase);
		}
		return instance;
	}

	public Tbl_detalle_retencionFactory(DataBaseObject objDataBase) {
        this.objDataBase = objDataBase;
	}
    
   
    
    /** Funci?n que retorna todos los datos de la tabla Tbl_detalle_retencion en formato de lista.
	 * @return List<Tbl_detalle_retencion> 
	 * @throws Exception
	 */
	public List<Tbl_detalle_retencion>  getTbl_detalle_retencionAll_List() throws Exception {		 
		List<Tbl_detalle_retencion> sublist = objDataBase .SQL_Select(
						Tbl_detalle_retencion.class,
						"SELECT * FROM Tbl_detalle_retencion; ");
	 	return sublist;
	}
    
    /** Funci?n  que permite ingresar datos en la tabla Tbl_detalle_retencion
	 * @param entidad [Tbl_detalle_retencion]
	 * @return Los datos se ingresaron correctamente o  No se pudo realizar la operacion solicitada
	 * @throws Exception
	 */
    public String Insert(Tbl_detalle_retencion entidad) throws Exception
	{	
	  String sql="INSERT INTO  Tbl_detalle_retencion( codigo,codigoretencion,baseimponible,porcentajeretener,valorretenido,coddocsustento,numdocsustento,fechaemisiondocsustento,claveacceso)    VALUES (?,?,?,?,?,?,?,?,?)";
	  ArrayList<Object> inParametros= new ArrayList<Object>();
      inParametros.add(entidad.getCodigo()); 
      inParametros.add(entidad.getCodigoretencion()); 
      inParametros.add(entidad.getBaseimponible()); 
      inParametros.add(entidad.getPorcentajeretener()); 
      inParametros.add(entidad.getValorretenido()); 
      inParametros.add(entidad.getCoddocsustento()); 
      inParametros.add(entidad.getNumdocsustento()); 
      inParametros.add(entidad.getFechaemisiondocsustento()); 
      inParametros.add(entidad.getClaveacceso()); 
	   int filasafectadas=  objDataBase.SQL_COMMAND(sql, inParametros);
	   return objDataBase.mensajeInsert(filasafectadas); 
	}

    /** Funci?n  que permite eliminar datos en la tabla Tbl_detalle_retencion, en base a su(s) clave(s) primaria(s)
	 * @param entidad [Tbl_detalle_retencion]
	 * @return Los datos se borraron correctamente o  No se pudo realizar la operacion solicitada
	 * @throws Exception
	 */
    public String Delete(Tbl_detalle_retencion entidad) throws Exception
	{	
	  String sql="DELETE FROM Tbl_detalle_retencion  WHERE codigo=? and claveacceso=?  ";
	  ArrayList<Object> inParametros= new ArrayList<>();
      inParametros.add(entidad.getCodigo()); 
      inParametros.add(entidad.getClaveacceso()); 
	  int filasafectadas=  objDataBase.SQL_COMMAND(sql, inParametros);
	  return objDataBase.mensajeDelete(filasafectadas); 
	}
    
        /** Funci?n  que permite actulizar datos en la tabla Tbl_detalle_retencion,no actuliza claves primarias
	 * @param entidad [Tbl_detalle_retencion]
	 * @return Los datos se actulizaron correctamente o  No se pudo realizar la operacion solicitada
	 * @throws Exception
	 */
    public String Update(Tbl_detalle_retencion entidad) throws Exception
	{	
	  String sql="UPDATE Tbl_detalle_retencion  "
	  		+ " SET codigoretencion=?,baseimponible=?,porcentajeretener=?,valorretenido=?,coddocsustento=?,numdocsustento=?,fechaemisiondocsustento=?  "
	  		+ " WHERE codigo=? and claveacceso=?    ";
	  ArrayList<Object> inParametros= new ArrayList<>();
      inParametros.add(entidad.getCodigoretencion()); 
      inParametros.add(entidad.getBaseimponible()); 
      inParametros.add(entidad.getPorcentajeretener()); 
      inParametros.add(entidad.getValorretenido()); 
      inParametros.add(entidad.getCoddocsustento()); 
      inParametros.add(entidad.getNumdocsustento()); 
      inParametros.add(entidad.getFechaemisiondocsustento()); 
      inParametros.add(entidad.getCodigo()); 
      inParametros.add(entidad.getClaveacceso()); 
	  int filasafectadas=  objDataBase.SQL_COMMAND(sql, inParametros);
	  return objDataBase.mensajeUpdate(filasafectadas); 
	}
}
 

