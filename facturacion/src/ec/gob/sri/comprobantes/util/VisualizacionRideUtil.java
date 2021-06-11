package ec.gob.sri.comprobantes.util;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import ec.com.mfac.mail.Empresa;
import ec.gob.sri.comprobantes.modelo.factura.Factura;
import ec.gob.sri.comprobantes.modelo.guia.GuiaRemision;
import ec.gob.sri.comprobantes.modelo.liquidacioncompra.LiquidacionCompras;
import ec.gob.sri.comprobantes.modelo.notacredito.NotaCredito;
import ec.gob.sri.comprobantes.modelo.notadebito.NotaDebito;
import ec.gob.sri.comprobantes.modelo.rentencion.ComprobanteRetencion;
import ec.gob.sri.comprobantes.modelo.reportes.ComprobanteRetencionReporte;
import ec.gob.sri.comprobantes.modelo.reportes.FacturaReporte;
import ec.gob.sri.comprobantes.modelo.reportes.GuiaRemisionReporte;
import ec.gob.sri.comprobantes.modelo.reportes.LiquidacionComprasReporte;
import ec.gob.sri.comprobantes.modelo.reportes.NotaCreditoReporte;
import ec.gob.sri.comprobantes.modelo.reportes.NotaDebitoReporte;
import ec.gob.sri.comprobantes.util.reportes.ReporteUtil;
import ec.gob.sri.comprobantes.util.xml.XML2Java;

/**
 * @author S/N
 * @modificado Orlando Cholota Esta clase permite generar el PDF de los
 *             documentos electronicos
 */
public class VisualizacionRideUtil {
	byte[] logo;
	String rutaCarpeta;

	/**
	 * Contructor que recive 2 parametros
	 * 
	 * @param logo
	 *            Logo para los PDF, si es null quedara en blanco
	 * @param rutaCarpeta
	 *            lugar donde se quiere que se genere el PDF, si el valor es
	 *            null se negera el la carpeta temporal del sistema opetarivo
	 */
	public VisualizacionRideUtil(byte[] logo, String rutaCarpeta) {
		this.logo = logo;
		this.rutaCarpeta = rutaCarpeta;

	}

	/*public VisualizacionRideUtil() {
		this.logo = null;

	}*/



	/**
	 * Esta funcion genera el PDF del documento electronico
	 * 
	 * @param xmlAutorizado
	 *            xml autorizado por el sri
	 * @return ruta del PDF generado.
	 */
	public String generarPdf(byte[] xmlAutorizado) throws Exception {
		String rutaPDF = "";
		try {
			String numeroAutorizacion = ArchivoUtils.obtenerValorXML(xmlAutorizado, "/autorizacion/numeroAutorizacion");
			String fechaAutorizacion = ArchivoUtils.obtenerValorXML(xmlAutorizado, "/autorizacion/fechaAutorizacion ");
			String estado = ArchivoUtils.obtenerValorXML(xmlAutorizado, "/autorizacion/estado ");

			if ("AUTORIZADO".equalsIgnoreCase(estado)) {

				rutaPDF = generar(numeroAutorizacion, fechaAutorizacion, xmlAutorizado);
			}

		} catch (Exception e) {
			Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, e);
		}

