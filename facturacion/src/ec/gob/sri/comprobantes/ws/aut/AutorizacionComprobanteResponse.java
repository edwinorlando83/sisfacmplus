/*    */ package ec.gob.sri.comprobantes.ws.aut;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlElement;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name="autorizacionComprobanteResponse", propOrder={"respuestaAutorizacionComprobante"})
/*    */ public class AutorizacionComprobanteResponse
/*    */ {
/*    */ 
/*    */   @XmlElement(name="RespuestaAutorizacionComprobante")
/*    */   protected RespuestaComprobante respuestaAutorizacionComprobante;
/*    */ 
/*    */   public RespuestaComprobante getRespuestaAutorizacionComprobante()
/*    */   {
/* 47 */     return this.respuestaAutorizacionComprobante;
/*    */   }
/*    */ 
/*    */   public void setRespuestaAutorizacionComprobante(RespuestaComprobante value)
/*    */   {
/* 59 */     this.respuestaAutorizacionComprobante = value;
/*    */   }
/*    */ }

/* Location:           C:\componentes-1.1.7-with-deps\componentes-1.1.7\deps\cliente-file-ws.jar
 * Qualified Name:     ec.gob.sri.comprobantes.ws.aut.AutorizacionComprobanteResponse
 * JD-Core Version:    0.6.2
 */