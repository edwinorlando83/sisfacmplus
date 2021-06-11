/*    */ package ec.gob.sri.comprobantes.ws.aut;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name="autorizacionComprobante", propOrder={"claveAccesoComprobante"})
/*    */ public class AutorizacionComprobante
/*    */ {
/*    */   protected String claveAccesoComprobante;
/*    */ 
/*    */   public String getClaveAccesoComprobante()
/*    */   {
/* 45 */     return this.claveAccesoComprobante;
/*    */   }
/*    */ 
/*    */   public void setClaveAccesoComprobante(String value)
/*    */   {
/* 57 */     this.claveAccesoComprobante = value;
/*    */   }
/*    */ }

/* Location:           C:\componentes-1.1.7-with-deps\componentes-1.1.7\deps\cliente-file-ws.jar
 * Qualified Name:     ec.gob.sri.comprobantes.ws.aut.AutorizacionComprobante
 * JD-Core Version:    0.6.2
 */