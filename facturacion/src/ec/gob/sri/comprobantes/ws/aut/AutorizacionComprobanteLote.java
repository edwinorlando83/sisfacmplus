/*    */ package ec.gob.sri.comprobantes.ws.aut;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name="autorizacionComprobanteLote", propOrder={"claveAccesoLote"})
/*    */ public class AutorizacionComprobanteLote
/*    */ {
/*    */   protected String claveAccesoLote;
/*    */ 
/*    */   public String getClaveAccesoLote()
/*    */   {
/* 45 */     return this.claveAccesoLote;
/*    */   }
/*    */ 
/*    */   public void setClaveAccesoLote(String value)
/*    */   {
/* 57 */     this.claveAccesoLote = value;
/*    */   }
/*    */ }

/* Location:           C:\componentes-1.1.7-with-deps\componentes-1.1.7\deps\cliente-file-ws.jar
 * Qualified Name:     ec.gob.sri.comprobantes.ws.aut.AutorizacionComprobanteLote
 * JD-Core Version:    0.6.2
 */