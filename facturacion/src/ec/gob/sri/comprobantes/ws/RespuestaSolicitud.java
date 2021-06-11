/*     */ package ec.gob.sri.comprobantes.ws;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlRootElement;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ @XmlRootElement
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="respuestaSolicitud", propOrder={"estado", "comprobantes"})
/*     */ public class RespuestaSolicitud
/*     */ {
/*     */   protected String estado;
/*     */   protected Comprobantes comprobantes;
/*     */ 
/*     */   public String getEstado()
/*     */   {
/*  62 */     return this.estado;
/*     */   }
/*     */ 
/*     */   public void setEstado(String value)
/*     */   {
/*  74 */     this.estado = value;
/*     */   }
/*     */ 
/*     */   public Comprobantes getComprobantes()
/*     */   {
/*  86 */     return this.comprobantes;
/*     */   }
/*     */ 
/*     */   public void setComprobantes(Comprobantes value)
/*     */   {
/*  98 */     this.comprobantes = value;
/*     */   }
/*     */ 
/*     */   @XmlAccessorType(XmlAccessType.FIELD)
/*     */   @XmlType(name="", propOrder={"comprobante"})
/*     */   public static class Comprobantes
/*     */   {
/*     */     protected List<Comprobante> comprobante;
/*     */ 
/*     */     public List<Comprobante> getComprobante()
/*     */     {
/* 152 */       if (this.comprobante == null) {
/* 153 */         this.comprobante = new ArrayList<Comprobante>();
/*     */       }
/* 155 */       return this.comprobante;
/*     */     }
/*     */   }
/*     */ }

 