/*    */ package ec.gob.sri.comprobantes.util;
/*    */ 
/*    */ public enum TipoEmisionEnum
/*    */ {
/* 12 */   NORMAL("NORMAL"), CONTINGENCIA("INDISPONIBILIDAD DE SISTEMA");
/*    */ 
/*    */   private String code;
/*    */ 
/* 16 */   private TipoEmisionEnum(String code) { this.code = code; }
/*    */ 
/*    */ 
/*    */   public String getCode()
/*    */   {
/* 24 */     return this.code;
/*    */   }
/*    */ }

/* Location:           C:\prolan\ce\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.TipoEmisionEnum
 * JD-Core Version:    0.6.2
 */