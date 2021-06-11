package ec.com.mfac.db;

import java.util.ArrayList;


public class SentenciasSQL {
	DataBaseObject databaseobject;

	public SentenciasSQL(DataBaseObject bd) {
		this.databaseobject = bd;
	}

	public ArrayList<Tbl_xml_generados> getXml(int numhilo) throws Exception {
		 
		String inSql = "SELECT clave_acceso,estado  FROM  tbl_xml_generados where estado='INGRESADO' and xml is not null  and hilo=  "+ numhilo +
				"  or ( MENSAJE  LIKE '%NO EXISTE UN REGISTRO RELACIONADO CON LA CLAVE DE ACCESO%' or MENSAJE  LIKE '%ACCESO REGISTRADA%'    OR  ( MENSAJE  LIKE '%PROCESAMIENTO%' and hilo="+numhilo+"  ) )  ";
		ArrayList<Tbl_xml_generados> lista = databaseobject.SQL_Select(Tbl_xml_generados.class, inSql);
		return lista;

	}
}
