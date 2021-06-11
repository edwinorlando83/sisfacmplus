/*    */ package ec.gob.sri.comprobantes.util;
/*    */ 
/*    */ public enum CodigoBusquedaEnum
/*    */ {
/* 12 */   SELECCIONE("SELECCIONE"), CODIGO("CODIGO"), AUXILIAR("CODIGO AUXILIAR");
/*    */ 
/*    */   private String code;
/*    */ 
/* 16 */   private CodigoBusquedaEnum(String code) { this.code = code; }
/*    */ 
/*    */ 
/*    */   public String getCode()
/*    */   {
/* 24 */     return this.code;
/*    */   }
/*    */ }

/* Location:           C:\prolan\ce\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.CodigoBusquedaEnum
 * JD-Core Version:    0.6.2
 */