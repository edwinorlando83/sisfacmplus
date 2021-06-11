  package ec.gob.sri.comprobantes.modelo.notacredito;
  
  import ec.gob.sri.comprobantes.modelo.InfoTributaria;
import ec.gob.sri.comprobantes.modelo.notacredito.TotalConImpuestos.TotalImpuesto;

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
  @XmlType(name="", propOrder={"infoTributaria", "infoNotaCredito", "detalles", "infoAdicional"})
  @XmlRootElement(name="notaCredito")
  public class NotaCredito
  {
  
	  
		 public String  getIvaPorcentaje()
		 {
			 String ivaporcentaje="";
		 
			for ( TotalImpuesto  totalimpuesto : getInfoNotaCredito().getTotalConImpuestos().getTotalImpuesto() ) {
					if (totalimpuesto.getCodigoPorcentaje().trim().equals("2")) {
						ivaporcentaje = "12";
					}
					if (totalimpuesto.getCodigoPorcentaje().trim().equals("3")) {
						ivaporcentaje = "14";
					}
				}
			 
			return  ivaporcentaje;
		 }
		 
    @XmlElement(required=true)
    protected InfoTributaria infoTributaria;
  
    @XmlElement(required=true)
    protected InfoNotaCredito infoNotaCredito;
  
    @XmlElement(required=true)
    protected Detalles detalles;
    protected InfoAdicional infoAdicional;
  
    @XmlAttribute(required=true)
    protected String id;
  
    @XmlAttribute(required=true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name="NMTOKEN")
    protected String version;
  
    public InfoTributaria getInfoTributaria()
    {
/*  203 */     return this.infoTributaria;
    }
  
    public void setInfoTributaria(InfoTributaria value)
    {
/*  215 */     this.infoTributaria = value;
    }
  
    public InfoNotaCredito getInfoNotaCredito()
    {
/*  227 */     return this.infoNotaCredito;
    }
  
    public void setInfoNotaCredito(InfoNotaCredito value)
    {
/*  239 */     this.infoNotaCredito = value;
    }
  
    public Detalles getDetalles()
    {
/*  251 */     return this.detalles;
    }
  
    public void setDetalles(Detalles value)
    {
/*  263 */     this.detalles = value;
    }
  
    public InfoAdicional getInfoAdicional()
    {
/*  275 */     return this.infoAdicional;
    }
  
    public void setInfoAdicional(InfoAdicional value)
    {
/*  287 */     this.infoAdicional = value;
    }
  
    public String getId()
    {
/*  299 */     return this.id;
    }
  
    public void setId(String value)
    {
/*  311 */     this.id = value;
    }
  
    public String getVersion()
    {
/*  323 */     return this.version;
    }
  
    public void setVersion(String value)
    {
/*  335 */     this.version = value;
    }
  
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name="", propOrder={"fechaEmision", "dirEstablecimiento", "tipoIdentificacionComprador", "razonSocialComprador", "identificacionComprador", "contribuyenteEspecial", "obligadoContabilidad", "rise", "codDocModificado", "numDocModificado", "fechaEmisionDocSustento", "totalSinImpuestos", "valorModificacion", "moneda", "totalConImpuestos", "motivo"})
    public static class InfoNotaCredito
    {
  
      @XmlElement(required=true)
      protected String fechaEmision;
      protected String dirEstablecimiento;
  
      @XmlElement(required=true)
      protected String tipoIdentificacionComprador;
  
      @XmlElement(required=true)
      protected String razonSocialComprador;
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
      protected BigDecimal valorModificacion;
      protected String moneda;
  
      @XmlElement(required=true)
      protected TotalConImpuestos totalConImpuestos;
  
      @XmlElement(required=true)
      protected String motivo;
  
      public String getFechaEmision()
      {
/* 1247 */       return this.fechaEmision;
      }
  
      public void setFechaEmision(String value)
      {
/* 1259 */       this.fechaEmision = value;
      }
  
      public String getDirEstablecimiento()
      {
/* 1271 */       return this.dirEstablecimiento;
      }
  
      public void setDirEstablecimiento(String value)
      {
/* 1283 */       this.dirEstablecimiento = value;
      }
  
      public String getTipoIdentificacionComprador()
      {
/* 1295 */       return this.tipoIdentificacionComprador;
      }
  
      public void setTipoIdentificacionComprador(String value)
      {
/* 1307 */       this.tipoIdentificacionComprador = value;
      }
  
      public String getRazonSocialComprador()
      {
/* 1319 */       return this.razonSocialComprador;
      }
  
      public void setRazonSocialComprador(String value)
      {
/* 1331 */       this.razonSocialComprador = value;
      }
  
      public String getIdentificacionComprador()
      {
/* 1343 */       return this.identificacionComprador;
      }
  
      public void setIdentificacionComprador(String value)
      {
/* 1355 */       this.identificacionComprador = value;
      }
  
      public String getContribuyenteEspecial()
      {
/* 1367 */       return this.contribuyenteEspecial;
      }
  
      public void setContribuyenteEspecial(String value)
      {
/* 1379 */       this.contribuyenteEspecial = value;
      }
  
      public String getObligadoContabilidad()
      {
/* 1391 */       return this.obligadoContabilidad;
      }
  
      public void setObligadoContabilidad(String value)
      {
/* 1403 */       this.obligadoContabilidad = value;
      }
  
      public String getRise()
      {
/* 1415 */       return this.rise;
      }
  
      public void setRise(String value)
      {
/* 1427 */       this.rise = value;
      }
  
      public String getCodDocModificado()
      {
/* 1439 */       return this.codDocModificado;
      }
  
      public void setCodDocModificado(String value)
      {
/* 1451 */       this.codDocModificado = value;
      }
  
      public String getNumDocModificado()
      {
/* 1463 */       return this.numDocModificado;
      }
  
      public void setNumDocModificado(String value)
      {
/* 1475 */       this.numDocModificado = value;
      }
  
      public String getFechaEmisionDocSustento()
      {
/* 1487 */       return this.fechaEmisionDocSustento;
      }
  
      public void setFechaEmisionDocSustento(String value)
      {
/* 1499 */       this.fechaEmisionDocSustento = value;
      }
  
      public BigDecimal getTotalSinImpuestos()
      {
/* 1511 */       return this.totalSinImpuestos;
      }
  
      public void setTotalSinImpuestos(BigDecimal value)
      {
/* 1523 */       this.totalSinImpuestos = value;
      }
  
      public BigDecimal getValorModificacion()
      {
/* 1535 */       return this.valorModificacion;
      }
  
      public void setValorModificacion(BigDecimal value)
      {
/* 1547 */       this.valorModificacion = value;
      }
  
      public String getMoneda()
      {
/* 1559 */       return this.moneda;
      }
  
      public void setMoneda(String value)
      {
/* 1571 */       this.moneda = value;
      }
  
      public TotalConImpuestos getTotalConImpuestos()
      {
/* 1583 */       return this.totalConImpuestos;
      }
  
      public void setTotalConImpuestos(TotalConImpuestos value)
      {
/* 1595 */       this.totalConImpuestos = value;
      }
  
      public String getMotivo()
      {
/* 1607 */       return this.motivo;
      }
  
      public void setMotivo(String value)
      {
/* 1619 */       this.motivo = value;
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
/* 1068 */       if (this.campoAdicional == null) {
/* 1069 */         this.campoAdicional = new ArrayList<CampoAdicional>();
        }
/* 1071 */       return this.campoAdicional;
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
/* 1112 */         return this.value;
        }
  
        public void setValue(String value)
        {
/* 1124 */         this.value = value;
        }
  
        public String getNombre()
        {
/* 1136 */         return this.nombre;
        }
  
        public void setNombre(String value)
        {
/* 1148 */         this.nombre = value;
        }
      }
    }
  
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name="", propOrder={"detalle"})
    public static class Detalles
    {
  
      @XmlElement(required=true)
      protected List<Detalle> detalle;
  
      public List<Detalle> getDetalle()
      {
/*  450 */       if (this.detalle == null) {
/*  451 */         this.detalle = new ArrayList<Detalle>();
        }
/*  453 */       return this.detalle;
      }
  
      @XmlAccessorType(XmlAccessType.FIELD)
      @XmlType(name="", propOrder={"codigoInterno", "codigoAdicional", "descripcion", "cantidad", "precioUnitario", "descuento", "precioTotalSinImpuesto", "detallesAdicionales", "impuestos"})
      public static class Detalle
      {
  
        @XmlElement(required=true)
        protected String codigoInterno;
        protected String codigoAdicional;
  
        @XmlElement(required=true)
        protected String descripcion;
  
        @XmlElement(required=true)
        protected BigDecimal cantidad;
  
        @XmlElement(required=true)
        protected BigDecimal precioUnitario;
        protected BigDecimal descuento;
  
        @XmlElement(required=true)
        protected BigDecimal precioTotalSinImpuesto;
        protected DetallesAdicionales detallesAdicionales;
  
        @XmlElement(required=true)
        protected Impuestos impuestos;
  
        public String getCodigoInterno()
        {
/*  565 */         return this.codigoInterno;
        }
  
        public void setCodigoInterno(String value)
        {
/*  577 */         this.codigoInterno = value;
        }
  
        public String getCodigoAdicional()
        {
/*  589 */         return this.codigoAdicional;
        }
  
        public void setCodigoAdicional(String value)
        {
/*  601 */         this.codigoAdicional = value;
        }
  
        public String getDescripcion()
        {
/*  613 */         return this.descripcion;
        }
  
        public void setDescripcion(String value)
        {
/*  625 */         this.descripcion = value;
        }
  
        public BigDecimal getCantidad()
        {
/*  637 */         return this.cantidad;
        }
  
        public void setCantidad(BigDecimal value)
        {
/*  649 */         this.cantidad = value;
        }
  
        public BigDecimal getPrecioUnitario()
        {
/*  661 */         return this.precioUnitario;
        }
  
        public void setPrecioUnitario(BigDecimal value)
        {
/*  673 */         this.precioUnitario = value;
        }
  
        public BigDecimal getDescuento()
        {
/*  685 */         return this.descuento;
        }
  
        public void setDescuento(BigDecimal value)
        {
/*  697 */         this.descuento = value;
        }
  
        public BigDecimal getPrecioTotalSinImpuesto()
        {
/*  709 */         return this.precioTotalSinImpuesto;
        }
  
        public void setPrecioTotalSinImpuesto(BigDecimal value)
        {
/*  721 */         this.precioTotalSinImpuesto = value;
        }
  
        public DetallesAdicionales getDetallesAdicionales()
        {
/*  733 */         return this.detallesAdicionales;
        }
  
        public void setDetallesAdicionales(DetallesAdicionales value)
        {
/*  745 */         this.detallesAdicionales = value;
        }
  
        public Impuestos getImpuestos()
        {
/*  757 */         return this.impuestos;
        }
  
        public void setImpuestos(Impuestos value)
        {
/*  769 */         this.impuestos = value;
        }
  
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name="", propOrder={"impuesto"})
        public static class Impuestos
        {
          protected List<Impuesto> impuesto;
  
          public List<Impuesto> getImpuesto()
          {
/*  996 */           if (this.impuesto == null) {
/*  997 */             this.impuesto = new ArrayList<Impuesto>();
            }
/*  999 */           return this.impuesto;
          }
        }
  
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name="", propOrder={"detAdicional"})
        public static class DetallesAdicionales
        {
  
          @XmlElement(required=true)
          protected List<DetAdicional> detAdicional;
  
          public List<DetAdicional> getDetAdicional()
          {
/*  846 */           if (this.detAdicional == null) {
/*  847 */             this.detAdicional = new ArrayList<DetAdicional>();
            }
/*  849 */           return this.detAdicional;
          }
  
          @XmlAccessorType(XmlAccessType.FIELD)
          @XmlType(name="")
          public static class DetAdicional
          {
  
            @XmlAttribute
            protected String nombre;
  
            @XmlAttribute
            protected String valor;
  
            public String getNombre()
            {
/*  902 */             return this.nombre;
            }
  
            public void setNombre(String value)
            {
/*  914 */             this.nombre = value;
            }
  
            public String getValor()
            {
/*  926 */             return this.valor;
            }
  
            public void setValor(String value)
            {
/*  938 */             this.valor = value;
            }
          }
        }
      }
    }
  }

/* Location:           C:\prolan\ce\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.modelo.notacredito.NotaCredito
 * JD-Core Version:    0.6.2
 */