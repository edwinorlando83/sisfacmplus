/*    */ package ec.gob.sri.comprobantes.util;
/*    */ 
/*    */ public enum TokensValidos
/*    */ {
/* 16 */   ANF1("ANF - Certificado Exportado"), 
/* 17 */   ANF_TOKEN("ANF - Plug & Sign"), 
/* 18 */   BCE_IKEY2032("BCE - iKey2032"), 
/* 19 */   BCE_ALADDIN("BCE - Aladdin eToken Pro"), 
/* 20 */   SD_EPASS3000("SD - ePass3003 auto"), 
/* 21 */   SD_BIOPASS("SD - BioPass3000");
/*    */ 
/*    */   String id;
/*    */ 
/*    */   private TokensValidos(String modelo) {
/* 26 */     this.id = modelo;
/*    */   }
/*    */ 
/*    */   public String getId() {
/* 30 */     return this.id;
/*    */   }
/*    */ 
/*    */   public void setId(String id) {
/* 34 */     this.id = id;
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 39 */     return getId();
/*    */   }
/*    */ }

/* Location:           C:\prolan\ce\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.TokensValidos
 * JD-Core Version:    0.6.2
 */