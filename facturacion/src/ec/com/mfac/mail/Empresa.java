package ec.com.mfac.mail;

public class Empresa {

	private String codemp;
	private String detallemail;
	private byte[] imagenlogo;
	private String mail_server;
	private String mail_port;
	private String mail_userid;
	private String mail_authmethod;
	private String maiL_characterset;
	private String mail_password;
	private String temamail;
	private String pathelec;
	private String nomemp;

	private String ruta_procesados, ruta_noprocesados;
	private byte[] firma;
	private String clave;
	
 
	private String formato_nc;
	private String formato_nd;
	private String formato_gu;
	private String formato_rt;
	private String formato_fc;

	public String getCodemp() {
		return codemp;
	}

	public String getDetallemail() {
		return detallemail;
	}

	public byte[] getImagenlogo() {
		return imagenlogo;
	}

	public String getMail_server() {
		return mail_server;
	}

	public String getMail_port() {
		return mail_port;
	}

	public String getMail_userid() {
		return mail_userid;
	}

	public String getMail_authmethod() {
		return mail_authmethod;
	}

	public String getMaiL_characterset() {
		return maiL_characterset;
	}

	public String getMail_password() {
		return mail_password;
	}

	public String getTemamail() {
		return temamail;
	}

	public void setCodemp(String codemp) {
		this.codemp = codemp;
	}

	public void setDetallemail(String detallemail) {
		this.detallemail = detallemail;
	}

	public void setImagenlogo(byte[] imagenlogo) {
		this.imagenlogo = imagenlogo;
	}

	public void setMail_server(String mail_server) {
		this.mail_server = mail_server;
	}

	public void setMail_port(String mail_port) {
		this.mail_port = mail_port;
	}

	public void setMail_userid(String mail_userid) {
		this.mail_userid = mail_userid;
	}

	public void setMail_authmethod(String mail_authmethod) {
		this.mail_authmethod = mail_authmethod;
	}

	public void setMaiL_characterset(String maiL_characterset) {
		this.maiL_characterset = maiL_characterset;
	}

	public void setMail_password(String mail_password) {
		this.mail_password = mail_password;
	}

	public void setTemamail(String temamail) {
		this.temamail = temamail;
	}

	public String getNomemp() {
		return nomemp;
	}

	public void setNomemp(String nomemp) {
		this.nomemp = nomemp;
	}

	public String getPathelec() {
		return pathelec;
	}

	public void setPathelec(String pathelec) {
		this.pathelec = pathelec;
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

	public byte[] getFirma() {
		return firma;
	}

	public void setFirma(byte[] firma) {
		this.firma = firma;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getFormato_nc() {
		return formato_nc;
	}

	public void setFormato_nc(String formato_nc) {
		this.formato_nc = formato_nc;
	}

	public String getFormato_nd() {
		return formato_nd;
	}

	public void setFormato_nd(String formato_nd) {
		this.formato_nd = formato_nd;
	}

	public String getFormato_gu() {
		return formato_gu;
	}

	public void setFormato_gu(String formato_gu) {
		this.formato_gu = formato_gu;
	}

	public String getFormato_rt() {
		return formato_rt;
	}

	public void setFormato_rt(String formato_rt) {
		this.formato_rt = formato_rt;
	}

	public String getFormato_fc() {
		return formato_fc;
	}

	public void setFormato_fc(String formato_fc) {
		this.formato_fc = formato_fc;
	}

}
