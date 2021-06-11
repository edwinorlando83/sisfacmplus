/*     */ package ec.gob.sri.comprobantes.ws;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="comprobante", propOrder={"claveAcceso", "mensajes"})
/*     */ public class Comprobante
/*     */ {
/*     */   protected String claveAcceso;
/*     */   protected Mensajes mensajes;
/*     */ 
/*     */   public String getClaveAcceso()
/*     */   {
/*  60 */     return this.claveAcceso;
/*     */   }
/*     */ 
/*     */   public void setClaveAcceso(String value)
/*     */   {
/*  72 */     this.claveAcceso = value;
/*     */   }
/*     */ 
/*     */   public Mensajes getMensajes()
/*     */   {
/*  84 */     return this.mensajes;
/*     */   }
/*     */ 
/*     */   public void setMensajes(Mensajes value)
/*     */   {
/*  96 */     this.mensajes = value;
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
/* 150 */       if (this.mensaje == null) {
/* 151 */         this.mensaje = new ArrayList<Mensaje>();
/*     */       }
/* 153 */       return this.mensaje;
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\componentes-1.1.7-with-deps\componentes-1.1.7\deps\cliente-file-ws.jar
 * Qualified Name:     ec.gob.sri.comprobantes.ws.Comprobante
 * JD-Core Version:    0.6.2
 */