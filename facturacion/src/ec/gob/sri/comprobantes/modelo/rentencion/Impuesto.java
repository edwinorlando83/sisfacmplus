/*     */ package ec.gob.sri.comprobantes.modelo.rentencion;
/*     */ 
/*     */ import java.math.BigDecimal;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlElement;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="impuesto", propOrder={"codigo", "codigoRetencion", "baseImponible", "porcentajeRetener", "valorRetenido", "codDocSustento", "numDocSustento", "fechaEmisionDocSustento"})
/*     */ public class Impuesto
/*     */ {
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected String codigo;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected String codigoRetencion;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected BigDecimal baseImponible;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected BigDecimal porcentajeRetener;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected BigDecimal valorRetenido;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected String codDocSustento;
/*     */   protected String numDocSustento;
/*     */   protected String fechaEmisionDocSustento;
/*     */ 
/*     */   public String getCodigo()
/*     */   {
/*  83 */     return this.codigo;
/*     */   }
/*     */ 
/*     */   public void setCodigo(String value)
/*     */   {
/*  95 */     this.codigo = value;
/*     */   }
/*     */ 
/*     */   public String getCodigoRetencion()
/*     */   {
/* 107 */     return this.codigoRetencion;
/*     */   }
/*     */ 
/*     */   public void setCodigoRetencion(String value)
/*     */   {
/* 119 */     this.codigoRetencion = value;
/*     */   }
/*     */ 
/*     */   public BigDecimal getBaseImponible()
/*     */   {
/* 131 */     return this.baseImponible;
/*     */   }
/*     */ 
/*     */   public void setBaseImponible(BigDecimal value)
/*     */   {
/* 143 */     this.baseImponible = value;
/*     */   }
/*     */ 
/*     */   public BigDecimal getPorcentajeRetener()
/*     */   {
/* 155 */     return this.porcentajeRetener;
/*     */   }
/*     */ 
/*     */   public void setPorcentajeRetener(BigDecimal value)
/*     */   {
/* 167 */     this.porcentajeRetener = value;
/*     */   }
/*     */ 
/*     */   public BigDecimal getValorRetenido()
/*     */   {
/* 179 */     return this.valorRetenido;
/*     */   }
/*     */ 
/*     */   public void setValorRetenido(BigDecimal value)
/*     */   {
/* 191 */     this.valorRetenido = value;
/*     */   }
/*     */ 
/*     */   public String getCodDocSustento()
/*     */   {
/* 203 */     return this.codDocSustento;
/*     */   }
/*     */ 
/*     */   public void setCodDocSustento(String value)
/*     */   {
/* 215 */     this.codDocSustento = value;
/*     */   }
/*     */ 
/*     */   public String getNumDocSustento()
/*     */   {
/* 227 */     return this.numDocSustento;
/*     */   }
/*     */ 
/*     */   public void setNumDocSustento(String value)
/*     */   {
/* 239 */     this.numDocSustento = value;
/*     */   }
/*     */ 
/*     */   public String getFechaEmisionDocSustento()
/*     */   {
/* 251 */     return this.fechaEmisionDocSustento;
/*     */   }
/*     */ 
/*     */   public void setFechaEmisionDocSustento(String value)
/*     */   {
/* 263 */     this.fechaEmisionDocSustento = value;
/*     */   }
/*     */ }

/* Location:           C:\prolan\ce\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.modelo.rentencion.Impuesto
 * JD-Core Version:    0.6.2
 */