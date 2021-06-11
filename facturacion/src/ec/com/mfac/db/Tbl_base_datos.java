package ec.com.mfac.db;

public class Tbl_base_datos {

	
	private String path_bd;
	private String acceso;
	private String codigo;
	private String carpeta;
	private byte[] p12;
	
	private boolean hilopropio;
	
	public String getPath_bd() {
		return path_bd;
	}
	public void setPath_bd(String path_bd) {
		this.path_bd = path_bd;
	}
	public String getAcceso() {
		return acceso;
	}
	public void setAcceso(String acceso) {
		this.acceso = acceso;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getCarpeta() {
		return carpeta;
	}
	public void setCarpeta(String carpeta) {
		this.carpeta = carpeta;
	}
	public boolean isHilopropio() {
		return hilopropio;
	}
	public void setHilopropio(boolean hilopropio) {
		this.hilopropio = hilopropio;
	}
	public byte[] getP12() {
		return p12;
	}
	public void setP12(byte[] p12) {
		this.p12 = p12;
	}
	
	
}
