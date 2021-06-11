package ec.com.mfac.modeloSybase;

 

import java.util.Date;

public class Tbl_encabezado    {
    
 
 private int filas;
 private String claveacceso;
 private String coddoc;
 private String ambiente;
 private String tipoemision;
 private String razonsocial;
 private String nombrecomercial;
 private String ruc;
 private String estab;
 private String ptoemi;
 private String secuencial;
 private String dirmatriz;
 private String fechaemision;
 private String direstablecimiento;
 private String obligadocontabilidad;
 private String tipoidentificacioncomprador;
 private String razonsocialcomprador;
 private String identificacioncomprador;
 private double totalsinimpuestos;
 private double totaldescuento;
 private double propina;
 private double importetotal;
 private String moneda;
 private String nc_rise;
 private String nc_coddocmodificado;
 private String nc_numdocmodificado;
 private Date nc_fechaemisiondocsustento;
 private double nc_valormodificacion;
 private String r_tipoidentificacionsujetoretenido;
 private String r_razonsocialsujetoretenido;
 private String r_identificacionsujetoretenido;
 private String r_periodofiscal;
 private String autorizacion;  
    public Tbl_encabezado()
	{
            
	}
    

    public String  getClaveacceso(){
        return claveacceso;
    }

    public void  setClaveacceso(  String claveacceso   ){
      this.claveacceso = claveacceso;
    }

    public String  getCoddoc(){
        return coddoc;
    }

    public void  setCoddoc(  String coddoc   ){
      this.coddoc = coddoc;
    }

    public String  getAmbiente(){
        return ambiente;
    }

    public void  setAmbiente(  String ambiente   ){
      this.ambiente = ambiente;
    }

    public String  getTipoemision(){
        return tipoemision;
    }

    public void  setTipoemision(  String tipoemision   ){
      this.tipoemision = tipoemision;
    }

    public String  getRazonsocial(){
        return razonsocial;
    }

    public void  setRazonsocial(  String razonsocial   ){
      this.razonsocial = razonsocial;
    }

    public String  getNombrecomercial(){
        return nombrecomercial;
    }

    public void  setNombrecomercial(  String nombrecomercial   ){
      this.nombrecomercial = nombrecomercial;
    }

    public String  getRuc(){
        return ruc;
    }

    public void  setRuc(  String ruc   ){
      this.ruc = ruc;
    }

    public String  getEstab(){
        return estab;
    }

    public void  setEstab(  String estab   ){
      this.estab = estab;
    }

    public String  getPtoemi(){
        return ptoemi;
    }

    public void  setPtoemi(  String ptoemi   ){
      this.ptoemi = ptoemi;
    }

    public String  getSecuencial(){
        return secuencial;
    }

    public void  setSecuencial(  String secuencial   ){
      this.secuencial = secuencial;
    }

    public String  getDirmatriz(){
        return dirmatriz;
    }

    public void  setDirmatriz(  String dirmatriz   ){
      this.dirmatriz = dirmatriz;
    }

    public String  getFechaemision(){
        return fechaemision;
    }

    public void  setFechaemision(  String fechaemision   ){
      this.fechaemision = fechaemision;
    }

    public String  getDirestablecimiento(){
        return direstablecimiento;
    }

    public void  setDirestablecimiento(  String direstablecimiento   ){
      this.direstablecimiento = direstablecimiento;
    }

    public String  getObligadocontabilidad(){
        return obligadocontabilidad;
    }

    public void  setObligadocontabilidad(  String obligadocontabilidad   ){
      this.obligadocontabilidad = obligadocontabilidad;
    }

    public String  getTipoidentificacioncomprador(){
        return tipoidentificacioncomprador;
    }

    public void  setTipoidentificacioncomprador(  String tipoidentificacioncomprador   ){
      this.tipoidentificacioncomprador = tipoidentificacioncomprador;
    }

    public String  getRazonsocialcomprador(){
        return razonsocialcomprador;
    }

    public void  setRazonsocialcomprador(  String razonsocialcomprador   ){
      this.razonsocialcomprador = razonsocialcomprador;
    }

    public String  getIdentificacioncomprador(){
        return identificacioncomprador;
    }

    public void  setIdentificacioncomprador(  String identificacioncomprador   ){
      this.identificacioncomprador = identificacioncomprador;
    }

    public double  getTotalsinimpuestos(){
        return totalsinimpuestos;
    }

