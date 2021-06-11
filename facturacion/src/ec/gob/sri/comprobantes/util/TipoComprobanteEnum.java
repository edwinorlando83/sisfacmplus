/*    */ package ec.gob.sri.comprobantes.util;
/*    */ 
/*    */ public enum TipoComprobanteEnum
/*    */ {
/*  9 */   LOTE("00", "lote.xsd", ""), 
/* 10 */   FACTURA("01", "factura.xsd", "FACTURA"), 
/* 11 */   NOTA_DE_CREDITO("04", "notaCredito.xsd", "NOTA DE CREDITO"), 
/* 12 */   NOTA_DE_DEBITO("05", "notaDebito.xsd", "NOTA DE DEBITO"), 
/* 13 */   GUIA_DE_REMISION("06", "guiaRemision.xsd", "GUIA DE REMISION"), 
/* 14 */   COMPROBANTE_DE_RETENCION("07", "comprobanteRetencion.xsd", "COMPROBANTE DE RETENCION"), 
/* 15 */   LIQUIDACION_DE_COMPRAS("03", "", "LIQ.DE COMPRAS");
/*    */ 
/*    */   private String code;
/*    */   private String xsd;
/*    */   private String descripcion;
/*    */ 
/* 22 */   private TipoComprobanteEnum(String code, String xsd, String descripcion) { this.code = code;
/* 23 */     this.xsd = xsd;
/* 24 */     this.descripcion = descripcion;
/*    */   }
/*    */ 
/*    */   public String getCode()
/*    */   {
/* 33 */     return this.code;
/*    */   }
/*    */ 
/*    */   public String getXsd()
/*    */   {
/* 42 */     return this.xsd;
/*    */   }
/*    */ 
/*    */   public String getDescripcion() {
/* 46 */     return this.descripcion;
/*    */   }
/*    */ 
/*    */   public static String retornaCodigo(String valor)
/*    */   {
/* 57 */     String codigo = null;
/*    */ 
/* 59 */     if (valor.equals(FACTURA.getDescripcion()))
/* 60 */       codigo = FACTURA.getCode();
/* 61 */     else if (valor.equals(NOTA_DE_DEBITO.getDescripcion()))
/* 62 */       codigo = NOTA_DE_DEBITO.getCode();
/* 63 */     else if (valor.equals(NOTA_DE_CREDITO.getDescripcion()))
/* 64 */       codigo = NOTA_DE_CREDITO.getCode();
/* 65 */     else if (valor.equals(COMPROBANTE_DE_RETENCION.getDescripcion()))
/* 66 */       codigo = COMPROBANTE_DE_RETENCION.getCode();
/* 67 */     else if (valor.equals(GUIA_DE_REMISION.getDescripcion()))
/* 68 */       codigo = GUIA_DE_REMISION.getCode();
/* 69 */     else if (valor.equals(LIQUIDACION_DE_COMPRAS.getDescripcion())) {
/* 70 */       codigo = LIQUIDACION_DE_COMPRAS.getCode();
/*    */     }
/*    */ 
/* 73 */     return codigo;
/*    */   }
/*    */ }

/* Location:           C:\prolan\ce\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.TipoComprobanteEnum
 * JD-Core Version:    0.6.2
 */