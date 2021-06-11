/*     */ package ec.gob.sri.comprobantes.modelo.guia;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlElement;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="destinatario", propOrder={"identificacionDestinatario", "razonSocialDestinatario", "dirDestinatario", "motivoTraslado", "docAduaneroUnico", "codEstabDestino", "ruta", "codDocSustento", "numDocSustento", "numAutDocSustento", "fechaEmisionDocSustento", "detalles"})
/*     */ public class Destinatario
/*     */ {
/*     */   protected String identificacionDestinatario;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected String razonSocialDestinatario;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected String dirDestinatario;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected String motivoTraslado;
/*     */   protected String docAduaneroUnico;
/*     */   protected String codEstabDestino;
/*     */   protected String ruta;
/*     */   protected String codDocSustento;
/*     */   protected String numDocSustento;
/*     */   protected String numAutDocSustento;
/*     */   protected String fechaEmisionDocSustento;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected Detalles detalles;
/*     */ 
/*     */   public String getIdentificacionDestinatario()
/*     */   {
/* 104 */     return this.identificacionDestinatario;
/*     */   }
/*     */ 
/*     */   public void setIdentificacionDestinatario(String value)
/*     */   {
/* 116 */     this.identificacionDestinatario = value;
/*     */   }
/*     */ 
/*     */   public String getRazonSocialDestinatario()
/*     */   {
/* 128 */     return this.razonSocialDestinatario;
/*     */   }
/*     */ 
/*     */   public void setRazonSocialDestinatario(String value)
/*     */   {
/* 140 */     this.razonSocialDestinatario = value;
/*     */   }
/*     */ 
/*     */   public String getDirDestinatario()
/*     */   {
/* 152 */     return this.dirDestinatario;
/*     */   }
/*     */ 
/*     */   public void setDirDestinatario(String value)
/*     */   {
/* 164 */     this.dirDestinatario = value;
/*     */   }
/*     */ 
/*     */   public String getMotivoTraslado()
/*     */   {
/* 176 */     return this.motivoTraslado;
/*     */   }
/*     */ 
/*     */   public void setMotivoTraslado(String value)
/*     */   {
/* 188 */     this.motivoTraslado = value;
/*     */   }
/*     */ 
/*     */   public String getDocAduaneroUnico()
/*     */   {
/* 200 */     return this.docAduaneroUnico;
/*     */   }
/*     */ 
/*     */   public void setDocAduaneroUnico(String value)
/*     */   {
/* 212 */     this.docAduaneroUnico = value;
/*     */   }
/*     */ 
/*     */   public String getCodEstabDestino()
/*     */   {
/* 224 */     return this.codEstabDestino;
/*     */   }
/*     */ 
/*     */   public void setCodEstabDestino(String value)
/*     */   {
/* 236 */     this.codEstabDestino = value;
/*     */   }
/*     */ 
/*     */   public String getRuta()
/*     */   {
/* 248 */     return this.ruta;
/*     */   }
/*     */ 
/*     */   public void setRuta(String value)
/*     */   {
/* 260 */     this.ruta = value;
/*     */   }
/*     */ 
/*     */   public String getCodDocSustento()
/*     */   {
/* 272 */     return this.codDocSustento;
/*     */   }
/*     */ 
/*     */   public void setCodDocSustento(String value)
/*     */   {
/* 284 */     this.codDocSustento = value;
/*     */   }
/*     */ 
/*     */   public String getNumDocSustento()
/*     */   {
/* 296 */     return this.numDocSustento;
/*     */   }
/*     */ 
/*     */   public void setNumDocSustento(String value)
/*     */   {
/* 308 */     this.numDocSustento = value;
/*     */   }
/*     */ 
/*     */   public String getNumAutDocSustento()
/*     */   {
/* 320 */     return this.numAutDocSustento;
/*     */   }
/*     */ 
/*     */   public void setNumAutDocSustento(String value)
/*     */   {
/* 332 */     this.numAutDocSustento = value;
/*     */   }
/*     */ 
/*     */   public String getFechaEmisionDocSustento()
/*     */   {
/* 344 */     return this.fechaEmisionDocSustento;
/*     */   }
/*     */ 
/*     */   public void setFechaEmisionDocSustento(String value)
/*     */   {
/* 356 */     this.fechaEmisionDocSustento = value;
/*     */   }
/*     */ 
/*     */   public Detalles getDetalles()
/*     */   {
/* 368 */     return this.detalles;
/*     */   }
/*     */ 
/*     */   public void setDetalles(Detalles value)
/*     */   {
/* 380 */     this.detalles = value;
/*     */   }
/*     */ 
/*     */   @XmlAccessorType(XmlAccessType.FIELD)
/*     */   @XmlType(name="", propOrder={"detalle"})
/*     */   public static class Detalles
/*     */   {
/*     */ 
/*     */     @XmlElement(required=true)
/*     */     protected List<Detalle> detalle;
/*     */ 
/*     */     public List<Detalle> getDetalle()
/*     */     {
/* 435 */       if (this.detalle == null) {
/* 436 */         this.detalle = new ArrayList<Detalle> ();
/*     */       }
/* 438 */       return this.detalle;
/*     */     }
/*     */   }
/*     */ }

 