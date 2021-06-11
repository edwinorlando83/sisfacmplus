/*     */ package ec.gob.sri.comprobantes.ws.aut;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="respuestaLote", propOrder={"claveAccesoLoteConsultada", "numeroComprobantesLote", "autorizaciones"})
/*     */ public class RespuestaLote
/*     */ {
/*     */   protected String claveAccesoLoteConsultada;
/*     */   protected String numeroComprobantesLote;
/*     */   protected Autorizaciones autorizaciones;
/*     */ 
/*     */   public String getClaveAccesoLoteConsultada()
/*     */   {
/*  63 */     return this.claveAccesoLoteConsultada;
/*     */   }
/*     */ 
/*     */   public void setClaveAccesoLoteConsultada(String value)
/*     */   {
/*  75 */     this.claveAccesoLoteConsultada = value;
/*     */   }
/*     */ 
/*     */   public String getNumeroComprobantesLote()
/*     */   {
/*  87 */     return this.numeroComprobantesLote;
/*     */   }
/*     */ 
/*     */   public void setNumeroComprobantesLote(String value)
/*     */   {
/*  99 */     this.numeroComprobantesLote = value;
/*     */   }
/*     */ 
/*     */   public Autorizaciones getAutorizaciones()
/*     */   {
/* 111 */     return this.autorizaciones;
/*     */   }
/*     */ 
/*     */   public void setAutorizaciones(Autorizaciones value)
/*     */   {
/* 123 */     this.autorizaciones = value;
/*     */   }
/*     */ 
/*     */   @XmlAccessorType(XmlAccessType.FIELD)
/*     */   @XmlType(name="", propOrder={"autorizacion"})
/*     */   public static class Autorizaciones
/*     */   {
/*     */     protected List<Autorizacion> autorizacion;
/*     */ 
/*     */     public List<Autorizacion> getAutorizacion()
/*     */     {
/* 177 */       if (this.autorizacion == null) {
/* 178 */         this.autorizacion = new ArrayList<Autorizacion>();
/*     */       }
/* 180 */       return this.autorizacion;
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\componentes-1.1.7-with-deps\componentes-1.1.7\deps\cliente-file-ws.jar
 * Qualified Name:     ec.gob.sri.comprobantes.ws.aut.RespuestaLote
 * JD-Core Version:    0.6.2
 */