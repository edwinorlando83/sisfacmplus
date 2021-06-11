  package ec.gob.sri.comprobantes.modelo.reportes;
  
  import java.util.ArrayList;
import java.util.List;

import ec.gob.sri.comprobantes.modelo.factura.Factura;
  
  public class FacturaReporte
  {
    private Factura factura;
    private String detalle1;
    private String detalle2;
    private String detalle3;
  
    private List<DetallesAdicionalesReporte> detallesAdiciones;
    private List<InformacionAdicional> infoAdicional;
  
    public FacturaReporte(Factura factura)
    {
/*  25 */     this.factura = factura;
    }
  
    public Factura getFactura()
    {
/*  32 */     return this.factura;
    }
  
    public void setFactura(Factura factura)
    {
/*  39 */     this.factura = factura;
    }
  
    public String getDetalle1()
    {
/*  46 */     return this.detalle1;
    }
  
    public void setDetalle1(String detalle1)
    {
/*  53 */     this.detalle1 = detalle1;
    }
  
    public String getDetalle2()
    {
/*  60 */     return this.detalle2;
    }
  
    public void setDetalle2(String detalle2)
    {
/*  67 */     this.detalle2 = detalle2;
    }
  
    public String getDetalle3()
    {
/*  74 */     return this.detalle3;
    }
  
   public void setDetalle3(String detalle3)
    {
/*  81 */     this.detalle3 = detalle3;
    }
  
    public List<DetallesAdicionalesReporte> getDetallesAdiciones()
    {
/*  88 */     this.detallesAdiciones = new ArrayList<DetallesAdicionalesReporte>();
  
/*  90 */     for (Factura.Detalles.Detalle det : getFactura().getDetalles().getDetalle()) {
/*  91 */       DetallesAdicionalesReporte detAd = new DetallesAdicionalesReporte();
/*  92 */       detAd.setCodigoPrincipal(det.getCodigoPrincipal());
/*  93 */       detAd.setCodigoAuxiliar(det.getCodigoAuxiliar());
/*  94 */       detAd.setDescripcion(det.getDescripcion());
/*  95 */       detAd.setCantidad(det.getCantidad().toPlainString());
/*  96 */       detAd.setPrecioTotalSinImpuesto(det.getPrecioTotalSinImpuesto().toString());
 
/*  97 */       detAd.setPrecioUnitario(det.getPrecioUnitario().toString());
              Double Subsidio= 0.0,precioSinSubsidio = 0.0;
                if( det.getPrecioSinSubsidio()!=null)
                  Subsidio  = det.getPrecioSinSubsidio().doubleValue() - det.getPrecioUnitario().doubleValue();
                detAd.setSubsidio(Subsidio.toString());
                
                if( det.getPrecioSinSubsidio()!=null)
                	precioSinSubsidio = det.getPrecioSinSubsidio().doubleValue();
                
                detAd.setPrecioSinSubsidio(precioSinSubsidio.toString());
                
                
                detAd.setDetalle1("");
                detAd.setDetalle2("");
                detAd.setDetalle3("");
                
/*  98 */       if (det.getDescuento() != null) {
/*  99 */         detAd.setDescuento(det.getDescuento().toString());
        }
/* 101 */       int i = 0;
/* 102 */        if ((det.getDetallesAdicionales() != null) && (det.getDetallesAdicionales().getDetAdicional() != null) && (!det.getDetallesAdicionales().getDetAdicional().isEmpty())) {
/* 103 */         for (Factura.Detalles.Detalle.DetallesAdicionales.DetAdicional detAdicional : det.getDetallesAdicionales().getDetAdicional()) {
/* 104 */           if (i == 0) {
/* 105 */            detAd.setDetalle1(detAdicional.getValor());
             }
/* 107 */            if (i == 1) {
/* 108 */              detAd.setDetalle2(detAdicional.getValor());
            }
/* 110 */           if (i == 2) {
/* 111 */             detAd.setDetalle3(detAdicional.getValor());
             }
/* 113 */           i++;
           }
         }
/* 116 */       detAd.setInfoAdicional(getInfoAdicional());
/* 117 */       this.detallesAdiciones.add(detAd);
      }
  
/* 120 */     return this.detallesAdiciones;
    }
  
    public void setDetallesAdiciones(List<DetallesAdicionalesReporte> detallesAdiciones)
    {
/* 127 */     this.detallesAdiciones = detallesAdiciones;
    }
  
    public List<InformacionAdicional> getInfoAdicional()
    {
 
      if (getFactura().getInfoAdicional() != null) {
        this.infoAdicional = new ArrayList<InformacionAdicional>();
       if ((getFactura().getInfoAdicional().getCampoAdicional() != null) && (!this.factura.getInfoAdicional().getCampoAdicional().isEmpty())) {
         for (Factura.InfoAdicional.CampoAdicional ca : getFactura().getInfoAdicional().getCampoAdicional()) {
            this.infoAdicional.add(new InformacionAdicional(ca.getValue(), ca.getNombre()));
          }
        }
      }
      return this.infoAdicional;
    }
  
    public void setInfoAdicional(List<InformacionAdicional> infoAdicional)
    {
   this.infoAdicional = infoAdicional;
    }

	 
  }

