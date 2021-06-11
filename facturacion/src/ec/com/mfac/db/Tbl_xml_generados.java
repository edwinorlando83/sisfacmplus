package ec.com.mfac.db;

public class Tbl_xml_generados {
	
	/**
	 * 
	 */
	private String clave_acceso;
	private byte[] xml;
	private String id_cliente;
	private String estado;
	
	public String getClave_acceso() {
		return clave_acceso;
	}
	public void setClave_acceso(String clave_acceso) {
		this.clave_acceso = clave_acceso;
	}
	public byte[] getXml() {
		return xml;
	}
	public void setXml(byte[] xml) {
		this.xml = xml;
	}
	public String getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(String id_cliente) {
		this.id_cliente = id_cliente;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
