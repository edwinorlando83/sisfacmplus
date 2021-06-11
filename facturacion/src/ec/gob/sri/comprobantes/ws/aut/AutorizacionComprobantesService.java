/*    */ package ec.gob.sri.comprobantes.ws.aut;

/*    */
/*    */ import java.net.URL;
/*    */ import javax.xml.namespace.QName;
/*    */ import javax.xml.ws.Service;
/*    */ import javax.xml.ws.WebEndpoint;
/*    */ import javax.xml.ws.WebServiceClient;
/*    */ import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

import ec.com.mfac.UrlSri;

/*    */
/*    */ @WebServiceClient(name = "AutorizacionComprobantesService", targetNamespace = "http://ec.gob.sri.ws.autorizacion", wsdlLocation = "/META-INF/wsdl/AutorizacionComprobantes.wsdl")
/*    */ public class AutorizacionComprobantesService extends Service
/*    */ {
	/*    */ private static final URL AUTORIZACIONCOMPROBANTESSERVICE_WSDL_LOCATION;
	private static final WebServiceException e = null;
	/* 34 */ private static final WebServiceException AUTORIZACIONCOMPROBANTESSERVICE_EXCEPTION = e;
	/*    */
	/* 26 */ private static final QName AUTORIZACIONCOMPROBANTESSERVICE_QNAME = new QName(
			"http://ec.gob.sri.ws.autorizacion", "AutorizacionComprobantesService");

	/*    */
	/*    */ public AutorizacionComprobantesService()
	/*    */ {
		/* 38 */ super(__getWsdlLocation(), AUTORIZACIONCOMPROBANTESSERVICE_QNAME);
		/*    */ }

	/*    */
	/*    */ public AutorizacionComprobantesService(URL wsdlLocation) {
		/* 42 */ super(wsdlLocation, AUTORIZACIONCOMPROBANTESSERVICE_QNAME);
		/*    */ }

	/*    */
	/*    */ public AutorizacionComprobantesService(URL wsdlLocation, QName serviceName) {

		/* 46 */ super(wsdlLocation, serviceName);
		/*    */ }

	/*    */
	/*    */ @WebEndpoint(name = "AutorizacionComprobantesPort")
	public AutorizacionComprobantes getAutorizacionComprobantesPort() {

		return (AutorizacionComprobantes) super.getPort(
				new QName("http://ec.gob.sri.ws.autorizacion",UrlSri.get_wsdlPort_Autorizacion()),
				AutorizacionComprobantes.class);
	}

	/*    */
	/*    */ @WebEndpoint(name = "AutorizacionComprobantesPort")
	/*    */ public AutorizacionComprobantes getAutorizacionComprobantesPort(WebServiceFeature[] features)
	/*    */ {
		/* 68 */ return (AutorizacionComprobantes) super.getPort(
				new QName("http://ec.gob.sri.ws.autorizacion", UrlSri.get_wsdlPort_Autorizacion()),
				AutorizacionComprobantes.class, features);
		/*    */ }

	/*    */
	/*    */ private static URL __getWsdlLocation() {
		/* 72 */ if (AUTORIZACIONCOMPROBANTESSERVICE_EXCEPTION != null) {
			/* 73 */ throw AUTORIZACIONCOMPROBANTESSERVICE_EXCEPTION;
			/*    */ }
		/* 75 */ return AUTORIZACIONCOMPROBANTESSERVICE_WSDL_LOCATION;
		/*    */ }

	/*    */
	/*    */ static
	/*    */ {
		/* 29 */ AUTORIZACIONCOMPROBANTESSERVICE_WSDL_LOCATION = AutorizacionComprobantesService.class
				.getResource("/META-INF/wsdl/AutorizacionComprobantes.wsdl");
		/* 31 */ if (AUTORIZACIONCOMPROBANTESSERVICE_WSDL_LOCATION == null)
			new WebServiceException(
					"Cannot find '/META-INF/wsdl/AutorizacionComprobantes.wsdl' wsdl. Place the resource correctly in the classpath.");
	}
	/*    */ }

/*
 * Location:
 * C:\componentes-1.1.7-with-deps\componentes-1.1.7\deps\cliente-file-ws.jar
 * Qualified Name:
 * ec.gob.sri.comprobantes.ws.aut.AutorizacionComprobantesService JD-Core
 * Version: 0.6.2
 */