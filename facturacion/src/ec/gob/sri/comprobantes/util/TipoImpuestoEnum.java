/*    */ package ec.gob.sri.comprobantes.util;
/*    */ 
/*    */ public enum TipoImpuestoEnum
/*    */ {
/* 10 */   RENTA(1, "Impuesto a la Renta"), IVA(2, "I.V.A."), ICE(3, "I.C.E."),IRBPNR(5, "IRBPNR");
 
/*    */   private int code;
/*    */   private String descripcion;
/*    */ 
/* 16 */   private TipoImpuestoEnum(int code, String descripcion) { this.code = code;
/* 17 */     this.descripcion = descripcion; }
/*    */ 
/*    */   public String getDescripcion()
/*    */   {
/* 21 */     return this.descripcion;
/*    */   }
/*    */ 
/*    */   public int getCode() {
/* 25 */     return this.code;
/*    */   }
/*    */ }

/* Location:           C:\prolan\ce\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.TipoImpuestoEnum
 * JD-Core Version:    0.6.2
 */