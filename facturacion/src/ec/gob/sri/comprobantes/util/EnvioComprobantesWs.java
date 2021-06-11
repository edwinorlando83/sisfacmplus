package ec.gob.sri.comprobantes.util;

import java.io.File;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.namespace.QName;

import ec.com.mfac.UrlSri;
import ec.gob.sri.comprobantes.ws.Comprobante;
import ec.gob.sri.comprobantes.ws.Mensaje;
import ec.gob.sri.comprobantes.ws.RecepcionComprobantes;
import ec.gob.sri.comprobantes.ws.RecepcionComprobantesService;
import ec.gob.sri.comprobantes.ws.RespuestaSolicitud;

public class EnvioComprobantesWs {
	private static RecepcionComprobantesService service;

	public static final String ESTADO_RECIBIDA = "RECIBIDA";
	public static final String ESTADO_DEVUELTA = "DEVUELTA";

	public EnvioComprobantesWs(String wsdlLocation) throws Exception {
  URL url = new URL(wsdlLocation);

 
  QName qname = new QName("http://ec.gob.sri.ws.recepcion",  UrlSri.get_RecepcionComprobantes() );
 
		service = new RecepcionComprobantesService(url, qname);
	}
	 
 
 
	public RespuestaSolicitud enviarComprobante(  File xmlFile ) {
	   RespuestaSolicitud response = null;
		try {
			RecepcionComprobantes port = service.getRecepcionComprobantesPort();
			response = port.validarComprobante(ArchivoUtils.archivoToByte(xmlFile));
		} catch (Exception e) {
		
			response = new RespuestaSolicitud();
			response.setEstado(e.getMessage());
			 
		}

		return response;
	}

	public RespuestaSolicitud enviarComprobante(String ruc, byte[] xml, String tipoComprobante, String versionXsd) {
		RespuestaSolicitud response = null;
		try {
			RecepcionComprobantes port = service.getRecepcionComprobantesPort();
			response = port.validarComprobante(xml);
		} catch (Exception e) {
			Logger.getLogger(EnvioComprobantesWs.class.getName()).log(Level.SEVERE, null, e);
			response = new RespuestaSolicitud();
			response.setEstado(e.getMessage());
			return response;
		}
		return response;
	}

	public static RespuestaSolicitud obtenerRespuestaEnvio(File archivo ,
			String claveDeAcceso, String urlWsdl) {
		RespuestaSolicitud respuesta = new RespuestaSolicitud();
		EnvioComprobantesWs cliente = null;
		try {

			String certif = System.getProperty("java.home") + "/lib/security/cacerts".replace('/', File.separatorChar);
			System.setProperty("javax.net.ssl.trustStore", certif);
			System.setProperty("javax.net.ssl.keyStorePassword", "changeit");
			System.setProperty("javax.net.ssl.trustStore", certif);
			System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
			cliente = new EnvioComprobantesWs(urlWsdl);			
			respuesta = cliente.enviarComprobante(  archivo );
			if( respuesta==null)
				respuesta = new RespuestaSolicitud();
			
		} catch (Exception ex) {
		 
			respuesta.setEstado(ex.getMessage());
		 
			
		}
		
		return respuesta;
	}

	public static void guardarRespuesta(String claveDeAcceso, String archivo, String estado, java.util.Date fecha) {

	}

	public static String obtenerMensajeRespuesta(RespuestaSolicitud respuesta) {
		StringBuilder mensajeDesplegable = new StringBuilder();
		if (respuesta.getEstado().equals("DEVUELTA") == true) {
			RespuestaSolicitud.Comprobantes comprobantes = respuesta.getComprobantes();
			for (Comprobante comp : comprobantes.getComprobante()) {
				mensajeDesplegable.append(comp.getClaveAcceso());
				mensajeDesplegable.append("\n");
				for (Mensaje m : comp.getMensajes().getMensaje()) {
					mensajeDesplegable.append(m.getMensaje()).append(" :\n");
					mensajeDesplegable.append(m.getInformacionAdicional() != null ? m.getInformacionAdicional() : "");
					mensajeDesplegable.append("\n");
				}
				mensajeDesplegable.append("\n");
			}
		}
		return mensajeDesplegable.toString();
	}
}
