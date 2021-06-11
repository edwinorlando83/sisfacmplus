package ec.gob.sri.comprobantes.ws;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

import ec.com.mfac.UrlSri;

@WebServiceClient(name = "RecepcionComprobantesService", targetNamespace = "http://ec.gob.sri.ws.recepcion", wsdlLocation = "/META-INF/wsdl/RecepcionComprobantes.wsdl")
public class RecepcionComprobantesService extends Service {
	private static final URL RECEPCIONCOMPROBANTESSERVICE_WSDL_LOCATION;
	private static final WebServiceException e = null;
	/* 34 */ private static final WebServiceException RECEPCIONCOMPROBANTESSERVICE_EXCEPTION = e;

	/* 26 */ private static final QName RECEPCIONCOMPROBANTESSERVICE_QNAME = new QName("http://ec.gob.sri.ws.recepcion",
			"RecepcionComprobantesService");

	public RecepcionComprobantesService() {
		/* 38 */ super(__getWsdlLocation(), RECEPCIONCOMPROBANTESSERVICE_QNAME);
	}

	public RecepcionComprobantesService(URL wsdlLocation) {
		/* 42 */ super(wsdlLocation, RECEPCIONCOMPROBANTESSERVICE_QNAME);
	}

	public RecepcionComprobantesService(URL wsdlLocation, QName serviceName) {
		/* 46 */ super(wsdlLocation, serviceName);
	}

	@WebEndpoint(name = "RecepcionComprobantesPort")
	public RecepcionComprobantes getRecepcionComprobantesPort() {
		
	 
	  return (RecepcionComprobantes) super.getPort(
				new QName("http://ec.gob.sri.ws.recepcion",UrlSri.get_wsdlPort_Recepcion()), RecepcionComprobantes.class);
	}

	@WebEndpoint(name = "RecepcionComprobantesPort")
	public RecepcionComprobantes getRecepcionComprobantesPort(WebServiceFeature[] features) {
		/* 68 */ return (RecepcionComprobantes) super.getPort(
				new QName("http://ec.gob.sri.ws.recepcion", UrlSri.get_wsdlPort_Recepcion()) , RecepcionComprobantes.class,
				features);
	}

	private static URL __getWsdlLocation() {
		/* 72 */ if (RECEPCIONCOMPROBANTESSERVICE_EXCEPTION != null) {
			/* 73 */ throw RECEPCIONCOMPROBANTESSERVICE_EXCEPTION;
		}
		/* 75 */ return RECEPCIONCOMPROBANTESSERVICE_WSDL_LOCATION;
	}

	static {
		/* 29 */ RECEPCIONCOMPROBANTESSERVICE_WSDL_LOCATION = RecepcionComprobantesService.class
				.getResource("/META-INF/wsdl/RecepcionComprobantes.wsdl");
		/* 31 */ if (RECEPCIONCOMPROBANTESSERVICE_WSDL_LOCATION == null)
			new WebServiceException(	"Cannot find '/META-INF/wsdl/RecepcionComprobantes.wsdl' wsdl. Place the resource correctly in the classpath.");
	}
}
