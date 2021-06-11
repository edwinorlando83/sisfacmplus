/*    */ package ec.gob.sri.comprobantes.ws;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlElement;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name="validarComprobanteResponse", propOrder={"respuestaRecepcionComprobante"})
/*    */ public class ValidarComprobanteResponse
/*    */ {
/*    */ 
/*    */   @XmlElement(name="RespuestaRecepcionComprobante")
/*    */   protected RespuestaSolicitud respuestaRecepcionComprobante;
/*    */ 
/*    */   public RespuestaSolicitud getRespuestaRecepcionComprobante()
/*    */   {
/* 47 */     return this.respuestaRecepcionComprobante;
/*    */   }
/*    */ 
/*    */   public void setRespuestaRecepcionComprobante(RespuestaSolicitud value)
/*    */   {
/* 59 */     this.respuestaRecepcionComprobante = value;
/*    */   }
/*    */ }

/* Location:           C:\componentes-1.1.7-with-deps\componentes-1.1.7\deps\cliente-file-ws.jar
 * Qualified Name:     ec.gob.sri.comprobantes.ws.ValidarComprobanteResponse
 * JD-Core Version:    0.6.2
 */