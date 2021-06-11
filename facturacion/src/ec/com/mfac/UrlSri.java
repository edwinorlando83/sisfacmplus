package ec.com.mfac;

public class UrlSri {
public static boolean isOffline;

 public static String ws_produccion_recepcion  ,ws_pruebas_recepcion  ,ws_produccion_autorizacion  ,ws_pruebas_autorizacion;
 
 
	public static String devuelveUrlWs(String ambiente, String nombreServicio ) {
	 
		if (nombreServicio.equalsIgnoreCase("RecepcionComprobantes")) {
			if (ambiente.equals("1"))
				return ws_pruebas_recepcion;
			else
				return ws_produccion_recepcion;
		} else {
			if (ambiente.equals("1"))
				return ws_pruebas_autorizacion;
			else
				return ws_produccion_autorizacion;
		}
	}
	
	   
		
	
	public static String get_wsdlbBinding_Autorizacion()
	{
		
		if (	isOffline==true)
			return "AutorizacionComprobantesOfflineService";
		else
			return "AutorizacionComprobantesService";
	}
	public static String get_wsdlPort_Autorizacion()
	{
		
		if (	isOffline==true)
			return "AutorizacionComprobantesOfflinePort";
		else
			return "AutorizacionComprobantesPort";
	}
	 
	public static String get_wsdlbBinding_Recepcion()
	{
		
		if (	isOffline==true)
			return "RecepcionComprobantesOffline";
		else
			return "RecepcionComprobantes";
	}
	public static String get_wsdlPort_Recepcion()
	{
		
		if (	isOffline==true)
			return "RecepcionComprobantesOfflinePort";
		else
			return "RecepcionComprobantesPort";
	}
		
	
	public static String get_RecepcionComprobantes()
	{	
		if (isOffline==true)
			return "RecepcionComprobantesOfflineService";
		else
			return "RecepcionComprobantesService";
	}
}
