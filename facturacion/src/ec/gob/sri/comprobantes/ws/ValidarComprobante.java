/*    */ package ec.gob.sri.comprobantes.ws;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name="validarComprobante", propOrder={"xml"})
/*    */ public class ValidarComprobante
/*    */ {
/*    */   protected byte[] xml;
/*    */ 
/*    */   public byte[] getXml()
/*    */   {
/* 44 */     return this.xml;
/*    */   }
/*    */ 
/*    */   public void setXml(byte[] value)
/*    */   {
/* 55 */     this.xml = ((byte[])value);
/*    */   }
/*    */ }

/* Location:           C:\componentes-1.1.7-with-deps\componentes-1.1.7\deps\cliente-file-ws.jar
 * Qualified Name:     ec.gob.sri.comprobantes.ws.ValidarComprobante
 * JD-Core Version:    0.6.2
 */