
package ec.com.mfac.db;

import java.io.Serializable;
import java.util.Date;

public class Tbl_factura implements   Serializable  {
    
    private static final long serialVersionUID = 3687;
    private int filas;
 private Integer fac_id;
 private String fac_numero;
 private Date fac_fecha;
 private String fac_codigo_emisor;
 private String fac_ruc_ci;
 private Double fac_total_descuentos;
 private Double fac_iva_12;
 private Double fac_iva_0;
 private Double fac_sub_total;
 private Double fac_total;
 private String fac_anulado;
 private String fac_estado;
 private String fac_tipo;
 private String fac_nc_motivo;
 private String fac_nc_factura;
 private String fac_nc_serie;
 private Integer fac_nc_fac_id;
 private Integer fac_guias_traspostista;
 private String fac_guias_destino;
 private String fac_guias_ruta;
 private String fac_guias_aduanero_cod;
 private String fac_guias_aduanero_doc;
 private Integer fac_guias_fac_id;
 private String fac_guias_numautoriza;
 private Date fac_guias_fechainicio;
 private Date fac_guias_fechafin;
 private Date fac_guias_fechaemision;
 private String fac_guias_placa;
 private String fac_guias_dir_partida;
 private String clientenombre;
 private String ter_razon_social;
 private Date fac_nc_fechaemisiondoc; 
 private String fac_cr_numerocomp;
 private String   fac_cr_mes ;
 private String   fac_cr_anio ;
  private String fac_claveacceso;  
  private String razonsocial ;
 private String fac_mensaje;
 private String fac_observacion;
 private String fac_facturatienenc;
 private String fac_facturatienenc_num;
 private String fac_esinhabilitado;
 private String fac_usuario;
 private String  fac_serie;
 private String fac_autorizacion;
 private String fac_tipogasto;
 
    public Tbl_factura()
	{
            
	}
    

    public Integer  getFac_id(){
        return fac_id;
    }

    public void  setFac_id(  Integer fac_id   ){
      this.fac_id = fac_id;
    }

    public String  getFac_numero(){
        return fac_numero;
    }

    public void  setFac_numero(  String fac_numero   ){
      this.fac_numero = fac_numero;
    }

    public Date  getFac_fecha(){
        return fac_fecha;
    }

    public void  setFac_fecha(  Date fac_fecha   ){
      this.fac_fecha = fac_fecha;
    }

    public String  getFac_codigo_emisor(){
        return fac_codigo_emisor;
    }

    public void  setFac_codigo_emisor(  String fac_codigo_emisor   ){
      this.fac_codigo_emisor = fac_codigo_emisor;
    }

    public String  getFac_ruc_ci(){
        return fac_ruc_ci;
    }

    public void  setFac_ruc_ci(  String fac_ruc_ci   ){
      this.fac_ruc_ci = fac_ruc_ci;
    }

    public Double  getFac_total_descuentos(){
        return fac_total_descuentos;
    }

    public void  setFac_total_descuentos(  Double fac_total_descuentos   ){
      this.fac_total_descuentos = fac_total_descuentos;
    }

    public Double  getFac_iva_12(){
        return fac_iva_12;
    }

    public void  setFac_iva_12(  Double fac_iva_12   ){
      this.fac_iva_12 = fac_iva_12;
    }

    public Double  getFac_iva_0(){
        return fac_iva_0;
    }

    public void  setFac_iva_0(  Double fac_iva_0   ){
      this.fac_iva_0 = fac_iva_0;
    }

    public Double  getFac_sub_total(){
        return fac_sub_total;
    }

    public void  setFac_sub_total(  Double fac_sub_total   ){
      this.fac_sub_total = fac_sub_total;
    }

    public Double  getFac_total(){
        return fac_total;
    }

    public void  setFac_total(  Double fac_total   ){
      this.fac_total = fac_total;
    }

    public String  getFac_anulado(){
        return fac_anulado;
    }

