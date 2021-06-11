package ec.com.mfac.mail;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import ec.com.mfac.FacturacionElectronica;
import ec.com.mfac.MensajeSri;
import ec.com.mfac.MicroUtils;
import ec.com.mfac.UrlSri;
import ec.com.mfac.db.DataBaseObject;
import ec.gob.sri.comprobantes.modelo.factura.Factura;
import ec.gob.sri.comprobantes.modelo.factura.Factura.InfoAdicional.CampoAdicional;
import ec.gob.sri.comprobantes.modelo.guia.GuiaRemision;
import ec.gob.sri.comprobantes.modelo.liquidacioncompra.LiquidacionCompras;
import ec.gob.sri.comprobantes.modelo.notacredito.NotaCredito;
import ec.gob.sri.comprobantes.modelo.notadebito.NotaDebito;
import ec.gob.sri.comprobantes.modelo.rentencion.ComprobanteRetencion;
import ec.gob.sri.comprobantes.util.ArchivoUtils;
import ec.gob.sri.comprobantes.util.VisualizacionRideUtil;
import ec.gob.sri.comprobantes.util.xml.XML2Java;

public class EnviarMail {
	String host;
	String username;
	String password;
	String port;
	String nomemp;
	Empresa empresa;

	public static void main(String[] args) {
		UrlSri.ws_produccion_recepcion = "https://cel.sri.gob.ec/comprobantes-electronicos-ws/RecepcionComprobantesOffline?wsdl";
		UrlSri.ws_pruebas_recepcion = "https://celcer.sri.gob.ec/comprobantes-electronicos-ws/RecepcionComprobantesOffline?wsdl";
		UrlSri.ws_pruebas_autorizacion = "https://celcer.sri.gob.ec/comprobantes-electronicos-ws/AutorizacionComprobantesOffline?wsdl";
		UrlSri.ws_produccion_autorizacion = "https://cel.sri.gob.ec/comprobantes-electronicos-ws/AutorizacionComprobantesOffline?wsdl";
		UrlSri.isOffline = true;

		String ruta = null;
		try {

			VisualizacionRideUtil visualizacionrideutil = new VisualizacionRideUtil(null, null);

			FacturacionElectronica fe = new FacturacionElectronica();
			 MensajeSri res = fe.consultarEnProduccion("2909202001180176902500120010100000198790001987917");

		 	ruta = visualizacionrideutil.generarPdf(res.getArchivoAutorizado());

			Empresa empresa2 = new Empresa();
 
				 
				 empresa2.setMail_server("mail.grupo-bastidas.com");
				 empresa2.setMail_userid("facelectronica@grupo-bastidas.com");
				 empresa2.setMail_password("bastidas1945"); 
				 empresa2.setMail_port("587");
				 
				  empresa2.setMail_server("mail.la99radio.com");
				  empresa2.setMail_userid("facturacion@la99radio.com");
				  empresa2.setMail_password("aDmn4sql"); 
				  empresa2.setMail_port("465");	
				  
				  
	 
			/*
			 * empresa2.setMail_server("box1311.bluehost.com");
			 * empresa2.setMail_userid("facturacionelectronica@sunconservation.ec");
			 * empresa2.setMail_password("Sun@2016"); empresa2.setMail_port("465");
			 * 
			 * 
			 * 
			 * 
			 * empresa2.setMail_server("smtp.office365.com");
			 * empresa2.setMail_userid("edwin_orlando83@hotmail.com");
			 * empresa2.setMail_password("adryadry"); empresa2.setMail_port("587");
			 * 
			 * 
			 * empresa2.setMail_server("smtp.gmail.com");
			 * empresa2.setMail_userid("edwinorlando83@gmail.com");
			 * empresa2.setMail_password("j03lal3j0"); empresa2.setMail_port("587");
			 * 
			 * /* empresa2.setMail_server("smtp.gmail.com");
			 * empresa2.setMail_userid("facturacionautopartesmolina@gmail.com");
			 * empresa2.setMail_password("mariapazluisantonio");
			 * empresa2.setMail_port("587");
			 */

			EnviarMail enviarmail = new EnviarMail(empresa2);
			enviarmail.test(new File(ruta));

		} catch (Exception er) {
			System.out.println(er);
		}

	}

	public EnviarMail(Empresa empresa) {
		this.empresa = empresa;
		String inhost = empresa.getMail_server();
		String inusername = empresa.getMail_userid();
		String inpassword = empresa.getMail_password();
		String inport = empresa.getMail_port();

		host = inhost;
		username = inusername;
		password = inpassword;
		port = inport;
		nomemp = empresa.getNomemp();

	}

