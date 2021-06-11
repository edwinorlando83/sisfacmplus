package ec.gob.sri.comprobantes.util;

import java.text.SimpleDateFormat;

public class Constantes {

	public static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	public static final SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
	public static final int INTENTOS_CONEXION_WS = 3;
	public static final int INTENTOS_RESPUESTA_AUTORIZACION_WS = 5;

}
