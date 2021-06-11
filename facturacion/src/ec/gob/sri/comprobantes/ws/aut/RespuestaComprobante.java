/*     */ package ec.gob.sri.comprobantes.ws.aut;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="respuestaComprobante", propOrder={"claveAccesoConsultada", "numeroComprobantes", "autorizaciones"})
/*     */ public class RespuestaComprobante
/*     */ {
/*     */   protected String claveAccesoConsultada;
/*     */   protected String numeroComprobantes;
/*     */   protected Autorizaciones autorizaciones;
/*     */ 
/*     */   public String getClaveAccesoConsultada()
/*     */   {
/*  63 */     return this.claveAccesoConsultada;
/*     */   }
/*     */ 
/*     */   public void setClaveAccesoConsultada(String value)
/*     */   {
/*  75 */     this.claveAccesoConsultada = value;
/*     */   }
/*     */ 
/*     */   public String getNumeroComprobantes()
/*     */   {
/*  87 */     return this.numeroComprobantes;
/*     */   }
/*     */ 
/*     */   public void setNumeroComprobantes(String value)
/*     */   {
/*  99 */     this.numeroComprobantes = value;
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
/* 177 */       
				if (this.autorizacion == null) {
/* 178 */         this.autorizacion = new ArrayList<Autorizacion>();
/*     */       }

/* 180 */       return this.autorizacion;
/*     */     }
/*     */   }
/*     */ }