    public void  setFac_anulado(  String fac_anulado   ){
      this.fac_anulado = fac_anulado;
    }

    public String  getFac_estado(){
        return fac_estado;
    }

    public void  setFac_estado(  String fac_estado   ){
      this.fac_estado = fac_estado;
    }

    public String  getFac_tipo(){
        return fac_tipo;
    }

    public void  setFac_tipo(  String fac_tipo   ){
      this.fac_tipo = fac_tipo;
    }

    public String  getFac_nc_motivo(){
        return fac_nc_motivo;
    }

    public void  setFac_nc_motivo(  String fac_nc_motivo   ){
      this.fac_nc_motivo = fac_nc_motivo;
    }

    public String  getFac_nc_factura(){
        return fac_nc_factura;
    }

    public void  setFac_nc_factura(  String fac_nc_factura   ){
      this.fac_nc_factura = fac_nc_factura;
    }

    public String  getFac_nc_serie(){
        return fac_nc_serie;
    }

    public void  setFac_nc_serie(  String fac_nc_serie   ){
      this.fac_nc_serie = fac_nc_serie;
    }

    public Integer  getFac_nc_fac_id(){
        return fac_nc_fac_id;
    }

    public void  setFac_nc_fac_id(  Integer fac_nc_fac_id   ){
      this.fac_nc_fac_id = fac_nc_fac_id;
    }

    public Integer  getFac_guias_traspostista(){
        return fac_guias_traspostista;
    }

    public void  setFac_guias_traspostista(  Integer fac_guias_traspostista   ){
      this.fac_guias_traspostista = fac_guias_traspostista;
    }

    public String  getFac_guias_destino(){
        return fac_guias_destino;
    }

    public void  setFac_guias_destino(  String fac_guias_destino   ){
      this.fac_guias_destino = fac_guias_destino;
    }

    public String  getFac_guias_ruta(){
        return fac_guias_ruta;
    }

    public void  setFac_guias_ruta(  String fac_guias_ruta   ){
      this.fac_guias_ruta = fac_guias_ruta;
    }

    public String  getFac_guias_aduanero_cod(){
        return fac_guias_aduanero_cod;
    }

    public void  setFac_guias_aduanero_cod(  String fac_guias_aduanero_cod   ){
      this.fac_guias_aduanero_cod = fac_guias_aduanero_cod;
    }

    public String  getFac_guias_aduanero_doc(){
        return fac_guias_aduanero_doc;
    }

    public void  setFac_guias_aduanero_doc(  String fac_guias_aduanero_doc   ){
      this.fac_guias_aduanero_doc = fac_guias_aduanero_doc;
    }

    public Integer  getFac_guias_fac_id(){
        return fac_guias_fac_id;
    }

    public void  setFac_guias_fac_id(  Integer fac_guias_fac_id   ){
      this.fac_guias_fac_id = fac_guias_fac_id;
    }

    public String  getFac_guias_numautoriza(){
        return fac_guias_numautoriza;
    }

    public void  setFac_guias_numautoriza(  String fac_guias_numautoriza   ){
      this.fac_guias_numautoriza = fac_guias_numautoriza;
    }

    public Date  getFac_guias_fechainicio(){
        return fac_guias_fechainicio;
    }

    public void  setFac_guias_fechainicio(  Date fac_guias_fechainicio   ){
      this.fac_guias_fechainicio = fac_guias_fechainicio;
    }

    public Date  getFac_guias_fechafin(){
        return fac_guias_fechafin;
    }

    public void  setFac_guias_fechafin(  Date fac_guias_fechafin   ){
      this.fac_guias_fechafin = fac_guias_fechafin;
    }

    public Date  getFac_guias_fechaemision(){
        return fac_guias_fechaemision;
    }

    public void  setFac_guias_fechaemision(  Date fac_guias_fechaemision   ){
      this.fac_guias_fechaemision = fac_guias_fechaemision;
    }

    public String  getFac_guias_placa(){
        return fac_guias_placa;
    }

