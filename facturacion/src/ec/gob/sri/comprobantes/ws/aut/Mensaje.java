/*     */ package ec.gob.sri.comprobantes.ws.aut;
/*     */ 
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="mensaje", propOrder={"identificador", "mensaje", "informacionAdicional", "tipo"})
/*     */ public class Mensaje
/*     */ {
/*     */   protected String identificador;
/*     */   protected String mensaje;
/*     */   protected String informacionAdicional;
/*     */   protected String tipo;
/*     */ 
/*     */   public String getIdentificador()
/*     */   {
/*  54 */     return this.identificador;
/*     */   }
/*     */ 
/*     */   public void setIdentificador(String value)
/*     */   {
/*  66 */     this.identificador = value;
/*     */   }
/*     */ 
/*     */   public String getMensaje()
/*     */   {
/*  78 */     return this.mensaje;
/*     */   }
/*     */ 
/*     */   public void setMensaje(String value)
/*     */   {
/*  90 */     this.mensaje = value;
/*     */   }
/*     */ 
/*     */   public String getInformacionAdicional()
/*     */   {
/* 102 */     return this.informacionAdicional;
/*     */   }
/*     */ 
/*     */   public void setInformacionAdicional(String value)
/*     */   {
/* 114 */     this.informacionAdicional = value;
/*     */   }
/*     */ 
/*     */   public String getTipo()
/*     */   {
/* 126 */     return this.tipo;
/*     */   }
/*     */ 
/*     */   public void setTipo(String value)
/*     */   {
/* 138 */     this.tipo = value;
/*     */   }
/*     */ }

/* Location:           C:\componentes-1.1.7-with-deps\componentes-1.1.7\deps\cliente-file-ws.jar
 * Qualified Name:     ec.gob.sri.comprobantes.ws.aut.Mensaje
 * JD-Core Version:    0.6.2
 */