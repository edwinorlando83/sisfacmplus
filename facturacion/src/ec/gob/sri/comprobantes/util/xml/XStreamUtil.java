/*     */ package ec.gob.sri.comprobantes.util.xml;
/*     */ 
/*     */ import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
/*     */ import com.thoughtworks.xstream.XStream;
/*     */ import com.thoughtworks.xstream.core.util.QuickWriter;
/*     */ import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
/*     */ import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
/*     */ import com.thoughtworks.xstream.io.xml.XppDriver;
/*     */ import ec.gob.sri.comprobantes.modelo.ComprobanteXml;
/*     */ import ec.gob.sri.comprobantes.modelo.LoteXml;
/*     */ import ec.gob.sri.comprobantes.ws.aut.Autorizacion;
/*     */ import ec.gob.sri.comprobantes.ws.aut.Mensaje;
/*     */ import ec.gob.sri.comprobantes.ws.aut.RespuestaComprobante;
/*     */ import ec.gob.sri.comprobantes.ws.aut.RespuestaLote;
/*     */ import java.io.Writer;
/*     */ 
/*     */ public class XStreamUtil
/*     */ {
/*     */   public static XStream getLoteXStream()
/*     */   {
/*  35 */     XStream xstream = new XStream(new XppDriver()
/*     */     {
/*     */       public HierarchicalStreamWriter createWriter(Writer out)
/*     */       {
/*  40 */         return new PrettyPrintWriter(out)
/*     */         {
/*     */           protected void writeText(QuickWriter writer, String text)
/*     */           {
/*  44 */             writer.write(text);
/*     */           }
/*     */         };
/*     */       }
/*     */     });
/*  50 */     xstream.alias("lote", LoteXml.class);
/*  51 */     xstream.alias("comprobante", ComprobanteXml.class);
/*     */ 
/*  54 */     xstream.registerConverter(new ComprobanteXmlConverter());
/*     */ 
/*  56 */     return xstream;
/*     */   }
/*     */ 
/*     */   public static XStream getRespuestaXStream()
/*     */   {
/*  66 */     XStream xstream = new XStream(new XppDriver()
/*     */     {
/*     */       public HierarchicalStreamWriter createWriter(Writer out)
/*     */       {
/*  71 */         return new PrettyPrintWriter(out)
/*     */         {
/*     */           protected void writeText(QuickWriter writer, String text)
/*     */           {
/*  75 */             writer.write(text);
/*     */           }
/*     */         };
/*     */       }
/*     */     });
/*  81 */     xstream.alias("respuesta", RespuestaComprobante.class);
/*  82 */     xstream.alias("autorizacion", Autorizacion.class);
/*  83 */     xstream.alias("fechaAutorizacion", XMLGregorianCalendarImpl.class);
/*  84 */     xstream.alias("mensaje", Mensaje.class);
/*  85 */     xstream.registerConverter(new RespuestaDateConverter());
/*     */ 
/*  87 */     return xstream;
/*     */   }
/*     */ 
/*     */   public static XStream getRespuestaLoteXStream()
/*     */   {
/*  97 */     XStream xstream = new XStream(new XppDriver()
/*     */     {
/*     */       public HierarchicalStreamWriter createWriter(Writer out)
/*     */       {
/* 102 */         return new PrettyPrintWriter(out)
/*     */         {
/*     */           protected void writeText(QuickWriter writer, String text)
/*     */           {
/* 106 */             writer.write(text);
/*     */           }
/*     */         };
/*     */       }
/*     */     });
/* 112 */     xstream.alias("respuesta", RespuestaLote.class);
/* 113 */     xstream.alias("autorizacion", Autorizacion.class);
/* 114 */     xstream.alias("fechaAutorizacion", XMLGregorianCalendarImpl.class);
/* 115 */     xstream.alias("mensaje", Mensaje.class);
/* 116 */     xstream.registerConverter(new RespuestaDateConverter());
/*     */ 
/* 118 */     return xstream;
/*     */   }
/*     */ }

