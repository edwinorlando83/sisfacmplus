/*     */ package ec.gob.sri.comprobantes.modelo.guia;
/*     */ 
/*     */ import ec.gob.sri.comprobantes.modelo.InfoTributaria;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlAttribute;
/*     */ import javax.xml.bind.annotation.XmlElement;
/*     */ import javax.xml.bind.annotation.XmlRootElement;
/*     */ import javax.xml.bind.annotation.XmlSchemaType;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ import javax.xml.bind.annotation.XmlValue;
/*     */ import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
/*     */ import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="", propOrder={"infoTributaria", "infoGuiaRemision", "destinatarios", "infoAdicional"})
/*     */ @XmlRootElement(name="guiaRemision")
/*     */ public class GuiaRemision
/*     */ {
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected InfoTributaria infoTributaria;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected InfoGuiaRemision infoGuiaRemision;
/*     */ 
/*     */   @XmlElement(required=true)
/*     */   protected Destinatarios destinatarios;
/*     */   protected InfoAdicional infoAdicional;
/*     */ 
/*     */   @XmlAttribute(required=true)
/*     */   protected String id;
/*     */ 
/*     */   @XmlAttribute(required=true)
/*     */   @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
/*     */   @XmlSchemaType(name="NMTOKEN")
/*     */   protected String version;
/*     */ 
/*     */   public InfoTributaria getInfoTributaria()
/*     */   {
/* 137 */     return this.infoTributaria;
/*     */   }
/*     */ 
/*     */   public void setInfoTributaria(InfoTributaria value)
/*     */   {
/* 149 */     this.infoTributaria = value;
/*     */   }
/*     */ 
/*     */   public InfoGuiaRemision getInfoGuiaRemision()
/*     */   {
/* 161 */     return this.infoGuiaRemision;
/*     */   }
/*     */ 
/*     */   public void setInfoGuiaRemision(InfoGuiaRemision value)
/*     */   {
/* 173 */     this.infoGuiaRemision = value;
/*     */   }
/*     */ 
/*     */   public Destinatarios getDestinatarios()
/*     */   {
/* 185 */     return this.destinatarios;
/*     */   }
/*     */ 
/*     */   public void setDestinatarios(Destinatarios value)
/*     */   {
/* 197 */     this.destinatarios = value;
/*     */   }
/*     */ 
/*     */   public InfoAdicional getInfoAdicional()
/*     */   {
/* 209 */     return this.infoAdicional;
/*     */   }
/*     */ 
/*     */   public void setInfoAdicional(InfoAdicional value)
/*     */   {
/* 221 */     this.infoAdicional = value;
/*     */   }
/*     */ 
/*     */   public String getId()
/*     */   {
/* 233 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(String value)
/*     */   {
/* 245 */     this.id = value;
/*     */   }
/*     */ 
/*     */   public String getVersion()
/*     */   {
/* 257 */     return this.version;
/*     */   }
/*     */ 
/*     */   public void setVersion(String value)
/*     */   {
/* 269 */     this.version = value;
/*     */   }
/*     */ 
/*     */   @XmlAccessorType(XmlAccessType.FIELD)
/*     */   @XmlType(name="", propOrder={"dirEstablecimiento", "dirPartida", "razonSocialTransportista", "tipoIdentificacionTransportista", "rucTransportista", "rise", "obligadoContabilidad", "contribuyenteEspecial", "fechaIniTransporte", "fechaFinTransporte", "placa"})
/*     */   public static class InfoGuiaRemision
/*     */   {
/*     */     protected String dirEstablecimiento;
/*     */ 
/*     */     @XmlElement(required=true)
/*     */     protected String dirPartida;
/*     */ 
/*     */     @XmlElement(required=true)
/*     */     protected String razonSocialTransportista;
/*     */ 
/*     */     @XmlElement(required=true)
/*     */     protected String tipoIdentificacionTransportista;
/*     */ 
/*     */     @XmlElement(required=true)
/*     */     protected String rucTransportista;
/*     */     protected String rise;
/*     */     protected String obligadoContabilidad;
/*     */     protected String contribuyenteEspecial;
/*     */ 
/*     */     @XmlElement(required=true)
/*     */     protected String fechaIniTransporte;
/*     */ 
/*     */     @XmlElement(required=true)
/*     */     protected String fechaFinTransporte;
/*     */ 
/*     */     @XmlElement(required=true)
/*     */     protected String placa;
/*     */ 
/*     */     public String getDirEstablecimiento()
/*     */     {
/* 553 */       return this.dirEstablecimiento;
/*     */     }
/*     */ 
/*     */     public void setDirEstablecimiento(String value)
/*     */     {
/* 565 */       this.dirEstablecimiento = value;
/*     */     }
/*     */ 
/*     */     public String getDirPartida()
/*     */     {
/* 577 */       return this.dirPartida;
/*     */     }
/*     */ 
/*     */     public void setDirPartida(String value)
/*     */     {
/* 589 */       this.dirPartida = value;
/*     */     }
/*     */ 
/*     */     public String getRazonSocialTransportista()
/*     */     {
/* 601 */       return this.razonSocialTransportista;
/*     */     }
/*     */ 
/*     */     public void setRazonSocialTransportista(String value)
/*     */     {
/* 613 */       this.razonSocialTransportista = value;
/*     */     }
/*     */ 
/*     */     public String getTipoIdentificacionTransportista()
/*     */     {
/* 625 */       return this.tipoIdentificacionTransportista;
/*     */     }
/*     */ 
/*     */     public void setTipoIdentificacionTransportista(String value)
/*     */     {
/* 637 */       this.tipoIdentificacionTransportista = value;
/*     */     }
/*     */ 
/*     */     public String getRucTransportista()
/*     */     {
/* 649 */       return this.rucTransportista;
/*     */     }
/*     */ 
/*     */     public void setRucTransportista(String value)
/*     */     {
/* 661 */       this.rucTransportista = value;
/*     */     }
/*     */ 
/*     */     public String getRise()
/*     */     {
/* 673 */       return this.rise;
/*     */     }
/*     */ 
/*     */     public void setRise(String value)
/*     */     {
/* 685 */       this.rise = value;
/*     */     }
/*     */ 
/*     */     public String getObligadoContabilidad()
/*     */     {
/* 697 */       return this.obligadoContabilidad;
/*     */     }
/*     */ 
/*     */     public void setObligadoContabilidad(String value)
/*     */     {
/* 709 */       this.obligadoContabilidad = value;
/*     */     }
/*     */ 
/*     */     public String getContribuyenteEspecial()
/*     */     {
/* 721 */       return this.contribuyenteEspecial;
/*     */     }
/*     */ 
/*     */     public void setContribuyenteEspecial(String value)
/*     */     {
/* 733 */       this.contribuyenteEspecial = value;
/*     */     }
/*     */ 
/*     */     public String getFechaIniTransporte()
/*     */     {
/* 745 */       return this.fechaIniTransporte;
/*     */     }
/*     */ 
/*     */     public void setFechaIniTransporte(String value)
/*     */     {
/* 757 */       this.fechaIniTransporte = value;
/*     */     }
/*     */ 
/*     */     public String getFechaFinTransporte()
/*     */     {
/* 769 */       return this.fechaFinTransporte;
/*     */     }
/*     */ 
/*     */     public void setFechaFinTransporte(String value)
/*     */     {
/* 781 */       this.fechaFinTransporte = value;
/*     */     }
/*     */ 
/*     */     public String getPlaca()
/*     */     {
/* 793 */       return this.placa;
/*     */     }
/*     */ 
/*     */     public void setPlaca(String value)
/*     */     {
/* 805 */       this.placa = value;
/*     */     }
/*     */   }
/*     */ 
/*     */   @XmlAccessorType(XmlAccessType.FIELD)
/*     */   @XmlType(name="", propOrder={"campoAdicional"})
/*     */   public static class InfoAdicional
/*     */   {
/*     */ 
/*     */     @XmlElement(required=true)
/*     */     protected List<CampoAdicional> campoAdicional;
/*     */ 
/*     */     public List<CampoAdicional> getCampoAdicional()
/*     */     {
/* 392 */       if (this.campoAdicional == null) {
/* 393 */         this.campoAdicional = new ArrayList<CampoAdicional>();
/*     */       }
/* 395 */       return this.campoAdicional;
/*     */     }
/*     */ 
/*     */     @XmlAccessorType(XmlAccessType.FIELD)
/*     */     @XmlType(name="", propOrder={"value"})
/*     */     public static class CampoAdicional
/*     */     {
/*     */ 
/*     */       @XmlValue
/*     */       protected String value;
/*     */ 
/*     */       @XmlAttribute
/*     */       protected String nombre;
/*     */ 
/*     */       public String getValue()
/*     */       {
/* 436 */         return this.value;
/*     */       }
/*     */ 
/*     */       public void setValue(String value)
/*     */       {
/* 448 */         this.value = value;
/*     */       }
/*     */ 
/*     */       public String getNombre()
/*     */       {
/* 460 */         return this.nombre;
/*     */       }
/*     */ 
/*     */       public void setNombre(String value)
/*     */       {
/* 472 */         this.nombre = value;
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   @XmlAccessorType(XmlAccessType.FIELD)
/*     */   @XmlType(name="", propOrder={"destinatario"})
/*     */   public static class Destinatarios
/*     */   {
/*     */ 
/*     */     @XmlElement(required=true)
/*     */     protected List<Destinatario> destinatario;
/*     */ 
/*     */     public List<Destinatario> getDestinatario()
/*     */     {
/* 324 */       if (this.destinatario == null) {
/* 325 */         this.destinatario = new ArrayList<Destinatario>();
/*     */       }
/* 327 */       return this.destinatario;
/*     */     }
/*     */   }
/*     */ }

 