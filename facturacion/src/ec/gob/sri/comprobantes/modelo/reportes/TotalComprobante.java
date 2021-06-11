/*     */ package ec.gob.sri.comprobantes.modelo.reportes;
/*     */ 
/*     */ import java.math.BigDecimal;
/*     */ 
/*     */ public class TotalComprobante
/*     */ {
/*     */   private String subtotal12;
/*     */   private String subtotal0;
/*     */   private String subtotalNoSujetoIva;
/*     */   private BigDecimal subtotal;
/*     */   private String iva12;
/*     */   private String totalIce;
private String IRBPNR;
 

/*     */ 
/*     */   public String getSubtotal12()
/*     */   {
/*  25 */     return this.subtotal12;
/*     */   }
/*     */ 
/*     */   public void setSubtotal12(String subtotal12)
/*     */   {
/*  32 */     this.subtotal12 = subtotal12;
/*     */   }
/*     */ 
/*     */   public String getSubtotal0()
/*     */   {
/*  39 */     return this.subtotal0;
/*     */   }
/*     */ 
/*     */   public void setSubtotal0(String subtotal0)
/*     */   {
/*  46 */     this.subtotal0 = subtotal0;
/*     */   }
/*     */ 
/*     */   public BigDecimal getSubtotal()
/*     */   {
/*  53 */     return this.subtotal;
/*     */   }
/*     */ 
/*     */   public void setSubtotal(BigDecimal subtotal)
/*     */   {
/*  60 */     this.subtotal = subtotal;
/*     */   }
/*     */ 
/*     */   public String getIva12()
/*     */   {
/*  67 */     return this.iva12;
/*     */   }
/*     */ 
/*     */   public void setIva12(String iva12)
/*     */   {
/*  74 */     this.iva12 = iva12;
/*     */   }
/*     */ 
/*     */   public String getTotalIce()
/*     */   {
/*  81 */     return this.totalIce;
/*     */   }
/*     */ 
/*     */   public void setTotalIce(String totalIce)
/*     */   {
/*  88 */     this.totalIce = totalIce;
/*     */   }
/*     */ 
/*     */   public String getSubtotalNoSujetoIva()
/*     */   {
/*  95 */     return this.subtotalNoSujetoIva;
/*     */   }
/*     */ 
/*     */   public void setSubtotalNoSujetoIva(String subtotalNoSujetoIva)
/*     */   {
/* 102 */     this.subtotalNoSujetoIva = subtotalNoSujetoIva;
/*     */   }
/*     */
public String getIRBPNR() {
	return IRBPNR;
}
public void setIRBPNR(String iRBPNR) {
	IRBPNR = iRBPNR;
} }

/* Location:           C:\prolan\ce\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.modelo.reportes.TotalComprobante
 * JD-Core Version:    0.6.2
 */