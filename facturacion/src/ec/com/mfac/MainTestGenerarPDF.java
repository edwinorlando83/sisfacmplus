package ec.com.mfac;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import ec.com.mfac.db.Coneccion;
import ec.com.mfac.db.DataBaseObject;
import ec.com.mfac.mail.Empresa;
import ec.com.mfac.mail.EnviarMail;
import ec.gob.sri.comprobantes.modelo.factura.Factura;
import ec.gob.sri.comprobantes.modelo.factura.Factura.InfoAdicional.CampoAdicional;
import ec.gob.sri.comprobantes.modelo.guia.GuiaRemision;
import ec.gob.sri.comprobantes.modelo.notacredito.NotaCredito;
import ec.gob.sri.comprobantes.modelo.notadebito.NotaDebito;
import ec.gob.sri.comprobantes.modelo.rentencion.ComprobanteRetencion;
import ec.gob.sri.comprobantes.util.ArchivoUtils;
import ec.gob.sri.comprobantes.util.VisualizacionRideUtil;
import ec.gob.sri.comprobantes.util.xml.XML2Java;

/**
 * @author Orlando
 *
 */
public class MainTestGenerarPDF extends TimerTask {
	static boolean ejecutar = false;
	DataBaseObject databaseobject;
	static ArrayList<Empresa> empresas;

