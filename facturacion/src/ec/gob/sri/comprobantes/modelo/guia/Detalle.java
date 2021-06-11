  package ec.gob.sri.comprobantes.modelo.guia;
  
  import java.math.BigDecimal;
  import java.util.ArrayList;
  import java.util.List;
  import javax.xml.bind.annotation.XmlAccessType;
  import javax.xml.bind.annotation.XmlAccessorType;
  import javax.xml.bind.annotation.XmlAttribute;
  import javax.xml.bind.annotation.XmlElement;
  import javax.xml.bind.annotation.XmlType;
  
  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(name="detalle", propOrder={"codigoInterno", "codigoAdicional", "descripcion", "cantidad", "detallesAdicionales"})
  public class Detalle
  {
  
    @XmlElement(required=true)
    protected String codigoInterno;
    protected String codigoAdicional;
  
    @XmlElement(required=true)
    protected String descripcion;
  
    @XmlElement(required=true)
    protected BigDecimal cantidad;
    protected DetallesAdicionales detallesAdicionales;
  
    public String getCodigoInterno()
    {
/* 107 */     return this.codigoInterno;
    }
  
    public void setCodigoInterno(String value)
    {
/* 119 */     this.codigoInterno = value;
    }
  
    public String getCodigoAdicional()
    {
/* 131 */     return this.codigoAdicional;
    }
  
    public void setCodigoAdicional(String value)
    {
/* 143 */     this.codigoAdicional = value;
    }
  
    public String getDescripcion()
    {
/* 155 */     return this.descripcion;
    }
  
    public void setDescripcion(String value)
    {
/* 167 */     this.descripcion = value;
    }
  
    public BigDecimal getCantidad()
    {
/* 179 */     return this.cantidad;
    }
  
    public void setCantidad(BigDecimal value)
    {
/* 191 */     this.cantidad = value;
    }
  
    public DetallesAdicionales getDetallesAdicionales()
    {
/* 203 */     return this.detallesAdicionales;
    }
  
    public void setDetallesAdicionales(DetallesAdicionales value)
    {
/* 215 */     this.detallesAdicionales = value;
    }
  
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name="", propOrder={"detAdicional"})
    public static class DetallesAdicionales
    {
      protected List<DetAdicional> detAdicional;
  
      public List<DetAdicional> getDetAdicional()
      {
/* 292 */       if (this.detAdicional == null) {
/* 293 */         this.detAdicional = new ArrayList<DetAdicional>();
        }
/* 295 */       return this.detAdicional;
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
/* 349 */         return this.nombre;
        }
  
        public void setNombre(String value)
        {
/* 361 */         this.nombre = value;
        }
  
        public String getValor()
        {
/* 373 */         return this.valor;
        }
  
        public void setValor(String value)
        {
/* 385 */         this.valor = value;
        }
      }
    }
  }

 