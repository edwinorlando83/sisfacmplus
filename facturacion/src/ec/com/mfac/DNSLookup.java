package ec.com.mfac;

import java.sql.Connection;
import java.sql.DriverManager;

public class DNSLookup
{ 
	
	public static void main(String args[]){
		//connection url
		String url = "jdbc:ucanaccess://D:\\Users\\TCP\\Documents\\Database1.accdb";
		
		try {	
				//establishing connection
				Connection con = DriverManager.getConnection(url);
	
				if(con!=null){
					System.out.println("Connection Successful!");
					con.close();
				}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}