/*     */ package ec.gob.sri.comprobantes.ws.aut;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlSchemaType;
/*     */ import javax.xml.bind.annotation.XmlType;
 
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="autorizacion", propOrder={"estado", "numeroAutorizacion", "fechaAutorizacion", "comprobante", "mensajes"})
/*     */ public class Autorizacion
/*     */ {
/*     */   protected String estado;
/*     */   protected String numeroAutorizacion;
/*     */ 
/*     */   @XmlSchemaType(name="dateTime")
/*     */   protected String fechaAutorizacion;
/*     */   protected String comprobante;
/*     */   protected Mensajes mensajes;
/*     */ 
/*     */   public String getEstado()
/*     */   {
/*  72 */     return this.estado;
/*     */   }
/*     */ 
/*     */   public void setEstado(String value)
/*     */   {
/*  84 */     this.estado = value;
/*     */   }
/*     */ 
/*     */   public String getNumeroAutorizacion()
/*     */   {
/*  96 */     return this.numeroAutorizacion;
/*     */   }
/*     */ 
/*     */   public void setNumeroAutorizacion(String value)
/*     */   {
/* 108 */     this.numeroAutorizacion = value;
/*     */   }
/*     */ 
/*     */   public String getFechaAutorizacion()
/*     */   {
/* 120 */     return this.fechaAutorizacion;
/*     */   }
/*     */ 
/*     */   public void setFechaAutorizacion(String value)
/*     */   {
/* 132 */     this.fechaAutorizacion = value;
/*     */   }
/*     */ 
/*     */   public String getComprobante()
/*     */   {
/* 144 */     return this.comprobante;
/*     */   }
/*     */ 
/*     */   public void setComprobante(String value)
/*     */   {
/* 156 */     this.comprobante = value;
/*     */   }
/*     */ 
/*     */   public Mensajes getMensajes()
/*     */   {
/* 168 */     return this.mensajes;
/*     */   }
/*     */ 
/*     */   public void setMensajes(Mensajes value)
/*     */   {
/* 180 */     this.mensajes = value;
/*     */   }
/*     */ 
/*     */   @XmlAccessorType(XmlAccessType.FIELD)
/*     */   @XmlType(name="", propOrder={"mensaje"})
/*     */   public static class Mensajes
/*     */   {
/*     */     protected List<Mensaje> mensaje;
/*     */ 
/*     */     public List<Mensaje> getMensaje()
/*     */     {
/* 234 */       if (this.mensaje == null) {
/* 235 */         this.mensaje = new ArrayList<Mensaje> ();
/*     */       }
				
/* 237 */       return this.mensaje;
/*     */     }
/*     */   }
/*     */ }