    public void  setTotalsinimpuestos(  double totalsinimpuestos   ){
      this.totalsinimpuestos = totalsinimpuestos;
    }

    public double  getTotaldescuento(){
        return totaldescuento;
    }

    public void  setTotaldescuento(  double totaldescuento   ){
      this.totaldescuento = totaldescuento;
    }

    public double  getPropina(){
        return propina;
    }

    public void  setPropina(  double propina   ){
      this.propina = propina;
    }

    public double  getImportetotal(){
        return importetotal;
    }

    public void  setImportetotal(  double importetotal   ){
      this.importetotal = importetotal;
    }

    public String  getMoneda(){
        return moneda;
    }

    public void  setMoneda(  String moneda   ){
      this.moneda = moneda;
    }

    public String  getNc_rise(){
    	
    	if(nc_rise!=null)
    		if(nc_rise.trim().length()==0)
    			return "_";
    	
        return nc_rise;
    }

    public void  setNc_rise(  String nc_rise   ){
      this.nc_rise = nc_rise;
    }

    public String  getNc_coddocmodificado(){
    	if(nc_coddocmodificado!=null)
    		if(nc_coddocmodificado.trim().length()==0)
    			return "_";
        return nc_coddocmodificado;
    }

    public void  setNc_coddocmodificado(  String nc_coddocmodificado   ){
      this.nc_coddocmodificado = nc_coddocmodificado;
    }

    public String  getNc_numdocmodificado(){
    	
    	if(nc_numdocmodificado!=null)
    		if(nc_numdocmodificado.trim().length()==0)
    			return "_";
        return nc_numdocmodificado;
    }

    public void  setNc_numdocmodificado(  String nc_numdocmodificado   ){
      this.nc_numdocmodificado = nc_numdocmodificado;
    }

    public Date  getNc_fechaemisiondocsustento(){
    	
      	
        return nc_fechaemisiondocsustento;
    }

    public void  setNc_fechaemisiondocsustento(  Date nc_fechaemisiondocsustento   ){
      this.nc_fechaemisiondocsustento = nc_fechaemisiondocsustento;
    }

    public double  getNc_valormodificacion(){
        return nc_valormodificacion;
    }

    public void  setNc_valormodificacion(  double nc_valormodificacion   ){
      this.nc_valormodificacion = nc_valormodificacion;
    }

    public String  getR_tipoidentificacionsujetoretenido(){
    	if(r_tipoidentificacionsujetoretenido!=null)
    		if(r_tipoidentificacionsujetoretenido.trim().length()==0)
    			return "_";
        return r_tipoidentificacionsujetoretenido;
    }

    public void  setR_tipoidentificacionsujetoretenido(  String r_tipoidentificacionsujetoretenido   ){
      this.r_tipoidentificacionsujetoretenido = r_tipoidentificacionsujetoretenido;
    }

    public String  getR_razonsocialsujetoretenido(){
    	if(r_razonsocialsujetoretenido!=null)
    		if(r_razonsocialsujetoretenido.trim().length()==0)
    			return "_";
        return r_razonsocialsujetoretenido;
    }

    public void  setR_razonsocialsujetoretenido(  String r_razonsocialsujetoretenido   ){
      this.r_razonsocialsujetoretenido = r_razonsocialsujetoretenido;
    }

    public String  getR_identificacionsujetoretenido(){
    	if(r_identificacionsujetoretenido!=null)
    		if(r_identificacionsujetoretenido.trim().length()==0)
    			return "_";
    	
        return r_identificacionsujetoretenido;
    }

    public void  setR_identificacionsujetoretenido(  String r_identificacionsujetoretenido   ){
      this.r_identificacionsujetoretenido = r_identificacionsujetoretenido;
    }

    public String  getR_periodofiscal(){
    	if(r_periodofiscal!=null)
    		if(r_periodofiscal.trim().length()==0)
    			return "_";
        return r_periodofiscal;
    }

    public void  setR_periodofiscal(  String r_periodofiscal   ){
      this.r_periodofiscal = r_periodofiscal;
    }

	
    public int getFilas() {
		return filas;
	}


	public void setFilas(int filas) {
		this.filas = filas;
	}


	public String getAutorizacion() {
		return autorizacion;
	}


	public void setAutorizacion(String autorizacion) {
		this.autorizacion = autorizacion;
	}
    
}


