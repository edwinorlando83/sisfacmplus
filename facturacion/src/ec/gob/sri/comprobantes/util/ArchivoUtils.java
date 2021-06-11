package ec.gob.sri.comprobantes.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import ec.gob.sri.comprobantes.modelo.factura.Factura;
import ec.gob.sri.comprobantes.modelo.factura.Factura.InfoFactura.TotalConImpuestos.TotalImpuesto;
import ec.gob.sri.comprobantes.modelo.notacredito.NotaCredito;
import ec.gob.sri.comprobantes.util.xml.Java2XML;
import ec.gob.sri.comprobantes.util.xml.LectorXPath;
import ec.gob.sri.comprobantes.util.xml.ValidadorEstructuraDocumento;
import ec.gob.sri.comprobantes.util.xml.XML2Java;
import ec.gob.sri.comprobantes.ws.RespuestaSolicitud;

public class ArchivoUtils {

	public static File stringToArchivo(String path, String contenidoArchivo) {
		/* 97 */ FileOutputStream fos = null;

		File archivoCreado = null;

		try {

			archivoCreado = File.createTempFile("temp-file-name", ".xml");
			fos = new FileOutputStream(archivoCreado);
			OutputStreamWriter out = new OutputStreamWriter(fos, "UTF-8");
			for (int i = 0; i < contenidoArchivo.length(); i++) {
				out.write(contenidoArchivo.charAt(i));
			}
			out.close();

		} catch (Exception ex) {

			Logger.getLogger(ArchivoUtils.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		} finally {
			try {
				if (fos != null)/* 117 */ fos.close();
			} catch (Exception ex) {
				Logger.getLogger(ArchivoUtils.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

		return archivoCreado;
	}

	public static byte[] archivoToByte(File file) throws IOException {
		/* 136 */ byte[] buffer = new byte[(int) file.length()];
		/* 137 */ InputStream ios = null;
		try {
			/* 139 */ ios = new FileInputStream(file);
			/* 140 */ if (ios.read(buffer) == -1)
				/* 141 */ throw new IOException("EOF reached while trying to read the whole file");
		} finally {
			try {
				/* 145 */ if (ios != null)/* 146 */ ios.close();
			} catch (IOException e) {
				/* 149 */ Logger.getLogger(ArchivoUtils.class.getName()).log(Level.SEVERE, null, e);
			}
		}

		/* 153 */ return buffer;
	}

	public static File byteToFile(byte[] arrayBytes, String rutaArchivo) {
		File file = null;
		try {
			file = new File(rutaArchivo);
			file.createNewFile();
			FileInputStream fileInputStream = new FileInputStream(rutaArchivo);
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(arrayBytes);
			OutputStream outputStream = new FileOutputStream(rutaArchivo);
			int data;
			while ((data = byteArrayInputStream.read()) != -1) {
				outputStream.write(data);
			}

			fileInputStream.close();
			outputStream.close();

		} catch (IOException ex) {
			Logger.getLogger(ArchivoUtils.class.getName()).log(Level.SEVERE, null, ex);
		}
		return file;
	}

	public static String obtenerValorXML(byte[] xmlDocument, String expression) {
		String valor = null;
		try {

			LectorXPath reader = new LectorXPath(xmlDocument);
			valor = (String) reader.leerArchivo(expression, XPathConstants.STRING);
		} catch (Exception e) {

		}

		return valor;
	}

	/**
	 * Devuelve el porcentaje de IVA en Facturas o Notas de Credito AUTORIZADOS
	 * 
	 * @param xmlDocument
	 * @return
	 * @author Orlando Cholota
	 */
	public static String obtenerPorcentajeIVA_AUTORIZADO(byte[] xmlDocument) {
		String ivaporcentaje = null;
		try {

			String tipoDeDocumento = obtenerTipoComprobante(xmlDocument);

			if (tipoDeDocumento.equalsIgnoreCase("FA")) {
				Factura f = XML2Java.unmarshalFactura(xmlDocument);	
				ivaporcentaje = f.getIvaPorcentaje();
 
			}
			
			if (tipoDeDocumento.equalsIgnoreCase("NC")) {
				NotaCredito notacredito = XML2Java.unmarshalNotaCredito(xmlDocument);			 
				ivaporcentaje = notacredito.getIvaPorcentaje();
			}
			

		} catch (Exception e) {
			System.out.println("=="+e.getMessage());
		}

		return ivaporcentaje;
	}

	
	/**
	 * Devuelve el porcentaje de IVA en Facturas o Notas de Credito  GENERADOS
	 * 
	 * @param xmlDocument
	 * @return
	 * @author Orlando Cholota
	 */
	public static String obtenerPorcentajeIVA_GENERADOS(byte[] xmlDocument) {
		String ivaporcentaje = null;
		try {

			String tipoDeDocumento = obtenerTipoComprobante(xmlDocument);

			if (tipoDeDocumento.equalsIgnoreCase("FA")) {
				Factura f = XML2Java.unmarshalFactura(xmlDocument);			 
				for (TotalImpuesto totalimpuesto : f.getInfoFactura().getTotalConImpuestos().getTotalImpuesto()) {
					if (totalimpuesto.getCodigoPorcentaje().trim().equals("2")) {
						ivaporcentaje = "12";
					}
					if (totalimpuesto.getCodigoPorcentaje().trim().equals("3")) {
						ivaporcentaje = "14";
					}
				}
			}
			
			if (tipoDeDocumento.equalsIgnoreCase("FA")) {
				Factura f = XML2Java.unmarshalFactura(xmlDocument);			 
				for (TotalImpuesto totalimpuesto : f.getInfoFactura().getTotalConImpuestos().getTotalImpuesto()) {
					if (totalimpuesto.getCodigoPorcentaje().trim().equals("2")) {
						ivaporcentaje = "12";
					}
					if (totalimpuesto.getCodigoPorcentaje().trim().equals("3")) {
						ivaporcentaje = "14";
					}
				}
			}
			

		} catch (Exception e) {
			System.out.println("sss"+e.getMessage());
		}

		return ivaporcentaje;
	}
	
	public static String obtenerValorXML(File xmlDocument, String expression) {
		String valor = null;

		LectorXPath reader = new LectorXPath(xmlDocument.getPath());
		valor = (String) reader.leerArchivo(expression, XPathConstants.STRING);
		if (valor != null)
			valor = valor.trim();

		return valor;
	}

	public static String obtenerValorXMLDesdeByte(byte[] xmlbyte, String expression) {
		/* 195 */ String valor = null;
		try {
			/* 198 */ // System.out.println("el xmlDocument es:
						// "+xmlDocument.getPath());
			LectorXPath reader = new LectorXPath(xmlbyte);
			/* 199 */ valor = (String) reader.leerArchivo(expression, XPathConstants.STRING);
		} catch (Exception e) {
			/* 202 */
			// Logger.getLogger(ArchivoUtils.class.getName()).log(Level.SEVERE,
			// null, e);

		}

		/* 205 */ return valor;
	}

	public static String seleccionaXsd(String tipo) {
		/* 215 */ String nombreXsd = null;

		/* 217 */ if (tipo.equals(TipoComprobanteEnum.FACTURA.getCode()))
			/* 218 */ nombreXsd = TipoComprobanteEnum.FACTURA.getXsd();
		/* 219 */ else if (tipo.equals(TipoComprobanteEnum.COMPROBANTE_DE_RETENCION.getCode()))
			/* 220 */ nombreXsd = TipoComprobanteEnum.COMPROBANTE_DE_RETENCION.getXsd();
		/* 221 */ else if (tipo.equals(TipoComprobanteEnum.GUIA_DE_REMISION.getCode()))
			/* 222 */ nombreXsd = TipoComprobanteEnum.GUIA_DE_REMISION.getXsd();
		/* 223 */ else if (tipo.equals(TipoComprobanteEnum.NOTA_DE_CREDITO.getCode()))
			/* 224 */ nombreXsd = TipoComprobanteEnum.NOTA_DE_CREDITO.getXsd();
		/* 225 */ else if (tipo.equals(TipoComprobanteEnum.NOTA_DE_DEBITO.getCode()))
			/* 226 */ nombreXsd = TipoComprobanteEnum.NOTA_DE_DEBITO.getXsd();
		/* 227 */ else if (tipo.equals(TipoComprobanteEnum.LOTE.getCode())) {
			/* 228 */ nombreXsd = TipoComprobanteEnum.LOTE.getXsd();
		}

		/* 231 */ return nombreXsd;
	}

	public static String validaArchivoXSD(String tipoComprobante, String pathArchivoXML) {
		/* 346 */ String respuestaValidacion = null;
		try {
			/* 350 */ ValidadorEstructuraDocumento validador = new ValidadorEstructuraDocumento();
			/* 351 */ String nombreXsd = seleccionaXsd(tipoComprobante);

			/* 353 */ String pathArchivoXSD = "resources/xsd/" + nombreXsd;

			/* 355 */ if (pathArchivoXML != null) {
				/* 356 */ validador.setArchivoXML(new File(pathArchivoXML));
				/* 357 */ validador.setArchivoXSD(new File(pathArchivoXSD));

				/* 359 */ respuestaValidacion = validador.validacion();
			}
		} catch (Exception ex) {
			/* 362 */ Logger.getLogger(ArchivoUtils.class.getName()).log(Level.SEVERE, null, ex);
		}
		/* 364 */ return respuestaValidacion;
	}

 

	public static String decodeArchivoBase64(String pathArchivo) {
		/* 458 */ String xmlDecodificado = null;
		try {
			/* 460 */ File file = new File(pathArchivo);
			/* 461 */ if (file.exists()) {
				/* 463 */ String encd = obtenerValorXML(file, "/*/comprobante");

				/* 466 */ xmlDecodificado = encd;
			} else {
				/* 469 */ System.out.print("File not found!");
			}
		} catch (Exception e) {
			/* 472 */ Logger.getLogger(AutorizacionComprobantesWs.class.getName()).log(Level.SEVERE, null, e);
		}
		/* 474 */ return xmlDecodificado;
	}

	public static boolean anadirMotivosRechazo(File archivo, RespuestaSolicitud respuestaRecepcion) {
		/* 489 */ boolean exito = false;
		/* 490 */ File respuesta = new File("respuesta.xml");
		/* 491 */ Java2XML.marshalRespuestaSolicitud(respuestaRecepcion, respuesta.getPath());
		/* 492 */ if (adjuntarArchivo(respuesta, archivo) == true) {
			/* 493 */ exito = true;
			/* 494 */ respuesta.delete();
		}
		/* 496 */ return exito;
	}

	public static boolean adjuntarArchivo(File respuesta, File comprobante) {
		/* 507 */ boolean exito = false;
		try {
			/* 510 */ Document document = merge("*", new File[] { comprobante, respuesta });

			/* 512 */ DOMSource source = new DOMSource(document);

			/* 514 */ StreamResult result = new StreamResult(
					new OutputStreamWriter(new FileOutputStream(comprobante), "UTF-8"));

			/* 516 */ TransformerFactory transFactory = TransformerFactory.newInstance();
			/* 517 */ Transformer transformer = transFactory.newTransformer();

			/* 519 */ transformer.transform(source, result);
		} catch (Exception ex) {
			/* 522 */ Logger.getLogger(ArchivoUtils.class.getName()).log(Level.SEVERE, null, ex);
		}
		/* 524 */ return exito;
	}

	private static Document merge(String exp, File[] files) throws Exception {
		/* 537 */ XPathFactory xPathFactory = XPathFactory.newInstance();
		/* 538 */ XPath xpath = xPathFactory.newXPath();
		/* 539 */ XPathExpression expression = xpath.compile(exp);

		/* 541 */ DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		/* 542 */ docBuilderFactory.setIgnoringElementContentWhitespace(true);
		/* 543 */ DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		/* 544 */ Document base = docBuilder.parse(files[0]);

		/* 546 */ Node results = (Node) expression.evaluate(base, XPathConstants.NODE);
		/* 547 */ if (results == null) {
			/* 548 */ throw new IOException(files[0] + ": expression does not evaluate to node");
		}

		/* 551 */ for (int i = 1; i < files.length; i++) {
			/* 552 */ Document merge = docBuilder.parse(files[i]);
			/* 553 */ Node nextResults = (Node) expression.evaluate(merge, XPathConstants.NODE);
			/* 554 */ results.appendChild(base.importNode(nextResults, true));
		}

		/* 563 */ return base;
	}

	public static String obtenerTipoComprobante(byte[] xmlAutorizado) throws Exception {

		String docu = null;

		docu = new String(xmlAutorizado, "UTF-8");
		
		if (docu.contains("&lt;factura") || docu.contains("<factura")) {
			return "FA";
		}
		if (docu.contains("&lt;comprobanteRetencion") || docu.contains("<comprobanteRetencion")) {
			return "CR";
		}
		if (docu.contains("&lt;notaCredito")||docu.contains("<notaCredito") ) {
			return "NC";
		}
		if (docu.contains("&lt;notaDebito") ||docu.contains("<notaDebito") ) {
			return "ND";
		}
		if (docu.contains("&lt;guiaRemision")|| docu.contains("<guiaRemision")) {
			return "GR";
		}
		if (docu.contains("&lt;liquidacionCompra")|| docu.contains("<liquidacionCompra")) {
			return "LC";
		}
		return null;
		

		 
	}

}
