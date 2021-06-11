/*     */ package ec.gob.sri.comprobantes.modelo.notacredito;
/*     */  
/*     */ import java.math.BigDecimal;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlElement;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="impuesto", propOrder={"codigo", "codigoPorcentaje", "tarifa", "baseImponible", "valor"})
/*     */ public class Impuesto
/*     */ {
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected String codigo;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected String codigoPorcentaje;
/*     */   protected BigDecimal tarifa;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected BigDecimal baseImponible;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected BigDecimal valor;
/*     */ 
/*     */   public String getCodigo()
/*     */   {
/*  72 */     return this.codigo;
/*     */   }
/*     */ 
/*     */   public void setCodigo(String value)
/*     */   {
/*  84 */     this.codigo = value;
/*     */   }
/*     */ 
/*     */   public String getCodigoPorcentaje()
/*     */   {
/*  96 */     return this.codigoPorcentaje;
/*     */   }
/*     */ 
/*     */   public void setCodigoPorcentaje(String value)
/*     */   {
/* 108 */     this.codigoPorcentaje = value;
/*     */   }
/*     */ 
/*     */   public BigDecimal getTarifa()
/*     */   {
/* 120 */     return this.tarifa;
/*     */   }
/*     */ 
/*     */   public void setTarifa(BigDecimal value)
/*     */   {
/* 132 */     this.tarifa = value;
/*     */   }
/*     */ 
/*     */   public BigDecimal getBaseImponible()
/*     */   {
/* 144 */     return this.baseImponible;
/*     */   }
/*     */ 
/*     */   public void setBaseImponible(BigDecimal value)
/*     */   {
/* 156 */     this.baseImponible = value;
/*     */   }
/*     */ 
/*     */   public BigDecimal getValor()
/*     */   {
/* 168 */     return this.valor;
/*     */   }
/*     */ 
/*     */   public void setValor(BigDecimal value)
/*     */   {
/* 180 */     this.valor = value;
/*     */   }
/*     */ }

/* Location:           C:\prolan\ce\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.modelo.notacredito.Impuesto
 * JD-Core Version:    0.6.2
 */