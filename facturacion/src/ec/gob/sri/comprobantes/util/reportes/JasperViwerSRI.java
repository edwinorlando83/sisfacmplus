/*    */ package ec.gob.sri.comprobantes.util.reportes;
/*    */ import java.io.InputStream;
/*    */ import java.util.Locale;
/*    */ import java.util.ResourceBundle;

/*    */ import net.sf.jasperreports.engine.JRException;
/*    */ import net.sf.jasperreports.engine.JasperPrint;
/*    */ import net.sf.jasperreports.view.JRViewer;
/*    */ 
/*    */ public class JasperViwerSRI extends JRViewer
/*    */ {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/*    */   public JasperViwerSRI(JasperPrint jrPrint)
/*    */   {
/* 22 */     super(jrPrint);
/*    */   }
/*    */ 
/*    */   public JasperViwerSRI(JasperPrint jrPrint, Locale locale) {
/* 26 */     super(jrPrint, locale);
/*    */   }
/*    */ 
/*    */   public JasperViwerSRI(InputStream is, boolean isXML) throws JRException
/*    */   {
/* 31 */     super(is, isXML);
/*    */   }
/*    */ 
/*    */   public JasperViwerSRI(String fileName, boolean isXML, Locale locale) throws JRException {
/* 35 */     super(fileName, isXML, locale);
/*    */   }
/*    */ 
/*    */   public JasperViwerSRI(JasperPrint jrPrint, Locale locale, ResourceBundle resBundle) {
/* 39 */     super(jrPrint, locale, resBundle);
/*    */   }
/*    */ 
 
/*    */ }

