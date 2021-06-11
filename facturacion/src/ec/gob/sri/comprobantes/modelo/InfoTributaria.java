/*     */ package ec.gob.sri.comprobantes.modelo;
/*     */ 
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlElement;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="infoTributaria", propOrder={"ambiente", "tipoEmision", "razonSocial", "nombreComercial", "ruc", "claveAcceso", "codDoc", "estab", "ptoEmi", "secuencial", "dirMatriz"})
/*     */ public class InfoTributaria
/*     */ {
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected String ambiente;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected String tipoEmision;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected String razonSocial;
/*     */   protected String nombreComercial;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected String ruc;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected String claveAcceso;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected String codDoc;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected String estab;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected String ptoEmi;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected String secuencial;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected String dirMatriz;
/*     */ 
/*     */   public String getAmbiente()
/*     */   {
/*  95 */     return this.ambiente;
/*     */   }
/*     */ 
/*     */   public void setAmbiente(String value)
/*     */   {
/* 107 */     this.ambiente = value;
/*     */   }
/*     */ 
/*     */   public String getTipoEmision()
/*     */   {
/* 119 */     return this.tipoEmision;
/*     */   }
/*     */ 
/*     */   public void setTipoEmision(String value)
/*     */   {
/* 131 */     this.tipoEmision = value;
/*     */   }
/*     */ 
/*     */   public String getRazonSocial()
/*     */   {
/* 143 */     return this.razonSocial;
/*     */   }
/*     */ 
/*     */   public void setRazonSocial(String value)
/*     */   {
/* 155 */     this.razonSocial = value;
/*     */   }
/*     */ 
/*     */   public String getNombreComercial()
/*     */   {
/* 167 */     return this.nombreComercial;
/*     */   }
/*     */ 
/*     */   public void setNombreComercial(String value)
/*     */   {
/* 179 */     this.nombreComercial = value;
/*     */   }
/*     */ 
/*     */   public String getRuc()
/*     */   {
/* 191 */     return this.ruc;
/*     */   }
/*     */ 
/*     */   public void setRuc(String value)
/*     */   {
/* 203 */     this.ruc = value;
/*     */   }
/*     */ 
/*     */   public String getClaveAcceso()
/*     */   {
/* 215 */     return this.claveAcceso;
/*     */   }
/*     */ 
/*     */   public void setClaveAcceso(String value)
/*     */   {
/* 227 */     this.claveAcceso = value;
/*     */   }
/*     */ 
/*     */   public String getCodDoc()
/*     */   {
/* 239 */     return this.codDoc;
/*     */   }
/*     */ 
/*     */   public void setCodDoc(String value)
/*     */   {
/* 251 */     this.codDoc = value;
/*     */   }
/*     */ 
/*     */   public String getEstab()
/*     */   {
/* 263 */     return this.estab;
/*     */   }
/*     */ 
/*     */   public void setEstab(String value)
/*     */   {
/* 275 */     this.estab = value;
/*     */   }
/*     */ 
/*     */   public String getPtoEmi()
/*     */   {
/* 287 */     return this.ptoEmi;
/*     */   }
/*     */ 
/*     */   public void setPtoEmi(String value)
/*     */   {
/* 299 */     this.ptoEmi = value;
/*     */   }
/*     */ 
/*     */   public String getSecuencial()
/*     */   {
/* 311 */     return this.secuencial;
/*     */   }
/*     */ 
/*     */   public void setSecuencial(String value)
/*     */   {
/* 323 */     this.secuencial = value;
/*     */   }
/*     */ 
/*     */   public String getDirMatriz()
/*     */   {
/* 335 */     return this.dirMatriz;
/*     */   }
/*     */ 
/*     */   public void setDirMatriz(String value)
/*     */   {
/* 347 */     this.dirMatriz = value;
/*     */   }
/*     */ }

/* Location:           C:\prolan\ce\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.modelo.InfoTributaria
 * JD-Core Version:    0.6.2
 */