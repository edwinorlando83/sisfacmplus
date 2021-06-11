/*    */ package ec.gob.sri.comprobantes.util;
/*    */ 
/*    */ public class CampoModelo
/*    */ {
/*    */   private String valor;
/*    */   private String etiqueta;
/*    */   private Integer longitud;
/*    */ 
/*    */   public CampoModelo(String valor, String etiqueta, Integer longitud)
/*    */   {
/* 17 */     this.valor = valor;
/* 18 */     this.etiqueta = etiqueta;
/* 19 */     this.longitud = longitud;
/*    */   }
/*    */ 
/*    */   public String getValor()
/*    */   {
/* 27 */     return this.valor;
/*    */   }
/*    */ 
/*    */   public void setValor(String valor)
/*    */   {
/* 34 */     this.valor = valor;
/*    */   }
/*    */ 
/*    */   public String getEtiqueta()
/*    */   {
/* 41 */     return this.etiqueta;
/*    */   }
/*    */ 
/*    */   public void setEtiqueta(String etiqueta)
/*    */   {
/* 48 */     this.etiqueta = etiqueta;
/*    */   }
/*    */ 
/*    */   public Integer getLongitud()
/*    */   {
/* 55 */     return this.longitud;
/*    */   }
/*    */ 
/*    */   public void setLongitud(Integer longitud)
/*    */   {
/* 62 */     this.longitud = longitud;
/*    */   }
/*    */ }

/* Location:           C:\prolan\ce\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.CampoModelo
 * JD-Core Version:    0.6.2
 */