  package ec.gob.sri.comprobantes.modelo.factura;
  
  import java.math.BigDecimal;
  import javax.xml.bind.annotation.XmlAccessType;
  import javax.xml.bind.annotation.XmlAccessorType;
  import javax.xml.bind.annotation.XmlElement;
  import javax.xml.bind.annotation.XmlType;
  
  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(name="impuesto", propOrder={"codigo", "codigoPorcentaje", "tarifa", "baseImponible", "valor"})
  public class Impuesto
  {
  
    @XmlElement(required=true)
    protected String codigo;
  
    @XmlElement(required=true)
    protected String codigoPorcentaje;
  
    @XmlElement(required=true)
    protected BigDecimal tarifa;
  
    @XmlElement(required=true)
    protected BigDecimal baseImponible;
  
    @XmlElement(required=true)
    protected BigDecimal valor;
  
    public String getCodigo()
    {
/*  73 */     return this.codigo;
    }
  
    public void setCodigo(String value)
    {
/*  85 */     this.codigo = value;
    }
  
    public String getCodigoPorcentaje()
    {
/*  97 */     return this.codigoPorcentaje;
    }
  
    public void setCodigoPorcentaje(String value)
    {
/* 109 */     this.codigoPorcentaje = value;
    }
  
    public BigDecimal getTarifa()
    {
/* 121 */     return this.tarifa;
    }
  
    public void setTarifa(BigDecimal value)
    {
/* 133 */     this.tarifa = value;
    }
  
    public BigDecimal getBaseImponible()
    {
/* 145 */     return this.baseImponible;
    }
  
    public void setBaseImponible(BigDecimal value)
    {
/* 157 */     this.baseImponible = value;
    }
  
    public BigDecimal getValor()
    {
/* 169 */     return this.valor;
    }
  
    public void setValor(BigDecimal value)
    {
/* 181 */     this.valor = value;
    }
  }

 