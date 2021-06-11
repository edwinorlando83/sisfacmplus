 package ec.gob.sri.comprobantes.modelo.reportes;
 import java.util.ArrayList;
 import java.util.List;

 
 import ec.gob.sri.comprobantes.modelo.notadebito.NotaDebito;
 
 public class NotaDebitoReporte
 {
   private NotaDebito notaDebito;
   private List<DetallesAdicionalesReporte> detallesAdiciones;
   private List<InformacionAdicional> infoAdicional;
 
   public NotaDebitoReporte(NotaDebito notaDebito)
   {
/* 22 */     this.notaDebito = notaDebito;
   }
 
   public List<DetallesAdicionalesReporte> getDetallesAdiciones()
   {
/* 29 */     this.detallesAdiciones = new ArrayList<DetallesAdicionalesReporte>();
/* 30 */     for (NotaDebito.Motivos.Motivo motivo : this.notaDebito.getMotivos().getMotivo()) {
/* 31 */       DetallesAdicionalesReporte detAd = new DetallesAdicionalesReporte();
/* 32 */       detAd.setRazonModificacion(motivo.getRazon());
/* 33 */       detAd.setValorModificacion(motivo.getValor().toString());
/* 34 */       detAd.setInfoAdicional(getInfoAdicional());
/* 35 */       this.detallesAdiciones.add(detAd);
     }
/* 37 */     return this.detallesAdiciones;
   }
 
   public void setDetallesAdiciones(List<DetallesAdicionalesReporte> detallesAdiciones)
   {
/* 44 */     this.detallesAdiciones = detallesAdiciones;
   }
 
   public NotaDebito getNotaDebito()
   {
/* 51 */     return this.notaDebito;
   }
 
   public void setNotaDebito(NotaDebito notaDebito)
   {
/* 58 */     this.notaDebito = notaDebito;
   }
 
   public List<InformacionAdicional> getInfoAdicional()
   {
/* 66 */     if ((this.notaDebito.getInfoAdicional() != null) && (!this.notaDebito.getInfoAdicional().getCampoAdicional().isEmpty())) {
/* 67 */       this.infoAdicional = new ArrayList<InformacionAdicional>();
/* 68 */       for (NotaDebito.InfoAdicional.CampoAdicional info : this.notaDebito.getInfoAdicional().getCampoAdicional()) {
/* 69 */         InformacionAdicional ia = new InformacionAdicional(info.getValue(), info.getNombre());
/* 70 */         this.infoAdicional.add(ia);
       }
     }
/* 73 */     return this.infoAdicional;
   }
 
   public void setInfoAdicional(List<InformacionAdicional> infoAdicional)
   {
/* 80 */     this.infoAdicional = infoAdicional;
   }
 }

/* Location:           C:\prolan\ce\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.modelo.reportes.NotaDebitoReporte
 * JD-Core Version:    0.6.2
 */