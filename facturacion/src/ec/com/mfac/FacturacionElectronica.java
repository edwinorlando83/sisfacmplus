package ec.com.mfac;

import java.io.File;

import ec.gob.sri.comprobantes.util.ArchivoUtils;
import ec.gob.sri.comprobantes.util.AutorizacionComprobantesWs;
import ec.gob.sri.comprobantes.util.EnvioComprobantesWs;
import ec.gob.sri.comprobantes.view.formas.comprobantes.XAdESBESSignature;
import ec.gob.sri.comprobantes.ws.Comprobante;
import ec.gob.sri.comprobantes.ws.Mensaje;
import ec.gob.sri.comprobantes.ws.RespuestaSolicitud;
import ec.gob.sri.comprobantes.ws.RespuestaSolicitud.Comprobantes;

/**
 * @author Orlando Clase que permite llamar al metodo de autizacion de
 *         documentos electronicos
 */
public class FacturacionElectronica {

	private byte[] archivop12;
	private String password;
	private byte[] xml;
	private byte[] logo;

	public FacturacionElectronica(byte[] archivop12, String password, byte[] xml) {
		this.setArchivop12(archivop12);
		this.setPassword(password);
		this.setXml(xml);

	}

	public FacturacionElectronica(byte[] archivop12, String password, byte[] xml, byte[] logo) {
		this.setArchivop12(archivop12);
		this.setPassword(password);
		this.setXml(xml);
		this.setLogo(logo);

	}

	public FacturacionElectronica() {

	}

	public byte[] getXml() {
		return xml;
	}

