/*    */ package ec.gob.sri.comprobantes.util;
/*    */ 
/*    */ public enum TipoClienteEnum
/*    */ {
/* 12 */   C("CLIENTE", "C"), R("SUJETOS RETENIDOS", "R"), D("DESTINATARIOS", "D");
/*    */ 
/*    */   private String code;
/*    */   private String descripcion;
/*    */ 
/* 17 */   private TipoClienteEnum(String descripcion, String code) { this.code = code;
/* 18 */     this.descripcion = descripcion;
/*    */   }
/*    */ 
/*    */   public String getCode()
/*    */   {
/* 26 */     return this.code;
/*    */   }
/*    */   public String getDescripcion() {
/* 29 */     return this.descripcion;
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 33 */     return this.descripcion;
/*    */   }
/*    */ }

/* Location:           C:\prolan\ce\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.TipoClienteEnum
 * JD-Core Version:    0.6.2
 */