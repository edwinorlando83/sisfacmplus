 package ec.gob.sri.comprobantes.modelo.reportes;
 import java.util.ArrayList;
 import java.util.List;

 
 import ec.gob.sri.comprobantes.modelo.rentencion.ComprobanteRetencion;
 import ec.gob.sri.comprobantes.modelo.rentencion.Impuesto;
 
 public class ComprobanteRetencionReporte
 {
   private ComprobanteRetencion comprobanteRetencion;
   private List<DetallesAdicionalesReporte> detallesAdiciones;
   private List<InformacionAdicional> infoAdicional;
 
 
   public ComprobanteRetencionReporte(ComprobanteRetencion comprobanteRetencion)
   {
/*  31 */     this.comprobanteRetencion = comprobanteRetencion;
   }
 
   public ComprobanteRetencion getComprobanteRetencion()
   {
/*  38 */     return this.comprobanteRetencion;
   }
 
   public void setComprobanteRetencion(ComprobanteRetencion comprobanteRetencion)
   {
/*  45 */     this.comprobanteRetencion = comprobanteRetencion;
   }
 
   public List<DetallesAdicionalesReporte> getDetallesAdiciones()
   {
/*  52 */     this.detallesAdiciones = new ArrayList<DetallesAdicionalesReporte>();
/*  53 */     System.out.println(this.comprobanteRetencion.getImpuestos().getImpuesto().size());
/*  54 */     for (Impuesto im : this.comprobanteRetencion.getImpuestos().getImpuesto()) {
/*  55 */       DetallesAdicionalesReporte detAd = new DetallesAdicionalesReporte();
/*  56 */       detAd.setBaseImponible(im.getBaseImponible().toString());
/*  57 */       detAd.setPorcentajeRetener(im.getPorcentajeRetener().toString());
/*  58 */       detAd.setValorRetenido(im.getValorRetenido().toString());
/*  59 */       detAd.setNombreImpuesto(obtenerImpuestoDecripcion(im.getCodigo()));
/*  60 */       detAd.setInfoAdicional(getInfoAdicional());
/*  61 */       detAd.setNumeroComprobante(im.getNumDocSustento());
/*  62 */       detAd.setNombreComprobante(obtenerDecripcionComprobante(im.getCodDocSustento()));
/*  63 */       detAd.setFechaEmisionCcompModificado(im.getFechaEmisionDocSustento());
/*  64 */       this.detallesAdiciones.add(detAd);
     }
/*  66 */     return this.detallesAdiciones;
   }
 
   private String obtenerDecripcionComprobante(String codDocSustento) {
/*  70 */     if ("01".equals(codDocSustento)) {
/*  71 */       return "FACTURA";
     }
/*  73 */     if ("04".equals(codDocSustento)) {
/*  74 */       return "NOTA DE CREITO";
     }
/*  76 */     if ("05".equals(codDocSustento)) {
/*  77 */       return "NOTA DE DEBITO";
     }
/*  79 */     if ("06".equals(codDocSustento)) {
/*  80 */       return "GUIA DE REMISION";
     }
/*  82 */     if ("07".equals(codDocSustento)) {
/*  83 */       return "COMPROBANTE RETENCION";
     }
/*  85 */     return null;
   }
 
   private String obtenerImpuestoDecripcion(String codigoImpuesto) {
/*  89 */     if (codigoImpuesto.equals("1")) {
/*  90 */       return "RENTA";
     }
/*  92 */     if (codigoImpuesto.equals("2")) {
/*  93 */       return "IVA";
     }
/*  95 */     if (codigoImpuesto.equals("3")) {
/*  96 */       return "ICE";
     }
/*  98 */     if (codigoImpuesto.equals("6")) {
/*  99 */       return "IMPUESTO A LA SALIDA DE DIVISAS";
     }
/* 101 */     return null;
   }
 
   public void setDetallesAdiciones(List<DetallesAdicionalesReporte> detallesAdiciones)
   {
/* 108 */     this.detallesAdiciones = detallesAdiciones;
   }
 
   public List<InformacionAdicional> getInfoAdicional()
   {
/* 115 */     if (this.comprobanteRetencion.getInfoAdicional() != null) {
/* 116 */       this.infoAdicional = new ArrayList<InformacionAdicional>();
/* 117 */       if ((this.comprobanteRetencion.getInfoAdicional().getCampoAdicional() != null) && (!this.comprobanteRetencion.getInfoAdicional().getCampoAdicional().isEmpty())) {
/* 118 */         for (ComprobanteRetencion.InfoAdicional.CampoAdicional ca : this.comprobanteRetencion.getInfoAdicional().getCampoAdicional()) {
/* 119 */           this.infoAdicional.add(new InformacionAdicional(ca.getValue(), ca.getNombre()));
         }
       }
     }
/* 123 */     return this.infoAdicional;
   }
 
   public void setInfoAdicional(List<InformacionAdicional> infoAdicional)
   {
/* 130 */     this.infoAdicional = infoAdicional;
   }
 }

 