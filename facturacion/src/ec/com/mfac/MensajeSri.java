package ec.com.mfac;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MensajeSri {
	private String mensaje;
	private String estado;
	private String clave_acceso;
	private Date fecha_autorizacion;
 
	private String numero_autorizacion;
	private  byte[] archivoAutorizado;
	private boolean autorizado;
	public String getMensaje() {
		return mensaje ==null?"":mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getClave_acceso() {
		return clave_acceso;
	}
	public void setClave_acceso(String clave_acceso) {
		this.clave_acceso = clave_acceso;
	}
	public Date getFecha_autorizacion() {
		return fecha_autorizacion;
	}
	public void setFecha_autorizacion(Date fecha_autorizacion) {
		this.fecha_autorizacion = fecha_autorizacion;
	}
	public String getNumero_autorizacion() {
		return numero_autorizacion;
	}
	public void setNumero_autorizacion(String numero_autorizacion) {
		this.numero_autorizacion = numero_autorizacion;
	}
	public byte[] getArchivoAutorizado() {
		return archivoAutorizado;
	}
	public void setArchivoAutorizado(byte[] archivoAutorizado) {
		this.archivoAutorizado = archivoAutorizado;
	}
	public boolean isAutorizado() {
		return autorizado;
	}
	public void setAutorizado(boolean autorizado) {
		this.autorizado = autorizado;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getFecha_autorizacionString()
	{
		SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
	     return dt1.format(this.fecha_autorizacion);
	}

}
