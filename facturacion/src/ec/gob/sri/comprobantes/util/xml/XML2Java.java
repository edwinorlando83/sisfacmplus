package ec.gob.sri.comprobantes.util.xml;

import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import ec.gob.sri.comprobantes.modelo.factura.Factura;
import ec.gob.sri.comprobantes.modelo.guia.GuiaRemision;
import ec.gob.sri.comprobantes.modelo.liquidacioncompra.LiquidacionCompras;
import ec.gob.sri.comprobantes.modelo.notacredito.NotaCredito;
import ec.gob.sri.comprobantes.modelo.notadebito.NotaDebito;
import ec.gob.sri.comprobantes.modelo.rentencion.ComprobanteRetencion;
import ec.gob.sri.comprobantes.ws.aut.Autorizacion;

public class XML2Java {

	public static Factura unmarshalFactura(byte[] xmlAutorizado) throws Exception {
		return unmarshalFactura(xmlAutorizado, false);
	}
	public static LiquidacionCompras unmarshalLiquidacionCompra(byte[] xmlAutorizado) throws Exception {
		return unmarshalLiquidacionCompra(xmlAutorizado, false);
	}
	public static Factura unmarshalFactura(byte[] xmlAutorizado, boolean esGenerado) throws Exception {
		StringReader reader = getDocumento(xmlAutorizado, esGenerado);
		JAXBContext context = JAXBContext.newInstance("ec.gob.sri.comprobantes.modelo.factura");
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Factura item = (Factura) unmarshaller.unmarshal(reader);
		return item;
	}
	public static LiquidacionCompras unmarshalLiquidacionCompra(byte[] xmlAutorizado, boolean esGenerado) throws Exception {
		StringReader reader = getDocumento(xmlAutorizado, esGenerado);
		JAXBContext context = JAXBContext.newInstance("ec.gob.sri.comprobantes.modelo.liquidacioncompra");
		Unmarshaller unmarshaller = context.createUnmarshaller();
		LiquidacionCompras item = (LiquidacionCompras) unmarshaller.unmarshal(reader);
		return item;
	}
	public static NotaDebito unmarshalNotaDebito(byte[] xmlAutorizado) throws Exception {

		return unmarshalNotaDebito(xmlAutorizado, false);
	}

	public static NotaDebito unmarshalNotaDebito(byte[] xmlAutorizado, boolean esGenerado) throws Exception {
		JAXBContext context = JAXBContext.newInstance("ec.gob.sri.comprobantes.modelo.notadebito");

		StringReader reader = getDocumento(xmlAutorizado, esGenerado);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		NotaDebito item = (NotaDebito) unmarshaller.unmarshal(reader);
		return item;
	}

	public static NotaCredito unmarshalNotaCredito(byte[] xmlAutorizado) throws Exception {
		return unmarshalNotaCredito(xmlAutorizado, false);
	}

	public static NotaCredito unmarshalNotaCredito(byte[] xmlAutorizado, boolean esGenerado) throws Exception {
		JAXBContext context = JAXBContext.newInstance("ec.gob.sri.comprobantes.modelo.notacredito");

		StringReader reader = getDocumento(xmlAutorizado, esGenerado);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		NotaCredito item = (NotaCredito) unmarshaller.unmarshal(reader);
		return item;
	}

	public static GuiaRemision unmarshalGuiaRemision(byte[] xmlAutorizado) throws Exception {
		JAXBContext context = JAXBContext.newInstance("ec.gob.sri.comprobantes.modelo.guia");
		Unmarshaller unmarshaller = context.createUnmarshaller();
		StringReader reader = getDocumento(xmlAutorizado, false);
		GuiaRemision item = (GuiaRemision) unmarshaller.unmarshal(reader);
		return item;
	}

	public static GuiaRemision unmarshalGuiaRemision(byte[] xmlAutorizado, boolean esGenerado) throws Exception {
		StringReader reader = getDocumento(xmlAutorizado, esGenerado);
		JAXBContext context = JAXBContext.newInstance("ec.gob.sri.comprobantes.modelo.rentencio");
		Unmarshaller unmarshaller = context.createUnmarshaller();
		GuiaRemision item = (GuiaRemision) unmarshaller.unmarshal(reader);
		return item;
	}

	public static ComprobanteRetencion unmarshalComprobanteRetencion(byte[] xmlAutorizado) throws Exception {
		return unmarshalComprobanteRetencion(xmlAutorizado, false);
	}

	public static ComprobanteRetencion unmarshalComprobanteRetencion(byte[] xmlAutorizado, boolean esGenerado)
			throws Exception {

		JAXBContext context = JAXBContext.newInstance("ec.gob.sri.comprobantes.modelo.rentencion");
		Unmarshaller unmarshaller = context.createUnmarshaller();
		StringReader reader = getDocumento(xmlAutorizado, esGenerado);
		ComprobanteRetencion item = (ComprobanteRetencion) unmarshaller.unmarshal(reader);
		return item;
	}

	public static Autorizacion unmarshalAutorizacion(String pathArchivo) throws Exception {
		JAXBContext context = JAXBContext.newInstance("ec.gob.sri.comprobantes.ws.aut.Autorizacion");
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Autorizacion item = (Autorizacion) unmarshaller.unmarshal(new FileReader(pathArchivo));
		return item;
	}

	private static StringReader getDocumento(byte[] xmlAutorizado, boolean esGenerado) throws Exception {
		String documento = null;
		if (esGenerado == false) {

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new ByteArrayInputStream(xmlAutorizado));
			NodeList list = doc.getElementsByTagName("*");
			for (int i = 0; i < list.getLength(); i++) {
				Element element = (Element) list.item(i);
				if (element.getNodeName().equals("comprobante")) {
					documento = element.getChildNodes().item(0).getNodeValue();
				}
			}
		} else
			documento = new String(xmlAutorizado, "UTF-8");
		StringReader reader = new StringReader(documento);

		return reader;
	}
}
