package ec.gob.sri.comprobantes.util;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.namespace.QName;

import com.thoughtworks.xstream.XStream;

import ec.com.mfac.MensajeSri;
import ec.com.mfac.UrlSri;
import ec.gob.sri.comprobantes.util.xml.XStreamUtil;
import ec.gob.sri.comprobantes.ws.aut.Autorizacion;
import ec.gob.sri.comprobantes.ws.aut.AutorizacionComprobantes;
import ec.gob.sri.comprobantes.ws.aut.AutorizacionComprobantesService;
import ec.gob.sri.comprobantes.ws.aut.Mensaje;
import ec.gob.sri.comprobantes.ws.aut.RespuestaComprobante;

public class AutorizacionComprobantesWs {
	private AutorizacionComprobantesService service;
	public static final String ESTADO_AUTORIZADO = "AUTORIZADO";
	public static final String ESTADO_NO_AUTORIZADO = "NO AUTORIZADO";

	public AutorizacionComprobantesWs(String wsdlLocation) throws Exception {

		String url= UrlSri.get_wsdlbBinding_Autorizacion();
		this.service = new AutorizacionComprobantesService(new URL(wsdlLocation), new QName("http://ec.gob.sri.ws.autorizacion", 
				url));

	}

	public RespuestaComprobante llamadaWSAutorizacionInd(String claveDeAcceso) {
		RespuestaComprobante response = null;
		try {
			AutorizacionComprobantes port = this.service.getAutorizacionComprobantesPort();
			response = port.autorizacionComprobante(claveDeAcceso);
		} catch (Exception e) {
			
			return response;
		}

		return response;
	}

	public static MensajeSri autorizarComprobanteIndividual(String claveDeAcceso  
			 ) throws Exception {

		MensajeSri mensajesri = new MensajeSri();
		mensajesri.setAutorizado(false);
		mensajesri.setClave_acceso(claveDeAcceso);
 
		String tipoAmbiente  = claveDeAcceso.substring(23, 24);
		RespuestaComprobante respuesta = null;
		String url  ;
 
         url = UrlSri.devuelveUrlWs( tipoAmbiente, "AutorizacionComprobantes");
	 
	  	
		AutorizacionComprobantesWs autorizacioncomprobantesws = new AutorizacionComprobantesWs(	url); 

		respuesta = autorizacioncomprobantesws.llamadaWSAutorizacionInd(claveDeAcceso);


		if (respuesta != null) {

			if (respuesta.getNumeroComprobantes() == null || Integer.valueOf(respuesta.getNumeroComprobantes() )  ==0) {

				mensajesri.setEstado("ERROR");
				mensajesri.setMensaje("NO EXISTE UN REGISTRO RELACIONADO CON LA CLAVE DE ACCESO CONSULTADA");
				return mensajesri;
			}
			
			if (respuesta.getAutorizaciones().getAutorizacion().isEmpty() == true) {

				mensajesri.setEstado("EN PROCESO");
				mensajesri.setMensaje("TRANSMITIDO SIN RESPUESTA|Ha ocurrido un error en el proceso de la Autorizacion");
				return mensajesri;
			}

			int respuestatotal = Integer.valueOf(respuesta.getNumeroComprobantes());
		//	for (Autorizacion item : respuesta.getAutorizaciones().getAutorizacion()) {

		    	Autorizacion item =  respuesta.getAutorizaciones().getAutorizacion().get(0);	
		     
 		 
		    	  
				item.setComprobante("<![CDATA[" + item.getComprobante() + "]]>");

				XStream xstream = XStreamUtil.getRespuestaXStream();
				Writer writer = null;
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				writer = new OutputStreamWriter(outputStream, "UTF-8");
				writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
				xstream.toXML(item, writer);
			 	mensajesri.setArchivoAutorizado(outputStream.toByteArray());			 	
				if (respuestatotal >= 1) {
					mensajesri.setEstado(item.getEstado());
					mensajesri.setNumero_autorizacion(item.getNumeroAutorizacion());					
					mensajesri.setMensaje(obtieneMensajesAutorizacion(item)); 					
				 
					String string = item.getFechaAutorizacion();
					 
					//2001-07-04T12:08:56.235-0700            yyyy-MM-dd'T'HH:mm:ss.SSSZ
					//2017-09-18T15:08:27-05:00
					DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss-SS" );
					Date date = format.parse(string);
					System.out.println(date); 					
				 	mensajesri.setFecha_autorizacion(date);
					
					
				} 		
		//	}
		}

		return mensajesri;
	}

	private static String obtieneMensajesAutorizacion(Autorizacion autorizacion) {
	  StringBuilder mensaje = new StringBuilder();
		 for (Mensaje m : autorizacion.getMensajes().getMensaje()) {
			 if (m.getInformacionAdicional() != null)
			 {
				  mensaje.append("\n" + m.getMensaje() + ":  "  );
			  mensaje.append(  m.getInformacionAdicional());
			 }
			else {
			  mensaje.append("\n" + m.getMensaje());
			}
		}

	 return mensaje.toString();
	}

	public static boolean verificarOCSP(Autorizacion autorizacion) throws SQLException, ClassNotFoundException {
		  boolean respuesta = true;

		  for (Mensaje m : autorizacion.getMensajes().getMensaje()) {
		  if (m.getIdentificador().equals("61")) {
			 
				 respuesta = false;
			}
		}
	 return respuesta;
	}
}
