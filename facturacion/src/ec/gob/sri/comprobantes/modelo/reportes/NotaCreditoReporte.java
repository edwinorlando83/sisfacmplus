 package ec.gob.sri.comprobantes.modelo.reportes;
 
 import java.util.ArrayList;
import java.util.List;

import ec.gob.sri.comprobantes.modelo.notacredito.NotaCredito;
 
 public class NotaCreditoReporte
 {
   private NotaCredito notaCredito;
   private List<DetallesAdicionalesReporte> detallesAdiciones;
   private List<InformacionAdicional> infoAdicional;
 
   public NotaCreditoReporte(NotaCredito notaCredito)
   {
/*  21 */     this.notaCredito = notaCredito;
   }
 
   public NotaCredito getNotaCredito()
   {
/*  28 */     return this.notaCredito;
   }
 
   public void setNotaCredito(NotaCredito notaCredito)
   {
/*  35 */     this.notaCredito = notaCredito;
   }
 
   public List<DetallesAdicionalesReporte> getDetallesAdiciones()
   {
/*  42 */     this.detallesAdiciones = new ArrayList<DetallesAdicionalesReporte>();
 
/*  44 */     for (NotaCredito.Detalles.Detalle det : getNotaCredito().getDetalles().getDetalle()) {
/*  45 */       DetallesAdicionalesReporte detAd = new DetallesAdicionalesReporte();
/*  46 */       detAd.setCodigoPrincipal(det.getCodigoInterno());
/*  47 */       detAd.setCodigoAuxiliar(det.getCodigoAdicional());
/*  48 */       detAd.setDescripcion(det.getDescripcion());
/*  49 */       detAd.setCantidad(det.getCantidad().toPlainString());
/*  50 */       detAd.setPrecioTotalSinImpuesto(det.getPrecioTotalSinImpuesto().toString());
/*  51 */       detAd.setPrecioUnitario(det.getPrecioUnitario().toString());
/*  52 */       detAd.setDescuento(det.getDescuento().toString());
/*  53 */      // int i = 0;
/*  54 */       //if ((det.getDetallesAdicionales() != null) && (det.getDetallesAdicionales().getDetAdicional() != null)) {
/*  55 */        // for (NotaCredito.Detalles.Detalle.DetallesAdicionales.DetAdicional detAdicional : det.getDetallesAdicionales().getDetAdicional()) {
/*  56 */          // if (i == 0) {
/*  57 */            // detAd.setDetalle1(detAdicional.getNombre());
           //}
/*  59 */           //if (i == 1) {
/*  60 */             //detAd.setDetalle2(detAdicional.getNombre());
           //}
/*  62 */           //if (i == 2) {
/*  63 */             //detAd.setDetalle3(detAdicional.getNombre());
           //}
/*  65 */           //i++;
         //}
 
       //}
 
/*  70 */       detAd.setInfoAdicional(getInfoAdicional());
/*  71 */       this.detallesAdiciones.add(detAd);
     }
/*  73 */     return this.detallesAdiciones;
   }
 
   public void setDetallesAdiciones(List<DetallesAdicionalesReporte> detallesAdiciones)
   {
/*  80 */     this.detallesAdiciones = detallesAdiciones;
   }
 
   public List<InformacionAdicional> getInfoAdicional()
   {
/*  87 */     if (this.notaCredito.getInfoAdicional() != null) {
/*  88 */       this.infoAdicional = new ArrayList<InformacionAdicional>();
/*  89 */       if ((this.notaCredito.getInfoAdicional().getCampoAdicional() != null) && (!this.notaCredito.getInfoAdicional().getCampoAdicional().isEmpty())) {
/*  90 */         for (NotaCredito.InfoAdicional.CampoAdicional ca : this.notaCredito.getInfoAdicional().getCampoAdicional()) {
/*  91 */           this.infoAdicional.add(new InformacionAdicional(ca.getValue(), ca.getNombre()));
         }
       }
     }
/*  95 */     return this.infoAdicional;
   }
 
   public void setInfoAdicional(List<InformacionAdicional> infoAdicional)
   {
/* 102 */     this.infoAdicional = infoAdicional;
   }
 }

 