		return rutaPDF;
	}
	
	public String generarPdf(byte[] xmlAutorizado, Empresa empresa) throws Exception {
		String rutaPDF = "";
		try {
			String numeroAutorizacion = ArchivoUtils.obtenerValorXML(xmlAutorizado, "/autorizacion/numeroAutorizacion");
			String fechaAutorizacion = ArchivoUtils.obtenerValorXML(xmlAutorizado, "/autorizacion/fechaAutorizacion ");
			String estado = ArchivoUtils.obtenerValorXML(xmlAutorizado, "/autorizacion/estado ");

			if ("AUTORIZADO".equalsIgnoreCase(estado)) {
				rutaPDF = generar(numeroAutorizacion, fechaAutorizacion, xmlAutorizado,empresa);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return rutaPDF;
	}
	
	private String generar(String numeroAutorizacion, String fechaAut, byte[] xmlAutorizado, Empresa empresa) throws Exception {
		String rutaPDF = "";

		String tipoComprobante = ArchivoUtils.obtenerTipoComprobante(xmlAutorizado);

		if (tipoComprobante.equals("FA")) {
			try {
				Factura f = XML2Java.unmarshalFactura(xmlAutorizado);
				FacturaReporte fr = new FacturaReporte(f);
				rutaPDF = generarReporte(xmlAutorizado, fr, numeroAutorizacion, fechaAut , empresa.getFormato_fc() );
			} catch (Exception ex) {
				Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		if (tipoComprobante.equals("ND")) {
			try {
				NotaDebito nd = XML2Java.unmarshalNotaDebito(xmlAutorizado);
				NotaDebitoReporte ndR = new NotaDebitoReporte(nd);
				rutaPDF = generarReporte(xmlAutorizado, ndR, numeroAutorizacion, fechaAut,empresa.getFormato_nd());
			} catch (Exception ex) {
				Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		if (tipoComprobante.equals("NC")) {
			try {
				NotaCredito nd = XML2Java.unmarshalNotaCredito(xmlAutorizado);
				NotaCreditoReporte ndR = new NotaCreditoReporte(nd);
				rutaPDF = generarReporte(xmlAutorizado, ndR, numeroAutorizacion, fechaAut,empresa.getFormato_nc());
			} catch (Exception ex) {
				Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

		if (tipoComprobante.equals("CR")) {
			try {
				ComprobanteRetencion nd = XML2Java.unmarshalComprobanteRetencion(xmlAutorizado);
				ComprobanteRetencionReporte ndR = new ComprobanteRetencionReporte(nd);
				rutaPDF = generarReporte(xmlAutorizado, ndR, numeroAutorizacion, fechaAut,empresa.getFormato_rt());
			} catch (Exception ex) {
				Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		if (tipoComprobante.equals("GR"))
			try {
				GuiaRemision gr = XML2Java.unmarshalGuiaRemision(xmlAutorizado);
				GuiaRemisionReporte grr = new GuiaRemisionReporte(gr);
				rutaPDF = generarReporte(xmlAutorizado, grr, numeroAutorizacion, fechaAut, gr,empresa.getFormato_gu());
			} catch (Exception ex) {
				Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex);
			}
		
		
		if (tipoComprobante.equals("LC")) {
			try {
				LiquidacionCompras f = XML2Java.unmarshalLiquidacionCompra(xmlAutorizado);
				LiquidacionComprasReporte fr = new LiquidacionComprasReporte(f);
				rutaPDF = generarReporte(xmlAutorizado, fr, numeroAutorizacion, fechaAut,null);
			} catch (Exception ex) {
				Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		

		return rutaPDF;
	}
	private String generar(String numeroAutorizacion, String fechaAut, byte[] xmlAutorizado) throws Exception {
		String rutaPDF = "";
		
		//aquie para traer el logo del establecimiento
		

		String tipoComprobante = ArchivoUtils.obtenerTipoComprobante(xmlAutorizado);

		if (tipoComprobante.equals("FA")) {
			try {
				Factura f = XML2Java.unmarshalFactura(xmlAutorizado);
				FacturaReporte fr = new FacturaReporte(f);
				rutaPDF = generarReporte(xmlAutorizado, fr, numeroAutorizacion, fechaAut,null);
			} catch (Exception ex) {
				Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		if (tipoComprobante.equals("ND")) {
			try {
				NotaDebito nd = XML2Java.unmarshalNotaDebito(xmlAutorizado);
				NotaDebitoReporte ndR = new NotaDebitoReporte(nd);
				rutaPDF = generarReporte(xmlAutorizado, ndR, numeroAutorizacion, fechaAut,null);
			} catch (Exception ex) {
				Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		if (tipoComprobante.equals("NC")) {
			try {
				NotaCredito nd = XML2Java.unmarshalNotaCredito(xmlAutorizado);
				NotaCreditoReporte ndR = new NotaCreditoReporte(nd);
				rutaPDF = generarReporte(xmlAutorizado, ndR, numeroAutorizacion, fechaAut,null);
			} catch (Exception ex) {
				Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

		if (tipoComprobante.equals("CR")) {
			try {
				ComprobanteRetencion nd = XML2Java.unmarshalComprobanteRetencion(xmlAutorizado);
				ComprobanteRetencionReporte ndR = new ComprobanteRetencionReporte(nd);
				rutaPDF = generarReporte(xmlAutorizado, ndR, numeroAutorizacion, fechaAut,null);
			} catch (Exception ex) {
				Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		if (tipoComprobante.equals("GR")) {
			try {
				GuiaRemision gr = XML2Java.unmarshalGuiaRemision(xmlAutorizado);
				GuiaRemisionReporte grr = new GuiaRemisionReporte(gr);
				rutaPDF = generarReporte(xmlAutorizado, grr, numeroAutorizacion, fechaAut, gr,null);
			} catch (Exception ex) {
				Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		
		if (tipoComprobante.equals("LC")) {
			try {
				LiquidacionCompras f = XML2Java.unmarshalLiquidacionCompra(xmlAutorizado);
				LiquidacionComprasReporte fr = new LiquidacionComprasReporte(f);
				rutaPDF = generarReporte(xmlAutorizado, fr, numeroAutorizacion, fechaAut,null);
			} catch (Exception ex) {
				Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		

		return rutaPDF;
	}

	public String generarReporte(byte[] xmlAutorizado, FacturaReporte xml, String numAut, String fechaAut, String formato_fac) {
		String rutaPDF = "";
		ReporteUtil repUtil = new ReporteUtil(logo, rutaCarpeta);
		try { 
			
			if( formato_fac!=null)
				rutaPDF = repUtil.generarReporte(  "resources/reportes/"+formato_fac.trim()+".jasper", xml, numAut, fechaAut);
			else
			rutaPDF = repUtil.generarReporte(  "resources/reportes/factura.jasper", xml, numAut, fechaAut);
		} catch (SQLException ex) {
			Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex);
		}
		return rutaPDF;
	}

	public String generarReporte(byte[] xmlAutorizado, LiquidacionComprasReporte xml, String numAut, String fechaAut, String formato_fac) {
		String rutaPDF = "";
		ReporteUtil repUtil = new ReporteUtil(logo, rutaCarpeta);
		try { 
			
			if( formato_fac!=null)
				rutaPDF = repUtil.generarReporte(  "resources/reportes/"+formato_fac.trim()+".jasper", xml, numAut, fechaAut);
			else
			rutaPDF = repUtil.generarReporte(  "resources/reportes/liquidacion.jasper", xml, numAut, fechaAut);
		} catch (SQLException ex) {
			Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex);
		}
		return rutaPDF;
	}
	
	public String generarReporte(byte[] xmlAutorizado, NotaCreditoReporte xml, String numAut, String fechaAut, String formato_nc) {
		ReporteUtil repUtil = new ReporteUtil(logo, rutaCarpeta);
		String rutaPDF = "";
		try {
			
		if( formato_nc !=null )		
			
			rutaPDF = repUtil.generarReporte(  "resources/reportes/"+formato_nc.trim()+".jasper", xml, numAut,
					fechaAut);
		else
			
			rutaPDF = repUtil.generarReporte(  "resources/reportes/notaCreditoFinal.jasper", xml, numAut,
					fechaAut);	
		} catch (SQLException ex) {
			Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex);
		}
		return rutaPDF;
	}

	public String generarReporte(byte[] xmlAutorizado, NotaDebitoReporte xml, String numAut, String fechaAut, String formato_nd) {
		String rutaPDF = "";

		ReporteUtil repUtil = new ReporteUtil(logo, rutaCarpeta);
		try {
			if( formato_nd!=null)
			rutaPDF = repUtil.generarReporte(  "resources/reportes/"+formato_nd.trim()+".jasper", xml, numAut,
					fechaAut);
			else
				rutaPDF = repUtil.generarReporte(  "resources/reportes/notaDebitoFinal.jasper", xml, numAut,
						fechaAut);	
		} catch (SQLException ex) {
			Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex);
		}
		return rutaPDF;
	}

	public String generarReporte(byte[] xmlAutorizado, ComprobanteRetencionReporte xml, String numAut,
			String fechaAut, String formato_ret) {
		String rutaPDF = "";
		ReporteUtil repUtil = new ReporteUtil(logo, rutaCarpeta);
		try {
			if( formato_ret!=null )
			rutaPDF = repUtil.generarReporte(  "resources/reportes/"+formato_ret.trim()+".jasper", xml,
					numAut, fechaAut);
			else
				rutaPDF = repUtil.generarReporte(  "resources/reportes/comprobanteRetencion.jasper", xml,
						numAut, fechaAut);
				
			
		} catch (SQLException ex) {
			Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex);
		}
		return rutaPDF;
	}

	public String generarReporte(byte[] xmlAutorizado, GuiaRemisionReporte xml, String numAut, String fechaAut,
			GuiaRemision gr, String formato_guia) {
		String rutaPDF = "";
		ReporteUtil repUtil = new ReporteUtil(logo, rutaCarpeta);
		try {
			
			if( formato_guia!=null)
			rutaPDF = repUtil.generarReporte( "resources/reportes/"+formato_guia.trim()+".jasper", xml, numAut,
					fechaAut, gr);
			
			else
				rutaPDF = repUtil.generarReporte( "resources/reportes/guiaRemisionFinal.jasper", xml, numAut,
						fechaAut, gr);	
		} catch (SQLException ex) {
			Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex);
		}

		return rutaPDF;
	}
}
