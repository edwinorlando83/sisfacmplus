/*    */ package ec.gob.sri.comprobantes.modelo.notacredito;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlElement;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name="detalle", propOrder={"motivoModificacion"})
/*    */ public class Detalle
/*    */ {
/*    */ 
/*    */   @XmlElement(required=true)
/*    */   protected String motivoModificacion;
/*    */ 
/*    */   public String getMotivoModificacion()
/*    */   {
/* 56 */     return this.motivoModificacion;
/*    */   }
/*    */ 
/*    */   public void setMotivoModificacion(String value)
/*    */   {
/* 68 */     this.motivoModificacion = value;
/*    */   }
/*    */ }

/* Location:           C:\prolan\ce\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.modelo.notacredito.Detalle
 * JD-Core Version:    0.6.2
 */