	public MainTestGenerarPDF() {
		try {
			databaseobject = new DataBaseObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String clave_acceso = "2909202001180176902500120010100000198790001987917";
		try {

			if (args.length > 0) {
				clave_acceso = args[0];

			} else {
				System.out.println("Escriba la clave de acceso");
			}

			UrlSri.ws_produccion_recepcion = "https://cel.sri.gob.ec/comprobantes-electronicos-ws/RecepcionComprobantesOffline?wsdl";
			UrlSri.ws_pruebas_recepcion = "https://celcer.sri.gob.ec/comprobantes-electronicos-ws/RecepcionComprobantesOffline?wsdl";
			UrlSri.ws_pruebas_autorizacion = "https://celcer.sri.gob.ec/comprobantes-electronicos-ws/AutorizacionComprobantesOffline?wsdl";
			UrlSri.ws_produccion_autorizacion = "https://cel.sri.gob.ec/comprobantes-electronicos-ws/AutorizacionComprobantesOffline?wsdl";
			UrlSri.isOffline = true;

			FacturacionElectronica fe = new FacturacionElectronica();
			MensajeSri res = fe.consultarEnProduccion(clave_acceso);
			if (res.getEstado().equalsIgnoreCase("AUTORIZADO")) {
			//	MicroUtils mu = new MicroUtils();
			/*	byte[] inlogo = mu.getlogo(clave_acceso.substring(10, 23), clave_acceso.substring(24, 27));

				if (inlogo != null) {

					MainAutorizar.leerArchivoConfiguracion("AdminSQLplus.-18460");
					MainAutorizar main = new MainAutorizar();
					main.leerUrlSRI();
					ArrayList<Empresa> emps = main.leerDatosEmpresas();
					inlogo = emps.get(0).getImagenlogo();
					System.out.println(emps.get(0));

				}*/

				Empresa empresa2 = new Empresa();
				 
				  
				empresa2.setMail_server("mail.microplussql.com");
				empresa2.setMail_userid("ventas@microplussql.com");
				empresa2.setMail_password("Ventasmatriz.-18460");
				empresa2.setMail_port("465");
		 
			 	VisualizacionRideUtil visualizacionrideutil = new VisualizacionRideUtil(null, null);
			 	String spdfFile = visualizacionrideutil.generarPdf(res.getArchivoAutorizado(),empresa2);

			 
				 System.out.println(spdfFile);
			} else {
				System.out.println(res.getMensaje());

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	private void autorizar() {

		MainTestGenerarPDF.ejecutar = false;
		for (Empresa empresa : empresas) {

			ArrayList<File> archivos = leerXmls(empresa.getPathelec());
			System.out.println(" Archivos : " + archivos.size());
			for (File file : archivos) {
				try {
					byte[] xml = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
					byte[] archivop12 = empresa.getFirma();
					String password = empresa.getClave();
					FacturacionElectronica fe = new FacturacionElectronica(archivop12, password, xml);
					MensajeSri mensajesri = fe.enviar();
					String ruta_noprocesados = empresa.getRuta_noprocesados();
					String ruta_procesados = empresa.getRuta_procesados();

					String smg = insertAutorizado(file, mensajesri, ruta_noprocesados, ruta_procesados, empresa);
					System.out.println(smg);

				} catch (Exception er) {
					System.out.println(er);
					MainTestGenerarPDF.ejecutar = true;

				}

			}

		}
		MainTestGenerarPDF.ejecutar = true;

	}

	private String insertAutorizado(File file, MensajeSri mensajesri, String ruta_noprocesados, String ruta_procesados,
			Empresa empresa) throws Exception {
		String msg = "";
		byte[] archivodevuelto = mensajesri.getArchivoAutorizado();
		String claveAcceso = mensajesri.getClave_acceso();
		Date fechaAutorizacion = mensajesri.getFecha_autorizacion();
		String numeroAuto = mensajesri.getNumero_autorizacion();
		String estado = mensajesri.getEstado();
		String mensaje = mensajesri.getMensaje();

		String inSqlDelete = "delete from tbl_sri_autorizados  where claveacceso=? ";
		ArrayList<Object> inParametrosdelete = new ArrayList<Object>();
		inParametrosdelete.add(claveAcceso);
		databaseobject.SQL_COMMAND(inSqlDelete, inParametrosdelete);

		if (archivodevuelto != null && estado.equals("AUTORIZADO")) {
			System.out.println(" AUTORIZADO " + claveAcceso);

			File temp = File.createTempFile("tempfile", ".xml");
			FileOutputStream fos = new FileOutputStream(temp.getAbsolutePath());
			fos.write(archivodevuelto);
			fos.close();

			String codigo = " ";
			String control = " ";
			String mail_enviado = "0";
			String ruc_tercero = " ";
			String tipo = ArchivoUtils.obtenerTipoComprobante(archivodevuelto);
			if (tipo.equalsIgnoreCase("FA"))

			{

				Factura obj = XML2Java.unmarshalFactura(archivodevuelto);
				ruc_tercero = obj.getInfoFactura().getIdentificacionComprador();
				for (CampoAdicional info : obj.getInfoAdicional().getCampoAdicional()) {
					if (info.getNombre().equalsIgnoreCase("CONTROL"))
						control = info.getValue();
					if (info.getNombre().equalsIgnoreCase("codigo"))
						codigo = info.getValue();
				}

			}
			if (tipo.equalsIgnoreCase("CR"))

			{

				ComprobanteRetencion nd = XML2Java.unmarshalComprobanteRetencion(archivodevuelto);
				ruc_tercero = nd.getInfoCompRetencion().getIdentificacionSujetoRetenido();

				for (ec.gob.sri.comprobantes.modelo.rentencion.ComprobanteRetencion.InfoAdicional.CampoAdicional info : nd
						.getInfoAdicional().getCampoAdicional()) {
					if (info.getNombre().equalsIgnoreCase("CONTROL"))
						control = info.getValue();
					if (info.getNombre().equalsIgnoreCase("codigo"))
						codigo = info.getValue();
				}

			}
			if (tipo.equalsIgnoreCase("NC"))

			{

				NotaCredito nd = XML2Java.unmarshalNotaCredito(archivodevuelto);

				ruc_tercero = nd.getInfoNotaCredito().getIdentificacionComprador();

				for (ec.gob.sri.comprobantes.modelo.notacredito.NotaCredito.InfoAdicional.CampoAdicional info : nd
						.getInfoAdicional().getCampoAdicional()) {
					if (info.getNombre().equalsIgnoreCase("CONTROL"))
						control = info.getValue();
					if (info.getNombre().equalsIgnoreCase("codigo"))
						codigo = info.getValue();
				}

			}
			if (tipo.equalsIgnoreCase("ND"))

			{

				NotaDebito nd = XML2Java.unmarshalNotaDebito(archivodevuelto);
				ruc_tercero = nd.getInfoNotaDebito().getIdentificacionComprador();

				for (ec.gob.sri.comprobantes.modelo.notadebito.NotaDebito.InfoAdicional.CampoAdicional info : nd
						.getInfoAdicional().getCampoAdicional()) {
					if (info.getNombre().equalsIgnoreCase("CONTROL"))
						control = info.getValue();
					if (info.getNombre().equalsIgnoreCase("codigo"))
						codigo = info.getValue();
				}

			}

			if (tipo.equalsIgnoreCase("GR"))

			{

				GuiaRemision gr = XML2Java.unmarshalGuiaRemision(archivodevuelto);

				ruc_tercero = gr.getInfoGuiaRemision().getRucTransportista();
				for (ec.gob.sri.comprobantes.modelo.guia.GuiaRemision.InfoAdicional.CampoAdicional info : gr
						.getInfoAdicional().getCampoAdicional()) {
					if (info.getNombre().equalsIgnoreCase("CONTROL"))
						control = info.getValue();
					if (info.getNombre().equalsIgnoreCase("codigo"))
						codigo = info.getValue();
				}

			}

			String inSql = "INSERT INTO tbl_sri_autorizados (xml,claveacceso,fecha_autorizacion,numero_autorizacion,mensaje,estado,codigo,control,mail_enviado,ruc_tercero ) Values(?,?,?,?,?,?,?,?,?,?)";
			ArrayList<Object> inParametros = new ArrayList<Object>();
			inParametros.add(claveAcceso);
			inParametros.add(fechaAutorizacion);
			inParametros.add(numeroAuto);
			inParametros.add(mensaje);
			inParametros.add(estado);
			inParametros.add(codigo);
			inParametros.add(control);
			inParametros.add(mail_enviado);
			inParametros.add(ruc_tercero);
			databaseobject.SQL_ESCALAR_UPDATE_FILE(inSql, inParametros, temp, true);
			EnviarMail envio = new EnviarMail(empresa);
			envio.enviarMailaDestinatario(archivodevuelto, mensajesri.getClave_acceso());
			CopiaXmlGenerados(file, mensajesri.getClave_acceso(), ruta_procesados);
		} else {

			String inSql = "INSERT INTO tbl_sri_autorizados ( claveacceso,  mensaje,estado ) Values(?,?,?)";
			ArrayList<Object> inParametros = new ArrayList<Object>();
			inParametros.add(claveAcceso);
			inParametros.add(mensaje);
			inParametros.add(estado);
			databaseobject.SQL_COMMAND(inSql, inParametros);

			if (mensaje != null && !mensaje.toUpperCase().contains("PROCESAMIEN"))
				CopiaXmlGenerados(file, mensajesri.getClave_acceso(), ruta_noprocesados);
		}

		msg = "Finalizado:" + estado;
		return msg;
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

	public String leerUrlSRI() {
		String msg = "";
		try {

			String sql = "Select clave,ws_produccion_recepcion  ,ws_pruebas_recepcion "
					+ " ,ws_produccion_autorizacion  ,ws_pruebas_autorizacion ,"
					+ " modooffline, ruta_procesados , ruta_noprocesados  from tbl_emisor  ";
			ArrayList<List<Object>> lstDatos = databaseobject.SQL_SELECT_list(sql);
			if (lstDatos.size() == 0) {
				msg += "No se ha definido datos,  en la tabla tbl_emisor  ";
			} else {

				if (lstDatos.get(0) != null)

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

	public ArrayList<Empresa> leerDatosEmpresas() {

		ArrayList<Empresa> empresaLst = new ArrayList<Empresa>();
		try {

			String sql = "select distinct codemp, temamail, detallemail," + "  mail_server,mail_port,mail_userid,"
					+ " mail_authmethod, maiL_characterset,mail_password,nomemp,pathelecplus" + " ,ruc from empresa";

			ArrayList<List<Object>> lstDatos = databaseobject.SQL_SELECT_list(sql);

			for (List<Object> row : lstDatos) {
				Empresa empresa = new Empresa();
				String temamail = row.get(1) == null ? "" : row.get(1).toString();
				String detallemail = row.get(2) == null ? "" : row.get(2).toString();
				String mail_server = row.get(3) == null ? "" : row.get(3).toString();
				String mail_port = row.get(4) == null ? "" : row.get(4).toString();
				String mail_userid = row.get(5) == null ? "" : row.get(5).toString();
				String mail_authmethod = row.get(6) == null ? "" : row.get(6).toString();
				String maiL_characterset = row.get(7) == null ? "" : row.get(7).toString();
				String mail_password = row.get(8) == null ? "" : row.get(8).toString();
				String nomemp = row.get(9) == null ? "" : row.get(9).toString();
				String pathelec = row.get(10) == null ? "" : row.get(10).toString();
				String ruc = row.get(11) == null ? "" : row.get(11).toString();

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

				String sqlLogo = "Select imagenlogo from empresa where ruc='" + ruc + "' ";
				Object imagen = databaseobject.SQL_ESCALAR(sqlLogo);
				if (imagen != null) {
					byte[] logobyte = (byte[]) imagen;
					empresa.setImagenlogo(logobyte);
				}

				String sqlfirma = "Select firma from tbl_emisor where ruc ='" + ruc + "' ";
				Object firma = databaseobject.SQL_ESCALAR(sqlfirma);
				if (firma != null) {
					byte[] firmabyte = (byte[]) firma;
					empresa.setFirma(firmabyte);
				}
				String sqlOtros = "select 	formato_fc, formato_nc, formato_nd, formato_gu, formato_rt,clave, ruta_procesados,ruta_noprocesados  from tbl_emisor where ruc='"
						+ ruc + "' ";
				ArrayList<List<Object>> lstOtrosDatos = databaseobject.SQL_SELECT_list(sqlOtros);

				String formato_fc = "";
				String formato_nc = "";
				String formato_nd = "";
				String formato_gu = "";
				String formato_rt = "";

				String clave = "";
				String ruta_procesados = "";
				String ruta_noprocesados = "";
				if (lstOtrosDatos.size() > 0) {
					formato_fc = lstOtrosDatos.get(0).get(0) == null ? "factura"
							: lstOtrosDatos.get(0).get(0).toString();
					formato_nc = lstOtrosDatos.get(0).get(1) == null ? "notaCreditoFinal"
							: lstOtrosDatos.get(0).get(1).toString();
					formato_nd = lstOtrosDatos.get(0).get(2) == null ? "notaDebitoFinal"
							: lstOtrosDatos.get(0).get(2).toString();
					formato_gu = lstOtrosDatos.get(0).get(3) == null ? "guiaRemisionFinal"
							: lstOtrosDatos.get(0).get(3).toString();
					formato_rt = lstOtrosDatos.get(0).get(4) == null ? "comprobanteRetencion"
							: lstOtrosDatos.get(0).get(4).toString();
					clave = lstOtrosDatos.get(0).get(5) == null ? "" : lstOtrosDatos.get(0).get(5).toString();
					ruta_procesados = lstOtrosDatos.get(0).get(6) == null ? "" : lstOtrosDatos.get(0).get(6).toString();
					ruta_noprocesados = lstOtrosDatos.get(0).get(7) == null ? ""
							: lstOtrosDatos.get(0).get(7).toString();
					empresa.setFormato_fc(formato_fc);
					empresa.setFormato_nc(formato_nc);
					empresa.setFormato_nd(formato_nd);
					empresa.setFormato_gu(formato_gu);
					empresa.setFormato_rt(formato_rt);
					empresa.setClave(clave);
					empresa.setRuta_procesados(ruta_procesados);
					empresa.setRuta_noprocesados(ruta_noprocesados);

				}

				empresaLst.add(empresa);

			}

		} catch (

		Exception er) {
			System.out.println(er.getMessage());

		}

		return empresaLst;
	}

	public void setValorActivo(Boolean activo) throws Exception {
		String sql = "";
		if (activo)
			sql = " Update tbl_emisor set servicio_sri_activo = 'S' ";
		else
			sql = " Update tbl_emisor set servicio_sri_activo = 'N' ";

		databaseobject.SQL_COMMAND(sql);

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
	public void CopiaXmlGenerados(File origen, String clave_acceso, String ruta) {

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

	private ArrayList<File> leerXmls(String path) {
		ArrayList<File> archivos = new ArrayList<File>();
		File carpeta = new File(path);
		if (carpeta.listFiles() != null) {
			for (File file : carpeta.listFiles())
				if (file.isDirectory() == false && esXML(file))
					archivos.add(file);

		}
		return archivos;

	}

	private boolean esXML(File file) {
		boolean retorno = false;
		try {
			InputStream is = new BufferedInputStream(new FileInputStream(file));
			file = null;
			String mimeType = URLConnection.guessContentTypeFromStream(is);
			is.close();
			is = null;
			if (mimeType != null && mimeType.contains("xml"))
				retorno = true;
		} catch (Exception er) {
			retorno = false;
		}
		return retorno;
	}

	@Override
	public void run() {
		MainTestGenerarPDF main = new MainTestGenerarPDF();
		main.autorizar();
	}
}
