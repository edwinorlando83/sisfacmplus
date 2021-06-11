package ec.gob.sri.comprobantes.view.formas.comprobantes;

import java.io.File;

import org.w3c.dom.Document;

import es.mityc.firmaJava.libreria.xades.DataToSign;
import es.mityc.firmaJava.libreria.xades.XAdESSchemas;
import es.mityc.javasign.xml.refs.InternObjectToSign;
import es.mityc.javasign.xml.refs.ObjectToSign;

public class XAdESBESSignature extends GenericXMLSignature {

	private byte[] BfileToSign;

	public XAdESBESSignature(byte[] BfileToSign) {
		super();
		this.BfileToSign = BfileToSign;
	}

	public static File firmar(byte[] xmlFile, byte[] FileSignature, String passSignature) {
		if (xmlFile == null)
			return null;

		if (FileSignature == null)
			return null;

		File re = null;
		XAdESBESSignature signature = new XAdESBESSignature(xmlFile);
		signature.setPassSignature(passSignature);
		signature.setPathSignature(FileSignature);
		try {
			re = signature.execute();
		} catch (Exception e) {
         // System.out.println("Error en: 1) FIRMA, 2) PASSWORD , 3)CARACTERES ESPECIALES EN EL XML");
		   return null;
		}

		return re;
	}

	@Override
	protected DataToSign createDataToSign() {

		DataToSign datosAFirmar = new DataToSign();

		datosAFirmar.setXadesFormat(es.mityc.javasign.EnumFormatoFirma.XAdES_BES);

		datosAFirmar.setEsquema(XAdESSchemas.XAdES_132);
		datosAFirmar.setXMLEncoding("UTF-8");
		datosAFirmar.setEnveloped(true);
		datosAFirmar.addObject(new ObjectToSign(new InternObjectToSign("comprobante"), "contenido comprobante", null,
				"text/xml", null));
		datosAFirmar.setParentSignNode("comprobante");
		Document docToSign = getDocument(BfileToSign);
		datosAFirmar.setDocument(docToSign);

		return datosAFirmar;
	}

	@Override
	protected String getSignatureFileName() {
		return "";
	}

	@Override
	protected String getPathOut() {
		return "";
	}

}