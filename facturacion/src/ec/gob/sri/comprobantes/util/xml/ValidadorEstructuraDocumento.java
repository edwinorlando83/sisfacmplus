/*    */ package ec.gob.sri.comprobantes.util.xml;
/*    */ 
/*    */ import java.io.File;
/*    */ import javax.xml.transform.stream.StreamSource;
/*    */ import javax.xml.validation.Schema;
/*    */ import javax.xml.validation.SchemaFactory;
/*    */ import javax.xml.validation.Validator;
/*    */ import org.xml.sax.SAXException;
/*    */ 
/*    */ public class ValidadorEstructuraDocumento
/*    */ {
/*    */   private File archivoXSD;
/*    */   private File archivoXML;
/*    */ 
/*    */   public String validacion()
/*    */   {
/* 35 */     validarArchivo(this.archivoXSD, "archivoXSD");
/* 36 */     validarArchivo(this.archivoXML, "archivoXML");
/*    */ 
/* 38 */     String mensaje = null;
/*    */ 
/* 40 */     SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
/*    */     Schema schema;
/*    */     try
/*    */     {
/* 43 */       schema = schemaFactory.newSchema(this.archivoXSD);
/*    */     } catch (SAXException e) {
/* 45 */       throw new IllegalStateException("Existe un error en la sintaxis del esquema", e);
/*    */     }
/* 47 */     Validator validator = schema.newValidator();
/*    */     try {
/* 49 */       validator.validate(new StreamSource(this.archivoXML));
/*    */     }
/*    */     catch (Exception e) {
/* 52 */       return e.getMessage();
/*    */     }
/* 54 */     return mensaje;
/*    */   }
/*    */ 
/*    */   protected void validarArchivo(File archivo, String nombre)
/*    */     throws IllegalStateException
/*    */   {
/* 61 */     if ((null == archivo) || (archivo.length() <= 0L))
/* 62 */       throw new IllegalStateException(nombre + " es nulo o esta vacio");
/*    */   }
/*    */ 
/*    */   public File getArchivoXSD()
/*    */   {
/* 70 */     return this.archivoXSD;
/*    */   }
/*    */ 
/*    */   public void setArchivoXSD(File archivoXSD)
/*    */   {
/* 77 */     this.archivoXSD = archivoXSD;
/*    */   }
/*    */ 
/*    */   public File getArchivoXML()
/*    */   {
/* 84 */     return this.archivoXML;
/*    */   }
/*    */ 
/*    */   public void setArchivoXML(File archivoXML)
/*    */   {
/* 91 */     this.archivoXML = archivoXML;
/*    */   }
/*    */ }

/* Location:           C:\prolan\ce\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.xml.ValidadorEstructuraDocumento
 * JD-Core Version:    0.6.2
 */