	public void test(File archivoPDF) {

		String mail_destino = "edwin_orlando83@hotmail.com";
		try {
			// String txt = sendMail(mail_destino, "Aunto test", "Mensaje Text", null, null,
			// null);
			String txt = sendMail(mail_destino, empresa.getTemamail(), "correo de prueba", null, archivoPDF, null);
			System.out.println(txt);
			System.out.println(mail_destino);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	private String sendMail(String mail_destino, String Asunto, String Mensaje, String mailcc, File archivoPDF,
			File archivoXml) throws Exception {

		if (Asunto == null)
			Asunto = "Envio de Factura";
		if (Asunto.trim().isEmpty())
			Asunto = "Envio de Factura";

		String resultado = ""; 
		Properties props = new Properties();

 props.put("mail.smtp.ssl.trust", host);
	 //	props.put("mail.smtp.UseDefaultCredentials ", true);
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);	 	
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.timeout", 3000);
	 
		props.put("mail.smtp.starttls.enable", true);
	 
		if (port.trim().equals("465")) {
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.starttls.enable", true);
		}
		
		if ( username.contains("gmail") ) {
			props.put("mail.smtp.starttls.enable", true);
		    props.put("mail.smtp.user", username);
		    props.put("mail.smtp.clave", password); 
		}

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
	 
		 

		try {

			BodyPart messageBodyPart = new MimeBodyPart();
			// messageBodyPart.setText(Mensaje);
			messageBodyPart.setContent(Mensaje, "text/html; charset=utf-8");
			Multipart multipart = new MimeMultipart();

			multipart.addBodyPart(messageBodyPart);

			messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText(Mensaje);

			if (archivoPDF != null) {
				messageBodyPart = new MimeBodyPart();
				DataSource source = new FileDataSource(archivoPDF.getAbsolutePath());
				messageBodyPart.setDataHandler(new DataHandler(source));
				messageBodyPart.setFileName(archivoPDF.getName());
				multipart.addBodyPart(messageBodyPart);
			}

			if (archivoXml != null) {
				messageBodyPart = new MimeBodyPart();
				DataSource source = new FileDataSource(archivoXml.getAbsolutePath());
				messageBodyPart.setDataHandler(new DataHandler(source));
				messageBodyPart.setFileName(archivoXml.getName());
				multipart.addBodyPart(messageBodyPart);
			}
			
			String nombreEmpresa = "Facturación Electrónica";
			if( empresa.getNomemp() !=null)
			{
				nombreEmpresa = empresa.getNomemp() + 	"Facturación Electrónica" ;
			}

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username,nombreEmpresa ));
	 
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail_destino));

			if (mailcc != null && !mailcc.trim().isEmpty())
				message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(mailcc));

			message.setSubject(Asunto);
			message.setContent(multipart);

			Transport.send(message);
			resultado = "Enviado";
		} catch (Exception err) {
			if (!err.getMessage().contains("Exception reading response"))
				resultado = err.getMessage();
			else
				resultado = "Enviado";

		}
		return resultado;
	}

	public String enviarMailaDestinatario(byte[] xmlAutorizado, String claveAceso) {

		String res = "Error al enviar el mail";
		try {
			String tmpDir = System.getProperty("java.io.tmpdir");
			String rutaArchivo = tmpDir + File.separator + claveAceso + ".xml";
			File xmlFile = new File(rutaArchivo);
			FileOutputStream outputStream = new FileOutputStream(xmlFile);
			outputStream.write(xmlAutorizado);
			outputStream.close();

			MicroUtils mu = new MicroUtils();
			byte[] inlogo = null;
			inlogo = mu.getlogo(claveAceso.substring(10, 23), claveAceso.substring(24, 27));

			if (inlogo == null) {
				inlogo = empresa.getImagenlogo();
			}

			VisualizacionRideUtil visualizacionrideutil = new VisualizacionRideUtil(inlogo, tmpDir);
			String spdfFile = visualizacionrideutil.generarPdf(xmlAutorizado, empresa);

			File pdfFile = new File(spdfFile);

			String tipo = ArchivoUtils.obtenerTipoComprobante(xmlAutorizado);

			String comprobante = "";
			String cliente = "";
			String correo = "";
			String secuencial = "";
			if (tipo.equalsIgnoreCase("FA"))
			{
				comprobante = "FACTURA";
				Factura obj = XML2Java.unmarshalFactura(xmlAutorizado);
				cliente = obj.getInfoFactura().getRazonSocialComprador();
				for (CampoAdicional info : obj.getInfoAdicional().getCampoAdicional()) {
					if (info.getNombre().equalsIgnoreCase("CORREOELECTRONICO"))
						correo = info.getValue();
				}
				secuencial = obj.getInfoTributaria().getSecuencial();
			}
			if (tipo.equalsIgnoreCase("CR"))

			{
				comprobante = "RETENCI&Oacute;N";

				ComprobanteRetencion nd = XML2Java.unmarshalComprobanteRetencion(xmlAutorizado);
				cliente = nd.getInfoCompRetencion().getRazonSocialSujetoRetenido();

				for (ec.gob.sri.comprobantes.modelo.rentencion.ComprobanteRetencion.InfoAdicional.CampoAdicional infoa : nd
						.getInfoAdicional().getCampoAdicional()) {
					if (infoa.getNombre().equalsIgnoreCase("CORREOELECTRONICO"))
						correo = infoa.getValue();
				}

				secuencial = nd.getInfoTributaria().getSecuencial();

			}
			if (tipo.equalsIgnoreCase("NC"))

			{
				comprobante = "NOTA DE CR&Eacute;DITO";

				NotaCredito nd = XML2Java.unmarshalNotaCredito(xmlAutorizado);
				cliente = nd.getInfoNotaCredito().getRazonSocialComprador();
				for (ec.gob.sri.comprobantes.modelo.notacredito.NotaCredito.InfoAdicional.CampoAdicional infoa : nd
						.getInfoAdicional().getCampoAdicional()) {
					if (infoa.getNombre().equalsIgnoreCase("CORREOELECTRONICO"))
						correo = infoa.getValue();
				}
				secuencial = nd.getInfoTributaria().getSecuencial();
			}
			if (tipo.equalsIgnoreCase("ND"))

			{
				comprobante = "NOTA DE D&Eacute;BITO";

				NotaDebito nd = XML2Java.unmarshalNotaDebito(xmlAutorizado);
				cliente = nd.getInfoNotaDebito().getRazonSocialComprador();

				for (ec.gob.sri.comprobantes.modelo.notadebito.NotaDebito.InfoAdicional.CampoAdicional infoa : nd
						.getInfoAdicional().getCampoAdicional()) {
					if (infoa.getNombre().equalsIgnoreCase("CORREOELECTRONICO"))
						correo = infoa.getValue();
				}
				secuencial = nd.getInfoTributaria().getSecuencial();
			}

			if (tipo.equalsIgnoreCase("GR"))

			{
				comprobante = "GUIA  DE REMISI&Oacute;N";

				GuiaRemision gr = XML2Java.unmarshalGuiaRemision(xmlAutorizado);

				cliente = gr.getInfoGuiaRemision().getRazonSocialTransportista();
				for (ec.gob.sri.comprobantes.modelo.guia.GuiaRemision.InfoAdicional.CampoAdicional infoa : gr
						.getInfoAdicional().getCampoAdicional()) {
					if (infoa.getNombre().equalsIgnoreCase("CORREOELECTRONICO"))
						correo = infoa.getValue();
				}

				secuencial = gr.getInfoTributaria().getSecuencial();

			}
			if (tipo.equalsIgnoreCase("LC"))

			{
				comprobante = "LIQUIDACI&Oacute;N DE COMPRAS";

				LiquidacionCompras gr = XML2Java.unmarshalLiquidacionCompra(xmlAutorizado);

				cliente = gr.getInfoLiquidacionCompra().getRazonSocialProveedor();

				for (ec.gob.sri.comprobantes.modelo.liquidacioncompra.LiquidacionCompras.InfoAdicional.CampoAdicional info : gr
						.getInfoAdicional().getCampoAdicional()) {
					if (info.getNombre().equalsIgnoreCase("CORREOELECTRONICO"))
						correo = info.getValue();

				}
				secuencial = gr.getInfoTributaria().getSecuencial();

			}

			// if(mail_destino!=null )
			// if( mail_destino.equalsIgnoreCase("sincorreo@correo.com"))
			// return mail_destino;

			String msg = empresa.getDetallemail() + "<br> <br> Estimado(a), <br> <b>" + cliente + " </b> <br>"
					+ " Enviamos el comprobante electrónico:  <br> " + " Comprobante: <b> " + comprobante
					+ " </b>  <br> " + " Número Documento : <b>" + secuencial + "</b>  <br> "

					+ "Adjuntamos el comprobante en formato:<b> XML y PDF <br></b> "

			;
			update_tbl_sri_autorizados(claveAceso);

			if (!correo.equalsIgnoreCase("correo@correo.com") && !correo.equalsIgnoreCase("sincorreo@correo.com")) {
				res = sendMail(correo, empresa.getTemamail(), msg, null, pdfFile, xmlFile);
				System.out.println("Correo " + res + "==>" + correo);

			} else {
				System.out.println("No se envio a:" + correo);
			}
			// pdfFile.delete();
			// xmlFile.delete();

		} catch (Exception e) {
			res = e.getMessage();
		}

		return res;
	}

	private void update_tbl_sri_autorizados(String claveacceso) throws Exception {
		DataBaseObject databaseobject;
		databaseobject = new DataBaseObject();
		String sql = "update tbl_sri_autorizados set  mail_enviado='1' where claveacceso='" + claveacceso + "'";
		databaseobject.SQL_COMMAND(sql);

	}
}
