/*    */ package ec.gob.sri.comprobantes.ws.aut;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlElement;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name="autorizacionComprobanteLoteResponse", propOrder={"respuestaAutorizacionLote"})
/*    */ public class AutorizacionComprobanteLoteResponse
/*    */ {
/*    */ 
/*    */   @XmlElement(name="RespuestaAutorizacionLote")
/*    */   protected RespuestaLote respuestaAutorizacionLote;
/*    */ 
/*    */   public RespuestaLote getRespuestaAutorizacionLote()
/*    */   {
/* 47 */     return this.respuestaAutorizacionLote;
/*    */   }
/*    */ 
/*    */   public void setRespuestaAutorizacionLote(RespuestaLote value)
/*    */   {
/* 59 */     this.respuestaAutorizacionLote = value;
/*    */   }
/*    */ }

/* Location:           C:\componentes-1.1.7-with-deps\componentes-1.1.7\deps\cliente-file-ws.jar
 * Qualified Name:     ec.gob.sri.comprobantes.ws.aut.AutorizacionComprobanteLoteResponse
 * JD-Core Version:    0.6.2
 */