	public void setXml(byte[] xml) {
		this.xml = xml;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte[] getArchivop12() {
		return archivop12;
	}

	public void setArchivop12(byte[] archivop12) {
		this.archivop12 = archivop12;
	}

	/**
	 * Esta funcion permite consultar el estado de un documento electronico en
	 * el SRI AMBIENTE DE PRODUCCION
	 * 
	 * @param clave_acceso
	 * @return MensajeSri objecto con los datos devueltos del servico web del
	 *         SRI.
	 * @throws Exception
	 */
	public MensajeSri consultarEnProduccion(String clave_acceso) throws Exception {
		MensajeSri mensajesri = AutorizacionComprobantesWs.autorizarComprobanteIndividual(clave_acceso);
		return mensajesri;
	}

	/**
	 * Esta funcion permite consultar el estado de un documento electronico en
	 * el SRI AMBIENTE DE PRUBEAS
	 * 
	 * @param clave_acceso
	 * @return MensajeSri objecto con los datos devueltos del servico web del
	 *         SRI.
	 * @throws Exception
	 */
	public MensajeSri consultarEnPruebas(String clave_acceso) throws Exception {
		MensajeSri mensajesri = AutorizacionComprobantesWs.autorizarComprobanteIndividual(clave_acceso );
		return mensajesri;
	}

	/**
	 * Esta funcion permite consultar el estado de un documento electronico en
	 * el SRI
	 * 
	 * @param clave_acceso
	 * @param tipoAmbiente
	 *            1Prubeas, 2 Produccion
	 * @return MensajeSri objecto con los datos devueltos del servico web del
	 *         SRI.
	 * @throws Exception
	 */
	public MensajeSri consultar(String clave_acceso, String tipoAmbiente) throws Exception {
		MensajeSri mensajesri = AutorizacionComprobantesWs.autorizarComprobanteIndividual(clave_acceso );
		return mensajesri;
	}

	/**
	 * Envia un documento electronico [xml], para ser autorizado por el SRI. En
	 * el xml debe estar especificado si el ambiente es de pruebas o de
	 * produccion
	 * 
	 * @return MensajeSri objecto con los resultados devueltos por el SRI.
	 * @throws Exception
	 */
	public MensajeSri enviar() throws Exception {
		MensajeSri mensajesri = new MensajeSri();
		File archivoFirmado = XAdESBESSignature.firmar(xml, archivop12, password);
		if (archivoFirmado == null) {
			String clave_acceso = ArchivoUtils.obtenerValorXML(xml, "/*/infoTributaria/claveAcceso");
			
			mensajesri.setClave_acceso(clave_acceso);
			mensajesri.setAutorizado(false);
			mensajesri.setEstado("ERROR");
			mensajesri.setMensaje("Los datos de la firma digital no son correctos ");
			System.out.println("Los datos de la firma digital no son correctos ");
			return mensajesri;
		}
		else
		{
		  mensajesri = enviarDocumento(archivoFirmado);
		  archivoFirmado.delete();
			 

		}

		return mensajesri;
	}

	/**
	 * Esta funci�n permite enviar un documento electr�nico hacia el Sri
	 * 
	 * @param archivoFirmado
	 * @param tipoAmbiente
	 * @param rucEmisor
	 * @return
	 */
	public MensajeSri enviarDocumento(File archivoFirmado) {

		MensajeSri mensajesri = new MensajeSri();
		try {

			RespuestaSolicitud respuestaRecepcion = new RespuestaSolicitud();
			String clave_acceso = ArchivoUtils.obtenerValorXML(archivoFirmado, "/*/infoTributaria/claveAcceso");
			String tipoAmbiente = ArchivoUtils.obtenerValorXML(archivoFirmado, "/*/infoTributaria/ambiente");
			mensajesri.setAutorizado(false);
			mensajesri.setClave_acceso(clave_acceso);

			String url;

			url = UrlSri.devuelveUrlWs(tipoAmbiente, "RecepcionComprobantes");

			respuestaRecepcion = EnvioComprobantesWs.obtenerRespuestaEnvio(archivoFirmado, clave_acceso, url);

			mensajesri.setEstado(respuestaRecepcion.getEstado());

			Comprobantes obj = respuestaRecepcion.getComprobantes();

			if (obj.getComprobante().size() > 0) {
				Comprobante comp = obj.getComprobante().get(0);

				for (Mensaje mensaje : comp.getMensajes().getMensaje()) {

					mensajesri.setEstado("ERROR");

					String msg = "";

					if (mensaje.getMensaje() != null)
						msg += mensaje.getMensaje();

					if (mensaje.getInformacionAdicional() != null)
						msg += "    " + mensaje.getInformacionAdicional();
					mensajesri.setMensaje(msg);
				}
			}
			// ERROR SECUENCIAL REGISTRADO
			String estado = respuestaRecepcion.getEstado();
			if (estado.equals("RECIBIDA") || mensajesri.getMensaje().equals("CLAVE ACCESO REGISTRADA")) {
				Thread.sleep(1200);
				mensajesri = consultar(clave_acceso, tipoAmbiente);
			} else if (respuestaRecepcion.getEstado().equals("DEVUELTA")) {
				if (respuestaRecepcion.getComprobantes() != null) {
					if (respuestaRecepcion.getComprobantes().getComprobante().get(0) != null) {
						String v_mensaje = "";
						for (Mensaje Msg : respuestaRecepcion.getComprobantes().getComprobante().get(0).getMensajes()
								.getMensaje()) {
							if (Msg.getMensaje() != null)
								v_mensaje = Msg.getMensaje();
							if (Msg.getInformacionAdicional() != null)
								v_mensaje += "  " + Msg.getInformacionAdicional();
						}
						mensajesri.setMensaje(v_mensaje);
						mensajesri.setEstado("ERROR");
						mensajesri.setClave_acceso(
								respuestaRecepcion.getComprobantes().getComprobante().get(0).getClaveAcceso());
					}

				}
			}
			if (mensajesri.getEstado().equals("ERROR"))
				System.err.println(mensajesri.getMensaje() + "  " + mensajesri.getClave_acceso());
		} catch (Exception e) {
			mensajesri = null;
			System.err.println("ERROR CONECCION SRI  "  );
		}
		return mensajesri;
	}

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

}
