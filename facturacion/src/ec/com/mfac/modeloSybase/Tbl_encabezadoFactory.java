
package ec.com.mfac.modeloSybase;

import java.util.ArrayList;
import java.util.List;

import ec.com.mfac.db.DataBaseObject;

public class Tbl_encabezadoFactory {
	private static Tbl_encabezadoFactory instance = null;
	DataBaseObject objDataBase;
	public static Tbl_encabezadoFactory getInstance(DataBaseObject objDataBase) {
		if (instance == null) {
			instance = new Tbl_encabezadoFactory(objDataBase);
		}
		return instance;
	}

	public Tbl_encabezadoFactory(DataBaseObject objDataBase) {
        this.objDataBase = objDataBase;
	}
     
    
    /** Funci?n que retorna todos los datos de la tabla Tbl_encabezado en formato de lista.
	 * @return List<Tbl_encabezado> 
	 * @throws Exception
	 */
	public List<Tbl_encabezado>  getTbl_encabezadoAll_List() throws Exception {		 
		List<Tbl_encabezado> sublist = objDataBase .SQL_Select(
						Tbl_encabezado.class,
						"SELECT * FROM Tbl_encabezado; ");
	 	return sublist;
	}
    
    /** Funci?n  que permite ingresar datos en la tabla Tbl_encabezado
	 * @param entidad [Tbl_encabezado]
	 * @return Los datos se ingresaron correctamente o  No se pudo realizar la operacion solicitada
	 * @throws Exception
	 */
    public boolean Insert(Tbl_encabezado entidad) throws Exception
	{	
	  String sql="INSERT INTO  Tbl_encabezado( claveacceso,coddoc,ambiente,tipoemision,razonsocial,nombrecomercial,ruc,estab,ptoemi,secuencial,dirmatriz,fechaemision,direstablecimiento,obligadocontabilidad,tipoidentificacioncomprador,razonsocialcomprador,identificacioncomprador,totalsinimpuestos,totaldescuento,propina,importetotal,moneda,nc_rise,nc_coddocmodificado,nc_numdocmodificado,nc_fechaemisiondocsustento,nc_valormodificacion,r_tipoidentificacionsujetoretenido,r_razonsocialsujetoretenido,r_identificacionsujetoretenido,r_periodofiscal,autorizacion)    VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	  ArrayList<Object> inParametros= new ArrayList<Object>();
      inParametros.add(entidad.getClaveacceso().trim()); 
      inParametros.add(entidad.getCoddoc().trim()); 
      inParametros.add(entidad.getAmbiente().trim()); 
      inParametros.add(entidad.getTipoemision().trim()); 
      inParametros.add(entidad.getRazonsocial().trim()); 
      inParametros.add(entidad.getNombrecomercial()==null?"S_N":entidad.getNombrecomercial().trim()); 
      inParametros.add(entidad.getRuc()==null?"ruc":entidad.getRuc().trim()); 
      inParametros.add(entidad.getEstab().trim()); 
      inParametros.add(entidad.getPtoemi().trim()); 
      inParametros.add(entidad.getSecuencial()==null?"sec":entidad.getSecuencial().trim()); 
      inParametros.add(entidad.getDirmatriz()==null?"_":entidad.getDirmatriz().trim()); 
      inParametros.add(entidad.getFechaemision()==null?"_":entidad.getFechaemision().trim()); 
      inParametros.add(entidad.getDirestablecimiento()==null?"_":entidad.getDirestablecimiento().trim()); 
      inParametros.add(entidad.getObligadocontabilidad()==null?"_":entidad.getObligadocontabilidad().trim()); 
      inParametros.add(entidad.getTipoidentificacioncomprador()==null?"_":entidad.getTipoidentificacioncomprador().trim()); 
      inParametros.add(entidad.getRazonsocialcomprador()==null?"_":entidad.getRazonsocialcomprador().trim()); 
      inParametros.add(entidad.getIdentificacioncomprador()==null?"_":entidad.getIdentificacioncomprador().trim()); 
      inParametros.add(entidad.getTotalsinimpuestos() ); 
      inParametros.add(entidad.getTotaldescuento() ); 
      inParametros.add(entidad.getPropina()  ); 
      inParametros.add(entidad.getImportetotal() ); 
      inParametros.add(entidad.getMoneda()==null?"_":entidad.getMoneda().trim()); 
      inParametros.add(entidad.getNc_rise()==null?"_":entidad.getNc_rise().trim()); 
      inParametros.add(entidad.getNc_coddocmodificado()==null?"_":entidad.getNc_coddocmodificado().trim()); 
      inParametros.add(entidad.getNc_numdocmodificado()==null?"_":entidad.getNc_numdocmodificado().trim()); 
      inParametros.add(entidad.getNc_fechaemisiondocsustento() ==null?" " : entidad.getNc_fechaemisiondocsustento()); 
      inParametros.add(entidad.getNc_valormodificacion() ); 
      inParametros.add(entidad.getR_tipoidentificacionsujetoretenido()==null?"_":entidad.getR_tipoidentificacionsujetoretenido().trim()); 
      inParametros.add(entidad.getR_razonsocialsujetoretenido()==null?"_":entidad.getR_razonsocialsujetoretenido().trim()); 
      inParametros.add(entidad.getR_identificacionsujetoretenido()==null?"_":entidad.getR_identificacionsujetoretenido().trim()); 
      inParametros.add(entidad.getR_periodofiscal()==null?"_":entidad.getR_periodofiscal().trim()); 
      inParametros.add(entidad.getAutorizacion().trim()); 
      int filasafectadas=  objDataBase.SQL_COMMAND(sql, inParametros);
	   return filasafectadas > 0; 
	}

