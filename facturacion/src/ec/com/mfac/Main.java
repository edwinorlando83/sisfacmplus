package ec.com.mfac;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ec.com.mfac.db.Coneccion;
import ec.com.mfac.db.DataBaseObject;
import ec.com.mfac.mail.Empresa;
import ec.com.mfac.modeloSybase.Tbl_detalle;
import ec.com.mfac.modeloSybase.Tbl_detalleFactory;
import ec.com.mfac.modeloSybase.Tbl_detalle_retencion;
import ec.com.mfac.modeloSybase.Tbl_detalle_retencionFactory;
import ec.com.mfac.modeloSybase.Tbl_encabezado;
import ec.com.mfac.modeloSybase.Tbl_encabezadoFactory;
import ec.com.mfac.modeloSybase.Tbl_impuestos_detalle;
import ec.com.mfac.modeloSybase.Tbl_impuestos_detalleFactory;
import ec.com.mfac.modeloSybase.Tbl_infoadicional;
import ec.com.mfac.modeloSybase.Tbl_infoadicionalFactory;
import ec.com.mfac.modeloSybase.Tbl_pagos;
import ec.com.mfac.modeloSybase.Tbl_pagosFactory;
import ec.com.mfac.modeloSybase.Tbl_totalimpuesto;
import ec.com.mfac.modeloSybase.Tbl_totalimpuestoFactory;
import ec.gob.sri.comprobantes.modelo.factura.Factura;
import ec.gob.sri.comprobantes.modelo.factura.Factura.Detalles;
import ec.gob.sri.comprobantes.modelo.factura.Factura.Detalles.Detalle;
import ec.gob.sri.comprobantes.modelo.factura.Factura.InfoAdicional.CampoAdicional;
import ec.gob.sri.comprobantes.modelo.factura.Factura.InfoFactura.Pagos;
import ec.gob.sri.comprobantes.modelo.factura.Factura.InfoFactura.Pagos.Pago;
import ec.gob.sri.comprobantes.modelo.factura.Factura.InfoFactura.TotalConImpuestos.TotalImpuesto;
import ec.gob.sri.comprobantes.modelo.factura.Impuesto;
import ec.gob.sri.comprobantes.modelo.notacredito.NotaCredito;
import ec.gob.sri.comprobantes.modelo.rentencion.ComprobanteRetencion;
import ec.gob.sri.comprobantes.modelo.rentencion.ComprobanteRetencion.Impuestos;
import ec.gob.sri.comprobantes.util.ArchivoUtils;
import ec.gob.sri.comprobantes.util.xml.XML2Java;

/**
 * @author Orlando
 *  mfacturacion.jar
 */
public class Main {
	DataBaseObject databaseobject;

