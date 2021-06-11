package ec.gob.sri.comprobantes.view.formas.comprobantes;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import es.mityc.firmaJava.libreria.xades.DataToSign;
import es.mityc.firmaJava.libreria.xades.FirmaXML;

public abstract class GenericXMLSignature {


    //Path de la firma electronica
    private byte[] fileSignature;
    //calve de la firma electronica
    private String passSignature;
    
    /*Metodos Getters y Setters (Propiedades)*/
    public byte[] getPathSignature() {
        return fileSignature;
    }

    public void setPathSignature(byte[] pathSignature) {
        this.fileSignature = pathSignature;
    }

    public String getPassSignature() {
        return passSignature;
    }

    public void setPassSignature(String passSignature) {
        this.passSignature = passSignature;
    }
  
    protected File execute() throws IOException {
    
        // Obtencion del gestor de claves
        KeyStore keyStore = getKeyStore();
      
        if(keyStore==null){
            System.err.println("No se pudo obtener almacen de firma.");
            return null;
        }
        String alias=getAlias(keyStore);
      
        // Obtencion del certificado para firmar. Utilizaremos el primer
        // certificado del almacen.          
        X509Certificate certificate = null;
        try {
            certificate = (X509Certificate)keyStore.getCertificate(alias);
            if (certificate == null) {
                System.err.println("No existe ningun certificado para firmar.");
                return null;
            }
        } catch (KeyStoreException e1) {
        	  System.out.println("Error en: 1) FIRMA, 2) PASSWORD o 3)CARACTERES ESPECIALES EN EL XML");
        }
          
        PrivateKey privateKey = null;
        KeyStore tmpKs = keyStore;
        try {
            privateKey = (PrivateKey) tmpKs.getKey(alias, this.passSignature.toCharArray());
        } catch (UnrecoverableKeyException e) {
            System.err.println("No existe clave privada para firmar.");
           
        } catch (KeyStoreException e) {
            System.err.println("No existe clave privada para firmar.");
           
        } catch (NoSuchAlgorithmException e) {
            System.err.println("No existe clave privada para firmar.");
            
        }
    
         
         Provider provider = keyStore.getProvider();        
         DataToSign dataToSign = createDataToSign();
     
         FirmaXML firma = new FirmaXML();

         // Firmamos el documento
         Document docSigned = null;
         try {
             Object[] res = firma.signFile(certificate, dataToSign, privateKey, provider);
             docSigned = (Document) res[0];
         } catch (Exception ex) {
             System.err.println("Error realizando la firma");           
             return null;
         }
       File temp = File.createTempFile("MicroPlusSQL", ".xml"); 
     
         saveDocumenteDisk(docSigned, temp);
		return temp;
    }
    
     /**
      *
      * Crea el objeto DataToSign que contiene toda la informaci�n de la firma
      * que se desea realizar. Todas las implementaciones deber�n proporcionar
      * una implementaci�n de este m�todo
      *

      *
     * @return El objeto DataToSign que contiene toda la informaci�n de la firma
      *         a realizar
      */
    protected abstract DataToSign createDataToSign();

    
    protected abstract String getSignatureFileName();
  
    protected abstract String getPathOut();
   

  
     protected Document getDocument(byte[] documentoXml) {
         Document doc = null;
         DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
         dbf.setNamespaceAware(true);
         
         try {
            DocumentBuilder db = dbf.newDocumentBuilder();
          
            doc=db.parse(new ByteArrayInputStream(documentoXml));
         } catch (ParserConfigurationException ex) {
             System.err.println("Error al parsear el documento");
             ex.printStackTrace();
             //System.exit(-1);
         } catch (SAXException ex) {
             System.err.println("Error al parsear el documento");
             ex.printStackTrace();
             //System.exit(-1);
         } catch (IOException ex) {
             System.err.println("Error al parsear el documento");
             ex.printStackTrace();
             //System.exit(-1);
         } catch (IllegalArgumentException ex) {
            System.err.println("Error al parsear el documento");
             ex.printStackTrace();
            //System.exit(-1);
         }
         return doc;
     }

   
     private KeyStore getKeyStore()
     {
         KeyStore ks = null;
        try {
            ks = KeyStore.getInstance("PKCS12");
            
    
            InputStream fis=new ByteArrayInputStream(fileSignature);;
            ks.load(fis, passSignature.toCharArray());
        } catch (KeyStoreException e) {
             e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
           e.printStackTrace();
        } catch (IOException e) {
           e.printStackTrace();
        }
         return ks;
     }

     private static String getAlias(KeyStore keyStore)
     {
         String alias = null;
         Enumeration<?> nombres;
           try {
               nombres = keyStore.aliases();
                 
               while(nombres.hasMoreElements())
               {
                   String tmpAlias = (String)nombres.nextElement();
                   if(keyStore.isKeyEntry(tmpAlias))
                   alias=tmpAlias;
               }
           }
           catch (KeyStoreException e) {
               //e.printStackTrace();
           }
           return alias;
     }

 public static void saveDocumenteDisk(Document document,File Xml)
     {
         try {
                 DOMSource source = new DOMSource(document);
                 StreamResult result = new StreamResult(Xml);
                 TransformerFactory transformerFactory = TransformerFactory.newInstance();
                 Transformer transformer;
                 transformer = transformerFactory.newTransformer();
                 transformer.transform(source, result);
                 
         }  catch (TransformerConfigurationException e) {
               
        	     System.err.println("Error al parsear el documento"+e.getMessage());
              
         }  catch (TransformerException e) {
                
                 System.err.println("Error al parsear el documento"+e.getMessage());
         }
       
     }
}

