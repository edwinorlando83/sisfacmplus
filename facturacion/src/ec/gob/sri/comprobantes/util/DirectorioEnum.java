/*    */ package ec.gob.sri.comprobantes.util;
/*    */ 
/*    */ public enum DirectorioEnum
/*    */ {
/* 10 */   GENERADOS(1), FIRMADOS(2), AUTORIZADOS(3), NO_AUTORIZADOS(4);
/*    */ 
/*    */   private int code;
/*    */ 
/*    */   private DirectorioEnum(int code) {
/* 15 */     this.code = code;
/*    */   }
/*    */ 
/*    */   public int getCode() {
/* 19 */     return this.code;
/*    */   }
/*    */ 
/*    */   public void setCode(int code) {
/* 23 */     this.code = code;
/*    */   }
/*    */ }