	public Main() {
		try {
			databaseobject = new DataBaseObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		try {

			// 2 opciones C o A
		
	 	    String funcion = args[0]; 
			 String rutaArchivo_codEmp = args[1];
			 String rucEmisor = args[2];
			 String paswd = args[3];
			 
		 
	/*		 String funcion = "C";
		 	String rucEmisor = "1802662930001";
		    String paswd = "AdminSQLplus.-18460";

	 	String rutaArchivo_codEmp = "d:\\1.txt";*/

			// java -jar mfacturacion.jar A xml.xml 0602325839001
			// AdminSQLplus.-18460

			/*
			 * String funcion = "A"; String rucEmisor="0603201062001"; String
			 * paswd = "AdminSQLplus.-18460"; String rutaArchivo_codEmp =
			 * "C:\\baseASA9\\1.xml";
			 */

			/*
			 * String funcion = "M"; String rutaArchivo_codEmp = "01"; String
			 * rucEmisor="1891709214001"; String paswd = "AdminSQLplus.-18460";
			 * 
			 */
			leerArchivoConfiguracion(paswd);
			Main main = new Main();
			main.leerDatosEmisor(rucEmisor);

			main.leerDatosEmpresa(rucEmisor, rutaArchivo_codEmp);

			File file = null;
			if (funcion.equalsIgnoreCase("C")) {
				file = new File(rutaArchivo_codEmp);
				String resupues = main.leerArchivo(file);
				System.out.println(resupues);
				file = null;
			} else if (funcion.equalsIgnoreCase("T")) {
				boolean reachable = pingURL(UrlSri.ws_produccion_autorizacion, 300);

				main.setValorActivo(reachable);
			} else
				System.out.println("Primer Parametro debe ser C[Consultar] , A[Autorizar] ,  T [Test] o M [Mail] ");

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	private String leerArchivo(File archivo) throws Exception {
		String retorno = "";

	 /*	databaseobject.SQL_COMMAND("delete from tbl_detalle_retencion;");
		databaseobject.SQL_COMMAND("delete from tbl_impuestos_detalle;");
		databaseobject.SQL_COMMAND("delete from tbl_totalimpuesto;");
		databaseobject.SQL_COMMAND("delete from tbl_pagos;");
		databaseobject.SQL_COMMAND("delete from tbl_infoadicional;");
		databaseobject.SQL_COMMAND("delete from tbl_pagos;");
		databaseobject.SQL_COMMAND("delete from tbl_detalle;");
		databaseobject.SQL_COMMAND("delete from tbl_encabezaDO;");
 */
		// obtener tipo de contenido
		InputStream is = new BufferedInputStream(new FileInputStream(archivo));
		String mimeType = URLConnection.guessContentTypeFromStream(is);
		is.close();
		is = null;

		if (mimeType != null && mimeType.contains("xml")) {
			byte[] xmlAutorizado = Files.readAllBytes(Paths.get(archivo.getAbsolutePath()));
			String tipoDoc = ArchivoUtils.obtenerTipoComprobante(xmlAutorizado);

			if (tipoDoc.equals("FA")) {
				insertFactura(xmlAutorizado);

			}
			if (tipoDoc.equals("NC")) {
				insertNotaCredito(xmlAutorizado);
			}

			if (tipoDoc.equals("CR")) {
				insertRetencion(xmlAutorizado);
			}
			retorno = "finalizado correctamente";
		} else {
			String nombre = archivo.getName();
			if (nombre.contains(".txt")) {

				BufferedReader buf = null;
				buf = new BufferedReader(new FileReader(archivo.getAbsolutePath()));
				String lineJustFetched = null;
				String[] wordsArray;
				lineJustFetched = buf.readLine();
				while (true) {
					lineJustFetched = buf.readLine();
					if (lineJustFetched == null) {
						break;
					} else {
						wordsArray = lineJustFetched.split("\t");
						int posfactura = 9;
						if (  wordsArray[0].toLowerCase().contains("notas de"))
							posfactura = 9;
						if (wordsArray.length > 8) {
							String ss = wordsArray[posfactura];
							if (ss.length() == 49)
								insertarenDB(ss);
						}
					}
				}

				buf.close();
				buf = null;
				retorno = "finalizado correctamente";
			} else {
				retorno = "Solo puden ser acrvhivos .txt o .xml ";

			}
		} // fin else 1

		return retorno;
	}

	private void insertarenDB(String clave_acceso) {
		try {

			FacturacionElectronica fe = new FacturacionElectronica();

			MensajeSri res = fe.consultarEnProduccion(clave_acceso.trim());
			byte[] xmlAutorizado = res.getArchivoAutorizado();

			String tipoDoc = ArchivoUtils.obtenerTipoComprobante(xmlAutorizado);

			if (tipoDoc.equals("FA")) {
				insertFactura(xmlAutorizado);
			}
			if (tipoDoc.equals("NC")) {
				insertNotaCredito(xmlAutorizado);
			}

			if (tipoDoc.equals("CR")) {
				insertRetencion(xmlAutorizado);
			}

		} catch (Exception e) {

			System.out.println("====" + e + "    " + clave_acceso);
		}
	}

	private void insertNotaCredito(byte[] xmlAutorizado) {
		try {
			NotaCredito factura = XML2Java.unmarshalNotaCredito(xmlAutorizado);

			String numeroAutorizacion = ArchivoUtils.obtenerValorXML(xmlAutorizado, "autorizacion/numeroAutorizacion");
			Tbl_encabezado encb = new Tbl_encabezado();
			encb.setAutorizacion(numeroAutorizacion);
			encb.setClaveacceso(factura.getInfoTributaria().getClaveAcceso());
			encb.setAmbiente(factura.getInfoTributaria().getAmbiente());
			encb.setCoddoc(factura.getInfoTributaria().getCodDoc());
			encb.setDirmatriz(factura.getInfoTributaria().getDirMatriz());
			encb.setEstab(factura.getInfoTributaria().getEstab());
			encb.setFechaemision(factura.getInfoNotaCredito().getFechaEmision() );
			encb.setTipoemision(factura.getInfoTributaria().getTipoEmision());
			encb.setRazonsocial(factura.getInfoTributaria().getRazonSocial());
			encb.setNombrecomercial(factura.getInfoTributaria().getNombreComercial());
			encb.setRuc(factura.getInfoTributaria().getRuc());
			encb.setPtoemi(factura.getInfoTributaria().getPtoEmi());
			encb.setSecuencial(factura.getInfoTributaria().getSecuencial());
			encb.setDirestablecimiento(factura.getInfoNotaCredito().getDirEstablecimiento());
			encb.setObligadocontabilidad(factura.getInfoNotaCredito().getObligadoContabilidad());
			encb.setTipoidentificacioncomprador(factura.getInfoNotaCredito().getIdentificacionComprador());
			encb.setRazonsocialcomprador(factura.getInfoNotaCredito().getRazonSocialComprador());
			encb.setIdentificacioncomprador(factura.getInfoNotaCredito().getTipoIdentificacionComprador());
			encb.setTotalsinimpuestos(factura.getInfoNotaCredito().getTotalSinImpuestos().doubleValue());
			encb.setTotaldescuento(0);
			encb.setPropina(0);
			encb.setImportetotal(0);
			encb.setMoneda(factura.getInfoNotaCredito().getMoneda());
			encb.setNc_rise(
					factura.getInfoNotaCredito().getRise() == null ? " " : factura.getInfoNotaCredito().getRise());
			encb.setNc_coddocmodificado(factura.getInfoNotaCredito().getCodDocModificado());
			encb.setNc_numdocmodificado(factura.getInfoNotaCredito().getNumDocModificado());
			String stringfecha = factura.getInfoNotaCredito().getFechaEmisionDocSustento();
			DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Date date = format.parse(stringfecha);

			encb.setNc_fechaemisiondocsustento(date);
			encb.setNc_valormodificacion(factura.getInfoNotaCredito().getValorModificacion().doubleValue());

			encb.setR_tipoidentificacionsujetoretenido("");
			encb.setR_razonsocialsujetoretenido("");
			encb.setR_identificacionsujetoretenido("");
			encb.setR_periodofiscal("");
			boolean insertado = Tbl_encabezadoFactory.getInstance(databaseobject).Insert(encb);
			if (insertado) {
				ec.gob.sri.comprobantes.modelo.notacredito.NotaCredito.Detalles detalle = factura.getDetalles();

				for (ec.gob.sri.comprobantes.modelo.notacredito.NotaCredito.Detalles.Detalle dt : detalle
						.getDetalle()) {

					String sql_id = "select  case when max(pk_detalle) is null then 1 else max(pk_detalle) + 1 end  from Tbl_detalle  ;";
					Object resultado = databaseobject.SQL_ESCALAR(sql_id);
					Integer pk_detalle = Integer.valueOf(resultado.toString());

					Tbl_detalle entidad = new Tbl_detalle();
					entidad.setCodigoprincipal(dt.getCodigoInterno());
					entidad.setCodigoauxiliar(dt.getCodigoAdicional());

					entidad.setDescripcion(dt.getDescripcion());
					entidad.setCantidad(dt.getCantidad().doubleValue());
					entidad.setPreciounitario(dt.getPrecioUnitario().doubleValue());
					entidad.setDescuento(dt.getDescuento().doubleValue());
					entidad.setPreciototalsinimpuesto(dt.getPrecioTotalSinImpuesto().doubleValue());
					entidad.setClaveacceso(factura.getInfoTributaria().getClaveAcceso());
					entidad.setPk_detalle(pk_detalle);
					boolean seinsertoDetalle = Tbl_detalleFactory.getInstance(databaseobject).Insert(entidad);
					if (seinsertoDetalle) {

						for (ec.gob.sri.comprobantes.modelo.notacredito.Impuesto impuesto : dt.getImpuestos()
								.getImpuesto()) {
							Tbl_impuestos_detalle tbl_impuestos_detalle = new Tbl_impuestos_detalle();
							tbl_impuestos_detalle.setCodigo(impuesto.getCodigo());
							tbl_impuestos_detalle.setCodigoporcentaje(impuesto.getCodigoPorcentaje());
							tbl_impuestos_detalle.setTarifa(impuesto.getTarifa().doubleValue());
							tbl_impuestos_detalle.setBaseimponible(impuesto.getBaseImponible().doubleValue());
							tbl_impuestos_detalle.setValor(impuesto.getValor().doubleValue());
							tbl_impuestos_detalle.setPk_detalle(pk_detalle);
							Tbl_impuestos_detalleFactory.getInstance(databaseobject).Insert(tbl_impuestos_detalle);
						}

					}

				}

				for (NotaCredito.InfoAdicional.CampoAdicional campoadicional : factura.getInfoAdicional()
						.getCampoAdicional()) {

					String sql_id = "select  case when max(pk_infodicional) is null then 1 else max(pk_infodicional) + 1 end  from Tbl_infoadicional    ;";
					Object resultado = databaseobject.SQL_ESCALAR(sql_id);
					Integer pk_infodicional = Integer.valueOf(resultado.toString());

					Tbl_infoadicional tbl_infoadicional = new Tbl_infoadicional();
					tbl_infoadicional.setPk_infodicional(pk_infodicional);
					tbl_infoadicional.setCampo(campoadicional.getNombre());
					tbl_infoadicional.setValor(campoadicional.getValue());
					tbl_infoadicional.setClaveacceso(factura.getInfoTributaria().getClaveAcceso());
					Tbl_infoadicionalFactory.getInstance(databaseobject).Insert(tbl_infoadicional);
				}

				for (ec.gob.sri.comprobantes.modelo.notacredito.TotalConImpuestos.TotalImpuesto impuest : factura
						.getInfoNotaCredito().getTotalConImpuestos().getTotalImpuesto()) {
					Tbl_totalimpuesto ttip = new Tbl_totalimpuesto();
					ttip.setClaveacceso(factura.getInfoTributaria().getClaveAcceso());
					ttip.setCodigo(impuest.getCodigo());
					ttip.setCodigoporcentaje(impuest.getCodigoPorcentaje());
					ttip.setValor(impuest.getValor().doubleValue());
					Tbl_totalimpuestoFactory.getInstance(databaseobject).Insert(ttip);

				}

			}

		} catch (Exception e) {

			System.out.println(e);
		}
	}

	private void insertFactura(byte[] xmlAutorizado) {
		try {
			Factura factura = XML2Java.unmarshalFactura(xmlAutorizado);
if("2003201801176804939000120010040000242072018203710".equals(factura.getInfoTributaria().getClaveAcceso() ))
	System.out.println("");
			String numeroAutorizacion = ArchivoUtils.obtenerValorXML(xmlAutorizado, "autorizacion/numeroAutorizacion");
			Tbl_encabezado encb = new Tbl_encabezado();
			encb.setClaveacceso(factura.getInfoTributaria().getClaveAcceso());
			encb.setAutorizacion(numeroAutorizacion);
			encb.setAmbiente(factura.getInfoTributaria().getAmbiente());
			encb.setCoddoc(factura.getInfoTributaria().getCodDoc());
			encb.setDirmatriz(factura.getInfoTributaria().getDirMatriz());
			encb.setEstab(factura.getInfoTributaria().getEstab());
			encb.setFechaemision(factura.getInfoFactura().getFechaEmision());
			encb.setTipoemision(factura.getInfoTributaria().getTipoEmision());
			encb.setRazonsocial(factura.getInfoTributaria().getRazonSocial());
			encb.setNombrecomercial(factura.getInfoTributaria().getNombreComercial());
			encb.setRuc(factura.getInfoTributaria().getRuc());
			encb.setPtoemi(factura.getInfoTributaria().getPtoEmi());
			encb.setSecuencial(factura.getInfoTributaria().getSecuencial());
			encb.setDirestablecimiento(factura.getInfoFactura().getDirEstablecimiento());
			encb.setObligadocontabilidad(factura.getInfoFactura().getObligadoContabilidad());
			encb.setTipoidentificacioncomprador(factura.getInfoFactura().getTipoIdentificacionComprador());
			encb.setRazonsocialcomprador(factura.getInfoFactura().getRazonSocialComprador());
			encb.setIdentificacioncomprador(factura.getInfoFactura().getTipoIdentificacionComprador());
			encb.setTotalsinimpuestos(factura.getInfoFactura().getTotalSinImpuestos().doubleValue());
			encb.setTotaldescuento(factura.getInfoFactura().getTotalDescuento().doubleValue());
			encb.setPropina(factura.getInfoFactura().getPropina()==null?0.0:factura.getInfoFactura().getPropina().doubleValue());
			encb.setImportetotal(factura.getInfoFactura().getImporteTotal().doubleValue());
			encb.setMoneda(factura.getInfoFactura().getMoneda());
			encb.setNc_rise(" ");
			encb.setNc_coddocmodificado(" ");
			encb.setNc_numdocmodificado(" ");
			encb.setNc_fechaemisiondocsustento(new Date());
			encb.setNc_valormodificacion(0);
			encb.setR_tipoidentificacionsujetoretenido("");
			encb.setR_razonsocialsujetoretenido("");
			encb.setR_identificacionsujetoretenido("");
			encb.setR_periodofiscal("");
			String sql = "delete from  Tbl_encabezado where claveacceso='"
					+ factura.getInfoTributaria().getClaveAcceso() + "'";

			databaseobject.SQL_COMMAND(sql);
			boolean insertado = Tbl_encabezadoFactory.getInstance(databaseobject).Insert(encb);
			if (insertado) {

				System.out.println("Insertado: " + factura.getInfoTributaria().getClaveAcceso());

				Detalles detalle = factura.getDetalles();
				for (Detalle dt : detalle.getDetalle()) {

					String sql_id = "select  case when max(pk_detalle) is null then 1 else max(pk_detalle) + 1 end  from Tbl_detalle  ;";
					Object resultado = databaseobject.SQL_ESCALAR(sql_id);
					Integer pk_detalle = Integer.valueOf(resultado.toString());

					Tbl_detalle entidad = new Tbl_detalle();
					entidad.setCodigoprincipal(dt.getCodigoPrincipal());
					entidad.setCodigoauxiliar(dt.getCodigoAuxiliar());
					entidad.setDescripcion(dt.getDescripcion());
					entidad.setCantidad(dt.getCantidad().doubleValue());
					entidad.setPreciounitario(dt.getPrecioUnitario().doubleValue());
					entidad.setDescuento(dt.getDescuento().doubleValue());
					entidad.setPreciototalsinimpuesto(dt.getPrecioTotalSinImpuesto().doubleValue());
					entidad.setClaveacceso(factura.getInfoTributaria().getClaveAcceso());
					entidad.setPk_detalle(pk_detalle);
					boolean seinsertoDetalle = Tbl_detalleFactory.getInstance(databaseobject).Insert(entidad);
					if (seinsertoDetalle) {
						for (Impuesto impuesto : dt.getImpuestos().getImpuesto()) {
							Tbl_impuestos_detalle tbl_impuestos_detalle = new Tbl_impuestos_detalle();
							tbl_impuestos_detalle.setCodigo(impuesto.getCodigo());
							tbl_impuestos_detalle.setCodigoporcentaje(impuesto.getCodigoPorcentaje());
							tbl_impuestos_detalle.setTarifa(impuesto.getTarifa().doubleValue());
							tbl_impuestos_detalle.setBaseimponible(impuesto.getBaseImponible().doubleValue());
							tbl_impuestos_detalle.setValor(impuesto.getValor().doubleValue());
							tbl_impuestos_detalle.setPk_detalle(pk_detalle);
							Tbl_impuestos_detalleFactory.getInstance(databaseobject).Insert(tbl_impuestos_detalle);
						}

					}

				}
				// if("0510201701099000573700120900010622055300509052313".equals(factura.getInfoTributaria().getClaveAcceso()))
				// System.out.println("");

				Pagos lstPagos = factura.getInfoFactura().getPagos();
				if (lstPagos != null)
					for (Pago pg : lstPagos.getPago()) {
						Tbl_pagos tbl_pagos = new Tbl_pagos();
						tbl_pagos.setClaveacceso(factura.getInfoTributaria().getClaveAcceso());
						tbl_pagos.setFormapago(pg.getFormaPago());
						tbl_pagos.setTotal(pg.getTotal().doubleValue());
						Tbl_pagosFactory.getInstance(databaseobject).Insert(tbl_pagos);
					}

				if (factura.getInfoAdicional() != null)
					for (CampoAdicional lstinfo : factura.getInfoAdicional().getCampoAdicional()) {
						String sql_id = "select  case when max(pk_infodicional) is null then 1 else max(pk_infodicional) + 1 end  from Tbl_infoadicional    ;";
						Object resultado = databaseobject.SQL_ESCALAR(sql_id);
						Integer pk_infodicional = Integer.valueOf(resultado.toString());
						Tbl_infoadicional tbl_infoadicional = new Tbl_infoadicional();
						tbl_infoadicional.setPk_infodicional(pk_infodicional);
						tbl_infoadicional.setCampo(lstinfo.getNombre());
						tbl_infoadicional.setValor(lstinfo.getValue());
						tbl_infoadicional.setClaveacceso(factura.getInfoTributaria().getClaveAcceso());
						Tbl_infoadicionalFactory.getInstance(databaseobject).Insert(tbl_infoadicional);
					}
				if (factura.getInfoFactura().getTotalConImpuestos() != null)
					for (TotalImpuesto impuest : factura.getInfoFactura().getTotalConImpuestos().getTotalImpuesto()) {
						Tbl_totalimpuesto ttip = new Tbl_totalimpuesto();
						ttip.setClaveacceso(factura.getInfoTributaria().getClaveAcceso());
						ttip.setCodigo(impuest.getCodigo());
						ttip.setCodigoporcentaje(impuest.getCodigoPorcentaje());
						ttip.setValor(impuest.getValor().doubleValue());
						Tbl_totalimpuestoFactory.getInstance(databaseobject).Insert(ttip);

					}

			}

		} catch (Exception e) {

			System.out.println(e);
		}
	}

	private void insertRetencion(byte[] xmlAutorizado) {
		try {
			ComprobanteRetencion retencion = XML2Java.unmarshalComprobanteRetencion(xmlAutorizado);
			String numeroAutorizacion = ArchivoUtils.obtenerValorXML(xmlAutorizado, "autorizacion/numeroAutorizacion");
			Tbl_encabezado encb = new Tbl_encabezado();
			encb.setAutorizacion(numeroAutorizacion);
			encb.setClaveacceso(retencion.getInfoTributaria().getClaveAcceso());
			encb.setAmbiente(retencion.getInfoTributaria().getAmbiente());
			encb.setCoddoc(retencion.getInfoTributaria().getCodDoc());
			encb.setDirmatriz(retencion.getInfoTributaria().getDirMatriz());
			encb.setEstab(retencion.getInfoTributaria().getEstab());
			encb.setFechaemision(retencion.getInfoCompRetencion().getFechaEmision());
			encb.setTipoemision(retencion.getInfoTributaria().getTipoEmision());
			encb.setRazonsocial(retencion.getInfoTributaria().getRazonSocial());
			encb.setNombrecomercial(retencion.getInfoTributaria().getNombreComercial());
			encb.setRuc(retencion.getInfoTributaria().getRuc());
			encb.setPtoemi(retencion.getInfoTributaria().getPtoEmi());
			encb.setSecuencial(retencion.getInfoTributaria().getSecuencial());
			encb.setDirestablecimiento(retencion.getInfoCompRetencion().getDirEstablecimiento());
			encb.setObligadocontabilidad(retencion.getInfoCompRetencion().getObligadoContabilidad());

			encb.setTipoidentificacioncomprador(retencion.getInfoCompRetencion().getTipoIdentificacionSujetoRetenido());
			encb.setRazonsocialcomprador(retencion.getInfoCompRetencion().getRazonSocialSujetoRetenido());
			encb.setIdentificacioncomprador(retencion.getInfoCompRetencion().getIdentificacionSujetoRetenido());
			encb.setTotalsinimpuestos(0);
			encb.setTotaldescuento(0);
			encb.setPropina(0);
			encb.setImportetotal(0);
			encb.setMoneda(" ");
			encb.setNc_rise(" ");
			encb.setNc_coddocmodificado(" ");
			encb.setNc_numdocmodificado(" ");
			encb.setNc_fechaemisiondocsustento(new Date());
			encb.setNc_valormodificacion(0);
			encb.setR_tipoidentificacionsujetoretenido(
					retencion.getInfoCompRetencion().getTipoIdentificacionSujetoRetenido());
			encb.setR_razonsocialsujetoretenido(retencion.getInfoCompRetencion().getRazonSocialSujetoRetenido());
			encb.setR_identificacionsujetoretenido(retencion.getInfoCompRetencion().getIdentificacionSujetoRetenido());
			encb.setR_periodofiscal(retencion.getInfoCompRetencion().getPeriodoFiscal());
			boolean insertado = Tbl_encabezadoFactory.getInstance(databaseobject).Insert(encb);
			if (insertado) {
				Impuestos detalle = retencion.getImpuestos();

				for (ec.gob.sri.comprobantes.modelo.rentencion.Impuesto dt : detalle.getImpuesto()) {

					Tbl_detalle_retencion entidad = new Tbl_detalle_retencion();
					entidad.setCodigo(dt.getCodigo());
					entidad.setCodigoretencion(dt.getCodigoRetencion());
					entidad.setBaseimponible(dt.getBaseImponible().doubleValue());
					entidad.setPorcentajeretener(dt.getPorcentajeRetener().doubleValue());
					entidad.setValorretenido(dt.getValorRetenido().doubleValue());
					entidad.setCoddocsustento(dt.getCodDocSustento());
					entidad.setNumdocsustento(dt.getNumDocSustento());
					entidad.setClaveacceso(retencion.getInfoTributaria().getClaveAcceso());
					String stringfecha = dt.getFechaEmisionDocSustento();
					DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
					Date date = format.parse(stringfecha);
					entidad.setFechaemisiondocsustento(date);

					Tbl_detalle_retencionFactory.getInstance(databaseobject).Insert(entidad);
				}

				for (ec.gob.sri.comprobantes.modelo.rentencion.ComprobanteRetencion.InfoAdicional.CampoAdicional lstinfo : retencion
						.getInfoAdicional().getCampoAdicional()) {

					String sql_id = "select  case when max(pk_infodicional) is null then 1 else max(pk_infodicional) + 1 end  from Tbl_infoadicional    ;";
					Object resultado = databaseobject.SQL_ESCALAR(sql_id);
					Integer pk_infodicional = Integer.valueOf(resultado.toString());

					Tbl_infoadicional tbl_infoadicional = new Tbl_infoadicional();
					tbl_infoadicional.setPk_infodicional(pk_infodicional);
					tbl_infoadicional.setCampo(lstinfo.getNombre());
					tbl_infoadicional.setValor(lstinfo.getValue());
					tbl_infoadicional.setClaveacceso(retencion.getInfoTributaria().getClaveAcceso());
					Tbl_infoadicionalFactory.getInstance(databaseobject).Insert(tbl_infoadicional);
				}

			}

		} catch (Exception e) {

			System.out.println(e);
		}
	}

	public static boolean leerArchivoConfiguracion(String passwd) {
		boolean aux = false;
		Path currentp = Paths.get("");
		String dir = currentp.toAbsolutePath().toString() + File.separator + "conexionfacdb";
		if (!Files.exists(Paths.get(dir))) {
			System.out.println("Error debe crear conexionfacdb en la direccion " + dir);
			return false;
		}
		// #IP;BASE;USUARIO;PASSWORD;PUERTO
		ArrayList<String> datos = new ArrayList<String>();
		try {
			FileInputStream fstream = new FileInputStream(dir);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			while ((strLine = br.readLine()) != null) {
				if (!strLine.contains("#"))
					datos.add(strLine);
			}
			br.close();
			aux = true;

			String[] bases = datos.get(0).split(";");
			Coneccion.ip = bases[0];
			Coneccion.bd = bases[1];
			Coneccion.usr = bases[2];
			Coneccion.puerto = bases[3];
			Coneccion.pass = passwd;

		} catch (Exception e) {

			aux = false;
		}
		return aux;
	}

	public String leerDatosEmisor(String ruc) {
		String msg = "";
		try {
		 
			String sql = "Select clave,ws_produccion_recepcion  ,ws_pruebas_recepcion "
					+ " ,ws_produccion_autorizacion  ,ws_pruebas_autorizacion ,"
					+ " modooffline, ruta_procesados , ruta_noprocesados  from tbl_emisor " + " where ruc ='" + ruc
					+ "' ";

			 
			ArrayList<List<Object>> lstDatos = databaseobject.SQL_SELECT_list(sql);
			if (lstDatos.size() == 0) {
				msg += "No se ha definido datos,  en la tabla tbl_emisor para el ruc:" + ruc;
			} else {

				if (lstDatos.get(0).get(0) != null)

					UrlSri.ws_produccion_recepcion = lstDatos.get(0).get(1).toString();
				UrlSri.ws_pruebas_recepcion = lstDatos.get(0).get(2).toString();
				UrlSri.ws_produccion_autorizacion = lstDatos.get(0).get(3).toString();
				UrlSri.ws_pruebas_autorizacion = lstDatos.get(0).get(4).toString();

				String esoffline = lstDatos.get(0).get(5).toString();
				UrlSri.isOffline = esoffline.equalsIgnoreCase("S");

			}

		} catch (Exception er) {
			System.out.println(er.getMessage());

		}

		return msg;
	}

	public String leerDatosEmpresa(String ruc, String codemp) {
		String msg = " ";
		Empresa empresa = new Empresa();
		try {
			String sqlfirma = "Select imagenlogo from empresa where ruc='" + ruc + "' and  codemp='" + codemp + "'";

			String sql = "select codemp, temamail, detallemail," + "  mail_server,mail_port,mail_userid,"
					+ " mail_authmethod, maiL_characterset,mail_password,nomemp,pathelec" + " from empresa where ruc='"
					+ ruc + "' and  codemp='" + codemp + "'";

			Object imagen = databaseobject.SQL_ESCALAR(sqlfirma);
			if (imagen == null)
				msg = "No se ha definido imagen en la tabla empresa para el ruc:" + ruc;
			else {
				byte[] logobyte = (byte[]) imagen;
				empresa.setImagenlogo(logobyte);
			}

			ArrayList<List<Object>> lstDatos = databaseobject.SQL_SELECT_list(sql);
			if (lstDatos.size() == 0) {
				msg += "No se ha definido datos,  en la tabla empresa para el ruc" + ruc;
			} else {

				String temamail = lstDatos.get(0).get(1) == null ? "" : lstDatos.get(0).get(1).toString();
				;
				String detallemail = lstDatos.get(0).get(2) == null ? "" : lstDatos.get(0).get(2).toString();
				;
				String mail_server = lstDatos.get(0).get(3) == null ? "" : lstDatos.get(0).get(3).toString();
				;
				String mail_port = lstDatos.get(0).get(4) == null ? "" : lstDatos.get(0).get(4).toString();
				;
				String mail_userid = lstDatos.get(0).get(5) == null ? "" : lstDatos.get(0).get(5).toString();
				;
				String mail_authmethod = lstDatos.get(0).get(6) == null ? "" : lstDatos.get(0).get(6).toString();
				;
				String maiL_characterset = lstDatos.get(0).get(7) == null ? "" : lstDatos.get(0).get(7).toString();
				;
				String mail_password = lstDatos.get(0).get(8) == null ? "" : lstDatos.get(0).get(8).toString();
				String nomemp = lstDatos.get(0).get(9) == null ? "" : lstDatos.get(0).get(9).toString();
				String pathelec = lstDatos.get(0).get(10) == null ? "" : lstDatos.get(0).get(10).toString();

				empresa.setTemamail(temamail);
				empresa.setDetallemail(detallemail);
				empresa.setMail_server(mail_server);
				empresa.setMail_port(mail_port);
				empresa.setMail_authmethod(mail_authmethod);
				empresa.setMail_userid(mail_userid);
				empresa.setMaiL_characterset(maiL_characterset);
				empresa.setMail_password(mail_password);
				empresa.setNomemp(nomemp);
				empresa.setPathelec(pathelec);
			}

		} catch (Exception er) {
			System.out.println(er.getMessage());

		}

		return msg;
	}

	public void setValorActivo(Boolean activo) throws Exception {
		String sql = "";
		if (activo)
			sql = " Update tbl_emisor set servicio_sri_activo = 'S' ";
		else
			sql = " Update tbl_emisor set servicio_sri_activo = 'N' ";

		int x = databaseobject.SQL_COMMAND(sql);
		System.out.println(x + "  " + activo);
	}

	public static boolean pingURL(String url, int timeout) throws Exception {
		Runtime runtime = Runtime.getRuntime();
		Process proc = runtime.exec("ping cel.sri.gob.ec");
		int mPingResult = proc.waitFor();
		if (mPingResult == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Para copiar Xml Generados
	 * 
	 * @throws IOException
	 */
	public void CopiaXmlGenerados(File origen, String clave_acceso, String ruta) throws IOException {

		File destino;

		try {
			destino = new File(ruta + File.separator + clave_acceso);
			InputStream in = new FileInputStream(origen);
			FileOutputStream out = new FileOutputStream(destino + ".xml");
			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			in.close();
			out.close();
			System.out.println("copiado a:" + destino.getAbsoluteFile());
			origen.delete();
		} catch (IOException ioe) {
			System.err.println("*****" + ioe.getMessage());
		}

		origen = null;
		destino = null;

	}

}
