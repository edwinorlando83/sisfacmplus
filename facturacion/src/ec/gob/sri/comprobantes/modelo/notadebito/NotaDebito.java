  package ec.gob.sri.comprobantes.modelo.notadebito;
  
  import ec.gob.sri.comprobantes.modelo.InfoTributaria;
  import java.math.BigDecimal;
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
  @XmlType(name="", propOrder={"infoTributaria", "infoNotaDebito", "motivos", "infoAdicional"})
  @XmlRootElement(name="notaDebito")
  public class NotaDebito
  {
  
    @XmlElement(required=true)
    protected InfoTributaria infoTributaria;
  
    @XmlElement(required=true)
    protected InfoNotaDebito infoNotaDebito;
  
    @XmlElement(required=true)
    protected Motivos motivos;
    protected InfoAdicional infoAdicional;
  
    @XmlAttribute
    protected String id;
  
    @XmlAttribute(required=true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name="NMTOKEN")
    protected String version;
  
    public InfoTributaria getInfoTributaria()
    {
/*  162 */     return this.infoTributaria;
    }
  
    public void setInfoTributaria(InfoTributaria value)
    {
/*  174 */     this.infoTributaria = value;
    }
  
    public InfoNotaDebito getInfoNotaDebito()
    {
/*  186 */     return this.infoNotaDebito;
    }
  
    public void setInfoNotaDebito(InfoNotaDebito value)
    {
/*  198 */     this.infoNotaDebito = value;
    }
  
    public Motivos getMotivos()
    {
/*  210 */     return this.motivos;
    }
  
    public void setMotivos(Motivos value)
    {
/*  222 */     this.motivos = value;
    }
  
    public InfoAdicional getInfoAdicional()
    {
/*  234 */     return this.infoAdicional;
    }
  
    public void setInfoAdicional(InfoAdicional value)
    {
/*  246 */     this.infoAdicional = value;
    }
  
    public String getId()
    {
/*  258 */     return this.id;
    }
  
    public void setId(String value)
    {
/*  270 */     this.id = value;
    }
  
    public String getVersion()
    {
/*  282 */     return this.version;
    }
  
    public void setVersion(String value)
    {
/*  294 */     this.version = value;
    }
  
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name="", propOrder={"motivo"})
    public static class Motivos
    {
  
      @XmlElement(required=true)
      protected List<Motivo> motivo;
  
      public List<Motivo> getMotivo()
      {
/*  991 */       if (this.motivo == null) {
/*  992 */         this.motivo = new ArrayList<Motivo>();
        }
/*  994 */       return this.motivo;
      }
  
      @XmlAccessorType(XmlAccessType.FIELD)
      @XmlType(name="", propOrder={"razon", "valor"})
      public static class Motivo
      {
  
        @XmlElement(required=true)
        protected String razon;
  
        @XmlElement(required=true)
        protected BigDecimal valor;
  
        public String getRazon()
        {
/* 1039 */         return this.razon;
        }
  
        public void setRazon(String value)
        {
/* 1051 */         this.razon = value;
        }
  
        public BigDecimal getValor()
        {
/* 1063 */         return this.valor;
        }
  
        public void setValor(BigDecimal value)
        {
/* 1075 */         this.valor = value;
        }
      }
    }
  
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name="", propOrder={"fechaEmision", "dirEstablecimiento", "tipoIdentificacionComprador", "razonSocialComprador", "identificacionComprador", "contribuyenteEspecial", "obligadoContabilidad", "rise", "codDocModificado", "numDocModificado", "fechaEmisionDocSustento", "totalSinImpuestos", "impuestos", "valorTotal"})
    public static class InfoNotaDebito
    {
  
      @XmlElement(required=true)
      protected String fechaEmision;
      protected String dirEstablecimiento;
  
      @XmlElement(required=true)
      protected String tipoIdentificacionComprador;
      protected String razonSocialComprador;
  
      @XmlElement(required=true)
      protected String identificacionComprador;
      protected String contribuyenteEspecial;
      protected String obligadoContabilidad;
      protected String rise;
  
      @XmlElement(required=true)
      protected String codDocModificado;
  
      @XmlElement(required=true)
      protected String numDocModificado;
  
      @XmlElement(required=true)
      protected String fechaEmisionDocSustento;
  
      @XmlElement(required=true)
      protected BigDecimal totalSinImpuestos;
  
      @XmlElement(required=true)
      protected Impuestos impuestos;
  
      @XmlElement(required=true)
      protected BigDecimal valorTotal;
  
      public String getFechaEmision()
      {
/*  539 */       return this.fechaEmision;
      }
  
      public void setFechaEmision(String value)
      {
/*  551 */       this.fechaEmision = value;
      }
  
      public String getDirEstablecimiento()
      {
/*  563 */       return this.dirEstablecimiento;
      }
  
      public void setDirEstablecimiento(String value)
      {
/*  575 */       this.dirEstablecimiento = value;
      }
  
      public String getTipoIdentificacionComprador()
      {
/*  587 */       return this.tipoIdentificacionComprador;
      }
  
      public void setTipoIdentificacionComprador(String value)
      {
/*  599 */       this.tipoIdentificacionComprador = value;
      }
  
      public String getRazonSocialComprador()
      {
/*  611 */       return this.razonSocialComprador;
      }
  
      public void setRazonSocialComprador(String value)
      {
/*  623 */       this.razonSocialComprador = value;
      }
  
      public String getIdentificacionComprador()
      {
/*  635 */       return this.identificacionComprador;
      }
  
      public void setIdentificacionComprador(String value)
      {
/*  647 */       this.identificacionComprador = value;
      }
  
      public String getContribuyenteEspecial()
      {
/*  659 */       return this.contribuyenteEspecial;
      }
  
      public void setContribuyenteEspecial(String value)
      {
/*  671 */       this.contribuyenteEspecial = value;
      }
  
      public String getObligadoContabilidad()
      {
/*  683 */       return this.obligadoContabilidad;
      }
  
      public void setObligadoContabilidad(String value)
      {
/*  695 */       this.obligadoContabilidad = value;
      }
  
      public String getRise()
      {
/*  707 */       return this.rise;
      }
  
      public void setRise(String value)
      {
/*  719 */       this.rise = value;
      }
  
      public String getCodDocModificado()
      {
/*  731 */       return this.codDocModificado;
      }
  
      public void setCodDocModificado(String value)
      {
/*  743 */       this.codDocModificado = value;
      }
  
      public String getNumDocModificado()
      {
/*  755 */       return this.numDocModificado;
      }
  
      public void setNumDocModificado(String value)
      {
/*  767 */       this.numDocModificado = value;
      }
  
      public String getFechaEmisionDocSustento()
      {
/*  779 */       return this.fechaEmisionDocSustento;
      }
  
      public void setFechaEmisionDocSustento(String value)
      {
/*  791 */       this.fechaEmisionDocSustento = value;
      }
  
      public BigDecimal getTotalSinImpuestos()
      {
/*  803 */       return this.totalSinImpuestos;
      }
  
      public void setTotalSinImpuestos(BigDecimal value)
      {
/*  815 */       this.totalSinImpuestos = value;
      }
  
      public Impuestos getImpuestos()
      {
/*  827 */       return this.impuestos;
      }
  
      public void setImpuestos(Impuestos value)
      {
/*  839 */       this.impuestos = value;
      }
  
      public BigDecimal getValorTotal()
      {
/*  851 */       return this.valorTotal;
      }
  
      public void setValorTotal(BigDecimal value)
      {
/*  863 */       this.valorTotal = value;
      }
  
      @XmlAccessorType(XmlAccessType.FIELD)
      @XmlType(name="", propOrder={"impuesto"})
      public static class Impuestos
      {
  
        @XmlElement(required=true)
        protected List<Impuesto> impuesto;
  
        public List<Impuesto> getImpuesto()
        {
/*  918 */         if (this.impuesto == null) {
/*  919 */           this.impuesto = new ArrayList<Impuesto>();
          }
/*  921 */         return this.impuesto;
        }
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
/*  357 */       if (this.campoAdicional == null) {
/*  358 */         this.campoAdicional = new ArrayList<CampoAdicional>();
        }
/*  360 */       return this.campoAdicional;
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
/*  401 */         return this.value;
        }
  
        public void setValue(String value)
        {
/*  413 */         this.value = value;
        }
  
        public String getNombre()
        {
/*  425 */         return this.nombre;
        }
  
        public void setNombre(String value)
        {
/*  437 */         this.nombre = value;
        }
      }
    }
  }

 