package ec.com.mfac;

import ec.com.mfac.db.DataBaseObject;

public class MicroUtils {
 
	public MicroUtils(  )
	{
	 
		
	}
	public byte[] getlogo(String ruc, String serie)  
	{
		byte[] logobyte =null;
		try
		{
	
		DataBaseObject databaseobject = new DataBaseObject();
		
		String sqlLogo = "select  es.imagenestabl from  establecimientos es inner join empresa em on ( es.codemp = em.codemp ) where  em.ruc = '"+ruc+"' and es.establ ='"+serie+"' ";
		Object imagen = databaseobject.SQL_ESCALAR(sqlLogo); 
		if (imagen != null) {
		 logobyte = (byte[]) imagen;			 
		} 
		}
		catch (Exception er)
		{
			 System.out.println(er);
			logobyte=null;
			
		}
		
		return logobyte;
		
	}
	 

}
