  package ec.gob.sri.comprobantes.modelo.rentencion;
  
  import ec.gob.sri.comprobantes.modelo.InfoTributaria;
  import java.util.ArrayList;
  import java.util.List;
  import javax.xml.bind.annotation.XmlAccessType;
  import javax.xml.bind.annotation.XmlAccessorType;
  import javax.xml.bind.annotation.XmlAttribute;
  import javax.xml.bind.annotation.XmlElement;
  import javax.xml.bind.annotation.XmlRootElement;
  import javax.xml.bind.annotation.XmlSchemaType;
  import javax.xml.bind.annotation.XmlType;
  import javax.xml.bind.annotation.XmlValue;
  import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
  import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
  

  
  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(name="", propOrder={"infoTributaria", "infoCompRetencion", "impuestos", "infoAdicional"})
  @XmlRootElement(name="comprobanteRetencion")
  public class ComprobanteRetencion
  {
	  
    @XmlElement(required=true)
    protected InfoTributaria infoTributaria;
  
    @XmlElement(required=true)
    protected InfoCompRetencion infoCompRetencion;
  
    @XmlElement(required=true)
    protected Impuestos impuestos;
    protected InfoAdicional infoAdicional;
  
    @XmlAttribute
    protected String id;
  
    @XmlAttribute(required=true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name="NMTOKEN")
    protected String version;
  
    public InfoTributaria getInfoTributaria()
    {
/* 134 */     return this.infoTributaria;
    }
  
    public void setInfoTributaria(InfoTributaria value)
    {
/* 146 */     this.infoTributaria = value;
    }
  
    public InfoCompRetencion getInfoCompRetencion()
    {
/* 158 */     return this.infoCompRetencion;
    }
  
    public void setInfoCompRetencion(InfoCompRetencion value)
    {
/* 170 */     this.infoCompRetencion = value;
    }
  
    public Impuestos getImpuestos()
    {
/* 182 */     return this.impuestos;
    }
  
    public void setImpuestos(Impuestos value)
    {
/* 194 */     this.impuestos = value;
    }
  
    public InfoAdicional getInfoAdicional()
    {
/* 206 */     return this.infoAdicional;
    }
  
    public void setInfoAdicional(InfoAdicional value)
    {
/* 218 */     this.infoAdicional = value;
    }
  
    public String getId()
    {
/* 230 */     return this.id;
    }
  
    public void setId(String value)
    {
/* 242 */     this.id = value;
    }
  
    public String getVersion()
    {
/* 254 */     return this.version;
    }
  
    public void setVersion(String value)
    {
/* 266 */     this.version = value;
    }
  
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name="", propOrder={"fechaEmision", "dirEstablecimiento", "contribuyenteEspecial", "obligadoContabilidad", "tipoIdentificacionSujetoRetenido", "razonSocialSujetoRetenido", "identificacionSujetoRetenido", "periodoFiscal"})
    public static class InfoCompRetencion
    {
  
      @XmlElement(required=true)
      protected String fechaEmision;
      protected String dirEstablecimiento;
      protected String contribuyenteEspecial;
      protected String obligadoContabilidad;
  
      @XmlElement(required=true)
      protected String tipoIdentificacionSujetoRetenido;
  
      @XmlElement(required=true)
      protected String razonSocialSujetoRetenido;
  
      @XmlElement(required=true)
      protected String identificacionSujetoRetenido;
  
      @XmlElement(required=true)
      protected String periodoFiscal;
  
      public String getFechaEmision()
      {
/* 539 */       return this.fechaEmision;
      }
  
      public void setFechaEmision(String value)
      {
/* 551 */       this.fechaEmision = value;
      }
  
      public String getDirEstablecimiento()
      {
/* 563 */       return this.dirEstablecimiento;
      }
  
      public void setDirEstablecimiento(String value)
      {
/* 575 */       this.dirEstablecimiento = value;
      }
  
      public String getContribuyenteEspecial()
      {
/* 587 */       return this.contribuyenteEspecial;
      }
  
      public void setContribuyenteEspecial(String value)
      {
/* 599 */       this.contribuyenteEspecial = value;
      }
  
      public String getObligadoContabilidad()
      {
/* 611 */       return this.obligadoContabilidad;
      }
  
      public void setObligadoContabilidad(String value)
      {
/* 623 */       this.obligadoContabilidad = value;
      }
  
      public String getTipoIdentificacionSujetoRetenido()
      {
/* 635 */       return this.tipoIdentificacionSujetoRetenido;
      }
  
      public void setTipoIdentificacionSujetoRetenido(String value)
      {
/* 647 */       this.tipoIdentificacionSujetoRetenido = value;
      }
  
      public String getRazonSocialSujetoRetenido()
      {
/* 659 */       return this.razonSocialSujetoRetenido;
      }
  
      public void setRazonSocialSujetoRetenido(String value)
      {
/* 671 */       this.razonSocialSujetoRetenido = value;
      }
  
      public String getIdentificacionSujetoRetenido()
      {
/* 683 */       return this.identificacionSujetoRetenido;
      }
  
      public void setIdentificacionSujetoRetenido(String value)
      {
/* 695 */       this.identificacionSujetoRetenido = value;
      }
  
      public String getPeriodoFiscal()
      {
/* 707 */       return this.periodoFiscal;
      }
  
      public void setPeriodoFiscal(String value)
      {
/* 719 */       this.periodoFiscal = value;
      }
    }
  
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name="", propOrder={"campoAdicional"})
    public static class InfoAdicional
    {
  
      @XmlElement(required=true)
      protected List<CampoAdicional> campoAdicional;
  
      public List<CampoAdicional> getCampoAdicional()
      {
/* 389 */       if (this.campoAdicional == null) {
/* 390 */         this.campoAdicional = new ArrayList<CampoAdicional>();
        }
/* 392 */       return this.campoAdicional;
      }
  
      @XmlAccessorType(XmlAccessType.FIELD)
      @XmlType(name="", propOrder={"value"})
      public static class CampoAdicional
      {
  
        @XmlValue
        protected String value;
  
        @XmlAttribute
        protected String nombre;
  
        public String getValue()
        {
/* 433 */         return this.value;
        }
  
        public void setValue(String value)
        {
/* 445 */         this.value = value;
        }
  
        public String getNombre()
        {
/* 457 */         return this.nombre;
        }
  
        public void setNombre(String value)
        {
/* 469 */         this.nombre = value;
        }
      }
    }
  
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name="", propOrder={"impuesto"})
    public static class Impuestos
    {
  
      @XmlElement(required=true)
      protected List<Impuesto> impuesto;
  
      public List<Impuesto> getImpuesto()
      {
/* 321 */       if (this.impuesto == null) {
/* 322 */         this.impuesto = new ArrayList<Impuesto>();
        }
/* 324 */       return this.impuesto;
      }
    }
  }

 