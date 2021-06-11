package ec.com.mfac.modeloSybase;
 
import java.util.ArrayList;
import java.util.List;

import ec.com.mfac.db.DataBaseObject;

public class Tbl_detalleFactory {
	private static Tbl_detalleFactory instance = null;
	DataBaseObject objDataBase;
	public static Tbl_detalleFactory getInstance(DataBaseObject objDataBase) {
		if (instance == null) {
			instance = new Tbl_detalleFactory(objDataBase);
		}
		return instance;
	}

	public Tbl_detalleFactory(DataBaseObject objDataBase) {
        this.objDataBase = objDataBase;
	}
    
   
    /** Funci?n que retorna todos los datos de la tabla Tbl_detalle en formato de lista.
	 * @return List<Tbl_detalle> 
	 * @throws Exception
	 */
	public List<Tbl_detalle>  getTbl_detalleAll_List() throws Exception {		 
		List<Tbl_detalle> sublist = objDataBase .SQL_Select(
						Tbl_detalle.class,
						"SELECT * FROM Tbl_detalle; ");
	 	return sublist;
	}
    
    /** Funci?n  que permite ingresar datos en la tabla Tbl_detalle
	 * @param entidad [Tbl_detalle]
	 * @return Los datos se ingresaron correctamente o  No se pudo realizar la operacion solicitada
	 * @throws Exception
	 */
    public boolean Insert(Tbl_detalle entidad) throws Exception
	{	
	  String sql="INSERT INTO  Tbl_detalle( pk_detalle,codigoprincipal,codigoauxiliar,descripcion,cantidad,preciounitario,descuento,preciototalsinimpuesto,claveacceso)    VALUES (?,?,?,?,?,?,?,?,?)";
	 

	  
	  ArrayList<Object> inParametros= new ArrayList<Object>();
      inParametros.add(entidad.getPk_detalle()); 
      inParametros.add(entidad.getCodigoprincipal()==null?"":entidad.getCodigoprincipal()); 
      inParametros.add(entidad.getCodigoauxiliar()==null?"":entidad.getCodigoauxiliar()); 
      inParametros.add(entidad.getDescripcion()==null?"":entidad.getDescripcion()); 
      inParametros.add(entidad.getCantidad()); 
      inParametros.add(entidad.getPreciounitario()); 
      inParametros.add(entidad.getDescuento()); 
      inParametros.add(entidad.getPreciototalsinimpuesto()); 
      inParametros.add(entidad.getClaveacceso()); 
	   int filasafectadas=  objDataBase.SQL_COMMAND(sql, inParametros);
	   return filasafectadas>0; 
	}

    /** Funci?n  que permite eliminar datos en la tabla Tbl_detalle, en base a su(s) clave(s) primaria(s)
	 * @param entidad [Tbl_detalle]
	 * @return Los datos se borraron correctamente o  No se pudo realizar la operacion solicitada
	 * @throws Exception
	 */
    public String Delete(Tbl_detalle entidad) throws Exception
	{	
	  String sql="DELETE FROM Tbl_detalle  WHERE pk_detalle=?  ";
	  ArrayList<Object> inParametros= new ArrayList<>();
      inParametros.add(entidad.getPk_detalle()); 
	  int filasafectadas=  objDataBase.SQL_COMMAND(sql, inParametros);
	  return objDataBase.mensajeDelete(filasafectadas); 
	}
    
        /** Funci?n  que permite actulizar datos en la tabla Tbl_detalle,no actuliza claves primarias
	 * @param entidad [Tbl_detalle]
	 * @return Los datos se actulizaron correctamente o  No se pudo realizar la operacion solicitada
	 * @throws Exception
	 */
    public String Update(Tbl_detalle entidad) throws Exception
	{	
	  String sql="UPDATE Tbl_detalle  "
	  		+ " SET codigoprincipal=?,codigoauxiliar=?,descripcion=?,cantidad=?,preciounitario=?,descuento=?,preciototalsinimpuesto=?,claveacceso=?  "
	  		+ " WHERE pk_detalle=?    ";
	  ArrayList<Object> inParametros= new ArrayList<>();
      inParametros.add(entidad.getCodigoprincipal()); 
      inParametros.add(entidad.getCodigoauxiliar()); 
      inParametros.add(entidad.getDescripcion()); 
      inParametros.add(entidad.getCantidad()); 
      inParametros.add(entidad.getPreciounitario()); 
      inParametros.add(entidad.getDescuento()); 
      inParametros.add(entidad.getPreciototalsinimpuesto()); 
      inParametros.add(entidad.getClaveacceso()); 
      inParametros.add(entidad.getPk_detalle()); 
	  int filasafectadas=  objDataBase.SQL_COMMAND(sql, inParametros);
	  return objDataBase.mensajeUpdate(filasafectadas); 
	}
}
 
 