    /** Funci?n  que permite eliminar datos en la tabla Tbl_encabezado, en base a su(s) clave(s) primaria(s)
	 * @param entidad [Tbl_encabezado]
	 * @return Los datos se borraron correctamente o  No se pudo realizar la operacion solicitada
	 * @throws Exception
	 */
    public String Delete(Tbl_encabezado entidad) throws Exception
	{	
	  String sql="DELETE FROM Tbl_encabezado  WHERE claveacceso=?  ";
	  ArrayList<Object> inParametros= new ArrayList<>();
      inParametros.add(entidad.getClaveacceso()); 
	  int filasafectadas=  objDataBase.SQL_COMMAND(sql, inParametros);
	  return objDataBase.mensajeDelete(filasafectadas); 
	}
    
        /** Funci?n  que permite actulizar datos en la tabla Tbl_encabezado,no actuliza claves primarias
	 * @param entidad [Tbl_encabezado]
	 * @return Los datos se actulizaron correctamente o  No se pudo realizar la operacion solicitada
	 * @throws Exception
	 */
    public String Update(Tbl_encabezado entidad) throws Exception
	{	
	  String sql="UPDATE Tbl_encabezado  "
	  		+ " SET coddoc=?,ambiente=?,tipoemision=?,razonsocial=?,nombrecomercial=?,ruc=?,estab=?,ptoemi=?,secuencial=?,dirmatriz=?,fechaemision=?,direstablecimiento=?,obligadocontabilidad=?,tipoidentificacioncomprador=?,razonsocialcomprador=?,identificacioncomprador=?,totalsinimpuestos=?,totaldescuento=?,propina=?,importetotal=?,moneda=?,nc_rise=?,nc_coddocmodificado=?,nc_numdocmodificado=?,nc_fechaemisiondocsustento=?,nc_valormodificacion=?,r_tipoidentificacionsujetoretenido=?,r_razonsocialsujetoretenido=?,r_identificacionsujetoretenido=?,r_periodofiscal=?  "
	  		+ " WHERE claveacceso=?    ";
	  ArrayList<Object> inParametros= new ArrayList<>();
      inParametros.add(entidad.getCoddoc()); 
      inParametros.add(entidad.getAmbiente()); 
      inParametros.add(entidad.getTipoemision()); 
      inParametros.add(entidad.getRazonsocial()); 
      inParametros.add(entidad.getNombrecomercial()); 
      inParametros.add(entidad.getRuc()); 
      inParametros.add(entidad.getEstab()); 
      inParametros.add(entidad.getPtoemi()); 
      inParametros.add(entidad.getSecuencial()); 
      inParametros.add(entidad.getDirmatriz()); 
      inParametros.add(entidad.getFechaemision()); 
      inParametros.add(entidad.getDirestablecimiento()); 
      inParametros.add(entidad.getObligadocontabilidad()); 
      inParametros.add(entidad.getTipoidentificacioncomprador()); 
      inParametros.add(entidad.getRazonsocialcomprador()); 
      inParametros.add(entidad.getIdentificacioncomprador()); 
      inParametros.add(entidad.getTotalsinimpuestos()); 
      inParametros.add(entidad.getTotaldescuento()); 
      inParametros.add(entidad.getPropina()); 
      inParametros.add(entidad.getImportetotal()); 
      inParametros.add(entidad.getMoneda()); 
      inParametros.add(entidad.getNc_rise()); 
      inParametros.add(entidad.getNc_coddocmodificado()); 
      inParametros.add(entidad.getNc_numdocmodificado()); 
      inParametros.add(entidad.getNc_fechaemisiondocsustento()); 
      inParametros.add(entidad.getNc_valormodificacion()); 
      inParametros.add(entidad.getR_tipoidentificacionsujetoretenido()); 
      inParametros.add(entidad.getR_razonsocialsujetoretenido()); 
      inParametros.add(entidad.getR_identificacionsujetoretenido()); 
      inParametros.add(entidad.getR_periodofiscal()); 
      inParametros.add(entidad.getClaveacceso()); 
	  int filasafectadas=  objDataBase.SQL_COMMAND(sql, inParametros);
	  return objDataBase.mensajeUpdate(filasafectadas); 
	}
}
 
