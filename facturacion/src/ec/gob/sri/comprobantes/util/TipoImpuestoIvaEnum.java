/*    */ package ec.gob.sri.comprobantes.util;
/*    */ 
/*    */ public enum TipoImpuestoIvaEnum
/*    */ {
/* 10 */   IVA_VENTA_0("0"), IVA_VENTA_12("2"), IVA_VENTA_14("3"), IVA_VENTA_EXCENTO("6");
/*    */ 
/*    */   private String code;
/*    */ 
/*    */   private TipoImpuestoIvaEnum(String code) {
/* 15 */     this.code = code;
/*    */   }
/*    */ 
/*    */   public String getCode()
/*    */   {
/* 24 */     return this.code;
/*    */   }
/*    */ }

/* Location:           C:\prolan\ce\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.TipoImpuestoIvaEnum
 * JD-Core Version:    0.6.2
 */