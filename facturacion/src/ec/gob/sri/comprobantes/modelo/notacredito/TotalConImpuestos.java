/*     */ package ec.gob.sri.comprobantes.modelo.notacredito;
/*     */  
/*     */ import java.math.BigDecimal;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlElement;
/*     */ import javax.xml.bind.annotation.XmlRootElement;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="", propOrder={"totalImpuesto"})
/*     */ @XmlRootElement(name="totalConImpuestos")
/*     */ public class TotalConImpuestos
/*     */ {
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected List<TotalImpuesto> totalImpuesto;
/*     */ 
/*     */   public List<TotalImpuesto> getTotalImpuesto()
/*     */   {
/*  86 */     if (this.totalImpuesto == null) {
/*  87 */       this.totalImpuesto = new ArrayList<TotalImpuesto>();
/*     */     }
/*  89 */     return this.totalImpuesto;
/*     */   }
/*     */ 
/*     */   @XmlAccessorType(XmlAccessType.FIELD)
/*     */   @XmlType(name="", propOrder={"codigo", "codigoPorcentaje", "baseImponible", "valor"})
/*     */   public static class TotalImpuesto
/*     */   {
/*     */ 
/*     */     @XmlElement(required=true)
/*     */     protected String codigo;
/*     */ 
/*     */     @XmlElement(required=true)
/*     */     protected String codigoPorcentaje;
/*     */ 
/*     */     @XmlElement(required=true)
/*     */     protected BigDecimal baseImponible;
/*     */ 
/*     */     @XmlElement(required=true)
/*     */     protected BigDecimal valor;
/*     */ 
/*     */     public String getCodigo()
/*     */     {
/* 142 */       return this.codigo;
/*     */     }
/*     */ 
/*     */     public void setCodigo(String value)
/*     */     {
/* 154 */       this.codigo = value;
/*     */     }
/*     */ 
/*     */     public String getCodigoPorcentaje()
/*     */     {
/* 166 */       return this.codigoPorcentaje;
/*     */     }
/*     */ 
/*     */     public void setCodigoPorcentaje(String value)
/*     */     {
/* 178 */       this.codigoPorcentaje = value;
/*     */     }
/*     */ 
/*     */     public BigDecimal getBaseImponible()
/*     */     {
/* 190 */       return this.baseImponible;
/*     */     }
/*     */ 
/*     */     public void setBaseImponible(BigDecimal value)
/*     */     {
/* 202 */       this.baseImponible = value;
/*     */     }
/*     */ 
/*     */     public BigDecimal getValor()
/*     */     {
/* 214 */       return this.valor;
/*     */     }
/*     */ 
/*     */     public void setValor(BigDecimal value)
/*     */     {
/* 226 */       this.valor = value;
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\prolan\ce\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.modelo.notacredito.TotalConImpuestos
 * JD-Core Version:    0.6.2
 */