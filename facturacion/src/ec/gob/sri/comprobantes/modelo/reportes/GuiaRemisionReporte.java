  package ec.gob.sri.comprobantes.modelo.reportes;
  
  import java.util.ArrayList;
import java.util.List;

import ec.gob.sri.comprobantes.modelo.guia.Destinatario;
import ec.gob.sri.comprobantes.modelo.guia.Detalle;
import ec.gob.sri.comprobantes.modelo.guia.GuiaRemision;
import ec.gob.sri.comprobantes.util.StringUtil;
  
  public class GuiaRemisionReporte
  {
    private GuiaRemision guiaRemision;
    private String nombreComprobante;
    private String numDocSustento;
    private String fechaEmisionSustento;
    private String numeroAutorizacion;
    private String motivoTraslado;
    private String destino;
    private String rucDestinatario;
    private String razonSocial;
    private String docAduanero;
    private String codigoEstab;
    private String ruta;
    private List<DetalleGuiaReporte> detalles;
    private List<GuiaRemisionReporte> guiaRemisionList;
  
    public GuiaRemisionReporte(GuiaRemision guiaRemision)
    {
/*  36 */     this.guiaRemision = guiaRemision;
    }
  
    public GuiaRemisionReporte()
    {
    }
  
    public GuiaRemision getGuiaRemision()
    {
/*  47 */     return this.guiaRemision;
    }
  
    public void setGuiaRemision(GuiaRemision guiaRemision)
    {
/*  54 */     this.guiaRemision = guiaRemision;
    }
  
    public String getNombreComprobante()
    {
/*  61 */     return this.nombreComprobante;
    }
  
    public void setNombreComprobante(String nombreComprobante)
    {
/*  68 */     this.nombreComprobante = nombreComprobante;
    }
  
    public String getNumDocSustento()
    {
/*  75 */     return this.numDocSustento;
    }
  
    public void setNumDocSustento(String numDocSustento)
    {
/*  82 */     this.numDocSustento = numDocSustento;
    }
  
    public String getFechaEmisionSustento()
    {
/*  89 */     return this.fechaEmisionSustento;
    }
  
    public void setFechaEmisionSustento(String fechaEmisionSustento)
    {
/*  96 */     this.fechaEmisionSustento = fechaEmisionSustento;
    }
  
    public String getNumeroAutorizacion()
    {
/* 103 */     return this.numeroAutorizacion;
    }
  
    public void setNumeroAutorizacion(String numeroAutorizacion)
    {
/* 110 */     this.numeroAutorizacion = numeroAutorizacion;
    }
  
    public String getMotivoTraslado()
    {
/* 117 */     return this.motivoTraslado;
    }
  
    public void setMotivoTraslado(String motivoTraslado)
    {
/* 124 */     this.motivoTraslado = motivoTraslado;
    }
  
    public String getDestino()
    {
/* 131 */     return this.destino;
    }
  
    public void setDestino(String destino)
    {
/* 138 */     this.destino = destino;
    }
  
    public String getRucDestinatario()
    {
/* 145 */     return this.rucDestinatario;
    }
  
    public void setRucDestinatario(String rucDestinatario)
    {
/* 152 */     this.rucDestinatario = rucDestinatario;
    }
  
    public String getRazonSocial()
    {
/* 159 */     return this.razonSocial;
    }
  
    public void setRazonSocial(String razonSocial)
    {
/* 166 */     this.razonSocial = razonSocial;
    }
  
    public String getDocAduanero()
    {
/* 173 */     return this.docAduanero;
    }
  
    public void setDocAduanero(String docAduanero)
    {
/* 180 */     this.docAduanero = docAduanero;
    }
  
    public String getCodigoEstab()
    {
/* 187 */     return this.codigoEstab;
    }
  
    public void setCodigoEstab(String cosdigoEstab)
    {
/* 194 */     this.codigoEstab = cosdigoEstab;
    }
  
    public String getRuta()
    {
/* 201 */     return this.ruta;
    }
  
    public void setRuta(String ruta)
    {
/* 208 */     this.ruta = ruta;
    }
  
    public List<GuiaRemisionReporte> getGuiaRemisionList()
    {
/* 217 */     this.guiaRemisionList = new ArrayList<GuiaRemisionReporte>();
/* 218 */     for (Destinatario dest : this.guiaRemision.getDestinatarios().getDestinatario()) {
/* 219 */       GuiaRemisionReporte gr = new GuiaRemisionReporte();
/* 220 */       gr.setNombreComprobante(StringUtil.obtenerDocumentoModificado(dest.getCodDocSustento()));
/* 221 */       gr.setNumDocSustento(dest.getNumDocSustento());
/* 222 */       gr.setFechaEmisionSustento(dest.getFechaEmisionDocSustento());
/* 223 */       gr.setNumeroAutorizacion(dest.getNumAutDocSustento());
/* 224 */       gr.setMotivoTraslado(dest.getMotivoTraslado());
/* 225 */       gr.setDestino(dest.getDirDestinatario());
/* 226 */       gr.setRucDestinatario(dest.getIdentificacionDestinatario());
/* 227 */       gr.setRazonSocial(dest.getRazonSocialDestinatario());
/* 228 */       gr.setDocAduanero(dest.getDocAduaneroUnico());
/* 229 */       gr.setCodigoEstab(dest.getCodEstabDestino());
/* 230 */       gr.setRuta(dest.getRuta());
/* 231 */       gr.setDetalles(obtenerDetalles(dest));
  
/* 233 */       this.guiaRemisionList.add(gr);
      }
  
/* 236 */     return this.guiaRemisionList;
    }
    private List<DetalleGuiaReporte> obtenerDetalles(Destinatario dest) {
/* 239 */     List<DetalleGuiaReporte> list = new ArrayList<DetalleGuiaReporte>();
/* 240 */     for (Detalle detalle : dest.getDetalles().getDetalle()) {
/* 241 */       DetalleGuiaReporte dgr = new DetalleGuiaReporte();
/* 242 */       dgr.setCantidad(detalle.getCantidad().toPlainString());
/* 243 */       dgr.setDescripcion(detalle.getDescripcion());
/* 244 */       dgr.setCodigoPrincipal(detalle.getCodigoInterno());
/* 245 */       dgr.setCodigoAuxiliar(detalle.getCodigoAdicional());
/* 246 */       list.add(dgr);
      }
/* 248 */     return list;
    }
  
    public void setGuiaRemisionList(List<GuiaRemisionReporte> guiaRemisionList)
    {
/* 255 */     this.guiaRemisionList = guiaRemisionList;
    }
  
    public List<DetalleGuiaReporte> getDetalles()
    {
/* 262 */     return this.detalles;
    }
  
    public void setDetalles(List<DetalleGuiaReporte> detalles)
    {
/* 269 */     this.detalles = detalles;
    }
  }

 