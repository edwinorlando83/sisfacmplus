/*     */ package ec.gob.sri.comprobantes.modelo.notadebito;
/*     */ 
/*     */ import ec.gob.sri.comprobantes.modelo.InfoTributaria;
/*     */ import javax.xml.bind.annotation.XmlRegistry;
/*     */ 
/*     */ @XmlRegistry
/*     */ public class ObjectFactory
/*     */ {
/*     */   public NotaDebito.InfoAdicional createNotaDebitoInfoAdicional()
/*     */   {
/*  45 */     return new NotaDebito.InfoAdicional();
/*     */   }
/*     */ 
/*     */   public Impuesto createImpuesto()
/*     */   {
/*  53 */     return new Impuesto();
/*     */   }
/*     */ 
/*     */   public NotaDebito.Motivos createNotaDebitoMotivos()
/*     */   {
/*  61 */     return new NotaDebito.Motivos();
/*     */   }
/*     */ 
/*     */   public NotaDebito.InfoNotaDebito.Impuestos createNotaDebitoInfoNotaDebitoImpuestos()
/*     */   {
/*  69 */     return new NotaDebito.InfoNotaDebito.Impuestos();
/*     */   }
/*     */ 
/*     */   public NotaDebito.InfoNotaDebito createNotaDebitoInfoNotaDebito()
/*     */   {
/*  77 */     return new NotaDebito.InfoNotaDebito();
/*     */   }
/*     */ 
/*     */   public NotaDebito.InfoAdicional.CampoAdicional createNotaDebitoInfoAdicionalCampoAdicional()
/*     */   {
/*  85 */     return new NotaDebito.InfoAdicional.CampoAdicional();
/*     */   }
/*     */ 
/*     */   public Detalle createDetalle()
/*     */   {
/*  93 */     return new Detalle();
/*     */   }
/*     */ 
/*     */   public InfoTributaria createInfoTributaria()
/*     */   {
/* 101 */     return new InfoTributaria();
/*     */   }
/*     */ 
/*     */   public NotaDebito createNotaDebito()
/*     */   {
/* 109 */     return new NotaDebito();
/*     */   }
/*     */ 
/*     */   public NotaDebito.Motivos.Motivo createNotaDebitoMotivosMotivo()
/*     */   {
/* 117 */     return new NotaDebito.Motivos.Motivo();
/*     */   }
/*     */ }

/* Location:           C:\prolan\ce\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.modelo.notadebito.ObjectFactory
 * JD-Core Version:    0.6.2
 */