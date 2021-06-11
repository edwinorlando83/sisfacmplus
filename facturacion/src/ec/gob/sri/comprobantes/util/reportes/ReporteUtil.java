package ec.gob.sri.comprobantes.util.reportes;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import ec.gob.sri.comprobantes.modelo.InfoTributaria;
import ec.gob.sri.comprobantes.modelo.factura.Factura;
import ec.gob.sri.comprobantes.modelo.factura.Factura.InfoFactura.Pagos.Pago;
import ec.gob.sri.comprobantes.modelo.guia.GuiaRemision;
import ec.gob.sri.comprobantes.modelo.liquidacioncompra.LiquidacionCompras;
import ec.gob.sri.comprobantes.modelo.notacredito.NotaCredito;
import ec.gob.sri.comprobantes.modelo.notadebito.Impuesto;
import ec.gob.sri.comprobantes.modelo.notadebito.NotaDebito;
import ec.gob.sri.comprobantes.modelo.rentencion.ComprobanteRetencion;
import ec.gob.sri.comprobantes.modelo.reportes.ComprobanteRetencionReporte;
import ec.gob.sri.comprobantes.modelo.reportes.DetallesAdicionalesReporte;
import ec.gob.sri.comprobantes.modelo.reportes.FacturaReporte;
import ec.gob.sri.comprobantes.modelo.reportes.GuiaRemisionReporte;
import ec.gob.sri.comprobantes.modelo.reportes.InformacionAdicional;
import ec.gob.sri.comprobantes.modelo.reportes.LiquidacionComprasReporte;
import ec.gob.sri.comprobantes.modelo.reportes.NotaCreditoReporte;
import ec.gob.sri.comprobantes.modelo.reportes.NotaDebitoReporte;
import ec.gob.sri.comprobantes.modelo.reportes.TotalComprobante;
import ec.gob.sri.comprobantes.util.StringUtil;
import ec.gob.sri.comprobantes.util.TipoAmbienteEnum;
import ec.gob.sri.comprobantes.util.TipoEmisionEnum;
import ec.gob.sri.comprobantes.util.TipoImpuestoEnum;
import ec.gob.sri.comprobantes.util.TipoImpuestoIvaEnum;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class ReporteUtil {
	byte[] logoEmpresa;
	String rutaCarpetaPDF;
	String rutaJasper;

	public ReporteUtil(byte[] logo, String rutaCarpetaPDF, String rutaJasper) {
		this.logoEmpresa = logo;
		this.rutaCarpetaPDF = rutaCarpetaPDF;
		this.rutaJasper = rutaJasper;
	}

	public ReporteUtil(byte[] logo, String rutaCarpetaPDF) {
		this.logoEmpresa = logo;
		this.rutaCarpetaPDF = rutaCarpetaPDF;

	}

	String razoncli = null;

	public String generarReporte(String urlReporte, FacturaReporte fact, String numAut, String fechaAut)
			throws SQLException, ClassNotFoundException {

		String rutaPDF = "";
		FileInputStream is = null;
		try {
			JRDataSource dataSource = new JRBeanCollectionDataSource(fact.getDetallesAdiciones());

			is = new FileInputStream(urlReporte);
			JasperPrint reporte_view = JasperFillManager.fillReport(is,
					obtenerMapaParametrosReportes(
							obtenerParametrosInfoTriobutaria(fact.getFactura().getInfoTributaria(), numAut, fechaAut),
							obtenerInfoFactura(fact.getFactura(), fact)),
					dataSource);
			String nombre = fact.getFactura().getInfoTributaria().getClaveAcceso();

			rutaPDF = showReport(reporte_view, nombre);
		} catch (FileNotFoundException ex) {
			System.out.println("Error-ReporteUtil-generarReporte ex: " + ex.getMessage());
		} catch (JRException e) {
			System.out.println("Error-ReporteUtil-generarReporte e: " + e.getStackTrace());
		} finally {
			try {
				if (is != null)
					is.close();
			} catch (IOException ex) {
				System.out.println("Error-ReporteUtil-generarReporte: " + ex.getMessage());
			}
		}

		return rutaPDF;
	}

	public String generarReporte(String urlReporte, LiquidacionComprasReporte fact, String numAut, String fechaAut)
			throws SQLException, ClassNotFoundException {

		String rutaPDF = "";
		FileInputStream is = null;
		try {
			JRDataSource dataSource = new JRBeanCollectionDataSource(fact.getDetallesAdiciones());

			is = new FileInputStream(urlReporte);
			JasperPrint reporte_view = JasperFillManager.fillReport(is,
					obtenerMapaParametrosReportes(
							obtenerParametrosInfoTriobutaria(fact.getFactura().getInfoTributaria(), numAut, fechaAut),
							obtenerInfoLiquidacionCompra(fact.getFactura(), fact)),
					dataSource);
			String nombre = fact.getFactura().getInfoTributaria().getClaveAcceso();

			rutaPDF = showReport(reporte_view, nombre);
		} catch (FileNotFoundException ex) {
			System.out.println("Error-ReporteUtil-generarReporte: " + ex.getMessage());
		} catch (JRException e) {
			System.out.println("Error-ReporteUtil-generarReporte: " + e.getMessage());
		} finally {
			try {
				if (is != null)
					is.close();
			} catch (IOException ex) {
				System.out.println("Error-ReporteUtil-generarReporte: " + ex.getMessage());
			}
		}

		return rutaPDF;
	}

	public String generarReporte(String urlReporte, NotaDebitoReporte rep, String numAut, String fechaAut)
			throws SQLException, ClassNotFoundException {

		String rutaPDF = "";
		FileInputStream is = null;
		try {
			/* 104 */JRDataSource dataSource = new JRBeanCollectionDataSource(rep.getDetallesAdiciones());
			/* 105 */is = new FileInputStream(urlReporte);
			
			 
			/* 106 */JasperPrint reporte_view = JasperFillManager.fillReport(is,
					obtenerMapaParametrosReportes(
							obtenerParametrosInfoTriobutaria(rep.getNotaDebito().getInfoTributaria(), numAut, fechaAut),
							obtenerInfoND(rep.getNotaDebito().getInfoNotaDebito(), rep)),
					dataSource);
			String nombre = rep.getNotaDebito().getInfoTributaria().getClaveAcceso();

			rutaPDF = showReport(reporte_view, nombre);
		} catch (FileNotFoundException ex) {
			Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, ex);
		} catch (JRException e) {
			Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, e);
		} finally {
			try {
				if (is != null)
					/* 116 */is.close();
			} catch (IOException ex) {
				Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

		return rutaPDF;
	}

	public String generarReporte(String urlReporte, NotaCreditoReporte rep, String numAut, String fechaAut)
			throws SQLException, ClassNotFoundException {
		String rutaPDF = "";
		FileInputStream is = null;
		try {
			JRDataSource dataSource = new JRBeanCollectionDataSource(rep.getDetallesAdiciones());
			is = new FileInputStream(urlReporte);

			JasperPrint reporte_view = JasperFillManager.fillReport(is, obtenerMapaParametrosReportes(
					obtenerParametrosInfoTriobutaria(rep.getNotaCredito().getInfoTributaria(), numAut, fechaAut),
					obtenerInfoNC(rep.getNotaCredito(), rep)), dataSource);
			String nombre = rep.getNotaCredito().getInfoTributaria().getClaveAcceso();

			rutaPDF = showReport(reporte_view, nombre);
		} catch (FileNotFoundException ex) {
			Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, ex);
		} catch (JRException e) {
			Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, e);
		} finally {
			try {
				if (is != null)
					is.close();
			} catch (IOException ex) {
				Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

		return rutaPDF;
	}

	public String generarReporte(String urlReporte, GuiaRemisionReporte rep, String numAut, String fechaAut,
			GuiaRemision guiaRemision) throws SQLException, ClassNotFoundException {
		String rutaPDF = "";
		FileInputStream is = null;
		try {
			/* 156 */JRDataSource dataSource = new JRBeanCollectionDataSource(rep.getGuiaRemisionList());
			/* 157 */is = new FileInputStream(urlReporte);
			/* 158 */JasperPrint reporte_view = JasperFillManager.fillReport(is,
					obtenerMapaParametrosReportes(
							obtenerParametrosInfoTriobutaria(rep.getGuiaRemision().getInfoTributaria(), numAut,
									fechaAut),
							obtenerInfoGR(rep.getGuiaRemision().getInfoGuiaRemision(), guiaRemision)),
					dataSource);
			String nombre = rep.getGuiaRemision().getInfoTributaria().getClaveAcceso();

			rutaPDF = showReport(reporte_view, nombre);
		} catch (FileNotFoundException ex) {
			/* 162 */Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, ex);
		} catch (JRException e) {
			/* 164 */Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, e);
		} finally {
			try {
				/* 167 */if (is != null)
					/* 168 */is.close();
			} catch (IOException ex) {
				/* 171 */Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

		return rutaPDF;
	}

	public String generarReporte(String urlReporte, ComprobanteRetencionReporte rep, String numAut, String fechaAut)
			throws SQLException, ClassNotFoundException {
		String rutaPDF = "";
		FileInputStream is = null;
		try {
			/* 182 */JRDataSource dataSource = new JRBeanCollectionDataSource(rep.getDetallesAdiciones());
			/* 183 */is = new FileInputStream(urlReporte);
			/* 184 */JasperPrint reporte_view = JasperFillManager.fillReport(is,
					obtenerMapaParametrosReportes(
							obtenerParametrosInfoTriobutaria(rep.getComprobanteRetencion().getInfoTributaria(), numAut,
									fechaAut),
							obtenerInfoCompRetencion(rep.getComprobanteRetencion().getInfoCompRetencion(),rep)),
					dataSource);
			String nombre = rep.getComprobanteRetencion().getInfoTributaria().getClaveAcceso();

			rutaPDF = showReport(reporte_view, nombre);
		} catch (FileNotFoundException ex) {
			/* 188 */Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, ex);
		} catch (JRException e) {
			/* 190 */Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, e);
		} finally {
			try {
				/* 193 */if (is != null)
					/* 194 */is.close();
			} catch (IOException ex) {
				/* 197 */Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return rutaPDF;
	}

	private Map<String, Object> obtenerMapaParametrosReportes(Map<String, Object> mapa1, Map<String, Object> mapa2) {
		mapa1.putAll(mapa2);
		return mapa1;
	}

	private Map<String, Object> obtenerParametrosInfoTriobutaria(InfoTributaria infoTributaria, String numAut,
			String fechaAut) throws SQLException, ClassNotFoundException {

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("RUC", infoTributaria.getRuc());
		param.put("CLAVE_ACC", infoTributaria.getClaveAcceso());
		param.put("RAZON_SOCIAL", infoTributaria.getRazonSocial());
		param.put("DIR_MATRIZ", infoTributaria.getDirMatriz());

		if (logoEmpresa != null) {

			InputStream isLogo = new ByteArrayInputStream(logoEmpresa);

			param.put("LOGO", isLogo);
		}

		String ruta = "resources/reportes/";
		if (rutaJasper != null)
			ruta = this.rutaJasper + ruta;

		param.put("SUBREPORT_DIR", ruta);
		param.put("TIPO_EMISION", obtenerTipoEmision(infoTributaria));
		param.put("NUM_AUT", numAut);

		// SimpleDateFormat dt1 = new SimpleDateFormat("yyyy/mm/dd hh:mm:ss");

		param.put("FECHA_AUT", fechaAut);
		// param.put("MARCA_AGUA",
		// obtenerMarcaAgua(infoTributaria.getAmbiente()));
		/* 233 */param.put("NUM_FACT",
				infoTributaria.getEstab() + "-" + infoTributaria.getPtoEmi() + "-" + infoTributaria.getSecuencial());
		/* 234 */param.put("AMBIENTE", obtenerAmbiente(infoTributaria));
		/* 235 */param.put("NOM_COMERCIAL", infoTributaria.getNombreComercial());
		/* 236 */return param;
	}

	private String obtenerAmbiente(InfoTributaria infoTributaria) {
		/* 240 */if (infoTributaria.getAmbiente().equals("2")) {
			/* 241 */return TipoAmbienteEnum.PRODUCCION.toString();
		}
		/* 243 */return TipoAmbienteEnum.PRUEBAS.toString();
	}

	private String obtenerTipoEmision(InfoTributaria infoTributaria) {
		/* 248 */if (infoTributaria.getTipoEmision().equals("2")) {
			/* 249 */return TipoEmisionEnum.CONTINGENCIA.getCode();
		}
		/* 251 */if (infoTributaria.getTipoEmision().equals("1")) {
			/* 252 */return TipoEmisionEnum.NORMAL.getCode();
		}
		/* 254 */return null;
	}

	private Map<String, Object> obtenerInfoFactura(Factura factura, FacturaReporte fact) {
		Factura.InfoFactura infoFactura = factura.getInfoFactura();
		Map<String, Object> param = new HashMap<String, Object>();
		/* 274 */param.put("DIR_SUCURSAL", infoFactura.getDirEstablecimiento());
		/* 275 */param.put("CONT_ESPECIAL", infoFactura.getContribuyenteEspecial());
		/* 276 */param.put("LLEVA_CONTABILIDAD", infoFactura.getObligadoContabilidad());
		/* 277 */param.put("RS_COMPRADOR", infoFactura.getRazonSocialComprador());
		/* 278 */param.put("RUC_COMPRADOR", infoFactura.getIdentificacionComprador());
		/* 279 */param.put("FECHA_EMISION", infoFactura.getFechaEmision());
		/* 280 */param.put("GUIA", infoFactura.getGuiaRemision());
		/* 281 */TotalComprobante tc = getTotales(infoFactura);
		/* 282 */param.put("VALOR_TOTAL", infoFactura.getImporteTotal());

		Double totalsubsi = 0.0;
		if (infoFactura.getTotalSubsidio() != null)
			totalsubsi = infoFactura.getTotalSubsidio().doubleValue();

		double ahorro = infoFactura.getImporteTotal().doubleValue() - totalsubsi;
		param.put("AHORRO", ahorro);

		param.put("totalSubsidio", infoFactura.getTotalSubsidio());
		param.put("IRBPNR", tc.getIRBPNR());

		String formapago = "";
		for (Pago pago : infoFactura.getPagos().getPago()) {
			String codformapago = pago.getFormaPago();
			String valor = pago.getTotal().toString();

			if (codformapago.equals("20"))
				formapago = codformapago + "  OTROS  CON UTILIZACION DEL SISTEMA FINANCIERO       " + valor + "\n";
			else if (codformapago.equals("01"))
				formapago = codformapago + " OTROS  SIN CON UTILIZACION DEL SISTEMA FINANCIERO   " + valor + "\n";
			else if (codformapago.equals("15"))
				formapago = codformapago + "     COMPENSACIÓN DE DEUDAS   " + valor + "\n";
			else

			if (codformapago.equals("16"))
				formapago = codformapago + "     TARJETA DE DÉBITO  " + valor + "\n";
			else if (codformapago.equals("17"))
				formapago = codformapago + "     DINERO ELECTRÓNICO   " + valor + "\n";
			else

			if (codformapago.equals("18"))
				formapago = codformapago + "     TARJETA PREPAGO  " + valor + "\n";
			else

			if (codformapago.equals("19"))
				formapago = codformapago + "     TARJETA DE CRÉDITO   " + valor + "\n";
			else if (codformapago.equals("21"))
				formapago = codformapago + "     ENDOSO DE TÍTULOS   " + valor + "\n";
			else
				formapago = codformapago + " " + valor + "\n";

		}
		param.put("p_formapago", formapago);

		/* 283 */param.put("DESCUENTO", infoFactura.getTotalDescuento());
		/* 284 */param.put("IVA", tc.getIva12());
		/* 285 */param.put("IVA_0", tc.getSubtotal0());
		/* 286 */param.put("IVA_12", tc.getSubtotal12());
		/* 287 */param.put("ICE", tc.getTotalIce());
		/* 288 */param.put("NO_OBJETO_IVA", tc.getSubtotalNoSujetoIva());
		/* 289 */param.put("SUBTOTAL", infoFactura.getTotalSinImpuestos());
		param.put("IVA_PORCENTAJE", factura.getIvaPorcentaje() + " %");

		if (infoFactura.getPropina() != null) {
			param.put("PROPINA", infoFactura.getPropina().toString());
		}
		param.put("TOTAL_DESCUENTO", calcularDescuento(fact));

		BigDecimal tss = calcularprecioconSubsidio(fact, factura.getIvaPorcentaje());

		BigDecimal imt = infoFactura.getImporteTotal().setScale(2, BigDecimal.ROUND_UP);

		BigDecimal tsss = tss.subtract(imt);

		param.put("totalSubsidio", tss.toString());

		if (tsss.intValue() > 0)
			param.put("AHORRO", tsss.toString());
		else
			param.put("AHORRO", "0.00");

		param.put("DIRECCIONCOMPRADOR", infoFactura.getDireccionComprador());
		param.put("GUIAREMISION", infoFactura.getGuiaRemision());
		param.put("DIRESTABLECIMIENTO", infoFactura.getDirEstablecimiento());
		
		
		List<InformacionAdicional> lista = fact.getInfoAdicional(); 		
		String REGIMENIMPOSITIVO = " ";
		String AGENTERETENCION = " ";
		for (InformacionAdicional i : lista) {
			if (i.getNombre().equalsIgnoreCase("REGIMENIMPOSITIVO"))
				REGIMENIMPOSITIVO = i.getValor();
			if (i.getNombre().equalsIgnoreCase("AGENTERETENCION"))
				AGENTERETENCION = i.getValor();
		}
		param.put("REGIMENIMPOSITIVO", REGIMENIMPOSITIVO);
		param.put("AGENTERETENCION", AGENTERETENCION); 
		return param;
	}

	private Map<String, Object> obtenerInfoLiquidacionCompra(LiquidacionCompras factura,
			LiquidacionComprasReporte fact) {
		LiquidacionCompras.InfoLiquidacionCompra infoFactura = factura.getInfoLiquidacionCompra();
		Map<String, Object> param = new HashMap<String, Object>();
		/* 274 */param.put("DIR_SUCURSAL", infoFactura.getDirEstablecimiento());
		/* 275 */param.put("CONT_ESPECIAL", infoFactura.getContribuyenteEspecial());
		/* 276 */param.put("LLEVA_CONTABILIDAD", infoFactura.getObligadoContabilidad());
		/* 277 */param.put("RS_COMPRADOR", infoFactura.getRazonSocialProveedor());
		/* 278 */param.put("RUC_COMPRADOR", infoFactura.getIdentificacionProveedor());
		/* 279 */param.put("FECHA_EMISION", infoFactura.getFechaEmision());
		/* 280 */param.put("GUIA", infoFactura.getGuiaRemision());
		/* 281 */TotalComprobante tc = getTotales(infoFactura);
		/* 282 */param.put("VALOR_TOTAL", infoFactura.getImporteTotal());

		Double totalsubsi = 0.0;
		if (infoFactura.getTotalSubsidio() != null)
			totalsubsi = infoFactura.getTotalSubsidio().doubleValue();

		double ahorro = infoFactura.getImporteTotal().doubleValue() - totalsubsi;
		param.put("AHORRO", ahorro);

		param.put("totalSubsidio", infoFactura.getTotalSubsidio());
		param.put("IRBPNR", tc.getIRBPNR());

		String formapago = "";
		for (ec.gob.sri.comprobantes.modelo.liquidacioncompra.LiquidacionCompras.InfoLiquidacionCompra.Pagos.Pago pago : infoFactura
				.getPagos().getPago()) {
			String codformapago = pago.getFormaPago();
			String valor = pago.getTotal().toString();

			if (codformapago.equals("20"))
				formapago = codformapago + "    CON UTILIZACION DEL SISTEMA FINANCIERO       " + valor + "\n";
			else if (codformapago.equals("01"))
				formapago = codformapago + "    SIN CON UTILIZACION DEL SISTEMA FINANCIERO   " + valor + "\n";
			else if (codformapago.equals("15"))
				formapago = codformapago + "     COMPENSACIÓN DE DEUDAS   " + valor + "\n";
			else

			if (codformapago.equals("16"))
				formapago = codformapago + "     TARJETA DE DÉBITO  " + valor + "\n";
			else if (codformapago.equals("17"))
				formapago = codformapago + "     DINERO ELECTRÓNICO   " + valor + "\n";
			else

			if (codformapago.equals("18"))
				formapago = codformapago + "     TARJETA PREPAGO  " + valor + "\n";
			else

			if (codformapago.equals("19"))
				formapago = codformapago + "     TARJETA DE CRÉDITO   " + valor + "\n";
			else if (codformapago.equals("21"))
				formapago = codformapago + "     ENDOSO DE TÍTULOS   " + valor + "\n";
			else
				formapago = codformapago + " " + valor + "\n";

		}
		param.put("p_formapago", formapago);

		/* 283 */param.put("DESCUENTO", infoFactura.getTotalDescuento());
		/* 284 */param.put("IVA", tc.getIva12());
		/* 285 */param.put("IVA_0", tc.getSubtotal0());
		/* 286 */param.put("IVA_12", tc.getSubtotal12());
		/* 287 */param.put("ICE", tc.getTotalIce());
		/* 288 */param.put("NO_OBJETO_IVA", tc.getSubtotalNoSujetoIva());
		/* 289 */param.put("SUBTOTAL", infoFactura.getTotalSinImpuestos());
		param.put("IVA_PORCENTAJE", factura.getIvaPorcentaje() + " %");

		if (infoFactura.getPropina() != null) {
			param.put("PROPINA", infoFactura.getPropina().toString());
		}
		param.put("TOTAL_DESCUENTO", calcularDescuento(fact));

		BigDecimal tss = calcularprecioconSubsidio(fact, factura.getIvaPorcentaje());

		BigDecimal imt = infoFactura.getImporteTotal().setScale(2, BigDecimal.ROUND_UP);

		BigDecimal tsss = tss.subtract(imt);

		param.put("totalSubsidio", tss.toString());

		if (tsss.intValue() > 0)
			param.put("AHORRO", tsss.toString());
		else
			param.put("AHORRO", "0.00");
		
		
	   List<InformacionAdicional> lista = fact.getInfoAdicional(); 
		
		String REGIMENIMPOSITIVO = "";
		String AGENTERETENCION = "";
		for (InformacionAdicional i : lista) {
			if (i.getNombre().equalsIgnoreCase("REGIMENIMPOSITIVO"))
				REGIMENIMPOSITIVO = i.getValor();
			if (i.getNombre().equalsIgnoreCase("AGENTERETENCION"))
				AGENTERETENCION = i.getValor();
		}
		param.put("REGIMENIMPOSITIVO", REGIMENIMPOSITIVO);
		param.put("AGENTERETENCION", AGENTERETENCION); 
		

		return param;
	}

	private String calcularDescuento(FacturaReporte fact) {
		BigDecimal descuento = new BigDecimal(0);
		for (DetallesAdicionalesReporte detalle : fact.getDetallesAdiciones()) {
			descuento = descuento.add(new BigDecimal(detalle.getDescuento()));
		}
		return descuento.toString();
	}

	private String calcularDescuento(LiquidacionComprasReporte fact) {
		BigDecimal descuento = new BigDecimal(0);
		for (DetallesAdicionalesReporte detalle : fact.getDetallesAdiciones()) {
			descuento = descuento.add(new BigDecimal(detalle.getDescuento()));
		}
		return descuento.toString();
	}

	private BigDecimal calcularprecioconSubsidio(FacturaReporte fact, String iniva) {
		BigDecimal precioconSubsidio = new BigDecimal(0);
		BigDecimal iva = new BigDecimal(iniva);

		for (DetallesAdicionalesReporte detalle : fact.getDetallesAdiciones()) {

			BigDecimal PrecioSinSubsidio = new BigDecimal(detalle.getPrecioSinSubsidio());
			BigDecimal Cantidad = new BigDecimal(detalle.getCantidad());

			precioconSubsidio = precioconSubsidio.add(PrecioSinSubsidio.multiply(Cantidad));
		}

		BigDecimal valor_iva = precioconSubsidio.multiply(iva).divide(new BigDecimal(100));
		BigDecimal total = precioconSubsidio.add(valor_iva);

		return total.setScale(2, BigDecimal.ROUND_UP);
	}

	private BigDecimal calcularprecioconSubsidio(LiquidacionComprasReporte fact, String iniva) {
		BigDecimal precioconSubsidio = new BigDecimal(0);
		BigDecimal iva = new BigDecimal(iniva);

		for (DetallesAdicionalesReporte detalle : fact.getDetallesAdiciones()) {

			BigDecimal PrecioSinSubsidio = new BigDecimal(detalle.getPrecioSinSubsidio());
			BigDecimal Cantidad = new BigDecimal(detalle.getCantidad());

			precioconSubsidio = precioconSubsidio.add(PrecioSinSubsidio.multiply(Cantidad));
		}

		BigDecimal valor_iva = precioconSubsidio.multiply(iva).divide(new BigDecimal(100));
		BigDecimal total = precioconSubsidio.add(valor_iva);

		return total.setScale(2, BigDecimal.ROUND_UP);
	}

	private TotalComprobante getTotales(Factura.InfoFactura infoFactura) {
		/* 306 */BigDecimal totalIva12 = new BigDecimal(0.0D);
		/* 307 */BigDecimal totalIva0 = new BigDecimal(0.0D);
		/* 308 */BigDecimal iva12 = new BigDecimal(0.0D);
		/* 309 */BigDecimal totalICE = new BigDecimal(0.0D);
		/* 309 */BigDecimal totalIRBPNR = new BigDecimal(0.0D);

		/* 310 */BigDecimal totalSinImpuesto = new BigDecimal(0.0D);
		/* 311 */TotalComprobante tc = new TotalComprobante();
		/* 312 */for (Factura.InfoFactura.TotalConImpuestos.TotalImpuesto ti : infoFactura.getTotalConImpuestos()
				.getTotalImpuesto()) {
			/* 313 */Integer cod = new Integer(ti.getCodigo());
			/* 314 */if ((TipoImpuestoEnum.IVA.getCode() == cod.intValue())
					&& (TipoImpuestoIvaEnum.IVA_VENTA_12.getCode().equals(ti.getCodigoPorcentaje()))) {
				/* 316 */totalIva12 = totalIva12.add(ti.getBaseImponible());
				/* 317 */iva12 = iva12.add(ti.getValor());
			}
			/* 319 */if ((TipoImpuestoEnum.IVA.getCode() == cod.intValue())
					&& (TipoImpuestoIvaEnum.IVA_VENTA_0.getCode().equals(ti.getCodigoPorcentaje()))) {
				/* 321 */totalIva0 = totalIva0.add(ti.getBaseImponible());
			}
			/* 323 */if ((TipoImpuestoEnum.IVA.getCode() == cod.intValue())
					&& (TipoImpuestoIvaEnum.IVA_VENTA_EXCENTO.getCode().equals(ti.getCodigoPorcentaje()))) {
				/* 325 */totalSinImpuesto = totalSinImpuesto.add(ti.getBaseImponible());
			}
			if (TipoImpuestoEnum.ICE.getCode() == cod.intValue()) {
				totalICE = totalICE.add(ti.getValor());
			}

			if (TipoImpuestoEnum.IRBPNR.getCode() == cod.intValue()) {
				totalIRBPNR = totalIRBPNR.add(ti.getValor());
			}

		}
		/* 331 */tc.setIva12(iva12.toString());
		/* 332 */tc.setSubtotal0(totalIva0.toString());
		/* 333 */tc.setSubtotal12(totalIva12.toString());
		/* 334 */tc.setTotalIce(totalICE.toString());
		/* 335 */tc.setSubtotal(totalIva0.add(totalIva12));
		/* 336 */tc.setSubtotalNoSujetoIva(totalSinImpuesto.toString());
		tc.setIRBPNR(totalIRBPNR.toString());

		/* 337 */return tc;
	}

	private TotalComprobante getTotales(LiquidacionCompras.InfoLiquidacionCompra infoFactura) {
		/* 306 */BigDecimal totalIva12 = new BigDecimal(0.0D);
		/* 307 */BigDecimal totalIva0 = new BigDecimal(0.0D);
		/* 308 */BigDecimal iva12 = new BigDecimal(0.0D);
		/* 309 */BigDecimal totalICE = new BigDecimal(0.0D);
		/* 309 */BigDecimal totalIRBPNR = new BigDecimal(0.0D);

		/* 310 */BigDecimal totalSinImpuesto = new BigDecimal(0.0D);
		/* 311 */TotalComprobante tc = new TotalComprobante();
		/* 312 */for (LiquidacionCompras.InfoLiquidacionCompra.TotalConImpuestos.TotalImpuesto ti : infoFactura
				.getTotalConImpuestos().getTotalImpuesto()) {
			/* 313 */Integer cod = new Integer(ti.getCodigo());
			/* 314 */if ((TipoImpuestoEnum.IVA.getCode() == cod.intValue())
					&& (TipoImpuestoIvaEnum.IVA_VENTA_12.getCode().equals(ti.getCodigoPorcentaje()))) {
				/* 316 */totalIva12 = totalIva12.add(ti.getBaseImponible());
				/* 317 */iva12 = iva12.add(ti.getValor());
			}
			/* 319 */if ((TipoImpuestoEnum.IVA.getCode() == cod.intValue())
					&& (TipoImpuestoIvaEnum.IVA_VENTA_0.getCode().equals(ti.getCodigoPorcentaje()))) {
				/* 321 */totalIva0 = totalIva0.add(ti.getBaseImponible());
			}
			/* 323 */if ((TipoImpuestoEnum.IVA.getCode() == cod.intValue())
					&& (TipoImpuestoIvaEnum.IVA_VENTA_EXCENTO.getCode().equals(ti.getCodigoPorcentaje()))) {
				/* 325 */totalSinImpuesto = totalSinImpuesto.add(ti.getBaseImponible());
			}
			if (TipoImpuestoEnum.ICE.getCode() == cod.intValue()) {
				totalICE = totalICE.add(ti.getValor());
			}

			if (TipoImpuestoEnum.IRBPNR.getCode() == cod.intValue()) {
				totalIRBPNR = totalIRBPNR.add(ti.getValor());
			}

		}
		/* 331 */tc.setIva12(iva12.toString());
		/* 332 */tc.setSubtotal0(totalIva0.toString());
		/* 333 */tc.setSubtotal12(totalIva12.toString());
		/* 334 */tc.setTotalIce(totalICE.toString());
		/* 335 */tc.setSubtotal(totalIva0.add(totalIva12));
		/* 336 */tc.setSubtotalNoSujetoIva(totalSinImpuesto.toString());
		tc.setIRBPNR(totalIRBPNR.toString());

		/* 337 */return tc;
	}

	private TotalComprobante getTotalesNC(NotaCredito.InfoNotaCredito infoNc) {
		BigDecimal totalIva12 = new BigDecimal(0.0D);
		BigDecimal totalIva0 = new BigDecimal(0.0D);
		BigDecimal iva12 = new BigDecimal(0.0D);
		BigDecimal totalICE = new BigDecimal(0.0D);
		BigDecimal totalSinImpuesto = new BigDecimal(0.0D);
		TotalComprobante tc = new TotalComprobante();
		for (ec.gob.sri.comprobantes.modelo.notacredito.TotalConImpuestos.TotalImpuesto ti : infoNc
				.getTotalConImpuestos().getTotalImpuesto()) {
			Integer cod = new Integer(ti.getCodigo());
			if ((TipoImpuestoEnum.IVA.getCode() == cod.intValue())
					&& (TipoImpuestoIvaEnum.IVA_VENTA_12.getCode().equals(ti.getCodigoPorcentaje()))) {
				totalIva12 = totalIva12.add(ti.getBaseImponible());
				iva12 = iva12.add(ti.getValor());
			}

			if ((TipoImpuestoEnum.IVA.getCode() == cod.intValue())
					&& (TipoImpuestoIvaEnum.IVA_VENTA_14.getCode().equals(ti.getCodigoPorcentaje()))) {
				totalIva12 = totalIva12.add(ti.getBaseImponible());
				iva12 = iva12.add(ti.getValor());
			}

			/* 355 */if ((TipoImpuestoEnum.IVA.getCode() == cod.intValue())
					&& (TipoImpuestoIvaEnum.IVA_VENTA_0.getCode().equals(ti.getCodigoPorcentaje()))) {
				/* 357 */totalIva0 = totalIva0.add(ti.getBaseImponible());
			}
			/* 359 */if ((TipoImpuestoEnum.IVA.getCode() == cod.intValue())
					&& (TipoImpuestoIvaEnum.IVA_VENTA_EXCENTO.getCode().equals(ti.getCodigoPorcentaje()))) {
				/* 361 */totalSinImpuesto = totalSinImpuesto.add(ti.getBaseImponible());
			}
			/* 363 */if (TipoImpuestoEnum.ICE.getCode() == cod.intValue()) {
				/* 364 */totalICE = totalICE.add(ti.getValor());
			}
		}
		/* 367 */tc.setIva12(iva12.toString());
		/* 368 */tc.setSubtotal0(totalIva0.toString());
		/* 369 */tc.setSubtotal12(totalIva12.toString());
		/* 370 */tc.setTotalIce(totalICE.toString());
		/* 371 */tc.setSubtotal(totalIva0.add(totalIva12));
		/* 372 */tc.setSubtotalNoSujetoIva(totalSinImpuesto.toString());
		/* 373 */return tc;
	}

	private TotalComprobante getTotalesND(NotaDebito.InfoNotaDebito infoNotaDebito) {
		BigDecimal totalIva12 = new BigDecimal(0.0D);
		BigDecimal totalIva0 = new BigDecimal(0.0D);
		BigDecimal totalICE = new BigDecimal(0.0D);
		BigDecimal iva12 = new BigDecimal(0.0D);
		BigDecimal totalSinImpuesto = new BigDecimal(0.0D);
		TotalComprobante tc = new TotalComprobante();
		for (Impuesto ti : infoNotaDebito.getImpuestos().getImpuesto()) {
			Integer cod = new Integer(ti.getCodigo());
			if ((TipoImpuestoEnum.IVA.getCode() == cod.intValue())
					&& (TipoImpuestoIvaEnum.IVA_VENTA_12.getCode().equals(ti.getCodigoPorcentaje()))) {
				totalIva12 = totalIva12.add(ti.getBaseImponible());
				iva12 = iva12.add(ti.getValor());
			}
			/* 391 */if ((TipoImpuestoEnum.IVA.getCode() == cod.intValue())
					&& (TipoImpuestoIvaEnum.IVA_VENTA_0.getCode().equals(ti.getCodigoPorcentaje()))) {
				/* 393 */totalIva0 = totalIva0.add(ti.getBaseImponible());
			}
			/* 395 */if ((TipoImpuestoEnum.IVA.getCode() == cod.intValue())
					&& (TipoImpuestoIvaEnum.IVA_VENTA_EXCENTO.getCode().equals(ti.getCodigoPorcentaje()))) {
				/* 397 */totalSinImpuesto = totalSinImpuesto.add(ti.getBaseImponible());
			}
			/* 399 */if (TipoImpuestoEnum.ICE.getCode() == cod.intValue()) {
				/* 400 */totalICE = totalICE.add(ti.getValor());
			}
		}
		/* 403 */tc.setSubtotal0(totalIva0.toString());
		/* 404 */tc.setSubtotal12(totalIva12.toString());
		/* 405 */tc.setTotalIce(totalICE.toString());
		/* 406 */tc.setIva12(iva12.toString());
		/* 407 */tc.setSubtotalNoSujetoIva(totalSinImpuesto.toPlainString());
		/* 408 */return tc;
	}

	private Map<String, Object> obtenerInfoNC(NotaCredito notacredito, NotaCreditoReporte nc) {

		NotaCredito.InfoNotaCredito infoNC = notacredito.getInfoNotaCredito();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("DIR_SUCURSAL", infoNC.getDirEstablecimiento());
		param.put("CONT_ESPECIAL", infoNC.getContribuyenteEspecial());
		param.put("LLEVA_CONTABILIDAD", infoNC.getObligadoContabilidad());
		param.put("RS_COMPRADOR", infoNC.getRazonSocialComprador());
		param.put("RUC_COMPRADOR", infoNC.getIdentificacionComprador());
		param.put("FECHA_EMISION", infoNC.getFechaEmision());
		TotalComprobante tc = getTotalesNC(infoNC);
		param.put("IVA_0", tc.getSubtotal0());
		param.put("IVA_12", tc.getSubtotal12());
		param.put("ICE", tc.getTotalIce());
		param.put("VALOR_TOTAL", infoNC.getValorModificacion());
		param.put("IVA", tc.getIva12());
		param.put("SUBTOTAL", infoNC.getTotalSinImpuestos());
		param.put("NO_OBJETO_IVA", tc.getSubtotalNoSujetoIva());
		param.put("NUM_DOC_MODIFICADO", infoNC.getNumDocModificado());
		param.put("FECHA_EMISION_DOC_SUSTENTO", infoNC.getFechaEmisionDocSustento());
		param.put("DOC_MODIFICADO", infoNC.getCodDocModificado());
		param.put("TOTAL_DESCUENTO", obtenerTotalDescuento(nc));
		param.put("RAZON_MODIF", infoNC.getMotivo());
		param.put("IVA_PORCENTAJE", notacredito.getIvaPorcentaje() + " %");
		
		
		String REGIMENIMPOSITIVO = "";
		String AGENTERETENCION = "";
		 List<InformacionAdicional> lista = nc.getInfoAdicional(); 
		for ( InformacionAdicional i : lista) {
			if (i.getNombre().equalsIgnoreCase("REGIMENIMPOSITIVO"))
				REGIMENIMPOSITIVO = i.getValor();
			if (i.getNombre().equalsIgnoreCase("AGENTERETENCION"))
				AGENTERETENCION = i.getValor();
		}
		param.put("REGIMENIMPOSITIVO", REGIMENIMPOSITIVO);
		param.put("AGENTERETENCION", AGENTERETENCION); 
		
		
		return param;
	}

	private Map<String, Object> obtenerInfoGR(GuiaRemision.InfoGuiaRemision igr, GuiaRemision guiaRemision) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("DIR_SUCURSAL", igr.getDirEstablecimiento());
		param.put("CONT_ESPECIAL", igr.getContribuyenteEspecial());
		param.put("LLEVA_CONTABILIDAD", igr.getObligadoContabilidad());
		param.put("FECHA_INI_TRANSPORTE", igr.getFechaIniTransporte());
		param.put("FECHA_FIN_TRANSPORTE", igr.getFechaFinTransporte());
		param.put("RUC_TRANSPORTISTA", igr.getRucTransportista());
		param.put("RS_TRANSPORTISTA", igr.getRazonSocialTransportista());
		param.put("PLACA", igr.getPlaca());
		param.put("PUNTO_PARTIDA", igr.getDirPartida());

		List<InformacionAdicional> lista = getInfoAdicional(guiaRemision);

		param.put("INFO_ADICIONAL", lista);

		String REGIMENIMPOSITIVO = "";
		String AGENTERETENCION = "";
		for (InformacionAdicional i : lista) {
			if (i.getNombre().equalsIgnoreCase("REGIMENIMPOSITIVO"))
				REGIMENIMPOSITIVO = i.getValor();
			if (i.getNombre().equalsIgnoreCase("AGENTERETENCION"))
				AGENTERETENCION = i.getValor();
		}
		param.put("REGIMENIMPOSITIVO", REGIMENIMPOSITIVO);
		param.put("AGENTERETENCION", AGENTERETENCION);

		return param;
	}

	public List<InformacionAdicional> getInfoAdicional(GuiaRemision guiaRemision) {

		List<InformacionAdicional> infoAdicional = new ArrayList<InformacionAdicional>();
		if (guiaRemision.getInfoAdicional() != null) {
			for (GuiaRemision.InfoAdicional.CampoAdicional ca : guiaRemision.getInfoAdicional().getCampoAdicional()) {
				infoAdicional.add(new InformacionAdicional(ca.getValue(), ca.getNombre()));
			}
		}
		if ((infoAdicional != null) && (!infoAdicional.isEmpty())) {
			return infoAdicional;
		}
		return null;
	}

	private String obtenerTotalDescuento(NotaCreditoReporte nc) {
		BigDecimal descuento = new BigDecimal(0);
		for (DetallesAdicionalesReporte detalle : nc.getDetallesAdiciones()) {
			descuento = descuento.add(new BigDecimal(detalle.getDescuento()));
		}
		return descuento.toString();
	}

	private Map<String, Object> obtenerInfoND(NotaDebito.InfoNotaDebito notaDebito, NotaDebitoReporte rnd) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("DIR_SUCURSAL", notaDebito.getDirEstablecimiento());
		param.put("CONT_ESPECIAL", notaDebito.getContribuyenteEspecial());
		param.put("LLEVA_CONTABILIDAD", notaDebito.getObligadoContabilidad());
		param.put("RS_COMPRADOR", notaDebito.getRazonSocialComprador());
		param.put("RUC_COMPRADOR", notaDebito.getIdentificacionComprador());
		param.put("FECHA_EMISION", notaDebito.getFechaEmision());
		TotalComprobante tc = getTotalesND(notaDebito);
		param.put("IVA_0", tc.getSubtotal0());
		param.put("IVA_12", tc.getSubtotal12());
		param.put("ICE", tc.getTotalIce());
		param.put("TOTAL", notaDebito.getValorTotal());
		param.put("IVA", tc.getIva12());
		param.put("NO_OBJETO_IVA", tc.getSubtotalNoSujetoIva());
		param.put("NUM_DOC_MODIFICADO", notaDebito.getNumDocModificado());
		param.put("FECHA_EMISION_DOC_SUSTENTO", notaDebito.getFechaEmisionDocSustento());
		param.put("DOC_MODIFICADO", StringUtil.obtenerDocumentoModificado(notaDebito.getCodDocModificado()));
		param.put("TOTAL_SIN_IMP", notaDebito.getTotalSinImpuestos());
		
		
		String REGIMENIMPOSITIVO = "";
		String AGENTERETENCION = "";
		 List<InformacionAdicional> lista = rnd.getInfoAdicional(); 
		for ( InformacionAdicional i : lista) {
			if (i.getNombre().equalsIgnoreCase("REGIMENIMPOSITIVO"))
				REGIMENIMPOSITIVO = i.getValor();
			if (i.getNombre().equalsIgnoreCase("AGENTERETENCION"))
				AGENTERETENCION = i.getValor();
		}
		param.put("REGIMENIMPOSITIVO", REGIMENIMPOSITIVO);
		param.put("AGENTERETENCION", AGENTERETENCION); 
		
		return param;
	}

	private Map<String, Object> obtenerInfoCompRetencion(ComprobanteRetencion.InfoCompRetencion infoComp, ComprobanteRetencionReporte crr) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("DIR_SUCURSAL", infoComp.getDirEstablecimiento());
		param.put("RS_COMPRADOR", infoComp.getRazonSocialSujetoRetenido());
		param.put("RUC_COMPRADOR", infoComp.getIdentificacionSujetoRetenido());
		param.put("FECHA_EMISION", infoComp.getFechaEmision());
		param.put("CONT_ESPECIAL", infoComp.getContribuyenteEspecial());
		param.put("LLEVA_CONTABILIDAD", infoComp.getObligadoContabilidad());
		param.put("EJERCICIO_FISCAL", infoComp.getPeriodoFiscal());
		
		
		String REGIMENIMPOSITIVO = "";
		String AGENTERETENCION = "";
		 List<InformacionAdicional> lista = crr.getInfoAdicional(); 
		for ( InformacionAdicional i : lista) {
			if (i.getNombre().equalsIgnoreCase("REGIMENIMPOSITIVO"))
				REGIMENIMPOSITIVO = i.getValor();
			if (i.getNombre().equalsIgnoreCase("AGENTERETENCION"))
				AGENTERETENCION = i.getValor();
		}
		param.put("REGIMENIMPOSITIVO", REGIMENIMPOSITIVO);
		param.put("AGENTERETENCION", AGENTERETENCION); 
		
		
		return param;
	}

	public String showReport(JasperPrint jp, String nombre) {
		String rutaPDF = "";
		try {

			if (rutaCarpetaPDF == null)
				rutaCarpetaPDF = System.getProperty("java.io.tmpdir");

			if (!rutaCarpetaPDF.endsWith("\\"))
				rutaCarpetaPDF = rutaCarpetaPDF + "\\";

			rutaPDF = rutaCarpetaPDF + nombre + ".pdf";
			JasperExportManager.exportReportToPdfFile(jp, rutaPDF);

		} catch (JRException ex) {
			System.err.println("Error iReport: " + ex.getMessage());
		} catch (Exception e) {
			System.out.println("error " + e.getMessage());
		}

		return rutaPDF;
	}

}
