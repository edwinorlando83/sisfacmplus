/*    */ package ec.gob.sri.comprobantes.util.xml;
import java.io.ByteArrayInputStream;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.util.logging.Level;
/*    */ import java.util.logging.Logger;

/*    */ import javax.xml.namespace.QName;
/*    */ import javax.xml.parsers.DocumentBuilder;
/*    */ import javax.xml.parsers.DocumentBuilderFactory;
/*    */ import javax.xml.parsers.ParserConfigurationException;
/*    */ import javax.xml.xpath.XPath;
/*    */ import javax.xml.xpath.XPathExpression;
/*    */ import javax.xml.xpath.XPathExpressionException;
/*    */ import javax.xml.xpath.XPathFactory;

/*    */ import org.w3c.dom.Document;
/*    */ import org.xml.sax.SAXException;
/*    */ 
/*    */ public class LectorXPath
/*    */ {
/*    */   private String xmlFile;
/*    */   private Document xmlDocument;
/*    */   private XPath xPath;
/*    */ private byte[] xmlFileByte;
/*    */   public LectorXPath(String xmlFile)
/*    */   {
/* 30 */     this.xmlFile = xmlFile;
/* 31 */     inicializar();
/*    */   }

/*    */   public LectorXPath(byte[] xmlFileByte)
/*    */   {
/* 30 */     this.xmlFileByte = xmlFileByte;
/* 31 */     inicializarByte();
/*    */   }


/*    */ private void inicializarByte() {
	/*    */ try {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		this.xmlDocument = builder.parse(new ByteArrayInputStream(xmlFileByte));
		/*    */ this.xPath = XPathFactory.newInstance().newXPath();
		/*    */ }
	/*    */ catch (IOException ex) {
		/* 41 */ Logger.getLogger(LectorXPath.class.getName()).log(Level.SEVERE, null, ex);

		/*    */ } catch (SAXException ex) {
		/* 43 */ Logger.getLogger(LectorXPath.class.getName()).log(Level.SEVERE, null, ex);
		System.err.println(LectorXPath.class.getName());
		/*    */ } catch (ParserConfigurationException ex) {
		/* 45 */ Logger.getLogger(LectorXPath.class.getName()).log(Level.SEVERE, null, ex);
		System.err.println(LectorXPath.class.getName());
		/*    */ }
	/*    */ }

/*    */   private void inicializar() {
/*    */     try {
/* 36 */       this.xmlDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(this.xmlFile);
/*    */       this.xPath = XPathFactory.newInstance().newXPath();
/*    */     }
/*    */     catch (IOException ex) {
/* 41 */       //Logger.getLogger(LectorXPath.class.getName()).log(Level.SEVERE, null, ex);
				System.err.println(ex+this.xmlFile );	
/*    */     } catch (SAXException ex) {
/* 43 */       //Logger.getLogger(LectorXPath.class.getName()).log(Level.SEVERE, null, ex);
				System.err.println(LectorXPath.class.getName());
/*    */     } catch (ParserConfigurationException ex) {
/* 45 */       //Logger.getLogger(LectorXPath.class.getName()).log(Level.SEVERE, null, ex);
				System.err.println(LectorXPath.class.getName());
/*    */     }
/*    */   }
/*    */ 
/*    */   public Object leerArchivo(String expression, QName returnType) {
/*    */     try {
/* 51 */       XPathExpression xPathExpression = this.xPath.compile(expression);
/* 52 */       return xPathExpression.evaluate(this.xmlDocument, returnType);
/*    */     } catch (XPathExpressionException ex) {
/* 54 */       Logger.getLogger(LectorXPath.class.getName()).log(Level.SEVERE, null, ex);
/* 55 */     }return null;
/*    */   }
/*    */ }