    public void  setFac_guias_placa(  String fac_guias_placa   ){
      this.fac_guias_placa = fac_guias_placa;
    }

    public String  getFac_guias_dir_partida(){
        return fac_guias_dir_partida;
    }

    public void  setFac_guias_dir_partida(  String fac_guias_dir_partida   ){
      this.fac_guias_dir_partida = fac_guias_dir_partida;
    }

	
    public int getFilas() {
		return filas;
	}


	public void setFilas(int filas) {
		this.filas = filas;
	}


	public String getClientenombre() {
		return clientenombre;
	}


	public void setClientenombre(String clientenombre) {
		this.clientenombre = clientenombre;
	}


	public String getTer_razon_social() {
		return ter_razon_social;
	}


	public void setTer_razon_social(String ter_razon_social) {
		this.ter_razon_social = ter_razon_social;
	}


	public Date getFac_nc_fechaemisiondoc() {
		return fac_nc_fechaemisiondoc;
	}


	public void setFac_nc_fechaemisiondoc(Date fac_nc_fechaemisiondoc) {
		this.fac_nc_fechaemisiondoc = fac_nc_fechaemisiondoc;
	}


	public String getFac_cr_numerocomp() {
		return fac_cr_numerocomp;
	}


	public void setFac_cr_numerocomp(String fac_cr_numerocomp) {
		this.fac_cr_numerocomp = fac_cr_numerocomp;
	}


	public String getFac_cr_mes() {
		return fac_cr_mes;
	}


	public void setFac_cr_mes(String fac_cr_mes) {
		this.fac_cr_mes = fac_cr_mes;
	}


	public String getFac_cr_anio() {
		return fac_cr_anio;
	}


	public void setFac_cr_anio(String fac_cr_anio) {
		this.fac_cr_anio = fac_cr_anio;
	}


	public String getFac_claveacceso() {
		return fac_claveacceso;
	}


	public void setFac_claveacceso(String fac_claveacceso) {
		this.fac_claveacceso = fac_claveacceso;
	}


	/** Para cuando se utiliza en el cliente
	 * @return
	 */
	public String getRazonsocial() {
		return razonsocial;
	}


	public void setRazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
	}


	public String getFac_mensaje() {
		return fac_mensaje;
	}


	public void setFac_mensaje(String fac_mensaje) {
		this.fac_mensaje = fac_mensaje;
	}


	public String getFac_observacion() {
		return fac_observacion;
	}


	public void setFac_observacion(String fac_observacion) {
		this.fac_observacion = fac_observacion;
	}


	public String getFac_esinhabilitado() {
		return fac_esinhabilitado;
	}


	public void setFac_esinhabilitado(String fac_esinhabilitado) {
		this.fac_esinhabilitado = fac_esinhabilitado;
	}


	public String getFac_facturatienenc() {
		return fac_facturatienenc;
	}


	public void setFac_facturatienenc(String fac_facturatienenc) {
		this.fac_facturatienenc = fac_facturatienenc;
	}


	public String getFac_facturatienenc_num() {
		return fac_facturatienenc_num;
	}


	public void setFac_facturatienenc_num(String fac_facturatienenc_num) {
		this.fac_facturatienenc_num = fac_facturatienenc_num;
	}


	public String getFac_usuario() {
		return fac_usuario;
	}


	public void setFac_usuario(String fac_usuario) {
		this.fac_usuario = fac_usuario;
	}


	public String getFac_autorizacion() {
		return fac_autorizacion;
	}


	public void setFac_autorizacion(String fac_autorizacion) {
		this.fac_autorizacion = fac_autorizacion;
	}


	public String getFac_tipogasto() {
		return fac_tipogasto;
	}


	public void setFac_tipogasto(String fac_tipogasto) {
		this.fac_tipogasto = fac_tipogasto;
	}


	public String getFac_serie() {
		return fac_serie;
	}


	public void setFac_serie(String fac_serie) {
		this.fac_serie = fac_serie;
	}
    
}


