/*    */ package ec.gob.sri.comprobantes.util;
/*    */ 
/*    */ public enum TipoAmbienteEnum
/*    */ {
/* 12 */   PRODUCCION("2"), PRUEBAS("1");
/*    */ 
/*    */   private String code;
/*    */ 
/* 16 */   private TipoAmbienteEnum(String code) { this.code = code; }
/*    */ 
/*    */ 
/*    */   public String getCode()
/*    */   {
/* 24 */     return this.code;
/*    */   }
/*    */ }

/* Location:           C:\prolan\ce\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.TipoAmbienteEnum
 * JD-Core Version:    0.6.2
 */