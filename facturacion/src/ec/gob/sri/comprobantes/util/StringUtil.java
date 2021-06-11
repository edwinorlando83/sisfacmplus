package ec.gob.sri.comprobantes.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;

public class StringUtil {
	public static boolean validateEmail(String email) {
		/* 19 */ Pattern p = Pattern
				.compile("[a-zA-Z0-9]+[.[a-zA-Z0-9_-]+]*@[a-z0-9][\\w\\.-]*[a-z0-9]\\.[a-z][a-z\\.]*[a-z]$");
		/* 20 */ Matcher m = p.matcher(email);
		/* 21 */ return m.matches();
	}

	public static String getTipoIdentificacion(String tipoIddentificacion) {
		/* 25 */ if (tipoIddentificacion.equals("CEDULA")) {
			/* 26 */ return "C";
		}
		/* 28 */ if (tipoIddentificacion.equals("RUC")) {
			/* 29 */ return "R";
		}
		/* 31 */ if (tipoIddentificacion.equals("PASAPORTE")) {
			/* 32 */ return "P";
		}
		/* 34 */ if (tipoIddentificacion.equals("PASAPORTE")) {
			/* 35 */ return null;
		}
		/* 37 */ return null;
	}

	public static String getSlectedItem(String tipoIddentificacion) {
		/* 41 */ if (tipoIddentificacion.equals("C")) {
			/* 42 */ return "CEDULA";
		}
		/* 44 */ if (tipoIddentificacion.equals("R")) {
			/* 45 */ return "RUC";
		}
		/* 47 */ if (tipoIddentificacion.equals("P")) {
			/* 48 */ return "PASAPORTE";
		}
		/* 50 */ if (tipoIddentificacion.equals("")) {
			/* 51 */ return "SELECCIONE";
		}
		/* 53 */ return null;
	}

	public static String getSlectedItemTipoProducto(String tipoIddentificacion) {
		/* 57 */ if (tipoIddentificacion.equals("B")) {
			/* 58 */ return "BIEN";
		}
		/* 60 */ if (tipoIddentificacion.equals("S")) {
			/* 61 */ return "SERVICIO";
		}
		/* 63 */ return null;
	}

	public static String getSelectedTipoAmbiente(String tipoIddentificacion) {
		/* 67 */ if (tipoIddentificacion.equals("2")) {
			/* 68 */ return "PRODUCCION";
		}
		/* 70 */ if (tipoIddentificacion.equals("1")) {
			/* 71 */ return "PRUEBAS";
		}
		/* 73 */ return null;
	}

	public static void convertirMayusculas(JTextField field) {
		/* 77 */ ConvertirMayusculas filter = new ConvertirMayusculas();
		/* 78 */ ((AbstractDocument) field.getDocument()).setDocumentFilter(filter);
	}

	public static void convertirMinusculas(JTextField field) {
		/* 82 */ ConvertirMinusculas filter = new ConvertirMinusculas();
		/* 83 */ ((AbstractDocument) field.getDocument()).setDocumentFilter(filter);
	}

	public static String obtenerTipoEmision(String valorCombo) {
		/* 87 */ if (valorCombo.equalsIgnoreCase("NORMAL")) {
			/* 88 */ return "1";
		}
		/* 90 */ if (valorCombo.equalsIgnoreCase("INDISPONIBILIDAD DE SISTEMA")) {
			/* 91 */ return "2";
		}
		/* 93 */ return null;
	}

	public static String obtenerNumeroTipoEmision(String tipoEmision) {
		/* 97 */ if (tipoEmision.equalsIgnoreCase("1")) {
			/* 98 */ return "NORMAL";
		}
		/* 100 */ if (tipoEmision.equalsIgnoreCase("3")) {
			/* 101 */ return "BAJA CONECTIVIDAD";
		}
		/* 103 */ if (tipoEmision.equalsIgnoreCase("2")) {
			/* 104 */ return "INDISPONIBILIDAD DE SISTEMA";
		}
		/* 106 */ return null;
	}

	public static String quitarEnters(String cadenConEnters) {
		/* 110 */ String cadenaSinEnters = null;
		/* 111 */ for (int x = 0; x < cadenConEnters.length(); x++) {
			/* 112 */ if (cadenConEnters.charAt(x) == '\t') {
				/* 113 */ cadenaSinEnters = cadenaSinEnters + cadenConEnters.charAt(x);
			}
		}
		/* 116 */ return cadenaSinEnters;
	}

	public static boolean validarExpresionRegular(String patron, String valor) {
		/* 120 */ if ((patron != null) && (valor != null)) {
			/* 121 */ Pattern pattern = Pattern.compile(patron);
			/* 122 */ Matcher matcher = pattern.matcher(valor);
			/* 123 */ return matcher.matches();
		}
		/* 125 */ return false;
	}

	public static String obtenerDocumentoModificado(String codDoc) {
		/* 129 */ if ("01".equals(codDoc)) {
			/* 130 */ return "FACTURA";
		}
		/* 132 */ if ("04".equals(codDoc)) {
			/* 133 */ return "NOTA DE CREDITO";
		}
		/* 135 */ if ("05".equals(codDoc)) {
			/* 136 */ return "NOTA DE DEBITO";
		}
		/* 138 */ if ("06".equals(codDoc)) {
			/* 139 */ return "GUIA REMISION";
		}
		/* 141 */ if ("07".equals(codDoc)) {
			/* 142 */ return "COMPROBANTE DE RETENCION";
		}
		/* 144 */ return null;
	}
}

 