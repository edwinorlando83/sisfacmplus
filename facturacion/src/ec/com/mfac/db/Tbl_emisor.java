
package  ec.com.mfac.db;

import java.io.Serializable;

public class Tbl_emisor implements  Serializable  {
    
 private static final long serialVersionUID = 3171;
 private int filas;
 private String codigo;
 private String razonsocial;
 private String ruc;
 private String nomcomercial;
 private String direstablecimiento;
 private String codestablecimiento;
 private String resolusion;
 private String contribuyenteespecial;
 private String codpintoemision;
 private String llevacontabilidad;
 private String logoimagen;
 private String tipoemision;
 private Integer tiempoespera;
 private String clave_interna;
 private String tipo_ambiente;
 private String direccion_matriz;
 private String token;
 private Integer id_rolusuario;
 private String nombrerol;
 private String nombreempleado;
 private String cb_Especial;
 private String cb_obligado;
private String ruta_procesados;	
private Boolean esnotario;
private Boolean usar_gastos;
private Boolean escolegio;
private String copia_generados;
private String copia_autorizados;
private String ruta_noprocesados;

private byte[] logo;
    public Tbl_emisor()
	{
            
	}
    public String getSerie()
    {
    	return codestablecimiento + "-"+ codpintoemision;
    }
    public String  getCodigo(){
        return codigo;
    }

    public void  setCodigo(  String codigo   ){
      this.codigo = codigo;
    }

    public String  getRazonsocial(){
        return razonsocial;
    }

    public void  setRazonsocial(  String razonsocial   ){
      this.razonsocial = razonsocial;
    }

    public String  getRuc(){
        return ruc;
    }

    public void  setRuc(  String ruc   ){
      this.ruc = ruc;
    }

    public String  getNomcomercial(){
        return nomcomercial;
    }

    public void  setNomcomercial(  String nomcomercial   ){
      this.nomcomercial = nomcomercial;
    }

    public String  getDirestablecimiento(){
        return direstablecimiento;
    }

    public void  setDirestablecimiento(  String direstablecimiento   ){
      this.direstablecimiento = direstablecimiento;
    }

    public String  getCodestablecimiento(){
        return codestablecimiento;
    }

    public void  setCodestablecimiento(  String codestablecimiento   ){
      this.codestablecimiento = codestablecimiento;
    }

    public String  getResolusion(){
        return resolusion;
    }

    public void  setResolusion(  String resolusion   ){
      this.resolusion = resolusion;
    }

    public String  getContribuyenteespecial(){
        return contribuyenteespecial;
    }

    public void  setContribuyenteespecial(  String contribuyenteespecial   ){
      this.contribuyenteespecial = contribuyenteespecial;
    }

    public String  getCodpintoemision(){
        return codpintoemision;
    }

    public void  setCodpintoemision(  String codpintoemision   ){
      this.codpintoemision = codpintoemision;
    }

    public String  getLlevacontabilidad(){
        return llevacontabilidad;
    }

    public void  setLlevacontabilidad(  String llevacontabilidad   ){
      this.llevacontabilidad = llevacontabilidad;
    }

    public String  getLogoimagen(){
        return logoimagen;
    }

    public void  setLogoimagen(  String logoimagen   ){
      this.logoimagen = logoimagen;
    }

    public String  getTipoemision(){
        return tipoemision;
    }

    public void  setTipoemision(  String tipoemision   ){
      this.tipoemision = tipoemision;
    }

    public Integer  getTiempoespera(){
        return tiempoespera;
    }

    public void  setTiempoespera(  Integer tiempoespera   ){
      this.tiempoespera = tiempoespera;
    }

    public String  getClave_interna(){
        return clave_interna;
    }

    public void  setClave_interna(  String clave_interna   ){
      this.clave_interna = clave_interna;
    }

    public String  getTipo_ambiente(){
        return tipo_ambiente;
    }

    public void  setTipo_ambiente(  String tipo_ambiente   ){
      this.tipo_ambiente = tipo_ambiente;
    }

    public String  getDireccion_matriz(){
        return direccion_matriz;
    }

    public void  setDireccion_matriz(  String direccion_matriz   ){
      this.direccion_matriz = direccion_matriz;
    }

    public String  getToken(){
        return token;
    }

    public void  setToken(  String token   ){
      this.token = token;
    }

    public Integer  getId_rolusuario(){
        return id_rolusuario;
    }

// IsForeignKeyMember 
    public void  setId_rolusuario(  Integer id_rolusuario   ){
      this.id_rolusuario = id_rolusuario;
    }

	    public int getFilas() {
		return filas;
	}


	public void setFilas(int filas) {
		this.filas = filas;
	}

 	public String getNombreempleado() {
		return nombreempleado;
	}


	public void setNombreempleado(String nombreempleado) {
		this.nombreempleado = nombreempleado;
	}


	public String getNombrerol() {
		return nombrerol;
	}


	public void setNombrerol(String nombrerol) {
		this.nombrerol = nombrerol;
	}

	public String getCb_Especial() {
		return cb_Especial;
	}

	public void setCb_Especial(String cb_Especial) {
		this.cb_Especial = cb_Especial;
	}

	public String getCb_obligado() {
		return cb_obligado;
	}

	public void setCb_obligado(String cb_obligado) {
		this.cb_obligado = cb_obligado;
	}

	 	public Boolean getEsnotario() {
		return esnotario;
	}
	public void setEsnotario(Boolean esnotario) {
		this.esnotario = esnotario;
	}
	public Boolean getUsar_gastos() {
		return usar_gastos;
	}
	public void setUsar_gastos(Boolean usar_gastos) {
		this.usar_gastos = usar_gastos;
	}
	public Boolean getEscolegio() {
		return escolegio;
	}
	public void setEscolegio(Boolean escolegio) {
		this.escolegio = escolegio;
	}
	public String getCopia_generados() {
		return copia_generados;
	}
	public void setCopia_generados(String copia_generados) {
		this.copia_generados = copia_generados;
	}
	public String getCopia_autorizados() {
		return copia_autorizados;
	}
	public void setCopia_autorizados(String copia_autorizados) {
		this.copia_autorizados = copia_autorizados;
	}
	public byte[] getLogo() {
		return logo;
	}
	public void setLogo(byte[] logo) {
		this.logo = logo;
	}
	public String getRuta_procesados() {
		return ruta_procesados;
	}
	public void setRuta_procesados(String ruta_procesados) {
		this.ruta_procesados = ruta_procesados;
	}
	public String getRuta_noprocesados() {
		return ruta_noprocesados;
	}
	public void setRuta_noprocesados(String ruta_noprocesados) {
		this.ruta_noprocesados = ruta_noprocesados;
	}
	
    
}


