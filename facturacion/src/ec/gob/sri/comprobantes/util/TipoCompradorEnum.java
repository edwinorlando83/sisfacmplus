/*    */ package ec.gob.sri.comprobantes.util;
/*    */ 
/*    */ public enum TipoCompradorEnum
/*    */ {
/*  9 */   CONSUMIDOR_FINAL("07"), RUC("04"), CEDULA("05"), PASAPORTE("06");
/*    */ 
/*    */   private String code;
/*    */ 
/* 13 */   private TipoCompradorEnum(String code) { this.code = code; }
/*    */ 
/*    */ 
/*    */   public String getCode()
/*    */   {
/* 21 */     return this.code;
/*    */   }
/*    */ 
/*    */   public static String retornaCodigo(String valor)
/*    */   {
/* 33 */     String codigo = null;
/*    */ 
/* 35 */     if (valor.equals("C")) {
/* 36 */       codigo = CEDULA.getCode();
/*    */     }
/*    */ 
/* 39 */     if (valor.equals("R")) {
/* 40 */       codigo = RUC.getCode();
/*    */     }
/*    */ 
/* 43 */     if (valor.equals("P")) {
/* 44 */       codigo = PASAPORTE.getCode();
/*    */     }
/*    */ 
/* 47 */     if (valor.equals("F")) {
/* 48 */       codigo = CONSUMIDOR_FINAL.getCode();
/*    */     }
/*    */ 
/* 51 */     return codigo;
/*    */   }
/*    */ }

/* Location:           C:\prolan\ce\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.TipoCompradorEnum
 * JD-Core Version:    0.6.2
 */