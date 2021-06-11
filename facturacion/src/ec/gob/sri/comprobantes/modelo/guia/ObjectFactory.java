  package ec.gob.sri.comprobantes.modelo.guia;
  
  import ec.gob.sri.comprobantes.modelo.InfoTributaria;
  import javax.xml.bind.annotation.XmlRegistry;
  
  @XmlRegistry
  public class ObjectFactory
  {
    public GuiaRemision.Destinatarios createGuiaRemisionDestinatarios()
    {
/*  45 */     return new GuiaRemision.Destinatarios();
    }
  
    public Detalle.DetallesAdicionales createDetalleDetallesAdicionales()
    {
/*  53 */     return new Detalle.DetallesAdicionales();
    }
  
    public Destinatario createDestinatario()
    {
/*  61 */     return new Destinatario();
    }
  
    public Detalle.DetallesAdicionales.DetAdicional createDetalleDetallesAdicionalesDetAdicional()
    {
/*  69 */     return new Detalle.DetallesAdicionales.DetAdicional();
    }
  
    public Destinatario.Detalles createDestinatarioDetalles()
    {
/*  77 */     return new Destinatario.Detalles();
    }
  
    public GuiaRemision createGuiaRemision()
    {
/*  85 */     return new GuiaRemision();
    }
  
    public GuiaRemision.InfoAdicional.CampoAdicional createGuiaRemisionInfoAdicionalCampoAdicional()
    {
/*  93 */     return new GuiaRemision.InfoAdicional.CampoAdicional();
    }
  
    public GuiaRemision.InfoAdicional createGuiaRemisionInfoAdicional()
    {
/* 101 */     return new GuiaRemision.InfoAdicional();
    }
  
    public InfoTributaria createInfoTributaria()
    {
/* 109 */     return new InfoTributaria();
    }
  
    public GuiaRemision.InfoGuiaRemision createGuiaRemisionInfoGuiaRemision()
    {
/* 117 */     return new GuiaRemision.InfoGuiaRemision();
    }
  
    public Detalle createDetalle()
    {
/* 125 */     return new Detalle();
    }
  }

 